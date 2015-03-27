/**
 */
package org.nasdanika.cdo.boxing.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.boxing.BigDecimalBox;
import org.nasdanika.cdo.boxing.BigIntegerBox;
import org.nasdanika.cdo.boxing.BooleanBox;
import org.nasdanika.cdo.boxing.Box;
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

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.boxing.BoxingPackage
 * @generated
 */
public class BoxingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BoxingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoxingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BoxingPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoxingSwitch<Adapter> modelSwitch =
		new BoxingSwitch<Adapter>() {
			@Override
			public <T, C extends Context> Adapter caseBox(Box<T, C> object) {
				return createBoxAdapter();
			}
			@Override
			public Adapter caseBigDecimalBox(BigDecimalBox object) {
				return createBigDecimalBoxAdapter();
			}
			@Override
			public Adapter caseBigIntegerBox(BigIntegerBox object) {
				return createBigIntegerBoxAdapter();
			}
			@Override
			public Adapter caseBooleanBox(BooleanBox object) {
				return createBooleanBoxAdapter();
			}
			@Override
			public Adapter caseByteBox(ByteBox object) {
				return createByteBoxAdapter();
			}
			@Override
			public Adapter caseByteArrayBox(ByteArrayBox object) {
				return createByteArrayBoxAdapter();
			}
			@Override
			public Adapter caseCharacterBox(CharacterBox object) {
				return createCharacterBoxAdapter();
			}
			@Override
			public Adapter caseDateBox(DateBox object) {
				return createDateBoxAdapter();
			}
			@Override
			public Adapter caseDoubleBox(DoubleBox object) {
				return createDoubleBoxAdapter();
			}
			@Override
			public Adapter caseFloatBox(FloatBox object) {
				return createFloatBoxAdapter();
			}
			@Override
			public Adapter caseIntegerBox(IntegerBox object) {
				return createIntegerBoxAdapter();
			}
			@Override
			public Adapter caseLongBox(LongBox object) {
				return createLongBoxAdapter();
			}
			@Override
			public Adapter caseShortBox(ShortBox object) {
				return createShortBoxAdapter();
			}
			@Override
			public Adapter caseStringBox(StringBox object) {
				return createStringBoxAdapter();
			}
			@Override
			public <T> Adapter caseCollectionBox(CollectionBox<T> object) {
				return createCollectionBoxAdapter();
			}
			@Override
			public <K, V> Adapter caseMapBox(MapBox<K, V> object) {
				return createMapBoxAdapter();
			}
			@Override
			public Adapter caseMapEntry(MapEntry object) {
				return createMapEntryAdapter();
			}
			@Override
			public Adapter caseStreamBox(StreamBox object) {
				return createStreamBoxAdapter();
			}
			@Override
			public Adapter caseReaderBox(ReaderBox object) {
				return createReaderBoxAdapter();
			}
			@Override
			public Adapter caseSerializableBox(SerializableBox object) {
				return createSerializableBoxAdapter();
			}
			@Override
			public Adapter caseReferenceBox(ReferenceBox object) {
				return createReferenceBoxAdapter();
			}
			@Override
			public Adapter caseNullBox(NullBox object) {
				return createNullBoxAdapter();
			}
			@Override
			public Adapter caseEClassifierBox(EClassifierBox object) {
				return createEClassifierBoxAdapter();
			}
			@Override
			public <T> Adapter caseClassBox(ClassBox<T> object) {
				return createClassBoxAdapter();
			}
			@Override
			public <T> Adapter caseObjectBox(ObjectBox<T> object) {
				return createObjectBoxAdapter();
			}
			@Override
			public Adapter caseFieldEntry(FieldEntry object) {
				return createFieldEntryAdapter();
			}
			@Override
			public Adapter caseCharArrayBox(CharArrayBox object) {
				return createCharArrayBoxAdapter();
			}
			@Override
			public Adapter caseDoubleArrayBox(DoubleArrayBox object) {
				return createDoubleArrayBoxAdapter();
			}
			@Override
			public Adapter caseFloatArrayBox(FloatArrayBox object) {
				return createFloatArrayBoxAdapter();
			}
			@Override
			public Adapter caseIntArrayBox(IntArrayBox object) {
				return createIntArrayBoxAdapter();
			}
			@Override
			public Adapter caseLongArrayBox(LongArrayBox object) {
				return createLongArrayBoxAdapter();
			}
			@Override
			public <T> Adapter caseObjectArrayBox(ObjectArrayBox<T> object) {
				return createObjectArrayBoxAdapter();
			}
			@Override
			public Adapter caseShortArrayBox(ShortArrayBox object) {
				return createShortArrayBoxAdapter();
			}
			@Override
			public Adapter caseJsonArrayBox(JsonArrayBox object) {
				return createJsonArrayBoxAdapter();
			}
			@Override
			public Adapter caseJsonObjectBox(JsonObjectBox object) {
				return createJsonObjectBoxAdapter();
			}
			@Override
			public Adapter caseStringObjectMapEntry(Map.Entry<String, EObject> object) {
				return createStringObjectMapEntryAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.Box <em>Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.Box
	 * @generated
	 */
	public Adapter createBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.BigDecimalBox <em>Big Decimal Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.BigDecimalBox
	 * @generated
	 */
	public Adapter createBigDecimalBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.BigIntegerBox <em>Big Integer Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.BigIntegerBox
	 * @generated
	 */
	public Adapter createBigIntegerBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.BooleanBox <em>Boolean Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.BooleanBox
	 * @generated
	 */
	public Adapter createBooleanBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.ByteBox <em>Byte Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.ByteBox
	 * @generated
	 */
	public Adapter createByteBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.ByteArrayBox <em>Byte Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.ByteArrayBox
	 * @generated
	 */
	public Adapter createByteArrayBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.CharacterBox <em>Character Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.CharacterBox
	 * @generated
	 */
	public Adapter createCharacterBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.DateBox <em>Date Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.DateBox
	 * @generated
	 */
	public Adapter createDateBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.DoubleBox <em>Double Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.DoubleBox
	 * @generated
	 */
	public Adapter createDoubleBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.FloatBox <em>Float Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.FloatBox
	 * @generated
	 */
	public Adapter createFloatBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.IntegerBox <em>Integer Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.IntegerBox
	 * @generated
	 */
	public Adapter createIntegerBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.LongBox <em>Long Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.LongBox
	 * @generated
	 */
	public Adapter createLongBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.ShortBox <em>Short Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.ShortBox
	 * @generated
	 */
	public Adapter createShortBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.StringBox <em>String Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.StringBox
	 * @generated
	 */
	public Adapter createStringBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.CollectionBox <em>Collection Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.CollectionBox
	 * @generated
	 */
	public Adapter createCollectionBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.MapBox <em>Map Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.MapBox
	 * @generated
	 */
	public Adapter createMapBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.MapEntry <em>Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.MapEntry
	 * @generated
	 */
	public Adapter createMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.StreamBox <em>Stream Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.StreamBox
	 * @generated
	 */
	public Adapter createStreamBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.ReaderBox <em>Reader Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.ReaderBox
	 * @generated
	 */
	public Adapter createReaderBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.SerializableBox <em>Serializable Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.SerializableBox
	 * @generated
	 */
	public Adapter createSerializableBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.ReferenceBox <em>Reference Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.ReferenceBox
	 * @generated
	 */
	public Adapter createReferenceBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.NullBox <em>Null Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.NullBox
	 * @generated
	 */
	public Adapter createNullBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.EClassifierBox <em>EClassifier Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.EClassifierBox
	 * @generated
	 */
	public Adapter createEClassifierBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.ClassBox <em>Class Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.ClassBox
	 * @generated
	 */
	public Adapter createClassBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.ObjectBox <em>Object Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.ObjectBox
	 * @generated
	 */
	public Adapter createObjectBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.FieldEntry <em>Field Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.FieldEntry
	 * @generated
	 */
	public Adapter createFieldEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.CharArrayBox <em>Char Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.CharArrayBox
	 * @generated
	 */
	public Adapter createCharArrayBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.DoubleArrayBox <em>Double Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.DoubleArrayBox
	 * @generated
	 */
	public Adapter createDoubleArrayBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.FloatArrayBox <em>Float Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.FloatArrayBox
	 * @generated
	 */
	public Adapter createFloatArrayBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.IntArrayBox <em>Int Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.IntArrayBox
	 * @generated
	 */
	public Adapter createIntArrayBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.LongArrayBox <em>Long Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.LongArrayBox
	 * @generated
	 */
	public Adapter createLongArrayBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.ObjectArrayBox <em>Object Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.ObjectArrayBox
	 * @generated
	 */
	public Adapter createObjectArrayBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.ShortArrayBox <em>Short Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.ShortArrayBox
	 * @generated
	 */
	public Adapter createShortArrayBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.JsonArrayBox <em>Json Array Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.JsonArrayBox
	 * @generated
	 */
	public Adapter createJsonArrayBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.cdo.boxing.JsonObjectBox <em>Json Object Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.cdo.boxing.JsonObjectBox
	 * @generated
	 */
	public Adapter createJsonObjectBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String Object Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringObjectMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //BoxingAdapterFactory
