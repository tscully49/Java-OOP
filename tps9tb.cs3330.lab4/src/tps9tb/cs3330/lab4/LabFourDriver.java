/**
 * Name: Thomas Scully
 * Date: 9/30/14
 * Section: D
 * Submission Code: FantasyFootball
 */
package tps9tb.cs3330.lab4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class LabFourDriver {
	
	private static Scanner userInput;
	private static Random randomGenerator;
	private static ArrayList<String> carMakes;
	private static ArrayList<String> carTypes;
	private static ArrayList<String> carColors;
	
	
	/**
	 * The main function for the lab, takes in an input for levels and fills in cars for each level
	 * 
	 * @param args Isn't used for this lab 
	 */
	public static void main(String[] args) {
		initAttributes();
		
		System.out.print("Enter number of parking structure levels: ");
		String input = userInput.nextLine();
		System.out.println(" ");
		
		ParkingStructure parkingStructure = new ParkingStructure(Integer.parseInt(input));
		
		while (!parkingStructure.isFull()) {
			Car incomingCar = createCar();
			System.out.println(incomingCar.getMake()
					+ " " + incomingCar.getType()/*Typo in the document, put model instead of type*/ + " " + incomingCar.getColor());
			int storageLevel = parkingStructure.addCar(incomingCar);
			System.out.println("Car Stored at level " + storageLevel);
			System.out.println(" ");
		}

		
	}
	
	/**
	 * Initializes all attributes for the lab, and sets the make, type, and color for each array list 
	 */
	private static void initAttributes() {
		randomGenerator = new Random(1337);
		userInput = new Scanner(System.in);
		
		carMakes = new ArrayList<String>();
		carMakes.add(new String("Ford"));
		carMakes.add(new String("Toyota"));
		carMakes.add(new String("Dodge"));
		carMakes.add(new String("Honda"));
		
		carTypes = new ArrayList<String>();
		carTypes.add(new String("Sedan"));
		carTypes.add(new String("Truck"));
		carTypes.add(new String("Van"));
		carTypes.add(new String("Hatchback"));
		
		carColors = new ArrayList<String>();
		carColors.add(new String("Blue"));
		carColors.add(new String("Green"));
		carColors.add(new String("Red"));
		carColors.add(new String("Purple"));
		carColors.add(new String("Orange"));
		carColors.add(new String("Yellow"));
	}
	
	/**
	 * Creates a new car object and sets a random make, type, and color for the car 
	 * 
	 * @return newCar Returns a new object of car 
	 */
	private static Car createCar() {
		int a = randomGenerator.nextInt(carMakes.size());
		int b = randomGenerator.nextInt(carTypes.size());
		int c = randomGenerator.nextInt(carColors.size());
		
		Car newCar = new Car(carTypes.get(b), carColors.get(c), carMakes.get(a));
		return newCar;
	}
}
