/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Screenshot Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Screenshot entry is an association class between operation result and a screenshot.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.ScreenshotEntry#getType <em>Type</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.ScreenshotEntry#getComment <em>Comment</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.ScreenshotEntry#getScreenshot <em>Screenshot</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.ScreenshotEntry#getSeqNo <em>Seq No</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getScreenshotEntry()
 * @model
 * @generated
 */
public interface ScreenshotEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.nasdanika.webtest.model.ScreenshotType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates when screenshot was taken.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.nasdanika.webtest.model.ScreenshotType
	 * @see #setType(ScreenshotType)
	 * @see org.nasdanika.webtest.model.ModelPackage#getScreenshotEntry_Type()
	 * @model
	 * @generated
	 */
	ScreenshotType getType();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.ScreenshotEntry#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.nasdanika.webtest.model.ScreenshotType
	 * @see #getType()
	 * @generated
	 */
	void setType(ScreenshotType value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment for explicitly taken screenshots.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.nasdanika.webtest.model.ModelPackage#getScreenshotEntry_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.ScreenshotEntry#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Screenshot</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.webtest.model.Screenshot#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Screenshot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to a screenshot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Screenshot</em>' reference.
	 * @see #setScreenshot(Screenshot)
	 * @see org.nasdanika.webtest.model.ModelPackage#getScreenshotEntry_Screenshot()
	 * @see org.nasdanika.webtest.model.Screenshot#getEntries
	 * @model opposite="entries"
	 * @generated
	 */
	Screenshot getScreenshot();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.ScreenshotEntry#getScreenshot <em>Screenshot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Screenshot</em>' reference.
	 * @see #getScreenshot()
	 * @generated
	 */
	void setScreenshot(Screenshot value);

	/**
	 * Returns the value of the '<em><b>Seq No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seq No</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seq No</em>' attribute.
	 * @see #setSeqNo(int)
	 * @see org.nasdanika.webtest.model.ModelPackage#getScreenshotEntry_SeqNo()
	 * @model
	 * @generated
	 */
	int getSeqNo();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.ScreenshotEntry#getSeqNo <em>Seq No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seq No</em>' attribute.
	 * @see #getSeqNo()
	 * @generated
	 */
	void setSeqNo(int value);

} // ScreenshotEntry
