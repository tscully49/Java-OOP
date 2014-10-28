/**
 * Name: Thomas Scully
 * Date: 10/27/14
 * Section: D
 * Submission Code: Bonus Week
 */ 
package tps9tb.cs3330.lab7;

public abstract class Animal {
	protected boolean legs;
	protected boolean wings;
	protected String type;
	
	/**
	 * The constructor for an animal, which sets the passed parameters to the attributes 
	 * 
	 * @param legs If the animal has legs or not 
	 * @param wings IF the animal has wings or not 
	 * @param type The type of animal that is being created 
	 */
	public Animal (boolean legs, boolean wings, String type) {
		setLegs(legs);
		setWings(wings);
		setType(type);
	}
	
	/**
	 * Sets a true or false if the animal has legs or not 
	 * 
	 * @param legs A true or false value if the animal has legs or not 
	 */
	protected void setLegs(boolean legs) {
		this.legs = legs;
	}
	
	/**
	 * Sets if the animal has wings or not 
	 * 
	 * @param wings A true or false value for if the animal has wings or not 
	 */
	protected void setWings(boolean wings) {
		this.wings = wings;
	}
	
	/**
	 * Sets the type of animal that is being created 
	 * 
	 * @param type The type of animal being created 
	 */
	protected void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the boolean value of if the animal has legs or not 
	 * 
	 * @return boolean Returns true or false for if the animal has legs or not 
	 */
	public boolean getLegs() {
		return this.legs;
	}
	
	/**
	 * Returns a boolean value if the animal has wings or not 
	 * 
	 * @return boolean Returns true or false depending on if the animal has wings or not 
	 */
	public boolean getWings() {
		return this.wings;
	}
	
	/**
	 * Gets the type of animal that is created 
	 * 
	 * @return this.type Returns the string of what type of animal is being created 
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * An abstract method of eat, which will be defined in a subclass 
	 * 
	 * @param food The animal object that is being eaten 
	 * @return boolean Returns true or false if the animal can be eaten or not 
	 */
	public abstract boolean eat(Animal food); 
	
	/**
	 * Returns a string of the animal type, if the animal has wings, and if it has feet 
	 * 
	 * @Return finalString The final concatenated String of everything listed above 
	 */
	public String toString() {
		String finalString = getType(); // Adds the animal type to the string and then 
		
		if (getWings()) {
			finalString += " has wings"; // Concatenates whether the animal has wings or not 
			if (getLegs()) {
				finalString += " and has legs"; // Same for legs
			}
			else {
				finalString += ", but no legs";
			}
		}
		else{
			finalString += " has no wings";
			if (getLegs()) {
				finalString += ", but has legs"; // Same for legs
			}
			else {
				finalString += " and no legs";
			}
		}
		return finalString; // Returns the whole concatenated string with all the information in it 
	}
}
