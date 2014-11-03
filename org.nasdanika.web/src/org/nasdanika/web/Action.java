package org.nasdanika.web;

/**
 * Action is returned by Route.navigate() method.
 * @author Pavel
 *
 */
public interface Action extends AutoCloseable {
	
	Action NOT_FOUND = new Action() {

		@Override
		public Object execute() throws Exception {
			return ProcessingError.NOT_FOUND;
		}

		@Override
		public void close() throws Exception {
			// NOP			
		}
		
	};
	
	Action BAD_REQUEST = new Action() {

		@Override
		public Object execute() throws Exception {
			return ProcessingError.BAD_REQUEST;
		}

		@Override
		public void close() throws Exception {
			// NOP			
		}
		
	};
	
	Action FORBIDDEN = new Action() {

		@Override
		public Object execute() throws Exception {
			return ProcessingError.FORBIDDEN;
		}

		@Override
		public void close() throws Exception {
			// NOP			
		}
		
	};	
	
	Action INTERNAL_SERVER_ERROR = new Action() {

		@Override
		public Object execute() throws Exception {
			return ProcessingError.INTERNAL_SERVER_ERROR;
		}

		@Override
		public void close() throws Exception {
			// NOP			
		}
		
	};	
	
	Object execute() throws Exception;

}
