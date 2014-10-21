/**
 * Name: Thomas Scully
 * Date: 10/14/14
 * Section: D
 * Submission Code:
 */
package tps9tb.cs3330.homework2;

public class Beast {
	private String name;
	private Health health;
	
	/**
	 * Constructor for beast 
	 * 
	 * @param name The name 
	 * @param hp The health points 
	 */
	public Beast(String name, int hp) {
		setName(name);
		createHealth(hp);
	}
	
	/**
	 * Sets the name for beast 
	 * 
	 * @param name The name 
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the health points for the beast 
	 * 
	 * @param hp the health points to be used 
	 */
	private void createHealth(int hp) {
		this.health = new Health(hp);
	}
	
	/**
	 * Gets the name of the beast 
	 * 
	 * @return Returns the name of the beast 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the health points of the beast 
	 *  
	 * @return Returns the health points 
	 */
	public int getHealth() {
		return this.health.getHealthPoints();
	}
	
	/**
	 * Injures the beast by a passed in item parameter 
	 * 
	 * @param item the item to hurt the beast with 
	 * @return returns true or false 
	 */
	public boolean injured(Item item) {
		if (item != null) {
			this.health.hit(item.getValue());
			return true;
		}
		else { return false; }
	}
	
	/**
	 * Returns if the beast is living
	 * 
	 * @return REturns true or false 
	 */
	public boolean isLiving() {
		return this.health.getAlive();
	}
}
