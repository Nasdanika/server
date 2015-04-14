/**
 */
package org.nasdanika.cdo.function.impl;

import java.lang.reflect.Method;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.cdo.function.ObjectMethodFunction;
import org.nasdanika.core.InstanceMethodCommand;
import org.nasdanika.core.MethodCommand;
import org.nasdanika.function.FunctionException;
import org.osgi.framework.FrameworkUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Method Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl#getParameterTypes <em>Parameter Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectMethodFunctionImpl<CR, T, R> extends AbstractFunctionImpl<CR, T, R> implements ObjectMethodFunction<CR, T, R> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectMethodFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.OBJECT_METHOD_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		return (EObject)eGet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		eSet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return (String)eGet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__METHOD_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		eSet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__METHOD_NAME, newMethodName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ClassBox<T>> getParameterTypes() {
		return (EList<ClassBox<T>>)eGet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__PARAMETER_TYPES, true);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<R> getReturnType(CDOTransactionContext<CR> context) {
		Object target = BoxUtil.unbox(getTarget(), context);
		try {
			return (Class<R>) target.getClass().getMethod(getMethodName(), getParameterTypes(context)).getReturnType();
		} catch (Exception e) {
			throw new FunctionException(e);
		}
	}
	
	private InstanceMethodCommand<CDOTransactionContext<CR>, R> getInstanceMethodCommand(CDOTransactionContext<CR> context) {
		EList<ClassBox<T>> ptl = getParameterTypes();
		Class<?>[] parameterTypes = new Class<?>[ptl.size()];
		int idx = 0;
		for (ClassBox<T> pt: ptl) {
			parameterTypes[idx++] = pt.get(context);
		}
		Object target = BoxUtil.unbox(getTarget(), context);
		try {
			Method targetMethod = target.getClass().getMethod(getMethodName(), parameterTypes);
			MethodCommand<CDOTransactionContext<CR>, R> methodCommand = new MethodCommand<CDOTransactionContext<CR>, R>(FrameworkUtil.getBundle(getClass()).getBundleContext(), targetMethod);
			return new InstanceMethodCommand<CDOTransactionContext<CR>, R>(target, methodCommand);
		} catch (Exception e) {
			throw new FunctionException(e);
		}		
	}
	
	@Override
	public Class<?>[] getParameterTypes(CDOTransactionContext<CR> context) {
		try (InstanceMethodCommand<CDOTransactionContext<CR>, R> cmd = getInstanceMethodCommand(context)) {
			return cmd.getParameterTypes();
		} catch (Exception e) {
			throw new FunctionException(e);
		}
	}
	
	@Override
	protected R invoke(CDOTransactionContext<CR> context, Object[] args) throws Exception {
		try (InstanceMethodCommand<CDOTransactionContext<CR>, R> cmd = getInstanceMethodCommand(context)) {
			return cmd.execute(context, args); 
		}
	}
	
} //ObjectMethodFunctionImpl
