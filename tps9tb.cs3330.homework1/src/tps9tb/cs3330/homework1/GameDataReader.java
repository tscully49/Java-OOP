/**
 * Name: Thomas Scully
 * Date: 9/22/14
 * Section: D
 * Submission Code: None 
 */
package tps9tb.cs3330.homework1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class GameDataReader {
	
	/**
	 * A blank constructor for GAmeDataReader
	 */
	public GameDataReader() {
		
	}
	
	/**
	 * Reads all the items, values, and weights and inputs them into an array of items to be used later in the game 
	 * 
	 * @return ItemArray The array of all items that can be found in the game 
	 */
	public Item[] getGameItems() {
		Item[] ItemArray = new Item[25]; // Instantiates the item array 
		
		BufferedReader reader = null; // Sets the reader to null 
		
		try {
			File file = new File("GameData/GameItems.csv"); // Creates file pointer
			reader = new BufferedReader(new FileReader(file)); // Creates an instance of buffered reader 
			
			String line;
			int counter = 0;
			while ((line = reader.readLine()) != null && counter < 25) { // Parses through each line of the file until the end or until the counter reaches 25
				
				String[] tempString = line.split(","); // Creates a temporary string 
			
				ItemArray[counter] = new Item(tempString[0], Integer.parseInt(tempString[1]), Integer.parseInt(tempString[2])); // Put the data in the object Employee
				counter++; 
			}
		}
		catch (IOException e) {
			e.printStackTrace(); // Catch any error and print it out 
		}
		finally {
			try {
				reader.close(); // Close the reader 
			}
			catch (IOException e) {
				e.printStackTrace(); // Print out any errors 
			}
		}
		
		return ItemArray; // Returns an array of class Item 
	}
}