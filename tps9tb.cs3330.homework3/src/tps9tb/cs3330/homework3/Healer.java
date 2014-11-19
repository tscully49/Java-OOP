/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D
 * Homework 3 
 */
package tps9tb.cs3330.homework3;

public class Healer extends Item{
	private int healPoints;
	
	/**
	 * The constructor for healer Item objects 
	 * 
	 * @param name The name of the healer item 
	 * @param level The level of the healer item 
	 * @param weight the weight of the healer item 
	 * @param healPoints The heal points of the item 
	 */
	public Healer(String name, String level, int weight, int healPoints) {
		super(name, level, weight); // Calls the super constructor from Item 
		setHealPoints(healPoints); // Sets the heal points of the item
	}
	
	/**
	 * Sets the heal points of the weapon based on the passed parameters 
	 * 
	 * @param healPoints The int value of heal points to be used on the healer item 
	 */
	private void setHealPoints(int healPoints) {
		this.healPoints = healPoints;
	}
	
	/**
	 * GEts the int value of heal points on the weapon 
	 * 
	 * @return this.healPoints the heal points of this object 
	 */
	public int getPoints() {
		return this.healPoints;
	}
}
