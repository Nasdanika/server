package org.nasdanika.cdo.web.routes.app;

import java.io.InputStream;
import java.io.Reader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.Part;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.nasdanika.cdo.EAttributeProtector;
import org.nasdanika.cdo.web.routes.app.Renderer.TypedElementLocation;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Well;

public enum RenderAnnotation {
		
		/**
		 * {@link EStructuralFeature} annotation defining whether the feature is visible in the object view.
		 * The value of this annotation can be one of the following:
		 * 
		 *   * Blank string (or annotation is not present) - the feature is editable if it is not an item (``isItem()`` returns false)
		 *   * ``true`` boolean literal - the feature is visible.
		 *   * ``false`` boolean literal - the feature is hidden.
		 *   * [JXPath](https://commons.apache.org/proper/commons-jxpath/index.html) expression. If this expression evaluates to ``true`` (compared with ``Boolean.TRUE``), then the feature is visible.
		 */
		VISIBLE("visible"),
		
		/**
		 * {@link EAttribute} annotation defining whether the attribute shall be protected.
		 * If 'true' then context is adapted to {@link EAttributeProtector} to perform protection. If adapt() returns null then EAttributeProtector.CRYPTO_PROTECTOR is used for
		 * protection.
		 */
		PROTECTED("protected"),

		/**
		 * {@link EStructuralFeature} or {@link EClass} annotation defining whether a visible feature or object is editable, i.e. shall be displayed in the edit form or an edit button shall be displayed. A feature might be editable, but disabled.
		 * The value of this annotation can be one of the following:
		 * 
		 *   * ``true`` boolean literal or empty string - the feature is editable (default).
		 *   * ``false`` boolean literal - the feature not editable.
		 *   * [JXPath](https://commons.apache.org/proper/commons-jxpath/index.html) expression. If this expression evaluates to ``true`` (compared with ``Boolean.TRUE``), then the feature is editable.
		 */
		EDITABLE("editable"),
		
		/**
		 * Set this annotation to "both" to HTML-escape feature value for view and edit, to "view" for view escaping and to "edit" for edit escaping. 
		 */
		ESCAPE("escape"),
		
//		/**
//		 * {@link EStructuralFeature} annotation defining whether elements can be deleted from the feature, i.e. delete or clear buttons shall be shown next to the element values. 
//		 * The value of this annotation can be one of the following:
//		 * 
//		 *   * ``true`` boolean literal or empty string - the feature is deletable (default).
//		 *   * ``false`` boolean literal - the feature is not deletables.
//		 *   * [JXPath](https://commons.apache.org/proper/commons-jxpath/index.html) expression. If this expression evaluates to ``true`` (compared with ``Boolean.TRUE``), then the feature is deletable.
//		 */
//		DELETABLE("deletable"),
		
		/**
		 * {@link EStructuralFeature} annotation defining whether an editable feature is disabled, i.e. it shall be displayed in the edit form, but the edit control shall be disabled.
		 * The value of this annotation can be one of the following:
		 * 
		 *   * ``false`` boolean literal or empty string - the feature is enabled (default).
		 *   * ``true`` boolean literal - the feature is disabled.
		 *   * [JXPath](https://commons.apache.org/proper/commons-jxpath/index.html) expression. If this expression evaluates to ``true`` (compared with ``Boolean.TRUE``), then the feature is disabled.
		 */
		DISABLED("disabled"),
		
		/**
		 * On EClass this annotation is a pattern which is interpolated to generate object label.
		 */
		LABEL("label"),
		
		/**
		 * Value of ``model-element-label`` render annotation is used to customize/localize name of a model element such as {@link EClass} or {@link EStructuralFeature}.
		 */
		MODEL_ELEMENT_LABEL("model-element-label"),
		
		/**
		 * Documentation annotation can be used to:
		 * 
		 * * Provide documentation for model elements if they are not documented in the model.
		 * * Localize model element documentation.
		 * 
		 */
		DOCUMENTATION("documentation"), 

		/**
		 * Format is used for rendering and parsing date and number feature values. {@link SimpleDateFormat} for dates, {@link DecimalFormat} for numbers.
		 * Can be a string or YAML map with display and edit keys if different formats are desired for display and editing.
		 */
		FORMAT("format"),

		/**
		 * Annotation to provide an icon for a model element such as {@link EClass} or {@link EStructuralFeature}.
		 * If icon contains ``/`` it is treated as URL, otherwise it is treated as css class, e.g. Bootstrap's ``glyphicon glyphicon-close``.
		 */
		ICON("icon"),
		
		/**
		 * Set this annotation on {@link EClass} to ``true`` to have the class view rendered in the item container. 
		 */
		VIEW_ITEM("view-item"),

		/**
		 * Defines {@link ETypedElement} location - view, left panel, or item container (tabs, pills, accordion). The value shall be one of {@link TypedElementLocation} constants.
		 */
		TYPED_ELEMENT_LOCATION("typed-element-location"),		
		
		/**
		 * {@link EReference} or {@link EParameter} annotation - [JXPath](https://commons.apache.org/proper/commons-jxpath/) selector of choices to assign to the reference.
		 * The path is evaluated with the current object as context.
		 */
		CHOICES_SELECTOR("choices-selector"),
		
		/**
		 * {@link EReference} or {@link EParameter} annotation - [JXPath](https://commons.apache.org/proper/commons-jxpath/) filter of choices to assign to the reference.
		 * The expression shall return true for the choice to be used. Choice object is available in 'choice' variable.
		 * Choice filter is ignored when choices selector is used.
		 */
		CHOICE_FILTER("choice-filter"),
				
		/**
		 * {@link ENamedElement} category. Categories are displayed as panels in the view and field sets in edit forms.
		 */
		CATEGORY("category"),
		
		/**
		 * Set this annotation to ``list`` on {@link EReference} to have elements rendered in a list instead of a table.
		 */
		VIEW("view"),
		
		/**
		 * {@link EClass} annotation, ``true`` or ``false`` defining whether a new object's view page shall be opened upon creation.
		 * If not specified, defaults to ``true`` for objects which have visible features with feature locations different from ``view`` (e.g. ``item``) and to ``false`` otherwise.  
		 * 
		 */
		VIEW_ON_CREATE("view-on-create"),		
		
		/**
		 * {@link EReference} annotation listing reference elements {@link EStructuralFeature}s to show in a reference item table.
		 * The value of this annotation can be one of the following:
		 * 
		 * * A space-separated list of feature names.
		 * * A YAML document list of feature names or mappings of feature name to feature configuration definition, which may include:
		 *     * ``visible`` - [JXPath](https://commons.apache.org/proper/commons-jxpath/index.html) expression. If this expression evaluates to ``true`` (compared with ``Boolean.TRUE``), then the feature is included in the list.
		 *     * ``filter`` - if set to true, then a filter drop-down is shown in the feature column header in the feature view.
		 *     * ``attributes`` - a map of attributes to apply to the feature cells.
		 *     * ``classes`` - a string or a list of CSS classes to apply (can also be specified through the ``class`` attribute)
		 *     * ``style`` - a string or a map of css style attributes to their values (can also be specified through the ``style`` attribute)
		 *       
		 * Example:
		 * ```yaml
		 * - name:
		 *     classes: bg-success
		 *     attributes: 
		 *         width: 5px
		 * - age:
		 *     classes: 
		 *         - col-xs-3
		 *         - bg-info
		 * - ssn
		 * ```
		 *        
		 */
		VIEW_FEATURES("view-features"),
		
		/**
		 * {@link EReference} annotation specifying {@link EClass}es of elements which can be instantiated and set/added to the reference.  
		 * The list of element types shall be space-separated. Elements shall be in
		 * the following format: ``<eclass name>[@<epackage ns uri>]``. EPackage namespace URI part can be omitted if the class is in the same package with the 
		 * feature's declaring EClass. If the annotation starts with ``#`` then the rest of it is considered as a comment. This can be used to clearly
		 * specify an empty list of element types, e.g. if ``factory`` EOperations or template objects are used to populate the references.
		 */
		ELEMENT_TYPES("element-types"),

		/**
		 * {@link ETypedElement} annotation specifying edit form control type for a feature or parameter. 
		 * Defaults to input for attributes and multi-value features and select for references.
		 * 
		 * Valid values:
		 * 
		 *     * input (default for {@link EAttribute}),
		 *     * select (default for {@link EReference},
		 *     * textarea
		 */
		CONTROL("control"),
		
		/**
		 * Control configuration shall be a YAML map of control attribute names to values. 
		 * If value is a map, then it is output as css values - colon separated keys and values and semicolon separated entries. E.g. style attribute can be specified as a map.
		 * If value is a list, then it is output as space-separated entries. E.g. class attribute can be specified as a list.
		 */
		CONTROL_CONFIGURATION("control-configuration"),
		
		/**
		 * {@link ETypedElement} annotation for ``input`` control - one of {@link HTMLFactory.InputType} values. 
		 * Defaults to checkbox for booleans and multi-value features, text otherwise.
		 */
		INPUT_TYPE("input-type"),

		/**
		 * {@link ETypedElement} (attribute or parameter) annotation for select, radio and checkbox on non-boolean types. 
		 * 
		 * YAML map of values to labels or list if values and labels are the same.   
		 */
		CHOICES("choices"),
		
		/**
		 * {@link ETypedElement} annotation to explicitly specify whether to use form input group or not. 
		 */
		FORM_INPUT_GROUP("form-input-group"),
		
		/**
		 * By default EClass edit forms are rendered as horizontal forms by the {@link Route}. Set this annotation to ``false`` to change the default rendering.
		 */
		HORIZONTAL_FORM("horizontal-form"),
		
		/**
		 * {@link EClass} annotation. Set it to true to disable HTML 5 form validation, e.g. if you have a required component with HTML content rendered by
		 * TinyMCE in Chrome.
		 */
		NO_VALIDATE("no-validate"),
		
		/**
		 * {@link ETypedElement} annotation specifying feature value content type. If attribute control is ``textarea`` and content type is ``text/html`` then 
		 * the textarea is initialized with wysiwyg.js editor - http://wysiwygjs.github.io/. 
		 */
		CONTENT_TYPE("content-type"),
		
		/**
		 * Defines model element ({@link EClass} or {@link ETypedElement}) constraint used for validation. Constraint shall be a YML text which defines a single constraint or a list of constraints. 
		 * 
		 * Constraint can be a string or a map containing:
		 * 
		 * * ``condition`` - XPath expression boolean expression.
		 * * ``errorMessageKey`` - Optional error message key. If it is present, error message is retrieved as resource string.
		 * * ``errorMessage`` - Error message to display if the expression evaluates to false. It is used if ``errorMessageKey`` is not defined or if there is no resource string for the key. 
		 * 
		 * If the constraint is a String, then it is treated as ``condition`` XPath expression and error message is constructed as ``Constraint violation: <condition>``. 
		 * 
		 */
		CONSTRAINT("constraint"),
		
		/**
		 * {@link ETypedElement} or {@link EClass} annotation - XPath expression to use for sorting of items in tables and lists.  
		 */
		SORT("sort"),
		
		/**
		 * {@link EOperation} annotation which exposes the EOperation through the web UI. The value of this annotation shall be a YAML map
		 * with the following keys:
		 * 
		 * * ``action`` - Security action. Defaults to {@link AuthorizationProvider.StandardAction}.execute.
		 * * ``confirm`` - If set, then click on the button shows this confirmation message before executing the operation. May contain {{object-label}} token. For feature-value operations the message may contain ``{{element-label}}`` token.
		 * * ``consumes`` - Single value or a list or content types which this web operation can consume.
		 * * ``feature`` - Feature name to associate this web operation with. If this value is present, web operation invocation button will be displayed in the corresponding feature view instead of the object view. Feature name is passed to the eOperation as ``feature`` query parameter.
		 * * ``feature-value`` - Feature name to associate this web operation with. If this value is present, web operation invocation button will be displayed in the corresponding feature value element instead of the object view. Feature name is passed to the eOperation as ``feature`` query parameter. Element CDO ID is passed to the eOperation as ``element`` query parameter and its position as ``position`` parameter.
		 * * ``lock`` - Lock to apply on the repository in order to execute the operation 
		 *     * ``path`` - [JXPath](https://commons.apache.org/proper/commons-jxpath/) path of the object to apply the lock to. If not set, the lock is applied to the target object.
		 *     * ``type`` - Lock type, one of ``none``, ``read``, ``write``, or ``imply-from-http-method`` (default). ``imply-from-http-method`` implies ``write`` for ``DELETE``, ``PATCH``, ``POST``, and ``PUT`` and ``read`` otherwise.
		 *     * ``timeout`` - Lock timeout in milliseconds. Defaults to one minute.
		 * * ``method`` - HTTP method which matches the operation. If not set then it defaults to ``GET`` for EOperation invocation (so it can be invoked by clicking on a button). If EOperation has unbound parameters, then ``GET`` method renders a form with those parameters and ``POST`` by the form invokes the operation after input validation against operation and parameter ``constraint``'s.
		 * * ``path`` - Web operation path. It may contain path parameters in the form ``{<parameter name>}``. Defaults to the EOperation name.
		 * * ``produces`` - Content type produced by the operation.
		 * * ``role`` - one of {@link EOperationTargetInfo.Role} constants. Defaults to ``operation`` if not present.
		 * * ``style`` - {@link org.nasdanika.html.Bootstrap.Style} enum value for button or left panel item depending on location. Defaults to ``INFO`` for buttons and ``DEFAULT`` for left panel items.
		 * 
		 * If you have a web operation with all defaults put a comment (``# comment``) or a document start (``---``) or both in the details.
		 */
		WEB_OPERATION("web-operation"),
		
		/**
		 * {@link EParameter} annotation binding web operation parameter to one request or context values. Unbound parameters are implicitly bound to the form input with the same name.
		 * The value of this annotation is a single value or a single-entry YAML map or a single value:
		 * 
		 * * ``body`` - Binds the parameter to request body.
		 * * ``context`` - Binds the parameter to the context.
		 * * ``cookie`` - Binds the parameter to a cookie with the same name as the parameter name.
		 * * ``cookie: name`` - Binds the parameter to the named cookie.
		 * * ``expression: expression`` - JXPath expression (which can also be a constant) to evaluate. E.g. ``$context/principals/login``   
		 * * ``extension`` - Binds the parameter to registered extension(s). This key's value shall be a map with the following elements:
		 *     * ``point`` - Extension point ID.
		 *     * ``configuration-element`` - Configuration element name.
		 *     * ``class-attribute`` - Attribute containing the class name. Defaults to ``class``.
		 * * ``form`` (default) - Binds the parameter to the query parameter with the same name as {@link EParameter} if request method is ``POST``.
		 * * ``form: name`` - Binds the parameter to the named query parameter if request method is ``POST``.
		 * * ``header`` - Binds the parameter to a header with the same name as the parameter name.
		 * * ``header: name`` - Binds the parameter to the named header.
		 * * ``null`` - Binds parameter to ``null``.
		 * * ``part`` - Binds the parameter to a part with the same name as the parameter name. Parameter type shall be {@link Part}, {@link InputStream}, byte[], {@link Reader}, String, or other type which Part or InputStream can be converted to.
		 * * ``part: name`` - Binds the parameter to the named part.
		 * * ``part-file-name: name`` - Binds the parameter to the named part. Parameter type shall be String. This binding would typically be used with ``part`` binding to avoid introducing dependency on the servlet API in the model.
		 * * ``path`` - Binds the parameter to a path parameter with the same name as the parameter name.
		 * * ``path: name`` - Binds the parameter to the named path parameter.
		 * * ``query`` - Binds the parameter to the query parameter with the same name as {@link EParameter}.
		 * * ``query: name`` - Binds the parameter to the named query parameter.
		 * * ``service`` - Binds the parameter to an OSGi service with the same type as the parameter type.
		 * * ``service: filter`` - Binds the parameter to an OSGi service applying the specified filter.
		 * * ``value: value`` - Binds the parameter to a constant value.
		 */
		BIND("bind"),	
		
		/**
		 * Provides default value for {@link EParameter}.
		 */
		DEFAULT_VALUE("deafult-value"),

//---		
		/**
		 * {@link ETypedElement} annotation indicating that the table listing reference elements shall display elements type in a type column. 
		 * The value of this annotation is a pattern which is interpolated with the following tokens:
		 * 
		 * * ``icon`` - Element icon.
		 * * ``eclass-icon`` - Element type icon.
		 * * ``eclass-label`` - Element type label.
		 * * ``documentation-icon`` - Documentation icon or blank string if there is no documentation.
		 * 
		 * This annotation is useful for references containing elements of different types.
		 */
		TYPE_COLUMN("type-column"),		
		
		/**
		 * {@link EClass} yaml annotation which defines feature items container and its configuration.
		 * If not present, features items are rendered as tabs.
		 * 
		 * Supported containers:
		 * 
		 * * ``tabs`` - may contain ``justified`` sub-element set to ``true``. 
		 * * ``pills`` - may contain sub-elements:
		 *     * ``stacked``
		 *     * ``justified``
		 *     * ``width``
		 * * ``accordion`` - may contain ``style`` sub-element with value corresponding to one of {@link Bootstrap.Style} enum constants.
		 * 
		 * Examples:
		 * 
		 * ```
		 * tabs
		 * 
		 * tabs:
		 *     justified: true
		 *     
		 * pills
		 * 
		 * pills:
		 *     stacked: true
		 *     justified: true
		 *     width: 2
		 *  
		 * pills:
		 *     stacked: true
		 *     justified: true
		 *     width: 
		 *         xs: 5
		 *         lg: 1
		 *         
		 * accordion
		 * 
		 * accordion
		 *     style: PRIMARY         
		 * ```
		 */
		FEATURE_ITEMS_CONTAINER("feature-items-container"),
		
		/**
		 * {@link EStructuralFeature} annotation specifying XPath expression evaluating to the placeholder value for features. Placeholder value is an implicit application-specific value, different from the 
		 * default value. For example, in hierarchical structures children may implicitly inherit parent feature value, unless it is explicitly set (overridden) in the child.
		 * 
		 * In the absence of feature value (null or blank string for strings) placeholder values are displayed in the view in a small {@link Well}.
		 */
		PLACEHOLDER("placeholder"),
		
		/**
		 * {@link EClass} or {@link EReference} annotation containing a list of features to group by left panel menu items. 
		 * A tree node is created for each feature value.
		 */
		GROUP_BY("group-by"),

//===		
		/**
		 * {@link EReference} annotation. 
		 * If value is ``true``, for radios and checkboxes choices are represented according to their containment hierarchy in the model. 
		 * If value is ``reference-nodes``, then containing references are shown as nodes in the tree. 
		 */
		CHOICE_TREE("choice-tree"), 
				
		/**
		 * {@link EStructuralFeature} annotation indicating whether the feature elements shall be shown in the left panel tree. True or false.
		 * In the absence of this annotation containing many features are considered as tree features. 
		 */
		TREE_FEATURE("tree-feature"),
		
		/**
		 * {@link EStructuralFeature} annotation indicating whether the feature shall be shown in the breadcrumbs path. True or false.
		 * In the absence of this annotation containing many features are considered as tree features. 
		 */
		PATH_FEATURE("path-feature"),
		
		/**
		  * {@link EStructuralFeature} annotation. If it is set to false, then feature elements
		  * appear directly under the container in the tree. 
		  * Otherwise, a tree node with feature name and icon (if available) is created to hold feature elements. 		 
		  */
		TREE_NODE("tree-node");		
				
		public final String literal;
		
		private RenderAnnotation(String literal) {
			this.literal = literal;
		}
	}