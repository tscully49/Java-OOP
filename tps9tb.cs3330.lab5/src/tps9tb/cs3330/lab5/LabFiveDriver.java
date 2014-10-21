/**
 * Name: Thomas Scully
 * Date: 10/6/14
 * Section: D
 * Submission Code:
 */
package tps9tb.cs3330.lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class LabFiveDriver {
	private static ArrayList<Shape> shapes;
	private static Scanner userInput;
	
	/**
	 * Main takes in a number of shapes, then calls all other methods to fill the list of shapes, make calculations, and then print out and remove a shape with a certain color 
	 * 
	 * @param args Not used for the lab 
	 */
	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		System.out.print("Enter number of shapes to create: ");
		int size = Integer.parseInt(userInput.nextLine());
		initShapes(size);
		displayShapes();
		System.out.print("Enter a shape color to remove:");
		String shapeColor = userInput.nextLine();
		removeShape(shapeColor);
		displayShapes();
		userInput.close();
	}
	
	/**
	 * Initializes the array list of shapes and populates it depending on what the user enters and error checks the inputs a bit 
	 * 
	 * @param numberOfShapes The number of shapes to be added to the array list 
	 */
	public static void initShapes(int numberOfShapes) {
		shapes = new ArrayList<Shape>(); // instantiate the array lsit of shapes 
		int counter = 0;
		
		while(counter < numberOfShapes) { // Keep looping until you've made the correct number of shapes 
			System.out.print("Enter a shape: ");
			String in = userInput.nextLine(); // read in an input from user 
			
			
			
			String[] stringAr = in.split(" "); // Split the input up into smaller strings (tokenize by white spaces)
			
			if (stringAr[0].equals("circle") && stringAr.length == 3) { // Checks the length of the array of string and the first string to make sure it's a valid shape 
				shapes.add(new Circle(Integer.parseInt(stringAr[1]), stringAr[2].trim())); // If it is valid, create a new shape object and construct it based on the shape 
				counter++;
			}
			else if(stringAr[0].equals("square") && stringAr.length == 3) {
				shapes.add(new Square(Integer.parseInt(stringAr[1]), stringAr[2].trim()));
				counter++;
			}
			else if(stringAr[0].equals("rectangle") && stringAr.length == 4) {
				shapes.add(new Rectangle(Integer.parseInt(stringAr[1]), Integer.parseInt(stringAr[2]), stringAr[3].trim()));
				counter++;
			}
			else if(stringAr[0].equals("ellipse") && stringAr.length == 4) {
				shapes.add(new Ellipse(Integer.parseInt(stringAr[1]), Integer.parseInt(stringAr[2]), stringAr[3].trim()));
				counter++;
			}
			else {
				System.out.println("Invalid Shape! Try Again!"); // doesn't bump counter if input is invalid 
			}
		}
		
	}
	
	/**
	 * Prints out all shapes in the array list with area and perimeters 
	 */
	public static void displayShapes() {
		for (Shape s: shapes) { // loops through all shapes 
			System.out.println(s.toString());
		}
	}
	
	/**
	 * Removes the first shape in the array list with the designated color passed in to the method 
	 * 
	 * @param shapeColor The color to be checked for in the array list 
	 */
	public static void removeShape(String shapeColor) {
		int i;
		for (i=0; i < shapes.size(); ++i) { // checks through each shape in the array until the one with the color is found 
			if (shapes.get(i).getColor().equals(shapeColor)) {
				System.out.println(shapes.get(i).getColor());
				shapes.remove(i); // REmove the shape from the array list if it is found 
				return;
			}
		}
	}
}
