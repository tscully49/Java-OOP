/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D
 * Homework 3 
 */
package tps9tb.cs3330.homework3;

public abstract class Item {
	private String name;
	private String level;
	private int weight;
	
	/**
	 * Constructor for the class Item 
	 * 
	 * @param name The name of the item 
	 * @param level The level of the item 
	 * @param weight The weight of the item 
	 */
	public Item(String name, String level, int weight) {
		setName(name);
		setLevel(level);
		setWeight(weight);
	}
	
	/**
	 * Sets the name for the item 
	 * 
	 * @param name The item name 
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set the value for the item 
	 * 
	 * @param value The value of the item 
	 */
	private void setLevel(String level) {
		this.level = level;
	}

	/**
	 * Sets the weight of the item 
	 * 
	 * @param weight The weight of the item 
	 */
	private void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Grabs the name of the item 
	 * 
	 * @return this.name The name of that instance of item 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Grabs the value of the item 
	 * 
	 * @return this.value The value of that instance of item 
	 */
	public String getLevel() {
		return this.level;
	}
	
	/**
	 * grabs the weight of the item 
	 * 
	 * @return this.weight The weight of that instance of item
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * Abstract class for getPoints which will be defined in the subclasses of item 
	 * @return int will return an int value 
	 */
	public abstract int getPoints();
}
