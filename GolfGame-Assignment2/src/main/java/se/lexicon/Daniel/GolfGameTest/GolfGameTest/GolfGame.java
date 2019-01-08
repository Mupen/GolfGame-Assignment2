package se.lexicon.Daniel.GolfGameTest.GolfGameTest;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class GolfGame {
	public static double[][] savedGolfData;
	public static Random rng = new Random();
	static int userScore = 0;
    static Scanner keyboard = new Scanner(System.in);
    public static void main( String[] args ) {
    	boolean keepLooping = true;
    	
    	while(keepLooping) {
    		String selection = getScannerInput(
    				"\n------------------ Menu ------------------\n" + 
    				"Start = Start the selection of golf course.\n" + 
    				"Help = Find out tips about how to play the game.\n" +
    				"Quit = Immediately terminate the game.\n" +
    				"Your selection: "
    				);

    		switch (selection.toLowerCase()) {
			case "start":
				savedGolfData = new double[0][4]; // used to reset the values of the array so it don't have values or null
				keepLooping = startGolfGame(); // call a method that will give you option of golf courses
				break;
			case "help":
				keepLooping = tutorialGolfGame(); // call a method that write out a list of tutorial message and replay the while loop
				break;
			case "quit":
				keepLooping = quitGolfGame(); // call a method that write out a message and quit the game
				break;
			default:
				break;
			}
    	}
    }

	private static boolean startGolfGame() { 
    	boolean keepLoopingSelection = true;
    	boolean keepLooping = true;
    	
    	while(keepLoopingSelection) {
    		String selection = getScannerInput(
        			"\n------------ Selection ------------\n" + 
        			"Quit = Immediately terminate the game.\n" + 
        			"Menu = Go back to the game menu.\n" + 
        			"Tiny = Select the smallest course.\n" +
        			"Medium = Select the normal course.\n" +
        			"Huge = Select the ridiculous big course.\n" +
        			"Random = walk around and shoot randomly.\n" +
        			"Your selection: "
        		);
    		
    		switch (selection.toLowerCase()) {
			case "quit":
				keepLoopingSelection = false;
				keepLooping = quitGolfGame();
				break;
			case "menu":
				keepLoopingSelection = false;
				break;
			case "tiny": // start tiny golf curse loop
				for (int loop = 0; loop <= 3; loop++) {
					System.out.println("Hole " + (loop + 1));
					
					//One arrays holding the necessary information on each of the holes.
					int[] meterage = {320, 440, 560, 680};
					userScore += GolfCourses.hole(meterage[loop], userScore);
					System.out.println("Your score for the round so far is: " + userScore + "\n");
				}
				break;
			case "medium": // start medium golf curse loop
				for (int loop = 0; loop <= 7; loop++) {
					System.out.println("Hole " + (loop + 1));
					
					//Two arrays holding the necessary information on each of the 18 holes.
					int[] meterage = {320, 440, 560, 680, 700, 820, 1000, 1120};
					userScore += GolfCourses.hole(meterage[loop], userScore);
					System.out.println("Your score for the round so far is: " + userScore + "\n");
				}
				break;
			case "huge": // start huge golf curse loop
				for (int loop = 0; loop <= 11; loop++) {
					System.out.println("Hole " + (loop + 1));
					
					//Two arrays holding the necessary information on each of the 18 holes.
					int[] meterage = {320, 440, 560, 680, 700, 820, 940, 1060, 1180, 1200, 1320, 1440};
					userScore += GolfCourses.hole(meterage[loop], userScore);
					System.out.println("Your score for the round so far is: " + userScore + "\n");
				}
				break;
			default:
		    	System.out.println("\nA valid response was not entered.");
		    	keepLoopingSelection = true;
				break;
			}
    		printSwingScoreData();
    	}
    	return keepLooping;
	}
	
	private static boolean tutorialGolfGame() { 
		System.out.println("##########################################################");
		System.out.println("#### Welcome To Extream Golf Sports Alpha!, Tutorial! ####");
		System.out.println("##########################################################");
		System.out.println("First thing to remember is that golf is a serious sport" 
						+"\n"+ "that have a lot of hidden dangers in it."+"\r\n" );		
			
		System.out.println("1st: First upp is gravity that is 9.8 in the location we" 
						+"\n"+ "will be playing in. With that knowledge and the fact that" 
						+"\n"+ "you are the one that can control the angle and the velocity" 
						+"\n"+ "speed of the golf ball you should be able to do the math" 
						+"\n"+ "in your head… Nerd!"+"\r\n" );
			
		System.out.println("2th: Second is the fact that weather is a thing and" 
						+"\n"+ "sometimes it will just screw with you applying a" 
						+"\n"+ "unwanted modifier to your calculator i know you" 
						+"\n"+ "have in your pocket."+"\r\n" );
			
		System.out.println("3th: Third is that all ground is not equal" 
						+"\n"+ "depending on the angle and friction of the ground you" 
						+"\n"+ "can have you perfect 45 angle and 56 m/s speed" 
						+"\n"+ "be hit the ground of 320 but roll based" 
						+"\n"+ "on a unknown modifier."+"\r\n" );
			
		System.out.println("4th: in some of the taller grass they exist Hipsters" 
						+"\n"+ "and they have created a lot of problems disturbing guest around" 
						+"\n"+ "here. But we have found a solution to that. If any one" 
						+"\n"+ "of them would try to disturb you remember to just pick up you" 
						+"\n"+ "mobile and start playing nickelback as loud as you" 
						+"\n"+ "can and they will run away if they don't want their" 
						+"\n"+ "faces to be melted like the natzi in Indiana Jones."+"\r\n" );
			
		System.out.println("5th: And when the last one ensure you don't go to close" 
						+"\n"+ "to the lakes. I have heard reports that cthulhu is on summer break" 
						+"\n"+ "and is sleeping off a hangover around this location." 
						+"\n"+ "if he would wake up. Scream as loud as you can with the" 
						+"\n"+ "voice of a 10 year child that was just was informed that" 
						+"\n"+ "santa is a lie. "+"\r\n" );
		
   		boolean keepLooping = true;
   		return keepLooping;
	}
	
	public static void saveSwingScoreData(double distance, double imputAngle, double inputVelocity, double shotDistance) {
		savedGolfData = Arrays.copyOf(savedGolfData, savedGolfData.length + 1); // add one row for the new stroke
		double[][] scoreData = new double[1][4];
		scoreData[0][0] = imputAngle;
		scoreData[0][1] = inputVelocity;
		scoreData[0][2] = shotDistance;
		scoreData[0][3] = distance; 
		System.arraycopy(scoreData, 0, savedGolfData, savedGolfData.length - 1, scoreData.length);// add scoreData to saveSwingScoreData
	}
	
	private static void printSwingScoreData() {
		System.out.println("Game History\n");
		System.out.println("Your final score for the round is: " + userScore);
		System.out.println("Totally " + savedGolfData.length + " number of swings");
		System.out.format("+--------------+-----------------+----------------+------------+%n");
		System.out.format("|  imputAngle  |  inputVelocity  |  shotDistance  |  Distance  |%n");
		System.out.format("+--------------+-----------------+----------------+------------+%n");
		for (double[] swingData : savedGolfData) {
			 System.out.println("|      " + swingData[0] + "      |       " + swingData[1] + "       |       " + swingData[2] + "       |     " + swingData[3] + "     |"); 
			    
		}
		System.out.format("+---------+--------------+-----------------+----------------+------------+%n");
	}

	private static boolean quitGolfGame() {
   		System.out.print("Thanks for playing!\n" + "Terminating program...\n");
   		boolean keepLooping = false;
   		return keepLooping;
	}
	
    public static String getScannerInput(String inputString) {
        System.out.print(inputString);
        return keyboard.nextLine();
    }
    
    public static double parseStringToDouble(String inputString) {
		if(inputString.equals(null) || inputString.equals("") || !inputString.matches("[0-9]+")) {
			System.out.println("Not a valid input...");
			return parseStringToDouble(getScannerInput("Please enter a valid input: " + "of " + getScannerInput("Please enter a input name")));
		}
		else {
			double doubleNumber = Double.parseDouble(inputString);
			return doubleNumber;
		}
    }
}
