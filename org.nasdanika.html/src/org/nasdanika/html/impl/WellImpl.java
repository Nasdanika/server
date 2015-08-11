package org.nasdanika.html.impl;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Well;

class WellImpl extends UIElementImpl<Well> implements Well {

	private Tag div;
	
	WellImpl(HTMLFactory factory, Object[] content) {
		super(factory);
		div = factory.div(content).addClass("well");
	}
	
	@Override
	public Well content(Object... content) {
		div.content(content);
		return this;
	}
	
	@Override
	public Well small() {
		div.addClass("well-sm");
		return this;
	}
	
	@Override
	public Well large() {
		div.addClass("well-lg");
		return this;
	}
	
	@Override
	public String toString() {	
		return div.toString();
	}

	@Override
	public void close() throws Exception {
		super.close();
		div.close();
	}

}
