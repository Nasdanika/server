/**
 */
package org.nasdanika.cdo.boxing.util;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.nasdanika.cdo.boxing.*;
import org.nasdanika.core.Context;

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
 * @see org.nasdanika.cdo.boxing.BoxingPackage
 * @generated
 */
public class BoxingSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BoxingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoxingSwitch() {
		if (modelPackage == null) {
			modelPackage = BoxingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case BoxingPackage.BOX: {
				Box<?, ?> box = (Box<?, ?>)theEObject;
				T1 result = caseBox(box);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.BIG_DECIMAL_BOX: {
				BigDecimalBox bigDecimalBox = (BigDecimalBox)theEObject;
				T1 result = caseBigDecimalBox(bigDecimalBox);
				if (result == null) result = caseBox(bigDecimalBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.BIG_INTEGER_BOX: {
				BigIntegerBox bigIntegerBox = (BigIntegerBox)theEObject;
				T1 result = caseBigIntegerBox(bigIntegerBox);
				if (result == null) result = caseBox(bigIntegerBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.BOOLEAN_BOX: {
				BooleanBox booleanBox = (BooleanBox)theEObject;
				T1 result = caseBooleanBox(booleanBox);
				if (result == null) result = caseBox(booleanBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.BYTE_BOX: {
				ByteBox byteBox = (ByteBox)theEObject;
				T1 result = caseByteBox(byteBox);
				if (result == null) result = caseBox(byteBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.BYTE_ARRAY_BOX: {
				ByteArrayBox byteArrayBox = (ByteArrayBox)theEObject;
				T1 result = caseByteArrayBox(byteArrayBox);
				if (result == null) result = caseBox(byteArrayBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.CHARACTER_BOX: {
				CharacterBox characterBox = (CharacterBox)theEObject;
				T1 result = caseCharacterBox(characterBox);
				if (result == null) result = caseBox(characterBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.DATE_BOX: {
				DateBox dateBox = (DateBox)theEObject;
				T1 result = caseDateBox(dateBox);
				if (result == null) result = caseBox(dateBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.DOUBLE_BOX: {
				DoubleBox doubleBox = (DoubleBox)theEObject;
				T1 result = caseDoubleBox(doubleBox);
				if (result == null) result = caseBox(doubleBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.FLOAT_BOX: {
				FloatBox floatBox = (FloatBox)theEObject;
				T1 result = caseFloatBox(floatBox);
				if (result == null) result = caseBox(floatBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.INTEGER_BOX: {
				IntegerBox integerBox = (IntegerBox)theEObject;
				T1 result = caseIntegerBox(integerBox);
				if (result == null) result = caseBox(integerBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.LONG_BOX: {
				LongBox longBox = (LongBox)theEObject;
				T1 result = caseLongBox(longBox);
				if (result == null) result = caseBox(longBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.SHORT_BOX: {
				ShortBox shortBox = (ShortBox)theEObject;
				T1 result = caseShortBox(shortBox);
				if (result == null) result = caseBox(shortBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.STRING_BOX: {
				StringBox stringBox = (StringBox)theEObject;
				T1 result = caseStringBox(stringBox);
				if (result == null) result = caseBox(stringBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.COLLECTION_BOX: {
				CollectionBox<?> collectionBox = (CollectionBox<?>)theEObject;
				T1 result = caseCollectionBox(collectionBox);
				if (result == null) result = caseBox(collectionBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.MAP_BOX: {
				MapBox<?, ?> mapBox = (MapBox<?, ?>)theEObject;
				T1 result = caseMapBox(mapBox);
				if (result == null) result = caseBox(mapBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.MAP_ENTRY: {
				MapEntry mapEntry = (MapEntry)theEObject;
				T1 result = caseMapEntry(mapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.STREAM_BOX: {
				StreamBox streamBox = (StreamBox)theEObject;
				T1 result = caseStreamBox(streamBox);
				if (result == null) result = caseBox(streamBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.READER_BOX: {
				ReaderBox readerBox = (ReaderBox)theEObject;
				T1 result = caseReaderBox(readerBox);
				if (result == null) result = caseBox(readerBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.SERIALIZABLE_BOX: {
				SerializableBox serializableBox = (SerializableBox)theEObject;
				T1 result = caseSerializableBox(serializableBox);
				if (result == null) result = caseBox(serializableBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.REFERENCE_BOX: {
				ReferenceBox referenceBox = (ReferenceBox)theEObject;
				T1 result = caseReferenceBox(referenceBox);
				if (result == null) result = caseBox(referenceBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.NULL_BOX: {
				NullBox nullBox = (NullBox)theEObject;
				T1 result = caseNullBox(nullBox);
				if (result == null) result = caseBox(nullBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.ECLASSIFIER_BOX: {
				EClassifierBox eClassifierBox = (EClassifierBox)theEObject;
				T1 result = caseEClassifierBox(eClassifierBox);
				if (result == null) result = caseBox(eClassifierBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.CLASS_BOX: {
				ClassBox<?> classBox = (ClassBox<?>)theEObject;
				T1 result = caseClassBox(classBox);
				if (result == null) result = caseBox(classBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.OBJECT_BOX: {
				ObjectBox<?> objectBox = (ObjectBox<?>)theEObject;
				T1 result = caseObjectBox(objectBox);
				if (result == null) result = caseBox(objectBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.FIELD_ENTRY: {
				FieldEntry fieldEntry = (FieldEntry)theEObject;
				T1 result = caseFieldEntry(fieldEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.CHAR_ARRAY_BOX: {
				CharArrayBox charArrayBox = (CharArrayBox)theEObject;
				T1 result = caseCharArrayBox(charArrayBox);
				if (result == null) result = caseBox(charArrayBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.DOUBLE_ARRAY_BOX: {
				DoubleArrayBox doubleArrayBox = (DoubleArrayBox)theEObject;
				T1 result = caseDoubleArrayBox(doubleArrayBox);
				if (result == null) result = caseBox(doubleArrayBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.FLOAT_ARRAY_BOX: {
				FloatArrayBox floatArrayBox = (FloatArrayBox)theEObject;
				T1 result = caseFloatArrayBox(floatArrayBox);
				if (result == null) result = caseBox(floatArrayBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.INT_ARRAY_BOX: {
				IntArrayBox intArrayBox = (IntArrayBox)theEObject;
				T1 result = caseIntArrayBox(intArrayBox);
				if (result == null) result = caseBox(intArrayBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.LONG_ARRAY_BOX: {
				LongArrayBox longArrayBox = (LongArrayBox)theEObject;
				T1 result = caseLongArrayBox(longArrayBox);
				if (result == null) result = caseBox(longArrayBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.OBJECT_ARRAY_BOX: {
				ObjectArrayBox<?> objectArrayBox = (ObjectArrayBox<?>)theEObject;
				T1 result = caseObjectArrayBox(objectArrayBox);
				if (result == null) result = caseBox(objectArrayBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.SHORT_ARRAY_BOX: {
				ShortArrayBox shortArrayBox = (ShortArrayBox)theEObject;
				T1 result = caseShortArrayBox(shortArrayBox);
				if (result == null) result = caseBox(shortArrayBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.JSON_ARRAY_BOX: {
				JsonArrayBox jsonArrayBox = (JsonArrayBox)theEObject;
				T1 result = caseJsonArrayBox(jsonArrayBox);
				if (result == null) result = caseBox(jsonArrayBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.JSON_OBJECT_BOX: {
				JsonObjectBox jsonObjectBox = (JsonObjectBox)theEObject;
				T1 result = caseJsonObjectBox(jsonObjectBox);
				if (result == null) result = caseBox(jsonObjectBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BoxingPackage.STRING_OBJECT_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, EObject> stringObjectMapEntry = (Map.Entry<String, EObject>)theEObject;
				T1 result = caseStringObjectMapEntry(stringObjectMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T, C extends Context> T1 caseBox(Box<T, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Big Decimal Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Big Decimal Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBigDecimalBox(BigDecimalBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Big Integer Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Big Integer Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBigIntegerBox(BigIntegerBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBooleanBox(BooleanBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Byte Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Byte Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseByteBox(ByteBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Byte Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Byte Array Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseByteArrayBox(ByteArrayBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Character Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Character Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCharacterBox(CharacterBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Date Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Date Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDateBox(DateBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDoubleBox(DoubleBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFloatBox(FloatBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntegerBox(IntegerBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLongBox(LongBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Short Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Short Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseShortBox(ShortBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringBox(StringBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseCollectionBox(CollectionBox<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <K, V> T1 caseMapBox(MapBox<K, V> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMapEntry(MapEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stream Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stream Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStreamBox(StreamBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reader Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reader Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReaderBox(ReaderBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Serializable Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Serializable Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSerializableBox(SerializableBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReferenceBox(ReferenceBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNullBox(NullBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClassifier Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClassifier Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEClassifierBox(EClassifierBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseClassBox(ClassBox<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseObjectBox(ObjectBox<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFieldEntry(FieldEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Char Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Char Array Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCharArrayBox(CharArrayBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Array Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDoubleArrayBox(DoubleArrayBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Array Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFloatArrayBox(FloatArrayBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Array Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntArrayBox(IntArrayBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Array Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLongArrayBox(LongArrayBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Array Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseObjectArrayBox(ObjectArrayBox<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Short Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Short Array Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseShortArrayBox(ShortArrayBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Json Array Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Json Array Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseJsonArrayBox(JsonArrayBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Json Object Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Json Object Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseJsonObjectBox(JsonObjectBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Object Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Object Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringObjectMapEntry(Map.Entry<String, EObject> object) {
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

} //BoxingSwitch
