package org.nasdanika.cdo.web.doc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.core.CoreUtil;

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
	private String content;
	private String tocId;
			
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
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

	protected TocNode(
			String text, 
			String href, 
			String icon, 
			AtomicLong counter,
			String tocId) {
		this.text = text;
		this.href = href;
		this.icon = icon;
		this.counter = counter;
		this.id = "content_node_"+Long.toString(counter.incrementAndGet(), Character.MAX_RADIX);
		this.tocId = tocId;
		if (CoreUtil.isBlank(this.href)) {
			if (CoreUtil.isBlank(this.tocId)) {
				this.href = "/toc/"+this.id;
			} else {
				this.href = "/toc/"+this.tocId;				
			}
		}
	}
		
	public TocNode(String text, String href, String icon) {
		this(text, href, icon, new AtomicLong(), null);
	}

	public List<TocNode> getChildren() {
		return children;
	}
	
	public TocNode createChild(String text, String href, String icon, String tocId) {
		TocNode child = new TocNode(text, href, icon, counter, tocId);
		children.add(child);
		child.parent = this;
		return child;
	}
	
	public List<TocNode> getPath() {
		List<TocNode> ret = parent==null ? new ArrayList<TocNode>() : parent.getPath();
		ret.add(this);
		return ret;
	}
	
	public TocNode getParent() {
		return parent;
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
	
	public TocNode findByTocId(String tocId) {
		if (this.tocId!=null && this.tocId.equals(tocId)) {
			return this;
		}
		for (TocNode child: children) {
			TocNode ret = child.findByTocId(tocId);
			if (ret!=null) {
				return ret;
			}
		}
		return null;		
	}
	
	public JSONObject toJSON(String contextURL) throws Exception {
		JSONObject ret = new JSONObject();
		if (text!=null) {
			ret.put("text", text);
		}
		if (icon!=null) {
			ret.put("icon", contextURL+icon);
		}
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
	
	public static final Comparator<TocNode> NAME_COMPARATOR = new Comparator<TocNode>() {

		@Override
		public int compare(TocNode o1, TocNode o2) {
			if (o1==null || o1.getText()==null) {
				if (o2==null || o2.getText()==null) {
					return 0;
				}
				return 1;
			}
			if (o2==null || o2.getText()==null) {
				return -1;
			}
			return o1.getText().compareTo(o2.getText());
		}
	};	

	public void sort(boolean recursive) {
		Collections.sort(children, NAME_COMPARATOR);
		if (recursive) {
			for (TocNode child: children) {
				child.sort(recursive);
			}
		}
	}
}
