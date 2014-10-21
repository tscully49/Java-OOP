/**
 * Name: Thomas Scully
 * Date: 10/20/14
 * Section: D
 * Submission Code: Lab6
 */ 
package tps9tb.cs3330.lab6;

public class Don extends Goon {
	private String mobName;
	private int netWorth;
	
	/**
	 * The constructor for this instance of Don 
	 * 
	 * @param name The name that this instance will receive 
	 * @param DOB The DOB that this instance of Don will receive 
	 * @param mobName The name of the mob for this Don object 
	 * @param newWorth the newWoth of this Don object that will be instantiated 
	 */
	public Don(String name, String DOB, String mobName, int newWorth) {
		super(name, DOB);
		setMobName(mobName);
		setNetWorth(netWorth);
	}
	
	/**
	 * Returns the networth of this instance of Don 
	 * 
	 * @return this.netWorth Returns the integer of netWorth for this instance of netWorth
	 */
	public int getNetWorth() {
		return this.netWorth;
	}
	
	/**
	 * Sets the attribute netWorth for this instance of Don
	 * 
	 * @param netWorth The integer for nerWorth will be returned 
	 */
	protected void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
	}
	
	/**
	 * Gets the String modName from the Don object 
	 * 
	 * @return this.mobName Returns mobName from this instance of Don 
	 */
	public String getMobName() {
		return this.mobName;
	}
	
	/**
	 * Sets the mobname for this instance of Don
	 * 
	 * @param mobName The String mobName to set this instance of Don with 
	 */
	protected void setMobName(String mobName) {
		this.mobName = mobName;
	}
}