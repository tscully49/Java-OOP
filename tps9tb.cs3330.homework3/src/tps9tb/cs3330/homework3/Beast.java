/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D
 * Homework 3 
 */
package tps9tb.cs3330.homework3;

public class Beast extends GameCreature{
	private String type;;
	
	/**
	 * Constructor for beast 
	 * 
	 * @param name The name 
	 * @param hp The health points 
	 */
	public Beast(String name, int hp, Bag emptyBag, String level) {
		super(name, hp, emptyBag);
		setType(level);
	}
	
	/**
	 * Sets the type of beast depending on the parameter 
	 * @param level The level to be set in the beast 
	 */
	private void setType(String level) {
		this.type = level;
	}
	 
	/**
	 * Gets the type of the beast and returns it 
	 * @return
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Attacks the creature that is passed in with the item that is also passed in and calls methods to do damage 
	 */
	public boolean attack(GameCreature human, Item item) {
		if (item instanceof Weapon) { // checks that the item is a weapon 
			human.injured(item.getPoints()); // injures the human 
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Heals the creature with the item that is passed after checking that the item is a healer type 
	 */
	public boolean heal(Item item) {
		if (item instanceof Healer) {
			this.health.heal(item.getPoints());
			return true;
		}
		else {
			return false;
		}
	}
	 
	/**
	 * Picks up the item for the beast, but this is never used 
	 */
	public boolean pickup (Item item) {
		return this.bag.addItem(item);
	}
	
	/**
	 * Drops the item for the beast but is never used 
	 */
	public boolean drop(Item item) {
		return this.bag.dropItem(item);
	}
	
	/**
	 * Drops all items in the beasts bag but is also never used
	 */
	public void dropAll() {
		this.bag.dropItems();
	}
	
}
