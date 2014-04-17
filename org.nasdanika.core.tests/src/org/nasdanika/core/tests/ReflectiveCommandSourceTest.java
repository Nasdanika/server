package org.nasdanika.core.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.nasdanika.core.CommandMethod;
import org.nasdanika.core.Context;
import org.nasdanika.core.ReflectiveCommandSource;

public class ReflectiveCommandSourceTest {
	
	public static class ReflectiveCommandSourceTestImpl extends ReflectiveCommandSource {

		public ReflectiveCommandSourceTestImpl() throws Exception {
			super();
		}
		
		@CommandMethod
		public String testCommandMethod(Context context) {
			return "OK";
		}
		
	}

	@Test
	public void testReflectiveCommandSource() throws Exception {
		try (ReflectiveCommandSource cs = new ReflectiveCommandSourceTestImpl()) {
			assertEquals(1, cs.getCommandMap().size());
			assertTrue(cs.getCommandMap().containsKey("testCommandMethod"));
			assertEquals("OK",cs.getCommandMap().get("testCommandMethod").execute(null));
		}
	}

}
