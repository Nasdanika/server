package org.nasdanika.cdo.web.routes.app;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.xpath.CDOObjectPointerFactory;
import org.nasdanika.html.HTMLFactory.TokenSource;

/**
 * Uses {@link EObject} {@link EAttribute}'s as source of tokens.
 * 
 * For {@link CDOObject}'s tokens starting with ``xpath:`` the suffix after ``xpath:`` prefix is evaluated by [JXPath](http://commons.apache.org/proper/commons-jxpath/). 
 * @author Pavel Vlasov
 *
 */
public class EObjectTokenSource implements TokenSource {
	
	public static final String XPATH_PREFIX = "xpath:";
	
	static {
		JXPathContextReferenceImpl.addNodePointerFactory(new CDOObjectPointerFactory());
	}	
	
	private EObject source;
	private TokenSource[] chain;
	
	public EObjectTokenSource(EObject source, TokenSource... chain) {
		this.source = source;
		this.chain = chain;
	}

	@Override
	public Object get(String token) {		
		EStructuralFeature tokenFeature = source.eClass().getEStructuralFeature(token);
		if (tokenFeature instanceof EAttribute) {
			Object tokenValue = source.eGet(tokenFeature);
			if (tokenValue != null) {
				return tokenValue;
			}
		}
		
		if (source instanceof CDOObject && token.startsWith(XPATH_PREFIX)) {
			JXPathContext jxPathContext = JXPathContext.newContext(source);
			jxPathContext.setLenient(true);
			Object ret = jxPathContext.getValue(token.substring(XPATH_PREFIX.length()));
			if (ret != null) {
				return ret;
			}
		}
		
		for (TokenSource ch: chain) {
			Object tokenValue = ch.get(token);
			if (tokenValue != null) {
				return tokenValue;
			}
		}
		
		return null;
	}
	
	

}
