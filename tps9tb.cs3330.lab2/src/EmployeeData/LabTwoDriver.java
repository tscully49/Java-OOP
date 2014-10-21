//Thomas Scully
package EmployeeData;

public class LabTwoDriver {
	
	/**
	 * Reads in employees from a file, prints out each name and age, prints off the highest paid employee, and prints off the total cost of each employee
	 * 
	 * @param args Args is nothing, it isn't used
	 */
	public static void main(String[] args) {
		EmployeeDataReader employeeDataReader = new EmployeeDataReader("EmployeeData/EmployeeData.csv");
		Employee[] employeeDatabase = employeeDataReader.getEmployeeData();
		displayEmployees(employeeDatabase);
		System.out.println("");
		Employee highestPaid = findHighestPaidEmployee(employeeDatabase);
	
		System.out.println("Highest Paid Employee is " + highestPaid.getName() + " at " + highestPaid.getSalary());
		System.out.println("Total Cost of All Employees is " +  totalCostOfAllEmployees(employeeDatabase));
		findBiggestAgeDifferenceBetweenEmployees(employeeDatabase);
	}
	
	/**
	 * Displays all Employee names and ages
	 * 
	 * @param employeeDatabase An object array of Employee objects
	 */
	public static void displayEmployees(Employee[] employeeDatabase) {
		for(Employee s: employeeDatabase) {
			System.out.println(s.getName() + " " + s.getAge());
		}
	}
	
	/**
	 * Finds the Employee with the highest salary and returns the employee with the highest salary
	 * 
	 * @param employeeDatabase An object array of Employee objects read in from a file 
	 * @return highPay The highest Salary from employeeDatabase
	 */
	public static Employee findHighestPaidEmployee(Employee[] employeeDatabase) {
		Employee highPay = employeeDatabase[0];
		
		for(Employee s: employeeDatabase) {
			if (s.getSalary() > highPay.getSalary()) {
				highPay = s;
			}
		}
		
		return highPay;
	}
	
	/**
	 * Adds up the Salary from each employee and returns it
	 * 
	 * @param employeeDatabase An object array of employee objects read in from a file 
	 * @return totalCost The total salary of each employee
	 */
	public static double totalCostOfAllEmployees(Employee[] employeeDatabase) {
		int totalCost = 0;
		
		for (Employee s: employeeDatabase) {
			totalCost += s.getSalary();
		}
		return totalCost;
	}
	
	/**
	 * Finds the biggest age difference between all employees and prints off the difference 
	 * 
	 * @param employeeDatabase An object array of employee objects read in from a file 
	 */
	public static void findBiggestAgeDifferenceBetweenEmployees(Employee[] employeeDatabase) {
		int biggestAge = 0;
		int smallestAge = 150;
		for(Employee s: employeeDatabase) {
			biggestAge = Math.max(biggestAge, s.getAge());
		}
		for(Employee s: employeeDatabase) {
			smallestAge = Math.min(smallestAge,  s.getAge());
		}
		System.out.println("BONUS: The greatest age difference between the youngest and oldest employees is: " + (biggestAge-smallestAge));
	}
}