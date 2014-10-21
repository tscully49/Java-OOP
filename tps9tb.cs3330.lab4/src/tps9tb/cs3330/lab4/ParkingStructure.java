/**
 * Name: Thomas Scully
 * Date: 9/30/14
 * Section: D
 * Submission Code: FantasyFootball
 */
package tps9tb.cs3330.lab4;

import java.util.ArrayList;

public class ParkingStructure {
	private ArrayList<Level> levels;
	
	/**
	 * The constructor for the parking structure 
	 * 
	 * @param numberOfLevels The number of levels passed into the parking structure 
	 */
	public ParkingStructure(int numberOfLevels) {
		setLevels(numberOfLevels);
	}
	
	/**
	 * Sets the levels for the parking garage based on the passed parameter 
	 * 
	 * @param numberOfLevels The number of levels passed into the parking structure 
	 */
	private void setLevels(int numberOfLevels) {
		levels = new ArrayList<Level>();
		
		if (numberOfLevels > 0) {
			for (int i = 1; i < numberOfLevels+1; ++i) {
				levels.add(new Level(10));
			}
		}
		else {
			levels.add(new Level(10));
			levels.add(new Level(10));
		}
	}
	
	/**
	 * Checks to see if the entire parking structure is full 
	 * 
	 * @return boolean Returns true or false depending on if the garage is full 
	 */
	public boolean isFull() {
		for (Level s: levels) {
			if (!s.isFull()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Adds a car to the parking garage on a level that isn't full 
	 * 
	 * @param incomingCar The car object to be added to the parking garage
	 * @return i+1 Returns the level that the car 
	 */
	public int addCar (Car incomingCar) {
		int i = 1;
		for(Level s: levels) {
			if(!(s).isFull()) {
				(s).addCar(incomingCar);
				return i;
			}
			i++;
		}
		return i;
	}
}
