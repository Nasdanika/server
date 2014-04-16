nasdanika
=========

Nasdanika open source components. One of the primary goal of the components is to provide means to expose CDO repositories to the web in a REST-ful fashion through a variety of formats over HTTP and WebSocket with support of different HTTP methods. 

Nasdanika CDO application is a collection of routes. There are three types of routes:
* Root routes match URL's paths without context object.
* Object routes match object type and path.
* Extension routes match extension.

For example, in a URL ``http://localhost/contextpath/servletpath/viewcontext/resourcename/L3.json`` ``viewcontext`` matches a root route which provides ``CDOViewContext``, ``resourcename`` is a CDOResource name in a view, ``L3`` is an object ID in the resource, and ``.json`` matches JSON extension route which, for GET method, converts ``L3`` object, whatever it is into JSON representation. 
* ``http://localhost/contextpath/servletpath/viewcontext/resourcename/L3/transactions.json`` addresses ``transactions`` feature of ``L3`` object.
* ``http://localhost/contextpath/servletpath/viewcontext/resourcename/L3/transactions/3.json`` adresses 4th element of ``transactions`` collection of ``L3`` object.

Support of the following extension routes is planned:

| Extension  | GET | POST | PUT | PATCH | DELETE |
| ---------- | --- | ---- | --- | ----- | ------ |
| json | Render addressed object or object feature as JSON | Create a new object from JSON request payload and add it to the addressed collection | Replace addressed object/collection with an object(s) created from JSON data from request payload | Update addressed object/collection with JSON data from request payload | N/A - delete shall address object directly, without extension. |
| js | Generate JavaScript module which encapsulates operations on the addressed object/collection. | N/A | N/A | N/A | N/A |
| xml | Render addressed object or object feature as XML | Create a new object from XML request payload and add it to the addressed collection | Replace addressed object/collection with an object(s) created from XML data from request payload | Update addressed object/collection with XML data from request payload | N/A - delete shall address object directly, without extension. |
| html | Render addressed object or object feature as HTML | Create a new object from request parameters and add it to the addressed collection. | Replace addressed object/collection with an object(s) created from request parameters | Update addressed object/collection with request parameters | N/A - delete shall address object directly, without extension. |

Specific object types may support additional extensions, e.g. svg extension may generate an image depicting the object and objects referenced by it.

The table below outlines HTTP method behavior for different CDO classes

| Extension  | GET | POST | PUT | PATCH | DELETE |
| ---------- | --- | ---- | --- | ----- | ------ |
| CDOView | List resources | Open view, if not in auto mode | N/A | N/A | Close view, if not in auto mode |
| CDOTransaction | List resources | Open transaction, if not in auto mode | Commit and close | N/A | Rollback and close |
| CDOObject | Render object in specified format | Create object and add to collection | Replace object | Update object | Delete object from containing feature |

See Wiki for details.
