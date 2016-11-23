/**
 */
package org.nasdanika.codegen.maven.impl;

import java.util.List;

import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.Generator;
import org.nasdanika.codegen.Work;
import org.nasdanika.codegen.impl.NatureImpl;

import org.nasdanika.codegen.maven.MavenNature;
import org.nasdanika.codegen.maven.MavenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.maven.impl.MavenNatureImpl#getPomGenerator <em>Pom Generator</em>}</li>
 * </ul>
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generator<String> getPomGenerator() {
		return (Generator<String>)eGet(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPomGenerator(Generator<String> newPomGenerator) {
		eSet(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR, newPomGenerator);
	}

	@Override
	public Work<List<IProjectNature>> createWork(Context context, IProgressMonitor monitor) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWorkFactorySize() {
		// TODO Auto-generated method stub
		return 0;
	}

} //MavenNatureImpl
