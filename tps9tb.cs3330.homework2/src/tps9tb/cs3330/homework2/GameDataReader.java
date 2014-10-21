/**
 * Name: Thomas Scully
 * Date: 10/14/14
 * Section: D
 * Submission Code:
 */
package tps9tb.cs3330.homework2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameDataReader {
	/**
	 * Reads through the list of valid commands and puts them into an array list and returns the list 
	 * 
	 * @param filePath The path to find the file that will be read in 
	 * @return command Returns the array list of valid commands 
	 */
	public ArrayList<String> getGameCommands(String filePath) {
		ArrayList<String> command = new ArrayList<String>();
		
		BufferedReader reader = null; // Sets the reader to null 
		
		try {
			File file = new File(filePath); // Creates file pointer
			reader = new BufferedReader(new FileReader(file)); // Creates an instance of buffered reader 
			
			String line;
			while ((line = reader.readLine()) != null) { // Parses through each line of the file until the end or until the counter reaches 25
			
				command.add(new String(line)); // Put the data in the object Employee
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
		
		return command; // Returns an array of class Item 
	}
	/**
	 * Reads through the file and creates an array list of all possible items in the game 
	 * 
	 * @param filePath The path to the file to be read in 
	 * @return items The array list of all possible items that can be used in the game 
	 */
	public ArrayList<Item> getGameItems(String filePath) {
		
		ArrayList<Item> items = new ArrayList<Item>(); 
		
		BufferedReader reader = null; // Sets the reader to null 
		
		try {
			File file = new File(filePath); // Creates file pointer
			reader = new BufferedReader(new FileReader(file)); // Creates an instance of buffered reader 
			
			String line;
			while ((line = reader.readLine()) != null) { // Parses through each line of the file until the end or until the counter reaches 25
				
				String[] tempString = line.split(","); // Creates a temporary string 
			
				items.add(new Item(tempString[0], Integer.parseInt(tempString[1]), Integer.parseInt(tempString[2]))); // Put the data in the object Employee
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
		
		return items; // Returns an array of class Item 
	}
	/**
	 * Creates an array list of all possible beasts in the game that can be found and returns the array list 
	 * 
	 * @param filePath The path to the file that wil be read in 
	 * @return beasts The array list of all beasts in the game 
	 */
	public ArrayList<Beast> getGameBeasts(String filePath) {
		ArrayList<Beast> beasts = new ArrayList<Beast>(); 
		
		BufferedReader reader = null; // Sets the reader to null 
		
		try {
			File file = new File(filePath); // Creates file pointer
			reader = new BufferedReader(new FileReader(file)); // Creates an instance of buffered reader 
			
			String line;
			while ((line = reader.readLine()) != null) { // Parses through each line of the file until the end or until the counter reaches 25
				
				String[] tempString = line.split(","); // Creates a temporary string 
			
				beasts.add(new Beast(tempString[0], Integer.parseInt(tempString[1]))); // Put the data in the object Employee
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
		
		return beasts; // Returns an array of class Item 
	}

}

