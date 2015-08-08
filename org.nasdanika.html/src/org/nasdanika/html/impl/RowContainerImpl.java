package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer;
import org.nasdanika.html.Table;

class RowContainerImpl<T extends RowContainer<T>> extends UIElementImpl<T> implements RowContainer<T> {
	
	private String tagName;

	RowContainerImpl(HTMLFactory factory, String tagName) {
		super(factory);
		this.tagName = tagName;
	}

	class RowImpl extends UIElementImpl<Row> implements Row {
		
		RowImpl() {
			super(RowContainerImpl.this.factory);
		}
		
		private List<Object> content = new ArrayList<>();
		
		class CellImpl extends UIElementImpl<Cell> implements Cell {
			
			private boolean isHeader;

			CellImpl(boolean isHeader, Object... content) {
				super(RowContainerImpl.this.factory);
				content(content);
				this.isHeader = isHeader;
			}

			@Override
			public Cell colspan(int colspan) {
				return attribute("colspan", String.valueOf(colspan));
			}

			@Override
			public Cell rowspan(int rowspan) {
				return attribute("rowspan", String.valueOf(rowspan));
			}
			
			@Override
			public String toString() {
				String tagName = isHeader ? "th" : "td";
				if (content.isEmpty()) {
					return "<"+tagName+" "+attributes()+"/>";
				}				
				StringBuilder sb = new StringBuilder("<").append(tagName).append(attributes()).append(">");
				for (Object c: content) {
					sb.append(c);
				}
				return sb.append("</").append(tagName).append(">").append(genLoadRemoteContentScript()).toString();
			}
			
			private List<Object> content = new ArrayList<>();

			@Override
			public void close() throws Exception {
				super.close();
				for (Object c: content) {
					close(c);
				}
			}

			@Override
			public Cell content(Object... content) {
				for (Object c: content) {
					this.content.add(c);
				}
				return this;
			}
			
		}

		@Override
		public Cell cell(Object... content) {
			CellImpl cell = new CellImpl(false, content);
			this.content.add(cell);
			return cell;
		}

		@Override
		public Cell header(Object... content) {
			CellImpl cell = new CellImpl(true, content);
			this.content.add(cell);
			return cell;
		}

		@Override
		public Row style(org.nasdanika.html.UIElement.Style style) {
			return attribute("class", Style.PRIMARY.equals(style) ? "active" : style.name().toLowerCase());
		}
		
		@Override
		public String toString() {
			StringBuilder ret = new StringBuilder("<tr"+attributes()+">");
			for (Object c: content) {
				if (c!=null) {
					ret.append(c);
				}
			}
			ret.append("</tr>");
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
		public List<Cell> cells() {
			List<Cell> cells = new ArrayList<>();
			for (Object c: content) {
				if (c instanceof Cell) {
					cells.add((Cell) c);
				}
			}
			return cells;
		}

		@Override
		public Row content(Object... content) {
			for (Object c: content) {
				this.content.add(c);
			}
			return this;
		}
		
	}
	
	protected List<Object> content = new ArrayList<>();

	@Override
	public Row row() {
		Row row = new RowImpl();
		content.add(row);
		return row;
	}
	
	@Override
	public String toString() {		
		if (content.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder("<").append(tagName).append(attributes()).append(">");
		for (Object c: content) {
			try {
				sb.append(TagImpl.renderContent(c));
			} catch (Exception e) {
				sb.append(e.toString());
			}
		}
		return sb.append("</").append(tagName).append(">").append(genLoadRemoteContentScript()).toString();
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

	@SuppressWarnings("unchecked")
	@Override
	public T content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return (T) this;
	}

}
