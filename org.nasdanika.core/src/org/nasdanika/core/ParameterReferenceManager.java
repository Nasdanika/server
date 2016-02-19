package org.nasdanika.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Base class for classes which wrap methods with {@link ServiceParameter} annotations on parameters. This class tracks references and
 * injects them into arguments.
 * @author Pavel
 *
 * @param <C>
 * @param <R>
 */
public abstract class ParameterReferenceManager implements AutoCloseable {
	
	/**
	 * Provides information about reference to be injected as method argument.   
	 * <table cellspacing="0" border="1">
	 * <tr><th>isMany</th><th>isMandatory</th><th>Cardinality</th></tr>
	 * <tr><td>&nbsp;</td><td>&nbsp;</td><td align="center">0..1</td></tr>
	 * <tr><td align="center">X</td><td>&nbsp;</td><td align="center">0..*</td></tr>
	 * <tr><td>&nbsp;</td><td align="center">X</td><td align="center">1..1</td></tr>
	 * <tr><td align="center">X</td><td align="center">X</td><td align="center">1..*</td></tr>
	 * </table>
	 * @author Pavel
	 *
	 */
	public static class ReferenceInfo {
		@Override
		public String toString() {
			return "ReferenceInfo [type=" + type + ", filter=" + filter
					+ ", isMandatory=" + isMandatory + ", isMany=" + isMany
					+ "]";
		}
		private Class<Object> type;
		private boolean isMany;
		private boolean isMandatory;
		private String filter;
		
		public ReferenceInfo(Class<Object> type, boolean isMany, boolean isMandatory, String filter) {
			super();
			this.type = type;
			this.isMany = isMany;
			this.isMandatory = isMandatory;
			this.filter = filter;
		}
		public Class<Object> getType() {
			return type;
		}
		public boolean isMany() {
			return isMany;
		}
		public boolean isMandatory() {
			return isMandatory;
		}	
		public String getFilter() {
			return filter;
		}
	}
	
	protected Method method;

	protected static class ReferenceEntry {
		
		private ReferenceInfo info;
		private ServiceTracker<Object, Object> serviceTracker;
		
		ReferenceInfo getInfo() {
			return info;
		}

		ReferenceEntry(BundleContext context, ReferenceInfo info) throws Exception {			
			this.info = info;
			if (CoreUtil.isBlank(info.getFilter())) {
				this.serviceTracker = new ServiceTracker<Object, Object>(context, info.getType(), null);				
			} else {
				String filter = "(&(" + Constants.OBJECTCLASS + "=" + info.getType().getName() + ")"+info.getFilter()+")";
				this.serviceTracker = new ServiceTracker<Object, Object>(context, context.createFilter(filter), null);
			}
			this.serviceTracker.open();
		}

		ServiceTracker<Object, Object> getServiceTracker() {
			return serviceTracker;
		}

		public boolean isSatisfied() {
			return !info.isMandatory() ||  serviceTracker.size() > 0;
		}
	}
	
	protected ReferenceEntry[] referenceEntries;
	
	protected ParameterReferenceManager(BundleContext context, Method method, ReferenceInfo[] referenceInfo) throws Exception {
		this.method = method;
		referenceEntries = new ReferenceEntry[referenceInfo.length];
		for (int i=0; i<referenceInfo.length; ++i) {
			if (referenceInfo[i]!=null) {
				referenceEntries[i] = new ReferenceEntry(context, referenceInfo[i]);
			}
		}
	}
	
	protected ParameterReferenceManager(Method method, ReferenceInfo[] referenceInfo) throws Exception {
		this(FrameworkUtil.getBundle(method.getDeclaringClass()).getBundleContext(), method, referenceInfo);
	}
	
	protected ParameterReferenceManager(BundleContext context, Method method) throws Exception {
		this(context, method, getReferenceInfoFromAnnotations(method));
	}
	
	protected ParameterReferenceManager(Method method) throws Exception {
		this(FrameworkUtil.getBundle(method.getDeclaringClass()).getBundleContext(), method);
	}
	
	@SuppressWarnings("unchecked")
	public static ReferenceInfo[] getReferenceInfoFromAnnotations(Method method) {
		Class<?>[] pt = method.getParameterTypes();
		Annotation[][] pa = method.getParameterAnnotations();
		ReferenceInfo[] ret = new ReferenceInfo[pa.length];
		Z: for (int i=0; i<pa.length; ++i) {
			for (Annotation a: pa[i]) {
				if (a instanceof ServiceParameter) {
					ret[i] = new ReferenceInfo(
							(Class<Object>) (pt[i].isArray() ? pt[i].getComponentType() : pt[i]),
							pt[i].isArray(), 
							((ServiceParameter) a).mandatory(), 
							((ServiceParameter) a).value());
					continue Z;
				}
			}
		}
		return ret;
	}
	
	public boolean canExecute() {
		for (ReferenceEntry re: referenceEntries) {
			if (re!=null && !re.isSatisfied()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Injects service references, if any. 
	 */
	protected void injectServiceReferences(Object[] args) throws Exception {
		Class<?>[] pt = method.getParameterTypes();
		for (int i=0; i<pt.length; ++i) {
			if (referenceEntries[i]!=null) {
				if (referenceEntries[i].isSatisfied()) {
					if (referenceEntries[i].getInfo().isMany()) {
						Object[] services = referenceEntries[i].getServiceTracker().getServices();
						if (pt[i].isArray()) {
							args[i] = Array.newInstance(pt[i].getComponentType(), services.length);
							System.arraycopy(services, 0, args[i], 0, services.length);
						} else if (pt[i].isAssignableFrom(List.class)) {
							args[i] = Arrays.asList(services);
						} else {
							throw new IllegalArgumentException("Cannot pass a list of services to parameter of type "+pt[i]);
						}
					} else {
						args[i] = referenceEntries[i].getServiceTracker().getService();
					}
				} else {
					throw new IllegalStateException("Service reference "+referenceEntries[i].getInfo()+" is not satisfied");
				}
			}
		}
	}

	@Override
	public void close() throws Exception {
		if (referenceEntries!=null) {
			for (ReferenceEntry re: referenceEntries) {
				if (re!=null) {
					ServiceTracker<Object, Object> st = re.getServiceTracker();
					if (st!=null) {
						st.close();
					}
				}
			}
		}		
	}

}
