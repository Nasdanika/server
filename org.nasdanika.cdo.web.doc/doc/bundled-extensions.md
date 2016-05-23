## Bundled extensions
``org.nasdanika.cdo.web.doc`` bundle ships with several extensions. Some of them are registered by the ``org.nasdanika.cdo.web.doc`` bundle, and some shall be registered by the application bundles. The application workspace wizard generates registrations of LightboxWikiLinkRenderer, IncludePlugin, WikipediaResolver, and JavadocWikiLinkResolver extensions in the application bundle plugin.xml.

### Wiki Link Resolvers
#### BundleResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.BundleResolver|org.nasdanika.cdo.web.doc.extensions.BundleResolver]]

Resolves resource from a bundle. Format: ``[[bundle>resource path in bundle]]``. Example: ``[[bundle>org.nasdanika.cdo.web/doc/forms.md]]`` is rendered as [[bundle>org.nasdanika.cdo.web/doc/forms.md]].

This resolver is registered by the documentation bundle.

#### DokuWikiResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.DokuWikiResolver|org.nasdanika.cdo.web.doc.extensions.DokuWikiResolver]]

Resolves [DokuWiki](https://www.dokuwiki.org) page reference. Supports the following properties:

* ``location`` - Wiki base URL.
* ``icon`` - Optional URL of an icon to display in front of the link. 

#### EClassifierResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.EClassifierResolver|org.nasdanika.cdo.web.doc.extensions.EClassifierResolver]]

Resolves [[classifier>EClassifier@http://www.eclipse.org/emf/2002/Ecore]] reference. In EClassifier and [[classifier>EPackage@http://www.eclipse.org/emf/2002/Ecore]] documentation and TOC entries mounted to EClassifiers or EPackages the reference is resolved in the same registry (session or global). In documentation not mounted to registry elements the reference is resolved 
            in the session registry if it is available with a fallback to the global registry, if it is available. 
            
Format: ``[[classifier>EClassifier name@EPackage NS URI]]``. 
            
Example: ``[[classifier>EString@http://www.eclipse.org/emf/2002/Ecore]]`` is rendered as [[classifier>EString@http://www.eclipse.org/emf/2002/Ecore]]. 

In EClassifier or EPackage documentation EClassifiers in the same package can be referenced simply by their name, e.g. ``[[MyOtherClass]]`` or with ``classifier`` resolver, e.g. ``[[classifier>MyOtherClass]]``. In mounted TOC entries the latter form shall be used. 

This resolver doesn't work for TOC's/topics with embedded content, i.e. with text, markdown, or html nested elements.

It is registered by the documentation bundle.

#### ECoreGlobalResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.ECoreGlobalResolver|org.nasdanika.cdo.web.doc.extensions.ECoreGlobalResolver]]

Resolves a package or classifier URL from the global registry. Format: ``[[global>EClassifier name@EPackage NS URI]]``. EClassifier name with @ can be omitted to address the package.

Examples:

* ``[[global>EString@http://www.eclipse.org/emf/2002/Ecore]]`` is rendered as [[global>EString@http://www.eclipse.org/emf/2002/Ecore]]
* ``[[global>http://www.eclipse.org/emf/2002/Ecore]]`` is rendered as [[global>http://www.eclipse.org/emf/2002/Ecore]]

This resolver is registered by the documentation bundle.

#### ECoreSessionResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.ECoreSessionResolver|org.nasdanika.cdo.web.doc.extensions.ECoreSessionResolver]]

Resolves a package or classifier URL from the session registry. Format: ``[[session>EClassifier name@EPackage NS URI]]``. EClassifier name with @ can be omitted to address the package.

Examples:

* ``[[session>EString@http://www.eclipse.org/emf/2002/Ecore]]`` is rendered as [[session>EString@http://www.eclipse.org/emf/2002/Ecore]]
* ``[[session>http://www.eclipse.org/emf/2002/Ecore]]`` is rendered as [[session>http://www.eclipse.org/emf/2002/Ecore]]

This resolver is registered by the documentation bundle.

#### EPackageResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.EPackageResolver|org.nasdanika.cdo.web.doc.extensions.EPackageResolver]]

Resolves [[classifier>EPackage@http://www.eclipse.org/emf/2002/Ecore]] reference. In [[classifier>EClassifier@http://www.eclipse.org/emf/2002/Ecore]] and EPackage documentation and TOC entries mounted to EClassifiers or EPackages the reference is resolved in the same registry (session or global). In documentation not mounted to registry elements the reference is resolved 
            in the session registry if it is available with a fallback to the global registry, if it is available. 
            
Format: ``[[package>EPackage NS URI]]``. 
            
Example: ``[[package>http://www.eclipse.org/emf/2002/Ecore]]`` is rendered as [[package>http://www.eclipse.org/emf/2002/Ecore]]. 

This resolver doesn't work for TOC's/topics with embedded content, i.e. with text, markdown, or html nested elements.

It is registered by the documentation bundle.

#### JavadocWikiLinkResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.JavadocWikiLinkResolver|org.nasdanika.cdo.web.doc.extensions.JavadocWikiLinkResolver]]

Resolves JavaDoc URL from the class/package name. Usage: ``[[javadoc>fully qualified class name|text]]``. Text is optional. Examples: 

* ``[[javadoc>java.lang.String]]`` is rendered as [[javadoc>java.lang.String]]
* ``[[javadoc>java.lang.String|java.lang.String]]`` is rendered as [[javadoc>java.lang.String|java.lang.String]]

This resolver shall be configured by setting package map properties. Package map property name shall start with ``packageMap.`` followed by the package name. Property value shall be the base URL of the API documentation. E.g.:

```xml
<property
	name="packageMap.java"
	value="http://docs.oracle.com/javase/8/docs/api">
</property>
``` 

Packages are matched in the order of mapping declaration, so if some sub-package documentation has URL different from the parent package, the sub-package mapping shall precede the parent mapping. 

Registration of this extension is generated by the application workspace wizard in the application bundle plugin.xml. The generated registration includes package mappings for Nasdanika Foundation Server packages and for ``java`` and ``javax`` packages.

#### TocWikiLinkResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.TocWikiLinkResolver|org.nasdanika.cdo.web.doc.extensions.TocWikiLinkResolver]]

Resolves TOC URL from TOC ID. Format: ``[[toc>bundle/id]]``. Example: ``[[toc>org.nasdanika.core/credits]]`` is rendered as [[toc>org.nasdanika.core/credits]].

This resolver is registered by the documentation bundle.

#### StoryResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.StoryResolver|org.nasdanika.cdo.web.doc.extensions.StoryResolver]]

Resolves [[global>CatalogElement@urn:org.nasdanika.story|story element]] URL from ID. Format: ``[[story>bundle/location#id]]``. Example: ``[[story>org.myorg.mybundle/mystory.nasdanika_story#my-story-element]]``.
            
If story element ID contains ``${parent}`` token then the token is expanded to the parent element ID. If the parent element's id is blank, then token expansion fails and the element ID with the parent token is also considered blank.                         

This resolver is registered by the documentation bundle.

#### WikipediaResolver
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.WikipediaResolver|org.nasdanika.cdo.web.doc.extensions.WikipediaResolver]]

Resolves Wikipedia URL from the article name, renders wikipedia icon before the link. Replaces spaces with underscores in the article name. Format: ``[[wp>article name|text]]``. Example: ``[[wp>Domain-driven design]]`` is rendered as [[wp>Domain-driven design]].

This resolver supports ``url`` property with default value ``https://en.wikipedia.org``.

Registration of this extension is generated by the application workspace wizard in the application bundle plugin.xml.

### Wiki Link Renderers

#### LightboxWikiLinkRenderer
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.LightboxWikiLinkRenderer|org.nasdanika.cdo.web.doc.extensions.LightboxWikiLinkRenderer]]

Renders a [lightbox](http://lokeshdhakar.com/projects/lightbox2/) image link. 

Example:

* ``[[image:https://github.com/Nasdanika/server/wiki/webtest.png]]`` is rendered as [[image:https://github.com/Nasdanika/server/wiki/webtest.png]]

Registration of this extension is generated by the application workspace wizard in the application bundle plugin.xml.

### Markdown Pre-Processors
#### IncludePlugin
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.IncludeMarkdownPreProcessor|org.nasdanika.cdo.web.doc.extensions.IncludeMarkdownPreProcessor]]

Includes content of another documentation resource into this resource.
Format ``{{include>resource location}}``. Resource location URL supports custom schemes corresponding to the names of registered wiki link resolvers, e.g. ``bundle`` schema.

Registration of this extension is generated by the application workspace wizard in the application bundle plugin.xml.

### Content filters
#### MarkdownContentFilter
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.MarkdownContentFilter|org.nasdanika.cdo.web.doc.extensions.MarkdownContentFilter]]

Renders [markdown](http://daringfireball.net/projects/markdown/) to HTML using [pegdown](https://github.com/sirthias/pegdown) and  [highlight.js](https://highlightjs.org/) for syntax highlighting. 

Uses wiki link resolvers and renderers. Wiki link is a link enclosed in double brackets: ``[[renderer(config):resolver>location|text]]``. Renderer, renderer config, resolver, and text are optional. Examples of wiki links:

* ``[[image:https://github.com/Nasdanika/server/wiki/webtest.png]]`` - Uses ``image`` renderer.
* ``[[javadoc>java.lang.String]]`` - Uses ``javadoc`` resolver.
* ``[[image:bundle>org.nasdanika.webtest.hub/images/my-image.png]]`` - ``image`` renderer with ``bundle`` resolver.

This content filter is registered by the documentation bundle.

#### TextContentFilter
Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.TextContentFilter|org.nasdanika.cdo.web.doc.extensions.TextContentFilter]]

Renders plain text as pre-formatted HTML text, registered by the documentation bundle.

### ECore Documentation Generators

#### EPackage

Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.EPackageDocumentationGenerator|org.nasdanika.cdo.web.doc.extensions.EPackageDocumentationGenerator]]

Default documentation generator for EPackages - registered with empty NsURI and priority 0.

#### EClass

Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.EClassDocumentationGenerator|org.nasdanika.cdo.web.doc.extensions.EClassDocumentationGenerator]]

Default documentation generator for EClasses - registered with empty NsURI and name, and priority 0.

#### EDataType

Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.EDataTypeDocumentationGenerator|org.nasdanika.cdo.web.doc.extensions.EDataTypeDocumentationGenerator]]

Default documentation generator for EDataTypes - registered with empty NsURI and name, and priority 0.

#### EEnum

Class: [[javadoc>org.nasdanika.cdo.web.doc.extensions.EEnumDocumentationGenerator|org.nasdanika.cdo.web.doc.extensions.EEnumDocumentationGenerator]]

Default documentation generator for EEnums - registered with empty NsURI and name, and priority 0.

