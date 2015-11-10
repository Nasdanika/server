## Custom extensions
Nasdanika documentation system can be extended by creating and registering wiki link renderers, wiki link resolvers, content filters, annotation renderers, and plugins. 

### Wiki Link Resolver

### Wiki Link Renderer

### Content filter

### Plugin

### Annotation renderer


### Documentation
All extensions support ``description`` sub-element. Markdown text from the description element is rendered by the documentation route and displayed in 
the "Description" column on the installed extensions page.  

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
