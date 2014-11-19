/**
 * Name: Thomas Scully
 * Date: 11/3/14
 * Section: D
 * Submission Code: AdvanceWars
 */ 
package tps9tb.cs3330.lab8;

import java.text.DecimalFormat;

public class Person {
	private String name;
	private int age;
	private double bankAccountBalance;
	
	/**
	 * The constructor for Person which sets all of the variables 
	 * 
	 * @param age the integer age to be put into this instance of Person 
	 * @param name The string Name to be put into this instance of Name 
	 * @param bankAccountBalance the double balance to be put into this instance of Balance 
	 */
	public Person(int age, String name, double bankAccountBalance) {
		setAge(age);
		setName(name);
		setBankAccountBalance(bankAccountBalance);
	}
	
	/**
	 * SEts the attribute Age to the passed parameter after its been error checked 
	 * 
	 * @param age The integer to be put into the attribute age for this instance 
	 */
	private void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Sets the attribute name to the passed parameter after its been error checked 
	 * 
	 * @param name The name to be put into the attribute name for this instance 
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the attribute balance to the passed parameter after its been error checked 
	 * 
	 * @param bankAccountBalance The balance to be put into the attribute balance for this instance
	 */
	private void setBankAccountBalance(double bankAccountBalance) {
		this.bankAccountBalance = bankAccountBalance;
	}
	
	/**
	 * Gets this instance of the age and returns it 
	 * 
	 * @return Returns this instance of age 
	 */
	protected int getAge() {
		return this.age;
	}
	
	/**
	 * Gets this instance of the name and returns it 
	 * 
	 * @return Returns this instance of name
	 */
	protected String getName() {
		return this.name;
	}
	
	/**
	 * Gets this instance of the balance and returns it 
	 * 
	 * @return Returns this instance of bankAccountBalance 
	 */
	protected double getBankAccountBalance() {
		return this.bankAccountBalance;
	}
	
	/**
	 * Returns a concatenated string of information of each instance of the array list of Person 
	 * 
	 * @return Returns the concatenated string of name, balance, and age for everyone in the person array list 
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "\nName: " + getName() + "\nAge: " + getAge() + "\nAccount Balance: $" + df.format(getBankAccountBalance()); // Concatenates the information together and returns it 
	}
}
