package org.nasdanika.cdo.web.objectpathresolvers;

import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.nasdanika.core.Context;
import org.nasdanika.web.ObjectPathResolver;

/**
 * Resolves EObject path relative to its resource using URI fragment.
 * @author Pavel
 *
 */
public class EObjectPathResolver implements ObjectPathResolver<EObject> {

	@Override
	public String resolve(EObject obj, ObjectPathResolver<Object> master, Context context) throws Exception {
		if (obj instanceof CDOObject) {
			CDOObject cdoObj = (CDOObject) obj;
			CDOView view = cdoObj.cdoView();
			if (view!=null && cdoObj.cdoID()!=null && !cdoObj.cdoID().isTemporary()) {				
				String viewPath = master.resolve(view, null, context);
				if (viewPath!=null) {
					StringBuilder builder = new StringBuilder(viewPath);
					builder.append("/objects/");
					CDOIDUtil.write(builder, cdoObj.cdoID());
					return builder.toString();
				}
			}
		}
		// Resolving by containment
		EObject container = obj.eContainer();
		EReference containmentReference = obj.eContainmentFeature();
		if (container!=null && containmentReference!=null) {
			String containerPath = master.resolve(container, master, context);
			if (containerPath!=null) {
				String ret = containerPath+"/feature/" + containmentReference.getName(); // URLEncoder.encode(containmentReference.getName(), ((HttpServletRequestContext) context).getCharacterEncoding());
				if (containmentReference.isMany()) {
					int idx = ((List<?>) container.eGet(containmentReference)).indexOf(obj);
					if (idx==-1) {
						return null;
					}
					ret+="/"+idx;
				}
				return ret;
			}			
		}
		// Location in resource content.
		Resource res = obj.eResource();
		if (res!=null) {
			String resPath = master.resolve(res, master, context);
			if (resPath!=null) {
//				String fragment = res.getURIFragment(obj);
//				if (CoreUtil.isBlank(fragment)) {
					int idx = res.getContents().indexOf(obj);
					if (idx != -1) {
						return resPath+"/"+idx;
					}
//				} else {
//					return resPath+"/"+fragment;
//				}
			}
		}
		return null;
	}

}
