## Route services

OSGi components providing [[javadoc>org.nasdanika.web.Route]] interface can be configured to serve as model element routes by setting component properties as explained below:

* ``consumes`` - Multi-value string property or comma-separated list of MIME/content types which this route can consume. MIME/content types may contain wildcards, e.g. text/* 
* ``description`` - optional route description.
* ``description-content-type`` - ``Text``, ``HTML``, or ``Markdown`` (default).
* ``method`` - Single or multi-value listing HTTP method(s) which this route handles. ``*`` matches any method. If this property is not set then the route matches any request method.
* ``path`` - Route path. If path ends with /, then the route matches any request which path starts with the route path, otherwise route matches if paths are equal. Path and pattern a mutually exclusive. If path starts with a dot, the the route is treated as an extension route, i.e. it matches file extension, e.g. ``.png``.
* ``pattern`` - [[javadoc>java.util.regex.Pattern|Java Regex Pattern]] to match request (context) path.
* ``priority`` - Route priority.
* ``produces`` - Content type which this route produces.
* ``target`` - Name of the target [[classifier>EClass@http://www.eclipse.org/emf/2002/Ecore]]. Sub-types inherit routes defined in super-types and can override them.
* ``target-namespace-uri`` - Namespace URI of the target object class package.
* ``type`` - Shall be set to ``eobject``.

If two routes match the same request then:

* The route with higher priority takes precedence. 
* If priorities are equal, then route defined in a sub-class or a class with shortest inheritance distance to the context model element's EClass takes precedence. 
* If the routes have the same inheritance distance then a route with path takes precedence over a route with pattern.
* A route with the longest path/pattern takes precedence over the other if both use path or pattern.
