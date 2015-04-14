/**
 */
package org.nasdanika.cdo.function.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.cdo.function.ServiceMethodFunction;
import org.nasdanika.core.NasdanikaException;
import org.nasdanika.function.FunctionException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Method Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.impl.ServiceMethodFunctionImpl#getServiceType <em>Service Type</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.ServiceMethodFunctionImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.ServiceMethodFunctionImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.ServiceMethodFunctionImpl#getParameterTypes <em>Parameter Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceMethodFunctionImpl<CR, T, R> extends AbstractFunctionImpl<CR, T, R> implements ServiceMethodFunction<CR, T, R> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceMethodFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.SERVICE_METHOD_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilter() {
		return (String)eGet(FunctionPackage.Literals.SERVICE_METHOD_FUNCTION__FILTER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter(String newFilter) {
		eSet(FunctionPackage.Literals.SERVICE_METHOD_FUNCTION__FILTER, newFilter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceType() {
		return (String)eGet(FunctionPackage.Literals.SERVICE_METHOD_FUNCTION__SERVICE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceType(String newServiceType) {
		eSet(FunctionPackage.Literals.SERVICE_METHOD_FUNCTION__SERVICE_TYPE, newServiceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return (String)eGet(FunctionPackage.Literals.SERVICE_METHOD_FUNCTION__METHOD_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		eSet(FunctionPackage.Literals.SERVICE_METHOD_FUNCTION__METHOD_NAME, newMethodName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ClassBox<T>> getParameterTypes() {
		return (EList<ClassBox<T>>)eGet(FunctionPackage.Literals.SERVICE_METHOD_FUNCTION__PARAMETER_TYPES, true);
	}

	@Override
	public Class<?>[] getParameterTypes(CDOTransactionContext<CR> context) {
		EList<ClassBox<T>> ptl = getParameterTypes();
		Class<?>[] ret = new Class<?>[ptl.size()];
		int idx = 0;
		for (ClassBox<T> pt: ptl) {
			ret[idx++] = pt.get(context);
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<R> getReturnType(CDOTransactionContext<CR> context) {
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		try {
			ServiceReference<?>[] refs = bundleContext.getServiceReferences(getServiceType(), getFilter());
			if (refs!=null) {
				for (ServiceReference<?> ref: refs) {
					Object service = bundleContext.getService(ref);
					if (service!=null) {
						try {
							return (Class<R>) service.getClass().getMethod(getMethodName(), getParameterTypes(context)).getReturnType();
						} finally {
							bundleContext.ungetService(ref);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new FunctionException(e);
		}
		throw new FunctionException("Service not found "+getServiceType()+" / "+getFilter());		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected R invoke(CDOTransactionContext<CR> context, Object[] args) throws Exception {
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		try {
			ServiceReference<?>[] refs = bundleContext.getServiceReferences(getServiceType(), getFilter());
			if (refs!=null) {
				for (ServiceReference<?> ref: refs) {
					Object service = bundleContext.getService(ref);
					if (service!=null) {
						try {
							Class<?>[] parameterTypes = getParameterTypes(context);
							Object[] arguments = new Object[args.length];
							for (int i=0; i<args.length; ++i) {
								if (args==null || parameterTypes[i].isInstance(args[i])) {
									arguments[i] = args[i];
								} else {
									arguments[i] = context.convert(args[i], parameterTypes[i]);
									if (arguments[i]==null) {
										throw new NasdanikaException("Cannot convert "+args[i]+" to "+parameterTypes[i]);
									}
								}
							}							
							return (R) service.getClass().getMethod(getMethodName(), parameterTypes).invoke(service, arguments);
						} finally {
							bundleContext.ungetService(ref);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new FunctionException(e);
		}
		throw new FunctionException("Service not found "+getServiceType()+" / "+getFilter());		
	}

} //ServiceMethodFunctionImpl
