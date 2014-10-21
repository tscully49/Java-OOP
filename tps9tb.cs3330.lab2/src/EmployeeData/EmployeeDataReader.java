// Thomas Scully
package EmployeeData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeDataReader {
	String filePath;
	
	/**
	 * Constructor for EmployeeDataReader which sets the attributes
	 * 
	 * @param filePath The path for where the file is 
	 */
	public EmployeeDataReader(String filePath) {
		setFilePath(filePath);
	}
	
	/**
	 * Parses through the file line by line, breaks up the line, and inserts data into an Employee object array
	 * 
	 * @return EmployeeArray the Employee object array filled by the data in the file 
	 */
	public Employee[] getEmployeeData() {
		Employee[] EmployeeArray = new Employee[10];
		
		BufferedReader reader = null; // Sets the reader to null 
		
		try {
			File file = new File(getFilePath()); // Creates file pointer
			reader = new BufferedReader(new FileReader(file)); // Creates an instance of buffered reader 
			
			String line;
			int counter = 0;
			while ((line = reader.readLine()) != null && counter < 10) { // Parses through each line of the file until the end or until the counter reaches 10
				
				String[] tempString = line.split(","); // Creates a temporary string 
			
				EmployeeArray[counter] = new Employee(tempString[0], Integer.parseInt(tempString[1]), Double.parseDouble(tempString[2])); // Put the data in the object Employee
				counter++; 
			}
		}
		catch (IOException e) {
			e.printStackTrace(); // Catch any error and print it out 
		}
		finally {
			try {
				reader.close(); // Close the reader 
			}
			catch (IOException e) {
				e.printStackTrace(); // Print out any errors 
			}
		}
		
		return EmployeeArray;
	}
	
	/**
	 * Set this.filePath to the parameter filePath
	 * 
	 * @param filePath The location of the file being parsed
	 */
	private void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * Returns the filePath to the file being parsed
	 * 
	 * @return this.filePath returns the filepath of that instance of EmployeeDataReader
	 */
	private String getFilePath() {
		return this.filePath;
	}
}