/**
 * Name: Thomas Scully
 * Date: 10/20/14
 * Section: D
 * Submission Code: Lab6
 */ 
package tps9tb.cs3330.lab6;

public class Overseer extends Goon{
	private String sector;
	
	/**
	 * The constructor for the Overseer class 
	 *  
	 * @param name the name that will be given to this instance of Overseer
	 * @param DOB The date of birth that will be given to this instance of Overseer 
	 * @param sector The sector that will be given to this instance of Overseer
	 */
	public Overseer(String name, String DOB, String sector) {
		super(name, DOB);
		setSector(sector);
	}
	
	/**
	 * Returns the sector of this instance of Overseer
	 * 
	 * @return this.sector Returns the sector from this instance of Overseer
	 */ 
	public String getSector() {
		return this.sector;
	}
	
	/**
	 * Sets the sector of this instance of Overseer to the passes parameter
	 * 
	 * @param sector The string of sector that will be set to the sector attribute for the Overseer
	 */
	protected void setSector(String sector) {
		this.sector = sector;
	}

}
