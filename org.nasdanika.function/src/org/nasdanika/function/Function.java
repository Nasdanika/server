package org.nasdanika.function;

/**
 * Function encapsulates behavior to be executed at some later time.
 * @author Pavel Vlasov
 *
 */
public interface Function {
	
//	/**
//	 * Executes function.
//	 * @param args
//	 * @return
//	 * @throws Exception
//	 */
//	Object apply(Context context, Object... args) throws Exception;
	
	/**
	 * Maps arguments to parameters.
	 * @param map position is parameter index, value is argument index. Unused parameter indexes use unused argument
	 * indexes in sequence. E.g. map(3,3,0) would rearrange arguments [a,b,c,d,e,f] as [d,d,a,b,c,e,f]
	 */
	void map(int... map);
	
	/**
	 * Binds parameters to arguments. Can be invoked multiple times each time binding remaining parameters.
	 * If parameter is bound to a function that function will be invoked and then result of that invocation will
	 * be passed as a parameter to this function. Unbound parameters of the bound function are merged into this function 
	 * unbound parameters, e.g. if bindings are [1, f(x,y), 2, z], where x,y, and z are unbound parameters and f is a bound function,
	 * then effective function length would be 3 - x, y, and z. 
	 * @param bindings
	 */
	void bind(Object... bindings);
	
	/**
	 * Number of unbound parameters, including unbound parameters of functions bound to parameters.
	 * @return
	 */
	int length();
	
	/**
	 * Types of unbound parameters.
	 * @return
	 */
	Class<?>[] parameterTypes();

}
