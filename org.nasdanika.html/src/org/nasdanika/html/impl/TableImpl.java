package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Table;

class TableImpl extends UIElementImpl<Table> implements Table {
	
	class RowImpl extends UIElementImpl<Row> implements Row {
		
		private List<Cell> cells = new ArrayList<>();
		
		class CellImpl extends UIElementImpl<Cell> implements Cell {
			
			private String data;
			private boolean isHeader;

			CellImpl(String data, boolean isHeader) {
				this.data = data;
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
				if (data==null) {
					return "<"+tagName+" "+attributes()+"/>";
				}
				return "<"+tagName+attributes()+">"+data+"</"+tagName+">";
			}
			
		}

		@Override
		public Cell td(String data) {
			CellImpl cell = new CellImpl(data, false);
			cells.add(cell);
			return cell;
		}

		@Override
		public Cell th(String data) {
			CellImpl cell = new CellImpl(data, true);
			cells.add(cell);
			return cell;
		}

		@Override
		public Row style(org.nasdanika.html.UIElement.Style style) {
			return attribute("class", Style.PRIMARY.equals(style) ? "active" : style.name().toLowerCase());
		}
		
		@Override
		public String toString() {
			StringBuilder ret = new StringBuilder("<tr"+attributes()+">");
			for (Cell cell: cells) {
				ret.append(cell.toString());
			}
			ret.append("</tr>");
			return ret.toString();
		}
		
	}
	
	private List<Row> rows = new ArrayList<>();
	private boolean bordered;
	private boolean hover;
	private boolean striped;
	private boolean condensed;
	private boolean responsive;

	@Override
	public Row tr() {
		Row row = new RowImpl();
		rows.add(row);
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
		for (Row row: rows) {
			ret.append(row.toString());
		}
		ret.append("</table>");
		if (responsive) {
			ret.append("</div>");
		}
		return ret.toString();
	}

}
