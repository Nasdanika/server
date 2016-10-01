package org.nasdanika.cdo.web.doc.webtest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.ParameterizedTestResult;
import org.nasdanika.webtest.model.TestMethodResult;

public class TestMethodResultDocumentationGenerator extends MethodResultDocumentationGenerator<TestMethodResult> {

	protected TestMethodResultDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		super(testResultsDocumentationGenerator);
	}
	
	@Override
	protected String getIcon(TestMethodResult result) {
		switch (result.getStatus()) {
		case ERROR:
			return "/bundle/org.nasdanika.cdo.web.doc/images/flask_red.png";
		case FAIL:
			return "/bundle/org.nasdanika.cdo.web.doc/images/flask_orange.png";
		case PASS:
			return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/flask.png";		
		case PENDING:
			return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/flask_empty.png";
		}
		return "/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/flask.png";		
	}
	
	@Override
	protected Fragment getIndex(TestMethodResult obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix,	String path) throws Exception {
		Fragment ret = super.getIndex(obj, context, baseURI, urlPrefix, path);
		HTMLFactory htmlFactory = ret.getFactory();
		EList<String> parameters = obj.getParameters();
		if (!parameters.isEmpty()) {			
			ret.content(htmlFactory.tag(Tag.TagName.h4, "Parameters"));
			Table parametersTable = htmlFactory.table().bordered();
			ret.content(parametersTable);
			parametersTable.header().headerRow("Title", "Value", "Description", "Field", "Type").style(Bootstrap.Style.INFO);
			RowContainer<?> parametersTableBody = parametersTable.body();
			EList<Descriptor> parameterDescriptors = ((ParameterizedTestResult) obj.eContainer().eContainer()).getParameterDescriptors();
			for (int i=0; i<parameterDescriptors.size(); ++i) {
				Descriptor pd = parameterDescriptors.get(i);
				Row pRow = parametersTableBody.row(pd.getTitle());
				pRow.cell(StringEscapeUtils.escapeHtml4(parameters.get(i)));
				description(pd, pRow.cell(), context, baseURI, urlPrefix);
				String pqn = pd.getQualifiedName();
				int cIdx = pqn.indexOf(":");
				int lsIdx = pqn.substring(cIdx+1).lastIndexOf(' ');
				pRow.cell(pqn.substring(0, cIdx));
				String className = pqn.substring(lsIdx+cIdx+2);
				pRow.cell(testResultsDocumentationGenerator.getDocRoute().javaDocLink(className, false, false));
			}
		}
		
		return ret;
	}

	@Override
	protected boolean isTocHidden(TestMethodResult obj) {
		return false;
	}
}
