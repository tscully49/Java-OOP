/**
 * Name: Thomas Scully
 * Date: 10/14/14
 * Section: D
 * Submission Code:
 */
package tps9tb.cs3330.homework2;

import java.util.ArrayList;

public class Human {
	private String name;
	private Bag bag;
	private Health health;
	private CommandProcessor commandProcessor;
	
	/**
	 * The constructor for human 
	 * 
	 * @param name the name
	 * @param hp the health points 
	 * @param emptyBag the bag for the human 
	 */
	public Human(String name, int hp, Bag emptyBag) {
		setName(name);
		createHealth(hp);
		initBag(emptyBag);
		initCommandProcessor();
	}
	
	/**
	 * The setter for name 
	 * 
	 * @param name the name 
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Creates the health for human 
	 * 
	 * @param hp the healthpoints to be used 
	 */
	private void createHealth(int hp) {
		this.health = new Health(hp);
	}
	
	/**
	 * Creates the bag with a crowbar in it 
	 * 
	 * @param emptyBag The empty bag passed through 
	 */
	private void initBag(Bag emptyBag) {
		this.bag = emptyBag;
		this.bag.addItem(new Item("Crowbar", 30, 5));
	}
	
	/**
	 * Initializes a class of command processor 
	 */
	private void initCommandProcessor() {
		commandProcessor = new CommandProcessor();
	}
	
	/**
	 * The getter for the name 
	 * 
	 * @return Returns this instance of the name 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * The getter for the health of the human 
	 * 
	 * @return Returns this instance of health 
	 */
	public Health getHealth() {
		return this.health;
	}
	
	/**
	 * The getter for the bag of the human 
	 * 
	 * @return Returns this instance of bag 
	 */
	public Bag getBag() {
		return this.bag;
	}
	
	/**
	 * Returns if the human is living or not 
	 * 
	 * @return Returns if the human is alive or not 
	 */
	public boolean isLiving() {
		return this.health.getAlive();
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
	 * @param item The iteam to be dropped 
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
	public boolean attack(Beast beast, Item item) {
		return beast.injured(item);
	}
	
	/**
	 * Processes the command inputted and executes that command after checking that the command is valid 
	 * 
	 * @param commands the command to be executed 
	 * @param beast The beast that could be affected 
	 * @param item The item to be used, dropped, or picked up 
	 * @return Returns a human response class 
	 */
	public HumanResponse processCommand(String commands, Beast beast, Item item) {
		String response = "";
		boolean validAction = true;
		String[] splitCommands = commands.split(" ");
		
		if (commandProcessor.validateUserCommand(splitCommands[0])) { // Check that the command is valid 
			if (splitCommands[0].equals("attack") && splitCommands.length >= 4 && splitCommands[2].equals("with")) { //Checks that all indexes in the command for attack is correct 
				if (splitCommands[1].equals(beast.getName()) && beast.isLiving()) { // If the beast is alive and is valid... 
					
					splitCommands[3] = Character.toUpperCase(splitCommands[3].charAt(0)) + splitCommands[3].substring(1); // change the item to upper case so you don't have to input it with an upper case 
					Item used = this.bag.getItem(splitCommands[3]);
					
					if(attack(beast, used) == false) { // if the attack fails, print out... 
						response = "Not a Valid Weapon";
						validAction = false;
					}
				}
			
			}
			if(splitCommands[0].equals("pickup")) { // if the user says to pickup...
				if (pickup(item)) {
					response = "Item added successfully";
				}
				else {
					response = "Item not added successfully";
					validAction = false;
				}
			}
			if(splitCommands[0].equals("drop") && splitCommands.length >= 2) {
				String dropItem = Character.toUpperCase(splitCommands[1].charAt(0)) + splitCommands[1].substring(1); // converts the item to uppercase again 
				
				if(drop(this.bag.getItem(dropItem))) {
					response = "Item successfully dropped"; // if the item drop works correctly...
				}
				else {
					response = "Item not dropped successfully";
					validAction = false; // if it doesn't work 
				}
			}
			if(splitCommands[0].equals("help")) {
				ArrayList<String> stringList = commandProcessor.getCommands(); // Gets a list of valid commands from the file 
				
				for(String s: stringList) { // prints out all commands 
					response += s + "\n";
				}
			}
			
		}
		else {
			response = "Invalid Game Command"; // if command is not valid, let the user know and return a human response of false 
			HumanResponse no = new HumanResponse(response, false);
			return no;
		}
		HumanResponse newReturn = new HumanResponse(response, validAction); // return the human response with the response and validACtion type 
		return newReturn;
	}
	
}
