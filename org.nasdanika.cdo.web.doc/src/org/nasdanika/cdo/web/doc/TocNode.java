package org.nasdanika.cdo.web.doc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TocNode {	
	
	public interface TocNodeVisitor {
		
		void visit(TocNode tocNode);
		
	}

	private String text;
	private String href;
	private String icon;
	private TocNode parent;
	private List<TocNode> children = new ArrayList<>();
	private AtomicLong counter;
	private String id;
	
	public String getHref() {
		return href;
	}
	
	public String getText() {
		return text;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public String getId() {
		return id;
	}

	protected TocNode(String text, String href, String icon, AtomicLong counter) {
		this.text = text;
		this.href = href;
		this.icon = icon;
		this.counter = counter;
		this.id = "n_"+Long.toString(counter.incrementAndGet(), Character.MAX_RADIX);
	}
		
	public TocNode(String text, String href, String icon) {
		this(text, href, icon, new AtomicLong());
	}
	
	public List<TocNode> getChildren() {
		return children;
	}
	
	public TocNode createChild(String text, String href, String icon) {
		TocNode child = new TocNode(text, href, icon, counter);
		children.add(child);
		child.parent = this;
		return child;
	}
	
	public List<TocNode> getPath() {
		List<TocNode> ret = parent==null ? new ArrayList<TocNode>() : parent.getPath();
		ret.add(this);
		return ret;
	}
	
	public TocNode find(String href) {
		if (this.href!=null && this.href.equals(href)) {
			return this;
		}
		for (TocNode child: children) {
			TocNode ret = child.find(href);
			if (ret!=null) {
				return ret;
			}
		}
		return null;
	}
	
	public JSONObject toJSON(String contextURL) throws JSONException {
		JSONObject ret = new JSONObject();
		if (text!=null) {
			ret.put("text", text);
		}
		if (icon!=null) {
			ret.put("icon", contextURL+icon);
		}
//		if (href!=null) {
//			ret.put("href", href);
//		}
		ret.put("id", id);
		JSONArray jsonChildren = new JSONArray();
		for (TocNode child: children) {
			JSONObject jsonChild = child.toJSON(contextURL);
			if (jsonChild!=null) {
				jsonChildren.put(jsonChild);
			}
		}
		if (jsonChildren.length()>0) {
			ret.put("children", jsonChildren);
		}
		return ret;
	}

	void accept(TocNodeVisitor visitor) {
		visitor.visit(this);
		for (TocNode child: children) {
			child.accept(visitor);
		}
	}
}
