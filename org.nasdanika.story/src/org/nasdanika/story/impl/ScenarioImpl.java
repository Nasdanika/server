/**
 */
package org.nasdanika.story.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.util.StoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.impl.ScenarioImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ScenarioImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ScenarioImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ScenarioImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ScenarioImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ScenarioImpl#getOutcome <em>Outcome</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScenarioImpl extends CDOObjectImpl implements Scenario {
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
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getOutcome() <em>Outcome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutcome()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTCOME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.SCENARIO;
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
		return (String)eDynamicGet(StoryPackage.SCENARIO__ID, StoryPackage.Literals.CATALOG_ELEMENT__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(StoryPackage.SCENARIO__ID, StoryPackage.Literals.CATALOG_ELEMENT__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(StoryPackage.SCENARIO__NAME, StoryPackage.Literals.CATALOG_ELEMENT__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(StoryPackage.SCENARIO__NAME, StoryPackage.Literals.CATALOG_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eDynamicGet(StoryPackage.SCENARIO__DESCRIPTION, StoryPackage.Literals.CATALOG_ELEMENT__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(StoryPackage.SCENARIO__DESCRIPTION, StoryPackage.Literals.CATALOG_ELEMENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContext() {
		return (String)eDynamicGet(StoryPackage.SCENARIO__CONTEXT, StoryPackage.Literals.SCENARIO__CONTEXT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(String newContext) {
		eDynamicSet(StoryPackage.SCENARIO__CONTEXT, StoryPackage.Literals.SCENARIO__CONTEXT, newContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAction() {
		return (String)eDynamicGet(StoryPackage.SCENARIO__ACTION, StoryPackage.Literals.SCENARIO__ACTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(String newAction) {
		eDynamicSet(StoryPackage.SCENARIO__ACTION, StoryPackage.Literals.SCENARIO__ACTION, newAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutcome() {
		return (String)eDynamicGet(StoryPackage.SCENARIO__OUTCOME, StoryPackage.Literals.SCENARIO__OUTCOME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutcome(String newOutcome) {
		eDynamicSet(StoryPackage.SCENARIO__OUTCOME, StoryPackage.Literals.SCENARIO__OUTCOME, newOutcome);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoryPackage.SCENARIO__ID:
				return getId();
			case StoryPackage.SCENARIO__NAME:
				return getName();
			case StoryPackage.SCENARIO__DESCRIPTION:
				return getDescription();
			case StoryPackage.SCENARIO__CONTEXT:
				return getContext();
			case StoryPackage.SCENARIO__ACTION:
				return getAction();
			case StoryPackage.SCENARIO__OUTCOME:
				return getOutcome();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoryPackage.SCENARIO__ID:
				setId((String)newValue);
				return;
			case StoryPackage.SCENARIO__NAME:
				setName((String)newValue);
				return;
			case StoryPackage.SCENARIO__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case StoryPackage.SCENARIO__CONTEXT:
				setContext((String)newValue);
				return;
			case StoryPackage.SCENARIO__ACTION:
				setAction((String)newValue);
				return;
			case StoryPackage.SCENARIO__OUTCOME:
				setOutcome((String)newValue);
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
			case StoryPackage.SCENARIO__ID:
				setId(ID_EDEFAULT);
				return;
			case StoryPackage.SCENARIO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StoryPackage.SCENARIO__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case StoryPackage.SCENARIO__CONTEXT:
				setContext(CONTEXT_EDEFAULT);
				return;
			case StoryPackage.SCENARIO__ACTION:
				setAction(ACTION_EDEFAULT);
				return;
			case StoryPackage.SCENARIO__OUTCOME:
				setOutcome(OUTCOME_EDEFAULT);
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
			case StoryPackage.SCENARIO__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case StoryPackage.SCENARIO__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case StoryPackage.SCENARIO__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case StoryPackage.SCENARIO__CONTEXT:
				return CONTEXT_EDEFAULT == null ? getContext() != null : !CONTEXT_EDEFAULT.equals(getContext());
			case StoryPackage.SCENARIO__ACTION:
				return ACTION_EDEFAULT == null ? getAction() != null : !ACTION_EDEFAULT.equals(getAction());
			case StoryPackage.SCENARIO__OUTCOME:
				return OUTCOME_EDEFAULT == null ? getOutcome() != null : !OUTCOME_EDEFAULT.equals(getOutcome());
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
			case StoryPackage.SCENARIO___VALIDATE__DIAGNOSTICCHAIN_MAP:
				return validate((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ScenarioImpl
