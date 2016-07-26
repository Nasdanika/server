/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.core.Context;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.ClassBoxImpl#getBundleName <em>Bundle Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.ClassBoxImpl#getBundleVersion <em>Bundle Version</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.ClassBoxImpl#getClassName <em>Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassBoxImpl<T> extends CDOObjectImpl implements ClassBox<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.CLASS_BOX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBundleName() {
		return (String)eGet(BoxingPackage.Literals.CLASS_BOX__BUNDLE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleName(String newBundleName) {
		eSet(BoxingPackage.Literals.CLASS_BOX__BUNDLE_NAME, newBundleName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBundleVersion() {
		return (String)eGet(BoxingPackage.Literals.CLASS_BOX__BUNDLE_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleVersion(String newBundleVersion) {
		eSet(BoxingPackage.Literals.CLASS_BOX__BUNDLE_VERSION, newBundleVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return (String)eGet(BoxingPackage.Literals.CLASS_BOX__CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		eSet(BoxingPackage.Literals.CLASS_BOX__CLASS_NAME, newClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Class<T> get(Context context) {
		String bundleName = getBundleName();
		if (bundleName==null) {
			try {
				return (Class<T>) getClass().getClassLoader().loadClass(getClassName());
			} catch (ClassNotFoundException e) {
				throw new BoxingException(e);
			}
		}
		
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {
			throw new BoxingException("Cannot load "+getClassName()+" - defining bundle not found "+bundleName);
		}
		
		try {
			return (Class<T>) bundle.loadClass(getClassName());
		} catch (ClassNotFoundException e) {
			throw new BoxingException(e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void set(Class<T> value, Context context) {
		setClassName(value.getName());
		Bundle bundle = FrameworkUtil.getBundle(value);
		if (bundle!=null) {
			setBundleName(bundle.getSymbolicName());
			setBundleVersion(bundle.getVersion().toString());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BoxingPackage.CLASS_BOX___GET__CONTEXT:
				return get((Context)arguments.get(0));
			case BoxingPackage.CLASS_BOX___SET__OBJECT_CONTEXT:
				set((Class<T>)arguments.get(0), (Context)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ClassBoxImpl
