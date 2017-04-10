# CDO Web

This bundle contains classes and interfaces which allow to expose objects in a CDO repository over HTTP and web sockets.

* [JavaDoc](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/index.html)
* [Routes](doc/routes.md) - explains how define and use different types of routes.
* [Application Rendering](doc/application-rendering.md) - describes how to build CDO-backed model-driven web applications using classes and interfaces from the ``org.nasdanika.cdo.web.routes.app`` package. 

## Roadmap

* Application rendering
    * Support of ``inline`` feature location.
    * Web operation
        * Location - button in the action bar or a link in the left panel (typically for operations with unbound parameters and as such input forms).
        * ``feature`` annotation to associate operation with a feature, i.e. display the button in the feature view, not the object view.
        * Bindings of parameters similar to method parameter binding performed by [DispatchingRoute](http://www.nasdanika.org/server/apidocs/org.nasdanika.web/apidocs/org/nasdanika/web/DispatchingRoute.html?is-external=true)
            * BodyParameter - Request body is passed as parameter value. Converts body to the parameter type, e.g. String or JSONObject. 
            * CookieParameter
            * HeaderParameter
            * ModelParameter
            * PartParameter - For file uploads.
            * PathParameter
            * QueryParameter
            * TargetParameter
            * ContextParameter 
            * ServiceParameter - Looks up OSGi service of parameter type and passes it to the method.
            * ExtensionParameter - Instantiates executable extension and passes it to the method.
        * If all parameter are bound, then click on the button shall invoke the operation.
        * Otherwise click on the button shall do GET which renders a form requesting values for un-bound parameters. Form submission shall do POST on the same URL which would validate input and invoke the operation on successful validation. Un-bound parameters can be annotated with the same annotations as structural features - icon, control, input, label, constraint, ... The EOperation can also be annotated with icon, label, enabled, visible, constraints, ... The renderer shall have validateEOperationInput() method validating parameter bounds by default (e.g. if lower bound != 0 and parameter value is null or empty string). Sub-renderers may override this method to provide custom validations.
    * Wizard for EClass'es and EOperation's. Auto-wizard for EClass'es. 
        * Auto-wizard for classes with non-view (tab) references - many references by default. 
            * Show the edit form for view features - attributes and single references by default.
            * The edit form shall have "Save and Exit" and "Save and Continue" buttons instead of the "Save" button.
            * Click on the "Save and Exit" button saves data and returns to the original screen.
            * Click on the "Save and Continue" button saves data and navigates to the first non-view (tab) feature wizard page which would have "Continue" "Exit" and "Back" buttons. On a many-feature wizard page users can create new elements, which would start a sub-wizard for that element, and delete/edit existing elements.
            * Wizard may have a navigation bar at the top displaying wizard steps.
        * Explicit wizard for EClass'es and EOperations - similar to the auto-wizard, but the grouping of feature/parameters into wizard pages is defined by YAML annotation. This can be useful when one feature choices depend on another feature value (master/detail) and as such cannot be asked on the same page (the rendering framework doesn't use SPA techniques unless manually coded).         
    * Support of file input type to features - byte[] and String types.
    * Support of img content type to features of byte[] type. Convert to image type upon upload, e.g. if content type is ``image/png`` and uploaded file is ``jpeg``, convert before storing. Also support resizing if ``image-size`` annotation is present. In the code generator change [] Html checkbox to a dropdown "Content type". 
        