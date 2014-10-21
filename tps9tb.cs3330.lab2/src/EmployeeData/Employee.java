//Thomas Scully
package EmployeeData;

public class Employee {
	private String name;
	private int age;
	private double salary;
	
	/**
	 * The Constructor for Employee which sets all the attributes 
	 * 
	 * @param name the name to be put into Employee
	 * @param age the age to be put into Employee
	 * @param salary the salary to be put into Employee 
	 */
	Employee (String name, int age, double salary) {
		setName(name);
		setAge(age);
		setSalary(salary);
	}
	
	/**
	 * Sets the attribute salary to the parameter if salary is above 0, otherwise sets to a given number 
	 * 
	 * @param salary The salary to be put into the attribute 
	 */
	private void setSalary (double salary) {
		if (salary > 0) {
			this.salary = salary;
		}
		else {
			this.salary = 25000;
		}
	}
	
	/**
	 * Sets the attribute age to the parameter if age is below 150 or greater than or equal to 18, otherwise sets it to a given number 
	 * 
	 * @param age The age to be put into the attribute
	 */
	private void setAge(int age) {
		if (age < 150 && age >= 18) {
			this.age = age;
		}
		else {
			this.age = 18;
		}
	}
	
	/**
	 * Sets the attribute name to the parameter 
	 * 
	 * @param name The name to be put into the attribute 
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the Employee
	 * 
	 * @return this.name Returns the attribute name 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the age of the Employee
	 * 
	 * @return this.age Returns the attribute name 
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Returns the salary of the Employee
	 * 
	 * @return this.salary Returns the attribute salary
	 */
	public double getSalary() {
		return this.salary;
	}
	
}