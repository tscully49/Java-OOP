/**
 * Name: Thomas Scully
 * Date: 10/14/14
 * Section: D
 * Submission Code:
 */
package tps9tb.cs3330.homework2;

public class Health {
	private int healthPoints;
	private boolean alive;
	
	/**
	 * The constructor for health 
	 */
	public Health() {
		setAlive(true);
		setHealth(100);
	}
	
	/**
	 * The other constructor for health that has a parameter 
	 * 
	 * @param healthPoints The health points to be used 
	 */
	public Health(int healthPoints) {
		setAlive(true);
		setHealth(healthPoints);
	}
	
	/**
	 * Sets the health points for human 
	 * 
	 * @param hp The health points to be used 
	 */
	private void setHealth(int hp) {
		if (hp >= 1) {
			this.healthPoints = hp;
		}
		else {
			setAlive(false);
		}
	}
	
	/**
	 * Sets isAlive to the passed boolean parameter 
	 * 
	 * @param alive The boolean parameter 
	 */
	private void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * Gets the health points 
	 * 
	 * @return	Returns the health points 
	 */
	public int getHealthPoints() {
		return this.healthPoints;
	}
	
	/**
	 * Gets if the object is alive or not 
	 * 
	 * @return Returns true or false 
	 */
	public boolean getAlive() {
		return this.alive;
	}
	
	/**
	 * Subtracts health points based on the parameters passed in 
	 * 
	 * @param hitPoints the number to take away from health points 
	 */
	public void hit(int hitPoints) {
		int newHealth = healthPoints - hitPoints;
		setHealth(newHealth);
	}
}
