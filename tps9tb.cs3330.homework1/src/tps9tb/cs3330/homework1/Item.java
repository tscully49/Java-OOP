/**
 * Name: Thomas Scully
 * Date: 9/22/14
 * Section: D
 * Submission Code: None 
 */
package tps9tb.cs3330.homework1;

public class Item {
	private String name;
	private int value;
	private int weight;
	
	/**
	 * Constructor for the class Item 
	 * 
	 * @param name The name of the item 
	 * @param value The value of the item 
	 * @param weight The weight of the item 
	 */
	public Item(String name, int value, int weight) {
		setName(name);
		setValue(value);
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
	private void setValue(int value) {
		this.value = value;
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
	public int getValue() {
		return this.value;
	}
	
	/**
	 * grabs the weight of the item 
	 * 
	 * @return this.weight The weight of that instance of item
	 */
	public int getWeight() {
		return this.weight;
	}
}