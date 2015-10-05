package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.KnockoutVirtualElement;

class KnockoutVirtualElementImpl implements KnockoutVirtualElement {

	
	private List<Object> content = new ArrayList<>();
	private HTMLFactory factory;
	private String binding;
	private Object expression;

	KnockoutVirtualElementImpl(HTMLFactory factory, Object... content) {
		this.factory = factory;
		for (Object c: content) {
			this.content.add(c);
		}
	}
		
	protected List<Object> getContent() {
		return content;
	}
	
	@Override
	public KnockoutVirtualElement if_(Object expression) {
		return bind("if", expression);
	}

	@Override
	public KnockoutVirtualElement ifnot(Object expression) {
		return bind("ifnot", expression);
	}

	@Override
	public KnockoutVirtualElement with(Object expression) {
		return bind("with", expression);
	}

	@Override
	public KnockoutVirtualElement component(Object expression) {
		return bind("component", expression);
	}
	
	@Override
	public KnockoutVirtualElement foreach(Object expression) {
		return bind("foreach", expression);
	}

	@Override
	public KnockoutVirtualElement bind(String binding, Object expression) {
		this.binding = binding;
		this.expression = expression;
		return this;
	}

	@Override
	public KnockoutVirtualElement content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return this;
	}

	@Override
	public void close() throws Exception {
		if (expression instanceof AutoCloseable) {
			((AutoCloseable) expression).close();
		}
		for (Object c: getContent()) {
			if (c instanceof AutoCloseable) {
				((AutoCloseable) c).close();
			}
		}
	}
		
	@Override
	public String produce() {		
		List<Object> theContent = getContent();
		
		StringBuilder sb = new StringBuilder("<!-- ko ")
				.append(binding)
				.append(": ")
				.append(UIElementImpl.stringify(expression, factory))
				.append(" -->")
				.append(System.lineSeparator());
		
		for (Object c: theContent) {
			sb.append(UIElementImpl.stringify(c, factory));
		}
		return sb.append(System.lineSeparator()).append("<!-- /ko -->").toString();
	}
	
	/**
	 * Fallback for situations with missed refactorings of append().
	 */
	@Override
	public String toString() {
		return UIElementImpl.stringify(produce(), factory);
	}	

}
