# Application rendering

This page describes how to create model-driven web applications leveraging classes and interfaces in [org.nasdanika.cdo.web.routes.app](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/package-summary.html) package of the [org.nasdanika.cdo.web](https://github.com/Nasdanika/server/tree/master/org.nasdanika.cdo.web) bundle, [Renderer](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/Renderer.html) and [Route](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/Route.html) in particular.

The sections below outline the entire process of creating a web application focusing on use and customization of application routes and renderers. You can find a detailed description of the entire process in the [Server-side Java Development for Innovators](https://server-side-java-development-for-innovators.books.nasdanika.org/) online book, which is work in progress at 
the time of this writing.

## Overview

The core concept of the approach described here is that Web UI can be rendered using metadata of the model elements such as [EClass](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EClass.html), [EAttribute](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EAttribute.html), and [EReference](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EReference.html). 

Rendering is performed by the Renderer interface with default method implementations or by its sub-interfaces. Renderers shall be registered with ``org.nasdanika.cdo.web.renderer`` extension point in order to be discoverable by ``Renderer.getRenderer()`` methods.

Route class extends [EDispatchingRoute](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/EDispatchingRoute.html) and implements Renderer. It contains
route methods which leverage rendering methods to build the UI.

Rendering can be customized with:

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

#### Add render annotations

The way the Web UI is rendered can be customized in several ways, one of them being adding render annotations to the model. 
On the one hand it mixes the domain and the UI concerns, but on the other it allows to keep all things in one place - the model. 
This approach might be handy if the model developer is also responsible for the model UI so they have an idea how a particular model element shall appear in the UI.

The up-to date list of supported render annotations can be found in [RenderAnnotation](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/Renderer.RenderAnnotation.html) enum. Check the [source code](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/src-html/org/nasdanika/cdo/web/routes/app/Renderer.html#line.136) for literals to use in the model annotations.

Below is a list of render annotations with short descriptions grouped by the model element type:

* EModelElement
    * ``constraint`` - defines validation constraints using XPath.
    * ``documentation`` - can be used to define model element documentation if it is not defined in the GenModel annotation.
    * ``icon`` - defines model element icon. If icon annotation contains ``/`` it is treated as URL, otherwise it is treated as css class, e.g. Bootstrap's ``glyphicon glyphicon-close``. 
    * ``model-element-label`` - used to customize a model element label.
    * ``sort`` - XPath expression to use for sorting of items in tables and lists.
* EClass
    * ``feature-items-container`` - YAML annotation which defines feature items container and its configuration.
    * ``horizontal-form`` - set to ``false`` to change the default rendering.
    * ``label`` - a pattern which is interpolated with values of object features to generate object label. E.g. ``{{name}} ({{code}})``.
    * ``no-validate`` - disables HTML5 validation in forms.
    * ``view-item`` - if ``true`` then the class view is rendered in the item container (accordion, tabs, or pills) along with references.
* EStructuralFeature (EAttribute or EReference)
    * ``category`` - feature category. Categories are displayed as panels in the view and field sets in edit forms.
    * ``control`` - defines edit form control type - ``input``, ``select``, or ``textarea``.
    * ``control-configuration`` - a YAML map of control attribute names to values.
    * ``disabled`` - defines whether an editable feature control shall be disabled.
    * ``editable`` - defines editability of a visible feature.
    * ``feature-location`` - defines feature location - view, left panel, item container (tabs, pills, accordion), or inline (work in progress).
    * ``form-input-group`` - overrides the default decision of rendering control in a FormGroup or FormInputGroup.
    * ``input-type`` - input type if control is set to ``input``.
    * ``placeholder`` - XPath expression evaluating to the placeholder value for features. Placeholder value is an implicit application-specific value, different from the default value.
    * ``visible`` - defines visibility of a feature in the object view.
* EAttribute
    * ``choices`` - a YAML map of values to labels or a list if values and labels are the same.
    * ``content-type`` - set to ``text/html`` on attribute rendered in ``textarea`` to wrap the area into [TinyMCE](https://www.tinymce.com) editor.
    * ``format`` - to use for rendering and parsing number and date values.
* EReference
    * ``choices-selector`` - [JXPath](https://commons.apache.org/proper/commons-jxpath/) selector of choices to assign to the reference.
    * ``choice-tree`` - allows to display choices in a containment tree. 
    * ``element-types`` - specifies EClass'es of elements which can be instantiated and set/added to the reference.
    * ``type-column`` - indicates that the table listing reference elements shall display elements type in a type column.
    * ``view`` - Set this annotation to ``list`` on to have elements rendered in a list instead of a table.
    * ``view-features`` - list of features to show in a reference item table.

Consult JavaDoc and source code for details.


By default render annotations source is ``org.nasdanika.cdo.web.render``. It can be customized by overriding ``Renderer.getRenderAnnotationSource()``. 
One possibility which this customization opens is having multiple sets of render annotations and switching between them at runtime based on some criterion. 

You may also override ``String getRenderAnnotation(C context, EModelElement modelElement, String key)`` method to load annotations from other sources, e.g. from
a database.

### Generate model code, edit support, and editor

Edit and editor support are needed to create the initial model for your application. If you are planning building the application model from scratch in the web UI or programmatically then you 
don't need to generate edit/editor.

#### Customize editor, e.g. add ``Set password`` action

You may consider adding the following two modifications to the editor:

* Add master-detail view as described [here](https://github.com/Nasdanika/presentation).
* Add "Set Password" action for model elements which extend [LoginPasswordHashUser](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security/apidocs/org/nasdanika/cdo/security/LoginPasswordHashUser.html). This [gist](https://gist.github.com/pvlasov/ec2dd1bfa9f8d625c28d59caa5627b78) explains how to add "Set Password" action.

### Create the initial application model

The session initalizer generated by the wizard contains commented out code which loads initial model(s) from file(s) on first start.
To initialize the repository you need to:

* Use the editor to create the initial model.
* Set ``initial-content`` property of the session initializer OSGi component. Property value can contain tokens which are expanded using system properties, e.g. ``<property name="initial-content" type="String" value="${my-initial-model}"/>``. ``my-initial-model`` system property shall be set to the location of the initial model file.
* Make adjustments in the session initializer code if required. 

### Create Web UI generator model and generate code

The simplest way to get going is to register a route which would serve all classes from your application EPackage using default render/route implementations and model annotations. To do so manually register a route for your EPackage in the app project ``plugin.xml``:

```xml
<extension point="org.nasdanika.web.route">
   ... other routes ...
   <eobject-route
         class="org.nasdanika.cdo.web.routes.app.Route"
         method="*"
         path="/"
         target-namespace-uri="...your EPackage NS URI here...">
   </eobject-route>
```   

This approach may work perfectly fine in simple cases. However, if you want to localize your application or provide customizations not supported by annotations, you need to register class-specific renderers and/or routes. It can be done manually as well
 - see the ``Guest renderer`` and ``Guest route`` sections below. 
 
However, if your application model contains more than just a couple of classes, it is easier to generate renderer interfaces, route classes, their registrations, and resource bundles. This is what this section is about.   

First of all you shall install:

* [Nasdanika Ecore Code Generator](https://github.com/Nasdanika/codegen-ecore)
* [Web UI code generation target](https://github.com/Nasdanika/codegen-ecore-web-ui)

As a reminder, you can install them from ``http://www.nasdanika.org/repository``.

After installation read how to create and generate the model in the ``Nasdanika / Code generation`` section in the Eclipse help. This documentation is also available online:

* [Ecore Code Generator](https://github.com/Nasdanika/codegen-ecore/blob/master/org.nasdanika.codegen.ecore.editor/doc/ecore.md)
* [Web UI code generation target](https://github.com/Nasdanika/codegen-ecore-web-ui/blob/master/org.nasdanika.codegen.ecore.web.ui/doc/web-ui-generation-target.md)

### Customize/localize the Web UI

There are three ways to customize the Web UI in addition to annotating the model:

* Resource bundles
* Override renderer methods
* Override route methods


#### Resource bundles

The obvious use of resource bundles is localization. Out-of-the box the framework provides some localized messages for Russian and Spanish (thanks to Google Translate). 
You can use resource bundles to customize the UI if you did not annotate the model and/or to override model-level annotations. Resource property name format is ``<model element type>.<model element name>.<annotation>``, e.g. 

* ``class.Account.label``
* ``reference.transactions.icon``

You can also use resource bundles for contextual customization. For example, let's say you have have class ``Account`` with containment reference to class ``Transaction`` with attribute ``amount``.
 
To define an icon for ``amount`` attribute you can annotate the attribute in the model or add ``attribute.amount.icon=...`` property to  the ``Transaction.properties`` resource. If you want to have a different icon when transactions are displayed in the account view you can set the following property in ``Account.properties`` - ``reference.transactions.attribute.amount.icon``.   

##### Resource references 

Values of some resource properties can be rather large, e.g. localizations of model elements documentation. Such values can be put to their own files and be referenced by adding ``@`` at the end of the property. For example, ``attribute.amount.documentation@=<relative or absolute url of documentation resource>``. 
This technique can also be used for pulling dynamic values, e.g. ``attribute.currency.choices@=http://...`` will pull a list of currencies from an external URL.

#### Renderer methods

Renderer has quite a few methods, which might be scary at first. This section groups these methods by their purpose and provides quick overview of what each method does. As usual, JavaDoc provides more details, and source code is the final authority.

many methods - fine grained. reference impl.

##### General

* ``getHTMLFactory(C)``
* ``getObjectURI(C, T)``

##### Resource (strings) and annotations

* ``chain(ResourceProvider<C>)`` -
* ``getLocale(C)`` -
* ``getMasterResourceProvider(C)`` -
* ``getRenderAnnotation(C, EModelElement, RenderAnnotation)`` -
* ``getRenderAnnotation(C, EModelElement, String)`` -
* ``getRenderAnnotationSource(C)`` -
* ``getRenderer(EClass)`` -
* ``getRenderer(M)`` -
* ``getResource(C, ENamedElement, String)`` - 
* ``getResource(C, String)`` - 
* ``getResourceBundleClasses(C)`` - 
* ``getResourceString(C, ENamedElement, String, boolean)`` - 
* ``getResourceString(C, String)`` - 
* ``getResourceString(C, String, boolean)`` - 
* ``getYamlRenderAnnotation(C, EModelElement, RenderAnnotation)`` - 
* ``getYamlRenderAnnotation(C, EModelElement, String)`` - 
* ``

##### Documentation

* ``createPegDownLinkRenderer(C)`` - 
* ``firstHtmlSentence(C, String)`` - 
* ``firstSentence(C, String)`` - 
* ``getEClassifierDocRef(C, EClassifier)`` - 
* ``getMaxFirstSentenceLength()`` - 
* ``getMinFirstSentenceLength()`` - 
* ``markdownToHtml(C, String)`` - 
* ``renderDocumentation(C, EModelElement)`` - 
* ``renderDocumentationIcon(C, EModelElement, Modal, boolean)`` - 
* ``renderDocumentationModal(C, EModelElement)`` - 
* ``renderEditableFeaturesDocModals(C, T)`` - 
* ``renderFeatureFormGroupHelpText(C, T, EStructuralFeature, Modal)`` - 
* ``renderFeaturesDocModals(C, T, Collection<EStructuralFeature>)`` - 
* ``renderFirstDocumentationSentence(C, EModelElement)`` - 
* ``renderHelpIcon(C)`` - 
* ``renderVisibleFeaturesDocModals(C, T)`` - 

##### Viewing

* ``getFeatureCategory(C, EStructuralFeature, Collection<EStructuralFeature>)`` -
* ``getAutoCategory(C, EStructuralFeature, Collection<EStructuralFeature>)`` - 
* ``getFeatureLocation(C, EStructuralFeature)`` - 
* ``getFeatureSortKey(C, T, EStructuralFeature, Object)`` - 
* ``getIcon(C, T)`` - 
* ``getModelElementIcon(C, EModelElement)`` - 
* ``getPlaceholder(C, T, EStructuralFeature)`` - 
* ``getReferenceElementTypes(C, T, EReference)`` - 
* ``getReferenceRenderer(EReference, M)`` - 
* ``getVisibleFeatures(C, T, FeaturePredicate)`` - 
* ``isObjectPathRoot(C, T, EObject)`` - 
* ``isRequired(C, T, EStructuralFeature)`` - 
* ``isSortFeatureValues(C, T, EStructuralFeature)`` - 
* ``isViewItem(C, T)`` - 
* ``nameToLabel(String)`` - 
* ``renderAddIcon(C)`` - 
* ``renderCancelButton(C, T)`` - 
* ``renderCancelIcon(C)`` - 
* ``renderClearIcon(C)`` - 
* ``renderCreateIcon(C)`` - 
* ``renderDeleteButton(C, T)`` - 
* ``renderDeleteIcon(C)`` - 
* ``renderDetailsIcon(C)`` - 
* ``renderEditButton(C, T)`` - 
* ``renderEditIcon(C)`` - 
* ``renderFalse(C)`` - 
* ``renderFeatureAddButton(C, T, EStructuralFeature)`` - 
* ``renderFeatureCategoryIcon(C, EStructuralFeature, Collection<EStructuralFeature>)`` - 
* ``renderFeatureCategoryIconAndLabel(C, EStructuralFeature, Collection<EStructuralFeature>)`` - 
* ``renderFeatureCategoryLabel(C, EStructuralFeature, Collection<EStructuralFeature>)`` - 
* ``renderFeatureIconAndLabel(C, EStructuralFeature, Collection<EStructuralFeature>)`` - 
* ``renderFeatureItemsContainer(C, T, Map<EStructuralFeature, Modal>)`` - 
* ``renderFeatureLabel(C, EStructuralFeature, Collection<EStructuralFeature>)`` - 
* ``renderFeaturePath(C, T, EStructuralFeature, String, Breadcrumbs)`` - 
* ``renderFeatureValue(C, EStructuralFeature, Object)`` - 
* ``renderFeatureValueDeleteButton(C, T, EStructuralFeature, int, Object)`` - 
* ``renderFeatureValueEditButton(C, T, EStructuralFeature, int, Object)`` - 
* ``renderFeatureValueViewButton(C, T, EStructuralFeature, int, EObject)`` - 
* ``renderFeatureView(C, T, EStructuralFeature, boolean, Predicate<Object>, Comparator<Object>)`` - 
* ``renderIcon(C, T)`` - 
* ``renderIconAndLabel(C, T)`` - 
* ``renderLabel(C, T)`` - 
* ``renderLeftPanel(C, T)`` - 
* ``renderLink(C, T, boolean)`` - 
* ``renderModelElementIcon(C, EModelElement)`` - 
* ``renderNamedElementIconAndLabel(C, ENamedElement)`` - 
* ``renderNamedElementLabel(C, ENamedElement)`` - 
* ``renderObjectHeader(C, T, Modal)`` - 
* ``renderObjectPath(C, T, Object)`` - 
* ``renderObjectPath(C, T, String, Breadcrumbs)`` - 
* ``renderReferencesTree(C, T, int, Function<Object, Object>, boolean)`` - 
* ``renderTreeItem(C, T, int, Function<Object, Object>, boolean)`` - 
* ``renderTrue(C)`` - 
* ``renderView(C, T, Map<EStructuralFeature, Modal>)`` - 
* ``renderViewButtons(C, T)`` - 
* ``renderViewFeatures(C, T, Map<EStructuralFeature, Modal>)`` - 
* ``renderViewItemLabel(C, T)`` - 
* ``wireDeleteButton(C, T, Button)`` - 
* ``wireEditButton(C, T, Button)`` - 
* ``wireFeatureAddButton(C, T, EStructuralFeature, Button)`` - 
* ``wireFeatureValueDeleteButton(C, T, EStructuralFeature, int, Object, Button)`` - 
* ``wireFeatureValueEditButton(C, T, EStructuralFeature, int, Object, Button)`` - 
* ``wireFeatureValueViewButton(C, T, EStructuralFeature, int, EObject, Button)`` - 

##### Editing

* ``compareEditableFeatures(C, T, Consumer<Diagnostic>)`` - 
* ``getEditableFeatures(C, T)`` - 
* ``getFeatureChoices(C, T, EStructuralFeature)`` - 
* ``getFormControlValue(C, T, EStructuralFeature, Object)`` - 
* ``getReferenceChoices(C, T, EReference)`` - 
* ``parseFeatureValue(C, EStructuralFeature, String)`` - 
* ``renderEditableFeaturesFormGroups(C, T, FieldContainer<?>, Map<EStructuralFeature, Modal>, Map<EStructuralFeature, List<ValidationResult>>, boolean)`` - 
* ``renderEditForm(C, T, List<ValidationResult>, Map<EStructuralFeature, List<ValidationResult>>, boolean)`` - 
* ``renderFeatureControl(C, T, EStructuralFeature, FieldContainer<?>, Modal, List<ValidationResult>, boolean)`` - 
* ``renderFeatureEditForm(C, T, EStructuralFeature, List<ValidationResult>, boolean)`` - 
* ``renderFeatureFormGroup(C, T, EStructuralFeature, FieldContainer<?>, Modal, List<ValidationResult>, boolean)`` - 
* ``renderSaveButton(C, T)`` - 
* ``renderSaveIcon(C)`` - 
* ``renderTinymceInitScript(C, TextArea)`` - 
* ``setEditableFeatures(C, T, Consumer<Diagnostic>)`` - 
* ``setFeatureValue(C, T, EStructuralFeature)`` - 
* ``validate(C, T)`` - 
* ``validate(C, T, EModelElement, DiagnosticChain)`` - 
* ``wireCancelButton(C, T, Button)`` - 
* ``wireSaveButton(C, T, Button)`` - 

#### Route methods


##### Page rendering

* ``createRenderPageEnvironment(C)`` - 
* ``renderBody(C, Object, Object, Object, Object)`` - 
* ``renderFooter(C, T)`` - 
* ``renderHead(C, T)`` - 
* ``renderHeader(C, T)`` - 
* ``renderPage(C, T, String, Object)`` - 
* ``getPageTemplate(C)`` - 
* ``getTheme(C, T)`` - 
* ``setLeftPanelAndContentColSizes(C, UIElement<?>, UIElement<?>)`` - 

##### Viewing

* ``getIndexHtml(C, T)`` - 
* ``viewFeature(C, String, T)`` - 

##### Creation

* ``createContainementFeatureElement(C, T, String, String, String, String, String)`` - 

##### Editing
 
* ``edit(C, T, String, String, String)`` - 
* ``editFeature(C, String, T)`` - 
* ``editFeatureElement(C, String, String, T)`` - 
* ``selectReferenceFeatureElement(C, T, String, String, String)`` -
 
##### Deleting
 
* ``deleteFeature(C, T, String, String)`` - 
* ``deleteFeatureElement(C, T, String, String, String)`` - 
* ``getDeleteHtml(C, T, String)`` - 

##### Security

* ``processLogin(C, String, String, String)`` - 
* ``getLogoutHtml(C, String)`` - 

##### Developer routes 
* ``getApiDocPath()`` - 
* ``xPathEvaluator(C, T, String, String)`` - 
### Secure the application

This section describes how to secure the web application.

#### Set redirection to principal home

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

#### Change default access decision to deny

##### Routing servlet

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

#### CDO transaction context provider

Open ``xxx-cdo-transaction-context-provider.xml`` in the application project ``OSGI-INF`` folder and add the following property:

```xml
<property name="default-access-decision" type="String" value="deny"/>
```

Also make sure that your ``<app name>CDOTransactionContextProviderComponent`` class correctly implements ``getSecurityRealm()``. 

#### Implement login form

Create and register ``GuestRenderer`` and ``GuestRoute``.

##### Guest renderer

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

##### Guest route

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

#### User home

Implement the user route as required by your application.

#### NTLM authentication

This section describes how to set up NTLM authentication by putting the application behind Apache HTTPD (inspired by [Jenkins Reverse Proxy Auth Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Reverse+Proxy+Auth+Plugin). Another option is to use [WAFFLE](https://github.com/Waffle/waffle) or similar products.

##### Apache HTTPD

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

##### plugin.xml

Add ``user-name-header`` init parameter to the router servlet:

```xml
<init-param
      name="user-name-header"
      value="X-Forwarded-User">
</init-param>
```
 

#### Authorization

Define packages, classes, and actions in the initial model.

##### Protected

Some model classes extend protected. Web UI to edit permissions for grantable actions. 

##### Principal

Permissions are kept @Principal. Web UI to edit permissions on model objects. 

##### Custom

Override ``authorize()``.

### Additional generation targets

* Stories
* UI Driver and tests
* Custom 

### Build and deploy


