/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.TextReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.TextReferenceImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TextReferenceImpl extends TextGeneratorImpl implements TextReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.TEXT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRef() {
		return (String)eGet(CodegenPackage.Literals.TEXT_REFERENCE__REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(String newRef) {
		eSet(CodegenPackage.Literals.TEXT_REFERENCE__REF, newRef);
	}

} //TextReferenceImpl
