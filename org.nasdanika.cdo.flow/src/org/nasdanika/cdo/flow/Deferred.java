/**
 */
package org.nasdanika.cdo.flow;

import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deferred</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.Deferred#getState <em>State</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Deferred#getCreated <em>Created</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Deferred#getResolved <em>Resolved</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Deferred#getComment <em>Comment</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Deferred#getResolution <em>Resolution</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Deferred#getThen <em>Then</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.Deferred#getThenDeferreds <em>Then Deferreds</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferred()
 * @model superTypes="org.nasdanika.cdo.flow.Promise<R, C> org.nasdanika.cdo.flow.Command<org.eclipse.emf.ecore.EJavaObject, C>" CBounds="org.nasdanika.cdo.flow.Context"
 * @generated
 */
public interface Deferred<R, C extends Context> extends Promise<R, C>, Command<Object, C> {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.nasdanika.cdo.flow.PromiseState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.nasdanika.cdo.flow.PromiseState
	 * @see #setState(PromiseState)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferred_State()
	 * @model
	 * @generated
	 */
	PromiseState getState();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Deferred#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.nasdanika.cdo.flow.PromiseState
	 * @see #getState()
	 * @generated
	 */
	void setState(PromiseState value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Date)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferred_Created()
	 * @model
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Deferred#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see #setResolved(Date)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferred_Resolved()
	 * @model
	 * @generated
	 */
	Date getResolved();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Deferred#getResolved <em>Resolved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved</em>' attribute.
	 * @see #getResolved()
	 * @generated
	 */
	void setResolved(Date value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferred_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Deferred#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Resolution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolution</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolution</em>' containment reference.
	 * @see #setResolution(EObject)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferred_Resolution()
	 * @model containment="true"
	 * @generated
	 */
	EObject getResolution();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Deferred#getResolution <em>Resolution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolution</em>' containment reference.
	 * @see #getResolution()
	 * @generated
	 */
	void setResolution(EObject value);

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(Then)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferred_Then()
	 * @model type="org.nasdanika.cdo.flow.Then<org.eclipse.emf.ecore.EJavaObject, R, C>" containment="true"
	 * @generated
	 */
	Then<Object, R, C> getThen();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Deferred#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(Then<Object, R, C> value);

	/**
	 * Returns the value of the '<em><b>Then Deferreds</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.flow.Deferred}&lt;?, C>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Deferreds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Deferreds</em>' containment reference list.
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferred_ThenDeferreds()
	 * @model containment="true"
	 * @generated
	 */
	EList<Deferred<?, C>> getThenDeferreds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model executorType="org.nasdanika.cdo.flow.Executor<C>"
	 * @generated
	 */
	void resolve(R value, C context, Executor<C> executor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model executorType="org.nasdanika.cdo.flow.Executor<C>"
	 * @generated
	 */
	void resolve(Promise<R, C> promise, C context, Executor<C> executor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model reasonDataType="org.nasdanika.cdo.flow.Exception" executorType="org.nasdanika.cdo.flow.Executor<C>"
	 * @generated
	 */
	void reject(Exception reason, C context, Executor<C> executor);

} // Deferred
