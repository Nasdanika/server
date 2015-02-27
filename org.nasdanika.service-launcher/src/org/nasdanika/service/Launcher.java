package org.nasdanika.service;

import java.util.Arrays;

/**
 * A helper class for wrapping other classes with "main" method into Windows services with Apache procrun.
 * This class expects to be started with "start" argument followed by the class name and arguments to pass
 * to the target main() method.
 * It is stopped by "stop" argument followed by the name of a system property to set to 'true' to notify the
 * service application to initiate shutdown.  
 * @author Pavel
 *
 */
public class Launcher {

	public static void main(String[] args) {
		System.out.println("[Service Launcher] Invoked with arguments: "+Arrays.toString(args));
		try {
			if ("start".equals(args[0])) {
				String[] newArgs = args.length>2 ? new String[args.length-2] : new String[] {};
				if (args.length>2) {
					System.arraycopy(args, 2, newArgs, 0, newArgs.length);
				}
				Class.forName(args[1]).getMethod("main", String[].class).invoke(null, (Object) newArgs);
			} else if ("stop".equals(args[0])) {
				System.setProperty(args[1], "true");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} 
	}

}
