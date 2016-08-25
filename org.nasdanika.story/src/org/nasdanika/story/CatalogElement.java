/**
 */
package org.nasdanika.story;

import java.util.Map;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catalog Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base interface for model elements which can be added to a catalog.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.CatalogElement#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.story.CatalogElement#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.story.CatalogElement#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getCatalogElement()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface CatalogElement extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Catalog element identifier. The ID shall be unique for the element type in the
	 * containing resource, i.e. it is possible to have State and Scenario have the same ID,
	 * but two states or two scenarios shall not have duplicate ID's.
	 * 
	 * If catalog element ID contains ${parent} token then the token
	 * is expanded to the parent element ID. If the parent element's id is blank, then token expansion fails and the element ID with the parent token is also considered blank.                         
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.nasdanika.story.StoryPackage#getCatalogElement_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.CatalogElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.story.StoryPackage#getCatalogElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.CatalogElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element description. Supports markdown. Some catalog elements may hide description attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.nasdanika.story.StoryPackage#getCatalogElement_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.nasdanika.story.CatalogElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Validates element for execution/generation. Adds messages to diagnostics and 
	 * @param diagnostics Diagnostics to add validation messages to.
	 * @param context Validation context.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validate(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CatalogElement
