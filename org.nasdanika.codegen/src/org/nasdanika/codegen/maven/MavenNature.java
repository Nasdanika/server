/**
 */
package org.nasdanika.codegen.maven;

import org.nasdanika.codegen.Generator;
import org.nasdanika.codegen.Nature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Maven nature.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.maven.MavenNature#getPomGenerator <em>Pom Generator</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.maven.MavenPackage#getMavenNature()
 * @model
 * @generated
 */
public interface MavenNature extends Nature {

	/**
	 * Returns the value of the '<em><b>Pom Generator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional generator of ``pom.xml`` file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pom Generator</em>' containment reference.
	 * @see #setPomGenerator(Generator)
	 * @see org.nasdanika.codegen.maven.MavenPackage#getMavenNature_PomGenerator()
	 * @model type="org.nasdanika.codegen.Generator<org.eclipse.emf.ecore.EString>" containment="true"
	 * @generated
	 */
	Generator<String> getPomGenerator();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.maven.MavenNature#getPomGenerator <em>Pom Generator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pom Generator</em>' containment reference.
	 * @see #getPomGenerator()
	 * @generated
	 */
	void setPomGenerator(Generator<String> value);
} // MavenNature
