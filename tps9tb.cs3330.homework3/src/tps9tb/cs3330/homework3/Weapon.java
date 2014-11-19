/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D
 * Homework 3 
 */
package tps9tb.cs3330.homework3;

public class Weapon extends Item{
	private int damagePoints;
	
	/**
	 * The constructor for weapons with passed parameters 
	 * 
	 * @param name The name of the weapon 
	 * @param level The level of the weapon 
	 * @param weight The weight of the weapon 
	 * @param damagePoints The damage points of the weapon 
	 */
	public Weapon(String name, String level, int weight, int damagePoints) {
		super(name, level, weight);
		setDamagePoints(damagePoints);
	}
	
	/**
	 * SEts the damage points of the weapon 
	 * 
	 * @param damagePoints The damage points to be used 
	 */
	private void setDamagePoints(int damagePoints) {
		this.damagePoints = damagePoints;
	}
	
	/**
	 * Gets the damage points of the weapon and returns it 
	 * 
	 * @return this.damagePoints The damage points of the weapon 
	 */
	public int getPoints() {
		return this.damagePoints;
	}
}
