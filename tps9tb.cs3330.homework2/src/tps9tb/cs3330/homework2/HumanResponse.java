/**
 * Name: Thomas Scully
 * Date: 10/14/14
 * Section: D
 * Submission Code:
 */
package tps9tb.cs3330.homework2;

public class HumanResponse {
	private String response;
	private boolean validAction;
	
	/**
	 * The constructor for human response 
	 *  
	 * @param response The reponse 
	 * @param validAction Boolean if the action is valid or not 
	 */
	public HumanResponse(String response, boolean validAction) {
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
