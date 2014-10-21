package tps9tb.cs3330.lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class LabOneDriver {

	private static Scanner input;
	
	/**
	 * Count the number of occurrences for prefix, suffix, and substring 
	 * given a user input string compared against the strings stored in the file names.txt 
	 * 
	 * @param args Nothing is used from the args for this program
	 */
	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		String[] names = initArrayOfStrings("names.txt",10);
		displayArrayOfStrings(names);
		displaySortedArrayOfStrings(names);
		
		System.out.print("Enter a string to do comparison with: ");
		String search = input.nextLine();
		final int oldSchoolSubStrCnt = oldSchoolSubstringOccurrences(names,search);
		System.out.println("Manual substring search, found: " + oldSchoolSubStrCnt);
	
		final int oldSchoolPrefixCnt = oldSchoolPrefixOccurrences(names,search);
		System.out.println("Manual prefix search, found: " + oldSchoolPrefixCnt);
		
		System.out.println("Number of suffix found:" + countSuffixOccurrences(names,search));
		
		if (countPrefixOccurrences(names,search) != oldSchoolPrefixCnt) {
			System.out.println("You have an incorrect solution!");
		}
		
		if (countSubstringOccurrences(names,search) != oldSchoolSubStrCnt) {
			System.out.println("You have an incorrect solution!");
		}
		
		input.close();
	}
	
	/**
	 * Initializes the an array of Strings from a file located at the names.txt
	 * 
	 * @param filePath The location of the names used for the program
	 * @param num The number of records the program wants to read
	 * @return an array of strings that is populated
	 */
	public static String[] initArrayOfStrings(String filePath, int num) {
		
		String[] names = new String[num]; // create a blank array of strings.  Set the number of indexes to "num" passed to the method
		
		File file = new File(filePath); // Create an instance of the file from the passed "filePath"
			
		try { // Read in the file into indexes of the array.  Do this "num" times 
				
			Scanner sc = new Scanner(file);
				
			for (int i = 0; i < num; ++i) {
				String s = sc.nextLine();
				names[i] = s;
			}
			sc.close();
		}
		catch (FileNotFoundException e) { // If something goes wrong with reading the file, print out the last few
			e.printStackTrace();
		}
		
		return names; // Return the array of strings 
	}
	
	/**
	 * Displays the contents of the passed array of strings. If the array is
	 * empty will not display contents. 
	 * 
	 * @param arrayOfStrings That is populated with strings
	 */
	public static void displayArrayOfStrings(String[] arrayOfStrings) {
		if (arrayOfStrings == null) { // Checks to see if the array is NULL, and exits the method if it is 
			System.out.println("ARRAY IS NULL");
			return;
		}
		if (arrayOfStrings != null) { // If the array isn't NULL, loop through it and print out each string 
			System.out.println("Names stored in Array of Strings");
			for(String s: arrayOfStrings) {
				System.out.println(s); 
			}
			System.out.println(); // Print a gap between each list of strings 
		}
	}

	/**
	 * Displays the contents of the passed array of strings after sorting the string alphabetically.  If the array is empty, 
	 * nothing will be displayed
	 * 
	 * @param arrayOfStrings An array that is populated with strings 
	 */
	public static void displaySortedArrayOfStrings(String[] arrayOfStrings) {
		Arrays.sort(arrayOfStrings); // sorts the array in ascending order 
		if (arrayOfStrings == null) { // Checks to see if the array is NULL before starting to print things 
			System.out.println("ARRAY IS NULL");
			return; // Exits the method if the array is empty
		}
		System.out.println("Names stored in Array of Strings");
		for(String s: arrayOfStrings) { // Loops through the array and print out each string 
			System.out.println(s);
		}
	}
	/**
	 * Finds how many prefixes are found in the entire array of Strings.  If no prefixes are found, it will return 0, otherwise will
	 * return the number of prefixes found throughout the array of strings.  Only uses java functions charAt() and length()
	 * 
	 * @param arrayOfStrings An array of strings that will be checked
	 * @param prefix The string that will be searched for as a prefix throughout the array
	 * @return Returns the number of prefixes found, else returns 0 if none are found
	 */
	public static int oldSchoolPrefixOccurrences(String[] arrayOfStrings, String prefix) {
		int counter = 0; // sets the counter to 0 
		
		int substringLength = prefix.length(); // Creates a variable of how long the prefix is 
		
		for(String s: arrayOfStrings) { // loops through the array of strings 
			if (s.charAt(0) == prefix.charAt(0)) { // if the first letter of prefix and the string are the same, then search the rest of the string to see if they are the same 
				char[] test = new char[substringLength]; // create a character array of the length of the prefix 
				for(int j=0;j<substringLength;++j) { // loop through the next few letters depending on how long prefix is and fill the new character array
					test[j] = s.charAt(j); 
				}
				String newSubstring = new String(test); // converts the character array to a string 
				if (newSubstring.equals(prefix)) { // if the string and prefix are the same, then bump the counter 
					counter++;
				}
			}
		}
		return counter; // returns the number from the counter 
	}
	
	/**
	 * Finds how many substrings are found in the entire array of Strings.  If the substring isn't found throughout the whole array, it 
	 * will return 0, otherwise it will return the number of substrings found throughout the array.  Only uses java functions charAt() and length()
	 *  
	 * @param arrayOfStrings The array of strings that will be searched for the substring.  
	 * @param substring The substring that will be searched for throughout the array.
	 * @return Returns the number of prefixes found, else returns 0 if none are found.
	 */
	public static int oldSchoolSubstringOccurrences(String[] arrayOfStrings, String substring) {
		int counter = 0;
		int substringLength = substring.length(); // Creates a variable of how long the substring is 
		
		for (String s: arrayOfStrings) { // loops through the array of strings 
			int n = s.length(); // Sets "n" equal to the length of that particular string "s"
			for (int i=0 ; i<n ; ++i) { // Loops through each letter in the string 
				if (s.charAt(i) == substring.charAt(0) && i+substringLength<=n) { // if the first character of the substring and the current letter of the string "s" are the same, then go on 
					char[] test = new char[substringLength]; // creates an array of characters to create a string of size "substring" to compare with substring 
					for(int j=0;j<substringLength;++j) { // adds letters from s to the character array depending on how long the substring is 
						test[j] = s.charAt(i+j); 
					}
					String newSubstring = new String(test); // Converts the character array into a string
					if (newSubstring.equals(substring)) { // If that new string is equal to the substring, the counter is bumped 
						counter++;  
					}
				}
			}
		}
		
		return counter; // Returns the counter 
	}
	
	/**
	 * Searches for number of prefixes in the array of Strings using any java functions we know.  
	 * 
	 * @param arrayOfStrings  The array of strings that we will search for the prefix in 
	 * @param prefix  The prefix that we will use to search the array 
	 * @return  Returns the number of prefixes found within the array
	 */
	public static int countPrefixOccurrences(String[] arrayOfStrings, String prefix) {
		int counter = 0; // Sets the counter to 0 
		
		for(String s: arrayOfStrings) { // loops through the array of strings 
			if(s.startsWith(prefix)) { // checks to see if "s" starts with the string "prefix"
				counter++; // Bumps counter if the if statement passes 
			}
		}
		return counter; // Returns the counter 
	}
	
	/**
	 * Searches for the number of suffixes in the array of strings using any java function we know
	 * 
	 * @param arrayOfStrings  The array of strings that we will search for the suffix in
	 * @param suffix  The suffix that we will use to search the array
	 * @return  Returns the number of suffixes found within the array
	 */
	public static int countSuffixOccurrences(String[] arrayOfStrings, String suffix) {
		int count = 0; // Sets counter to 0 
		
		for (String s: arrayOfStrings) { // loops through the array of strings 
			if (s.endsWith(suffix)) { // Looks to see if the string "suffix" is at the end of "s" 
				count++; // Bumps the counter if the if statement passes 
			}
		}
		
		return count;  // Returns the counter 
	}
	
	/**
	 * Searches for the number of substrings in the array of strings using any java function we know
	 * 
	 * @param arrayOfStrings  The array of strings that we will search for the substring in 
	 * @param substring  The substring that we will use to search the array
	 * @return  Returns the number of substrings found within the array 
	 */
	public static int countSubstringOccurrences (String[] arrayOfStrings, String substring) {
		int counter = 0; // Sets counter to 0 
		
		/*for (String s: arrayOfStrings) {
			int n = s.length();
			for (int i=0 ; i<n ; ++i) {
				if (s.charAt(i) == substring.charAt(0) && i+substringLength<=n) {
					char[] test = new char[substringLength];
					for(int j=0;j<substringLength;++j) {
						test[j] = s.charAt(i+j);
					}
					String newSubstring = new String(test);
					if (newSubstring.equals(substring)) {
						counter++;
					}
				}
			}
		}*/
		
		for (String s: arrayOfStrings) { // Loops through the array of strings 
			if (s.contains(substring)) { // Checks to see if "substring" is anywhere within whatever "s" is at that time 
				counter++;
			}
		}
		return counter;
	}
}
