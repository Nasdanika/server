# Application rendering

Overview - CRUD, annotations, Ecore elements - classes, features, operations, many, containment.

## Rendering annotations

Resolution - resource strings, chaining, model annotations, annotation source.

## View

## Create

## Edit

## Delete



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