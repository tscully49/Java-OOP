/**
 * Name: Thomas Scully
 * Date: 10/20/14
 * Section: D
 * Submission Code: Lab6
 */ 
package tps9tb.cs3330.lab6;

public class Talent extends Goon{
	private String skill;
	
	/**
	 * The constructor for Talent which will establish the attributes with each parameter
	 * 
	 * @param name The name to be used for this instance of Talent 
	 * @param DOB The DOB to be used for this instance of Talent 
	 * @param skill The skill too be set to the skill attribute for Talent 
	 */
	public Talent (String name, String DOB, String skill) {
		super(name, DOB);
		setSkill(skill);
	}
	
	/**
	 * Gets the String getSkill and returns it 
	 * 
	 * @return this.skill Returns the attribute skill for this instance of Talent 
	 */
	public String getSkill() {
		return this.skill;
	}
	
	/**
	 * The setter for this instance of skill 
	 * 
	 * @param skill The parameter used to set the skill attribute for Talent 
	 */
	protected void setSkill(String skill) {
		this.skill = skill;
	}
}
