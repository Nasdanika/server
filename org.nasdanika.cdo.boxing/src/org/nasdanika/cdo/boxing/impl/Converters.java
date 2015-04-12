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
import org.nasdanika.core.ConverterMethod;
import org.nasdanika.core.ReflectiveConverterProvider;

public class Converters extends ReflectiveConverterProvider {

	public Converters() throws Exception {
		super();
	}

	@ConverterMethod
	public BigDecimalBox box(BigDecimal value, Context context) {
		BigDecimalBox ret = BoxingFactory.eINSTANCE.createBigDecimalBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public BigDecimal unbox(BigDecimalBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public BigIntegerBox box(BigInteger value, Context context) {
		BigIntegerBox ret = BoxingFactory.eINSTANCE.createBigIntegerBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public BigInteger unbox(BigIntegerBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public BooleanBox box(Boolean value, Context context) {
		BooleanBox ret = BoxingFactory.eINSTANCE.createBooleanBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Boolean unbox(BooleanBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public ByteArrayBox box(byte[] value, Context context) {
		ByteArrayBox ret = BoxingFactory.eINSTANCE.createByteArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public byte[] unbox(ByteArrayBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public ByteBox box(Byte value, Context context) {
		ByteBox ret = BoxingFactory.eINSTANCE.createByteBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Byte unbox(ByteBox box, Context context) {
		return box.get(context);
	}

	// TODO - String to CDOObject and back through CDOID
	
	@ConverterMethod
	public <T> ClassBox<T> box(Class<T> value, Context context) {
		ClassBox<T> ret = BoxingFactory.eINSTANCE.createClassBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public <T> Class<T> unbox(ClassBox<T> box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public CharacterBox box(Character value, Context context) {
		CharacterBox ret = BoxingFactory.eINSTANCE.createCharacterBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Character unbox(CharacterBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public <T> CollectionBox<T> box(Collection<T> value, Context context) {
		CollectionBox<T> ret = BoxingFactory.eINSTANCE.createCollectionBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public <T> Collection<T> unbox(CollectionBox<T> box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public DateBox box(Date value, Context context) {
		DateBox ret = BoxingFactory.eINSTANCE.createDateBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Date unbox(DateBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public DoubleBox box(Double value, Context context) {
		DoubleBox ret = BoxingFactory.eINSTANCE.createDoubleBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Double unbox(DoubleBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public EClassifierBox box(EClassifier value, Context context) {
		EClassifierBox ret = BoxingFactory.eINSTANCE.createEClassifierBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public EClassifier unbox(EClassifierBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public FloatBox box(Float value, Context context) {
		FloatBox ret = BoxingFactory.eINSTANCE.createFloatBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Float unbox(FloatBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public IntegerBox box(Integer value, Context context) {
		IntegerBox ret = BoxingFactory.eINSTANCE.createIntegerBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Integer unbox(IntegerBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public LongBox box(Long value, Context context) {
		LongBox ret = BoxingFactory.eINSTANCE.createLongBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Long unbox(LongBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public <K,V> MapBox<K,V> box(Map<K,V> value, Context context) {
		MapBox<K,V> ret = BoxingFactory.eINSTANCE.createMapBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public <K,V> Map<K,V> unbox(MapBox<K,V> box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public ReaderBox box(Reader value, Context context) {
		ReaderBox ret = BoxingFactory.eINSTANCE.createReaderBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Reader unbox(ReaderBox box, Context context) {
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
	public ShortBox box(Short value, Context context) {
		ShortBox ret = BoxingFactory.eINSTANCE.createShortBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public Short unbox(ShortBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public StreamBox box(InputStream value, Context context) {
		StreamBox ret = BoxingFactory.eINSTANCE.createStreamBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public InputStream unbox(StreamBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public StringBox box(String value, Context context) {
		StringBox ret = BoxingFactory.eINSTANCE.createStringBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public String unbox(StringBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public <T> ObjectBox<T> box(T value, Context context) {
		ObjectBox<T> ret = BoxingFactory.eINSTANCE.createObjectBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public <T> T unbox(ObjectBox<T> box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public JsonArrayBox box(JSONArray value, Context context) {
		JsonArrayBox ret = BoxingFactory.eINSTANCE.createJsonArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public JSONArray unbox(JsonArrayBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public JsonObjectBox box(JSONObject value, Context context) {
		JsonObjectBox ret = BoxingFactory.eINSTANCE.createJsonObjectBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public JSONObject unbox(JsonObjectBox box, Context context) {
		return box.get(context);
	}

	@ConverterMethod
	public CharArrayBox box(char[] value, Context context) {
		CharArrayBox ret = BoxingFactory.eINSTANCE.createCharArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public char[] unbox(CharArrayBox box, Context context) {
		return (char[]) box.get(context);
	}

	@ConverterMethod
	public DoubleArrayBox box(double[] value, Context context) {
		DoubleArrayBox ret = BoxingFactory.eINSTANCE.createDoubleArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public double[] unbox(DoubleArrayBox box, Context context) {
		return (double[]) box.get(context);
	}

	@ConverterMethod
	public FloatArrayBox box(float[] value, Context context) {
		FloatArrayBox ret = BoxingFactory.eINSTANCE.createFloatArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public float[] unbox(FloatArrayBox box, Context context) {
		return (float[]) box.get(context);
	}

	@ConverterMethod
	public IntArrayBox box(int[] value, Context context) {
		IntArrayBox ret = BoxingFactory.eINSTANCE.createIntArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public int[] unbox(IntArrayBox box, Context context) {
		return (int[]) box.get(context);
	}

	@ConverterMethod
	public LongArrayBox box(long[] value, Context context) {
		LongArrayBox ret = BoxingFactory.eINSTANCE.createLongArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public long[] unbox(LongArrayBox box, Context context) {
		return (long[]) box.get(context);
	}

	@ConverterMethod
	public <T> ObjectArrayBox<T> box(T[] value, Context context) {
		ObjectArrayBox<T> ret = BoxingFactory.eINSTANCE.createObjectArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	@ConverterMethod
	public <T> T[] unbox(ObjectArrayBox<T> box, Context context) {
		return (T[]) box.get(context);
	}

	@ConverterMethod
	public ShortArrayBox box(short[] value, Context context) {
		ShortArrayBox ret = BoxingFactory.eINSTANCE.createShortArrayBox();
		ret.set(value, context);
		return ret;
	}
	
	@ConverterMethod
	public short[] unbox(ShortArrayBox box, Context context) {
		return (short[]) box.get(context);
	}

}
