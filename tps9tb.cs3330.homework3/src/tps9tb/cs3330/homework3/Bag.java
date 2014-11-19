/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D
 * Homework 3
 */
package tps9tb.cs3330.homework3;

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
		for(Item s: items) { // Gets an item from the bag with the same name as the passed string 
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
		return this.items;
	}
	
	/**
	 * Gets the size of the item array list 
	 * 
	 * @return Returns an integer of the size 
	 */
	public int getSize() {
		return this.items.size();
	}
	
	/**
	 * Adds an item to the bag and returns true or false 
	 * 
	 * @param item the item to be added 
	 * @return Returns if the item was added or not 
	 */
	public boolean addItem(Item item) {
		if((this.weight + item.getWeight()) <= 20) { // Add the item as long as the weight of the bag doesn't exceed 20
			this.items.add(item);
			this.weight += item.getWeight();
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
		if (this.items.remove(item)) { // Remove the item and subtract the weight of it 
			this.weight -= item.getWeight();
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Drops all items in the bag by clearing the array list 
	 */
	public void dropItems() {
		items.clear();
		weight = 0;
	}
	
	/**
	 * Gets an item from the array list based on its index rather than its name 
	 * 
	 * @param itemIdx The index of the item in the array list 
	 * @return Returns the item in the index 
	 */
	public Item getItem(int itemIdx) {
		return items.get(itemIdx);
	}
}
