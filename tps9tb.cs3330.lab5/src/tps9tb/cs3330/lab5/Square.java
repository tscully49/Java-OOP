/**
 * Name: Thomas Scully
 * Date: 10/6/14
 * Section: D
 * Submission Code: no submission key
 */
package tps9tb.cs3330.lab5;

public class Square extends Rectangle{
	/**
	 * The constructor of square 
	 * 
	 * @param size The size to be passed into square
	 * @param color The color to be passed into square 
	 */
	public Square(double size, String color) { 
		super(size, size, color); // the super constructor to fill the attributes with 
	}
	
	/** 
	 * Returns a string with information about the square such as the color, area, and perimeter
	 * 
	 * @newString The returned concatenated string with information about the square in it 
	 */
	public String toString() {
		String newString = "Square " + super.getColor() + " " + super.calcArea() + " " + super.calcPerimeter(); // concatenates the string with all of the information 
		return newString;
	}
}
