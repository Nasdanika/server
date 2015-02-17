package org.nasdanika.function;

import java.util.Map;

import org.nasdanika.core.Context;

/**
 * @author Pavel Vlasov
 *
 */
public interface Participant {
	
	/**
	 * @return Input names mapped to input types.
	 */
	Map<String, Class<?>> getInputInfo();
	
	/**
	 * @return Bindings (outputs) names mapped to binding types.
	 */
	Map<String, Class<?>> getBindingInfo();
	
	/**
	 * @param inputName
	 * @param context
	 * @param bindings
	 * @return Returns participant input to use in a given context with given bindings.
	 */
	Object getInput(String inputName, Context context, Map<String, Object> bindings);
	
	/**
	 * Returns input to the participant allowing the participant to release resources associated with 
	 * the input.
	 * @param input
	 */
	void ungetInput(Object input);

}
