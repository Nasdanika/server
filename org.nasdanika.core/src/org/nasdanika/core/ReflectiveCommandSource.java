package org.nasdanika.core;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * Base class for classes which declare command methods.
 * @author Pavel
 *
 */
public abstract class ReflectiveCommandSource implements AutoCloseable {
	
	protected Map<String, InstanceMethodCommand<Context,Object>> commandMap = new HashMap<String, InstanceMethodCommand<Context,Object>>();
			
	protected ReflectiveCommandSource() throws Exception {
		this(null);
	}
	
	protected ReflectiveCommandSource(BundleContext context) throws Exception {
		if (context==null) {
			context = FrameworkUtil.getBundle(getClass()).getBundleContext();
		}
		for (Method m: getClass().getMethods()) {
			CommandMethod cma = m.getAnnotation(CommandMethod.class);
			if (cma!=null) {
				String cName = cma.value().trim().length()==0 ? m.getName() : cma.value();
				commandMap.put(cName, new InstanceMethodCommand<Context,Object>(this, new MethodCommand<Context,Object>(context, m)));
			}
		}
		commandMap = Collections.unmodifiableMap(commandMap);
	}

	@Override
	public void close() throws Exception {
		for (InstanceMethodCommand<Context, Object> imc: commandMap.values()) {
			imc.close();
		}
	}
	
	public Map<String, InstanceMethodCommand<Context, Object>> getCommandMap() {
		return commandMap;
	}

}
