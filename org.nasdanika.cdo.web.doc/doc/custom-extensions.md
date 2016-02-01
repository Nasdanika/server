## Custom extensions
Nasdanika documentation system can be extended by creating and registering wiki link renderers, wiki link resolvers, content filters, annotation renderers, plugins, and ECore model elements documentation generators. 

### Wiki Link Resolver
Wiki link resolvers are extensions which resolve a Wiki link in format ``[[resolver name>resolver-specific location]]`` to a link URL. Wiki link resolvers shall implement [[javadoc>org.nasdanika.cdo.web.doc.WikiLinkResolver]] interface. Resolvers can also implement [[javadoc>org.nasdanika.cdo.web.doc.WikiLinkProcessor$Renderer]] interface. 

#### Implementation

[[javadoc>org.nasdanika.cdo.web.doc.extensions.WikipediaResolver]] implements both interfaces - it resolves article URL relative to the Wiki URL and then renders a link with the Wikipedia logo in front: 

```java
public class WikipediaResolver implements WikiLinkResolver, Renderer {

	@Override
	public Rendering render(String href, String content, String config, boolean isMissing) {
		Rendering ret = new Rendering(href, "<i class=\"fa fa-wikipedia-w\"></i> "+content);
		if (isMissing) {
			ret.withAttribute("style", "color:red;border-bottom:1px dashed");
		}
		return ret;
	}

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		return spec==null ? null : url+"/wiki/"+spec.replace(' ', '_');
	}
	
	private String url = "https://en.wikipedia.org";
	
	public void setUrl(String wikipediaURL) {
		this.url = wikipediaURL;
	}

}
```

#### Registration

Resolvers shall be registered as ``wiki-link-resolver`` under ``org.nasdanika.cdo.web.doc.extensions`` extension point. For example:
```xml
<extension point="org.nasdanika.cdo.web.doc.extensions">
    <wiki-link-resolver
          class="org.nasdanika.cdo.web.doc.extensions.ECoreGlobalResolver"
          name="global">
          <description><![CDATA[
          Resolves a package or classifier URL from the global registry. Format: ``[[global>EClassifier name@EPackage NS URI]]``. EClassifier name with @ can be omitted to address the package.

Examples:

* ``[[global>EString@http://www.eclipse.org/emf/2002/Ecore]]`` is rendered as [[global>EString@http://www.eclipse.org/emf/2002/Ecore]]
* ``[[global>http://www.eclipse.org/emf/2002/Ecore]]`` is rendered as [[global>http://www.eclipse.org/emf/2002/Ecore]]
            ]]></description>
      </wiki-link-resolver>
</extension>
```

### Wiki Link Renderer
Wiki Link Renderers render Wiki links in format ``[[renderer name(configuration):location|content]]``. Location can be a resolver spec, e.g. ``bundle>org.mybundle/myresource.md``. Configuration and content are optional. Renderers shall implement [[javadoc>org.nasdanika.cdo.web.doc.WikiLinkProcessor$Renderer]] interface.


#### Implementation

[[javadoc>org.nasdanika.cdo.web.doc.extensions.LightboxWikiLinkRenderer]] renders an image link which opens the image in a dialog box:

```java
public class LightboxWikiLinkRenderer implements WikiLinkProcessor.Renderer {
	
	private AtomicInteger counter = new AtomicInteger();
	private Map<String, String> idMap = new ConcurrentHashMap<>();

	@Override
	public Rendering render(
			String href, 
			String content, 
			String config,
			boolean isMissing) {
		Rendering ret = new Rendering(href, "<span class=\"glyphicon glyphicon-picture\"></span> "+content);
		ret.withAttribute("data-title", content);
		String id = idMap.get(href);
		if (id==null) {
			id = "image-"+Integer.toString(counter.incrementAndGet(), Character.MAX_RADIX);
			idMap.put(href, id);
		}
		ret.withAttribute("data-lightbox", id);
		if (isMissing) {
			ret.withAttribute("style", "color:red;border-bottom:1px dashed");
		}
		return ret;
	}

}
```

#### Registration

```xml
<extension point="org.nasdanika.cdo.web.doc.extensions">
    <wiki-link-renderer
          class="org.nasdanika.cdo.web.doc.extensions.LightboxWikiLinkRenderer"
          name="image">
       <description><![CDATA[
            Renders a [lightbox](http://lokeshdhakar.com/projects/lightbox2/) image link. 

Example:

* ``[[image:https://github.com/Nasdanika/server/wiki/webtest.png]]`` is rendered as [[image:https://github.com/Nasdanika/server/wiki/webtest.png]]
         ]]></description>
    </wiki-link-renderer>
</extension>
```

### Content filter
Content filters convert content of one type to another, for example markdown to HTML. Content filters shall implement [[javadoc>org.nasdanika.cdo.web.doc.ContentFilter]] interface. Custom content filters can be used, for example, to convert model files to HTML representation of the model. 

#### Implementation

Text content filter escapes text and encloses it into a DIV styled as PRE.

```java
public class TextContentFilter implements ContentFilter {

	@Override
	public Object filter(Object content, DocRoute docRoute, URL baseURL, String urlPrefix) throws Exception {
		return docRoute.getHtmlFactory().div(StringEscapeUtils.escapeHtml4(CoreUtil.stringify(content)))
				.style("white-space", "pre-wrap")
				.style().font().family("monospace");
	}

}
```

#### Registration
Content filter extension registration specifies implementation class, source MIME type, and target MIME type.

```xml
<extension point="org.nasdanika.cdo.web.doc.extensions">
   <content-filter
         class="org.nasdanika.cdo.web.doc.extensions.TextContentFilter"
         source-type="text/plain"
         target-type="text/html">
         <description><![CDATA[
          Renders plain text as pre-formatted HTML text.
         ]]></description>
   </content-filter>
</extension>
```
 
### Custom MIME types
Content filtering is performed based on resource extension associated with a MIME type. Custom MIME types can be registered using ``mime-type`` extension:

```xml
<extension point="org.nasdanika.cdo.web.doc.extensions">
    <mime-type type="text/markdown">
        <mime-type-extension>
            md
        </mime-type-extension>
    </mime-type> 
</extension>
```

### Markdown Pre-Processor
Markdown Pre-Processors are used to expand markdown text before converting to HTML. They shall implement [[javadoc>org.nasdanika.cdo.web.doc.MarkdownPreProcessor]] interface.

#### Registration

```xml
<extension point="org.nasdanika.cdo.web.doc.extensions">
    <markdown-pre-processor class="org.nasdanika.cdo.web.doc.extensions.IncludeMarkdownPreProcessor">
    </markdown-pre-processor>
</extension>
```

### Annotation renderer
Annotation renderers are used to customize rendering of EAnnotation's in the model documentation. Annotation renderers shall implements [[javadoc>org.nasdanika.cdo.web.doc.EAnnotationRenderer]] interface.

### ECore Documentation Generators

Generation of documentation for model elements can be customized with four extensions. Custom generators can be configured to match all or specific model elements.  

#### EPackage

EPackage documentation generators shall implement [[javadoc>org.nasdanika.cdo.web.doc.EModelElementDocumentationGenerator|org.nasdanika.cdo.web.doc.EModelElementDocumentationGenerator<EPackage>]] interface and be registered with ``epackage-documentation-generator`` extension point.

Attributes:

* ``class`` - Implementation class.
* ``ns-uri`` - Namespace URI to match. If empty, matches any Namespace URI.
* ``priority`` - Priority, generators with higher priority take precedence over generators with lower priority.  

#### EClass

EClass documentation generators shall implement [[javadoc>org.nasdanika.cdo.web.doc.EModelElementDocumentationGenerator|org.nasdanika.cdo.web.doc.EModelElementDocumentationGenerator<EClass>]] and be registered with ``eclass-documentation-generator`` extension point.

Attributes:

* ``class`` - Implementation class.
* ``ns-uri`` - Namespace URI to match. If empty, matches any Namespace URI.
* ``name`` - Class name to match. If empty, matches any name.
* ``priority`` - Priority, generators with higher priority take precedence over generators with lower priority.  

#### EDataType

EDataType documentation generators shall implement [[javadoc>org.nasdanika.cdo.web.doc.EModelElementDocumentationGenerator|org.nasdanika.cdo.web.doc.EModelElementDocumentationGenerator<EDataType>]] and be registered with ``edatatype-documentation-generator`` extension point.

Attributes:

* ``class`` - Implementation class.
* ``ns-uri`` - Namespace URI to match. If empty, matches any Namespace URI.
* ``name`` - Data type name to match. If empty, matches any name.
* ``priority`` - Priority, generators with higher priority take precedence over generators with lower priority.  

#### EEnum

EEnum documentation generators shall implement [[javadoc>org.nasdanika.cdo.web.doc.EModelElementDocumentationGenerator|org.nasdanika.cdo.web.doc.EModelElementDocumentationGenerator<EEnum>]] and be registered with ``eenum-documentation-generator`` extension point.

Attributes:

* ``class`` - Implementation class.
* ``ns-uri`` - Namespace URI to match. If empty, matches any Namespace URI.
* ``name`` - Enumeration name to match. If empty, matches any name.
* ``priority`` - Priority, generators with higher priority take precedence over generators with lower priority.  


### Documentation
All extensions support ``description`` sub-element. Markdown text from the description element is rendered by the documentation route and displayed in 
the "Description" column on the [[../extensions.html|installed extensions]] page.  

### Property injection
All extensions support nested ``property`` elements. Property injection is performed by ``injectProperties`` method of [[javadoc>org.nasdanika.core.CoreUtil]] class. See ``CoreUtil.injectProperties()`` [JavaDoc](http://www.nasdanika.org/server/apidocs/org.nasdanika.core/target/site/apidocs/org/nasdanika/core/CoreUtil.html#injectProperties-org.eclipse.core.runtime.IConfigurationElement-T-) or [source](http://www.nasdanika.org/server/apidocs/org.nasdanika.core/target/site/apidocs/src-html/org/nasdanika/core/CoreUtil.html#line.168) for more details. 

#### Examples

##### Setter injection

```java
private String url = "https://en.wikipedia.org";
	
public void setUrl(String wikipediaURL) {
	this.url = wikipediaURL;
}
```

##### Map injection

```java
private Map<String, String> packageMap = new LinkedHashMap<String, String>();
	
public Map<String, String> getPackageMap() {
	return packageMap;
}
```

The property definition below puts ``java`` -> ``http://docs.oracle.com/javase/8/docs/api`` entry to the ``pacakgeMap``.

```xml
<property
      name="packageMap.java"
      value="http://docs.oracle.com/javase/8/docs/api">
</property>
```

### Reporting extension configuration
Configurable extensions can report their configuration by implementing [[javadoc>org.nasdanika.cdo.web.doc.ConfigurableExtension]] interface. Below is an example of ``generateConfigurationDocumentation(HTMLFactory htmlFactory)`` taken from the [[javadoc>org.nasdanika.cdo.web.doc.extensions.JavadocWikiLinkResolver]] extension:

```java
@Override
public Object generateConfigurationDocumentation(HTMLFactory htmlFactory) {
	Table packageMapTable = htmlFactory.table().bordered();
	Row hRow = packageMapTable.row();
	hRow.header("Package");
	hRow.header("Location");
	for (Entry<String, String> pe: packageMap.entrySet()) {
		Row pRow = packageMapTable.row();
		pRow.cell(pe.getKey());
		pRow.cell(htmlFactory.link(pe.getValue(), pe.getValue()));
	}
		
	return htmlFactory.panel(Style.INFO, "Package map", packageMapTable, null);
}
```

