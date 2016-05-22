/**
 */
package org.nasdanika.story.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import java.util.Map;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Epic;
import org.nasdanika.story.StoryBase;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.util.StoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Epic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.impl.EpicImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.EpicImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.EpicImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.EpicImpl#getStories <em>Stories</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EpicImpl extends CDOObjectImpl implements Epic {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EpicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.EPIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eDynamicGet(StoryPackage.EPIC__ID, StoryPackage.Literals.CATALOG_ELEMENT__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(StoryPackage.EPIC__ID, StoryPackage.Literals.CATALOG_ELEMENT__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(StoryPackage.EPIC__NAME, StoryPackage.Literals.CATALOG_ELEMENT__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(StoryPackage.EPIC__NAME, StoryPackage.Literals.CATALOG_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eDynamicGet(StoryPackage.EPIC__DESCRIPTION, StoryPackage.Literals.CATALOG_ELEMENT__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(StoryPackage.EPIC__DESCRIPTION, StoryPackage.Literals.CATALOG_ELEMENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StoryBase> getStories() {
		return (EList<StoryBase>)eDynamicGet(StoryPackage.EPIC__STORIES, StoryPackage.Literals.STORY_CONTAINER__STORIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validate(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (getId() != null && getId().trim().length() > 0) {
			TreeIterator<EObject> rcit = eResource().getAllContents();
			while (rcit.hasNext()) {
				EObject next = rcit.next();
				if (next != this && next instanceof CatalogElement) {
					String nextId = ((CatalogElement) next).getId();
					if (nextId != null && getId().trim().equals(nextId.trim())) {
						if (diagnostics != null) {
							diagnostics.add
								(new BasicDiagnostic
									(Diagnostic.ERROR,
									 StoryValidator.DIAGNOSTIC_SOURCE,
									 StoryValidator.CATALOG_ELEMENT__VALIDATE,
									 "Duplicate ID " + EObjectValidator.getObjectLabel(this, context),
									 new Object [] { this }));
						}
						return false;						
					}
				}
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoryPackage.EPIC__STORIES:
				return ((InternalEList<?>)getStories()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoryPackage.EPIC__ID:
				return getId();
			case StoryPackage.EPIC__NAME:
				return getName();
			case StoryPackage.EPIC__DESCRIPTION:
				return getDescription();
			case StoryPackage.EPIC__STORIES:
				return getStories();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoryPackage.EPIC__ID:
				setId((String)newValue);
				return;
			case StoryPackage.EPIC__NAME:
				setName((String)newValue);
				return;
			case StoryPackage.EPIC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case StoryPackage.EPIC__STORIES:
				getStories().clear();
				getStories().addAll((Collection<? extends StoryBase>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StoryPackage.EPIC__ID:
				setId(ID_EDEFAULT);
				return;
			case StoryPackage.EPIC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StoryPackage.EPIC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case StoryPackage.EPIC__STORIES:
				getStories().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StoryPackage.EPIC__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case StoryPackage.EPIC__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case StoryPackage.EPIC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case StoryPackage.EPIC__STORIES:
				return !getStories().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StoryPackage.EPIC___VALIDATE__DIAGNOSTICCHAIN_MAP:
				return validate((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //EpicImpl
