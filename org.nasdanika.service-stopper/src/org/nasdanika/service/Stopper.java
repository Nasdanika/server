package org.nasdanika.service;

import java.util.Arrays;

/**
 * A helper class for notifying other classes to stop by setting a system property to set to 'true'.  
 * @author Pavel
 *
 */
public class Stopper {

	public static void main(String[] args) {
		System.out.println("[Service Stopper] Invoked with arguments: "+Arrays.toString(args));
		System.setProperty(args[0], "true");
	}

}
