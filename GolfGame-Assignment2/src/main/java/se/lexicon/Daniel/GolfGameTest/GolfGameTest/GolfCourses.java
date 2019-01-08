package se.lexicon.Daniel.GolfGameTest.GolfGameTest;

public class GolfCourses  {
	public static int hole(int meterage, int userScore) {
		int shotsDone = 0;
		double distance = meterage;
		double target = 1;

		System.out.println("The hole is " + meterage + " meter");
		//While loop allows the player to keep trying the hole until they get the ball in (within 30 centimeter ).
		while (Math.abs(distance) > target) {
			
			// If-else-if statement checks all the possible results of a shot that did not make it in 
			// and prints the appropriate message, absolute values it if it went past the hole and calls location methods.
			if (shotsDone == 0) {
				target = 2;
				System.out.println("Your ball is currently " + distance + " meter from the hole.");
				System.out.println("\nThis is stroke " + (shotsDone+1) + " at this hole.");
				distance = GolfTerrain.teeingGround(shotsDone, distance);
				
			} 
			
			else if (shotsDone == 1) {
				target = 2;
				System.out.println("Your ball is currently " + distance + " meter from the hole.");
				System.out.println("\nThis is stroke " + (shotsDone+1) + " at this hole.");
				distance = GolfTerrain.fairwayGround(shotsDone, distance);
				
			} 
			
			else if (Math.abs(distance) <= (Math.abs(distance)/100*100)) {
				target = 5;
				distance = Math.abs(distance);
				System.out.println("Your ball is past the hole and is currently " + distance + " meter from the hole.");
				System.out.println("\nThis is stroke " + (shotsDone+1) + " at this hole.");
				distance = GolfTerrain.midwayGround(shotsDone, distance);
				
			}
			
			else if (distance >= (distance/100*100)) {
				target = 5;
				System.out.println("Your ball is currently " + distance + " meter from the hole.");
				System.out.println("\nThis is stroke " + (shotsDone+1) + " at this hole.");
				distance = GolfTerrain.midwayGround(shotsDone, distance);
			} 

			else if (Math.abs(distance) <= (Math.abs(distance)/100*50))  {
				target = 5;
				distance = Math.abs(distance);
				System.out.println("<= abs 100 * 50 Your ball is past the hole and is currently " + distance + " meter from the hole.");
				System.out.println("\nThis is stroke " + (shotsDone+1) + " at this hole.");
				distance = GolfTerrain.lakesideGround(shotsDone, distance);
				
			}
			
			else if (distance >= (distance/100*50)) {
				target = 5;
				System.out.println(">= Your ball is currently " + distance + " meter from the hole.");
				System.out.println("\nThis is stroke " + (shotsDone+1) + " at this hole.");
				distance = GolfTerrain.lakesideGround(shotsDone, distance);
				
			} 
			
			else if (Math.abs(distance) <= (Math.abs(distance)/100*25))  {
				target = 10;
				distance = Math.abs(distance);
				System.out.println("Your ball is past the hole and is currently " + distance + " meter from the hole.");
				System.out.println("\nThis is stroke " + (shotsDone+1) + " at this hole.");
				distance = GolfTerrain.greenfieldGround(shotsDone, distance);
				target = 10;
			}
			
			else if (distance >= (distance/100*25)) {
				target = 10;
				distance = Math.abs(distance);
				System.out.println("Your ball is currently " + distance + " meter from the hole.");
				System.out.println("\nThis is stroke " + (shotsDone+1) + " at this hole.");
				distance = GolfTerrain.greenfieldGround(shotsDone, distance);
				
			} 
			
			// Remember the amount of shots and amount for the amount of par you have done.
			shotsDone += 1;
			userScore = shotsDone;
		}
		System.out.println(""
				+ "\nYou made it in the hole!"
				+ "\nYour score on this hole is:" + userScore);
		return userScore;
	}
}
