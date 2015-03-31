/**
 * Name: Thomas Scully
 * Date: 12/1/14
 * Section: D
 * Submission Code: FreeCandy
 */ 
package tps9tb.cs3330.lab11;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DensityA {
	
	public static void main(String[] args) {
		// Create the frame.
		JFrame frame = new JFrame("Test");	
		
		String alt = JOptionPane.showInputDialog(frame, "Enter the elevation (in feet) of the airport:");
		double new_alt = Double.parseDouble(alt);
		while (new_alt < 0) {
			JOptionPane.showMessageDialog(frame,  "Please enter a positive value", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			alt = JOptionPane.showInputDialog(frame, "Enter the elevation (in feet) of the airport:");
			new_alt = Double.parseDouble(alt);
		}
		
		String oat = JOptionPane.showInputDialog(frame, "Enter the outside air temperature at the airport (in Celcius):");
		double new_oat = Double.parseDouble(oat);
		while (new_oat < 0) {
			JOptionPane.showMessageDialog(frame,  "Please enter a positive value", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			oat = JOptionPane.showInputDialog(frame, "Enter the outside air temperature at the airport (in Celcius):");
			new_oat = Double.parseDouble(oat);
		}
		
		String aps = JOptionPane.showInputDialog(frame, "Enter the current air pressure at the airport:");
		double new_aps = Double.parseDouble(aps);
		while (new_aps < 0) {
			JOptionPane.showMessageDialog(frame,  "Please enter a positive value", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			aps = JOptionPane.showInputDialog(frame, "Enter the current air pressure at the airport:");
			new_aps = Double.parseDouble(aps);
		}
		
		double calc1 = ((new_oat-(15-(new_alt*0.002)))*120)+(((29.92-new_aps)*1000)+new_alt);
		
		String length = JOptionPane.showInputDialog(frame, "Enter the length of the runway at the airport:");
		double new_length = Double.parseDouble(length);
		while (new_length < 0) {
			JOptionPane.showMessageDialog(frame,  "Please enter a positive value", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			length = JOptionPane.showInputDialog(frame, "Enter the length of the runway at the airport:");
			new_length = Double.parseDouble(length);
		}
		
		String STD = JOptionPane.showInputDialog(frame, "Enter the STD take off distance (0 elevation) for your airplane:");
		double new_STD = Double.parseDouble(STD);
		while (new_STD < 0) {
			JOptionPane.showMessageDialog(frame,  "Please enter a positive value", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			STD = JOptionPane.showInputDialog(frame, "Enter the STD take off distance (0 elevation) for your airplane:");
			new_STD = Double.parseDouble(STD);
		}
		
		double reqLength = ((calc1/100)*10)+new_STD;
		DecimalFormat df = new DecimalFormat("0.00");
		String first = df.format(calc1);
		String second = df.format(reqLength);
		
		JOptionPane.showMessageDialog(frame, "The density altitude at this airport is currently " + first + "\nThe distance required for takeoff at this density altitude for your plane is " + second, "REPORT", JOptionPane.PLAIN_MESSAGE);
		
		if (reqLength <= new_length) {
			JOptionPane.showMessageDialog(frame, "CLEARED FOR TAKEOFF", "TAKEOFF", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(frame, "DO NOT TAKEOFF!!!!", "TAKEOFF", JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
