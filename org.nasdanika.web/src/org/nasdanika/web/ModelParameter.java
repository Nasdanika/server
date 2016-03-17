package org.nasdanika.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.servlet.http.HttpServletRequest;

import org.nasdanika.core.CoreUtil;

/**
 * Arguments for parameters with this annotation are injected with values from request parameters.
 
 * If parameter type is a subtype of EObject, then argument value is provided in the following way:
 * a) Session package registry is searched for a package/factory which can instantiate the parameter type.
 * b) The factory is used to instantiate the type.
 * c) Request parameters are injected into features with names matching request parameters names. 
 * If a feature is a non-containing reference, then values shall be strings representing CDOID's. 
 * For containing references parameter values shall be in dotted notation hierarchy form, e.g. accounts.number.
 * 
 * <P/>
 * Otherwise parameter type is instantiated with a zero-arguments constructor and then request parameters are injected
 * using {@link CoreUtil}.injectProperty() method.
 *   
 * @author Pavel
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ModelParameter {
		
}
