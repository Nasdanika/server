/**
 */
package org.nasdanika.sca.provider;


import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.nasdanika.sca.Composite;
import org.nasdanika.sca.ScaFactory;
import org.nasdanika.sca.ScaPackage;

/**
 * This is the item provider adapter for a {@link org.nasdanika.sca.Composite} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeItemProvider extends AbstractComponentItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeItemProvider(AdapterFactory adapterFactory) {
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

			addImplementationPropertyDescriptor(object);
			addImplementationClassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Implementation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImplementationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Composite_implementation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Composite_implementation_feature", "_UI_Composite_type"),
				 ScaPackage.Literals.COMPOSITE__IMPLEMENTATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Implementation Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImplementationClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Composite_implementationClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Composite_implementationClass_feature", "_UI_Composite_type"),
				 ScaPackage.Literals.COMPOSITE__IMPLEMENTATION_CLASS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
			childrenFeatures.add(ScaPackage.Literals.COMPOSITE__COMPONENTS);
			childrenFeatures.add(ScaPackage.Literals.COMPOSITE__EXPORTED_SERVICES);
			childrenFeatures.add(ScaPackage.Literals.COMPOSITE__IMPORTED_REFERENCES);
			childrenFeatures.add(ScaPackage.Literals.COMPOSITE__IMPORTED_PROPERTIES);
			childrenFeatures.add(ScaPackage.Literals.COMPOSITE__EXPORTED_OPERATIONS);
			childrenFeatures.add(ScaPackage.Literals.COMPOSITE__IMPORTED_ACTIVATORS);
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
	 * This returns Composite.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Composite"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Composite)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Composite_type") :
			getString("_UI_Composite_type") + " " + label;
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

		switch (notification.getFeatureID(Composite.class)) {
			case ScaPackage.COMPOSITE__COMPONENTS:
			case ScaPackage.COMPOSITE__EXPORTED_SERVICES:
			case ScaPackage.COMPOSITE__IMPORTED_REFERENCES:
			case ScaPackage.COMPOSITE__IMPORTED_PROPERTIES:
			case ScaPackage.COMPOSITE__EXPORTED_OPERATIONS:
			case ScaPackage.COMPOSITE__IMPORTED_ACTIVATORS:
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
				(ScaPackage.Literals.COMPOSITE__COMPONENTS,
				 ScaFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.COMPOSITE__COMPONENTS,
				 ScaFactory.eINSTANCE.createComposite()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.COMPOSITE__COMPONENTS,
				 ScaFactory.eINSTANCE.createCompositeReference()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.COMPOSITE__EXPORTED_SERVICES,
				 ScaFactory.eINSTANCE.createServiceExport()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.COMPOSITE__IMPORTED_REFERENCES,
				 ScaFactory.eINSTANCE.createReferenceImport()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.COMPOSITE__IMPORTED_PROPERTIES,
				 ScaFactory.eINSTANCE.createPropertyImport()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.COMPOSITE__EXPORTED_OPERATIONS,
				 ScaFactory.eINSTANCE.createOperationExport()));

		newChildDescriptors.add
			(createChildParameter
				(ScaPackage.Literals.COMPOSITE__IMPORTED_ACTIVATORS,
				 ScaFactory.eINSTANCE.createActivatorImport()));
	}

}
