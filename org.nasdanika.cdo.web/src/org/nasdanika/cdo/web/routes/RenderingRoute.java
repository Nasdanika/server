package org.nasdanika.cdo.web.routes;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.CDOTransactionHttpServletRequestContext;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.html.emf.Renderer;
import org.nasdanika.html.emf.RenderingContext;
import org.nasdanika.html.emf.RenderingException;
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
	

}
