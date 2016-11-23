/**
 */
package org.nasdanika.codegen.maven.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import org.eclipse.emf.edit.provider.ViewerNotification;
import org.nasdanika.codegen.CodegenFactory;
import org.nasdanika.codegen.java.JavaFactory;
import org.nasdanika.codegen.maven.MavenFactory;
import org.nasdanika.codegen.maven.MavenNature;
import org.nasdanika.codegen.maven.MavenPackage;
import org.nasdanika.codegen.provider.CodegenEditPlugin;
import org.nasdanika.codegen.provider.NatureItemProvider;

/**
 * This is the item provider adapter for a {@link org.nasdanika.codegen.maven.MavenNature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MavenNatureItemProvider extends NatureItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MavenNatureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MavenNature.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MavenNature"));
	}
	
	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MavenNature)object).getBaseURL();
		return label == null || label.length() == 0 ?
			getString("_UI_MavenNature_type") :
			getString("_UI_MavenNature_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MavenNature.class)) {
			case MavenPackage.MAVEN_NATURE__POM_GENERATOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 MavenFactory.eINSTANCE.createMavenNature()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createWorkspace()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createFolder()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createProject()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createBinaryFile()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createTextFile()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createResourceReference()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createStaticText()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createContentReference()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createInterpolator()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createJETEmitter()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createJavaTextFilter()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createJavaStreamFilter()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createJavaTextGenerator()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 CodegenFactory.eINSTANCE.createJavaStreamGenerator()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 JavaFactory.eINSTANCE.createJavaNature()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 JavaFactory.eINSTANCE.createPackageFragmentRoot()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 JavaFactory.eINSTANCE.createPackageFragment()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 JavaFactory.eINSTANCE.createTextCompilationUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MavenPackage.Literals.MAVEN_NATURE__POM_GENERATOR,
				 JavaFactory.eINSTANCE.createStructuredCompilationUnit()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CodegenEditPlugin.INSTANCE;
	}

}
