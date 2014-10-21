/**
 * Name: Thomas Scully
 * Date: 10/14/14
 * Section: D
 * Submission Code:
 */
package tps9tb.cs3330.homework2;

import java.util.ArrayList;

public class Bag {
	private ArrayList<Item> items;
	private int weight;
	
	/**
	 * The constructor for the bag 
	 */
	public Bag() {
		initBag();
	}
	
	/**
	 * Initializes the bag and sets the weight to 0 
	 */
	private void initBag() {
		items = new ArrayList<Item>();
		weight = 0;
	}
	
	/**
	 * Gets an item from the bag and returns the object 
	 * 
	 * @param name The name of the item to be searched for 
	 * @return REturns the object of the item 
	 */
	public Item getItem(String name) {
		for(Item s: items) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
	
	/**
	 * Gets all items from the bag 
	 * 
	 * @return Returns an array list of all items 
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * Gets the size of the item array list 
	 * 
	 * @return Returns an integer of the size 
	 */
	public int getSize() {
		return items.size();
	}
	
	/**
	 * Adds an item to the bag and returns true or false 
	 * 
	 * @param item the item to be added 
	 * @return Returns if the item was added or not 
	 */
	public boolean addItem(Item item) {
		if((weight + item.getWeight()) <= 20) {
			items.add(item);
			weight += item.getWeight();
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Drops the passed item from the bag 
	 * 
	 * @param item The item to be dropped 
	 * @return Returns if the item was dropped or not 
	 */
	public boolean dropItem(Item item) {
		if (items.remove(item)) {
			weight -= item.getWeight();
			return true;
		}
		else {
			return false;
		}
	}
}
