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

	public T background(org.nasdanika.html.UIElement.BootstrapColor backgroundColor) {
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

	public T ngApp() {
		return target.ngApp();
	}

	public T ngApp(Object appName) {
		return target.ngApp(appName);
	}

	public T ngController(Object controllerName) {
		return target.ngController(controllerName);
	}

	public T ngHide(Object expr) {
		return target.ngHide(expr);
	}

	public T ngShow(Object expr) {
		return target.ngShow(expr);
	}

	public T ngRepeat(Object expr) {
		return target.ngRepeat(expr);
	}

	public T ngClass(Object expr) {
		return target.ngClass(expr);
	}

	public T ngCloak() {
		return target.ngCloak();
	}

	public T ngBind(Object expr) {
		return target.ngBind(expr);
	}

	public T ngBindHtml(Object expr) {
		return target.ngBindHtml(expr);
	}

	public T ngClick(Object expr) {
		return target.ngClick(expr);
	}

	public FontAwesome<T> fontAwesome() {
		return target.fontAwesome();
	}

	public T koDataBind(String name, Object value) {
		return target.koDataBind(name, value);
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
	public Grid<T> grid() {
		return target.grid();
	}

}
