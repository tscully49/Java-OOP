/**
 * Name: Thomas Scully
 * Date: 10/6/14
 * Section: D
 * Submission Code: no submission key
 */
package tps9tb.cs3330.lab5;

public class Circle extends Ellipse{
	
	/**
	 * The constructor for circle 
	 * 
	 * @param radius The radius to be passed into circle 
	 * @param color The color to be passed into the circle 
	 */
	public Circle(double radius, String color) {
		super(radius, radius, color); // calls the super constructor for all the attributes of circle 
	}
	
	/** 
	 * Returns a string of information from the circle such as area, perimeter and color 
	 * 
	 * @return newString Returns the concatenated string with information from the circle 
	 */
	public String toString() {
		String newString = "Circle " + super.getColor() + " " + super.calcArea() + " " + super.calcPerimeter(); // concatenates all of the information and returns it in the string 
		return newString;
	}
}