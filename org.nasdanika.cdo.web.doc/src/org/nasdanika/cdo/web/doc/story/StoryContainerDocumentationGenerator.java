package org.nasdanika.cdo.web.doc.story;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.Story;
import org.nasdanika.story.StoryBase;
import org.nasdanika.story.StoryContainer;
import org.nasdanika.web.HttpServletRequestContext;

abstract class StoryContainerDocumentationGenerator<T extends StoryContainer> extends StateContainerDocumentationGenerator<T> {

	StoryContainerDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		super(storyDocumentationGenerator);
	}

	@Override
	protected Collection<? extends EObject> getTocChildren(T storyContainer) {
		Collection<EObject> ret = new ArrayList<>(super.getTocChildren(storyContainer));
		ret.addAll(storyContainer.getStories());
		return ret;
	}
	
	@Override
	protected void indexTabs(T obj, HttpServletRequestContext context, URI baseURI, String urlPrefix, String path, Tabs tabs) {
		super.indexTabs(obj, context, baseURI, urlPrefix, path, tabs);
		
		boolean hasSummaries = false;
		boolean hasProtagonists = false;
		boolean hasGoals = false;
		boolean hasBenefits = false;
						
		if (!obj.getStories().isEmpty()) {
			List<Object[]> rows = new ArrayList<>();
			for (StoryBase storyBase: obj.getStories()) {
				Fragment protagonistsFragment = null;
				if (storyBase instanceof Story) {
					List<Protagonist> protagonists = new ArrayList<>();
					if (obj instanceof Protagonist) {
						protagonists.add((Protagonist) obj);
					}
					protagonists.addAll(((Story) storyBase).getProtagonists());
					
					if (!protagonists.isEmpty()) {
						protagonistsFragment = tabs.getFactory().fragment();
						hasProtagonists = true;
						Iterator<Protagonist> pit = protagonists.iterator();
						while (pit.hasNext()) {
							protagonistsFragment.content(storyDocumentationGenerator.getDocRoute().findToc(pit.next()).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()));
							if (pit.hasNext()) {
								protagonistsFragment.content(", ");
							}
						}
					}						
					
				}
				
				String summary = storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(storyBase.getDescription());
				hasSummaries = hasSummaries || !CoreUtil.isBlank(summary);
				
				Object goal = storyBase instanceof Story ? storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(((Story) storyBase).getGoal()) : "";
				hasGoals = hasGoals || !CoreUtil.isBlank(goal instanceof String ? (String) goal : "");
				
				Object benefit = storyBase instanceof Story ? storyDocumentationGenerator.getDocRoute().firstMarkdownSentence(((Story) storyBase).getBenefit()) : "";
				hasBenefits = hasBenefits || !CoreUtil.isBlank(benefit instanceof String ? (String) benefit : "");
				
				rows.add(new Object[] {
						storyDocumentationGenerator.getDocRoute().findToc(storyBase).getLink(storyDocumentationGenerator.getDocRoute().getDocRoutePath()),
						storyBase.eClass().getName(),
						summary,
						protagonistsFragment == null ? "" : protagonistsFragment,
						goal,
						benefit,								
				});
			}
			
			HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
			Table storiesTable = htmlFactory.table().bordered();
			Row headerRow = storiesTable.header().headerRow("Element", "Type").style(Style.PRIMARY);
			if (hasSummaries) {
				headerRow.header("Summary");
			}
			if (hasProtagonists) {
				headerRow.header("Protagonist(s)");
			}
			if (hasGoals) {
				headerRow.header("Goal");
			}
			if (hasBenefits) {
				headerRow.header("Benefit");
			}
			for (Object[] row: rows) {			
				Row tRow = storiesTable.body().row(row[0], row[1]);
				if (hasSummaries) {
					tRow.cell(row[2]);
				}
				if (hasProtagonists) {
					tRow.cell(row[3]);
				}
				if (hasGoals) {
					tRow.cell(row[4]);
				}
				if (hasBenefits) {
					tRow.cell(row[5]);
				}
				
			}
			tabs.item("Stories", storiesTable);
		}
	}
}
