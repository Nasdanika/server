/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.cdo.boxing.BigDecimalBox;
import org.nasdanika.cdo.boxing.BigIntegerBox;
import org.nasdanika.cdo.boxing.BooleanBox;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.boxing.BoxingFactory;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.ByteArrayBox;
import org.nasdanika.cdo.boxing.ByteBox;
import org.nasdanika.cdo.boxing.CharArrayBox;
import org.nasdanika.cdo.boxing.CharacterBox;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.boxing.CollectionBox;
import org.nasdanika.cdo.boxing.DateBox;
import org.nasdanika.cdo.boxing.DoubleArrayBox;
import org.nasdanika.cdo.boxing.DoubleBox;
import org.nasdanika.cdo.boxing.EClassifierBox;
import org.nasdanika.cdo.boxing.FieldEntry;
import org.nasdanika.cdo.boxing.FloatArrayBox;
import org.nasdanika.cdo.boxing.FloatBox;
import org.nasdanika.cdo.boxing.IntArrayBox;
import org.nasdanika.cdo.boxing.IntegerBox;
import org.nasdanika.cdo.boxing.JsonArrayBox;
import org.nasdanika.cdo.boxing.JsonObjectBox;
import org.nasdanika.cdo.boxing.LongArrayBox;
import org.nasdanika.cdo.boxing.LongBox;
import org.nasdanika.cdo.boxing.MapBox;
import org.nasdanika.cdo.boxing.MapEntry;
import org.nasdanika.cdo.boxing.NullBox;
import org.nasdanika.cdo.boxing.ObjectArrayBox;
import org.nasdanika.cdo.boxing.ObjectBox;
import org.nasdanika.cdo.boxing.ReaderBox;
import org.nasdanika.cdo.boxing.ReferenceBox;
import org.nasdanika.cdo.boxing.SerializableBox;
import org.nasdanika.cdo.boxing.ShortArrayBox;
import org.nasdanika.cdo.boxing.ShortBox;
import org.nasdanika.cdo.boxing.StreamBox;
import org.nasdanika.cdo.boxing.StringBox;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BoxingPackageImpl extends EPackageImpl implements BoxingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bigDecimalBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bigIntegerBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass byteBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass byteArrayBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dateBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shortBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readerBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serializableBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClassifierBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass charArrayBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleArrayBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatArrayBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intArrayBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longArrayBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectArrayBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shortArrayBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jsonArrayBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jsonObjectBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringObjectMapEntryEClass = null;

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
	private EDataType collectionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType converterContextEDataType = null;

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
	private EDataType readerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType serializableEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jsonArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jsonObjectEDataType = null;

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
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BoxingPackageImpl() {
		super(eNS_URI, BoxingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BoxingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BoxingPackage init() {
		if (isInited) return (BoxingPackage)EPackage.Registry.INSTANCE.getEPackage(BoxingPackage.eNS_URI);

		// Obtain or create and register package
		BoxingPackageImpl theBoxingPackage = (BoxingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BoxingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BoxingPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBoxingPackage.createPackageContents();

		// Initialize created meta-data
		theBoxingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBoxingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BoxingPackage.eNS_URI, theBoxingPackage);
		return theBoxingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBox() {
		return boxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBox__Get__Context() {
		return boxEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBox__Set__Object_Context() {
		return boxEClass.getEOperations().get(1);
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
	public EDataType getCollection() {
		return collectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getConverterContext() {
		return converterContextEDataType;
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
	public EDataType getReader() {
		return readerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSerializable() {
		return serializableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJSONArray() {
		return jsonArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJSONObject() {
		return jsonObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBigDecimalBox() {
		return bigDecimalBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBigDecimalBox_Value() {
		return (EAttribute)bigDecimalBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBigIntegerBox() {
		return bigIntegerBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBigIntegerBox_Value() {
		return (EAttribute)bigIntegerBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanBox() {
		return booleanBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanBox_Value() {
		return (EAttribute)booleanBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getByteBox() {
		return byteBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getByteBox_Value() {
		return (EAttribute)byteBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getByteArrayBox() {
		return byteArrayBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getByteArrayBox_Value() {
		return (EAttribute)byteArrayBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterBox() {
		return characterBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCharacterBox_Value() {
		return (EAttribute)characterBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDateBox() {
		return dateBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDateBox_Value() {
		return (EAttribute)dateBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleBox() {
		return doubleBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleBox_Value() {
		return (EAttribute)doubleBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloatBox() {
		return floatBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatBox_Value() {
		return (EAttribute)floatBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerBox() {
		return integerBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerBox_Value() {
		return (EAttribute)integerBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongBox() {
		return longBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongBox_Value() {
		return (EAttribute)longBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShortBox() {
		return shortBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShortBox_Value() {
		return (EAttribute)shortBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringBox() {
		return stringBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringBox_Value() {
		return (EAttribute)stringBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionBox() {
		return collectionBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionBox_Elements() {
		return (EReference)collectionBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionBox_Type() {
		return (EReference)collectionBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapBox() {
		return mapBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapBox_Entries() {
		return (EReference)mapBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapBox_Type() {
		return (EReference)mapBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapEntry() {
		return mapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapEntry_Key() {
		return (EReference)mapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapEntry_Value() {
		return (EReference)mapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStreamBox() {
		return streamBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStreamBox_Value() {
		return (EAttribute)streamBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReaderBox() {
		return readerBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReaderBox_Value() {
		return (EAttribute)readerBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSerializableBox() {
		return serializableBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializableBox_Value() {
		return (EAttribute)serializableBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceBox() {
		return referenceBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceBox_Target() {
		return (EReference)referenceBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullBox() {
		return nullBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClassifierBox() {
		return eClassifierBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEClassifierBox_NsURI() {
		return (EAttribute)eClassifierBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEClassifierBox_Name() {
		return (EAttribute)eClassifierBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassBox() {
		return classBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBox_BundleName() {
		return (EAttribute)classBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBox_BundleVersion() {
		return (EAttribute)classBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBox_ClassName() {
		return (EAttribute)classBoxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectBox() {
		return objectBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectBox_Fields() {
		return (EReference)objectBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectBox_Type() {
		return (EReference)objectBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFieldEntry() {
		return fieldEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldEntry_Name() {
		return (EAttribute)fieldEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldEntry_DeclaringClass() {
		return (EAttribute)fieldEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFieldEntry_Value() {
		return (EReference)fieldEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharArrayBox() {
		return charArrayBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCharArrayBox_Value() {
		return (EAttribute)charArrayBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleArrayBox() {
		return doubleArrayBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleArrayBox_Value() {
		return (EAttribute)doubleArrayBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloatArrayBox() {
		return floatArrayBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatArrayBox_Value() {
		return (EAttribute)floatArrayBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntArrayBox() {
		return intArrayBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntArrayBox_Value() {
		return (EAttribute)intArrayBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongArrayBox() {
		return longArrayBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongArrayBox_Value() {
		return (EAttribute)longArrayBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectArrayBox() {
		return objectArrayBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectArrayBox_ElementType() {
		return (EReference)objectArrayBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectArrayBox_Elements() {
		return (EReference)objectArrayBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShortArrayBox() {
		return shortArrayBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShortArrayBox_Value() {
		return (EAttribute)shortArrayBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJsonArrayBox() {
		return jsonArrayBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJsonArrayBox_Elements() {
		return (EReference)jsonArrayBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJsonObjectBox() {
		return jsonObjectBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJsonObjectBox_Elements() {
		return (EReference)jsonObjectBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringObjectMapEntry() {
		return stringObjectMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringObjectMapEntry_Key() {
		return (EAttribute)stringObjectMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringObjectMapEntry_Value() {
		return (EReference)stringObjectMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoxingFactory getBoxingFactory() {
		return (BoxingFactory)getEFactoryInstance();
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
		boxEClass = createEClass(BOX);
		createEOperation(boxEClass, BOX___GET__CONTEXT);
		createEOperation(boxEClass, BOX___SET__OBJECT_CONTEXT);

		bigDecimalBoxEClass = createEClass(BIG_DECIMAL_BOX);
		createEAttribute(bigDecimalBoxEClass, BIG_DECIMAL_BOX__VALUE);

		bigIntegerBoxEClass = createEClass(BIG_INTEGER_BOX);
		createEAttribute(bigIntegerBoxEClass, BIG_INTEGER_BOX__VALUE);

		booleanBoxEClass = createEClass(BOOLEAN_BOX);
		createEAttribute(booleanBoxEClass, BOOLEAN_BOX__VALUE);

		byteBoxEClass = createEClass(BYTE_BOX);
		createEAttribute(byteBoxEClass, BYTE_BOX__VALUE);

		byteArrayBoxEClass = createEClass(BYTE_ARRAY_BOX);
		createEAttribute(byteArrayBoxEClass, BYTE_ARRAY_BOX__VALUE);

		characterBoxEClass = createEClass(CHARACTER_BOX);
		createEAttribute(characterBoxEClass, CHARACTER_BOX__VALUE);

		dateBoxEClass = createEClass(DATE_BOX);
		createEAttribute(dateBoxEClass, DATE_BOX__VALUE);

		doubleBoxEClass = createEClass(DOUBLE_BOX);
		createEAttribute(doubleBoxEClass, DOUBLE_BOX__VALUE);

		floatBoxEClass = createEClass(FLOAT_BOX);
		createEAttribute(floatBoxEClass, FLOAT_BOX__VALUE);

		integerBoxEClass = createEClass(INTEGER_BOX);
		createEAttribute(integerBoxEClass, INTEGER_BOX__VALUE);

		longBoxEClass = createEClass(LONG_BOX);
		createEAttribute(longBoxEClass, LONG_BOX__VALUE);

		shortBoxEClass = createEClass(SHORT_BOX);
		createEAttribute(shortBoxEClass, SHORT_BOX__VALUE);

		stringBoxEClass = createEClass(STRING_BOX);
		createEAttribute(stringBoxEClass, STRING_BOX__VALUE);

		collectionBoxEClass = createEClass(COLLECTION_BOX);
		createEReference(collectionBoxEClass, COLLECTION_BOX__ELEMENTS);
		createEReference(collectionBoxEClass, COLLECTION_BOX__TYPE);

		mapBoxEClass = createEClass(MAP_BOX);
		createEReference(mapBoxEClass, MAP_BOX__ENTRIES);
		createEReference(mapBoxEClass, MAP_BOX__TYPE);

		mapEntryEClass = createEClass(MAP_ENTRY);
		createEReference(mapEntryEClass, MAP_ENTRY__KEY);
		createEReference(mapEntryEClass, MAP_ENTRY__VALUE);

		streamBoxEClass = createEClass(STREAM_BOX);
		createEAttribute(streamBoxEClass, STREAM_BOX__VALUE);

		readerBoxEClass = createEClass(READER_BOX);
		createEAttribute(readerBoxEClass, READER_BOX__VALUE);

		serializableBoxEClass = createEClass(SERIALIZABLE_BOX);
		createEAttribute(serializableBoxEClass, SERIALIZABLE_BOX__VALUE);

		referenceBoxEClass = createEClass(REFERENCE_BOX);
		createEReference(referenceBoxEClass, REFERENCE_BOX__TARGET);

		nullBoxEClass = createEClass(NULL_BOX);

		eClassifierBoxEClass = createEClass(ECLASSIFIER_BOX);
		createEAttribute(eClassifierBoxEClass, ECLASSIFIER_BOX__NS_URI);
		createEAttribute(eClassifierBoxEClass, ECLASSIFIER_BOX__NAME);

		classBoxEClass = createEClass(CLASS_BOX);
		createEAttribute(classBoxEClass, CLASS_BOX__BUNDLE_NAME);
		createEAttribute(classBoxEClass, CLASS_BOX__BUNDLE_VERSION);
		createEAttribute(classBoxEClass, CLASS_BOX__CLASS_NAME);

		objectBoxEClass = createEClass(OBJECT_BOX);
		createEReference(objectBoxEClass, OBJECT_BOX__FIELDS);
		createEReference(objectBoxEClass, OBJECT_BOX__TYPE);

		fieldEntryEClass = createEClass(FIELD_ENTRY);
		createEAttribute(fieldEntryEClass, FIELD_ENTRY__NAME);
		createEAttribute(fieldEntryEClass, FIELD_ENTRY__DECLARING_CLASS);
		createEReference(fieldEntryEClass, FIELD_ENTRY__VALUE);

		charArrayBoxEClass = createEClass(CHAR_ARRAY_BOX);
		createEAttribute(charArrayBoxEClass, CHAR_ARRAY_BOX__VALUE);

		doubleArrayBoxEClass = createEClass(DOUBLE_ARRAY_BOX);
		createEAttribute(doubleArrayBoxEClass, DOUBLE_ARRAY_BOX__VALUE);

		floatArrayBoxEClass = createEClass(FLOAT_ARRAY_BOX);
		createEAttribute(floatArrayBoxEClass, FLOAT_ARRAY_BOX__VALUE);

		intArrayBoxEClass = createEClass(INT_ARRAY_BOX);
		createEAttribute(intArrayBoxEClass, INT_ARRAY_BOX__VALUE);

		longArrayBoxEClass = createEClass(LONG_ARRAY_BOX);
		createEAttribute(longArrayBoxEClass, LONG_ARRAY_BOX__VALUE);

		objectArrayBoxEClass = createEClass(OBJECT_ARRAY_BOX);
		createEReference(objectArrayBoxEClass, OBJECT_ARRAY_BOX__ELEMENT_TYPE);
		createEReference(objectArrayBoxEClass, OBJECT_ARRAY_BOX__ELEMENTS);

		shortArrayBoxEClass = createEClass(SHORT_ARRAY_BOX);
		createEAttribute(shortArrayBoxEClass, SHORT_ARRAY_BOX__VALUE);

		jsonArrayBoxEClass = createEClass(JSON_ARRAY_BOX);
		createEReference(jsonArrayBoxEClass, JSON_ARRAY_BOX__ELEMENTS);

		jsonObjectBoxEClass = createEClass(JSON_OBJECT_BOX);
		createEReference(jsonObjectBoxEClass, JSON_OBJECT_BOX__ELEMENTS);

		stringObjectMapEntryEClass = createEClass(STRING_OBJECT_MAP_ENTRY);
		createEAttribute(stringObjectMapEntryEClass, STRING_OBJECT_MAP_ENTRY__KEY);
		createEReference(stringObjectMapEntryEClass, STRING_OBJECT_MAP_ENTRY__VALUE);

		// Create data types
		contextEDataType = createEDataType(CONTEXT);
		collectionEDataType = createEDataType(COLLECTION);
		converterContextEDataType = createEDataType(CONVERTER_CONTEXT);
		inputStreamEDataType = createEDataType(INPUT_STREAM);
		readerEDataType = createEDataType(READER);
		serializableEDataType = createEDataType(SERIALIZABLE);
		jsonArrayEDataType = createEDataType(JSON_ARRAY);
		jsonObjectEDataType = createEDataType(JSON_OBJECT);
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

		// Create type parameters
		ETypeParameter boxEClass_T = addETypeParameter(boxEClass, "T");
		ETypeParameter boxEClass_C = addETypeParameter(boxEClass, "C");
		ETypeParameter collectionBoxEClass_T = addETypeParameter(collectionBoxEClass, "T");
		ETypeParameter mapBoxEClass_K = addETypeParameter(mapBoxEClass, "K");
		ETypeParameter mapBoxEClass_V = addETypeParameter(mapBoxEClass, "V");
		ETypeParameter classBoxEClass_T = addETypeParameter(classBoxEClass, "T");
		ETypeParameter objectBoxEClass_T = addETypeParameter(objectBoxEClass, "T");
		ETypeParameter objectArrayBoxEClass_T = addETypeParameter(objectArrayBoxEClass, "T");
		addETypeParameter(collectionEDataType, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getContext());
		boxEClass_C.getEBounds().add(g1);

		// Add supertypes to classes
		g1 = createEGenericType(this.getBox());
		EGenericType g2 = createEGenericType(ecorePackage.getEBigDecimal());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		bigDecimalBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEBigInteger());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		bigIntegerBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEBooleanObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		booleanBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEByteObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		byteBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEByteArray());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		byteArrayBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getECharacterObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		characterBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEDate());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		dateBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEDoubleObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		doubleBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEFloatObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		floatBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEIntegerObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		integerBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getELongObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		longBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEShortObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		shortBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		stringBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(this.getCollection());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(collectionBoxEClass_T);
		g2.getETypeArguments().add(g3);
		g2 = createEGenericType(this.getConverterContext());
		g1.getETypeArguments().add(g2);
		collectionBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEMap());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(mapBoxEClass_K);
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(mapBoxEClass_V);
		g2.getETypeArguments().add(g3);
		g2 = createEGenericType(this.getConverterContext());
		g1.getETypeArguments().add(g2);
		mapBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(this.getInputStream());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		streamBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(this.getReader());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		readerBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(this.getSerializable());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		serializableBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		referenceBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		nullBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		eClassifierBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEJavaClass());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(classBoxEClass_T);
		g2.getETypeArguments().add(g3);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		classBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(objectBoxEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getConverterContext());
		g1.getETypeArguments().add(g2);
		objectBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		charArrayBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		doubleArrayBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		floatArrayBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		intArrayBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		longArrayBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		objectArrayBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		shortArrayBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(this.getJSONArray());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		jsonArrayBoxEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBox());
		g2 = createEGenericType(this.getJSONObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getContext());
		g1.getETypeArguments().add(g2);
		jsonObjectBoxEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(boxEClass, Box.class, "Box", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getBox__Get__Context(), null, "get", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(boxEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(boxEClass_T);
		initEOperation(op, g1);

		op = initEOperation(getBox__Set__Object_Context(), null, "set", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(boxEClass_T);
		addEParameter(op, g1, "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(boxEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bigDecimalBoxEClass, BigDecimalBox.class, "BigDecimalBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBigDecimalBox_Value(), ecorePackage.getEBigDecimal(), "value", null, 0, 1, BigDecimalBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bigIntegerBoxEClass, BigIntegerBox.class, "BigIntegerBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBigIntegerBox_Value(), ecorePackage.getEBigInteger(), "value", null, 0, 1, BigIntegerBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanBoxEClass, BooleanBox.class, "BooleanBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanBox_Value(), ecorePackage.getEBooleanObject(), "value", null, 0, 1, BooleanBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(byteBoxEClass, ByteBox.class, "ByteBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getByteBox_Value(), ecorePackage.getEByteObject(), "value", null, 0, 1, ByteBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(byteArrayBoxEClass, ByteArrayBox.class, "ByteArrayBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getByteArrayBox_Value(), ecorePackage.getEByteArray(), "value", null, 0, 1, ByteArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(characterBoxEClass, CharacterBox.class, "CharacterBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCharacterBox_Value(), ecorePackage.getECharacterObject(), "value", null, 0, 1, CharacterBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dateBoxEClass, DateBox.class, "DateBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDateBox_Value(), ecorePackage.getEDate(), "value", null, 0, 1, DateBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleBoxEClass, DoubleBox.class, "DoubleBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleBox_Value(), ecorePackage.getEDoubleObject(), "value", null, 0, 1, DoubleBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(floatBoxEClass, FloatBox.class, "FloatBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloatBox_Value(), ecorePackage.getEFloatObject(), "value", null, 0, 1, FloatBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerBoxEClass, IntegerBox.class, "IntegerBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerBox_Value(), ecorePackage.getEIntegerObject(), "value", null, 0, 1, IntegerBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(longBoxEClass, LongBox.class, "LongBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongBox_Value(), ecorePackage.getELongObject(), "value", null, 0, 1, LongBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shortBoxEClass, ShortBox.class, "ShortBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShortBox_Value(), ecorePackage.getEShortObject(), "value", null, 0, 1, ShortBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringBoxEClass, StringBox.class, "StringBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringBox_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionBoxEClass, CollectionBox.class, "CollectionBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionBox_Elements(), ecorePackage.getEObject(), null, "elements", null, 0, -1, CollectionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getClassBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEReference(getCollectionBox_Type(), g1, null, "type", null, 0, 1, CollectionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapBoxEClass, MapBox.class, "MapBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapBox_Entries(), this.getMapEntry(), null, "entries", null, 0, -1, MapBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getClassBox());
		g2 = createEGenericType(ecorePackage.getEMap());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(mapBoxEClass_K);
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(mapBoxEClass_V);
		g2.getETypeArguments().add(g3);
		initEReference(getMapBox_Type(), g1, null, "type", null, 0, 1, MapBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapEntryEClass, MapEntry.class, "MapEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapEntry_Key(), ecorePackage.getEObject(), null, "key", null, 0, 1, MapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapEntry_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, MapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(streamBoxEClass, StreamBox.class, "StreamBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStreamBox_Value(), ecorePackage.getEByteArray(), "value", null, 0, 1, StreamBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readerBoxEClass, ReaderBox.class, "ReaderBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReaderBox_Value(), ecorePackage.getEString(), "value", null, 0, 1, ReaderBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serializableBoxEClass, SerializableBox.class, "SerializableBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSerializableBox_Value(), ecorePackage.getEByteArray(), "value", null, 0, 1, SerializableBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceBoxEClass, ReferenceBox.class, "ReferenceBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceBox_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, ReferenceBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nullBoxEClass, NullBox.class, "NullBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eClassifierBoxEClass, EClassifierBox.class, "EClassifierBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEClassifierBox_NsURI(), ecorePackage.getEString(), "nsURI", null, 0, 1, EClassifierBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassifierBox_Name(), ecorePackage.getEString(), "name", null, 0, 1, EClassifierBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classBoxEClass, ClassBox.class, "ClassBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassBox_BundleName(), ecorePackage.getEString(), "bundleName", null, 0, 1, ClassBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBox_BundleVersion(), ecorePackage.getEString(), "bundleVersion", null, 0, 1, ClassBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBox_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, ClassBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectBoxEClass, ObjectBox.class, "ObjectBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectBox_Fields(), this.getFieldEntry(), null, "fields", null, 0, -1, ObjectBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getClassBox());
		g2 = createEGenericType(objectBoxEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getObjectBox_Type(), g1, null, "type", null, 0, 1, ObjectBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldEntryEClass, FieldEntry.class, "FieldEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFieldEntry_Name(), ecorePackage.getEString(), "name", null, 0, 1, FieldEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFieldEntry_DeclaringClass(), ecorePackage.getEString(), "declaringClass", null, 0, 1, FieldEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFieldEntry_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, FieldEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(charArrayBoxEClass, CharArrayBox.class, "CharArrayBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCharArrayBox_Value(), ecorePackage.getEChar(), "value", null, 0, -1, CharArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleArrayBoxEClass, DoubleArrayBox.class, "DoubleArrayBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleArrayBox_Value(), ecorePackage.getEDouble(), "value", null, 0, -1, DoubleArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(floatArrayBoxEClass, FloatArrayBox.class, "FloatArrayBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloatArrayBox_Value(), ecorePackage.getEFloat(), "value", null, 0, -1, FloatArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intArrayBoxEClass, IntArrayBox.class, "IntArrayBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntArrayBox_Value(), ecorePackage.getEInt(), "value", null, 0, -1, IntArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(longArrayBoxEClass, LongArrayBox.class, "LongArrayBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongArrayBox_Value(), ecorePackage.getELong(), "value", null, 0, -1, LongArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectArrayBoxEClass, ObjectArrayBox.class, "ObjectArrayBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getClassBox());
		g2 = createEGenericType(objectArrayBoxEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getObjectArrayBox_ElementType(), g1, null, "elementType", null, 0, 1, ObjectArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectArrayBox_Elements(), ecorePackage.getEObject(), null, "elements", null, 0, -1, ObjectArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shortArrayBoxEClass, ShortArrayBox.class, "ShortArrayBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShortArrayBox_Value(), ecorePackage.getEShort(), "value", null, 0, -1, ShortArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jsonArrayBoxEClass, JsonArrayBox.class, "JsonArrayBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJsonArrayBox_Elements(), ecorePackage.getEObject(), null, "elements", null, 0, -1, JsonArrayBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jsonObjectBoxEClass, JsonObjectBox.class, "JsonObjectBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJsonObjectBox_Elements(), this.getStringObjectMapEntry(), null, "elements", null, 0, -1, JsonObjectBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringObjectMapEntryEClass, Map.Entry.class, "StringObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringObjectMapEntry_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(contextEDataType, Context.class, "Context", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(collectionEDataType, Collection.class, "Collection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(converterContextEDataType, ConverterContext.class, "ConverterContext", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(inputStreamEDataType, InputStream.class, "InputStream", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(readerEDataType, Reader.class, "Reader", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(serializableEDataType, Serializable.class, "Serializable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(jsonArrayEDataType, JSONArray.class, "JSONArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(jsonObjectEDataType, JSONObject.class, "JSONObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BoxingPackageImpl
