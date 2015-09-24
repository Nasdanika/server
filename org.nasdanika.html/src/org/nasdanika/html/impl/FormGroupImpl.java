package org.nasdanika.html.impl;

import org.nasdanika.html.FormGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.InputBase;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement;

class FormGroupImpl<T extends FormGroup<T>, C> extends UIElementImpl<T> implements FormGroup<T> {
	
	private Object label;
	private Object controlId;
	protected C control;
	private boolean feedback;
	private Status status;
	private FormImpl form;
	private Object helpText;

	FormGroupImpl(HTMLFactory factory, FormImpl form, Object label, Object controlId, C control, Object helpText) {
		super(factory);
		this.form = form;
		this.label = label;
		this.controlId = controlId;
		this.control = control;	
		if (control instanceof InputBase) {
			((InputBase<?>) control).addClass("form-control");
		}
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
	public String toHTML() {
		if (status!=null) {
			addClass("has-"+status.name().toLowerCase());
		}
		if (feedback) {
			addClass("has-feedback");
		}
		StringBuilder sb = new StringBuilder(renderComment()).append("<div").append(attributes()).append(">");
		if (label!=null) {
			UIElement<?> labelTag = form.factory.tag(TagName.label, label).attribute("for", String.valueOf(controlId));
			if (form.inline) {
				labelTag.addClass("sr-only");
			}
			if (form.horizontal) {
				labelTag.addClass("col-"+form.deviceSize.code+"-"+form.labelWidth);
				labelTag.addClass("control-label");
			}
			sb.append(labelTag.toHTML());
			sb.append(" ");
		}
		if (form.horizontal) {
			UIElement<?> controlDiv = form.factory.div(toHTML(control));
			controlDiv.addClass("col-"+form.deviceSize.code+"-"+(12-form.labelWidth));
			if (label==null) {
				controlDiv.addClass("col-"+form.deviceSize.code+"-offset-"+form.labelWidth);
			}
			sb.append(controlDiv.toHTML());
		} else {
			sb.append(toHTML(control));
		}
		if (feedback && status!=null) {
			Tag feedbackSpan = null;
			switch (status) {
			case ERROR:
				feedbackSpan = form.factory.glyphicon(Glyphicon.remove);
				break;
			case SUCCESS:
				feedbackSpan = form.factory.glyphicon(Glyphicon.ok);
				break;
			case WARNING:
				feedbackSpan = form.factory.glyphicon(Glyphicon.warning_sign);
				break;
			default:
				break;			
			}
			if (feedbackSpan!=null) {
				feedbackSpan.addClass("form-control-feedback");
				sb.append(feedbackSpan.toHTML());
			}
		}
		if (helpText!=null && !form.horizontal && !form.inline) {
			sb.append(form.factory.tag(TagName.p, helpText).addClass("help-block"));			
		}
		sb.append("</div>");
		return sb.append(genLoadRemoteContentScript()).toString();
	}

	@Override
	public void close() throws Exception {
		super.close();
		close(control);
		close(controlId);
		close(helpText);
		close(label);		
	}
	
}