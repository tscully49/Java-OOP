/**
 * Name: Thomas Scully
 * Date: 11/3/14
 * Section: D
 * Submission Code: AdvanceWars
 */ 
package tps9tb.cs3330.lab8;

@SuppressWarnings("serial")

public class InvalidAgeException extends Exception{
	/**
	 * An empty constructor for InvalidAgeException
	 */
	public InvalidAgeException() {
		
	}
	
	/**
	 * Constructor for InvalidAgeException with a passed parameter
	 * 
	 * @param message The passed parameter which adds a string to the end of the error message 
	 */
	public InvalidAgeException(String message) {
		super(message);
	}
}
