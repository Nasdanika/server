/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.TextFilter;
import org.nasdanika.codegen.TextGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.TextFilterImpl#getTextgenerator <em>Textgenerator</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TextFilterImpl extends TextGeneratorImpl implements TextFilter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.TEXT_FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextGenerator getTextgenerator() {
		return (TextGenerator)eGet(CodegenPackage.Literals.TEXT_FILTER__TEXTGENERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextgenerator(TextGenerator newTextgenerator) {
		eSet(CodegenPackage.Literals.TEXT_FILTER__TEXTGENERATOR, newTextgenerator);
	}

} //TextFilterImpl
