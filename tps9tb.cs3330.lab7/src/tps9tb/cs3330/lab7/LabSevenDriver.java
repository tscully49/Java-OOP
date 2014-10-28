/**
 * Name: Thomas Scully
 * Date: 10/27/14
 * Section: D
 * Submission Code: Bonus Week
 */ 

package tps9tb.cs3330.lab7;

import java.util.ArrayList;

public class LabSevenDriver {
	/**
	 * The main method for the Driver which creates an arraylist, populates it, and calls all three other methods from the Driver to print out information about each animal object in the list 
	 * 
	 * @param args Any arguments that are passed into the program through the command line 
	 */
	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Hawk("Hawk"));
		animals.add(new Bat("Bat"));
		animals.add(new Snake("Snake"));
		animals.add(new Monkey("Monkey"));
		
		findWhoCanEatWho(animals);
		findWhoCanFly(animals);
		findWhoCantFly(animals);

	}
	
	/**
	 * Finds what animals can fly, prints them out and tells us that they can take off and land 
	 * 
	 * @param animals the ArrayList to be searched through to find the animals that can fly 
	 */
	private static void findWhoCanFly(ArrayList<Animal> animals) {
		System.out.println("");
		System.out.println("Animals that can fly:");
		for(Animal s: animals) { // Iterates through all animals in the array list 
			if (s.getWings()) {
				System.out.println(s.toString()); // Prints out the toString method from animal 
				if (s instanceof Bat) {
					Bat bat = (Bat)s;
					bat.takeOff();
					bat.land();
				}
				if (s instanceof Hawk) { // Checks if s is an instance of hawk 
					Hawk hawk = (Hawk)s;
					hawk.takeOff(); // Calls two methods which print out different information 
					hawk.land();
				}
			}
		}
	}
	
	/**
	 * Searches through the arraylist to find what animals can't fly and prints out the animal along with what action they can do 
	 * 
	 * @param animals The arraylist to be searched through to find the animals that can't fly 
	 */
	private static void findWhoCantFly(ArrayList<Animal> animals) {
		System.out.println("");
		System.out.println("Animals that can't fly:");
		for (Animal s: animals) {
			if (!s.getWings()) {
				System.out.println(s.toString());
				if (s instanceof Snake) { // checks to see if s is of type Snake 
					Snake snake = (Snake)s; // Typecasts s to a new variable of type Snake 
					snake.movement();
				}
				if (s instanceof Monkey) {
					Monkey monkey = (Monkey)s; // Type Casts s into a Monkey object 
					monkey.movement();
				}
			}
		}
	}
	
	/**
	 * Searches through the arraylist to find which animals can eat one another and prints it out as well as other information about the animals 
	 * 
	 * @param animals The ArrayList to be searched through to find the animals that can eat one another 
	 */
	private static void findWhoCanEatWho(ArrayList<Animal> animals) {
		System.out.println("Editable Animals:");
		for(Animal s: animals) { // Iterates through each animal twice which gives a Big O notation of O(n^2)
			for(Animal two: animals) { 
				if(s.eat(two)) { // Compares the two to see if "s" can eat "two"
					System.out.println(s.toString() + " and ate a " + two.getType());
				}
			}
		}
	}
}
