/**
 * Name: Thomas Scully
 * Date: 10/27/14
 * Section: D
 * Submission Code: Bonus Week
 */ 
package tps9tb.cs3330.lab7;

public class Bat extends Animal implements Flying{
	/**
	 * The constructor for the bat class which instantiates all the attributes for animal 
	 * 
	 * @param type The parameter which will be used to instantiate the type attribute 
	 */
	public Bat(String type) {
		super(true, true, type);
	}
	
	/**
	 * Returns if the bat can eat the passed in food or not, if so it returns true 
	 * 
	 * @Param food The food that the bat will have to learn 
	 * @Return boolean 
	 */
	public boolean eat(Animal food) {
		if (food instanceof Bat || food instanceof Snake) {
			return true;
		}
		else return false;
	}
	
	/**
	 * Allows the bat to take off, prints out that the bat can take off 
	 */
	public void takeOff() {
		System.out.println("The bat has taken off!");
	}
	
	/**
	 *  Allows the bat to land, prints out that the bat can take off 
	 */
	public void land() {
		System.out.println("The bat has landed on the ground");
	}
}
