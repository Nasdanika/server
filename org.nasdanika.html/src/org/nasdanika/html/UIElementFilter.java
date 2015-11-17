package org.nasdanika.html;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class UIElementFilter<T extends UIElement<T>> implements UIElement<T> {

	public void close() throws Exception {
		target.close();
	}

	public T on(org.nasdanika.html.UIElement.Event event, Object handler) {
		return target.on(event, handler);
	}

	public T on(String event, Object handler) {
		return target.on(event, handler);
	}

	public T on(org.nasdanika.html.UIElement.Event event, Reader handler) throws IOException {
		return target.on(event, handler);
	}

	public T on(String event, Reader handler) throws IOException {
		return target.on(event, handler);
	}

	public T on(org.nasdanika.html.UIElement.Event event, InputStream handler) throws IOException {
		return target.on(event, handler);
	}

	public T on(String event, InputStream handler) throws IOException {
		return target.on(event, handler);
	}

	public T background(org.nasdanika.html.Bootstrap.Color backgroundColor) {
		return target.background(backgroundColor);
	}

	public T background(org.nasdanika.html.UIElement.HTMLColor backgroundColor) {
		return target.background(backgroundColor);
	}

	public T id(Object id) {
		return target.id(id);
	}

	public Object getId() {
		return target.getId();
	}

	public T attribute(String name, Object value) {
		return target.attribute(name, value);
	}

	public String getAttribute(String name) {
		return target.getAttribute(name);
	}

	public T style(String name, Object value) {
		return target.style(name, value);
	}

	public T addClass(Object... clazz) {
		return target.addClass(clazz);
	}

	public T remoteContent(Object href) {
		return target.remoteContent(href);
	}
	
	@Override
	public Angular<T> angular() {
		return target.angular();
	}

	public FontAwesome<T> fontAwesome() {
		return target.fontAwesome();
	}
	
	@Override
	public Knockout<T> knockout() {
		return target.knockout();
	}

	private T target;

	public UIElementFilter(T target) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return target.toString();
	}
	
	@Override
	public Bootstrap<T> bootstrap() {
		return target.bootstrap();
	}

	@Override
	public T comment(String comment) {
		return target.comment(comment);
	}

	@Override
	public Object produce(int indent) {
		return target.produce(indent);
	}

}
