/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D 
 * Homework 3
 */
package tps9tb.cs3330.homework3;

public interface Creature { 
	public boolean attack(GameCreature creature, Item item);
	public boolean heal(Item item);
	public boolean pickup(Item item);
	public boolean drop(Item item);
	public void dropAll();
	public void injured(int damage);
	public CreatureResponse processCommand(String command,GameCreature creature,Item item);
}
