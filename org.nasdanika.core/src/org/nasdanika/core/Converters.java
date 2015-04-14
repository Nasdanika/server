package org.nasdanika.core;


public class Converters extends ReflectiveConverterProvider {

	public Converters() throws Exception {
		super();
	}

	@ConverterMethod
	public String toString(Object value, Context context) {
		return String.valueOf(value);
	}	

}
