package org.nasdanika.html.impl;

import org.nasdanika.html.FormGroup;
import org.nasdanika.html.UIElement;

class FormGroupImpl<T extends FormGroup<?>, C> extends UIElementImpl<T> implements FormGroup<T> {
	
	private String label;
	private String controlId;
	protected C control;
	private boolean feedback;
	private Status status;
	private FormImpl form;
	private String helpText;

	FormGroupImpl(FormImpl form, String label, String controlId, C control, String helpText) {
		this.form = form;
		this.label = label;
		this.controlId = controlId;
		this.control = control;	
		this.helpText = helpText;
		addClass("form-group");
	}

	@SuppressWarnings("unchecked")
	@Override
	public T feedback(boolean feedback) {
		this.feedback = feedback;
		return (T) this;
	}

	@Override
	public T feedback() {
		return feedback(true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T status(Status status) {
		this.status = status;
		return (T) this;
	}
	
	@Override
	public String toString() {
		if (status!=null) {
			addClass("has-"+status.name().toLowerCase());
		}
		if (feedback) {
			addClass("has-feedback");
		}
		StringBuilder sb = new StringBuilder("<div").append(attributes()).append(">");
		if (label!=null) {
			UIElement<?> labelTag = form.builder.tag("label", label).attribute("for", controlId);
			if (form.inline) {
				labelTag.addClass("sr-only");
			}
			if (form.horizontal) {
				labelTag.addClass("col-"+form.deviceSize.code+"-"+form.labelWidth);
				labelTag.addClass("control-label");
			}
			sb.append(labelTag);
		}
		if (form.horizontal) {
			UIElement<?> controlDiv = form.builder.tag("div", control.toString());
			controlDiv.addClass("col-"+form.deviceSize.code+"-"+(12-form.labelWidth));
			if (label==null) {
				controlDiv.addClass("col-"+form.deviceSize.code+"-offset-"+form.labelWidth);
			}
			sb.append(controlDiv);
		} else {
			sb.append(control);
		}
		if (feedback && status!=null) {
			UIElement<?> feedbackSpan = form.builder.tag("span", "").addClass("glyphicon");
			switch (status) {
			case ERROR:
				feedbackSpan.addClass("glyphicon-remove");
				break;
			case SUCCESS:
				feedbackSpan.addClass("glyphicon-ok");
				break;
			case WARNING:
				feedbackSpan.addClass("glyphicon-warning-sign");
				break;
			default:
				break;			
			}
			feedbackSpan.addClass("form-control-feedback");
			sb.append(feedbackSpan);
		}
		if (helpText!=null && !form.horizontal && !form.inline) {
			sb.append(form.builder.tag("p", helpText).addClass("help-block"));			
		}
		sb.append("</div>");
		return sb.toString();
	}
	
}