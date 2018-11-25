package org.nasdanika.cdo.web.routes;

import java.io.File;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.net4j.util.concurrent.IRWLockManager.LockType;
import org.nasdanika.cdo.web.CDOIDCodec;
import org.nasdanika.cdo.web.CDOTransactionHttpServletRequestContext;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.html.emf.Renderer;
import org.nasdanika.html.emf.RenderingContext;
import org.nasdanika.html.emf.RenderingException;
import org.nasdanika.web.Action;
import org.nasdanika.web.HeaderParameter;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.web.TargetParameter;
import org.osgi.framework.BundleContext;


/**
 * Base class for routes which use HTML renderers to generate Web UI.
 * @author Pavel Vlasov
 *
 */
public abstract class RenderingRoute<T extends CDOObject, C extends CDOTransactionHttpServletRequestContext<?>, RC extends RenderingContext> extends EDispatchingRoute {
		
	private class RendererEntry implements Comparable<RendererEntry> {
		
		private EClass eClass;
		private Class<? extends Renderer> rendererClass;

		RendererEntry(EClass eClass, Class<? extends Renderer> rendererClass) {
			this.eClass = eClass;
			this.rendererClass = rendererClass;
		}
		
		@Override
		public int compareTo(RendererEntry otherEntry) {
			if (otherEntry == this) {
				return 0;
			}
			if (otherEntry.eClass == eClass) {
				return 0;
			}
			if (otherEntry.eClass.isSuperTypeOf(eClass)) {
				return -1; // This one is more specific - shall be ahead  
			}
			if (eClass.isSuperTypeOf(otherEntry.eClass)) {
				return 1; // The other one one is more specific - this one shall be behind  
			}
			// Name comparison 
			int cmp = eClass.getEPackage().getNsURI().compareTo(otherEntry.eClass.getEPackage().getNsURI());
			return cmp == 0 ? eClass.getName().compareTo(otherEntry.eClass.getName()) : cmp;
		}
		
		Renderer createRenderer(C context, EObject obj) throws Exception {
			RC renderingContext = createRenderingContext(context);
			if (eClass.isInstance(obj)) {
				for (Constructor<?> c: rendererClass.getConstructors()) {
					Class<?>[] pt = c.getParameterTypes();
					if (pt.length == 2 && pt[0].isInstance(obj) && pt[1].isInstance(renderingContext)) {
						return (Renderer) c.newInstance(obj, renderingContext);
					}
				}
				throw new RenderingException("Cannot construct "+rendererClass+" from "+ obj +" and "+ renderingContext);
			}
			throw new RenderingException(obj + " is not an instance of "+eClass.getName());
		}
		
	}
	
	private List<RendererEntry> renderers = new ArrayList<>();
	
	protected RenderingRoute(BundleContext bundleContext) throws Exception {
		super(bundleContext);
	}
			
	/**
	 * Registers renderer class.
	 * @param eClass
	 * @param rendererClass
	 */
	protected void registerRenderer(EClass eClass, Class<? extends Renderer> rendererClass) {
		renderers.add(new RendererEntry(eClass, rendererClass));		
		Collections.sort(renderers);
	}
	
	/**
	 * Factory method for creating renderers.
	 * @param context
	 * @param obj
	 * @return
	 */
	protected Renderer createRenderer(C context, EObject obj) {
		for (RendererEntry re: renderers) {
			if (re.eClass.isInstance(obj)) {
				try {
					return re.createRenderer(context, obj);					
				} catch (RenderingException e) {
					throw e;
				} catch (Exception e) {
					throw new RenderingException("Cannot create renderer for "+obj+": "+e, e);
				}
			}
		}
		throw new RenderingException("No renderer found for "+obj);
	}
	
	/**
	 * Creates a renderer for EClass by creating a new instance and calling createRenderer(C, EObject);
	 * @param context
	 * @param eClass
	 * @return
	 */
	protected Renderer createRenderer(C context, EClass eClass) {
		return createRenderer(context, eClass.getEPackage().getEFactoryInstance().create(eClass));
	}
	
	protected abstract RC createRenderingContext(C context);
	
	
	/**
	 * Renders object view page - single value features in a table with two columns 
	 * and "many" features in tabs. 
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(comment="Renders object view with breadcrumbs, single features in a table, edit button, and many features in tabs with add/edit/delete controls")
	public Object getIndexHtml(
			@ContextParameter C context,
			@TargetParameter T target) throws Exception {
		return "Hello "+target+" "+createRenderer(context, target);
	}
		
	/**
	 * This method can be used for data backup and/or migration between instances/versions.
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(comment = "Exports the current object to XMI")
	public void getExportXml(@ContextParameter C context, @TargetParameter T target) throws Exception {
		if (target instanceof CDOObject) {
			ResourceSet resourceSet = new ResourceSetImpl();
			CDOObject cdoTarget = (CDOObject) target;
			CDOView view = cdoTarget.cdoView();
			Set<CDOObject> toLock = Collections.singleton(cdoTarget);
			// TODO - use context locking
			view.lockObjects(toLock, LockType.READ, TimeUnit.MINUTES.toMillis(1), true);
			try {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
						org.eclipse.emf.ecore.resource.Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());
				String targetID = CDOIDCodec.INSTANCE.encode(context, cdoTarget.cdoID());
				URI sourceURI = URI.createFileURI(File.createTempFile(targetID + "-export-", ".xml").getAbsolutePath());
				org.eclipse.emf.ecore.resource.Resource resource = resourceSet.createResource(sourceURI);
				resource.getContents().add(EcoreUtil.copy(target));
				HttpServletResponse response = context.getResponse();
				response.setContentType("text/xml");
				response.setHeader("Content-Disposition", "attachment; filename=" + target.eClass().getName() + "-"	+ targetID + "-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".xml");
				resource.save(response.getOutputStream(), null);
			} finally {
				view.unlockObjects(toLock, LockType.READ, true);
			}
		}
	}
	
	public static final String REFERRER_HEADER = "referer";	
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(comment="Invalidates session")
	public Object getLogoutHtml(@ContextParameter C context, @HeaderParameter(REFERRER_HEADER) String referrer) throws Exception {
		context.getRequest().getSession().invalidate();
		if (referrer == null) {
			return "Log out successful";
		}
		context.getResponse().sendRedirect(context.getRequest().getContextPath()+"/index.html");
		return Action.NOP;
	}
	
	

}
