/**
 */
package org.nasdanika.cdo.boxing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.boxing.BoxingFactory
 * @model kind="package"
 * @generated
 */
public interface BoxingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "boxing";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.cdo.boxing";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.cdo.boxing";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BoxingPackage eINSTANCE = org.nasdanika.cdo.boxing.impl.BoxingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.Box <em>Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.Box
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getBox()
	 * @generated
	 */
	int BOX = 0;

	/**
	 * The number of structural features of the '<em>Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX___GET__CONTEXT = 0;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX___SET__OBJECT_CONTEXT = 1;

	/**
	 * The number of operations of the '<em>Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '<em>Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.Context
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 36;

	/**
	 * The meta object id for the '<em>Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 37;

	/**
	 * The meta object id for the '<em>Input Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.InputStream
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getInputStream()
	 * @generated
	 */
	int INPUT_STREAM = 38;

	/**
	 * The meta object id for the '<em>Reader</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.Reader
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getReader()
	 * @generated
	 */
	int READER = 39;

	/**
	 * The meta object id for the '<em>Serializable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.Serializable
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getSerializable()
	 * @generated
	 */
	int SERIALIZABLE = 40;

	/**
	 * The meta object id for the '<em>JSON Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.json.JSONArray
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getJSONArray()
	 * @generated
	 */
	int JSON_ARRAY = 41;

	/**
	 * The meta object id for the '<em>JSON Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.json.JSONObject
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getJSONObject()
	 * @generated
	 */
	int JSON_OBJECT = 42;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.BigDecimalBoxImpl <em>Big Decimal Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.BigDecimalBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getBigDecimalBox()
	 * @generated
	 */
	int BIG_DECIMAL_BOX = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_DECIMAL_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Big Decimal Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_DECIMAL_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_DECIMAL_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_DECIMAL_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Big Decimal Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_DECIMAL_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.BigIntegerBoxImpl <em>Big Integer Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.BigIntegerBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getBigIntegerBox()
	 * @generated
	 */
	int BIG_INTEGER_BOX = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_INTEGER_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Big Integer Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_INTEGER_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_INTEGER_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_INTEGER_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Big Integer Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_INTEGER_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.BooleanBoxImpl <em>Boolean Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.BooleanBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getBooleanBox()
	 * @generated
	 */
	int BOOLEAN_BOX = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Boolean Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ByteBoxImpl <em>Byte Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ByteBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getByteBox()
	 * @generated
	 */
	int BYTE_BOX = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Byte Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Byte Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ByteArrayBoxImpl <em>Byte Array Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ByteArrayBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getByteArrayBox()
	 * @generated
	 */
	int BYTE_ARRAY_BOX = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_ARRAY_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Byte Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_ARRAY_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_ARRAY_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_ARRAY_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Byte Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_ARRAY_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.CharacterBoxImpl <em>Character Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.CharacterBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCharacterBox()
	 * @generated
	 */
	int CHARACTER_BOX = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Character Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Character Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.DateBoxImpl <em>Date Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.DateBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getDateBox()
	 * @generated
	 */
	int DATE_BOX = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Date Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Date Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.DoubleBoxImpl <em>Double Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.DoubleBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getDoubleBox()
	 * @generated
	 */
	int DOUBLE_BOX = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Double Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.FloatBoxImpl <em>Float Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.FloatBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getFloatBox()
	 * @generated
	 */
	int FLOAT_BOX = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Float Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Float Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.IntegerBoxImpl <em>Integer Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.IntegerBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getIntegerBox()
	 * @generated
	 */
	int INTEGER_BOX = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Integer Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.LongBoxImpl <em>Long Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.LongBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getLongBox()
	 * @generated
	 */
	int LONG_BOX = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Long Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Long Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ShortBoxImpl <em>Short Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ShortBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getShortBox()
	 * @generated
	 */
	int SHORT_BOX = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Short Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Short Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.StringBoxImpl <em>String Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.StringBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getStringBox()
	 * @generated
	 */
	int STRING_BOX = 13;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>String Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.CollectionBoxImpl <em>Collection Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.CollectionBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCollectionBox()
	 * @generated
	 */
	int COLLECTION_BOX = 14;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_BOX__ELEMENTS = BOX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_BOX__TYPE = BOX_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Collection Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.MapBoxImpl <em>Map Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.MapBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getMapBox()
	 * @generated
	 */
	int MAP_BOX = 15;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BOX__ENTRIES = BOX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BOX__TYPE = BOX_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Map Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Map Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.MapEntryImpl <em>Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.MapEntryImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getMapEntry()
	 * @generated
	 */
	int MAP_ENTRY = 16;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.StreamBoxImpl <em>Stream Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.StreamBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getStreamBox()
	 * @generated
	 */
	int STREAM_BOX = 17;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stream Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Stream Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ReaderBoxImpl <em>Reader Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ReaderBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getReaderBox()
	 * @generated
	 */
	int READER_BOX = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reader Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Reader Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.SerializableBoxImpl <em>Serializable Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.SerializableBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getSerializableBox()
	 * @generated
	 */
	int SERIALIZABLE_BOX = 19;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZABLE_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Serializable Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZABLE_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZABLE_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZABLE_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Serializable Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZABLE_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ReferenceBoxImpl <em>Reference Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ReferenceBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getReferenceBox()
	 * @generated
	 */
	int REFERENCE_BOX = 20;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOX__TARGET = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Reference Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.NullBoxImpl <em>Null Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.NullBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getNullBox()
	 * @generated
	 */
	int NULL_BOX = 21;

	/**
	 * The number of structural features of the '<em>Null Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Null Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.EClassifierBoxImpl <em>EClassifier Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.EClassifierBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getEClassifierBox()
	 * @generated
	 */
	int ECLASSIFIER_BOX = 22;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_BOX__NS_URI = BOX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_BOX__NAME = BOX_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EClassifier Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>EClassifier Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASSIFIER_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ClassBoxImpl <em>Class Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ClassBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getClassBox()
	 * @generated
	 */
	int CLASS_BOX = 23;

	/**
	 * The feature id for the '<em><b>Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BOX__BUNDLE_NAME = BOX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bundle Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BOX__BUNDLE_VERSION = BOX_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BOX__CLASS_NAME = BOX_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Class Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ObjectBoxImpl <em>Object Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ObjectBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getObjectBox()
	 * @generated
	 */
	int OBJECT_BOX = 24;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOX__FIELDS = BOX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOX__TYPE = BOX_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Object Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.FieldEntryImpl <em>Field Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.FieldEntryImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getFieldEntry()
	 * @generated
	 */
	int FIELD_ENTRY = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ENTRY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Declaring Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ENTRY__DECLARING_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ENTRY__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Field Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Field Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_ENTRY_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.CharArrayBoxImpl <em>Char Array Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.CharArrayBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCharArrayBox()
	 * @generated
	 */
	int CHAR_ARRAY_BOX = 26;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAR_ARRAY_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Char Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAR_ARRAY_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAR_ARRAY_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAR_ARRAY_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Char Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHAR_ARRAY_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.DoubleArrayBoxImpl <em>Double Array Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.DoubleArrayBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getDoubleArrayBox()
	 * @generated
	 */
	int DOUBLE_ARRAY_BOX = 27;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ARRAY_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ARRAY_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ARRAY_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ARRAY_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Double Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ARRAY_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.FloatArrayBoxImpl <em>Float Array Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.FloatArrayBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getFloatArrayBox()
	 * @generated
	 */
	int FLOAT_ARRAY_BOX = 28;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_ARRAY_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Float Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_ARRAY_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_ARRAY_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_ARRAY_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Float Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_ARRAY_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.IntArrayBoxImpl <em>Int Array Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.IntArrayBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getIntArrayBox()
	 * @generated
	 */
	int INT_ARRAY_BOX = 29;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ARRAY_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ARRAY_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ARRAY_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ARRAY_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Int Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ARRAY_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.LongArrayBoxImpl <em>Long Array Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.LongArrayBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getLongArrayBox()
	 * @generated
	 */
	int LONG_ARRAY_BOX = 30;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ARRAY_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Long Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ARRAY_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ARRAY_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ARRAY_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Long Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ARRAY_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ObjectArrayBoxImpl <em>Object Array Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ObjectArrayBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getObjectArrayBox()
	 * @generated
	 */
	int OBJECT_ARRAY_BOX = 31;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ARRAY_BOX__ELEMENT_TYPE = BOX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ARRAY_BOX__ELEMENTS = BOX_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ARRAY_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ARRAY_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ARRAY_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Object Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ARRAY_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ShortArrayBoxImpl <em>Short Array Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ShortArrayBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getShortArrayBox()
	 * @generated
	 */
	int SHORT_ARRAY_BOX = 32;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_ARRAY_BOX__VALUE = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Short Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_ARRAY_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_ARRAY_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_ARRAY_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Short Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_ARRAY_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.JsonArrayBoxImpl <em>Json Array Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.JsonArrayBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getJsonArrayBox()
	 * @generated
	 */
	int JSON_ARRAY_BOX = 33;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_ARRAY_BOX__ELEMENTS = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Json Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_ARRAY_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_ARRAY_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_ARRAY_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Json Array Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_ARRAY_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.JsonObjectBoxImpl <em>Json Object Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.JsonObjectBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getJsonObjectBox()
	 * @generated
	 */
	int JSON_OBJECT_BOX = 34;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_OBJECT_BOX__ELEMENTS = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Json Object Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_OBJECT_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_OBJECT_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_OBJECT_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>Json Object Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_OBJECT_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.StringObjectMapEntryImpl <em>String Object Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.StringObjectMapEntryImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getStringObjectMapEntry()
	 * @generated
	 */
	int STRING_OBJECT_MAP_ENTRY = 35;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_OBJECT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_OBJECT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String Object Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_OBJECT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String Object Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_OBJECT_MAP_ENTRY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.Box <em>Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Box</em>'.
	 * @see org.nasdanika.cdo.boxing.Box
	 * @generated
	 */
	EClass getBox();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.boxing.Box#get(org.nasdanika.core.Context) <em>Get</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get</em>' operation.
	 * @see org.nasdanika.cdo.boxing.Box#get(org.nasdanika.core.Context)
	 * @generated
	 */
	EOperation getBox__Get__Context();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.boxing.Box#set(java.lang.Object, org.nasdanika.core.Context) <em>Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set</em>' operation.
	 * @see org.nasdanika.cdo.boxing.Box#set(java.lang.Object, org.nasdanika.core.Context)
	 * @generated
	 */
	EOperation getBox__Set__Object_Context();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.core.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Context</em>'.
	 * @see org.nasdanika.core.Context
	 * @model instanceClass="org.nasdanika.core.Context"
	 * @generated
	 */
	EDataType getContext();

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection" typeParameters="T"
	 * @generated
	 */
	EDataType getCollection();

	/**
	 * Returns the meta object for data type '{@link java.io.InputStream <em>Input Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Input Stream</em>'.
	 * @see java.io.InputStream
	 * @model instanceClass="java.io.InputStream"
	 * @generated
	 */
	EDataType getInputStream();

	/**
	 * Returns the meta object for data type '{@link java.io.Reader <em>Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Reader</em>'.
	 * @see java.io.Reader
	 * @model instanceClass="java.io.Reader"
	 * @generated
	 */
	EDataType getReader();

	/**
	 * Returns the meta object for data type '{@link java.io.Serializable <em>Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Serializable</em>'.
	 * @see java.io.Serializable
	 * @model instanceClass="java.io.Serializable"
	 * @generated
	 */
	EDataType getSerializable();

	/**
	 * Returns the meta object for data type '{@link org.json.JSONArray <em>JSON Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JSON Array</em>'.
	 * @see org.json.JSONArray
	 * @model instanceClass="org.json.JSONArray"
	 * @generated
	 */
	EDataType getJSONArray();

	/**
	 * Returns the meta object for data type '{@link org.json.JSONObject <em>JSON Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JSON Object</em>'.
	 * @see org.json.JSONObject
	 * @model instanceClass="org.json.JSONObject"
	 * @generated
	 */
	EDataType getJSONObject();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.BigDecimalBox <em>Big Decimal Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Big Decimal Box</em>'.
	 * @see org.nasdanika.cdo.boxing.BigDecimalBox
	 * @generated
	 */
	EClass getBigDecimalBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.BigDecimalBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.BigDecimalBox#getValue()
	 * @see #getBigDecimalBox()
	 * @generated
	 */
	EAttribute getBigDecimalBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.BigIntegerBox <em>Big Integer Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Big Integer Box</em>'.
	 * @see org.nasdanika.cdo.boxing.BigIntegerBox
	 * @generated
	 */
	EClass getBigIntegerBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.BigIntegerBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.BigIntegerBox#getValue()
	 * @see #getBigIntegerBox()
	 * @generated
	 */
	EAttribute getBigIntegerBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.BooleanBox <em>Boolean Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Box</em>'.
	 * @see org.nasdanika.cdo.boxing.BooleanBox
	 * @generated
	 */
	EClass getBooleanBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.BooleanBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.BooleanBox#getValue()
	 * @see #getBooleanBox()
	 * @generated
	 */
	EAttribute getBooleanBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ByteBox <em>Byte Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Byte Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ByteBox
	 * @generated
	 */
	EClass getByteBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.ByteBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.ByteBox#getValue()
	 * @see #getByteBox()
	 * @generated
	 */
	EAttribute getByteBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ByteArrayBox <em>Byte Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Byte Array Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ByteArrayBox
	 * @generated
	 */
	EClass getByteArrayBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.ByteArrayBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.ByteArrayBox#getValue()
	 * @see #getByteArrayBox()
	 * @generated
	 */
	EAttribute getByteArrayBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.CharacterBox <em>Character Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Character Box</em>'.
	 * @see org.nasdanika.cdo.boxing.CharacterBox
	 * @generated
	 */
	EClass getCharacterBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.CharacterBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.CharacterBox#getValue()
	 * @see #getCharacterBox()
	 * @generated
	 */
	EAttribute getCharacterBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.DateBox <em>Date Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date Box</em>'.
	 * @see org.nasdanika.cdo.boxing.DateBox
	 * @generated
	 */
	EClass getDateBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.DateBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.DateBox#getValue()
	 * @see #getDateBox()
	 * @generated
	 */
	EAttribute getDateBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.DoubleBox <em>Double Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Box</em>'.
	 * @see org.nasdanika.cdo.boxing.DoubleBox
	 * @generated
	 */
	EClass getDoubleBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.DoubleBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.DoubleBox#getValue()
	 * @see #getDoubleBox()
	 * @generated
	 */
	EAttribute getDoubleBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.FloatBox <em>Float Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Box</em>'.
	 * @see org.nasdanika.cdo.boxing.FloatBox
	 * @generated
	 */
	EClass getFloatBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.FloatBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.FloatBox#getValue()
	 * @see #getFloatBox()
	 * @generated
	 */
	EAttribute getFloatBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.IntegerBox <em>Integer Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Box</em>'.
	 * @see org.nasdanika.cdo.boxing.IntegerBox
	 * @generated
	 */
	EClass getIntegerBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.IntegerBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.IntegerBox#getValue()
	 * @see #getIntegerBox()
	 * @generated
	 */
	EAttribute getIntegerBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.LongBox <em>Long Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Box</em>'.
	 * @see org.nasdanika.cdo.boxing.LongBox
	 * @generated
	 */
	EClass getLongBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.LongBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.LongBox#getValue()
	 * @see #getLongBox()
	 * @generated
	 */
	EAttribute getLongBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ShortBox <em>Short Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Short Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ShortBox
	 * @generated
	 */
	EClass getShortBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.ShortBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.ShortBox#getValue()
	 * @see #getShortBox()
	 * @generated
	 */
	EAttribute getShortBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.StringBox <em>String Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Box</em>'.
	 * @see org.nasdanika.cdo.boxing.StringBox
	 * @generated
	 */
	EClass getStringBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.StringBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.StringBox#getValue()
	 * @see #getStringBox()
	 * @generated
	 */
	EAttribute getStringBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.CollectionBox <em>Collection Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Box</em>'.
	 * @see org.nasdanika.cdo.boxing.CollectionBox
	 * @generated
	 */
	EClass getCollectionBox();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.boxing.CollectionBox#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.nasdanika.cdo.boxing.CollectionBox#getElements()
	 * @see #getCollectionBox()
	 * @generated
	 */
	EReference getCollectionBox_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.boxing.CollectionBox#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.nasdanika.cdo.boxing.CollectionBox#getType()
	 * @see #getCollectionBox()
	 * @generated
	 */
	EReference getCollectionBox_Type();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.MapBox <em>Map Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Box</em>'.
	 * @see org.nasdanika.cdo.boxing.MapBox
	 * @generated
	 */
	EClass getMapBox();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.boxing.MapBox#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.nasdanika.cdo.boxing.MapBox#getEntries()
	 * @see #getMapBox()
	 * @generated
	 */
	EReference getMapBox_Entries();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.boxing.MapBox#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.nasdanika.cdo.boxing.MapBox#getType()
	 * @see #getMapBox()
	 * @generated
	 */
	EReference getMapBox_Type();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.MapEntry <em>Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Entry</em>'.
	 * @see org.nasdanika.cdo.boxing.MapEntry
	 * @generated
	 */
	EClass getMapEntry();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.boxing.MapEntry#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.nasdanika.cdo.boxing.MapEntry#getKey()
	 * @see #getMapEntry()
	 * @generated
	 */
	EReference getMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.boxing.MapEntry#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.MapEntry#getValue()
	 * @see #getMapEntry()
	 * @generated
	 */
	EReference getMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.StreamBox <em>Stream Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream Box</em>'.
	 * @see org.nasdanika.cdo.boxing.StreamBox
	 * @generated
	 */
	EClass getStreamBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.StreamBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.StreamBox#getValue()
	 * @see #getStreamBox()
	 * @generated
	 */
	EAttribute getStreamBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ReaderBox <em>Reader Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reader Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ReaderBox
	 * @generated
	 */
	EClass getReaderBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.ReaderBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.ReaderBox#getValue()
	 * @see #getReaderBox()
	 * @generated
	 */
	EAttribute getReaderBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.SerializableBox <em>Serializable Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serializable Box</em>'.
	 * @see org.nasdanika.cdo.boxing.SerializableBox
	 * @generated
	 */
	EClass getSerializableBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.SerializableBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.SerializableBox#getValue()
	 * @see #getSerializableBox()
	 * @generated
	 */
	EAttribute getSerializableBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ReferenceBox <em>Reference Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ReferenceBox
	 * @generated
	 */
	EClass getReferenceBox();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.boxing.ReferenceBox#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.boxing.ReferenceBox#getTarget()
	 * @see #getReferenceBox()
	 * @generated
	 */
	EReference getReferenceBox_Target();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.NullBox <em>Null Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Box</em>'.
	 * @see org.nasdanika.cdo.boxing.NullBox
	 * @generated
	 */
	EClass getNullBox();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.EClassifierBox <em>EClassifier Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClassifier Box</em>'.
	 * @see org.nasdanika.cdo.boxing.EClassifierBox
	 * @generated
	 */
	EClass getEClassifierBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.EClassifierBox#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.nasdanika.cdo.boxing.EClassifierBox#getNsURI()
	 * @see #getEClassifierBox()
	 * @generated
	 */
	EAttribute getEClassifierBox_NsURI();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.EClassifierBox#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.cdo.boxing.EClassifierBox#getName()
	 * @see #getEClassifierBox()
	 * @generated
	 */
	EAttribute getEClassifierBox_Name();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ClassBox <em>Class Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ClassBox
	 * @generated
	 */
	EClass getClassBox();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.ClassBox#getBundleName <em>Bundle Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle Name</em>'.
	 * @see org.nasdanika.cdo.boxing.ClassBox#getBundleName()
	 * @see #getClassBox()
	 * @generated
	 */
	EAttribute getClassBox_BundleName();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.ClassBox#getBundleVersion <em>Bundle Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle Version</em>'.
	 * @see org.nasdanika.cdo.boxing.ClassBox#getBundleVersion()
	 * @see #getClassBox()
	 * @generated
	 */
	EAttribute getClassBox_BundleVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.ClassBox#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.nasdanika.cdo.boxing.ClassBox#getClassName()
	 * @see #getClassBox()
	 * @generated
	 */
	EAttribute getClassBox_ClassName();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ObjectBox <em>Object Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ObjectBox
	 * @generated
	 */
	EClass getObjectBox();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.boxing.ObjectBox#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.nasdanika.cdo.boxing.ObjectBox#getFields()
	 * @see #getObjectBox()
	 * @generated
	 */
	EReference getObjectBox_Fields();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.boxing.ObjectBox#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.nasdanika.cdo.boxing.ObjectBox#getType()
	 * @see #getObjectBox()
	 * @generated
	 */
	EReference getObjectBox_Type();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.FieldEntry <em>Field Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field Entry</em>'.
	 * @see org.nasdanika.cdo.boxing.FieldEntry
	 * @generated
	 */
	EClass getFieldEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.FieldEntry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.cdo.boxing.FieldEntry#getName()
	 * @see #getFieldEntry()
	 * @generated
	 */
	EAttribute getFieldEntry_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.boxing.FieldEntry#getDeclaringClass <em>Declaring Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declaring Class</em>'.
	 * @see org.nasdanika.cdo.boxing.FieldEntry#getDeclaringClass()
	 * @see #getFieldEntry()
	 * @generated
	 */
	EAttribute getFieldEntry_DeclaringClass();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.boxing.FieldEntry#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.FieldEntry#getValue()
	 * @see #getFieldEntry()
	 * @generated
	 */
	EReference getFieldEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.CharArrayBox <em>Char Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Char Array Box</em>'.
	 * @see org.nasdanika.cdo.boxing.CharArrayBox
	 * @generated
	 */
	EClass getCharArrayBox();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.cdo.boxing.CharArrayBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.CharArrayBox#getValue()
	 * @see #getCharArrayBox()
	 * @generated
	 */
	EAttribute getCharArrayBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.DoubleArrayBox <em>Double Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Array Box</em>'.
	 * @see org.nasdanika.cdo.boxing.DoubleArrayBox
	 * @generated
	 */
	EClass getDoubleArrayBox();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.cdo.boxing.DoubleArrayBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.DoubleArrayBox#getValue()
	 * @see #getDoubleArrayBox()
	 * @generated
	 */
	EAttribute getDoubleArrayBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.FloatArrayBox <em>Float Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Array Box</em>'.
	 * @see org.nasdanika.cdo.boxing.FloatArrayBox
	 * @generated
	 */
	EClass getFloatArrayBox();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.cdo.boxing.FloatArrayBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.FloatArrayBox#getValue()
	 * @see #getFloatArrayBox()
	 * @generated
	 */
	EAttribute getFloatArrayBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.IntArrayBox <em>Int Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Array Box</em>'.
	 * @see org.nasdanika.cdo.boxing.IntArrayBox
	 * @generated
	 */
	EClass getIntArrayBox();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.cdo.boxing.IntArrayBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.IntArrayBox#getValue()
	 * @see #getIntArrayBox()
	 * @generated
	 */
	EAttribute getIntArrayBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.LongArrayBox <em>Long Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Array Box</em>'.
	 * @see org.nasdanika.cdo.boxing.LongArrayBox
	 * @generated
	 */
	EClass getLongArrayBox();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.cdo.boxing.LongArrayBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.LongArrayBox#getValue()
	 * @see #getLongArrayBox()
	 * @generated
	 */
	EAttribute getLongArrayBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ObjectArrayBox <em>Object Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Array Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ObjectArrayBox
	 * @generated
	 */
	EClass getObjectArrayBox();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.boxing.ObjectArrayBox#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element Type</em>'.
	 * @see org.nasdanika.cdo.boxing.ObjectArrayBox#getElementType()
	 * @see #getObjectArrayBox()
	 * @generated
	 */
	EReference getObjectArrayBox_ElementType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.boxing.ObjectArrayBox#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.nasdanika.cdo.boxing.ObjectArrayBox#getElements()
	 * @see #getObjectArrayBox()
	 * @generated
	 */
	EReference getObjectArrayBox_Elements();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ShortArrayBox <em>Short Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Short Array Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ShortArrayBox
	 * @generated
	 */
	EClass getShortArrayBox();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.cdo.boxing.ShortArrayBox#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.nasdanika.cdo.boxing.ShortArrayBox#getValue()
	 * @see #getShortArrayBox()
	 * @generated
	 */
	EAttribute getShortArrayBox_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.JsonArrayBox <em>Json Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Json Array Box</em>'.
	 * @see org.nasdanika.cdo.boxing.JsonArrayBox
	 * @generated
	 */
	EClass getJsonArrayBox();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.cdo.boxing.JsonArrayBox#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.nasdanika.cdo.boxing.JsonArrayBox#getElements()
	 * @see #getJsonArrayBox()
	 * @generated
	 */
	EReference getJsonArrayBox_Elements();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.JsonObjectBox <em>Json Object Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Json Object Box</em>'.
	 * @see org.nasdanika.cdo.boxing.JsonObjectBox
	 * @generated
	 */
	EClass getJsonObjectBox();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.boxing.JsonObjectBox#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Elements</em>'.
	 * @see org.nasdanika.cdo.boxing.JsonObjectBox#getElements()
	 * @see #getJsonObjectBox()
	 * @generated
	 */
	EReference getJsonObjectBox_Elements();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String Object Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Object Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true"
	 * @generated
	 */
	EClass getStringObjectMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringObjectMapEntry()
	 * @generated
	 */
	EAttribute getStringObjectMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringObjectMapEntry()
	 * @generated
	 */
	EReference getStringObjectMapEntry_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BoxingFactory getBoxingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.Box <em>Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.Box
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getBox()
		 * @generated
		 */
		EClass BOX = eINSTANCE.getBox();

		/**
		 * The meta object literal for the '<em><b>Get</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOX___GET__CONTEXT = eINSTANCE.getBox__Get__Context();

		/**
		 * The meta object literal for the '<em><b>Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOX___SET__OBJECT_CONTEXT = eINSTANCE.getBox__Set__Object_Context();

		/**
		 * The meta object literal for the '<em>Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.core.Context
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getContext()
		 * @generated
		 */
		EDataType CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em>Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCollection()
		 * @generated
		 */
		EDataType COLLECTION = eINSTANCE.getCollection();

		/**
		 * The meta object literal for the '<em>Input Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.InputStream
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getInputStream()
		 * @generated
		 */
		EDataType INPUT_STREAM = eINSTANCE.getInputStream();

		/**
		 * The meta object literal for the '<em>Reader</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.Reader
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getReader()
		 * @generated
		 */
		EDataType READER = eINSTANCE.getReader();

		/**
		 * The meta object literal for the '<em>Serializable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.Serializable
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getSerializable()
		 * @generated
		 */
		EDataType SERIALIZABLE = eINSTANCE.getSerializable();

		/**
		 * The meta object literal for the '<em>JSON Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.json.JSONArray
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getJSONArray()
		 * @generated
		 */
		EDataType JSON_ARRAY = eINSTANCE.getJSONArray();

		/**
		 * The meta object literal for the '<em>JSON Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.json.JSONObject
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getJSONObject()
		 * @generated
		 */
		EDataType JSON_OBJECT = eINSTANCE.getJSONObject();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.BigDecimalBoxImpl <em>Big Decimal Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.BigDecimalBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getBigDecimalBox()
		 * @generated
		 */
		EClass BIG_DECIMAL_BOX = eINSTANCE.getBigDecimalBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIG_DECIMAL_BOX__VALUE = eINSTANCE.getBigDecimalBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.BigIntegerBoxImpl <em>Big Integer Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.BigIntegerBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getBigIntegerBox()
		 * @generated
		 */
		EClass BIG_INTEGER_BOX = eINSTANCE.getBigIntegerBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIG_INTEGER_BOX__VALUE = eINSTANCE.getBigIntegerBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.BooleanBoxImpl <em>Boolean Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.BooleanBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getBooleanBox()
		 * @generated
		 */
		EClass BOOLEAN_BOX = eINSTANCE.getBooleanBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_BOX__VALUE = eINSTANCE.getBooleanBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ByteBoxImpl <em>Byte Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ByteBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getByteBox()
		 * @generated
		 */
		EClass BYTE_BOX = eINSTANCE.getByteBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BYTE_BOX__VALUE = eINSTANCE.getByteBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ByteArrayBoxImpl <em>Byte Array Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ByteArrayBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getByteArrayBox()
		 * @generated
		 */
		EClass BYTE_ARRAY_BOX = eINSTANCE.getByteArrayBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BYTE_ARRAY_BOX__VALUE = eINSTANCE.getByteArrayBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.CharacterBoxImpl <em>Character Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.CharacterBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCharacterBox()
		 * @generated
		 */
		EClass CHARACTER_BOX = eINSTANCE.getCharacterBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHARACTER_BOX__VALUE = eINSTANCE.getCharacterBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.DateBoxImpl <em>Date Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.DateBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getDateBox()
		 * @generated
		 */
		EClass DATE_BOX = eINSTANCE.getDateBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_BOX__VALUE = eINSTANCE.getDateBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.DoubleBoxImpl <em>Double Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.DoubleBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getDoubleBox()
		 * @generated
		 */
		EClass DOUBLE_BOX = eINSTANCE.getDoubleBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_BOX__VALUE = eINSTANCE.getDoubleBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.FloatBoxImpl <em>Float Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.FloatBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getFloatBox()
		 * @generated
		 */
		EClass FLOAT_BOX = eINSTANCE.getFloatBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOAT_BOX__VALUE = eINSTANCE.getFloatBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.IntegerBoxImpl <em>Integer Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.IntegerBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getIntegerBox()
		 * @generated
		 */
		EClass INTEGER_BOX = eINSTANCE.getIntegerBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_BOX__VALUE = eINSTANCE.getIntegerBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.LongBoxImpl <em>Long Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.LongBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getLongBox()
		 * @generated
		 */
		EClass LONG_BOX = eINSTANCE.getLongBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_BOX__VALUE = eINSTANCE.getLongBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ShortBoxImpl <em>Short Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ShortBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getShortBox()
		 * @generated
		 */
		EClass SHORT_BOX = eINSTANCE.getShortBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHORT_BOX__VALUE = eINSTANCE.getShortBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.StringBoxImpl <em>String Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.StringBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getStringBox()
		 * @generated
		 */
		EClass STRING_BOX = eINSTANCE.getStringBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_BOX__VALUE = eINSTANCE.getStringBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.CollectionBoxImpl <em>Collection Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.CollectionBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCollectionBox()
		 * @generated
		 */
		EClass COLLECTION_BOX = eINSTANCE.getCollectionBox();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_BOX__ELEMENTS = eINSTANCE.getCollectionBox_Elements();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_BOX__TYPE = eINSTANCE.getCollectionBox_Type();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.MapBoxImpl <em>Map Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.MapBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getMapBox()
		 * @generated
		 */
		EClass MAP_BOX = eINSTANCE.getMapBox();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_BOX__ENTRIES = eINSTANCE.getMapBox_Entries();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_BOX__TYPE = eINSTANCE.getMapBox_Type();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.MapEntryImpl <em>Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.MapEntryImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getMapEntry()
		 * @generated
		 */
		EClass MAP_ENTRY = eINSTANCE.getMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_ENTRY__KEY = eINSTANCE.getMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_ENTRY__VALUE = eINSTANCE.getMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.StreamBoxImpl <em>Stream Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.StreamBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getStreamBox()
		 * @generated
		 */
		EClass STREAM_BOX = eINSTANCE.getStreamBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STREAM_BOX__VALUE = eINSTANCE.getStreamBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ReaderBoxImpl <em>Reader Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ReaderBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getReaderBox()
		 * @generated
		 */
		EClass READER_BOX = eINSTANCE.getReaderBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READER_BOX__VALUE = eINSTANCE.getReaderBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.SerializableBoxImpl <em>Serializable Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.SerializableBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getSerializableBox()
		 * @generated
		 */
		EClass SERIALIZABLE_BOX = eINSTANCE.getSerializableBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZABLE_BOX__VALUE = eINSTANCE.getSerializableBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ReferenceBoxImpl <em>Reference Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ReferenceBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getReferenceBox()
		 * @generated
		 */
		EClass REFERENCE_BOX = eINSTANCE.getReferenceBox();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_BOX__TARGET = eINSTANCE.getReferenceBox_Target();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.NullBoxImpl <em>Null Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.NullBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getNullBox()
		 * @generated
		 */
		EClass NULL_BOX = eINSTANCE.getNullBox();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.EClassifierBoxImpl <em>EClassifier Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.EClassifierBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getEClassifierBox()
		 * @generated
		 */
		EClass ECLASSIFIER_BOX = eINSTANCE.getEClassifierBox();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASSIFIER_BOX__NS_URI = eINSTANCE.getEClassifierBox_NsURI();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASSIFIER_BOX__NAME = eINSTANCE.getEClassifierBox_Name();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ClassBoxImpl <em>Class Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ClassBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getClassBox()
		 * @generated
		 */
		EClass CLASS_BOX = eINSTANCE.getClassBox();

		/**
		 * The meta object literal for the '<em><b>Bundle Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BOX__BUNDLE_NAME = eINSTANCE.getClassBox_BundleName();

		/**
		 * The meta object literal for the '<em><b>Bundle Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BOX__BUNDLE_VERSION = eINSTANCE.getClassBox_BundleVersion();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BOX__CLASS_NAME = eINSTANCE.getClassBox_ClassName();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ObjectBoxImpl <em>Object Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ObjectBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getObjectBox()
		 * @generated
		 */
		EClass OBJECT_BOX = eINSTANCE.getObjectBox();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_BOX__FIELDS = eINSTANCE.getObjectBox_Fields();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_BOX__TYPE = eINSTANCE.getObjectBox_Type();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.FieldEntryImpl <em>Field Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.FieldEntryImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getFieldEntry()
		 * @generated
		 */
		EClass FIELD_ENTRY = eINSTANCE.getFieldEntry();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_ENTRY__NAME = eINSTANCE.getFieldEntry_Name();

		/**
		 * The meta object literal for the '<em><b>Declaring Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_ENTRY__DECLARING_CLASS = eINSTANCE.getFieldEntry_DeclaringClass();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD_ENTRY__VALUE = eINSTANCE.getFieldEntry_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.CharArrayBoxImpl <em>Char Array Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.CharArrayBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCharArrayBox()
		 * @generated
		 */
		EClass CHAR_ARRAY_BOX = eINSTANCE.getCharArrayBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHAR_ARRAY_BOX__VALUE = eINSTANCE.getCharArrayBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.DoubleArrayBoxImpl <em>Double Array Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.DoubleArrayBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getDoubleArrayBox()
		 * @generated
		 */
		EClass DOUBLE_ARRAY_BOX = eINSTANCE.getDoubleArrayBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_ARRAY_BOX__VALUE = eINSTANCE.getDoubleArrayBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.FloatArrayBoxImpl <em>Float Array Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.FloatArrayBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getFloatArrayBox()
		 * @generated
		 */
		EClass FLOAT_ARRAY_BOX = eINSTANCE.getFloatArrayBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOAT_ARRAY_BOX__VALUE = eINSTANCE.getFloatArrayBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.IntArrayBoxImpl <em>Int Array Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.IntArrayBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getIntArrayBox()
		 * @generated
		 */
		EClass INT_ARRAY_BOX = eINSTANCE.getIntArrayBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_ARRAY_BOX__VALUE = eINSTANCE.getIntArrayBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.LongArrayBoxImpl <em>Long Array Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.LongArrayBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getLongArrayBox()
		 * @generated
		 */
		EClass LONG_ARRAY_BOX = eINSTANCE.getLongArrayBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ARRAY_BOX__VALUE = eINSTANCE.getLongArrayBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ObjectArrayBoxImpl <em>Object Array Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ObjectArrayBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getObjectArrayBox()
		 * @generated
		 */
		EClass OBJECT_ARRAY_BOX = eINSTANCE.getObjectArrayBox();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_ARRAY_BOX__ELEMENT_TYPE = eINSTANCE.getObjectArrayBox_ElementType();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_ARRAY_BOX__ELEMENTS = eINSTANCE.getObjectArrayBox_Elements();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ShortArrayBoxImpl <em>Short Array Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ShortArrayBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getShortArrayBox()
		 * @generated
		 */
		EClass SHORT_ARRAY_BOX = eINSTANCE.getShortArrayBox();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHORT_ARRAY_BOX__VALUE = eINSTANCE.getShortArrayBox_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.JsonArrayBoxImpl <em>Json Array Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.JsonArrayBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getJsonArrayBox()
		 * @generated
		 */
		EClass JSON_ARRAY_BOX = eINSTANCE.getJsonArrayBox();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON_ARRAY_BOX__ELEMENTS = eINSTANCE.getJsonArrayBox_Elements();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.JsonObjectBoxImpl <em>Json Object Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.JsonObjectBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getJsonObjectBox()
		 * @generated
		 */
		EClass JSON_OBJECT_BOX = eINSTANCE.getJsonObjectBox();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON_OBJECT_BOX__ELEMENTS = eINSTANCE.getJsonObjectBox_Elements();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.StringObjectMapEntryImpl <em>String Object Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.StringObjectMapEntryImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getStringObjectMapEntry()
		 * @generated
		 */
		EClass STRING_OBJECT_MAP_ENTRY = eINSTANCE.getStringObjectMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_OBJECT_MAP_ENTRY__KEY = eINSTANCE.getStringObjectMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_OBJECT_MAP_ENTRY__VALUE = eINSTANCE.getStringObjectMapEntry_Value();

	}

} //BoxingPackage
