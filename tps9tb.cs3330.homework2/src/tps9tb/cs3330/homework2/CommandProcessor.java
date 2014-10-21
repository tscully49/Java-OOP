/**
 * Name: Thomas Scully
 * Date: 10/14/14
 * Section: D
 * Submission Code:
 */
package tps9tb.cs3330.homework2;

import java.util.ArrayList;

public class CommandProcessor {
	private ArrayList<String> gameCommands;

	/**
	 * The constructor for command processor 
	 */
	public CommandProcessor() {
		setGameCommands();
	}
	
	/**
	 * Sets the game Commands for the game 
	 */
	public void setGameCommands() {
		GameDataReader reader = new GameDataReader();
		gameCommands = reader.getGameCommands("GameData/Commands.txt");
	}
	
	/**
	 * Gets all the game commands and returns it 
	 * 
	 * @return Returns the array list of game commands 
	 */
	public ArrayList<String> getCommands() {
		return gameCommands;
	}
	
	/**
	 * Validates if the passed command is valid or not 
	 * 
	 * @param command the command to be checked 
	 * @return Returns true or false 
	 */
	public boolean validateUserCommand(String command) {
		for(String s: gameCommands) {
			if (s.equals(command)) {
				return true;
			}
		}
		return false;
	}
}
