/**
 * Name: Thomas Scully
 * Date: 9/22/14
 * Section: D
 * Submission Code: None 
 */
package tps9tb.cs3330.homework1;

public class Command {
	private String commandName;
	
	/**
	 * The constructor for command 
	 * 
	 * @param commandName The name of the command 
	 */
	public Command(String commandName) {
		setCommandName(commandName);
	}
	
	/**
	 * Sets the commandName for that instance of command 
	 * 
	 * @param commandName The name of the command 
	 */
	private void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	
	/**
	 * Grabs the name of that instance of command
	 * 
	 * @return this.commandName The command name of that instance of command 
	 */
	public String getCommandName() {
		return this.commandName;
	}
}