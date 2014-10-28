/**
 * Name: Thomas Scully
 * Date: 10/27/14
 * Section: D
 * Submission Code: Bonus Week
 */ 
package tps9tb.cs3330.lab7;

public class Hawk extends Animal implements Flying{
	/**
	 * The constructor for the hawk, which only calls the super constructor 
	 * 
	 * @param type Makes the type variable equal to the parameter passed in 
	 */
	public Hawk(String type) {
		super(true, true, type);
	}
	
	/**
	 * Returns true or false depending on if the food is a bat or a snake 
	 * 
	 * @Param food The food that the Hawk is trying to eat 
	 * @Return boolean Returns true or false depending on if the Hawk can eat the food or not 
	 */
	public boolean eat(Animal food) {
		if(food instanceof Snake || food instanceof Bat) {
			return true;
		}
		else return false;
	}
	
	/**
	 * Allows the Hawk to take off, prints that the hawk can fly 
	 */
	public void takeOff() {
		System.out.println("The hawk has taken off!");
	}
	
	/**
	 *  Allows the hawk to land, prints that the hawk can land 
	 */
	public void land() {
		System.out.println("The hawk has landed on the ground");
	}
}
