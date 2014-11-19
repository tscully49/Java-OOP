/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D
 * Homework 3 
 */
package tps9tb.cs3330.homework3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameDataReader {
	public GameDataReader() {};
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
				String[] nameString = tempString[1].split(" ");
				if (tempString[0].equals("Weapon")) {
					items.add(new Weapon(nameString[1], nameString[0], Integer.parseInt(tempString[2]), Integer.parseInt(tempString[3]))); // Put the data in the object Employee
				}
				if (tempString[0].equals("Healer")) {
					items.add(new Healer(nameString[1], nameString[0], Integer.parseInt(tempString[2]), Integer.parseInt(tempString[3])));
				}
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
	 * @param filePath The path to the file that will be read in 
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
				
				String delim = "[\\s ,]+";
				String[] tempString = line.split(delim);// Creates a temporary string 
				//String[] nameString = tempString[0].split(" ");
				//String[] weaponString = tempString[2].split(" ");
				beasts.add(new Beast(tempString[1], Integer.parseInt(tempString[2]), new Bag(), tempString[0]));// Put the data in the object Employee
				beasts.get(beasts.size()-1).getBag().addItem(new Weapon(tempString[4], tempString[3], Integer.parseInt(tempString[5]), Integer.parseInt(tempString[6])));
				// Add the beasts item to their bag 
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

