/**
 */
package org.nasdanika.codegen.maven.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.impl.NatureImpl;

import org.nasdanika.codegen.maven.MavenNature;
import org.nasdanika.codegen.maven.MavenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nature</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MavenNatureImpl extends NatureImpl implements MavenNature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MavenNatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MavenPackage.Literals.MAVEN_NATURE;
	}

} //MavenNatureImpl
