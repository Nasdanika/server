package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer;
import org.nasdanika.html.Table;

class TableImpl extends RowContainerImpl<Table> implements Table {
	
	TableImpl(HTMLFactory factory) {
		super(factory, "table");
	}

	private boolean bordered;
	private boolean hover;
	private boolean striped;
	private boolean condensed;
	private boolean responsive;

	@Override
	public Row row() {
		Row row = new RowImpl();
		content.add(row);
		return row;
	}

	@Override
	public Table bordered(boolean bordered) {
		this.bordered = bordered;
		return this;
	}

	@Override
	public Table hover(boolean hover) {
		this.hover = hover;
		return this;
	}

	@Override
	public Table striped(boolean striped) {
		this.striped = striped;
		return this;
	}

	@Override
	public Table condensed(boolean condensed) {
		this.condensed = condensed;
		return this;
	}

	@Override
	public Table responsive(boolean responsive) {
		this.responsive = responsive;
		return this;
	}

	@Override
	public Table bordered() {
		return bordered(true);
	}

	@Override
	public Table hover() {
		return hover(true);
	}

	@Override
	public Table striped() {
		return striped(true);
	}

	@Override
	public Table condensed() {
		return condensed(true);
	}

	@Override
	public Table responsive() {
		return responsive(true);
	}
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		if (responsive) {
			ret.append("<div class=\"table-responsive\">");
		}
		
		ret.append("<table class=\"table");
		if (bordered) {
			ret.append(" table-bordered");
		}
		if (striped) {
			ret.append(" table-striped");
		}
		if (hover) {
			ret.append(" table-hover");
		}
		if (condensed) {
			ret.append(" table-condensed");
		}
		String mClass = merge("class");
		if (mClass.length()>0) {
			ret.append(" ");
			ret.append(mClass);
		}
		ret.append("\"");
		ret.append(attributes("class"));
		ret.append(">");
		for (Object c: content) {
			if (c!=null) {
				ret.append(c);
			}
		}
		ret.append("</table>");
		if (responsive) {
			ret.append("</div>");
		}
		return ret.append(genLoadRemoteContentScript()).toString();
	}
	
	@Override
	public void close() throws Exception {
		super.close();
		for (Object c: content) {
			close(c);
		}		
	}

	@Override
	public List<Row> rows() {
		List<Row> rows = new ArrayList<>();
		for (Object c: content) {
			if (c instanceof Row) {
				rows.add((Row) c);
			}
		}
		return rows;
	}

	@Override
	public Table content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return this;
	}
	
	private RowContainer<?> header;
	private RowContainer<?> body;
	private RowContainer<?> footer;	

	@Override
	public RowContainer<?> header() {
		if (header == null) {
			header = new RowContainerImpl<>(factory, "thead");
			content.add(header);
		}
		
		return header;
	}

	@Override
	public RowContainer<?> body() {
		if (body == null) {
			body = new RowContainerImpl<>(factory, "tbody");
			content.add(body);
		}
		
		return body;
	}

	@Override
	public RowContainer<?> footer() {
		if (footer == null) {
			footer = new RowContainerImpl<>(factory, "tfoot");
			content.add(footer);
		}
		
		return footer;
	}

}
