/**
 * Name: Thomas Scully
 * Date: 10/6/14
 * Section: D
 * Submission Code: no submission key
 */
package tps9tb.cs3330.lab5;

public class Rectangle extends Shape{
	private double width;
	private double height;
	
	/**
	 * The constructor for rectangle 
	 * 
	 * @param width The width to be used 
	 * @param height The height to be used 
	 * @param color The color to be used 
	 */
	public Rectangle(double width, double height, String color) {
		super(color);
		setWidth(width);
		setHeight(height);
	}
	
	/**
	 * Sets the width of the rectangle 
	 * 
	 * @param width The parameter to be used for the width 
	 */
	private void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * Sets the height of the rectangle
	 * 
	 * @param height The parameter to be used for the height 
	 */
	private void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * REturns the width of the rectangle 
	 * 
	 * @return this.width This instance of rectangle's width 
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * Returns the width of the rectangle
	 * 
	 * @return this.height This instance of height from rectangle 
	 */
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * Calculates and returns the area of the rectangle 
	 * 
	 * @return area The calculated area of the rectangle 
	 */
	public double calcArea() {
		double area = (getWidth() * getHeight()); // Calculates the area of the rectangle 
		
		return area;
	}
	
	/**
	 * Calculates and returns the perimeter of the rectangle 
	 * 
	 * @return perimeter The calculated perimeter of the rectangle 
	 */
	public double calcPerimeter() {
		double perimeter = (2*(getWidth())+(2*(getHeight()))); // Calculates the perimeter of the rectangle 
		
		return perimeter;
	}
	
	/**
	 * REturns a string of concatenated information from the rectangle 
	 * 
	 * @return newString The concatenated string of information on the rectangle 
	 */
	public String toString() {
		String newString = "Rectangle " + super.getColor() + " " + calcArea() + " " + calcPerimeter(); // concatenates the string with color, area, and perimeter
		return newString;
	}
}
