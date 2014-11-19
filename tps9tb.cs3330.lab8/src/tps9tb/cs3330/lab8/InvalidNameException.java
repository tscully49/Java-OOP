/**
 * Name: Thomas Scully
 * Date: 11/3/14
 * Section: D
 * Submission Code: AdvanceWars
 */ 
package tps9tb.cs3330.lab8;

@SuppressWarnings("serial")

public class InvalidNameException extends Exception{
	/**
	 * An empty constructor for InvalidNameException
	 */
	public InvalidNameException() {
		
	}
	
	/**
	 * Constructor for InvalidNameException with a passed parameter
	 * 
	 * @param message The passed parameter which adds a string to the end of the error message 
	 */
	public InvalidNameException(String message) {
		super(message);
	}
}
