/**
 * Name: Thomas Scully
 * Date: 11/2/14 
 * Section: D
 * Homework 3
 */
package tps9tb.cs3330.homework3;

public class CreatureResponse {
	private String response;
	private boolean validAction;
	
	/**
	 * The constructor for human response 
	 *  
	 * @param response The response 
	 * @param validAction Boolean if the action is valid or not 
	 */
	public CreatureResponse(String response, boolean validAction) {
		setValidAction(validAction);
		setResponse(response);
	}
	
	/**
	 * Sets if the action was valid or not 
	 * 
	 * @param validAction Returns true or false 
	 */
	private void setValidAction(boolean validAction) {
		this.validAction = validAction;
	}
	
	/**
	 * Sets the response to the passed parameter 
	 * 
	 * @param response the string for response 
	 */
	private void setResponse(String response) {
		this.response = response;
	}
	
	/**
	 * Gets the action boolean value 
	 * 
	 * @return Returns true or false for the action 
	 */
	public boolean getValidAction() {
		return this.validAction;
	}
	
	/**
	 * Gets the response from the object 
	 * 
	 * @return Returns the string from the object 
	 */
	public String getResponse() {
		return this.response;
	}
}
