/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.security.Action;
import org.nasdanika.cdo.security.PrincipalPermission;
import org.nasdanika.cdo.security.ProtectedPermission;
import org.nasdanika.cdo.security.SecurityFactory;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getIncludePatterns <em>Include Patterns</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getExcludePatterns <em>Exclude Patterns</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#isGrantable <em>Grantable</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getImplies <em>Implies</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getImpliedBy <em>Implied By</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionImpl extends CDOObjectImpl implements Action {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.ACTION;
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
	public String getName() {
		return (String)eGet(SecurityPackage.Literals.ACTION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SecurityPackage.Literals.ACTION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getIncludePatterns() {
		return (EList<String>)eGet(SecurityPackage.Literals.ACTION__INCLUDE_PATTERNS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getExcludePatterns() {
		return (EList<String>)eGet(SecurityPackage.Literals.ACTION__EXCLUDE_PATTERNS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(SecurityPackage.Literals.ACTION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(SecurityPackage.Literals.ACTION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGrantable() {
		return (Boolean)eGet(SecurityPackage.Literals.ACTION__GRANTABLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrantable(boolean newGrantable) {
		eSet(SecurityPackage.Literals.ACTION__GRANTABLE, newGrantable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Action> getImplies() {
		return (EList<Action>)eGet(SecurityPackage.Literals.ACTION__IMPLIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Action> getImpliedBy() {
		return (EList<Action>)eGet(SecurityPackage.Literals.ACTION__IMPLIED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategory() {
		return (String)eGet(SecurityPackage.Literals.ACTION__CATEGORY, true);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(String newCategory) {
		eSet(SecurityPackage.Literals.ACTION__CATEGORY, newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Action> getChildren() {
		return (EList<Action>)eGet(SecurityPackage.Literals.ACTION__CHILDREN, true);
	}

	/**
	 * Matches a pattern where <code>*</code> stands for zero or more characters and <code>?</code> stands for a single character.
	 * @param text
	 * @param glob
	 * @return
	 */
	private static boolean globMatch(String text, String glob) {
	    String rest = null;
	    int pos = glob.indexOf('*');
	    if (pos != -1) {
	        rest = glob.substring(pos + 1);
	        glob = glob.substring(0, pos);
	    }

	    if (glob.length() > text.length()) {
	        return false;
	    }

	    // handle the part up to the first *
	    for (int i = 0; i < glob.length(); i++) {
	        if (glob.charAt(i) != '?' && !glob.substring(i, i + 1).equalsIgnoreCase(text.substring(i, i + 1))) {
	            return false;
	        }
	    }
	    
	    // recurse for the part after the first *, if any
	    if (rest == null) {
	        return glob.length() == text.length();
	    } else {
	        for (int i = glob.length(); i <= text.length(); i++) {
	            if (globMatch(text.substring(i), rest)) {
	                return true;
	            }
	        }
	        return false;
	    }
	}	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean match(Context context, EObject target, String action, String qualifier, Map<String, Object> environment) {
		String[] toMatch;
		if (CoreUtil.isBlank(qualifier)) {
			toMatch = new String[] {action, action+":this"}; // So, say read:* matches read because read is the same as read:this
		} else {
			toMatch = new String[] {action+":"+qualifier};
		}
		for (String matchStr: toMatch) {
			I: for (String includePattern: getIncludePatterns()) {
				if (globMatch(matchStr, includePattern)) { 
					for (String excludePattern: getExcludePatterns()) {
						if (globMatch(matchStr, excludePattern)) {
							continue I;
						}
					}
					return true;
				}
			}
		}
		
		for (Action a: getImplies()) {
			if (a.match(context, target, action, qualifier, environment)) {
				return true;
			}
		}
		for (Action a: getChildren()) {
			if (a.match(context, target, action, qualifier, environment)) {
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
	public PrincipalPermission createPrincipalPermission() {
		return SecurityFactory.eINSTANCE.createPrincipalPermission();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProtectedPermission createProtectedPermission() {
		return SecurityFactory.eINSTANCE.createProtectedPermission();
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
			case SecurityPackage.ACTION___MATCH__CONTEXT_EOBJECT_STRING_STRING_MAP:
				return match((Context)arguments.get(0), (EObject)arguments.get(1), (String)arguments.get(2), (String)arguments.get(3), (Map<String, Object>)arguments.get(4));
			case SecurityPackage.ACTION___CREATE_PRINCIPAL_PERMISSION:
				return createPrincipalPermission();
			case SecurityPackage.ACTION___CREATE_PROTECTED_PERMISSION:
				return createProtectedPermission();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ActionImpl
