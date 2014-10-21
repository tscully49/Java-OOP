/**
 * Name: Thomas Scully
 * Date: 10/20/14
 * Section: D
 * Submission Code: Lab6
 */ 
package tps9tb.cs3330.lab6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GoonDatabase {
	private TreeMap<String, Goon> goonDB;

	/**
	 * The constructor for this instance of goon database 
	 * 
	 * @param goonDB
	 */
	public GoonDatabase(String goonDB) {
		importFile(goonDB);
	}
	
	/**
	 * Search menus is the main method for the game.  It will have the user input a query and then it will search through 
	 * the whole goonDB and look for that query, and then it will output the results from the query and keep going
	 * until the user inputs a "q"
	 */
	public void searchMenu() {
		Scanner input = new Scanner(System.in);
		String query;	
		
		System.out.println("Please Enter Your Query (or q to exit): "); // Enters the query 
		query = input.nextLine();
		
		while (!query.equals("q")) { // while the user doesn't enter a "q"
			TreeMap<String, Goon> list = searchDatabase(query);
			 
			if (list.size() == 0) { // if an empty treemap is submitted 
				System.out.println("No results found...");
			}
			int count = 0;
			for (Map.Entry<String, Goon> entry : list.entrySet()) {
				System.out.println(count+1 + " - " + entry.getValue().getName()); // Will print out of order because it's sorted through the tree map 
				count++;
			}
			System.out.println(" ");
			
			System.out.println("Please Enter Your Query (or q to exit): "); // enters a new query 
			query = input.nextLine();
		}
		
		System.out.println("Program Complete.");
		input.close();
	}
	
	/**
	 * Imports the whole goonDB from the passed csv file 
	 * 
	 * @param filePath the path to find the file to be imported into goonDB
	 */
	protected void importFile(String filePath) {
		
		goonDB = new TreeMap<String, Goon>();
		
		BufferedReader reader = null; // Sets the reader to null 
		
		try {
			File file = new File(filePath); // Creates file pointer
			reader = new BufferedReader(new FileReader(file)); // Creates an instance of buffered reader 
			
			String line;
			while ((line = reader.readLine()) != null) { // Parses through each line of the file until the end or until the counter reaches 25
				String tempString[] = line.split(",");
				
				if (tempString[0].equals("Talent")) {
					goonDB.put(tempString[1] + "," + tempString[0], new Talent(tempString[1], tempString[2], tempString[3])); // Put the data in the object Employee
				}
				else if (tempString[0].equals("Don")) {
					goonDB.put(tempString[1] + "," + tempString[0], new Don(tempString[1], tempString[2], tempString[3], Integer.parseInt(tempString[4])));
				}
				else if (tempString[0].equals("Overseer")){
					goonDB.put(tempString[1] + "," + tempString[0], new Overseer(tempString[1], tempString[2], tempString[3]));
				}
				else {
					System.out.println("Something went wrong!!!");
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
	}
	
	/**
	 * This method will search through goonDB to look for the string query and input those objects into a treemap which it will return after
	 * 
	 * @param query the string to be searched for in the query 
	 * @return list The treemap of the results from the query search
	 */
	protected TreeMap<String, Goon> searchDatabase(String query) { // The search complexity for a TreeMap is O log(n)
		TreeMap<String, Goon> list = new TreeMap<String, Goon>();
		
		for(Map.Entry<String, Goon> i : goonDB.entrySet()) { // searches through the whole tree map 
			String[] temp = i.getKey().split(",");
			if(temp[0].toLowerCase().equals(query.toLowerCase()) || temp[1].toLowerCase().equals(query.toLowerCase())) {
				list.put(i.getKey(), i.getValue());
			}
		}
		return list; // returns the tree map 
	}
}
