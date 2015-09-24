package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.nasdanika.html.Button;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Modal;
import org.nasdanika.html.Tag;

class ModalImpl extends UIElementImpl<Modal> implements Modal {

	private Tag contentDiv = new TagImpl(factory, "div") {

		protected List<Object> getContent() {
			List<Object> ret = new ArrayList<>();
			if (title!=null) {
				ret.add(factory.div("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>")
						.addClass("modal-header")
						.content(factory.tag(TagName.h4, title).addClass("modal-title")));
			}
			if (body!=null) {
				ret.add(factory.div(body).addClass("modal-body"));
			}
			if (footer!=null) {
				ret.add(factory.div(footer).addClass("modal-footer"));
			}
			return ret;
		};
		
	}.addClass("modal-content");
	
	private Object[] title;
	private Object[] body;
	private boolean large;
	private boolean small;
	private Object[] footer;
	
	ModalImpl(HTMLFactory factory) {
		super(factory);
		addClass("modal", "fade");
		id(factory.nextId());
	}

	@Override
	public void close() throws Exception {
		super.close();
		close(title);
		close(body);
		close(footer);
	}

	@Override
	public Modal title(Object... content) {
		this.title = content;
		return this;
	}

	@Override
	public Modal body(Object... content) {
		this.body = content;
		return this;
	}

	@Override
	public Modal footer(Object... content) {
		this.footer = content;
		return this;
	}

	@Override
	public Modal large() {
		large = true;
		return this;
	}

	@Override
	public Modal small() {
		small = true;
		return this;
	}
	
	@Override
	public String toHTML() {		
		StringBuilder sb = new StringBuilder(renderComment()).append("<div").append(attributes()).append(">");
		Tag dialogDiv = factory.div(contentDiv).addClass("modal-dialog");
		if (large) {
			dialogDiv.addClass("modal-lg");
		} else if (small) {
			dialogDiv.addClass("modal-sm");
		}
		sb.append(dialogDiv.toHTML());
		return sb.append("</").append("div").append(">").append(genLoadRemoteContentScript()).toString();
	}

	@Override
	public Options options() {
		return new Options() {
			
			private Object backdrop;
			private Boolean keyboard;
			private Boolean show;
			private Object path;

			@Override
			public Options backdrop(boolean backdrop) {
				this.backdrop = backdrop;
				return this;
			}

			@Override
			public Options staticBackdrop() {
				this.backdrop = "static";
				return this;
			}

			@Override
			public Options keyboard(boolean keyboard) {
				this.keyboard = keyboard;
				return this;
			}

			@Override
			public Options show(boolean show) {
				this.show = show;
				return this;
			}

			@Override
			public Options remote(Object path) {
				this.path = path;
				return this;
			}
			
			@Override
			public String toString() {
				try {
					JSONObject jObj = new JSONObject();
					if (backdrop!=null) {
							jObj.put("backdrop", backdrop);
					}
					if (keyboard!=null) {
						jObj.put("keyboard", keyboard);						
					}
					if (path!=null) {
						jObj.put("remote", path);						
					}
					if (show!=null) {
						jObj.put("show", show);						
					}
					return jObj.toString();
				} catch (JSONException e) {
					return "{}";
				}
			}
			
		};
	}

	@Override
	public Button bind(Button button) {
		return button
				.attribute("data-toggle", "modal")
				.attribute("data-target", "#"+getId());	
	}

}
