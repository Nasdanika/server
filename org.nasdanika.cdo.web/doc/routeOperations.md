## Route operations
[[classifier>EOperation@http://www.eclipse.org/emf/2002/Ecore|EOperations]] can be annotated with ``org.nasdanika.cdo.web:route`` and ``org.nasdanika.cdo.web:home-route`` to instruct the framework to route requests to annotated operations. These annotations support the following details:

  * ``action`` - security action for authorization check, defaults to HTTP method name.
  * ``qualifier`` - security qualifier for authorization check, defaults to operation name.
  * ``method`` - a comma separated list of HTTP methods to match, matches any method if omitted.
  * ``path`` - path to match, can contain path parameters in ``{}``, e.g. ``statement/{year}/{month}``. Path takes precedence over ``pattern``.
  * ``pattern`` - regex pattern to match request path. Not applicable to the home route annotation. If path and pattern are omitted, operation name is used as path. If the operation name starts with a lower-case name of one of HTTP methods and method detail entry is not present, then the method name prefix is used to match the method, and decapitalized suffix to match the path, e.g. ``getInventoryTable`` would match ``GET`` method and ``inventoryTable`` path.  
  * ``produces`` - response content type. Optional, used to match request ``Accept`` header values to the operation if present.
  * ``consumes`` - request content type(s) - comma-separated values, can contain wildcards, e.g. ``*/*`` or ``text/*``. Optional, used to match request content type to the operation if present. 
  
Home route matches the object path with ``.html`` extension, e.g. ``L3.html``.

### Parameter annotations
  * ``org.nasdanika.cdo:context-parameter`` - argument is computed by adapting the context to the parameter type. To get "raw" context use [[javadoc>org.nasdanika.web.HttpServletRequestContext|org.nasdanika.web.HttpServletRequestContext]] or [[javadoc>org.nasdanika.cdo.web.CDOTransactionHttpServletRequestContext|org.nasdanika.cdo.web.CDOTransactionHttpServletRequestContext<CR>]] as parameter type.
  * ``org.nasdanika.cdo:service-parameter`` - argument is computed by looking up an OSGi service with parameter's type, an optional ``filter`` data entry can be used to specify service filter.
  * ``org.nasdanika.cdo:query-parameter`` - argument is taken from a query parameter(s) with the name taken from ``name`` data entry. If there is no such query parameter, argument value is taken from ``defaultValue`` annotation data entry.    
  * ``org.nasdanika.cdo:path-parameter`` - argument is taken from a named path segment with the name taken from ``name`` data entry. If there is no such path segment, argument value is taken from ``defaultValue`` annotation data entry.    
  * ``org.nasdanika.cdo:cookie-parameter`` - argument is taken from a request cookies(s). An optional ``name`` data entry can be used to filter cookies by name.   

