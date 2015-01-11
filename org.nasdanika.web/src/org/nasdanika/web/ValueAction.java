package org.nasdanika.web;

/**
 * Action which wraps already computed value.
 * @author Pavel Vlasov
 *
 */
public class ValueAction implements Action {

	private Object value;
	private boolean closeValue;

	public ValueAction(Object value) {
		this(value, false);
	}

	public ValueAction(Object value, boolean closeValue) {
		this.value = value;
		this.closeValue = closeValue;				
	}
	
	@Override
	public void close() throws Exception {
		if (closeValue && value instanceof AutoCloseable) {
			((AutoCloseable) value).close();
		}
	}

	@Override
	public Object execute() throws Exception {
		return value;
	}
	
	public static Action wrap(Object value) {
		return value instanceof Action ? (Action) value : new ValueAction(value);
	}

}
