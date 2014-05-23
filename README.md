nasdanika
=========

* [Nasdanika HTML slides](http://www.slideshare.net/slideshow/embed_code/34274148)
* P2 repository - http://www.nasdanika.org/repository
* Binary distributions
  * Foundation server
    * [Windows 64](http://www.nasdanika.org/products/org.nasdanika.server-win32.win32.x86_64.zip)
    * [Linux GTK x86 64](http://www.nasdanika.org/products/org.nasdanika.server-linux.gtk.x86_64.zip)
  * Foundation server with examples
    * [Windows 64](http://www.nasdanika.org/products/org.nasdanika.examples-win32.win32.x86_64.zip)
    * [Linux GTK x86 64](http://www.nasdanika.org/products/org.nasdanika.examples-linux.gtk.x86_64.zip)


Nasdanika open source components. The primary goal of this project is to create a collection of OSGi bundles and an OSGi server for running CDO-powered OSGi server applications. The server shall support transactional execution with transactions 
spanning a single repository, multiple repositories, and multiple repositories participating in a JTA transaction along with other transactional resources. CDO-powered applications promise to be easier and faster to develop than alternatives because
CDO objects combine persistence and behavior, i.e. there is no need in layering business logic over the persistence logic, no need in complex configuration files - all information can be stored in a repository and transparently loaded to 
CDO objects. 

Another advantage is "Object-Oriented" UI. What it means is that UI is associated with objects, i.e. not ``accounts.jsp?customer=L103``, but ``L103/accounts.html``. 
This approach of attaching of behavior (UI pages) to data instead of data to behavior is 
conceptually equivalent to OO approach (methods belong to objects) compared to functional approach (data is passed to functions). It allows to build polymorphic UI's. For example, given a bank customer with different account types - credit cards, checking, savings, ...
account view for each account type will be provided by the corresponding account object, completely transparently for the customer object - the customer UI will "ask" the account object to provide a needed fragment, e.g. transactions list, and the account
will render it accordingly to its type. This approach combined with modularity of OSGi will allow to plug-in new model object types along with their UI's, e.g. deploy "mortgages" bundle and mortgages functionality along with UI will become available in the 
application. 

A development cycle is envisioned as follows:
* Create a model, reference existing/already deployed models as needed.
* Generate code.
* Implement business functionality, add extensions and services.
* Build a bundle.
* Deploy the bundle to the server through the Web console or command line.

The immediate objective is to provide means to expose CDO repositories to the web in a REST-ful fashion through a variety of formats over HTTP and WebSocket with support of different HTTP methods. Adding support for flows, rules, and job scheduling is planned for later stages. 

Nasdanika CDO application is a collection of routes. There are three types of routes:
* Root routes match URL's paths without context object.
* Object routes match object type and path.
* Extension routes match extension.

For example, in a URL ``http://localhost/contextpath/servletpath/viewcontext/resourcename/L3.json`` ``viewcontext`` matches a root route which provides ``CDOViewContext``, ``resourcename`` is a CDOResource name in a view, ``L3`` is an object ID in the resource, and ``.json`` matches JSON extension route which, for GET method, converts ``L3`` object, whatever it is, into JSON representation. 
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
