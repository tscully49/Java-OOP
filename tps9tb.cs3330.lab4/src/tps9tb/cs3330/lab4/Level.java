/**
 * Name: Thomas Scully
 * Date: 9/30/14
 * Section: D
 * Submission Code: FantasyFootball
 */
package tps9tb.cs3330.lab4;

import java.util.ArrayList;

public class Level {
	private ArrayList<Car> carsStored;
	private int numberOfParkingSpots;
	
	/**
	 * The constructor class for level which sets the parking 
	 * 
	 * @param numberOfParkingSpots
	 */
	public Level(int numberOfParkingSpots) {
		setNumberOfParkingSpots(numberOfParkingSpots);
	}
	
	/**
	 * Sets the number of parking spots for the level through a passed parameter 
	 * 
	 * @param numberOfParkingSpots
	 */
	private void setNumberOfParkingSpots(int numberOfParkingSpots) {
		carsStored = new ArrayList<Car>();
		this.numberOfParkingSpots = numberOfParkingSpots;
	}
	
	/**
	 * Checks to see if the level is full, if yes it returns true 
	 * 
	 * @return boolean Returns either true or false 
	 */
	public boolean isFull() {
		if (carsStored.size() >= numberOfParkingSpots) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Adds a car object to the current level that you are on 
	 * 
	 * @param incomingCar The car object to be passed into the level array list 
	 */
	public void addCar(Car incomingCar) {
		carsStored.add(incomingCar);
	}
	
}
