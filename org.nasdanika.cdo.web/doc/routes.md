## Routes

Web functionality can be associated with model elements using routes. There are the following type of routes:

* [Route operations](routeOperations.md) - annotated [[classifier>EOperation@http://www.eclipse.org/emf/2002/Ecore|EOperations]]. This kind of routes allows to define web functionality right in the model. It might be convenient for models which are used only in a web context and don't feature extensive web functionality. In models with extensive web functionality route operations may clutter the model and for models used in multiple contexts route operations will be irrelevant in non-web contexts and will introduce dependencies on web bundles.
* Extensions - routes associated with model elements using [Eclipse extensions mechanism](http://www.vogella.com/tutorials/EclipseExtensionPoint/article.html):
    * [Routes](routeExtensions.md) - contribute dynamic behavior. 
    * [Resource routes](resourceRouteExtensions.md) - contribute resources located in the extension's contributor bundle.
* [Service routes](routeServices.md) - OSGi components providing [[javadoc>org.nasdanika.web.Route]] service. When choosing between extension and service routes consider the following points:
    * Extension schema and the Eclipse plugin editor make it easier to configure an extension route - with a service route you will need to consult this documentation in order to configure route properties. 
    * Service routes may declare dependencies on other services and have activate/deactivate lifecycle methods.  
  
All types of routes are reported in the ``Routes`` tab of model classes documentation pages.  

### Micro web-applications
Service and extension route implementation classes may extend [[javadoc>org.nasdanika.web.DispatchingRoute]] or [[javadoc>org.nasdanika.cdo.web.EDispatchingRoute]] classes in order to implement fine-grained dispatching to methods annotated with [[javadoc>org.nasdanika.web.RouteMethod]] annotations and serving class loaded and bundle resources as specified by [[javadoc>org.nasdanika.web.Resource]] annotations on the target's class.

Such routes may be considered as micro web-applications operating in a context of a particular model element and performing a specific function and/or implementing a specific user story.
  