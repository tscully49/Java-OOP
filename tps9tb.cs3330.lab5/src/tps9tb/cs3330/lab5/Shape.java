/**
 * Name: Thomas Scully
 * Date: 10/6/14
 * Section: D
 * Submission Code: no submission key
 */
package tps9tb.cs3330.lab5;

public class Shape {
	private String color;
	
	/**
	 * Constructor for shape, sets the color of the shape 
	 * 
	 * @param color The color for shape to be made to 
	 */
	public Shape(String color) {
		setColor(color);
	}
	
	/**
	 * Sets the color of this instance of shape to the paramter
	 *  
	 * @param color The color to make this shape 
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * The get method for the color of this shape 
	 * 
	 * @return this.color Returns this instance of the shape's color 
	 */
	public String getColor() {
		return this.color;
	}
}
