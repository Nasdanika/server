/**
 */
package org.nasdanika.codegen.impl;

import java.io.InputStream;

import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IWorkspaceRoot;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.nasdanika.codegen.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodegenFactoryImpl extends EFactoryImpl implements CodegenFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CodegenFactory init() {
		try {
			CodegenFactory theCodegenFactory = (CodegenFactory)EPackage.Registry.INSTANCE.getEFactory(CodegenPackage.eNS_URI);
			if (theCodegenFactory != null) {
				return theCodegenFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CodegenFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CodegenPackage.SERVICE: return (EObject)createService();
			case CodegenPackage.PROPERTY: return (EObject)createProperty();
			case CodegenPackage.GROUP: return (EObject)createGroup();
			case CodegenPackage.WORKSPACE_ROOT: return (EObject)createWorkspaceRoot();
			case CodegenPackage.FOLDER: return (EObject)createFolder();
			case CodegenPackage.PROJECT: return (EObject)createProject();
			case CodegenPackage.BINARY_FILE: return (EObject)createBinaryFile();
			case CodegenPackage.TEXT_FILE: return (EObject)createTextFile();
			case CodegenPackage.RESOURCE_REFERENCE: return (EObject)createResourceReference();
			case CodegenPackage.STATIC_TEXT: return (EObject)createStaticText();
			case CodegenPackage.TEXT_REFERENCE: return (EObject)createTextReference();
			case CodegenPackage.JAVA_TEXT_GENERATOR: return (EObject)createJavaTextGenerator();
			case CodegenPackage.INTERPOLATOR: return (EObject)createInterpolator();
			case CodegenPackage.JAVA_TEXT_FILTER: return (EObject)createJavaTextFilter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CodegenPackage.RECONCILE_ACTION:
				return createReconcileActionFromString(eDataType, initialValue);
			case CodegenPackage.CONTEXT:
				return createContextFromString(eDataType, initialValue);
			case CodegenPackage.INPUT_STREAM:
				return createInputStreamFromString(eDataType, initialValue);
			case CodegenPackage.VOID:
				return createVoidFromString(eDataType, initialValue);
			case CodegenPackage.IFILE:
				return createIFileFromString(eDataType, initialValue);
			case CodegenPackage.IFOLDER:
				return createIFolderFromString(eDataType, initialValue);
			case CodegenPackage.IPROJECT:
				return createIProjectFromString(eDataType, initialValue);
			case CodegenPackage.IPROJECT_NATURE:
				return createIProjectNatureFromString(eDataType, initialValue);
			case CodegenPackage.IWORKSPACE_ROOT:
				return createIWorkspaceRootFromString(eDataType, initialValue);
			case CodegenPackage.EXCEPTION:
				return createExceptionFromString(eDataType, initialValue);
			case CodegenPackage.IRESOURCE:
				return createIResourceFromString(eDataType, initialValue);
			case CodegenPackage.LIST:
				return createListFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CodegenPackage.RECONCILE_ACTION:
				return convertReconcileActionToString(eDataType, instanceValue);
			case CodegenPackage.CONTEXT:
				return convertContextToString(eDataType, instanceValue);
			case CodegenPackage.INPUT_STREAM:
				return convertInputStreamToString(eDataType, instanceValue);
			case CodegenPackage.VOID:
				return convertVoidToString(eDataType, instanceValue);
			case CodegenPackage.IFILE:
				return convertIFileToString(eDataType, instanceValue);
			case CodegenPackage.IFOLDER:
				return convertIFolderToString(eDataType, instanceValue);
			case CodegenPackage.IPROJECT:
				return convertIProjectToString(eDataType, instanceValue);
			case CodegenPackage.IPROJECT_NATURE:
				return convertIProjectNatureToString(eDataType, instanceValue);
			case CodegenPackage.IWORKSPACE_ROOT:
				return convertIWorkspaceRootToString(eDataType, instanceValue);
			case CodegenPackage.EXCEPTION:
				return convertExceptionToString(eDataType, instanceValue);
			case CodegenPackage.IRESOURCE:
				return convertIResourceToString(eDataType, instanceValue);
			case CodegenPackage.LIST:
				return convertListToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> Service<T> createService() {
		ServiceImpl<T> service = new ServiceImpl<T>();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> Property<T> createProperty() {
		PropertyImpl<T> property = new PropertyImpl<T>();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> Group<T> createGroup() {
		GroupImpl<T> group = new GroupImpl<T>();
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceRoot createWorkspaceRoot() {
		WorkspaceRootImpl workspaceRoot = new WorkspaceRootImpl();
		return workspaceRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder createFolder() {
		FolderImpl folder = new FolderImpl();
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryFile createBinaryFile() {
		BinaryFileImpl binaryFile = new BinaryFileImpl();
		return binaryFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextFile createTextFile() {
		TextFileImpl textFile = new TextFileImpl();
		return textFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceReference createResourceReference() {
		ResourceReferenceImpl resourceReference = new ResourceReferenceImpl();
		return resourceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticText createStaticText() {
		StaticTextImpl staticText = new StaticTextImpl();
		return staticText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextReference createTextReference() {
		TextReferenceImpl textReference = new TextReferenceImpl();
		return textReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaTextGenerator createJavaTextGenerator() {
		JavaTextGeneratorImpl javaTextGenerator = new JavaTextGeneratorImpl();
		return javaTextGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interpolator createInterpolator() {
		InterpolatorImpl interpolator = new InterpolatorImpl();
		return interpolator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaTextFilter createJavaTextFilter() {
		JavaTextFilterImpl javaTextFilter = new JavaTextFilterImpl();
		return javaTextFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReconcileAction createReconcileActionFromString(EDataType eDataType, String initialValue) {
		ReconcileAction result = ReconcileAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReconcileActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContextFromString(EDataType eDataType, String initialValue) {
		return (Context)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContextToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputStream createInputStreamFromString(EDataType eDataType, String initialValue) {
		return (InputStream)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInputStreamToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Void createVoidFromString(EDataType eDataType, String initialValue) {
		return (Void)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVoidToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFile createIFileFromString(EDataType eDataType, String initialValue) {
		return (IFile)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIFileToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFolder createIFolderFromString(EDataType eDataType, String initialValue) {
		return (IFolder)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIFolderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProject createIProjectFromString(EDataType eDataType, String initialValue) {
		return (IProject)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIProjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProjectNature createIProjectNatureFromString(EDataType eDataType, String initialValue) {
		return (IProjectNature)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIProjectNatureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IWorkspaceRoot createIWorkspaceRootFromString(EDataType eDataType, String initialValue) {
		return (IWorkspaceRoot)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIWorkspaceRootToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exception createExceptionFromString(EDataType eDataType, String initialValue) {
		return (Exception)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFolder createIResourceFromString(EDataType eDataType, String initialValue) {
		return (IFolder)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIResourceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<?> createListFromString(EDataType eDataType, String initialValue) {
		return (List<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenPackage getCodegenPackage() {
		return (CodegenPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CodegenPackage getPackage() {
		return CodegenPackage.eINSTANCE;
	}

} //CodegenFactoryImpl
