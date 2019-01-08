package se.lexicon.Daniel.GolfGameTest.GolfGameTest;

import java.util.Scanner;
import java.lang.Double;
import java.math.BigDecimal;
import java.math.RoundingMode; 

public class GolfPhysics {
	
	public static final double gravity = 9.8;
	public static final double PI = Math.PI;
	public static final double minAngle = Double.MIN_VALUE;
	public static final double maxAngle = 90 - Double.MIN_VALUE;
	public static final double minVelocity = Double.MIN_VALUE;
	public static final double maxVelocity = 9000;
	private static Scanner scanner = new Scanner(System.in);
	
	public static double getInputVelocity() {
		double inputVelocity;
		System.out.print("Please enter a Velocity [in m/s]: ");
		String stringInput = scanner.nextLine();
		try {
			inputVelocity = Double.parseDouble(stringInput);
			if (checkValidRange(inputVelocity, minVelocity, maxVelocity))
				return inputVelocity;
			else
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			return getInputVelocity();
		}
	}

	public static double getInputAngle() {
		double inputAngle;
		System.out.print("Please enter a Angle [1-90]: ");
		String stringInput = scanner.nextLine();
		try {
			inputAngle = Double.parseDouble(stringInput);
			if (checkValidRange(inputAngle, minAngle, maxAngle))
				return inputAngle;
			else
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			return getInputAngle();
		}
	}

	public static boolean checkValidRange(double theValue, double minValue, double maxValue) {
		if (Double.compare(minValue, theValue) >= Double.compare(theValue, maxValue)) {
			return true;
		}else
			System.out.println("Not a valid number or value remember it need to be between" + minValue + " and " + maxValue + "");
			return false;
	}
	
	public static double getNextDistance(double imputAngle, double inputVelocity, double distance) {
		
		// The math needed to calculate the value of the shot.
		double shotDistance = (Math.pow(inputVelocity, 2) / 9.8 * Math.sin(2 * Math.PI/180*imputAngle));
		
		distance = roundDecimal2(distance); 
		imputAngle = roundDecimal2(imputAngle); 
		inputVelocity = roundDecimal2(inputVelocity);
		shotDistance = roundDecimal2(shotDistance);
		
		//  Round the values so that they don't become ridiculous and save it to the score array.
		GolfGame.saveSwingScoreData(distance, imputAngle, inputVelocity, shotDistance);
		
		// This remove the distance you shot from the original value. and re round them.
		distance -= shotDistance;
		
		distance = roundDecimal2(distance); 
				
		// This is printed and then subtracted out of distance remaining.
		System.out.println("Your stroke went " + shotDistance + " meters.");
		
		// Return the value left on the current hole.
		return distance;
    }
	
	public static Double roundDecimal2(Double inputDouble) {
		// Round the double with a scale of 2
	    return new BigDecimal(inputDouble.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
	}

}
