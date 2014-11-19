/**
 * Name: Thomas Scully
 * Date: 11/3/14
 * Section: D
 * Submission Code: AdvanceWars
 */ 
package tps9tb.cs3330.lab8;

@SuppressWarnings("serial")

public class InvalidBalanceException extends Exception{
	/**
	 * An empty constructor for InvalidBalanceException
	 */
	public InvalidBalanceException() {
		
	}
	
	/**
	 * Constructor for InvalidBalanceException with a parameter 
	 * 
	 * @param message The message to be added to the error message 
	 */
	public InvalidBalanceException(String message) {
		super(message); // calls the super constructor 
	}
}
