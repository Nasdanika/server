/**
 */
package org.nasdanika.webtest.performance;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Timing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.webtest.performance.ResourceTiming#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.ResourceTiming#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.ResourceTiming#getEntryType <em>Entry Type</em>}</li>
 *   <li>{@link org.nasdanika.webtest.performance.ResourceTiming#getInitiatorType <em>Initiator Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.webtest.performance.PerformancePackage#getResourceTiming()
 * @model
 * @generated
 */
public interface ResourceTiming extends TimingBase {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(double)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getResourceTiming_Duration()
	 * @model
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.ResourceTiming#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(double value);

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(double)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getResourceTiming_StartTime()
	 * @model
	 * @generated
	 */
	double getStartTime();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.ResourceTiming#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(double value);

	/**
	 * Returns the value of the '<em><b>Entry Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Type</em>' attribute.
	 * @see #setEntryType(String)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getResourceTiming_EntryType()
	 * @model
	 * @generated
	 */
	String getEntryType();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.ResourceTiming#getEntryType <em>Entry Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Type</em>' attribute.
	 * @see #getEntryType()
	 * @generated
	 */
	void setEntryType(String value);

	/**
	 * Returns the value of the '<em><b>Initiator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiator Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiator Type</em>' attribute.
	 * @see #setInitiatorType(String)
	 * @see org.nasdanika.webtest.performance.PerformancePackage#getResourceTiming_InitiatorType()
	 * @model
	 * @generated
	 */
	String getInitiatorType();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.performance.ResourceTiming#getInitiatorType <em>Initiator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initiator Type</em>' attribute.
	 * @see #getInitiatorType()
	 * @generated
	 */
	void setInitiatorType(String value);

} // ResourceTiming
