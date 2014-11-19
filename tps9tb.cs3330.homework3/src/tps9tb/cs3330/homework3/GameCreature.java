/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D
 * Homework 3
 */
package tps9tb.cs3330.homework3;

import java.util.ArrayList;

public abstract class GameCreature implements Creature{
	private String name;
	private CommandProcessor commandProcessor;
	protected Bag bag;
	protected Health health;
	/**
	 * Constructor for the GameCreature class using passed parameters
	 * @param name The name to be used 
	 * @param hp The HP to be used 
	 * @param emptyBag The empty bag to be instantiated 
	 */
	public GameCreature(String name, int hp, Bag emptyBag) {
		initCommandProcessor();
		setName(name);
		createHealth(hp);
		initBag(emptyBag);
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
	 * @param hp the health points to be used 
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
		this.bag.addItem(new Weapon("Standard", "Crowbar", 30, 5));
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
	public int currentHealthPoints() {
		return this.health.getHealthPoints();
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
	 * Processes the command input and executes that command after checking that the command is valid 
	 * 
	 * @param commands the command to be executed 
	 * @param beast The beast that could be affected 
	 * @param item The item to be used, dropped, or picked up 
	 * @return Returns a human response class  
	 */
	public CreatureResponse processCommand(String commands, GameCreature beast, Item item) {
		String response = "";
		boolean validAction = true;
		String[] splitCommands = commands.split(" "); // Splits the commands line up 
		
		if(!commandProcessor.validateUserCommand(splitCommands[0])) { // Checks to make sure the first index of the command isn't false 
			return new CreatureResponse("Invalid game command", false); // if so, return a false validaction and a response message 
		}
		if (splitCommands[0].equals("attack") && splitCommands.length == 3 && splitCommands[1].equals("with")) { //Checks that all indexes in the command for attack is correct 
			splitCommands[2] = Character.toUpperCase(splitCommands[2].charAt(0)) + splitCommands[2].substring(1); // change the item to upper case so you don't have to input it with an upper case 
			Item used = this.bag.getItem(splitCommands[2]);
			if (beast.isLiving()) { // If the beast is alive and is valid... 
				if(attack(beast, used) != true) { // if the attack fails, print out... 
					response = "Not a Valid Weapon";
					validAction = false; // sets validAction to false 
				}
				else {
					response = "Attack successful"; // Otherwise, report that the attack worked 
				}
			}
		
		}
		if(splitCommands[0].equals("pickup")) { // if the user says to pickup...
			if (pickup(item)) {
				response = "Item added successfully"; // If pickup is successful, report that it worked 
			}
			else {
				response = "Item not added successfully";
				validAction = false;
			}
		}
		if(splitCommands[0].equals("drop") && splitCommands.length >= 2) {
			String dropItem = Character.toUpperCase(splitCommands[1].charAt(0)) + splitCommands[1].substring(1); // converts the item to uppercase again 
			splitCommands[1] = Character.toUpperCase(splitCommands[1].charAt(0)) + splitCommands[1].substring(1); // 
			
			if (splitCommands.length == 3) { // If there is a number at the end of te drop item command 
				try {
					Integer.parseInt(splitCommands[2]); // CHeck to make sure it is an integer 
				}
				catch (NumberFormatException e) { // Catch any error converting the string to an integer 
					response = "Item not successfully dropped";
					validAction = false;
					return new CreatureResponse(response, validAction); // Report that the item wasn't dropped 
				}
				int var = Integer.parseInt(splitCommands[2]); // If the string is an int, then convert it and set to a variable 
				if(this.bag.getItem(var-1).getName() == item.getName()) { // Check that the index used in the command string actually has an item there, if so, then drop it 
					if (drop(item)) {
						response = "Item successfully dropped";
						return new CreatureResponse(response, true); // report that the item was successfully dropped 
					}
					else{
						response = "Item not dropped successfully"; 
						return new CreatureResponse(response, false); // report that the item wasn't successfully dropped 
					}
				}
				response = "Item not successfully dropped"; // Sets the response to a fail statement
				validAction = false; // sets the validAction to false
			}
			else if(drop(this.bag.getItem(dropItem))) {
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
		if (splitCommands[0].equals("heal") && splitCommands.length > 2) {
			splitCommands[2] = Character.toUpperCase(splitCommands[2].charAt(0)) + splitCommands[2].substring(1); // change the item to upper case so you don't have to input it with an upper case 
			Item used = this.bag.getItem(splitCommands[2]); // Pulls the item in the command String from the bag and sets it to "used"
			if (splitCommands.length == 4) { // Checks to see if the user used a number in the command string 
				try {
					Integer.parseInt(splitCommands[3]); // If so, convert that string to an integer and catch any errors 
				}
				catch (NumberFormatException e) { // Will be caught if the string is not an int 
					response = "Item not successfully used for healing";
					validAction = false;
					return new CreatureResponse(response, validAction); // Record an error message and send back the response 
				}
				int var = Integer.parseInt(splitCommands[3]); // If the string is an int then convert it and set it to a variable 
				if(this.bag.getItem(var-1).getName() == item.getName()) { // Checks that the number in the command string has an item in that number spot in the bag 
					if (this.heal(item)) { // Check to see the boolean response after calling heal 
						response = "Item successfully used for healing";
						this.bag.dropItem(used);
						return new CreatureResponse(response, true); 
					}
					else{ // If heal did not work successfully 
						response = "Item not used for healing successfully";
						return new CreatureResponse(response, false);
					}
				}
			}
			if (this.heal(used)) { // If a number wasn't used, call heal regardless and check based on the name of the item, not the index and name 
				response = "Item successfully used for healing";
				this.bag.dropItem(used);
			}
			else { // if heal failed, set the response and validACtion variables 
				response = "Cannot use this item for healing";
				validAction = false;
			}
		}
		if(splitCommands[0].equals("runaway")) { // Checks that the user entered "runaway" as a command 
			response = "Fled and dropped all items\n";
			this.dropAll(); // Drops all items and sets the response message 
		}
		CreatureResponse newReturn = new CreatureResponse(response, validAction); // return the human response with the response and validACtion type 
		return newReturn; // Return the response 
	}
	
	/**
	 * Injures whatever creature this is called from, calls the hit method from Health and deducts the healthpoints respectively 
	 */
	public void injured(int damage) {
		health.hit(damage);
	}
}
