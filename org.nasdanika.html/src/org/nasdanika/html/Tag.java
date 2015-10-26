package org.nasdanika.html;

/**
 * A generic UI element. It doesn't add any functionality, only binds UIElement
 * and Container generic parameter to self for convenience.
 * 
 * @author Pavel
 *
 */
public interface Tag extends UIElement<Tag>, Container<Tag> {

	enum TagName {
		a(true), abbr, acronym, address, area, article, aside, audio, b, base, bdi, bdo, blockquote, body, br, button, canvas, caption, cite, code, col, colgroup, datalist, dd, del, details, dfn, dialog, div(true), dl, dt, em, embed, fieldset, figcaption, figure, footer, form, h1, h2, h3, h4, h5, h6, head, header, hgroup, hr, html, i, iframe, img, input, ins, kbd, keygen, label, legend, li, link, main, map, mark, menu, menuitem, meta, meter, nav, noscript, object, ol, optgroup, option, output, p, param, pre, progress, q, rp, rt, ruby, s, samp, script, section, select, small, source, span(true), strong, style, sub, summary, sup, table, tbody, td(true), textarea(true), tfoot, th(true), thead, time, title, tr, track, u, ul, var, video, wbr;
		
		private boolean forceEndTag;
		
		public boolean isForceEndTag() {
			return forceEndTag;
		}
		
		private TagName() {
		}
		
		private TagName(boolean forceEndTag) {
			this.forceEndTag = forceEndTag;
		}
		
	}

}
