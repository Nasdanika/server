## Resource route extensions

Resource route is defined with ``eobject-resource-route`` element of ``org.nasdanika.web.route`` extension point. This element supports the following attributes and sub-elements:

* ``content-type`` - Response content type. If not set, then MIME types file is used to infer content file from resource extension.
* ``description`` - optional route description.
* ``path`` - Route path. If path ends with /, then the route's resource shall be a directory and route matches resource below the directory. Path and pattern a mutually exclusive. If path starts with a dot, the the route is treated as an extension route, i.e. it matches file extension, e.g. ``.png``.
* ``pattern`` - [[javadoc>java.util.regex.Pattern|Java Regex Pattern]] to match request path.
* ``priority`` - Route priority. 
* ``resource`` - contributing bundle resource. File or directory. If resource is directory, then it serves as the root for resolving resources.
* ``target`` - Name of the target [[classifier>EClass@http://www.eclipse.org/emf/2002/Ecore]]. Sub-types inherit routes defined in super-types and can override them.
* ``target-namespace-uri`` - Namespace URI of the target object class package.

If two routes match the same request then:

* The route with higher priority takes precedence. 
* If priorities are equal, then route defined in a sub-class or a class with shortest inheritance distance to the context model element's EClass takes precedence. 
* If the routes have the same inheritance distance then a route with path takes precedence over a route with pattern.
* A route with the longest path/pattern takes precedence over the other if both use path or pattern.