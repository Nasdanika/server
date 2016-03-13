/**
 */
package org.nasdanika.webtest.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.nasdanika.webtest.model.ActorMethodResult;
import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Method Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.ActorMethodResultImpl#getActorResult <em>Actor Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActorMethodResultImpl extends MethodResultImpl implements ActorMethodResult {
	/**
	 * The cached value of the '{@link #getActorResult() <em>Actor Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorResult()
	 * @generated
	 * @ordered
	 */
	protected ActorResult actorResult;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorMethodResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ACTOR_METHOD_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorResult getActorResult() {
		if (actorResult != null && actorResult.eIsProxy()) {
			InternalEObject oldActorResult = (InternalEObject)actorResult;
			actorResult = (ActorResult)eResolveProxy(oldActorResult);
			if (actorResult != oldActorResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT, oldActorResult, actorResult));
			}
		}
		return actorResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorResult basicGetActorResult() {
		return actorResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActorResult(ActorResult newActorResult, NotificationChain msgs) {
		ActorResult oldActorResult = actorResult;
		actorResult = newActorResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT, oldActorResult, newActorResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActorResult(ActorResult newActorResult) {
		if (newActorResult != actorResult) {
			NotificationChain msgs = null;
			if (actorResult != null)
				msgs = ((InternalEObject)actorResult).eInverseRemove(this, ModelPackage.ACTOR_RESULT__RESULTS, ActorResult.class, msgs);
			if (newActorResult != null)
				msgs = ((InternalEObject)newActorResult).eInverseAdd(this, ModelPackage.ACTOR_RESULT__RESULTS, ActorResult.class, msgs);
			msgs = basicSetActorResult(newActorResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT, newActorResult, newActorResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT:
				if (actorResult != null)
					msgs = ((InternalEObject)actorResult).eInverseRemove(this, ModelPackage.ACTOR_RESULT__RESULTS, ActorResult.class, msgs);
				return basicSetActorResult((ActorResult)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT:
				return basicSetActorResult(null, msgs);
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
			case ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT:
				if (resolve) return getActorResult();
				return basicGetActorResult();
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
			case ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT:
				setActorResult((ActorResult)newValue);
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
			case ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT:
				setActorResult((ActorResult)null);
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
			case ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT:
				return actorResult != null;
		}
		return super.eIsSet(featureID);
	}

} //ActorMethodResultImpl
