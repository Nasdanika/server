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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.nasdanika.codegen.BinaryFile;
import org.nasdanika.codegen.CodegenFactory;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Configurable;
import org.nasdanika.codegen.ConfigurationItem;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.File;
import org.nasdanika.codegen.Folder;
import org.nasdanika.codegen.Generator;
import org.nasdanika.codegen.Group;
import org.nasdanika.codegen.WorkFactory;
import org.nasdanika.codegen.Interpolator;
import org.nasdanika.codegen.JavaTextFilter;
import org.nasdanika.codegen.JavaTextGenerator;
import org.nasdanika.codegen.Nature;
import org.nasdanika.codegen.Project;
import org.nasdanika.codegen.Property;
import org.nasdanika.codegen.Provider;
import org.nasdanika.codegen.ReconcileAction;
import org.nasdanika.codegen.Resource;
import org.nasdanika.codegen.ResourceGenerator;
import org.nasdanika.codegen.ResourceReference;
import org.nasdanika.codegen.Service;
import org.nasdanika.codegen.StaticText;
import org.nasdanika.codegen.StreamGenerator;
import org.nasdanika.codegen.TextFile;
import org.nasdanika.codegen.TextFilter;
import org.nasdanika.codegen.TextGenerator;
import org.nasdanika.codegen.TextReference;
import org.nasdanika.codegen.WorkspaceRoot;

import org.nasdanika.codegen.java.JavaPackage;

import org.nasdanika.codegen.java.impl.JavaPackageImpl;

import org.nasdanika.codegen.maven.MavenPackage;

import org.nasdanika.codegen.maven.impl.MavenPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodegenPackageImpl extends EPackageImpl implements CodegenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass natureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaTextGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interpolatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaTextFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reconcileActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType contextEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType inputStreamEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType voidEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iFileEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iFolderEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iProjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iProjectNatureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iWorkspaceRootEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType exceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iResourceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.nasdanika.codegen.CodegenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CodegenPackageImpl() {
		super(eNS_URI, CodegenFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CodegenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CodegenPackage init() {
		if (isInited) return (CodegenPackage)EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI);

		// Obtain or create and register package
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CodegenPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		JavaPackageImpl theJavaPackage = (JavaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI) instanceof JavaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI) : JavaPackage.eINSTANCE);
		MavenPackageImpl theMavenPackage = (MavenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MavenPackage.eNS_URI) instanceof MavenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MavenPackage.eNS_URI) : MavenPackage.eINSTANCE);

		// Create package meta-data objects
		theCodegenPackage.createPackageContents();
		theJavaPackage.createPackageContents();
		theMavenPackage.createPackageContents();

		// Initialize created meta-data
		theCodegenPackage.initializePackageContents();
		theJavaPackage.initializePackageContents();
		theMavenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCodegenPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CodegenPackage.eNS_URI, theCodegenPackage);
		return theCodegenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurable() {
		return configurableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurable_PropertiesReferences() {
		return (EAttribute)configurableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurable_Configuration() {
		return (EReference)configurableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurable_DefaultPropertiesReferences() {
		return (EAttribute)configurableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConfigurable__CreateContext__Context() {
		return configurableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationItem() {
		return configurationItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationItem_ValueType() {
		return (EAttribute)configurationItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationItem_Value() {
		return (EAttribute)configurationItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationItem_Default() {
		return (EAttribute)configurationItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationItem_Description() {
		return (EAttribute)configurationItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ServiceType() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIGenerator() {
		return iGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenerator() {
		return generatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenerator_Iterator() {
		return (EAttribute)generatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroup() {
		return groupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroup_Selector() {
		return (EAttribute)groupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Members() {
		return (EReference)groupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceGenerator() {
		return resourceGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspaceRoot() {
		return workspaceRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceRoot_Projects() {
		return (EReference)workspaceRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolder() {
		return folderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_Children() {
		return (EReference)folderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNature() {
		return natureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFile() {
		return fileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextGenerator() {
		return textGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStreamGenerator() {
		return streamGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject() {
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Name() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Natures() {
		return (EReference)projectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Resources() {
		return (EReference)projectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_ReconcileAction() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Name() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_ReconcileAction() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryFile() {
		return binaryFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryFile_Streamgenerator() {
		return (EReference)binaryFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextFile() {
		return textFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextFile_Textgenerator() {
		return (EReference)textFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceReference() {
		return resourceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceReference_Target() {
		return (EReference)resourceReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticText() {
		return staticTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStaticText_Content() {
		return (EAttribute)staticTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextReference() {
		return textReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextReference_Ref() {
		return (EAttribute)textReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextFilter() {
		return textFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextFilter_Textgenerator() {
		return (EReference)textFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaTextGenerator() {
		return javaTextGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaTextGenerator_ClassName() {
		return (EAttribute)javaTextGeneratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterpolator() {
		return interpolatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaTextFilter() {
		return javaTextFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaTextFilter_ClassName() {
		return (EAttribute)javaTextFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvider() {
		return providerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReconcileAction() {
		return reconcileActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getContext() {
		return contextEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInputStream() {
		return inputStreamEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVoid() {
		return voidEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIFile() {
		return iFileEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIFolder() {
		return iFolderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIProject() {
		return iProjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIProjectNature() {
		return iProjectNatureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIWorkspaceRoot() {
		return iWorkspaceRootEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getException() {
		return exceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIResource() {
		return iResourceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getList() {
		return listEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenFactory getCodegenFactory() {
		return (CodegenFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		configurableEClass = createEClass(CONFIGURABLE);
		createEAttribute(configurableEClass, CONFIGURABLE__PROPERTIES_REFERENCES);
		createEReference(configurableEClass, CONFIGURABLE__CONFIGURATION);
		createEAttribute(configurableEClass, CONFIGURABLE__DEFAULT_PROPERTIES_REFERENCES);
		createEOperation(configurableEClass, CONFIGURABLE___CREATE_CONTEXT__CONTEXT);

		configurationItemEClass = createEClass(CONFIGURATION_ITEM);
		createEAttribute(configurationItemEClass, CONFIGURATION_ITEM__VALUE_TYPE);
		createEAttribute(configurationItemEClass, CONFIGURATION_ITEM__VALUE);
		createEAttribute(configurationItemEClass, CONFIGURATION_ITEM__DEFAULT);
		createEAttribute(configurationItemEClass, CONFIGURATION_ITEM__DESCRIPTION);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__SERVICE_TYPE);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);

		iGeneratorEClass = createEClass(IGENERATOR);

		generatorEClass = createEClass(GENERATOR);
		createEAttribute(generatorEClass, GENERATOR__ITERATOR);

		groupEClass = createEClass(GROUP);
		createEAttribute(groupEClass, GROUP__SELECTOR);
		createEReference(groupEClass, GROUP__MEMBERS);

		resourceGeneratorEClass = createEClass(RESOURCE_GENERATOR);

		workspaceRootEClass = createEClass(WORKSPACE_ROOT);
		createEReference(workspaceRootEClass, WORKSPACE_ROOT__PROJECTS);

		folderEClass = createEClass(FOLDER);
		createEReference(folderEClass, FOLDER__CHILDREN);

		natureEClass = createEClass(NATURE);

		fileEClass = createEClass(FILE);

		textGeneratorEClass = createEClass(TEXT_GENERATOR);

		streamGeneratorEClass = createEClass(STREAM_GENERATOR);

		projectEClass = createEClass(PROJECT);
		createEAttribute(projectEClass, PROJECT__NAME);
		createEReference(projectEClass, PROJECT__NATURES);
		createEReference(projectEClass, PROJECT__RESOURCES);
		createEAttribute(projectEClass, PROJECT__RECONCILE_ACTION);

		resourceEClass = createEClass(RESOURCE);
		createEAttribute(resourceEClass, RESOURCE__NAME);
		createEAttribute(resourceEClass, RESOURCE__RECONCILE_ACTION);

		binaryFileEClass = createEClass(BINARY_FILE);
		createEReference(binaryFileEClass, BINARY_FILE__STREAMGENERATOR);

		textFileEClass = createEClass(TEXT_FILE);
		createEReference(textFileEClass, TEXT_FILE__TEXTGENERATOR);

		resourceReferenceEClass = createEClass(RESOURCE_REFERENCE);
		createEReference(resourceReferenceEClass, RESOURCE_REFERENCE__TARGET);

		staticTextEClass = createEClass(STATIC_TEXT);
		createEAttribute(staticTextEClass, STATIC_TEXT__CONTENT);

		textReferenceEClass = createEClass(TEXT_REFERENCE);
		createEAttribute(textReferenceEClass, TEXT_REFERENCE__REF);

		textFilterEClass = createEClass(TEXT_FILTER);
		createEReference(textFilterEClass, TEXT_FILTER__TEXTGENERATOR);

		javaTextGeneratorEClass = createEClass(JAVA_TEXT_GENERATOR);
		createEAttribute(javaTextGeneratorEClass, JAVA_TEXT_GENERATOR__CLASS_NAME);

		interpolatorEClass = createEClass(INTERPOLATOR);

		javaTextFilterEClass = createEClass(JAVA_TEXT_FILTER);
		createEAttribute(javaTextFilterEClass, JAVA_TEXT_FILTER__CLASS_NAME);

		providerEClass = createEClass(PROVIDER);

		// Create enums
		reconcileActionEEnum = createEEnum(RECONCILE_ACTION);

		// Create data types
		contextEDataType = createEDataType(CONTEXT);
		inputStreamEDataType = createEDataType(INPUT_STREAM);
		voidEDataType = createEDataType(VOID);
		iFileEDataType = createEDataType(IFILE);
		iFolderEDataType = createEDataType(IFOLDER);
		iProjectEDataType = createEDataType(IPROJECT);
		iProjectNatureEDataType = createEDataType(IPROJECT_NATURE);
		iWorkspaceRootEDataType = createEDataType(IWORKSPACE_ROOT);
		exceptionEDataType = createEDataType(EXCEPTION);
		iResourceEDataType = createEDataType(IRESOURCE);
		listEDataType = createEDataType(LIST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		JavaPackage theJavaPackage = (JavaPackage)EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI);
		MavenPackage theMavenPackage = (MavenPackage)EPackage.Registry.INSTANCE.getEPackage(MavenPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theJavaPackage);
		getESubpackages().add(theMavenPackage);

		// Create type parameters
		ETypeParameter configurationItemEClass_T = addETypeParameter(configurationItemEClass, "T");
		ETypeParameter serviceEClass_T = addETypeParameter(serviceEClass, "T");
		ETypeParameter propertyEClass_T = addETypeParameter(propertyEClass, "T");
		addETypeParameter(iGeneratorEClass, "T");
		ETypeParameter generatorEClass_T = addETypeParameter(generatorEClass, "T");
		ETypeParameter groupEClass_T = addETypeParameter(groupEClass, "T");
		ETypeParameter resourceGeneratorEClass_T = addETypeParameter(resourceGeneratorEClass, "T");
		ETypeParameter resourceEClass_T = addETypeParameter(resourceEClass, "T");
		addETypeParameter(providerEClass, "T");
		addETypeParameter(listEDataType, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getProvider());
		EGenericType g2 = createEGenericType(configurationItemEClass_T);
		g1.getETypeArguments().add(g2);
		configurationItemEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConfigurable());
		configurationItemEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConfigurationItem());
		g2 = createEGenericType(serviceEClass_T);
		g1.getETypeArguments().add(g2);
		serviceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConfigurationItem());
		g2 = createEGenericType(propertyEClass_T);
		g1.getETypeArguments().add(g2);
		propertyEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIGenerator());
		g2 = createEGenericType(this.getList());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(generatorEClass_T);
		g2.getETypeArguments().add(g3);
		generatorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getConfigurable());
		generatorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGenerator());
		g2 = createEGenericType(groupEClass_T);
		g1.getETypeArguments().add(g2);
		groupEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGenerator());
		g2 = createEGenericType(resourceGeneratorEClass_T);
		g1.getETypeArguments().add(g2);
		resourceGeneratorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getResourceGenerator());
		g2 = createEGenericType(this.getIWorkspaceRoot());
		g1.getETypeArguments().add(g2);
		workspaceRootEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getResource());
		g2 = createEGenericType(this.getIFolder());
		g1.getETypeArguments().add(g2);
		folderEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGenerator());
		g2 = createEGenericType(this.getIProjectNature());
		g1.getETypeArguments().add(g2);
		natureEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getResource());
		g2 = createEGenericType(this.getIFile());
		g1.getETypeArguments().add(g2);
		fileEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGenerator());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		textGeneratorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGenerator());
		g2 = createEGenericType(this.getInputStream());
		g1.getETypeArguments().add(g2);
		streamGeneratorEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getResourceGenerator());
		g2 = createEGenericType(this.getIProject());
		g1.getETypeArguments().add(g2);
		projectEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getResourceGenerator());
		g2 = createEGenericType(resourceEClass_T);
		g1.getETypeArguments().add(g2);
		resourceEClass.getEGenericSuperTypes().add(g1);
		binaryFileEClass.getESuperTypes().add(this.getFile());
		textFileEClass.getESuperTypes().add(this.getFile());
		g1 = createEGenericType(this.getResource());
		g2 = createEGenericType(this.getIResource());
		g1.getETypeArguments().add(g2);
		resourceReferenceEClass.getEGenericSuperTypes().add(g1);
		staticTextEClass.getESuperTypes().add(this.getTextGenerator());
		textReferenceEClass.getESuperTypes().add(this.getTextGenerator());
		textFilterEClass.getESuperTypes().add(this.getTextGenerator());
		javaTextGeneratorEClass.getESuperTypes().add(this.getTextGenerator());
		interpolatorEClass.getESuperTypes().add(this.getTextFilter());
		javaTextFilterEClass.getESuperTypes().add(this.getTextFilter());

		// Initialize classes, features, and operations; add parameters
		initEClass(configurableEClass, Configurable.class, "Configurable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurable_PropertiesReferences(), ecorePackage.getEString(), "propertiesReferences", null, 0, -1, Configurable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getConfigurationItem());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEReference(getConfigurable_Configuration(), g1, null, "configuration", null, 0, -1, Configurable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurable_DefaultPropertiesReferences(), ecorePackage.getEString(), "defaultPropertiesReferences", null, 0, -1, Configurable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getConfigurable__CreateContext__Context(), this.getContext(), "createContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContext(), "parent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());

		initEClass(configurationItemEClass, ConfigurationItem.class, "ConfigurationItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationItem_ValueType(), ecorePackage.getEString(), "valueType", null, 0, 1, ConfigurationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationItem_Value(), ecorePackage.getEString(), "value", null, 0, 1, ConfigurationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationItem_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, ConfigurationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationItem_Description(), ecorePackage.getEString(), "description", null, 0, 1, ConfigurationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_ServiceType(), ecorePackage.getEString(), "serviceType", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iGeneratorEClass, WorkFactory.class, "IGenerator", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(generatorEClass, Generator.class, "Generator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenerator_Iterator(), ecorePackage.getEString(), "iterator", null, 0, 1, Generator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroup_Selector(), ecorePackage.getEString(), "selector", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getGenerator());
		g2 = createEGenericType(groupEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getGroup_Members(), g1, null, "members", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceGeneratorEClass, ResourceGenerator.class, "ResourceGenerator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(workspaceRootEClass, WorkspaceRoot.class, "WorkspaceRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspaceRoot_Projects(), this.getProject(), null, "projects", null, 0, -1, WorkspaceRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(folderEClass, Folder.class, "Folder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getResource());
		g2 = createEGenericType(this.getIResource());
		g1.getETypeArguments().add(g2);
		initEReference(getFolder_Children(), g1, null, "children", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(natureEClass, Nature.class, "Nature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileEClass, File.class, "File", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textGeneratorEClass, TextGenerator.class, "TextGenerator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(streamGeneratorEClass, StreamGenerator.class, "StreamGenerator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Natures(), this.getNature(), null, "natures", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getResource());
		g2 = createEGenericType(this.getIResource());
		g1.getETypeArguments().add(g2);
		initEReference(getProject_Resources(), g1, null, "resources", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_ReconcileAction(), this.getReconcileAction(), "reconcileAction", "Merge", 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResource_Name(), ecorePackage.getEString(), "name", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_ReconcileAction(), this.getReconcileAction(), "reconcileAction", "Merge", 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryFileEClass, BinaryFile.class, "BinaryFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryFile_Streamgenerator(), this.getStreamGenerator(), null, "streamgenerator", null, 1, 1, BinaryFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textFileEClass, TextFile.class, "TextFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTextFile_Textgenerator(), this.getTextGenerator(), null, "textgenerator", null, 1, 1, TextFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceReferenceEClass, ResourceReference.class, "ResourceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getResource());
		g2 = createEGenericType(this.getIResource());
		g1.getETypeArguments().add(g2);
		initEReference(getResourceReference_Target(), g1, null, "target", null, 0, 1, ResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(staticTextEClass, StaticText.class, "StaticText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticText_Content(), ecorePackage.getEString(), "content", null, 0, 1, StaticText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textReferenceEClass, TextReference.class, "TextReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextReference_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, TextReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textFilterEClass, TextFilter.class, "TextFilter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTextFilter_Textgenerator(), this.getTextGenerator(), null, "textgenerator", null, 1, 1, TextFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaTextGeneratorEClass, JavaTextGenerator.class, "JavaTextGenerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaTextGenerator_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, JavaTextGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interpolatorEClass, Interpolator.class, "Interpolator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(javaTextFilterEClass, JavaTextFilter.class, "JavaTextFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaTextFilter_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, JavaTextFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(providerEClass, Provider.class, "Provider", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(reconcileActionEEnum, ReconcileAction.class, "ReconcileAction");
		addEEnumLiteral(reconcileActionEEnum, ReconcileAction.KEEP);
		addEEnumLiteral(reconcileActionEEnum, ReconcileAction.MERGE);
		addEEnumLiteral(reconcileActionEEnum, ReconcileAction.OVERWRITE);
		addEEnumLiteral(reconcileActionEEnum, ReconcileAction.ABORT);
		addEEnumLiteral(reconcileActionEEnum, ReconcileAction.CONFIRM);

		// Initialize data types
		initEDataType(contextEDataType, Context.class, "Context", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(inputStreamEDataType, InputStream.class, "InputStream", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(voidEDataType, Void.class, "Void", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iFileEDataType, IFile.class, "IFile", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iFolderEDataType, IFolder.class, "IFolder", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iProjectEDataType, IProject.class, "IProject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iProjectNatureEDataType, IProjectNature.class, "IProjectNature", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iWorkspaceRootEDataType, IWorkspaceRoot.class, "IWorkspaceRoot", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(exceptionEDataType, Exception.class, "Exception", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iResourceEDataType, IFolder.class, "IResource", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listEDataType, List.class, "List", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CodegenPackageImpl
