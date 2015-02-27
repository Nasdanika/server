package org.nasdanika.cdo.web.routes;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOPackageInfo;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.cdo.web.routes.CDOWebUtil.DataDefinitionFilter;
import org.nasdanika.core.Context;
import org.nasdanika.core.Deletable;
import org.nasdanika.core.TransactionContext;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.ServerException;
import org.nasdanika.web.ValueAction;
import org.nasdanika.web.WebContext;

public class CDOViewRoute implements Route {

	private static final String OPERATION_KEY = "operation";
	private static final CDOViewSessionModuleGenerator cdoViewSessionModuleGenerator = new CDOViewSessionModuleGenerator();
	
	private static class DeltaEntry {
				
		private static final String NEW_POS_KEY = "newPos";

		private static final String POS_KEY = "pos";

		WebContext context;
		
		CDOObject target;
		
		boolean isSameVersion;
		
		JSONObject inDelta;
		
		String path;

		/**
		 * @return Validation result.
		 * @throws Exception
		 */
		public Map<?,?> applyInDelta() throws Exception {
			EClass targetClass = target.eClass();
			if (!isSameVersion && targetClass.getEAnnotation(CDOWebUtil.ANNOTATION_STRICT)!=null) {
				throw new ServerException("Object was modified, versions don't match: "+path);
			}
			CDOLock writeLock = target.cdoView()==null ? null : target.cdoWriteLock();
			if (writeLock == null || writeLock.tryLock(15, TimeUnit.SECONDS)) {
				try {	
					@SuppressWarnings("unchecked")
					Iterator<String> dit = inDelta.keys();
					while (dit.hasNext()) {
						String dk = dit.next();
						if (!CDOWebUtil.VERSION_KEY.equals(dk)) {
							EStructuralFeature feature = targetClass.getEStructuralFeature(dk);
							if (feature == null) {
								throw new ServerException("Feature "+dk+" not found in "+targetClass.getName()+" at "+path);
							}
							if (feature instanceof EAttribute) {
								applyAttributeInDelta(inDelta.getJSONObject(dk), (EAttribute) feature);
							} else {
								applyReferenceInDelta(inDelta.get(dk), (EReference) feature);							
							}
						}
					}
				} finally {
					if (writeLock!=null) {
						writeLock.unlock();
					}
				}
				return CDOWebUtil.validateEObject(context, target);
			}
			
			throw new ServerException("Unable to obtain write lock for "+path);
		}

		@SuppressWarnings("unchecked")
		private void applyAttributeInDelta(JSONObject jsonObject, EAttribute attr) throws Exception {
			if (!attr.isChangeable() || attr.getEAnnotation(CDOWebUtil.ANNOTATION_PRIVATE)!=null) {
				throw new ServerException(HttpServletResponse.SC_NOT_FOUND);
			}
			if (!context.authorize(target, "write", attr.getName(), null)) {
				throw new ServerException(HttpServletResponse.SC_FORBIDDEN);
			}
			EClass targetClass = target.eClass();
			Class<?> attrType = attr.getEAttributeType().getInstanceClass();
			if (!isSameVersion && targetClass.getEAnnotation(CDOWebUtil.ANNOTATION_LENIENT)==null) {				
				// Object was modified, strict policy, validate value
				String concurrentModificationMessage = "Concurrent modification of attribute "+attr.getName()+" at "+path;
				Object attrValue = target.eGet(attr);
				if (jsonObject.has(CDOWebUtil.INITIAL_VALUE_KEY)) {
					if (attr.isMany()) {
						if (!Arrays.equals(CDOWebUtil.get(context, jsonObject.getJSONArray(CDOWebUtil.INITIAL_VALUE_KEY), attrType), ((List<Object>) attrValue).toArray())) {
							throw new ServerException(concurrentModificationMessage);
						}
					} else {
						if (!CDOWebUtil.get(context, jsonObject, CDOWebUtil.INITIAL_VALUE_KEY, attrType).equals(attrValue)) {
							throw new ServerException(concurrentModificationMessage);
						}						
					}					
				} else {
					Object defaultValue = attr.getDefaultValue();
					if (defaultValue==null) {
						if (attrValue!=null) {
							throw new ServerException(concurrentModificationMessage);
						}
					} else {
						if (!defaultValue.equals(attrValue)) {
							throw new ServerException(concurrentModificationMessage);
						}
					}
				}
			}
			
			target.eSet(attr, CDOWebUtil.get(context, jsonObject, CDOWebUtil.VALUE_KEY, attrType));			
		}

		private void applyReferenceInDelta(Object object, EReference ref) throws Exception {
			if (!ref.isChangeable() || ref.getEAnnotation(CDOWebUtil.ANNOTATION_PRIVATE)!=null) {
				throw new ServerException(HttpServletResponse.SC_NOT_FOUND);
			}
			if (!context.authorize(target, "write", ref.getName(), null)) {
				throw new ServerException(HttpServletResponse.SC_FORBIDDEN);
			}
			EClass targetClass = target.eClass();
			Object refValue = target.eGet(ref);
			String concurrentModificationMessage = "Concurrent modification of reference "+ref.getName()+" at "+path;
			if (ref.isMany()) {
				@SuppressWarnings("unchecked")
				EList<CDOObject> refList = (EList<CDOObject>) refValue;
				JSONArray jsonArray = (JSONArray) object;
				if (ref.getEAnnotation(CDOWebUtil.ANNOTATION_LENIENT)==null) {
					//EList<CDOObject> refListCopy = new BasicEList<>(refList); // have to operate on a copy to avoid violation of constraints.
					for (int i=0, j=0; i<jsonArray.length(); ++i, ++j) {
						Object el = jsonArray.get(i);
						if (el instanceof String) {
							// No change - path
							if (refList.size()<=j || !((String) el).equals(context.getObjectPath(refList.get(j)))) {
								throw new ServerException(concurrentModificationMessage);								
							}
						} else {
							JSONObject joel = (JSONObject) el;
							if (joel.has(CDOWebUtil.INITIAL_VALUE_KEY)) {
								if (refList.size()<=j || !joel.getString(CDOWebUtil.INITIAL_VALUE_KEY).equals(context.getObjectPath(refList.get(j)))) {
									throw new ServerException(concurrentModificationMessage);								
								}
								if (joel.has(CDOWebUtil.VALUE_KEY)) {
									Object val = joel.get(CDOWebUtil.VALUE_KEY);
									if (val instanceof String) {
										CDOObject ve = CDOWebUtil.resolvePath(context, (String) val);
										if (ve==null) {
											throw new ServerException("Invalid path: "+val, HttpServletResponse.SC_NOT_FOUND);
										}
										refList.set(j, ve);										
									} else {
										refList.set(j, CDOWebUtil.create(context, (JSONObject) val, ref.getEReferenceType()));
									}
								} else {
									refList.remove(j--);
								}
							} else {
								if (joel.has(CDOWebUtil.VALUE_KEY)) {
									Object val = joel.get(CDOWebUtil.VALUE_KEY);
									if (val instanceof String) {
										CDOObject ve = CDOWebUtil.resolvePath(context, (String) val);
										if (ve==null) {
											throw new ServerException("Invalid path: "+val, HttpServletResponse.SC_NOT_FOUND);
										}
										refList.add(ve);										
									} else {
										refList.add(CDOWebUtil.create(context, (JSONObject) val, ref.getEReferenceType()));
									}
								} else {
									throw new ServerException("Invalid delta entry: "+joel, HttpServletResponse.SC_BAD_REQUEST);
								}								
							}
						}
					}
					//refList.clear();
					//refList.addAll(refListCopy);
				} else {
					for (int i=0; i<jsonArray.length(); ++i) {
						JSONObject command = jsonArray.getJSONObject(i);
						switch (command.getString("type")) {
						case "add": {
							Object val = command.get(CDOWebUtil.VALUE_KEY);
							if (val instanceof String) {
								CDOObject el = CDOWebUtil.resolvePath(context, (String) val);
								if (el==null) {
									throw new ServerException("Invalid path: "+val, HttpServletResponse.SC_NOT_FOUND);
								}
								if (command.has(POS_KEY)) {
									refList.add(command.getInt(POS_KEY), el);
								} else {
									refList.add(el);
								}								
							} else {
								if (command.has(POS_KEY)) {
									refList.add(command.getInt(POS_KEY), CDOWebUtil.create(context, (JSONObject) val, (EClass) ref.getEType()));
								} else {
									refList.add(CDOWebUtil.create(context, (JSONObject) val, (EClass) ref.getEType()));
								}
							}
							break;
						}
						case "set": {
							if (refList.size()<=command.getInt(POS_KEY)) {
								throw new ServerException(concurrentModificationMessage);
							}
							if (!command.getString(CDOWebUtil.INITIAL_VALUE_KEY).equals(context.getObjectPath(refList.get(command.getInt(POS_KEY))))) {
								throw new ServerException(concurrentModificationMessage);								
							}
							Object val = command.get(CDOWebUtil.VALUE_KEY);
							if (val instanceof String) {
								CDOObject el = CDOWebUtil.resolvePath(context, (String) val);
								if (el==null) {
									throw new ServerException("Invalid path: "+val, HttpServletResponse.SC_NOT_FOUND);
								}
								refList.set(command.getInt(POS_KEY), el);
							} else {
								refList.set(command.getInt(POS_KEY), CDOWebUtil.create(context, (JSONObject) val, (EClass) ref.getEType()));
							}
							break;
						}	
						case "move":
							if (refList.size()<=command.getInt(POS_KEY) || refList.size()<=command.getInt(NEW_POS_KEY)) {
								throw new ServerException(concurrentModificationMessage);
							}
							if (!command.getString(CDOWebUtil.INITIAL_VALUE_KEY).equals(context.getObjectPath(refList.get(command.getInt(POS_KEY))))) {
								throw new ServerException(concurrentModificationMessage);								
							}
							refList.move(command.getInt(NEW_POS_KEY), command.getInt(POS_KEY));
							break;
						case "remove":
							if (refList.size()<=command.getInt(POS_KEY)) {
								throw new ServerException(concurrentModificationMessage);
							}
							if (!command.getString(CDOWebUtil.INITIAL_VALUE_KEY).equals(context.getObjectPath(refList.get(command.getInt(POS_KEY))))) {
								throw new ServerException(concurrentModificationMessage);								
							}
							refList.remove(command.getInt(POS_KEY));
							break;						
						}
					}					
				}
			} else {
				if (targetClass.getEAnnotation(CDOWebUtil.ANNOTATION_LENIENT)==null) {				
					// Object was modified, strict policy, validate value
					JSONObject jsonObject = (JSONObject) object;
					if (jsonObject.has(CDOWebUtil.INITIAL_VALUE_KEY)) {
						JSONObject jiv = jsonObject.getJSONObject(CDOWebUtil.INITIAL_VALUE_KEY);
						if (jiv.has(CDOWebUtil.PATH_KEY)) {
							if (refValue==null || !jiv.getString(CDOWebUtil.PATH_KEY).equals(context.getObjectPath(refValue))) {
								throw new ServerException(concurrentModificationMessage);
							}
						} else if (refValue!=null) {
							throw new ServerException(concurrentModificationMessage);
						}
					} else {
						Object defaultValue = ref.getDefaultValue();
						if (defaultValue==null) {
							if (refValue!=null) {
								throw new ServerException(concurrentModificationMessage);
							}
						} else {
							if (!defaultValue.equals(refValue)) {
								throw new ServerException(concurrentModificationMessage);
							}
						}
					}
				}
			
				target.eSet(ref, CDOWebUtil.resolveOrCreate(context, (JSONObject) object, ref.getEReferenceType()));
			}
		}

		/**
		 * Computes deltas to send to the client and puts them to outDeltas under <code>path</code> key.
		 * @param value
		 * @param outDeltas
		 * @throws Exception 
		 */
		public void outDelta(final CDORevisionDelta cdoDelta, JSONObject outDeltas) throws Exception {
			if (target==null || target.cdoView()==null) {
				outDeltas.put(path, "detached");				
			} else if (isSameVersion) {
				if (cdoDelta!=null) {
					DataDefinitionFilter filter = new DataDefinitionFilter() {
						
						@Override
						public boolean accept(
								WebContext context, 
								CDOObject cdoObject,
								EStructuralFeature feature, 
								JSONObject definition) throws Exception {
							
							CDOFeatureDelta featureDelta = cdoDelta.getFeatureDelta(feature);
							if (featureDelta == null) {
								return false;
							}
							if (feature instanceof EAttribute) {
								if (!inDelta.has(feature.getName())) {
									return true;
								}
								JSONObject finDelta = inDelta.getJSONObject(feature.getName());
								return !finDelta.has(CDOWebUtil.VALUE_KEY) || !definition.has(CDOWebUtil.INITIAL_VALUE_KEY) || !finDelta.get(CDOWebUtil.VALUE_KEY).equals(definition.get(CDOWebUtil.INITIAL_VALUE_KEY));
							}
							
							return true; // Always pass modified references.
						}
					};
					outDeltas.put(path, CDOWebUtil.generateDataDefinitions(context, target, filter));				
				}
			} else {
				outDeltas.put(path, CDOWebUtil.generateDataDefinitions(context, target, null));				
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Action execute(final WebContext webContext) throws Exception {
		CDOView view = (CDOView) webContext.getTarget();
		
		if (webContext.getPath().length==1) { 
			if (RequestMethod.GET.equals(webContext.getMethod())) {
				if (webContext.authorize(view, "read", null, null)) {
					int dotIdx = webContext.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : webContext.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = webContext.getExtensionAction(view, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			return Action.NOT_FOUND;
		} 
		
		// Router path
		webContext.addPathTraceEntry("#router/main"+webContext.getObjectPath(view)+".html", "CDO View");
		
		if ("packages".equals(webContext.getPath()[1])) {
			String nsURI = (String) webContext.getSessionStore().get(NasdanikaCDOUtil.stripExtension(webContext.getPath()[2]));
			EPackage ePackage = view.getSession().getPackageRegistry().getEPackage(nsURI);
			if (ePackage == null) {
				// put packages to store
				for (CDOPackageInfo pi: view.getSession().getPackageRegistry().getPackageInfos()) {
					webContext.getSessionStore().put(pi.getEPackage().getNsURI());
				}
				nsURI = (String) webContext.getSessionStore().get(NasdanikaCDOUtil.stripExtension(webContext.getPath()[2]));
				ePackage = view.getSession().getPackageRegistry().getEPackage(nsURI);
				if (ePackage == null) {
					return Action.NOT_FOUND;
				}
			}
			Action prAction = webContext.getAction(ePackage, 2);
			return prAction==null ? Action.NOT_FOUND : prAction;
		}
		
		if ("elements".equals(webContext.getPath()[1])) {
			for (CDOResourceNode e: view.getElements()) {
				if (e.getName().equals(NasdanikaCDOUtil.stripExtension(webContext.getPath()[2]))) {
					final Action eAction = webContext.getAction(e, 2);
					return eAction==null ? Action.NOT_FOUND : eAction;
				}
			}	
			
			// TODO - create resources.
		} else if ("objects".equals(webContext.getPath()[1])) {
			CDOID id = CDOIDUtil.read(NasdanikaCDOUtil.stripExtension(webContext.getPath()[2]));
			CDOObject obj = view.getObject(id);
			return obj==null ? Action.NOT_FOUND : webContext.getAction(obj, 2);
		}
		
		if (webContext.getPath().length==2) {
			HttpContext httpContext = (HttpContext) webContext;
			if ("session.js".equals(webContext.getPath()[1])) {
				if (RequestMethod.GET.equals(webContext.getMethod())) {
//					if (webContext.authorize(view, "read", null, null)) {
						httpContext.getResponse().setContentType("application/javascript");
						return new ValueAction(cdoViewSessionModuleGenerator.generate(webContext, view));
//					} 
//					return Action.FORBIDDEN;
				}
			} else if ("session".equals(webContext.getPath()[1])) {
				if (RequestMethod.PUT.equals(webContext.getMethod())) {
//					if (webContext.authorize(view, "write", null, null)) {
						JSONObject jsonRequest;
						try (BufferedReader reader = httpContext.getRequest().getReader()) {
							jsonRequest = new JSONObject(new JSONTokener(reader));
						}	
						
						Map<String, Map<?,?>> objectValidationResults = new HashMap<>();
						final Map<CDOID, DeltaEntry> sessionObjects = new HashMap<>();
						String targetPath = jsonRequest.has("target") ? jsonRequest.getString("target") : null;
						CDOObject invocationTarget = null;
						if (jsonRequest.has("deltas")) {
							JSONObject deltas = jsonRequest.getJSONObject("deltas");
							Iterator<String> kit = deltas.keys();
							while (kit.hasNext()) {
								String path = kit.next();
								DeltaEntry deltaEntry = new DeltaEntry();
								deltaEntry.context = webContext;
								deltaEntry.path = path;
								deltaEntry.inDelta = deltas.getJSONObject(path);
								try {
									CDOObject cdoObject = CDOWebUtil.resolvePath(webContext, path);
									if (targetPath!=null && targetPath.equals(path)) {
										invocationTarget = cdoObject;
									}
									deltaEntry.target = cdoObject;
									
									CDORevision cdoRevision = cdoObject.cdoRevision();
									deltaEntry.isSameVersion = cdoRevision!=null 
											&& deltaEntry.inDelta.has("$version") 
											&& cdoRevision.getVersion() == deltaEntry.inDelta.getInt("$version");
									
									sessionObjects.put(cdoObject.cdoID(), deltaEntry);
									Map<?, ?> vr = deltaEntry.applyInDelta();
									if (vr!=null) {
										objectValidationResults.put(path, vr);
									}
								} catch (ObjectNotFoundException onfe) {
									// Not found - maybe was deleted by a different transaction
									sessionObjects.put(onfe.getID(), deltaEntry);
								}
							}
						}
						
						final Object[] opResult = { null };
						final JSONObject response = new JSONObject();
						if (jsonRequest.has(OPERATION_KEY)) {
							if (invocationTarget==null) {
								throw new ServerException("Invocation target not in session: "+targetPath);
							}
							String opName = jsonRequest.getString(OPERATION_KEY);
							JSONArray opArgs = jsonRequest.getJSONArray("args");
							if ("$delete".equals(opName)) {
								if (webContext.authorize(invocationTarget, "write", null, null)) {
									if (invocationTarget instanceof Deletable) {
										((Deletable<Context>) invocationTarget).delete(webContext);
									} else {
										EcoreUtil.delete(invocationTarget, true);
									}
								} else {
									throw new ServerException("Can't delete: "+targetPath, HttpServletResponse.SC_FORBIDDEN);
								}
							} else {
								EOperation candidate = null;
								for (EOperation op: invocationTarget.eClass().getEAllOperations()) {
									if (op.getEAnnotation(CDOWebUtil.ANNOTATION_PRIVATE)==null 
											&& op.getName().equals(opName) 
											&& op.getEParameters().size()==opArgs.length()+1 // No type matching, first parameter is context
											&& webContext.authorize(invocationTarget, CDOWebUtil.getEOperationPermission(op), opName, null)) { 
										candidate = op; 
										break;
									}
								}
								
								if (candidate == null) {
									throw new ServerException("No such authorized operation "+opName+" of "+targetPath, HttpServletResponse.SC_NOT_FOUND);
								}
								
								EList<EParameter> params = candidate.getEParameters();
								Class<?>[] pTypes = new Class[params.size()];
								for (int i=0; i<pTypes.length; ++i) {
									EParameter param = params.get(i);
									pTypes[i] = param.getEType().getInstanceClass();
								}
								EList<Object> args = new BasicEList<>();
								args.add(webContext);
								args.addAll(CDOWebUtil.unmarshal(webContext, opArgs, pTypes, invocationTarget.eClass()));

								Object operationValidationResult = CDOWebUtil.validateEOperation(webContext, candidate, invocationTarget, args);
								if (operationValidationResult!=null || !objectValidationResults.isEmpty()) {
									Map<String,Object> vr = new HashMap<>();
									if (!objectValidationResults.isEmpty()) {
										vr.put("objects", objectValidationResults);
									}
									if (operationValidationResult!=null) {
										vr.put("operation", operationValidationResult);
									}
									response.put("validationResults", CDOWebUtil.marshal(webContext, vr));
									if (webContext instanceof TransactionContext) {
										((TransactionContext) webContext).setRollbackOnly();
									}
								} else {
									opResult[0] = invocationTarget.eInvoke(candidate, args);
								}
							}
						} else if (!objectValidationResults.isEmpty()) {
							Map<String,Object> vr = new HashMap<>();
							vr.put("objects", objectValidationResults);
							response.put("validationResults", CDOWebUtil.marshal(webContext, vr));
							if (webContext instanceof TransactionContext) {
								((TransactionContext) webContext).setRollbackOnly();
							}
						}
												
						if (view instanceof CDOTransaction) {
							((CDOTransaction) view).addTransactionHandler(new CDOTransactionHandler2() {
								
								@Override
								public void rolledBackTransaction(CDOTransaction transaction) {
									// NOP
									
								}
								
								@Override
								public void committingTransaction(CDOTransaction transaction, CDOCommitContext context) {
									// NOP
									
								}
								
								@Override
								public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
									try {
										JSONObject rDeltas = new JSONObject();
										response.put("deltas", rDeltas);
										for (CDOID did: commitContext.getDetachedObjects().keySet()) {
											DeltaEntry deltaEntry = sessionObjects.remove(did);
											if (deltaEntry!=null) {												
												rDeltas.put(deltaEntry.path, "detached");
											}

										}
										for (Entry<CDOID, CDORevisionDelta> rde: commitContext.getRevisionDeltas().entrySet()) {
											DeltaEntry sessionObjectDeltaEntry = sessionObjects.remove(rde.getKey());
											if (sessionObjectDeltaEntry!=null) {
												sessionObjectDeltaEntry.outDelta(rde.getValue(), rDeltas);
											}
										}
										for (DeltaEntry sde: sessionObjects.values()) {
											sde.outDelta(null, rDeltas);
										}
										
										response.put("result", CDOWebUtil.marshal(webContext, opResult[0])); //Marshaling here so CDOID's are not transient for new objects.

									} catch (Exception e) {
										e.printStackTrace();
										try {
											response.put("error", e.toString());
										} catch (JSONException ex) {
											ex.printStackTrace();
										}
									}
									
								}
							});
						}
						httpContext.getResponse().setContentType("text/json");
						return new ValueAction(response);
//					} 
//					return Action.FORBIDDEN;
				}	
			}
			return Action.NOT_FOUND;
		}
		
		return Action.NOT_FOUND;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
		
	}

}
