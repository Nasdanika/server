# Application rendering

This page describes how to create model-driven web applications leveraging classes and interfaces in [org.nasdanika.cdo.web.routes.app](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/package-summary.html) package of the [org.nasdanika.cdo.web](https://github.com/Nasdanika/server/tree/master/org.nasdanika.cdo.web) bundle, [Renderer](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/Renderer.html) and [Route](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/Route.html) in particular.

The sections below outline the entire process of creating a web application focusing on use and customization of application routes and renderers. You can find a detailed description of the entire process in the [Server-side Java Development for Innovators](https://server-side-java-development-for-innovators.books.nasdanika.org/) online book, which is work in progress at 
the time of this writing.

## Overview

The core concept of the approach described here is that Web UI can be rendered using metadata of the model elements such as [EClass](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EClass.html), [EAttribute](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EAttribute.html), and [EReference](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EReference.html). Rendering can be customized with:

* Model annotations.
* Resource strings from resource bundles.
* Overriding default implementations rendering/routing methods.  


## Difference from Eclipse RAP

[Eclipse RAP](https://www.eclipse.org/rap/) provides means of exposing EMF/CDO web UI in a Web browser. The approach described here is fundamentally different from the one used by Eclipse RAP.

Eclipse RAP exposes SWT API's to the web. It starts a UI thread on the server which handles interactions with the browser. 
Nasdanika CDO Web processes each Web UI interaction as an HTTP request in its own CDO transaction. It also supports WebSockets but they are not used by application renderers and routes described here.

Eclipse RAP provides its own widgets toolkit, here we are going to leverage [Bootstrap](http://getbootstrap.com/) and HTML.

## Development

The development process includes the following steps:

* Set up environment.
* Generate application workspace.
* Create the application domain model. Optionally annotate the model. 
* Generate model code, edit support, and editor.
* Customize editor, e.g. add ``Set password`` action.
* Create the initial application model to be loaded into the repository on first start.
* Create Web UI generator model and generate renderers, routes, resource bundles and renderer/route registrations in ``plugin.xml``.
* Customize/localize the Web UI.
* Secure the application.
* Additional generation targets.
* Build and deploy.
 
These steps are described in the sections below.

### Set up environment

You'll need to download Eclipse Modeling package and install M2E, Tycho and Nasdanika Application Workspace Wizard. 
You may also install Nasdanika Story Editor, Nasdanika Ecore code generation editor and Web UI generation target so you don't have to do it later.

These steps are explained in [Install prerequisites](https://server-side-java-development-for-innovators.books.nasdanika.org/chapter-0-setup/install-prerequisites.html) chapter. 

Nasdanika plugins can be installed from ``http://www.nasdanika.org/repository`` P2 repository. 
 
### Generate application workspace

This step is explained in the [Nasdanika Application Workspace Wizard Documentation](https://github.com/Nasdanika/workspace-wizard/blob/master/org.nasdanika.workspace.wizard/doc/wizard.md) 
and [Generate Application Projects](https://server-side-java-development-for-innovators.books.nasdanika.org/chapter-0-setup/generate-application-projects.html) chapter. 

### Create the application domain model 

You can create the application domain model using several editors provided by [Ecore Tools](https://www.eclipse.org/ecoretools/) - a diagram editor and two types of tree editors, depending on 
your choice. For example you can start with the diagram editor to visually capture relationships between domain classes and then, after capturing "the big picture", switch to tree editors. 

You may watch this, slightly dated, video - [Create and document an ECore/CDO Model](https://www.youtube.com/watch?v=qfvr6HWo_Ok).

#### Adding rendering annotations

You may choose to keep rendering annotations in the model.


### Generate model code, edit support, and editor
### Customize editor, e.g. add ``Set password`` action
### Create the initial application model to be loaded into the repository on first start
### Create Web UI generator model and generate renderers, routes, resource bundles and renderer/route registrations in ``plugin.xml``
### Customize/localize the Web UI
### Secure the application
### Additional generation targets

* Stories
* UI Driver and tests
* Custom 

### Build and deploy




## Rendering annotations

Resolution - resource strings, chaining, model annotations, annotation source.
default/reference implementation.

## View

## Create

## Edit

## Delete


## Model annotation

white-labeling.


## Customize

icons.

## Security

This section describes how to secure the web application.

### Set redirection to principal home

In ``plugin.xml`` add the following route:

```xml
<root-route
      class="org.nasdanika.cdo.web.routes.RedirectToPrincipalHomeRoute"
      method="GET"
      path="index.html">
</root-route>
```

And change redirect in the application ``index.html``:
```html
<html>
	<head>
		<title>...</title>
		<META http-equiv="refresh" content="0;URL=/.../router/index.html">
	</head>
	<body>
		Redirecting to the home page.
	</body>
</html>
```

As a result ``index.html`` will redirect to the principal's ``index.html``, which in case of ``Guest`` will display the log-in form.

### Change default access decision to deny

#### Routing servlet

Open ``plugin.xml`` and set ``default-access-decision`` init parameter to ``deny``. 

Also set ``login-url`` to ``${context-path}/router/index.html``. 

```xml
<servlet
      alias="/router"
      class="org.nasdanika.cdo.web.CDOTransactionRoutingServlet" httpcontextId="...">
   <init-param
         name="json-pretty-print"
         value="true">
   </init-param>
   <init-param
         name="default-access-decision"
         value="deny">
   </init-param>
   <init-param
         name="login-url"
         value="${context-path}/router/index.html">
   </init-param>
   <init-param
         name="ws-session-path"
         value="/session">
   </init-param>
</servlet>
```

### CDO transaction context provider

Open ``xxx-cdo-transaction-context-provider.xml`` in the application project ``OSGI-INF`` folder and add the following property:

```xml
<property name="default-access-decision" type="String" value="deny"/>
```

Also make sure that your ``<app name>CDOTransactionContextProviderComponent`` class correctly implements ``getSecurityRealm()``. 

### Implement login form

Create and register ``GuestRenderer`` and ``GuestRoute``.

#### Guest renderer

```java
import org.nasdanika.cdo.security.Guest;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.web.CDOTransactionHttpServletRequestContext;
import org.nasdanika.cdo.web.routes.app.Renderer;
import org.nasdanika.cdo.web.routes.app.ResourceProvider;

public interface GuestRenderer extends RendererBase<Guest> {

	
	GuestRenderer INSTANCE = new GuestRenderer() {};	
	
	@Override
	default Renderer<CDOTransactionHttpServletRequestContext<LoginPasswordCredentials>, Guest> chain(ResourceProvider<CDOTransactionHttpServletRequestContext<LoginPasswordCredentials>> masterResourceProvider) throws Exception {
		return new GuestRenderer() {
			
			@Override
			public ResourceProvider<CDOTransactionHttpServletRequestContext<LoginPasswordCredentials>> getMasterResourceProvider(CDOTransactionHttpServletRequestContext<LoginPasswordCredentials> context) throws Exception {
				return masterResourceProvider;
			}
			
		};
	}	

}
```

Registration in ``plugin.xml``:
```xml
<extension
      point="org.nasdanika.cdo.web.renderer">
      
... other renderers ...      
   <renderer
         eclass-name="Guest"
         namespace-uri="urn:org.nasdanika.cdo.security"
         renderer="...app.routes.GuestRenderer">
   </renderer>
</extension>
```

#### Guest route

```java
import org.nasdanika.cdo.security.Guest;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.web.CDOTransactionHttpServletRequestContext;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Form;
import org.nasdanika.html.Form.Method;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.QueryParameter;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.web.RouteMethod.Lock.Type;
import org.nasdanika.web.TargetParameter;

public class GuestRoute extends RouteBase<Guest> implements GuestRenderer {

	public GuestRoute() throws Exception {
		super();
	}
	
	@RouteMethod(
			path="index.html", 
			value = { RequestMethod.GET, RequestMethod.POST },
			lock = @RouteMethod.Lock(type = Type.READ, path = ".."), 
			comment="Renders login form on GET, processes it on POST")
	public Object indexHtml(
			@ContextParameter CDOTransactionHttpServletRequestContext<LoginPasswordCredentials> context, 
			@TargetParameter Guest target,
			@QueryParameter("url") String returnURL,
			@QueryParameter("login") String login,
			@QueryParameter("password") String password) throws Exception {
			
		
		Form loginForm = processLogin(context, returnURL, login, password);
		if (loginForm == null) {
			return Action.NOP;
		}
		
		loginForm
			.action("index.html")
			.method(Method.post)
			.bootstrap().grid().col(Bootstrap.DeviceSize.EXTRA_SMALL, 12)
			.bootstrap().grid().col(Bootstrap.DeviceSize.SMALL, 12)
			.bootstrap().grid().col(Bootstrap.DeviceSize.MEDIUM, 9)
			.bootstrap().grid().col(Bootstrap.DeviceSize.LARGE, 7);
		
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Fragment content = htmlFactory.fragment();		
		content.content(content.getFactory().tag(TagName.h3, getResourceString(context, "logIn")));
		content.content(loginForm);
				
		return renderPage(context, target, getResourceString(context, "logIn"), content);				
	}
	
	@Override
	public Object renderLeftPanel(CDOTransactionHttpServletRequestContext<LoginPasswordCredentials> context, Guest obj)	throws Exception {
		return null;
	}

}
```

The code above places the login form to the content. You can may configure and place the login form as required by your application. 
E.g. it can be an inline form in the header or you may put it to the left panel.

Registration in ``plugin.xml``:

```xml
<extension point="org.nasdanika.web.route">
   ... other routes ...
   <eobject-route
         class="...app.routes.GuestRoute"
         method="*"
         path="/"
         target="Guest"
         target-namespace-uri="urn:org.nasdanika.cdo.security">
   </eobject-route>
```   

### User home

Implement the user route as required by your application.

### NTLM authentication

This section describes how to set up NTLM authentication by putting the application behind Apache HTTPD (inspired by [Jenkins Reverse Proxy Auth Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Reverse+Proxy+Auth+Plugin). Another option is to use [WAFFLE](https://github.com/Waffle/waffle) or similar products.

#### Apache HTTPD

* Enable proxy, ntlm and rewrite modules, 
* Proxy to your app 
* Set up NTLM/SSPI authentication
* Set up rewrite rule to pass user name in ``X-Forwarded-User`` header.

```
# Required modules
LoadModule proxy_module modules/mod_proxy.so
# Maybe this one is not needed
LoadModule proxy_html_module modules/mod_proxy_html.so 
LoadModule proxy_http_module modules/mod_proxy_http.so
LoadModule rewrite_module modules/mod_rewrite.so

LoadModule auth_ntlm_module modules/mod_authn_ntlm.so

...  

ProxyPass         /myapp  http://localhost:8080/myapp nocanon
ProxyPassReverse  /myapp  http://localhost:8080/myapp
ProxyRequests     Off
AllowEncodedSlashes NoDecode

<Location "/myapp/">
    AllowOverride All
    Options FollowSymLinks
    Order allow,deny
    Allow from all
    
    AuthName "MyOrg"
    AuthType SSPI
    NTLMAuth On
    NTLMAuthoritative On
    NTLMOmitDomain On
    NTLMUsernameCase lower
    NTLMOfferBasic Off

    require valid-user

    RewriteEngine On
    RewriteCond %{LA-U:REMOTE_USER} (.+)
    RewriteRule . - [E=RU:%1]
    RequestHeader add X-Forwarded-User %{RU}e

</Location>
```

#### plugin.xml

Add ``user-name-header`` init parameter to the router servlet:

```xml
<init-param
      name="user-name-header"
      value="X-Forwarded-User">
</init-param>
```
 

### Authorization

Define packages, classes, and actions in the initial model.

#### Protected

Some model classes extend protected. Web UI to edit permissions for grantable actions. 

#### Principal

Permissions are kept @Principal. Web UI to edit permissions on model objects. 

#### Custom

Override ``authorize()``.