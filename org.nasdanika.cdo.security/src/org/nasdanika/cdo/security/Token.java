/**
 */
package org.nasdanika.cdo.security;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base class for application-specific tokens.
 * 
 * When TokenCredentials are passed to authenticate(), the default implementation in LoginsPasswordRealm takes the part 
 * of the token before the first dot and decodes it as CDOID. Then it gets an object by that ID and, if it is Token, returns it.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getToken()
 * @model abstract="true"
 *        annotation="org.nasdanika.cdo.web.render label='{{eclass-name}}' icon='fa fa-tag'"
 * @generated
 */
public interface Token extends Principal {

} // Token
