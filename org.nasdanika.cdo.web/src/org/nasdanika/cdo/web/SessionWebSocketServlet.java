package org.nasdanika.cdo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.CDOTransactionContextProvider;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.CDOViewContextSubject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.web.routes.CDOWebUtil;
import org.nasdanika.cdo.web.routes.CDOWebUtil.DataDefinitionFilter;
import org.nasdanika.core.Context;
import org.nasdanika.core.Deletable;
import org.nasdanika.web.ServerException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Allows to push progress notifications to the client side session.
 * Notifications are sent as text messages.
 * @author Pavel Vlasov
 * 
 */
@SuppressWarnings("serial")
public class SessionWebSocketServlet<CR> extends WebSocketServlet {
	
	private ServiceTracker<CDOTransactionContextProvider<CR>, CDOTransactionContextProvider<CR>> cdoTransactionContextProviderServiceTracker;
	private String viewPath;
	private BundleContext bundleContext;
	
	public interface WebSocketContext<CR> extends CDOTransactionContext<CR> {
		
		/**
		 * Sends a notification to the client side.
		 * @param progressNotification
		 */
		void onProgress(Object progressNotification) throws Exception;

		String getViewPath();

		String getObjectPath(CDOObject cdoObject);
		
	}		

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		viewPath = config.getInitParameter("view-path");
		
		bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		String serviceFilter = config.getInitParameter("cdo-transaction-context-provider-service-filter");
		
		// TODO - bundle is still null???
		if (serviceFilter==null || serviceFilter.trim().length()==0) {
			cdoTransactionContextProviderServiceTracker = new ServiceTracker<>(bundleContext, CDOTransactionContextProvider.class.getName(), null);
		} else {
			String theFilter = "(&(" + Constants.OBJECTCLASS + "=" + CDOTransactionContextProvider.class.getName() + ")"+serviceFilter+")";
			try {
				cdoTransactionContextProviderServiceTracker = new ServiceTracker<>(bundleContext, bundleContext.createFilter(theFilter), null);
			} catch (InvalidSyntaxException e) {
				throw new ServletException("Invalid service filter ("+e+"): "+serviceFilter, e);
			}
		}
		cdoTransactionContextProviderServiceTracker.open();
	}
	
	@Override
	public void destroy() {
		if (cdoTransactionContextProviderServiceTracker!=null) {
			cdoTransactionContextProviderServiceTracker.close();
		}
		super.destroy();
	}

			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		getServletContext().getNamedDispatcher("default").forward(request,response);    
	}

    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
    	try {
			return new SessionWebSocket(request, protocol);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
	
	private static final String PRINCIPAL_ID_ATTRIBUTE_NAME = Principal.class.getName()+":id";
	
	private static final String OPERATION_KEY = "operation";
	private static final String ID_KEY = "id";
	
	private static class DeltaEntry<CR> {
				
		private static final String NEW_POS_KEY = "newPos";

		private static final String POS_KEY = "pos";

		WebSocketContext<CR> context;
		
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
				throw new ServerException("Attribute not found: "+attr.getName());
			}
			if (!context.authorize(target, "write", attr.getName(), null)) {
				throw new ServerException("Read only attribute "+attr.getName());
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
				throw new ServerException("Reference not found: "+ref.getName());
			}
			if (!context.authorize(target, "write", ref.getName(), null)) {
				throw new ServerException("Read only reference: "+ref.getName());
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
											throw new ServerException("Invalid path: "+val);
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
											throw new ServerException("Invalid path: "+val);
										}
										refList.add(ve);										
									} else {
										refList.add(CDOWebUtil.create(context, (JSONObject) val, ref.getEReferenceType()));
									}
								} else {
									throw new ServerException("Invalid delta entry: "+joel);
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
									throw new ServerException("Invalid path: "+val);
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
									throw new ServerException("Invalid path: "+val);
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
							if (refValue==null || !jiv.getString(CDOWebUtil.PATH_KEY).equals(context.getObjectPath((CDOObject) refValue))) {
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
								Context context, 
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
    
	private class SessionWebSocket implements WebSocket.OnTextMessage {
		
		private Connection connection;
		private CDOID principalID; 

		public SessionWebSocket(HttpServletRequest request, String protocol) {
			Object idAttr = request.getAttribute(PRINCIPAL_ID_ATTRIBUTE_NAME);
			if (idAttr instanceof CDOID) {
				principalID = (CDOID) idAttr;
			} 
		}

		@Override
		public void onOpen(Connection connection) {
			this.connection = connection;
		}

		@Override
		public void onClose(int closeCode, String message) {
			// NOP
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public void onMessage(String message) {
			try {
				JSONObject jsonRequest = new JSONObject(message);
				final Object requestId = jsonRequest.get(ID_KEY);
				CDOTransactionContextProvider<CR> cdoTransactionContextProvider = cdoTransactionContextProviderServiceTracker.getService();
				if (cdoTransactionContextProvider == null) {
					reject(requestId, "Transaction provided is not available");
				} else {															
					CDOViewContextSubject<CDOTransaction, CR> subject = new CDOViewContextSubject<CDOTransaction, CR>() {

						@Override
						public Principal getPrincipal(CDOViewContext<CDOTransaction, CR> context) {
							return principalID==null ? null : (Principal) context.getView().getObject(principalID);
						}

						@Override
						public void setPrincipal(CDOViewContext<CDOTransaction, CR> context, Principal principal) {
							if (principal==null) {
								principalID = null;
							} else {
								principalID = principal.cdoID();
							}							
						}
						
					};
					try (final CDOTransactionContext<CR> cdoTransactionContext = cdoTransactionContextProvider.createContext(subject)) {	
						final WebSocketContext<CR> webSocketContext = new WebSocketContext<CR>() {

							@Override
							public void setRollbackOnly() {
								cdoTransactionContext.setRollbackOnly();							
							}

							@Override
							public boolean isRollbackOnly() {
								return cdoTransactionContext.isRollbackOnly();
							}

							@Override
							public boolean authorize(Object target,	String action, String qualifier, Map<String, Object> environment) throws Exception {
								return cdoTransactionContext.authorize(target, action, qualifier, environment);
							}

							@Override
							public <T> T convert(Object source,	Class<T> targetType) throws Exception {
								return cdoTransactionContext.convert(source, targetType);
							}

							@Override
							public void close() throws Exception {
								cdoTransactionContext.close();								
							}

							@Override
							public <T> T adapt(Class<T> targetType) throws Exception {
								return cdoTransactionContext.adapt(targetType);
							}

							@Override
							public CDOTransaction getView() {
								return cdoTransactionContext.getView();
							}

							@Override
							public Principal getPrincipal() throws Exception {
								return cdoTransactionContext.getPrincipal();
							}

							@Override
							public ProtectionDomain<CR> getProtectionDomain() {
								return cdoTransactionContext.getProtectionDomain();
							}

							@Override
							public Principal authenticate(CR credentials) throws Exception {
								return cdoTransactionContext.authenticate(credentials);
							}

							@Override
							public void onProgress(Object progressNotification) throws Exception {
								JSONObject jo = new JSONObject();
								jo.put("progressNotification", progressNotification);
								connection.sendMessage(jo.toString());								
							}

							@Override
							public String getViewPath() {
								return viewPath;
							}

							@Override
							public String getObjectPath(CDOObject cdoObject) {
								if (cdoObject.cdoView()!=getView()) {
									throw new IllegalArgumentException("Object does not belong to the view: "+cdoObject);
								}
								StringBuilder builder = new StringBuilder(getViewPath()).append("/objects/");
								CDOIDUtil.write(builder, cdoObject.cdoID());
								return builder.toString();
							}
							
						};					
						
						Map<String, Map<?,?>> objectValidationResults = new HashMap<>();
						final Map<CDOID, DeltaEntry<CR>> sessionObjects = new HashMap<>();
						String targetPath = jsonRequest.has("target") ? jsonRequest.getString("target") : null;
						CDOObject invocationTarget = null;
						if (jsonRequest.has("deltas")) {
							JSONObject deltas = jsonRequest.getJSONObject("deltas");
							Iterator<String> kit = deltas.keys();
							while (kit.hasNext()) {
								String path = kit.next();
								DeltaEntry<CR> deltaEntry = new DeltaEntry<CR>();
								deltaEntry.context = webSocketContext;
								deltaEntry.path = path;
								deltaEntry.inDelta = deltas.getJSONObject(path);
								try {
									CDOObject cdoObject = CDOWebUtil.resolvePath(webSocketContext, path);
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
						response.put(ID_KEY, requestId);
						
						webSocketContext.getView().addTransactionHandler(new CDOTransactionHandler2() {
							
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
										DeltaEntry<CR> deltaEntry = sessionObjects.remove(did);
										if (deltaEntry!=null) {												
											rDeltas.put(deltaEntry.path, "detached");
										}
						
									}
									for (Entry<CDOID, CDORevisionDelta> rde: commitContext.getRevisionDeltas().entrySet()) {
										DeltaEntry<CR> sessionObjectDeltaEntry = sessionObjects.remove(rde.getKey());
										if (sessionObjectDeltaEntry!=null) {
											sessionObjectDeltaEntry.outDelta(rde.getValue(), rDeltas);
										}
									}
									for (DeltaEntry<CR> sde: sessionObjects.values()) {
										sde.outDelta(null, rDeltas);
									}
									
									response.put("result", CDOWebUtil.marshal(webSocketContext, opResult[0])); //Marshaling here so CDOID's are not transient for new objects.
									connection.sendMessage(response.toString());
								} catch (Exception e) {
									//e.printStackTrace();
									getServletConfig().getServletContext().log("Error processing client request", e);
									reject(requestId, e.toString());
								}
								
							}
						});
						
						if (jsonRequest.has(OPERATION_KEY)) {
							if (invocationTarget==null) {
								throw new ServerException("Invocation target not in session: "+targetPath);
							}
							String opName = jsonRequest.getString(OPERATION_KEY);
							JSONArray opArgs = jsonRequest.getJSONArray("args");
							if ("$delete".equals(opName)) {
								if (webSocketContext.authorize(invocationTarget, "write", null, null)) {
									if (invocationTarget instanceof Deletable) {
										((Deletable<Context>) invocationTarget).delete(webSocketContext);
									} else {
										EcoreUtil.delete(invocationTarget, true);
									}
								} else {
									throw new ServerException("Can't delete: "+targetPath);
								}
							} else {
								for (EOperation op: invocationTarget.eClass().getEAllOperations()) {
									if (op.getEAnnotation(CDOWebUtil.ANNOTATION_PRIVATE)==null && op.getName().equals(opName)) { 
																					
										int argCount = 0;
										for (EParameter p: op.getEParameters()) {
											if (p.getEAnnotation(CDOWebUtil.ANNOTATION_CONTEXT_PARAMETER)==null && p.getEAnnotation(CDOWebUtil.ANNOTATION_SERVICE_PARAMETER)==null) {
												++argCount;
											}
										}
										
										if (argCount==opArgs.length()) { // No type matching - conversion	
											EList<EParameter> params = op.getEParameters();
											List<Class<?>> pTypes = new ArrayList<Class<?>>();
											for (EParameter p: params) {
												if (p.getEAnnotation(CDOWebUtil.ANNOTATION_CONTEXT_PARAMETER)==null && p.getEAnnotation(CDOWebUtil.ANNOTATION_SERVICE_PARAMETER)==null) {
													pTypes.add(p.getEType().getInstanceClass());										
												}
											}
											Map<String,Object> argMap = new HashMap<>();
											EList<?> clientArgs = CDOWebUtil.unmarshal(webSocketContext, opArgs, pTypes, invocationTarget.eClass());
											int caIdx = 0;
											for (EParameter p: params) {
												if (p.getEAnnotation(CDOWebUtil.ANNOTATION_CONTEXT_PARAMETER)==null && p.getEAnnotation(CDOWebUtil.ANNOTATION_SERVICE_PARAMETER)==null) {
													argMap.put(p.getName(), clientArgs.get(caIdx++));										
												}
											}
											
											Map<String, Object> env = new HashMap<>();
											env.put("arguments", argMap);											
											if (webSocketContext.authorize(invocationTarget, CDOWebUtil.getEOperationPermission(op), opName, env)) {											
												List<ServiceReference<?>> toUnget = new ArrayList<>();
												caIdx = 0;
												EList<Object> args = new BasicEList<>();
												for (EParameter p: params) {
													if (p.getEAnnotation(CDOWebUtil.ANNOTATION_CONTEXT_PARAMETER)!=null) {
														args.add(webSocketContext.adapt(p.getEType().getInstanceClass()));
													} else if (p.getEAnnotation(CDOWebUtil.ANNOTATION_SERVICE_PARAMETER)!=null) {
														String serviceFilter = p.getEAnnotation(CDOWebUtil.ANNOTATION_SERVICE_PARAMETER).getDetails().get("filter");
														for (ServiceReference<?> ref: bundleContext.getServiceReferences(p.getEType().getInstanceClass(), serviceFilter)) {
															Object service = bundleContext.getService(ref);
															if (service!=null) {
																args.add(service);
																toUnget.add(ref);
																break;
															}
														}
													} else {
														args.add(clientArgs.get(caIdx++));										
													}
												}

												try {
													Object operationValidationResult = CDOWebUtil.validateEOperation(webSocketContext, op, invocationTarget, args);
													if (operationValidationResult!=null || !objectValidationResults.isEmpty()) {
														Map<String,Object> vr = new HashMap<>();
														if (!objectValidationResults.isEmpty()) {
															vr.put("objects", objectValidationResults);
														}
														if (operationValidationResult!=null) {
															vr.put("operation", operationValidationResult);
														}
														response.put("validationResults", CDOWebUtil.marshal(webSocketContext, vr));
														webSocketContext.setRollbackOnly();
													} else {
														opResult[0] = invocationTarget.eInvoke(op, args);
													}
												} finally {
													for (ServiceReference<?> sr: toUnget) {
														bundleContext.ungetService(sr);
													}													
												}
												return;
											}
										}
									}
								}								
								throw new ServerException("No such operation "+opName+" of "+targetPath);								
							}
						} else if (!objectValidationResults.isEmpty()) {
							Map<String,Object> vr = new HashMap<>();
							vr.put("objects", objectValidationResults);
							response.put("validationResults", CDOWebUtil.marshal(webSocketContext, vr));
							webSocketContext.setRollbackOnly();
						}
					} catch (Exception e) {												
						e.printStackTrace();
						reject(requestId, "Server error: "+e);
					}
				}
			} catch (JSONException e) {
				getServletConfig().getServletContext().log("Bad request "+message, e);
			}
		}		
		
		private void reject(Object id, String reason) {
			try {
				JSONObject jo = new JSONObject();
				jo.put(ID_KEY, id);
				jo.put("rejectionReason", reason);
				connection.sendMessage(jo.toString());
			} catch (Exception e) {
				getServletConfig().getServletContext().log("Failed to send rejection reason", e);
				//e.printStackTrace();
			}
		}
	}
}



