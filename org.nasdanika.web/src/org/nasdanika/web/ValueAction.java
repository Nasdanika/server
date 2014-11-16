package org.nasdanika.web;

/**
 * Action which wraps already computed value.
 * @author Pavel Vlasov
 *
 */
public class ValueAction implements Action {

	private Object value;

	public ValueAction(Object value) {
		this.value = value;
	}

	@Override
	public void close() throws Exception {
		// NOP
	}

	@Override
	public Object execute() throws Exception {
		return value;
	}
	
	public static Action wrap(Object value) {
		return value instanceof Action ? (Action) value : new ValueAction(value);
	}

}
