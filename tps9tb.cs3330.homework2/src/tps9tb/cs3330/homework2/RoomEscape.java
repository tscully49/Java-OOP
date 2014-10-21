/**
 * Name: Thomas Scully
 * Date: 10/14/14
 * Section: D
 * Submission Code:
 */
package tps9tb.cs3330.homework2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RoomEscape {
	private static Scanner userInput;
	private static ArrayList<Item> gameItems;
	private static ArrayList<Beast> gameBeasts;
	private static ArrayList<Beast> currentRoomBeasts;
	private static Human currentPlayer;
	private static Random randomGenerator;
	
	/**
     * The game starts by initializing the game as well as picking a player and number of levels.  Then a new instance of human is created and a counter of rooms beaten is created.
     * Then you continue through the while loop until you beat the game.  While in the loop, the number of beasts in your current room is updated and beasts beaten is set to 0, and then a new 
     * loop is set up where you must stay alive and have less than two creatures killed to stay in the loop.  While in the loop a random number is generated and based on that number, you either
     * find a new item or you encounter a new enemy to fight.  If you find an item you jump into the noBattle method and then go back through the loop again.  If you find an enemy, you fight the
     * enemy until you kill it.  If you die, the game is over, but if you kill two beasts, you move up to the next level.  You play the game until you beat every level or until you die.  
     *
     */
    public static void main(String[] args) {
            
            initGameData();
            System.out.print("Enter Character Name: ");
            String name = userInput.nextLine();
            System.out.print("Enter number of levels: ");
            int maxRooms = Integer.parseInt(userInput.nextLine()); // initializes the rooms 
            
            currentPlayer = new Human(name,100, new Bag()); // instantiates human 
            int roomsBeat = 0;
            
            while (roomsBeat < maxRooms) { // loop until you beat the correct number of rooms 
                    /*
                     * Create room bad guys and items
                     */
                    System.out.println("Entering Room " + (roomsBeat + 1)); // outputs the room that you are in 
                    System.out.println(" ");
                    initCurrentRoomBeasts(); // initializes the current beasts 
                    int creaturesDestroyed = 0;
                    
                    while (currentPlayer.isLiving() && creaturesDestroyed < 2) { // while the player is alive and you havent kills two beasts 
                            int encounterProb = randomGenerator.nextInt(100);
                            Item foundItem = null;
                            Beast foundEnemy = null;
                            /*
                             * 60 percent chance of being a Beast.
                             */
                            if (encounterProb <= 40) { 
                                    foundItem = findItem();
                                    System.out.println("You have discovered the item " + foundItem.getName());
                                    while (noBattle(foundItem));  // calls noBattle
                                    
                            }
                            else {
                                    foundEnemy = findEnemy(); // finds an enemy 
                                    System.out.println("You have encountered a(n) " + foundEnemy.getName()); // outputs the enemy found 
                                    if (battle (foundEnemy)) {
                                            creaturesDestroyed++; 
                                    }
                                    else {
                                            System.out.println("You are dead!"); // outputs if you are dead
                                            return;
                                    }
                            }
                    }
                    roomsBeat++;
            }
            System.out.println("You have beat RoomEscape!");
    }
    /**
     * Initializes the game by creating instances of random and input as well as creating the array lists for beast and item 
     */
    private static void initGameData() {
    	userInput = new Scanner(System.in); // creates a new scanner class 
    	randomGenerator = new Random(1337);  // Creates a new instance of the random class 
    	
    	GameDataReader dataReader = new GameDataReader();
    	
    	String filePath = "GameData/GameItems.csv";
    	gameItems = dataReader.getGameItems(filePath); // fills the array list of gameItems
    	
    	String filePathh = "GameData/GameBeasts.csv";
    	gameBeasts = dataReader.getGameBeasts(filePathh); // fills the array list of gameBeasts
    }
    
    /**
     * Initializes the current beasts,  Implements a deep copy of gameBeasts into a new array list which apparently isn't used anywhere else in the code
     */
    private static void initCurrentRoomBeasts() {
    	currentRoomBeasts = new ArrayList<Beast>();
    	
    	for(Beast s: gameBeasts) { // loops through and deep copies the gameBeasts into the new array 
    		currentRoomBeasts.add(new Beast(s.getName(), s.getHealth()));
    	}
    }
    /**
     * Finds a randomly selected item from the static array list gameItems 
     * 
     * @return the randomly selected item from the array list 
     */
    private static Item findItem() {
		int itemIdx = randomGenerator.nextInt(gameItems.size());
		int move_iterations = randomGenerator.nextInt(3)+1;  // Creates a random number between 1-4
		/*for(int i=0;i < move_iterations; ++i) {
			System.out.println("Searching Area...");
		}*/
		
		int i = 0;
		do{
			System.out.println("Searching Area..."); // prints out search area 
			
		}while(i++ < move_iterations);
		
		return gameItems.get(itemIdx); 
    }
    /**
     * Finds an enemy from the static array list and returns that enemy 
     * 
     * @return the randomly generated Beast from the array list 
     */
    private static Beast findEnemy() {
		int num = randomGenerator.nextInt(gameBeasts.size()); // Creates a random number between 0-25 
		int move_iterations = randomGenerator.nextInt(3)+1;  // Creates a random number between 1-4
		/*for(int i=0;i < move_iterations; ++i) {
			System.out.println("Searching Area...");
		}*/
		
		int i = 0;
		do{
			System.out.println("Searching Area...");
			
		}while(i++ < move_iterations);
		
		return gameBeasts.get(num); // returns a random instance of gameBeasts 
    }
    /**
     * Allows the current player to engage in combat with the incoming beast. The player uses 
     * items from his bag to kill the enemy. 
     * 
     * @param battlingBeast The found beast the player has encountered
     * @return Whether the currentPlayer is dead being false or alive being true.
     */
    private static boolean battle (Beast battlingBeast) {
            
            while (currentPlayer.isLiving()) {
                    displayBagContents(); // displays all contents of the bag 
                    String attackString = "attack " + battlingBeast.getName() + " with ";
                    System.out.print(attackString);
                    String input = userInput.nextLine(); 
                    System.out.println(" ");
                    
                    attackString += input;  // adds on to the end of attack string 
                    
                    HumanResponse response = currentPlayer.processCommand(attackString, battlingBeast,null);
                    if (!response.getValidAction()) { // if the response is not valid... 
                            System.out.println(response.getResponse());
                    }
                    if (currentPlayer.isLiving() && !battlingBeast.isLiving()) { // if the player is alive and the beast is dead... 
                            System.out.println(battlingBeast.getName() + " is killed");
                            System.out.println(" ");
                            return true;
                    }
                    else {
                            System.out.println(battlingBeast.getName() + " HP: " + battlingBeast.getHealth());
                    }
            }
            return false; 
    }


    /**
     * Displays the contents of the bag to player
     *
     */
    private static void displayBagContents () {
            System.out.println("Contents of Bag:");
            System.out.println("Name      HitPoints    Weight");
            Bag playerBag = currentPlayer.getBag();
            for (Item i : playerBag.getItems()) {
                    System.out.printf("%-10s%6d%10d\n", i.getName(),i.getValue(),i.getWeight()); // prints out the contents of the bag 
            }
            System.out.println(" ");
    }
    
    /**
     * Allows the player to run the following game commands "pickup" on the found item, â€œviewâ€ the player bag contents,
     * "drop" an item from their bag, show the game commands using "help", current item, and the enter key allow you to skip past an item (the string is empty).
     *  
     * 
     * @param foundItem An instantiated Item that the player has found
     */
    
    private static boolean noBattle (Item foundItem) {
            displayBagContents();
            System.out.print("Command: ");
            String input = userInput.nextLine();
            if (input.isEmpty()) { // if the input is empty 
                    return false;
            }
            HumanResponse response = currentPlayer.processCommand(input, null,foundItem);
            while (!response.getValidAction()) {
                    System.out.print(response.getResponse() + ", Try Again: "); // outputs to try again 
                    input = userInput.nextLine();
                    response = currentPlayer.processCommand(input, null,foundItem); // sets response equal to the command      
                    if (input.isEmpty()) {
                            return false;
                    }
            }        
            System.out.println(response.getResponse());
            return true;
    
    }
}
