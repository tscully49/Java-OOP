/**
 * Name: Thomas Scully
 * Date: 9/22/14
 * Section: D
 * Submission Code: None 
 */
package tps9tb.cs3330.homework1;


import java.util.Scanner;
import java.util.Random;

public class Scavenger {
	
	private static Scanner userInput;
	private static Item[] playerItems;
	private static Item[] gameItems;
	private static Command[] gameCommands;
	private static int currentPlayerItemsIdx;
	
	/**
	 * Plays the game through until a "quit" is entered as the command 
	 * 
	 * @param args Not used 
	 */
	public static void main(String[] args) {
			initGameDataAndArrays(); // Initialize the game 
			System.out.print("Enter a name: ");
			String name = userInput.nextLine(); // Enter a name 
			
			System.out.println("Welcome to the Scavenger Game "  + name );
			System.out.println(""); 
			
			while(currentPlayerItemsIdx < playerItems.length) { // If the index is still within the bag array 
				Item foundItem = scavengeArea(); // Look for an item 
				System.out.println("Item found: " + foundItem.getName());
				String[] splitStrings = null; 
				do {
					System.out.print("Command: ");
					String input = userInput.nextLine(); // Insert a game command 
					splitStrings = input.split(" "); 
					while (!validCommand(splitStrings)) { // Check to make sure the command is valid 
						System.out.print("Invalid Try Again, Command: ");
						input = userInput.nextLine(); 
						splitStrings = input.split(" "); // Input a new command for error checking 
					}	
				} while (!runCommand(splitStrings[0],foundItem)); // loop which a valid command is found 
			}
			
			displayPlayerItems();
			PlayerItemsStats(); // end game and print out stats 
	}
	
	/**
	 * Initializes a scanner as well as the empty bag, the array of items, and possile game commands to be used throughout the game 
	 */
	public static void initGameDataAndArrays() {
		userInput = new Scanner(System.in); // Creates new instance of scanner class 
		
		playerItems = new Item[10]; // creates empty bag of 10 indexes 
		for(int i=0;i<10;++i) {
			playerItems[i] = new Item("Empty", 0, 0);
		}
		
		GameDataReader gameReader = new GameDataReader(); 
		
		gameItems = gameReader.getGameItems();
		
		currentPlayerItemsIdx = 0;
		
		gameCommands = new Command[5]; // Makes array of game commands at 5 indexes 
		
		gameCommands[0] = new Command("help"); // Sets all of the game commands possible for the game 
		gameCommands[1] = new Command("pickup");
		gameCommands[2] = new Command("drop");
		gameCommands[3] = new Command("view");
		gameCommands[4] = new Command("quit");
		
	}
	
	/**
	 * Randomly generates a number and searches for an item.  Then sends a random item to main
	 *  
	 * @return gameItems[num] A random item from the items array 
	 */
	private static Item scavengeArea() {
		Random random = new Random(); // Creates a new instance of the random class 
		int num = random.nextInt(4)+1; // Creates a random number between 1-4
		for(int i=0;i < num; ++i) {
			System.out.println("Scavenging for an item...");
		}
		num = random.nextInt(25); // Creates a random number between 0-25 
		
		return gameItems[num]; 
	}
	
	/**
	 * Runs whatever command is passed to the method until a "quit" is found.  Already assumes that the command is checked for errors 
	 * 
	 * @param commandName The command to be ran 
	 * @param item The item to be used if picked up 
	 * @return boolean either returns a true or false dependent on what command is ran 
	 */
	public static boolean runCommand(String commandName, Item item) {
		
		if (commandName.equals(gameCommands[4].getCommandName())) {
			System.out.println("Game Terminated");
			System.exit(0); // Exits the program 
			return false;
		}
		else if (commandName.equals(gameCommands[1].getCommandName())) {
			addItemToPlayerItems(item); // Add the item to the bag method 
			System.out.println("Item successfully added");
			return true;
		}
		else if (commandName.equals(gameCommands[2].getCommandName())) {
			System.out.println("Item not added");
			return true;
		}
		else if (commandName.equals(gameCommands[0].getCommandName())) {
			displayGameCommands(); // run method for game commands 
			return false;
		}
		else if (commandName.equals(gameCommands[3].getCommandName())) {
			displayPlayerItems(); // run method for the bag 
			return false;
		}
		return true;
	}
	
	/**
	 * Displays all items in bag, but if bag is empty, it displays that the bag is empty 
	 */
	public static void displayPlayerItems() {
		if (currentPlayerItemsIdx == 0) { // If the bag is empty...
			System.out.println("Bag is empty...");
			return;
		}
		else {
			for (Item s: playerItems) {
				if (!s.getName().equals("Empty")) {
					System.out.println(s.getName() + "  " + s.getValue());
				}
			}
		}
	}
	
	/**
	 * Displays all possible commands to be used in the game 
	 */
	public static void displayGameCommands() {
		System.out.println("COMMANDS: ");
		for (Command s: gameCommands) { // foreach loop through the commands array 
			System.out.println(s.getCommandName() + " ");
		}
	}
	
	/**
	 * Checks to make sure the string passed is a valid command to be used in the game, returns true or false accordingly 
	 * 
	 * @param splitString The string to be checked against game commands 
	 * @return boolean Returns true if the string passed is a possible game command 
	 */
	public static boolean validCommand(String[] splitString) {
		if (splitString[0].equals(gameCommands[0].getCommandName()) || splitString[0].equals(gameCommands[1].getCommandName()) || splitString[0].equals(gameCommands[2].getCommandName()) || splitString[0].equals(gameCommands[3].getCommandName()) || splitString[0].equals(gameCommands[4].getCommandName())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Adds the passed item to the player's bag and increments the item index 
	 * 
	 * @param item The item to be added to the bag 
	 * @return boolean Returns false if the index is outside the bag, and true if the item is added to the bag 
	 */
	public static boolean addItemToPlayerItems(Item item) {
		if (currentPlayerItemsIdx >= playerItems.length) { // If the item index is at or past the end of the bag array 
			return false;
		}
		else {
			playerItems[currentPlayerItemsIdx] = item; // place the item in the bag 
			currentPlayerItemsIdx++;
			return true;
		}
	}
	
	/**
	 * Adds the total weight of all items as well as finding the minimum weight and the maximum weight and prints it out 
	 */
	public static void PlayerItemsStats() {
		int totalWeight = 0; // set total weight to 0 
		for(Item s: playerItems) { // Find the total weight 
			totalWeight += s.getWeight();
		}
		int totalValue = 0; // set total value to 0 
		for(Item s: playerItems) { // Find the total weight 
			totalValue += s.getValue();
		}
		int smallValue = playerItems[0].getWeight();
		for(Item s: playerItems) { // find the minimum weight 
			if(s.getWeight() < smallValue) {
				smallValue = s.getWeight();
			}
		}
		int largeValue = playerItems[0].getWeight();
		for(Item s: playerItems) { // find the maximum weight 
			if (s.getWeight() > largeValue) {
				largeValue = s.getWeight();
			}
		}
		System.out.println("\nTotal Weight is: "+totalWeight+"\nTotal Value is: "+totalValue+"\nMax weight found is: "+largeValue+"\nMin weight found is: "+smallValue);
	}

}