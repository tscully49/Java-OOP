/**
 * Name: Thomas Scully
 * Date: 10/20/14
 * Section: D
 * Submission Code: Lab6
 */ 
package tps9tb.cs3330.lab6;

public class DatabaseDriver {
	/**
	 * Calls a new instance of the searchMenu and then activates it 
	 * 
	 * @param args Not used for this lab 
	 */
	public static void main(String[] args) {
		GoonDatabase game = new GoonDatabase("Data/Goons.csv");
		
		game.searchMenu();
	}
}
