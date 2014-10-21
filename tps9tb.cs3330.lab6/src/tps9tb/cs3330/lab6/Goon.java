/**
 * Name: Thomas Scully
 * Date: 10/20/14
 * Section: D
 * Submission Code: Lab6
 */ 
package tps9tb.cs3330.lab6;

public class Goon {
	private String name;
	private String DOB;
	
	/**
	 * The constructor for Goon which gives it a name and DOB 
	 * 
	 * @param name the name to be given to the goon 
	 * @param DOB the Date of Birth to be given to this instance of goon 
	 */
	public Goon(String name, String DOB) {
		setName(name);
		setDOB(DOB);
	}
	
	/**
	 * Grabs the name of goon and returns it 
	 * 
	 * @return this.name This instance of the name for the goon will be returned 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the name for this instance of Goon 
	 * 
	 * @param name The name to be given to this instance of Goon 
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
	/**
	 * The getter for the date of birth of this instance of goon 
	 * 
	 * @return this.DOB this instance of the date of birth of Goon will be returned 
	 */
	public String getDOB() {
		return this.DOB;
	}
	
	/** 
	 * The setter for this instance of Goon 
	 * 
	 * @param DOB The date of birth that this instance of goon will be instantiated with 
	 */
	protected void setDOB(String DOB) {
		this.DOB = DOB;
	}
}
