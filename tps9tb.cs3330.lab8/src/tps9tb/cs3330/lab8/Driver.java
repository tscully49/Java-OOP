/**
 * Name: Thomas Scully
 * Date: 11/3/14
 * Section: D
 * Submission Code: AdvanceWars
 */ 
package tps9tb.cs3330.lab8;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Driver implements isValidData{
	/**
	 * The user will be prompted to enter a name, balance, and age for people in the bank account and will check each input to make sure that they are all valid inputs.
	 * If there is a problem with the input, then it will loop back to the beginning and ask for new inputs.  If all inputs are good, then it will add an instance of that 
	 * person to the array list and store them all until you type "q" and it will quit out and print out all of the instances of people in the array list 
	 * 
	 * @param args Does nothing for this instance 
	 */
	public static void main(String args[]) {
		ArrayList<Person> people = new ArrayList<Person>();
		String name = "";
		Scanner input = new Scanner(System.in); // Creates a new instance of scanner 
		while(!name.equals("q")) { // loops until q is typed 
			System.out.println(" ");
			
			System.out.println("Enter person info or q to quit.");
			System.out.print("Please enter the name of this person: ");
			name = input.nextLine();
			if (name.equals("q")) {
				break; // kills the loop if q is typed 
			}

			try {
				isName(name); 
			}
			catch (InvalidNameException e) { // catches the exception from isName and prints it out and goes back to the beginning of the while loop if caught 
				System.out.println(e); 
				continue;
			}
			
			System.out.print("Please enter an age for this person: ");
			String age = input.nextLine(); 
			
			try {
				isValidAge(age);
			}
			catch(InvalidAgeException e) { // goes to next loop and prints out error message if exception is caught from isValidAge
				System.out.println(e);
				continue;
			}
			
			
			System.out.print("Please enter a bank account for this person: ");
			String bankAccountBalance = input.nextLine();
			
			try {
				isBalance(bankAccountBalance);
			}
			catch(InvalidBalanceException e) {
				System.out.println(e);
				continue; // goes to the next loop of the while loop and skips the rest of this instance of the loop 
			}
			
			int new_age = Integer.parseInt(age); // turns the string into an integer 
			double new_balance = Double.parseDouble(bankAccountBalance); // makes the string into a double 
			people.add(new Person(new_age, name, new_balance)); // adds an instance of Person to the array list 
		}
		
		for(Person s: people) { // Prints out all people from the array list after the while loop is broken 
			System.out.println(s.toString());
		}
		input.close();
	}
	
	/**
	 * Error checks for a valid age making sure the age is between 0-150 and that an actual age was entered. It also checks that the age is an integer 
	 * 
	 * @param age The integer age passed in to be checked 
	 * @throws InvalidAgeException The exception that is searched for with the name 
	 */
	public static void isValidAge(String age) throws InvalidAgeException {//throws InvalidAgeException {
		try {
			if (age.equals(" ") || age.equals(null) || age.equals("")) { // Checks that something was actually entered besides a blank space of null 
				throw new InvalidAgeException("You did not enter an age ");
			}
			try { 
				int num = Integer.parseInt(age);
				if(num>=150) { // checks that the age is between 0-150 
					throw new InvalidAgeException("Age can not be equal to or more than 150");
				}
				if(num<=0) {
					throw new InvalidAgeException("Age can not be 0 or negative");
				}
			}
			catch(NumberFormatException e) { // Catches instances of the exception which are thrown in the case of a problem 
				throw new InvalidAgeException("You did not enter an Integer");
			}
		}
		catch(InvalidAgeException e) { // catches exceptions and executes the {} code 
			throw e;
		}
	}
	
	/**
	 * Error checks for a valid balance, making sure that the balance is a double.  Sends back an exception error message if not 
	 * 
	 * @param balance The double variable passed to be checked 
	 * @throws InvalidBalanceException The error message sent back if something wrong is found with the balance 
	 */
	public static void isBalance(String balance) throws InvalidBalanceException {
		try {
			if (balance.equals(" ") || balance.equals(null) || balance.equals("")) { // Checks that something was actually entered besides a blank space of null
				throw new InvalidBalanceException("You did not enter a balance ");
			}
			try {
				Double.parseDouble(balance); // tries to convert the String to a double 
			}
			catch(NumberFormatException e) {
				throw new InvalidBalanceException("You did not enter a Double"); // if it can't turn into a double, then executes the inside code 
			}
			
		} catch(InvalidBalanceException e) { // executes the inside code if the exception is caught
			throw e;
		}
	}
	
	/**
	 * Error checks for a valid name, making sure that the name is full of ONLY characters and white spaces.  Sends back an exception error message if not 
	 * 
	 * @param name The string passed into the method to be checked 
	 * @throws InvalidNameException The error message sent back if something wrong is found with the name 
	 */
	public static void isName(String name) throws InvalidNameException{// throws InvalidNameException {
		try{
			if (name.equals(" ") || name.equals(null) || name.equals("")) { // Checks that something was actually entered besides a blank space of null
				throw new InvalidNameException("You did not enter a name ");
			}
			for(int i=0;i<name.length();++i) { // iterates through every character in the string and checks that it is either a letter or a white space 
				char x = name.charAt(i); // makes a char out of that index of the string 
				
				if (!Character.isLetter(x) && !Character.isWhitespace(x)) { // checks for letters or white spaces 
					throw new InvalidNameException("You have entered an invalid name");
				}
			}
		}
		catch (InvalidNameException e) { // catches errors and executes the interior code if one is caught 
			throw e;
		}
	}
}
