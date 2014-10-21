/**
 * Name: Thomas Scully
 * Date: 9/30/14
 * Section: D
 * Submission Code: FantasyFootball
 */
package tps9tb.cs3330.lab4;


public class Car {
	private String make;
	private String type;
	private String color;
	
	/**
	 * Executes all of the set methods for class Car
	 *  
	 * @param type The type of the car passed to set the car class
	 * @param color The color of the car passed to set the car class
	 * @param make The make of the car passed to set the car class 
	 */
	public Car(String type, String color, String make) {
		setType(type);
		setColor(color);
		setMake(make);
	}
	
	/**
	 * Sets the make of the car 
	 * 
	 * @param make The make of the car to be set to the class
	 */
	private void setMake(String make) {
		this.make = make;
	}
	
	/**
	 * Sets the type of the car 
	 * 
	 * @param type The type of the car to be set to the class 
	 */
	private void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Sets the color of the car 
	 *  
	 * @param color The color of the car to be set to the class 
	 */
	private void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Returns the make of the car 
	 * 
	 * @return this.make The make of that instance of the object 
	 */
	public String getMake() {
		return this.make;
	}
	
	/**
	 * Returns the type of the car 
	 * 
	 * @return this.type The type of that instance of the object 
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Returns the type of the car 
	 * 
	 * @return this.type The type of that instance of the object 
	 */
	public String getColor() {
		return this.color;
	}
}
