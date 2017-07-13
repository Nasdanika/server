/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.PrincipalVisitor;
import org.nasdanika.cdo.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.GroupImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.GroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.GroupImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupImpl extends PrincipalImpl implements Group {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Principal> getMembers() {
		return (EList<Principal>)eGet(SecurityPackage.Literals.GROUP__MEMBERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(SecurityPackage.Literals.GROUP__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SecurityPackage.Literals.GROUP__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(SecurityPackage.Literals.GROUP__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(SecurityPackage.Literals.GROUP__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isMember(Principal principal) {
		if (principal==null) {
			return false;
		}
		for (Principal m: getMembers()) {
			if (m.equals(principal)) {
				return true;
			}
			
			if (m instanceof Group && ((Group) m).isMember(principal)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void accept(PrincipalVisitor visitor) {
		if (visitor.visit(this)) {
			for (Principal m: getMembers()) {
				m.accept(visitor);
			}
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
			case SecurityPackage.GROUP___IS_MEMBER__PRINCIPAL:
				return isMember((Principal)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //GroupImpl
