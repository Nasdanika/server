/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.TextFile;
import org.nasdanika.codegen.TextGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.TextFileImpl#getTextgenerator <em>Textgenerator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TextFileImpl extends FileImpl implements TextFile {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.TEXT_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextGenerator getTextgenerator() {
		return (TextGenerator)eGet(CodegenPackage.Literals.TEXT_FILE__TEXTGENERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextgenerator(TextGenerator newTextgenerator) {
		eSet(CodegenPackage.Literals.TEXT_FILE__TEXTGENERATOR, newTextgenerator);
	}

} //TextFileImpl
