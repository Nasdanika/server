/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JET Emitter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Invokes ``org.eclipse.emf.codegen.jet.JETEmitter`` to compile and evaluate a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.JETEmitter#getTemplateURI <em>Template URI</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getJETEmitter()
 * @model superTypes="org.nasdanika.codegen.Generator<org.eclipse.emf.ecore.EString>"
 * @generated
 */
public interface JETEmitter extends Generator<String> {
	/**
	 * Returns the value of the '<em><b>Template URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Template location.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Template URI</em>' attribute.
	 * @see #setTemplateURI(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getJETEmitter_TemplateURI()
	 * @model
	 * @generated
	 */
	String getTemplateURI();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.JETEmitter#getTemplateURI <em>Template URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template URI</em>' attribute.
	 * @see #getTemplateURI()
	 * @generated
	 */
	void setTemplateURI(String value);

} // JETEmitter
