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
	int CONTEXT = 23;

	/**
	 * The meta object id for the '<em>List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getList()
	 * @generated
	 */
	int LIST = 24;

	/**
	 * The meta object id for the '<em>Converter Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.ConverterContext
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getConverterContext()
	 * @generated
	 */
	int CONVERTER_CONTEXT = 25;

	/**
	 * The meta object id for the '<em>Input Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.InputStream
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getInputStream()
	 * @generated
	 */
	int INPUT_STREAM = 26;

	/**
	 * The meta object id for the '<em>CDO View Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.CDOViewContext
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCDOViewContext()
	 * @generated
	 */
	int CDO_VIEW_CONTEXT = 27;

	/**
	 * The meta object id for the '<em>Reader</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.Reader
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getReader()
	 * @generated
	 */
	int READER = 28;

	/**
	 * The meta object id for the '<em>Serializable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.Serializable
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getSerializable()
	 * @generated
	 */
	int SERIALIZABLE = 29;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.ListBoxImpl <em>List Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.ListBoxImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getListBox()
	 * @generated
	 */
	int LIST_BOX = 14;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_BOX__ELEMENTS = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_BOX___GET__CONTEXT = BOX___GET__CONTEXT;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_BOX___SET__OBJECT_CONTEXT = BOX___SET__OBJECT_CONTEXT;

	/**
	 * The number of operations of the '<em>List Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_BOX_OPERATION_COUNT = BOX_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Entries</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BOX__ENTRIES = BOX_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Map Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_BOX_FEATURE_COUNT = BOX_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.boxing.impl.StringToEObjectMapImpl <em>String To EObject Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.boxing.impl.StringToEObjectMapImpl
	 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getStringToEObjectMap()
	 * @generated
	 */
	int STRING_TO_EOBJECT_MAP = 16;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To EObject Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To EObject Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EOBJECT_MAP_OPERATION_COUNT = 0;

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
	 * Returns the meta object for data type '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List" typeParameters="T"
	 * @generated
	 */
	EDataType getList();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.core.ConverterContext <em>Converter Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Converter Context</em>'.
	 * @see org.nasdanika.core.ConverterContext
	 * @model instanceClass="org.nasdanika.core.ConverterContext"
	 * @generated
	 */
	EDataType getConverterContext();

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
	 * Returns the meta object for data type '{@link org.nasdanika.cdo.CDOViewContext <em>CDO View Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CDO View Context</em>'.
	 * @see org.nasdanika.cdo.CDOViewContext
	 * @model instanceClass="org.nasdanika.cdo.CDOViewContext"
	 * @generated
	 */
	EDataType getCDOViewContext();

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
	 * Returns the meta object for class '{@link org.nasdanika.cdo.boxing.ListBox <em>List Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Box</em>'.
	 * @see org.nasdanika.cdo.boxing.ListBox
	 * @generated
	 */
	EClass getListBox();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.cdo.boxing.ListBox#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.nasdanika.cdo.boxing.ListBox#getElements()
	 * @see #getListBox()
	 * @generated
	 */
	EReference getListBox_Elements();

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
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.boxing.MapBox#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Entries</em>'.
	 * @see org.nasdanika.cdo.boxing.MapBox#getEntries()
	 * @see #getMapBox()
	 * @generated
	 */
	EReference getMapBox_Entries();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To EObject Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To EObject Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true"
	 * @generated
	 */
	EClass getStringToEObjectMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEObjectMap()
	 * @generated
	 */
	EAttribute getStringToEObjectMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEObjectMap()
	 * @generated
	 */
	EReference getStringToEObjectMap_Value();

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
		 * The meta object literal for the '<em>List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getList()
		 * @generated
		 */
		EDataType LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '<em>Converter Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.core.ConverterContext
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getConverterContext()
		 * @generated
		 */
		EDataType CONVERTER_CONTEXT = eINSTANCE.getConverterContext();

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
		 * The meta object literal for the '<em>CDO View Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.CDOViewContext
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getCDOViewContext()
		 * @generated
		 */
		EDataType CDO_VIEW_CONTEXT = eINSTANCE.getCDOViewContext();

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
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.ListBoxImpl <em>List Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.ListBoxImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getListBox()
		 * @generated
		 */
		EClass LIST_BOX = eINSTANCE.getListBox();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_BOX__ELEMENTS = eINSTANCE.getListBox_Elements();

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
		 * The meta object literal for the '<em><b>Entries</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_BOX__ENTRIES = eINSTANCE.getMapBox_Entries();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.boxing.impl.StringToEObjectMapImpl <em>String To EObject Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.boxing.impl.StringToEObjectMapImpl
		 * @see org.nasdanika.cdo.boxing.impl.BoxingPackageImpl#getStringToEObjectMap()
		 * @generated
		 */
		EClass STRING_TO_EOBJECT_MAP = eINSTANCE.getStringToEObjectMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_EOBJECT_MAP__KEY = eINSTANCE.getStringToEObjectMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_EOBJECT_MAP__VALUE = eINSTANCE.getStringToEObjectMap_Value();

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

	}

} //BoxingPackage
