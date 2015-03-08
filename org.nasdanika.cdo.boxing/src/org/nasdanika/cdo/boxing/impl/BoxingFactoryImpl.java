/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.cdo.boxing.*;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BoxingFactoryImpl extends EFactoryImpl implements BoxingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BoxingFactory init() {
		try {
			BoxingFactory theBoxingFactory = (BoxingFactory)EPackage.Registry.INSTANCE.getEFactory(BoxingPackage.eNS_URI);
			if (theBoxingFactory != null) {
				return theBoxingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BoxingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoxingFactoryImpl() {
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
			case BoxingPackage.BIG_DECIMAL_BOX: return (EObject)createBigDecimalBox();
			case BoxingPackage.BIG_INTEGER_BOX: return (EObject)createBigIntegerBox();
			case BoxingPackage.BOOLEAN_BOX: return (EObject)createBooleanBox();
			case BoxingPackage.BYTE_BOX: return (EObject)createByteBox();
			case BoxingPackage.BYTE_ARRAY_BOX: return (EObject)createByteArrayBox();
			case BoxingPackage.CHARACTER_BOX: return (EObject)createCharacterBox();
			case BoxingPackage.DATE_BOX: return (EObject)createDateBox();
			case BoxingPackage.DOUBLE_BOX: return (EObject)createDoubleBox();
			case BoxingPackage.FLOAT_BOX: return (EObject)createFloatBox();
			case BoxingPackage.INTEGER_BOX: return (EObject)createIntegerBox();
			case BoxingPackage.LONG_BOX: return (EObject)createLongBox();
			case BoxingPackage.SHORT_BOX: return (EObject)createShortBox();
			case BoxingPackage.STRING_BOX: return (EObject)createStringBox();
			case BoxingPackage.COLLECTION_BOX: return (EObject)createCollectionBox();
			case BoxingPackage.MAP_BOX: return (EObject)createMapBox();
			case BoxingPackage.MAP_ENTRY: return (EObject)createMapEntry();
			case BoxingPackage.STREAM_BOX: return (EObject)createStreamBox();
			case BoxingPackage.READER_BOX: return (EObject)createReaderBox();
			case BoxingPackage.SERIALIZABLE_BOX: return (EObject)createSerializableBox();
			case BoxingPackage.REFERENCE_BOX: return (EObject)createReferenceBox();
			case BoxingPackage.NULL_BOX: return (EObject)createNullBox();
			case BoxingPackage.ECLASSIFIER_BOX: return (EObject)createEClassifierBox();
			case BoxingPackage.CLASS_BOX: return (EObject)createClassBox();
			case BoxingPackage.OBJECT_BOX: return (EObject)createObjectBox();
			case BoxingPackage.FIELD_ENTRY: return (EObject)createFieldEntry();
			case BoxingPackage.CHAR_ARRAY_BOX: return (EObject)createCharArrayBox();
			case BoxingPackage.DOUBLE_ARRAY_BOX: return (EObject)createDoubleArrayBox();
			case BoxingPackage.FLOAT_ARRAY_BOX: return (EObject)createFloatArrayBox();
			case BoxingPackage.INT_ARRAY_BOX: return (EObject)createIntArrayBox();
			case BoxingPackage.LONG_ARRAY_BOX: return (EObject)createLongArrayBox();
			case BoxingPackage.OBJECT_ARRAY_BOX: return (EObject)createObjectArrayBox();
			case BoxingPackage.SHORT_ARRAY_BOX: return (EObject)createShortArrayBox();
			case BoxingPackage.JSON_ARRAY_BOX: return (EObject)createJsonArrayBox();
			case BoxingPackage.JSON_OBJECT_BOX: return (EObject)createJsonObjectBox();
			case BoxingPackage.STRING_OBJECT_MAP_ENTRY: return (EObject)createStringObjectMapEntry();
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
			case BoxingPackage.CONTEXT:
				return createContextFromString(eDataType, initialValue);
			case BoxingPackage.COLLECTION:
				return createCollectionFromString(eDataType, initialValue);
			case BoxingPackage.CONVERTER_CONTEXT:
				return createConverterContextFromString(eDataType, initialValue);
			case BoxingPackage.INPUT_STREAM:
				return createInputStreamFromString(eDataType, initialValue);
			case BoxingPackage.READER:
				return createReaderFromString(eDataType, initialValue);
			case BoxingPackage.SERIALIZABLE:
				return createSerializableFromString(eDataType, initialValue);
			case BoxingPackage.JSON_ARRAY:
				return createJSONArrayFromString(eDataType, initialValue);
			case BoxingPackage.JSON_OBJECT:
				return createJSONObjectFromString(eDataType, initialValue);
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
			case BoxingPackage.CONTEXT:
				return convertContextToString(eDataType, instanceValue);
			case BoxingPackage.COLLECTION:
				return convertCollectionToString(eDataType, instanceValue);
			case BoxingPackage.CONVERTER_CONTEXT:
				return convertConverterContextToString(eDataType, instanceValue);
			case BoxingPackage.INPUT_STREAM:
				return convertInputStreamToString(eDataType, instanceValue);
			case BoxingPackage.READER:
				return convertReaderToString(eDataType, instanceValue);
			case BoxingPackage.SERIALIZABLE:
				return convertSerializableToString(eDataType, instanceValue);
			case BoxingPackage.JSON_ARRAY:
				return convertJSONArrayToString(eDataType, instanceValue);
			case BoxingPackage.JSON_OBJECT:
				return convertJSONObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimalBox createBigDecimalBox() {
		BigDecimalBoxImpl bigDecimalBox = new BigDecimalBoxImpl();
		return bigDecimalBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigIntegerBox createBigIntegerBox() {
		BigIntegerBoxImpl bigIntegerBox = new BigIntegerBoxImpl();
		return bigIntegerBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanBox createBooleanBox() {
		BooleanBoxImpl booleanBox = new BooleanBoxImpl();
		return booleanBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByteBox createByteBox() {
		ByteBoxImpl byteBox = new ByteBoxImpl();
		return byteBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByteArrayBox createByteArrayBox() {
		ByteArrayBoxImpl byteArrayBox = new ByteArrayBoxImpl();
		return byteArrayBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterBox createCharacterBox() {
		CharacterBoxImpl characterBox = new CharacterBoxImpl();
		return characterBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateBox createDateBox() {
		DateBoxImpl dateBox = new DateBoxImpl();
		return dateBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleBox createDoubleBox() {
		DoubleBoxImpl doubleBox = new DoubleBoxImpl();
		return doubleBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatBox createFloatBox() {
		FloatBoxImpl floatBox = new FloatBoxImpl();
		return floatBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerBox createIntegerBox() {
		IntegerBoxImpl integerBox = new IntegerBoxImpl();
		return integerBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongBox createLongBox() {
		LongBoxImpl longBox = new LongBoxImpl();
		return longBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortBox createShortBox() {
		ShortBoxImpl shortBox = new ShortBoxImpl();
		return shortBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringBox createStringBox() {
		StringBoxImpl stringBox = new StringBoxImpl();
		return stringBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> CollectionBox<T> createCollectionBox() {
		CollectionBoxImpl<T> collectionBox = new CollectionBoxImpl<T>();
		return collectionBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <K, V> MapBox<K, V> createMapBox() {
		MapBoxImpl<K, V> mapBox = new MapBoxImpl<K, V>();
		return mapBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapEntry createMapEntry() {
		MapEntryImpl mapEntry = new MapEntryImpl();
		return mapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StreamBox createStreamBox() {
		StreamBoxImpl streamBox = new StreamBoxImpl();
		return streamBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReaderBox createReaderBox() {
		ReaderBoxImpl readerBox = new ReaderBoxImpl();
		return readerBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializableBox createSerializableBox() {
		SerializableBoxImpl serializableBox = new SerializableBoxImpl();
		return serializableBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceBox createReferenceBox() {
		ReferenceBoxImpl referenceBox = new ReferenceBoxImpl();
		return referenceBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullBox createNullBox() {
		NullBoxImpl nullBox = new NullBoxImpl();
		return nullBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifierBox createEClassifierBox() {
		EClassifierBoxImpl eClassifierBox = new EClassifierBoxImpl();
		return eClassifierBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ClassBox<T> createClassBox() {
		ClassBoxImpl<T> classBox = new ClassBoxImpl<T>();
		return classBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ObjectBox<T> createObjectBox() {
		ObjectBoxImpl<T> objectBox = new ObjectBoxImpl<T>();
		return objectBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldEntry createFieldEntry() {
		FieldEntryImpl fieldEntry = new FieldEntryImpl();
		return fieldEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharArrayBox createCharArrayBox() {
		CharArrayBoxImpl charArrayBox = new CharArrayBoxImpl();
		return charArrayBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleArrayBox createDoubleArrayBox() {
		DoubleArrayBoxImpl doubleArrayBox = new DoubleArrayBoxImpl();
		return doubleArrayBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatArrayBox createFloatArrayBox() {
		FloatArrayBoxImpl floatArrayBox = new FloatArrayBoxImpl();
		return floatArrayBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntArrayBox createIntArrayBox() {
		IntArrayBoxImpl intArrayBox = new IntArrayBoxImpl();
		return intArrayBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongArrayBox createLongArrayBox() {
		LongArrayBoxImpl longArrayBox = new LongArrayBoxImpl();
		return longArrayBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ObjectArrayBox<T> createObjectArrayBox() {
		ObjectArrayBoxImpl<T> objectArrayBox = new ObjectArrayBoxImpl<T>();
		return objectArrayBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortArrayBox createShortArrayBox() {
		ShortArrayBoxImpl shortArrayBox = new ShortArrayBoxImpl();
		return shortArrayBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JsonArrayBox createJsonArrayBox() {
		JsonArrayBoxImpl jsonArrayBox = new JsonArrayBoxImpl();
		return jsonArrayBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JsonObjectBox createJsonObjectBox() {
		JsonObjectBoxImpl jsonObjectBox = new JsonObjectBoxImpl();
		return jsonObjectBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EObject> createStringObjectMapEntry() {
		StringObjectMapEntryImpl stringObjectMapEntry = new StringObjectMapEntryImpl();
		return stringObjectMapEntry;
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
	public Collection<?> createCollectionFromString(EDataType eDataType, String initialValue) {
		return (Collection<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConverterContext createConverterContextFromString(EDataType eDataType, String initialValue) {
		return (ConverterContext)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConverterContextToString(EDataType eDataType, Object instanceValue) {
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
	public Reader createReaderFromString(EDataType eDataType, String initialValue) {
		return (Reader)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReaderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Serializable createSerializableFromString(EDataType eDataType, String initialValue) {
		return (Serializable)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSerializableToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSONArray createJSONArrayFromString(EDataType eDataType, String initialValue) {
		return (JSONArray)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJSONArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSONObject createJSONObjectFromString(EDataType eDataType, String initialValue) {
		return (JSONObject)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJSONObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoxingPackage getBoxingPackage() {
		return (BoxingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BoxingPackage getPackage() {
		return BoxingPackage.eINSTANCE;
	}

} //BoxingFactoryImpl
