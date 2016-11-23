/**
 */
package org.nasdanika.codegen;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Generator is the base class for model element performing code generation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.Generator#getIterator <em>Iterator</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getGenerator()
 * @model abstract="true" superTypes="org.nasdanika.codegen.WorkFactory<org.nasdanika.codegen.List<T>> org.nasdanika.codegen.Configuration"
 * @generated
 */
public interface Generator<T> extends WorkFactory<List<T>>, Configuration {

	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Iterator attribute may contain a fragment of Java code which controls
	 * how many times the generator will be invoked and can modify generator's 
	 * context for each invocation.
	 * 
	 * The iterator's code shall be a Java method body as shown below:
	 * 
	 * ```java
	 * <T extends Generator> Object iterate(Context context, T generator) throws Exception {
	 *     // --- Iterator code here ---
	 * }
	 * ```
	 * 
	 * where ``T`` is the type of the iterator declaring generator model element. 
	 * 
	 * Iterator code may return one of the following:
	 * 
	 * * ``null`` or ``false`` or empty collection - no iteration.
	 * * ``java.lang.Iterable`` with elements of type ``org.nasdanika.codegen.Context`` or an array containing ``Context`` elements - generator will be invoked for each element of array/iterable and the element will be passed to the generator as its context.
	 * * ``Context`` - single invocation with returned context.
	 * 
	 * If the iterator returns any other result, then the generator throws ``IllegalArgumentException``.
	 * 
	 * Blank iterator code is equivalent to ``return context;``
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Iterator</em>' attribute.
	 * @see #setIterator(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getGenerator_Iterator()
	 * @model
	 * @generated
	 */
	String getIterator();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.Generator#getIterator <em>Iterator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' attribute.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Validates element for execution/generation. Adds messages to diagnostics and 
	 * @param diagnostics Diagnostics to add validation messages to.
	 * @param context Validation context.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validate(DiagnosticChain diagnostics, Map<Object, Object> context);
} // Generator
