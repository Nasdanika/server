package org.nasdanika.core;

import java.lang.reflect.Method;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * Wraps command method into a command.
 * @author Pavel
 *
 * @param <C>
 * @param <R>
 */
public class InstanceMethodCommand<C extends Context, R> implements Command<C, Object, R> {
	
	protected Object target;
	private MethodCommand<C,R> methodCommand;

	public InstanceMethodCommand(Object target, String name) throws Exception {
		this(FrameworkUtil.getBundle(target.getClass()).getBundleContext(), target, name);
	}

	public InstanceMethodCommand(BundleContext context, Object target, String name) throws Exception {
		this.target = target;
		for (Method m: target.getClass().getMethods()) {
			CommandMethod cma = m.getAnnotation(CommandMethod.class);
			if (cma!=null) {
				String cName = cma.value().trim().length()==0 ? m.getName() : cma.value();
				if (cName.equals(name)) {
					this.methodCommand = new MethodCommand<C, R>(context, m);
					return;
				}
			}
		}
		throw new IllegalArgumentException("Command method '"+name+"' not found in "+target.getClass().getName());
	}
	
	public InstanceMethodCommand(Object target, MethodCommand<C,R> methodCommand) {
		this.target = target;
		this.methodCommand = methodCommand;
	}

	/**
	 * Injects service references, if any. Then invokes method and returns result. 
	 */
	@Override
	public R execute(C context, Object... args) throws Exception {
		return methodCommand.execute(context, target, args);
	}
	
	@Override
	public void close() throws Exception {
		methodCommand.close();
	}

	@Override
	public boolean canExecute() {
		return methodCommand.canExecute();
	}
	
	public Class<?>[] getParameterTypes() {
		return methodCommand.getParameterTypes();
	}
	
	public Class<R> getReturnType() {
		return methodCommand.getReturnType();
	}
	

}
