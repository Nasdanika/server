package org.nasdanika.html;

public interface Modal extends UIElement<Modal> {
	
	interface Options {

		/**
		 * Includes a modal-backdrop element. Default - true. 
		 * @return
		 */
		Options backdrop(boolean backdrop);

		/**
		 * Call this method for a backdrop which doesn't close the modal on click.
		 * @return
		 */
		Options staticBackdrop();
		
		/**
		 * Closes the modal when escape key is pressed. Default - true.
		 * @param keyboard
		 * @return
		 */
		Options keyboard(boolean keyboard);
		
		/**
		 * Shows the modal when initialized. Default - true.
		 */
		Options show(boolean show);
		
		/**
		 * If a remote URL is provided, content will be loaded one time via jQuery's load method 
		 * and injected into the .modal-content div. If you're using the data-api, you may alternatively 
		 * use the href attribute to specify the remote source. 
		 */
		Options remote(Object path);
	}
	
	Options options();
	
	Modal title(Object... content);
	
	Modal body(Object... content);
	
	Modal footer(Object... content);
	
	Modal large();
	
	Modal small();
	
	/**
	 * Configures a button to toggle this dialog.
	 * @param button
	 * @return
	 */
	Button bind(Button button);
}
