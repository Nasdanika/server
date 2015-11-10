## DocRoute configuration

### Properties

Documentation route can be configured with the following properties:

Name           | Type     | Default value | Description 
---------------|:--------:|:-------------:|-------------
doc-app-path      | String | /router/doc.html | Path of the documentation application route.
doc-route-path    | String | /router/doc | Path of the documentation route.
bundle-excludes  | String - single or multi-value |  | [[javadoc>java.util.regex.Pattern|Regex pattern(s)]]. TOC entries from bundles with symbolic names matching the patterns are not included into the TOC tree.
bundle-includes  | String - single or multi-value |  | Regex patterns(s). If this property is set, then only TOC entries from bundles with symbolic names matching includes patterns and not matching excludes patterns are mounted to the TOC tree.
expand-content | Boolean  | true          | If true, content enclosed into double curly brackets is expanded with plugins.
global-registry  | Boolean | false        | If true or if a session registry is not available and this property is not set, packages from the global registry are mounted to the documentation table of content tree.
mime-types        | String - single or multi-value |  | ``mime.types`` formatted string(s) of custom mime types referenced by content filters. E.g. ``model/user-story userstory`` would set content type of a file ``something.userstory`` to ``model/user-story`` and a corresponding content filter will be used to render the user story to HTML.
package-excludes  | String - single or multi-value |  | Regex pattern(s). ECore packages with NsURI's matching the patterns are not included into the TOC tree.
package-includes  | String - single or multi-value |  | Regex patterns(s). If this property is set, then only ECore packages with NsURI's matching includes patterns and not matching excludes patterns are mounted to the TOC tree.
path-offset    | Number   | 1             | Length of the path of the documentation route counting from the context path. E.g. if the documentation route pattern is ``doc/.+`` pattern, then the path offset is 1, for ``something/doc/.+`` pattern the offset is 2.
pattern        | String   |               | Regular expression to match route to the request path. The application workspace wizard generates a documentation route component with ``doc/.+`` pattern.
reload-delay     | Number  | 30000        | Delay in milliseconds between a notification from the extension tracker about change in registered extensions and reloading of the TOC tree and the search index.
session-registry | Boolean | true         | If true and the CDO Session Provider reference is set, packages from the CDO session registry are mounted to the documentation table of contents tree.     

### References    	

Type | Policy | Bind | Description
-----|--------|------|------------
org.eclipse.emf.cdo.session.CDOSessionProvider | static | setCdoSessionProvider | An optional reference to CDOSessionProvider is used to generate documentation for packages in the session registry.
