/*
 * Implement the solutions to the missing code, if you have questions email your TA.
 * You can add or subtract material from the optional lab, but by doing this optional lab
 * you will be ready for lab1 which will be along the same lines as this and more. 
 */

package src.cs3330.optional.lab0;

import java.util.Scanner;

public class OptionalDriver {

	private static Scanner input;
	
	public static void main(String[] args) {
		/*
		 * The Scanner object allows a user to enter input into a console application
		 * A Scanner object can parse out a line, a number, and more.
		 */
		input = new Scanner(System.in); 
		/*
		 * An array in an Object in Java. Here we are assigning 
		 * the people reference to the returned array created in createdPersonArray
		 */
		Person[] people = createPersonArray();
		/*
		 * Just like C we pass the array by value
		 */
		displayPersonArray(people);
		/*
		 * System.out.println will display a string to the console
		 */
		System.out.println("Find Person: ");
		String target = input.nextLine();
		/*
		 * Performs a linear search on the passed array for the target
		 */
		findPersonLinearSearch(people,target);
		/*
		 * Java doesn't allow variables being redeclared so we have to create
		 * a new variable
		 */
		Person[] newPeople = addPerson(people);
		Person[] newerPeople = addPerson(newPeople);
		displayPersonArray(newerPeople);
		/*
		 * When we are done with our Scanner object we must close it.
		 */
		input.close();

	}
	
	public static  Person[] createPersonArray() {
		/*
		 * This is how to create an array in Java, note the difference
		 * between C and Java arrays.
		 * C: float data[];
		 * Java: float[] data;
		 */
		Person[] people = new Person[5];
		/*
		 * We can declare our counter variables within 
		 * our for loop unlike C. Note, I didn't hard code the value of 5.
		 * I used the array people length property. All arrays will have the length 
		 * property to use.
		 */
		for (int i = 0; i < people.length; ++i) {
			/*
			 * Ask the user for input for name of type String 
			 * and age that is type int. Use those scanned in
			 * values to pass to the creation of a new Person
			 * object
			 */
			System.out.println("Enter name: ");
			String firstName = input.nextLine();
			System.out.println("Enter age of person: ");
			int age = input.nextInt();

			/*
			 * We must initialize each reference of the array,
			 * thus I create a new Person Object. Similar to malloc in C.
			 */
			people[i] = new Person(firstName,age);
			input.nextLine(); // Eats the newline character...
		}
		return people;
	}
	
	public static void displayPersonArray(Person[] people) {
		/*
		 * Display the array passed, you can use the foreach loop (Google that :) )
		 * or do the standard for loop. To get a person's name, you must use the
		 * getter methods from an element in the people array, so getFirstName
		 * and getAge.
		 */
	
		for(Person s : people) {
			/*
			 * int age = getAge();
			 * String name = getFirstName();
			 */
			System.out.print(s.getFirstName());
			System.out.print(" - ");
			System.out.println(s.getAge());
		}
	}
	
	public static int findPersonLinearSearch(Person[] people, String firstName) {
		/*
		 * Do a linear search on the passed array with the target
		 */
		for(Person s : people){
			if ((s.getFirstName()).equals(firstName)) {
				System.out.println("Found the name!");
				return 1;
			}
		}
		System.out.println("Did NOT find the name!");
		return 0;
	}
	
	public static Person[] addPerson(Person[] people) {
		/*
		 * Create a new people array that is the size of people + 1, 
		 * copy all the persons from the people array passed
		 * into the new people array, and add the new person at
		 * the end of the array. After adding the new person,
		 * return the new people array created.
		 */
		Person[] newPeople = new Person[people.length+1];
		for(int i = 0; i < people.length; i++) {
			String firstName = people[i].getFirstName();
			int age = people[i].getAge();
			newPeople[i] = new Person(firstName, age);
		}
		System.out.println("Enter name of new person: ");
		String newName = input.nextLine();
		System.out.println("Enter age of the new person: ");
		int newAge = input.nextInt();
		newPeople[newPeople.length-1] = new Person(newName, newAge);
		input.nextLine();
		
		return newPeople;
	}

}
