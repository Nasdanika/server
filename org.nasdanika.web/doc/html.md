# HTML
``org.nasdanika.html`` bundle provides fluent [API](http://www.nasdanika.org/server/apidocs/) for building HTML code including:

* HTML (low level), 
* [Bootstrap](http://getbootstrap.com/), 
* [Font Awesome](https://fortawesome.github.io/Font-Awesome/), 
* [AngularJS](https://angularjs.org/), 
* [Knockout](http://knockoutjs.com/index.html),
* Application - convenience methods and interfaces for constructing single page router applications with a header, navigation bar, content panels and footer.  

An instance of [[javadoc>org.nasdanika.html.HTMLFactory]] is used to create instances of API interfaces, which are then combined together. In applications where HTML API is used not in the context of a web request [[javadoc>org.nasdanika.html.impl.DefaultHTMLFactory]] class can be directly instantiated and used as HTMLFactory implementation. In the context of a web request, e.g. in routes or route operations, and instance of HTMLFactory can be obtained either by adapting [[javadoc>org.nasdanika.web.HttpServletRequestContext]] or by specifying a context parameter - in this case the framework will adapt the context to HTMLFactory.

Many HTML interfaces extend [[javadoc>org.nasdanika.html.Producer]] and [[javadoc>java.lang.Autocloseable]]. Many API methods take objects as arguments to build a composite HTML object from parts.

Objects are converted to HTML string (stringified) using the following algorithm (see. [UIElementImpl.toHTML()](http://www.nasdanika.org/server/apidocs/src-html/org/nasdanika/html/impl/UIElementImpl.html#line.866) source code):  

* If object is ``null`` then it is treated as a blank string.
* If object is [[javadoc>java.lang.String]], then it is used as-is. 
* If object implements Producer, then its ``produce()`` method is invoked and return value is recursively passed to stringification. 
* If object impelements [[javadoc>org.nasdanika.html.FactoryProducer]], then its ``produce(HTMLFactory)`` method is invoked and return value is recursively passed to stringification. 
* If ``Producer.Adapter`` was set in the factory with ``setProducerAdapter()`` method, then the adapter is used to adapt object to producer. If adapter returns non-null value then it is passed to stringification.
* If ``FactoryProducer.Adapter`` was set in the factory with ``setFactoryProducerAdapter()`` method, then the adapter is used to adapt object to factory producer. If the adapter returns non-null value then it is passed to stringification.
* If object is [[javadoc>java.io.InputStream]] or [[javadoc>java.io.Reader]], its content is converted to string.
* If object is [[javadoc>java.net.URL]], then its input stream is used to retrieve text content.
* Otherwise object's ``toString()`` method is invoked.

Example - loading script from a classloader resource:

```java
htmlFactory.tag(TagName.script, getClass().getResource("Script.js"));
```

When ``close()`` method is invoked on HTML object, the object invokes ``close`` on all its parts. It allows to build complex HTML composites from parts which hold system resources such as OSGi services or database connections and release the resource by invoking ``close`` on the top object.

``Producer`` and ``FactoryProducer`` are functional interfaces. It allows to assemble HTML objects from lambdas and method references.

## Low level API

## Bootstrap

### Forms

## Font Awesome

## AngularJS

## Knockout

## Application

TODO - how router works, //, nsdLoad, nsdReplace