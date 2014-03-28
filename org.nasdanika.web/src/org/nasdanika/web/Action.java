package org.nasdanika.web;

/**
 * Action is returned by Route.navigate() method.
 * @author Pavel
 *
 */
public interface Action {
	
	Action NOT_FOUND = new Action() {

		@Override
		public Object execute() throws Exception {
			return ProcessingError.NOT_FOUND;
		}
		
	};
	
	Action FORBIDDEN = new Action() {

		@Override
		public Object execute() throws Exception {
			return ProcessingError.FORBIDDEN;
		}
		
	};	
	
	Object execute() throws Exception;

}
