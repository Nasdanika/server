/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Protected;
import org.nasdanika.cdo.security.ProtectedPermission;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.util.SecurityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protected Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.ProtectedPermissionImpl#getPrincipal <em>Principal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProtectedPermissionImpl extends PermissionImpl implements ProtectedPermission {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtectedPermissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.PROTECTED_PERMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Principal getPrincipal() {
		return (Principal)eGet(SecurityPackage.Literals.PROTECTED_PERMISSION__PRINCIPAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrincipal(Principal newPrincipal) {
		eSet(SecurityPackage.Literals.PROTECTED_PERMISSION__PRINCIPAL, newPrincipal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validate(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean hasDuplicates = false;
		if (diagnostics != null) {
			for (ProtectedPermission pp: ((Protected) eContainer()).getPermissions()) {
				if (pp != this && EcoreUtil.equals(pp, this)) {
					hasDuplicates = true;
					break;
				}
			}
			
			if (hasDuplicates) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SecurityValidator.DIAGNOSTIC_SOURCE,
						 SecurityValidator.PROTECTED_PERMISSION__VALIDATE,
						 "Duplicate permission",
						 new Object [] { this }));
			}
		}
		return !hasDuplicates;
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
			case SecurityPackage.PROTECTED_PERMISSION___VALIDATE__DIAGNOSTICCHAIN_MAP:
				return validate((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public EObject getTarget() {
		return eContainer();
	}

} //ProtectedPermissionImpl
