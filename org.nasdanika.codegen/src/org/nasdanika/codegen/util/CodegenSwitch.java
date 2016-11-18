/**
 */
package org.nasdanika.codegen.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.nasdanika.codegen.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.nasdanika.codegen.CodegenPackage
 * @generated
 */
public class CodegenSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CodegenPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenSwitch() {
		if (modelPackage == null) {
			modelPackage = CodegenPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CodegenPackage.CONFIGURABLE: {
				Configurable configurable = (Configurable)theEObject;
				T1 result = caseConfigurable(configurable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.CONFIGURATION_ITEM: {
				ConfigurationItem<?> configurationItem = (ConfigurationItem<?>)theEObject;
				T1 result = caseConfigurationItem(configurationItem);
				if (result == null) result = caseProvider(configurationItem);
				if (result == null) result = caseConfigurable(configurationItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.SERVICE: {
				Service<?> service = (Service<?>)theEObject;
				T1 result = caseService(service);
				if (result == null) result = caseConfigurationItem(service);
				if (result == null) result = caseProvider(service);
				if (result == null) result = caseConfigurable(service);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.PROPERTY: {
				Property<?> property = (Property<?>)theEObject;
				T1 result = caseProperty(property);
				if (result == null) result = caseConfigurationItem(property);
				if (result == null) result = caseProvider(property);
				if (result == null) result = caseConfigurable(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.CONTEXT_PROVIDER: {
				ContextProvider contextProvider = (ContextProvider)theEObject;
				T1 result = caseContextProvider(contextProvider);
				if (result == null) result = caseConfigurable(contextProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.IGENERATOR: {
				IGenerator<?> iGenerator = (IGenerator<?>)theEObject;
				T1 result = caseIGenerator(iGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.GENERATOR: {
				Generator<?> generator = (Generator<?>)theEObject;
				T1 result = caseGenerator(generator);
				if (result == null) result = caseIGenerator(generator);
				if (result == null) result = caseContextProvider(generator);
				if (result == null) result = caseConfigurable(generator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.GROUP: {
				Group<?> group = (Group<?>)theEObject;
				T1 result = caseGroup(group);
				if (result == null) result = caseGenerator(group);
				if (result == null) result = caseIGenerator(group);
				if (result == null) result = caseContextProvider(group);
				if (result == null) result = caseConfigurable(group);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.RESOURCE_GENERATOR: {
				ResourceGenerator<?> resourceGenerator = (ResourceGenerator<?>)theEObject;
				T1 result = caseResourceGenerator(resourceGenerator);
				if (result == null) result = caseGenerator(resourceGenerator);
				if (result == null) result = caseIGenerator(resourceGenerator);
				if (result == null) result = caseContextProvider(resourceGenerator);
				if (result == null) result = caseConfigurable(resourceGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.WORKSPACE_ROOT: {
				WorkspaceRoot workspaceRoot = (WorkspaceRoot)theEObject;
				T1 result = caseWorkspaceRoot(workspaceRoot);
				if (result == null) result = caseResourceGenerator(workspaceRoot);
				if (result == null) result = caseGenerator(workspaceRoot);
				if (result == null) result = caseIGenerator(workspaceRoot);
				if (result == null) result = caseContextProvider(workspaceRoot);
				if (result == null) result = caseConfigurable(workspaceRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.FOLDER: {
				Folder folder = (Folder)theEObject;
				T1 result = caseFolder(folder);
				if (result == null) result = caseResource(folder);
				if (result == null) result = caseResourceGenerator(folder);
				if (result == null) result = caseGenerator(folder);
				if (result == null) result = caseIGenerator(folder);
				if (result == null) result = caseContextProvider(folder);
				if (result == null) result = caseConfigurable(folder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.NATURE: {
				Nature nature = (Nature)theEObject;
				T1 result = caseNature(nature);
				if (result == null) result = caseGenerator(nature);
				if (result == null) result = caseIGenerator(nature);
				if (result == null) result = caseContextProvider(nature);
				if (result == null) result = caseConfigurable(nature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.FILE: {
				File file = (File)theEObject;
				T1 result = caseFile(file);
				if (result == null) result = caseResource(file);
				if (result == null) result = caseResourceGenerator(file);
				if (result == null) result = caseGenerator(file);
				if (result == null) result = caseIGenerator(file);
				if (result == null) result = caseContextProvider(file);
				if (result == null) result = caseConfigurable(file);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.TEXT_GENERATOR: {
				TextGenerator textGenerator = (TextGenerator)theEObject;
				T1 result = caseTextGenerator(textGenerator);
				if (result == null) result = caseGenerator(textGenerator);
				if (result == null) result = caseIGenerator(textGenerator);
				if (result == null) result = caseContextProvider(textGenerator);
				if (result == null) result = caseConfigurable(textGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.STREAM_GENERATOR: {
				StreamGenerator streamGenerator = (StreamGenerator)theEObject;
				T1 result = caseStreamGenerator(streamGenerator);
				if (result == null) result = caseGenerator(streamGenerator);
				if (result == null) result = caseIGenerator(streamGenerator);
				if (result == null) result = caseContextProvider(streamGenerator);
				if (result == null) result = caseConfigurable(streamGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.PROJECT: {
				Project project = (Project)theEObject;
				T1 result = caseProject(project);
				if (result == null) result = caseResourceGenerator(project);
				if (result == null) result = caseGenerator(project);
				if (result == null) result = caseIGenerator(project);
				if (result == null) result = caseContextProvider(project);
				if (result == null) result = caseConfigurable(project);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T1 result = caseResource(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.BINARY_FILE: {
				BinaryFile binaryFile = (BinaryFile)theEObject;
				T1 result = caseBinaryFile(binaryFile);
				if (result == null) result = caseFile(binaryFile);
				if (result == null) result = caseResource(binaryFile);
				if (result == null) result = caseResourceGenerator(binaryFile);
				if (result == null) result = caseGenerator(binaryFile);
				if (result == null) result = caseIGenerator(binaryFile);
				if (result == null) result = caseContextProvider(binaryFile);
				if (result == null) result = caseConfigurable(binaryFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.TEXT_FILE: {
				TextFile textFile = (TextFile)theEObject;
				T1 result = caseTextFile(textFile);
				if (result == null) result = caseFile(textFile);
				if (result == null) result = caseResource(textFile);
				if (result == null) result = caseResourceGenerator(textFile);
				if (result == null) result = caseGenerator(textFile);
				if (result == null) result = caseIGenerator(textFile);
				if (result == null) result = caseContextProvider(textFile);
				if (result == null) result = caseConfigurable(textFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.RESOURCE_REFERENCE: {
				ResourceReference resourceReference = (ResourceReference)theEObject;
				T1 result = caseResourceReference(resourceReference);
				if (result == null) result = caseResource(resourceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.STATIC_TEXT: {
				StaticText staticText = (StaticText)theEObject;
				T1 result = caseStaticText(staticText);
				if (result == null) result = caseTextGenerator(staticText);
				if (result == null) result = caseGenerator(staticText);
				if (result == null) result = caseIGenerator(staticText);
				if (result == null) result = caseContextProvider(staticText);
				if (result == null) result = caseConfigurable(staticText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.TEXT_REFERENCE: {
				TextReference textReference = (TextReference)theEObject;
				T1 result = caseTextReference(textReference);
				if (result == null) result = caseTextGenerator(textReference);
				if (result == null) result = caseGenerator(textReference);
				if (result == null) result = caseIGenerator(textReference);
				if (result == null) result = caseContextProvider(textReference);
				if (result == null) result = caseConfigurable(textReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.TEXT_FILTER: {
				TextFilter textFilter = (TextFilter)theEObject;
				T1 result = caseTextFilter(textFilter);
				if (result == null) result = caseTextGenerator(textFilter);
				if (result == null) result = caseGenerator(textFilter);
				if (result == null) result = caseIGenerator(textFilter);
				if (result == null) result = caseContextProvider(textFilter);
				if (result == null) result = caseConfigurable(textFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.JAVA_TEXT_GENERATOR: {
				JavaTextGenerator javaTextGenerator = (JavaTextGenerator)theEObject;
				T1 result = caseJavaTextGenerator(javaTextGenerator);
				if (result == null) result = caseTextGenerator(javaTextGenerator);
				if (result == null) result = caseGenerator(javaTextGenerator);
				if (result == null) result = caseIGenerator(javaTextGenerator);
				if (result == null) result = caseContextProvider(javaTextGenerator);
				if (result == null) result = caseConfigurable(javaTextGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.INTERPOLATOR: {
				Interpolator interpolator = (Interpolator)theEObject;
				T1 result = caseInterpolator(interpolator);
				if (result == null) result = caseTextFilter(interpolator);
				if (result == null) result = caseTextGenerator(interpolator);
				if (result == null) result = caseGenerator(interpolator);
				if (result == null) result = caseIGenerator(interpolator);
				if (result == null) result = caseContextProvider(interpolator);
				if (result == null) result = caseConfigurable(interpolator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.JAVA_TEXT_FILTER: {
				JavaTextFilter javaTextFilter = (JavaTextFilter)theEObject;
				T1 result = caseJavaTextFilter(javaTextFilter);
				if (result == null) result = caseTextFilter(javaTextFilter);
				if (result == null) result = caseTextGenerator(javaTextFilter);
				if (result == null) result = caseGenerator(javaTextFilter);
				if (result == null) result = caseIGenerator(javaTextFilter);
				if (result == null) result = caseContextProvider(javaTextFilter);
				if (result == null) result = caseConfigurable(javaTextFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodegenPackage.PROVIDER: {
				Provider<?> provider = (Provider<?>)theEObject;
				T1 result = caseProvider(provider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configurable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configurable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConfigurable(Configurable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseConfigurationItem(ConfigurationItem<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseService(Service<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseProperty(Property<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseContextProvider(ContextProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IGenerator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IGenerator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseIGenerator(IGenerator<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseGenerator(Generator<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseGroup(Group<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseResourceGenerator(ResourceGenerator<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Workspace Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Workspace Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseWorkspaceRoot(WorkspaceRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFolder(Folder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNature(Nature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFile(File object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTextGenerator(TextGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stream Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stream Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStreamGenerator(StreamGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProject(Project object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBinaryFile(BinaryFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTextFile(TextFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResourceReference(ResourceReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStaticText(StaticText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTextReference(TextReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTextFilter(TextFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Text Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Text Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseJavaTextGenerator(JavaTextGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interpolator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interpolator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInterpolator(Interpolator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Text Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Text Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseJavaTextFilter(JavaTextFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseProvider(Provider<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //CodegenSwitch
