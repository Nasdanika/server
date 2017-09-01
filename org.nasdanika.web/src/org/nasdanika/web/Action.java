package org.nasdanika.web;

/**
 * Action is returned by Route.navigate() method.
 * @author Pavel
 *
 */
public interface Action extends AutoCloseable {
	
	Action NOP = new Action() {

		@Override
		public Object execute() throws Exception {
			return null;
		}

		@Override
		public void close() throws Exception {
			// NOP			
		}
		
	};
	
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
	
	Action SERVICE_UNAVAILABLE = new Action() {

		@Override
		public Object execute() throws Exception {
			return ProcessingError.SERVICE_UNAVAILABLE;
		}

		@Override
		public void close() throws Exception {
			// NOP			
		}
		
	};	
	
	Action UNAUTHORIZED = new Action() {

		@Override
		public Object execute() throws Exception {
			return ProcessingError.UNAUTHORIZED;
		}

		@Override
		public void close() throws Exception {
			// NOP			
		}
		
	};		
		
	Object execute() throws Exception;

}
