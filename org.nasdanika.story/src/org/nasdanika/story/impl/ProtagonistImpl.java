/**
 */
package org.nasdanika.story.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.StoryBase;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.util.StoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protagonist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.impl.ProtagonistImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ProtagonistImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ProtagonistImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ProtagonistImpl#getStories <em>Stories</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ProtagonistImpl#getLinkTo <em>Link To</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ProtagonistImpl extends MinimalEObjectImpl.Container implements Protagonist {
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
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStories() <em>Stories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStories()
	 * @generated
	 * @ordered
	 */
	protected EList<StoryBase> stories;

	/**
	 * The cached value of the '{@link #getLinkTo() <em>Link To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkTo()
	 * @generated
	 * @ordered
	 */
	protected EClass linkTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtagonistImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.PROTAGONIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.PROTAGONIST__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.PROTAGONIST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.PROTAGONIST__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StoryBase> getStories() {
		if (stories == null) {
			stories = new EObjectContainmentEList<StoryBase>(StoryBase.class, this, StoryPackage.PROTAGONIST__STORIES);
		}
		return stories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkTo() {
		if (linkTo != null && linkTo.eIsProxy()) {
			InternalEObject oldLinkTo = (InternalEObject)linkTo;
			linkTo = (EClass)eResolveProxy(oldLinkTo);
			if (linkTo != oldLinkTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoryPackage.PROTAGONIST__LINK_TO, oldLinkTo, linkTo));
			}
		}
		return linkTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetLinkTo() {
		return linkTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkTo(EClass newLinkTo) {
		EClass oldLinkTo = linkTo;
		linkTo = newLinkTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.PROTAGONIST__LINK_TO, oldLinkTo, linkTo));
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
			case StoryPackage.PROTAGONIST__STORIES:
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
			case StoryPackage.PROTAGONIST__ID:
				return getId();
			case StoryPackage.PROTAGONIST__NAME:
				return getName();
			case StoryPackage.PROTAGONIST__DESCRIPTION:
				return getDescription();
			case StoryPackage.PROTAGONIST__STORIES:
				return getStories();
			case StoryPackage.PROTAGONIST__LINK_TO:
				if (resolve) return getLinkTo();
				return basicGetLinkTo();
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
			case StoryPackage.PROTAGONIST__ID:
				setId((String)newValue);
				return;
			case StoryPackage.PROTAGONIST__NAME:
				setName((String)newValue);
				return;
			case StoryPackage.PROTAGONIST__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case StoryPackage.PROTAGONIST__STORIES:
				getStories().clear();
				getStories().addAll((Collection<? extends StoryBase>)newValue);
				return;
			case StoryPackage.PROTAGONIST__LINK_TO:
				setLinkTo((EClass)newValue);
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
			case StoryPackage.PROTAGONIST__ID:
				setId(ID_EDEFAULT);
				return;
			case StoryPackage.PROTAGONIST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StoryPackage.PROTAGONIST__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case StoryPackage.PROTAGONIST__STORIES:
				getStories().clear();
				return;
			case StoryPackage.PROTAGONIST__LINK_TO:
				setLinkTo((EClass)null);
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
			case StoryPackage.PROTAGONIST__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case StoryPackage.PROTAGONIST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StoryPackage.PROTAGONIST__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case StoryPackage.PROTAGONIST__STORIES:
				return stories != null && !stories.isEmpty();
			case StoryPackage.PROTAGONIST__LINK_TO:
				return linkTo != null;
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
			case StoryPackage.PROTAGONIST___VALIDATE__DIAGNOSTICCHAIN_MAP:
				return validate((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ProtagonistImpl
