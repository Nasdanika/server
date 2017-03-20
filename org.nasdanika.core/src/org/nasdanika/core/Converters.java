package org.nasdanika.core;

import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

public class Converters extends ReflectiveConverterProvider {

	public Converters() throws Exception {
		super();
	}
	
	@ConverterMethod
	public String convert(URL value, Context context) {
		return CoreUtil.stringify(value);
	}	

	@ConverterMethod
	public String convert(InputStream value, Context context) {
		return CoreUtil.stringify(value);
	}	

	@ConverterMethod
	public String convert(Reader value, Context context) {
		return CoreUtil.stringify(value);
	}	

	@ConverterMethod
	public String toString(Object value, Context context) {
		return String.valueOf(value);
	}	

}
