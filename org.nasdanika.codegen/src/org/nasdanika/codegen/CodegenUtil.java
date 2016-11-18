package org.nasdanika.codegen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodegenUtil {
	
	private CodegenUtil() {
		// Utility class.
	}
		
	private static final Pattern EXPANDER_PATTERN = Pattern.compile("\\{\\{(.+?)\\}\\}");	
	
	/**
	 * Expands tokens in the form of <code>{{token name}}</code> to their values.
	 * If a token is not found expansion is not processed.
	 * @param input
	 * @param env
	 * @return
	 */
	public static String interpolate(String input, Context context) {
		if (context == null || input == null) {
			return input;
		}
		Matcher matcher = EXPANDER_PATTERN.matcher(input);
		StringBuilder output = new StringBuilder();
		int i = 0;
		while (matcher.find()) {
		    String token = matcher.group();
			Object replacement = context.get(token.substring(2, token.length()-2));
		    if (replacement != null) {
			    output.append(input.substring(i, matcher.start())).append(replacement);			    
			    i = matcher.end();
		    }
		}
		output.append(input.substring(i, input.length()));
		return output.toString();
	}
	
	/**
	 * Builds a context by traversing object's containment hierarchy from the top, e.g. from WorkspaceRoot to Project, to ...
	 * @param parent
	 * @param withContainer
	 * @return
	 * @throws Exception
	 */
	static Context hierarchyContext(Generator<?> generator, Context parent) throws Exception {
		return generator.eContainer() instanceof Generator ? hierarchyContext(((Generator<?>) generator.eContainer()), parent) : generator.createContext(parent);		
	}

	

}
