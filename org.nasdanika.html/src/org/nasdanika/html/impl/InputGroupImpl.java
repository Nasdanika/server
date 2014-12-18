package org.nasdanika.html.impl;

import java.util.Map;

import org.json.JSONObject;
import org.nasdanika.html.Button;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Input;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.HTMLFactory.Placement;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.InputGroup;

class InputGroupImpl extends UIElementImpl<InputGroup<?>> implements InputGroup<InputGroup<?>> {

	private Object leftAddOn;
	private Object rightAddOn;
	private Object control;
	private StringBuilder initScript = new StringBuilder();

	InputGroupImpl(HTMLFactory factory, Object control) {
		super(factory);
		this.control = control;
		if (control instanceof Input) {
			((Input) control).addClass("form-control");
		}		
		addClass("input-group");
	}
	
	@Override
	public InputGroup<?> size(Size size) {
		addClass("input-group-"+size.code);
		return this;
	}

	@Override
	public InputGroup<?> leftAddOn(Object... addOn) {
		if (leftAddOn!=null) {
			throw new IllegalStateException("Left add-on has already been set");
		}
		this.leftAddOn = new FragmentImpl(addOn);
		return this;
	}

	@Override
	public Button leftButton(Object... content) {
		if (leftAddOn!=null) {
			throw new IllegalStateException("Left add-on has already been set");
		}
		this.leftAddOn = new ButtonImpl(factory, true, content);
		return (Button) leftAddOn;
	}

	@Override
	public InputGroup<?> rightAddOn(Object... addOn) {
		if (rightAddOn!=null) {
			throw new IllegalStateException("Right add-on has already been set");
		}
		this.rightAddOn = new FragmentImpl(addOn);
		return this;
	}

	@Override
	public Button rightButton(Object... content) {
		if (rightAddOn!=null) {
			throw new IllegalStateException("Right add-on has already been set");
		}
		this.rightAddOn = new ButtonImpl(factory, true, content);
		return (Button) rightAddOn;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<div");
		sb.append(attributes());
		sb.append(">");
		if (leftAddOn instanceof Button) {
			sb.append(leftAddOn);
		} else if (leftAddOn!=null) {
			sb.append(factory.span(leftAddOn).addClass("input-group-addon"));
		}
		
		sb.append(control);

		if (rightAddOn instanceof Button) {
			sb.append(rightAddOn);
		} else if (rightAddOn!=null) {
			sb.append(factory.span(rightAddOn).addClass("input-group-addon"));
		} 	
		sb.append("</div>");
		if (initScript.length()>0) {
			sb.append(factory.tag(TagName.script, initScript));
		}
		return sb.append(genLoadRemoteContentScript()).toString();
		
	}

	@Override
	public void close() throws Exception {
		super.close();
		close(control);
		close(leftAddOn);
		close(rightAddOn);	
	}

	@Override
	public Button leftPopoverHelpButton(Placement placement, String title, String body, Map<String, Object> options) {
		Button ret = leftButton(factory.glyphicon(Glyphicon.question_sign)).id(factory.nextId());
		factory.popover(ret, placement, title, body);
		String opts = options==null ? "" : new JSONObject(options).toString();		
		initScript.append("$(\"#"+ret.getId()+"\").popover("+opts+");");
		return ret;
	}

	@Override
	public Button rightPopoverHelpButton(Placement placement, String title, String body, Map<String, Object> options) {
		Button ret = rightButton(factory.glyphicon(Glyphicon.question_sign)).id(factory.nextId());
		factory.popover(ret, placement, title, body);
		String opts = options==null ? "" : new JSONObject(options).toString();		
		initScript.append("$(\"#"+ret.getId()+"\").popover("+opts+");");
		return ret;
	}
}
