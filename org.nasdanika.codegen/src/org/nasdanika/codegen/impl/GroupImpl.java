/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Generator;
import org.nasdanika.codegen.Group;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.GroupImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.GroupImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.GroupImpl#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupImpl<T> extends GeneratorImpl<T> implements Group<T> {
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
		return CodegenPackage.Literals.GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIterator() {
		return (String)eGet(CodegenPackage.Literals.GROUP__ITERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterator(String newIterator) {
		eSet(CodegenPackage.Literals.GROUP__ITERATOR, newIterator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelector() {
		return (String)eGet(CodegenPackage.Literals.GROUP__SELECTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelector(String newSelector) {
		eSet(CodegenPackage.Literals.GROUP__SELECTOR, newSelector);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Generator<T>> getMembers() {
		return (EList<Generator<T>>)eGet(CodegenPackage.Literals.GROUP__MEMBERS, true);
	}

} //GroupImpl
