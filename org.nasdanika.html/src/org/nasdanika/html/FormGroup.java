package org.nasdanika.html;

public interface FormGroup<T extends FormGroup<?>> extends UIElement<T> {
	
	enum Status { SUCCESS, WARNING, ERROR }

	T status(FormGroup.Status status);
	
	T feedback(boolean feedback);
	
	T feedback();
	
}