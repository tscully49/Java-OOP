/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D
 * Homework 3 
 */
package tps9tb.cs3330.homework3;

public class Human extends GameCreature{
	/**
	 * The constructor for human 
	 * 
	 * @param name the name
	 * @param hp the health points 
	 * @param emptyBag the bag for the human 
	 */
	public Human(String name, int hp, Bag emptyBag) {
		super(name, hp, emptyBag);
		this.bag.addItem(new Weapon("Crowbar", "Standard", 5, 30));
	}
	
	/**
	 * Picks up the current item and sends it to the addItem method in bag 
	 * 
	 * @param item The item to be added 
	 * @return Returns boolean if the item was added or not 
	 */
	public boolean pickup(Item item) {
		return this.bag.addItem(item);
	}
	
	/**
	 * Calls the dropItem method from bag 
	 * 
	 * @param item The item to be dropped 
	 * @return Returns if the item was dropped or not 
	 */
	public boolean drop(Item item) {
		return this.bag.dropItem(item);
	}
	
	/**
	 * Returns if the attack on the beast was successful or not 
	 * 
	 * @param beast The beast to be damaged 
	 * @param item The item to use on the beast 
	 * @return Returns if the attack worked or not 
	 */
	public boolean attack(GameCreature beast, Item item) {
		if (item instanceof Weapon) { // If the item is a Weapon, then attack the beast with double the weapon points and return true 
			beast.injured(item.getPoints()*2);
			return true;
		}
		else { // Else return false 
			return false;
		}
	}
	
	/**
	 * Drops all items in the bag for the human 
	 */
	public void dropAll() {
		this.bag.dropItems();
	}
	
	/**
	 * Heals the human and checks to make sure that a healer item is being used 
	 */
	public boolean heal(Item item) {
		if (item instanceof Healer) { // Checks that the item being used is a healer type 
			this.health.heal(item.getPoints()); // Then heals the human for however many points 
			return true; 
		}
		else {
			return false;
		}
	}
	
}
