/**
 * Name: Thomas Scully
 * Date: 10/27/14
 * Section: D
 * Submission Code: Bonus Week
 */ 
package tps9tb.cs3330.lab7;

public class Monkey extends Animal implements NonFlying{
	/**
	 * The constructor for Monkey, which sets the type and instantiates the object 
	 * 
	 * @param type the value to be put into type for the monkey 
	 */
	public Monkey (String type) {
		super(true, false, type);
	}
	
	/** 
	 * Allows the monkey to only eat a snake, if it tries to eat anything else, it returns false 
	 * 
	 * @Param food the animal object that the monkey will try to eat 
	 * @Return boolean Returns true or false if the monkey could eat the animal 
	 */
	public boolean eat(Animal food){
		if (food instanceof Snake) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Allows the monkey to run, it gives the monkey the ability 
	 */
	public void movement() {
		System.out.println("The monkey is running on the ground");
	}
}
