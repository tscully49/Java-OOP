/**
 * Name: Thomas Scully
 * Date: 11/2/14
 * Section: D
 * Homework 3
 */
package tps9tb.cs3330.homework3;

import java.util.ArrayList;

public class CommandProcessor {
	protected ArrayList<String> gameCommands;

	/**
	 * The constructor for command processor  
	 */
	public CommandProcessor() {
		setGameCommands();
	}
	
	/**
	 * Sets the game Commands for the game 
	 */
	private void setGameCommands() {
		GameDataReader reader = new GameDataReader();
		gameCommands = reader.getGameCommands("GameData/Commands.txt");
	}
	
	/**
	 * Gets all the game commands and returns it 
	 * 
	 * @return Returns the array list of game commands 
	 */
	public ArrayList<String> getCommands() {
		return this.gameCommands;
	}
	
	/**
	 * Validates if the passed command is valid or not 
	 * 
	 * @param command the command to be checked 
	 * @return Returns true or false 
	 */
	public boolean validateUserCommand(String command) {
		for(String s: this.gameCommands) {
			if (s.equals(command)) { // If the command is equal to a command in the list, the print true 
				return true;
			}
		}
		return false;
	}
}
