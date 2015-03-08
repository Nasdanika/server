package org.nasdanika.cdo.boxing.impl;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.cdo.boxing.BigDecimalBox;
import org.nasdanika.cdo.boxing.BigIntegerBox;
import org.nasdanika.cdo.boxing.BooleanBox;
import org.nasdanika.cdo.boxing.BoxingFactory;
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
import org.nasdanika.cdo.boxing.FloatArrayBox;
import org.nasdanika.cdo.boxing.FloatBox;
import org.nasdanika.cdo.boxing.IntArrayBox;
import org.nasdanika.cdo.boxing.IntegerBox;
import org.nasdanika.cdo.boxing.JsonArrayBox;
import org.nasdanika.cdo.boxing.JsonObjectBox;
import org.nasdanika.cdo.boxing.LongArrayBox;
import org.nasdanika.cdo.boxing.LongBox;
import org.nasdanika.cdo.boxing.MapBox;
import org.nasdanika.cdo.boxing.ObjectArrayBox;
import org.nasdanika.cdo.boxing.ObjectBox;
import org.nasdanika.cdo.boxing.ReaderBox;
import org.nasdanika.cdo.boxing.ShortArrayBox;
import org.nasdanika.cdo.boxing.ShortBox;
import org.nasdanika.cdo.boxing.StreamBox;
import org.nasdanika.cdo.boxing.StringBox;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;
import org.nasdanika.core.ConverterMethod;
import org.nasdanika.core.ReflectiveConverterProvider;

public class Converters extends ReflectiveConverterProvider {

	protected Converters() throws Exception {
		super();
	}

	@ConverterMethod
	BigDecimalBox box(BigDecimal value, Context context) {
		BigDecimalBox ret = BoxingFactory.eINSTANCE.createBigDecimalBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	BigDecimal unbox(BigDecimalBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	BigIntegerBox box(BigInteger value, Context context) {
		BigIntegerBox ret = BoxingFactory.eINSTANCE.createBigIntegerBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	BigInteger unbox(BigIntegerBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	BooleanBox box(Boolean value, Context context) {
		BooleanBox ret = BoxingFactory.eINSTANCE.createBooleanBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Boolean unbox(BooleanBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	ByteArrayBox box(byte[] value, Context context) {
		ByteArrayBox ret = BoxingFactory.eINSTANCE.createByteArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	byte[] unbox(ByteArrayBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	ByteBox box(Byte value, Context context) {
		ByteBox ret = BoxingFactory.eINSTANCE.createByteBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Byte unbox(ByteBox box, Context context) {
		return box.get(context);
	}

	// TODO - String to CDOObject and back through CDOID
	
	@ConverterMethod
	<T> ClassBox<T> box(Class<T> value, Context context) {
		ClassBox<T> ret = BoxingFactory.eINSTANCE.createClassBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	<T> Class<T> unbox(ClassBox<T> box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	CharacterBox box(Character value, Context context) {
		CharacterBox ret = BoxingFactory.eINSTANCE.createCharacterBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Character unbox(CharacterBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	<T> CollectionBox<T> box(Collection<T> value, ConverterContext context) {
		CollectionBox<T> ret = BoxingFactory.eINSTANCE.createCollectionBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	<T> Collection<T> unbox(CollectionBox<T> box, ConverterContext context) {
		return box.get(context);
	}

	@ConverterMethod
	DateBox box(Date value, Context context) {
		DateBox ret = BoxingFactory.eINSTANCE.createDateBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Date unbox(DateBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	DoubleBox box(Double value, Context context) {
		DoubleBox ret = BoxingFactory.eINSTANCE.createDoubleBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Double unbox(DoubleBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	EClassifierBox box(EClassifier value, Context context) {
		EClassifierBox ret = BoxingFactory.eINSTANCE.createEClassifierBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	EClassifier unbox(EClassifierBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	FloatBox box(Float value, Context context) {
		FloatBox ret = BoxingFactory.eINSTANCE.createFloatBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Float unbox(FloatBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	IntegerBox box(Integer value, Context context) {
		IntegerBox ret = BoxingFactory.eINSTANCE.createIntegerBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Integer unbox(IntegerBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	LongBox box(Long value, Context context) {
		LongBox ret = BoxingFactory.eINSTANCE.createLongBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Long unbox(LongBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	<K,V> MapBox<K,V> box(Map<K,V> value, ConverterContext context) {
		MapBox<K,V> ret = BoxingFactory.eINSTANCE.createMapBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	<K,V> Map<K,V> unbox(MapBox<K,V> box, ConverterContext context) {
		return box.get(context);
	}

	@ConverterMethod
	ReaderBox box(Reader value, Context context) {
		ReaderBox ret = BoxingFactory.eINSTANCE.createReaderBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Reader unbox(ReaderBox box, Context context) {
		return box.get(context);
	}

	/* Use custom serialization
	@ConverterMethod
	SerializableBox box(Serializable value, Context context) {
		SerializableBox ret = BoxingFactory.eINSTANCE.createSerializableBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Serializable unbox(SerializableBox box, Context context) {
		return box.get(context);
	}
	*/

	@ConverterMethod
	ShortBox box(Short value, Context context) {
		ShortBox ret = BoxingFactory.eINSTANCE.createShortBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	Short unbox(ShortBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	StreamBox box(InputStream value, Context context) {
		StreamBox ret = BoxingFactory.eINSTANCE.createStreamBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	InputStream unbox(StreamBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	StringBox box(String value, Context context) {
		StringBox ret = BoxingFactory.eINSTANCE.createStringBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	String unbox(StringBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	<T> ObjectBox<T> box(T value, ConverterContext context) {
		ObjectBox<T> ret = BoxingFactory.eINSTANCE.createObjectBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	<T> T unbox(ObjectBox<T> box, ConverterContext context) {
		return box.get(context);
	}

	@ConverterMethod
	JsonArrayBox box(JSONArray value, ConverterContext context) {
		JsonArrayBox ret = BoxingFactory.eINSTANCE.createJsonArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	JSONArray unbox(JsonArrayBox box, ConverterContext context) {
		return box.get(context);
	}

	@ConverterMethod
	JsonObjectBox box(JSONObject value, ConverterContext context) {
		JsonObjectBox ret = BoxingFactory.eINSTANCE.createJsonObjectBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	JSONObject unbox(JsonObjectBox box, ConverterContext context) {
		return box.get(context);
	}

	@ConverterMethod
	CharArrayBox box(char[] value, Context context) {
		CharArrayBox ret = BoxingFactory.eINSTANCE.createCharArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	char[] unbox(CharArrayBox box, Context context) {
		return (char[]) box.get(context);
	}

	@ConverterMethod
	DoubleArrayBox box(double[] value, Context context) {
		DoubleArrayBox ret = BoxingFactory.eINSTANCE.createDoubleArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	double[] unbox(DoubleArrayBox box, Context context) {
		return (double[]) box.get(context);
	}

	@ConverterMethod
	FloatArrayBox box(float[] value, Context context) {
		FloatArrayBox ret = BoxingFactory.eINSTANCE.createFloatArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	float[] unbox(FloatArrayBox box, Context context) {
		return (float[]) box.get(context);
	}

	@ConverterMethod
	IntArrayBox box(int[] value, Context context) {
		IntArrayBox ret = BoxingFactory.eINSTANCE.createIntArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	int[] unbox(IntArrayBox box, Context context) {
		return (int[]) box.get(context);
	}

	@ConverterMethod
	LongArrayBox box(long[] value, Context context) {
		LongArrayBox ret = BoxingFactory.eINSTANCE.createLongArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	long[] unbox(LongArrayBox box, Context context) {
		return (long[]) box.get(context);
	}

	@ConverterMethod
	<T> ObjectArrayBox<T> box(T[] value, ConverterContext context) {
		ObjectArrayBox<T> ret = BoxingFactory.eINSTANCE.createObjectArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	@ConverterMethod
	<T> T[] unbox(ObjectArrayBox<T> box, ConverterContext context) {
		return (T[]) box.get(context);
	}

	@ConverterMethod
	ShortArrayBox box(short[] value, Context context) {
		ShortArrayBox ret = BoxingFactory.eINSTANCE.createShortArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	short[] unbox(ShortArrayBox box, Context context) {
		return (short[]) box.get(context);
	}

}
