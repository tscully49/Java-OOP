/**
 * Name: Thomas Scully
 * Date: 10/6/14
 * Section: D
 * Submission Code: no submission key
 */
package tps9tb.cs3330.lab5;

import java.lang.Math;

public class Ellipse extends Shape{
	private double majorAxis;
	private double minorAxis;
	
	/**
	 * The constructor for the ellipse 
	 * 
	 * @param minorAxis The minor axis to be used 
	 * @param majorAxis the major axis to be used 
	 * @param color the color to be used 
	 */
	public Ellipse(double minorAxis, double majorAxis, String color) {
		super(color); // calls the constructor from super for color 
		setMinorAxis(minorAxis);
		setMajorAxis(majorAxis);
	}
	
	/**
	 * Sets the minor axis for ellipse 
	 * 
	 * @param minorAxis minorAxis The parameter to set the minor axis to 
	 */
	private void setMinorAxis(double minorAxis) {
		this.minorAxis=minorAxis;
	}
	
	/**
	 * Sets the major axis of ellipse 
	 * 
	 * @param majorAxis The major axis to be set for this instance 
	 */
	private void setMajorAxis(double majorAxis) {
		this.majorAxis=majorAxis;
	}
	
	/**
	 * Returns the minor axis of this instance of ellipse
	 *  
	 * @return this.minorAxis This instance of minor axis for the ellipse
	 */
	public double getMinorAxis() {
		return this.minorAxis;
	}
	
	/**
	 * REturns the major axis of this instance of ellipse
	 * 
	 * @return this.majorAxis This instance of major axis
	 */
	public double getMajorAxis() {
		return this.majorAxis;
	}
	
	/**
	 * Calculates and returns the area of this instance of ellipse
	 * 
	 * @return area The calculated area of the ellipse 
	 */
	public double calcArea() {
		double area = (Math.PI * getMajorAxis() * getMinorAxis()); // calculates the area 
		
		return area;
	}
	
	/**
	 * Calculates and returns the perimeter of this instance of ellipes
	 * 
	 * @return perimeter The calculated perimeter of ellipse 
	 */
	public double calcPerimeter() {
		double perimeter = ((2*Math.PI) * Math.sqrt((((Math.pow(getMajorAxis(),2)+(Math.pow(getMinorAxis(), 2))) / 2)))); // calculates the perimeter
		
		return perimeter;
	}
	
	/**
	 * REturns a string with information about the ellipse
	 * 
	 * @return String Returns the concatenated string with the color, area, and perimeter of the ellipse 
	 */
	public String toString() {
		
		String newString = "Ellipse "+ super.getColor() + " " + calcArea() + " " + calcPerimeter(); // concatenates the strings and attributes together 
		return newString;
	}
}
