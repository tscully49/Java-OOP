/**
 * Name: Thomas Scully
 * Date: 10/27/14
 * Section: D
 * Submission Code: Bonus Week
 */ 
package tps9tb.cs3330.lab7;

public class Snake extends Animal implements NonFlying{
	/**
	 * The constructor for snake, which calls the super constructor for all the parameters 
	 * 
	 * @param type the type to be assigned to the snake through the super constructor 
	 */
	public Snake(String type) {
		super(false, false, type);
	}
	
	/**
	 * The snake will try to eat the animal object passed, returns if it is true or not 
	 * 
	 * @Param food The animal object that the snake will try to eat 
	 * @Return boolean Returns true or false if the snake could eat the animal 
	 */
	public boolean eat(Animal food) {
		return false;
	}
	
	/**
	 * Allows the snake to slither, gives the snake the ability to slither as its movement 
	 */
	public void movement() {
		System.out.println("The snake slithers on the ground");
	}
}
