/**
 */
package org.nasdanika.cdo.boxing;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.boxing.BoxingPackage
 * @generated
 */
public interface BoxingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BoxingFactory eINSTANCE = org.nasdanika.cdo.boxing.impl.BoxingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Big Decimal Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Big Decimal Box</em>'.
	 * @generated
	 */
	BigDecimalBox createBigDecimalBox();

	/**
	 * Returns a new object of class '<em>Big Integer Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Big Integer Box</em>'.
	 * @generated
	 */
	BigIntegerBox createBigIntegerBox();

	/**
	 * Returns a new object of class '<em>Boolean Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Box</em>'.
	 * @generated
	 */
	BooleanBox createBooleanBox();

	/**
	 * Returns a new object of class '<em>Byte Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Byte Box</em>'.
	 * @generated
	 */
	ByteBox createByteBox();

	/**
	 * Returns a new object of class '<em>Byte Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Byte Array Box</em>'.
	 * @generated
	 */
	ByteArrayBox createByteArrayBox();

	/**
	 * Returns a new object of class '<em>Character Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Character Box</em>'.
	 * @generated
	 */
	CharacterBox createCharacterBox();

	/**
	 * Returns a new object of class '<em>Date Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Date Box</em>'.
	 * @generated
	 */
	DateBox createDateBox();

	/**
	 * Returns a new object of class '<em>Double Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Box</em>'.
	 * @generated
	 */
	DoubleBox createDoubleBox();

	/**
	 * Returns a new object of class '<em>Float Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Float Box</em>'.
	 * @generated
	 */
	FloatBox createFloatBox();

	/**
	 * Returns a new object of class '<em>Integer Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Box</em>'.
	 * @generated
	 */
	IntegerBox createIntegerBox();

	/**
	 * Returns a new object of class '<em>Long Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Box</em>'.
	 * @generated
	 */
	LongBox createLongBox();

	/**
	 * Returns a new object of class '<em>Short Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Short Box</em>'.
	 * @generated
	 */
	ShortBox createShortBox();

	/**
	 * Returns a new object of class '<em>String Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Box</em>'.
	 * @generated
	 */
	StringBox createStringBox();

	/**
	 * Returns a new object of class '<em>Collection Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Box</em>'.
	 * @generated
	 */
	<T> CollectionBox<T> createCollectionBox();

	/**
	 * Returns a new object of class '<em>Map Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Box</em>'.
	 * @generated
	 */
	<K, V> MapBox<K, V> createMapBox();

	/**
	 * Returns a new object of class '<em>Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Entry</em>'.
	 * @generated
	 */
	MapEntry createMapEntry();

	/**
	 * Returns a new object of class '<em>Stream Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stream Box</em>'.
	 * @generated
	 */
	StreamBox createStreamBox();

	/**
	 * Returns a new object of class '<em>Reader Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reader Box</em>'.
	 * @generated
	 */
	ReaderBox createReaderBox();

	/**
	 * Returns a new object of class '<em>Serializable Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Serializable Box</em>'.
	 * @generated
	 */
	SerializableBox createSerializableBox();

	/**
	 * Returns a new object of class '<em>Reference Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Box</em>'.
	 * @generated
	 */
	ReferenceBox createReferenceBox();

	/**
	 * Returns a new object of class '<em>Null Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Box</em>'.
	 * @generated
	 */
	NullBox createNullBox();

	/**
	 * Returns a new object of class '<em>EClassifier Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClassifier Box</em>'.
	 * @generated
	 */
	EClassifierBox createEClassifierBox();

	/**
	 * Returns a new object of class '<em>Class Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Box</em>'.
	 * @generated
	 */
	<T> ClassBox<T> createClassBox();

	/**
	 * Returns a new object of class '<em>Object Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Box</em>'.
	 * @generated
	 */
	<T> ObjectBox<T> createObjectBox();

	/**
	 * Returns a new object of class '<em>Field Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Field Entry</em>'.
	 * @generated
	 */
	FieldEntry createFieldEntry();

	/**
	 * Returns a new object of class '<em>Char Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Char Array Box</em>'.
	 * @generated
	 */
	CharArrayBox createCharArrayBox();

	/**
	 * Returns a new object of class '<em>Double Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Array Box</em>'.
	 * @generated
	 */
	DoubleArrayBox createDoubleArrayBox();

	/**
	 * Returns a new object of class '<em>Float Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Float Array Box</em>'.
	 * @generated
	 */
	FloatArrayBox createFloatArrayBox();

	/**
	 * Returns a new object of class '<em>Int Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Array Box</em>'.
	 * @generated
	 */
	IntArrayBox createIntArrayBox();

	/**
	 * Returns a new object of class '<em>Long Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Array Box</em>'.
	 * @generated
	 */
	LongArrayBox createLongArrayBox();

	/**
	 * Returns a new object of class '<em>Object Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Array Box</em>'.
	 * @generated
	 */
	<T> ObjectArrayBox<T> createObjectArrayBox();

	/**
	 * Returns a new object of class '<em>Short Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Short Array Box</em>'.
	 * @generated
	 */
	ShortArrayBox createShortArrayBox();

	/**
	 * Returns a new object of class '<em>Json Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Json Array Box</em>'.
	 * @generated
	 */
	JsonArrayBox createJsonArrayBox();

	/**
	 * Returns a new object of class '<em>Json Object Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Json Object Box</em>'.
	 * @generated
	 */
	JsonObjectBox createJsonObjectBox();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BoxingPackage getBoxingPackage();

} //BoxingFactory
