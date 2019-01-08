package se.lexicon.Daniel.GolfGameTest.GolfGameTest;

public class GolfTerrain {
	
	//Method that is run for every shot not in the green.
	
	public static double teeingGround(int shotsDone, double distance) {
		System.out.println(""
				+ "\nYou are at the tee at the start of the golf course."
				+ "\nBecouse you are shooting from a tee so will the swing"
				+ "\nHave a boosted velocity and angle.");
		
		double imputAngle = GolfPhysics.getInputAngle();
		double inputVelocity = GolfPhysics.getInputVelocity();
		
		return distance = GolfPhysics.getNextDistance(imputAngle, inputVelocity, distance);
		
	}
	
	public static double fairwayGround(int shotsDone, double distance) {
		System.out.println(""
				+ "\nYou are at the lie this spot is known for hazard terrain."
				+ "\nIt is wise to shoot with a greater angle if you dont want to risk your ball.");
		
		double imputAngle = GolfPhysics.getInputAngle();
		double inputVelocity = GolfPhysics.getInputVelocity();
		
		return distance = GolfPhysics.getNextDistance(imputAngle, inputVelocity, distance);
		
	}
	
	public static double midwayGround(int shotsDone, double distance) {
		System.out.println(""
				+ "\n nothing about the terrain seems to be disturbing your swing."
				+ "\nit is just you with your balls.");
		
		double imputAngle = GolfPhysics.getInputAngle();
		double inputVelocity = GolfPhysics.getInputVelocity();
		
		return distance = GolfPhysics.getNextDistance(imputAngle, inputVelocity, distance);
		
	}
	
	public static double lakesideGround(int shotsDone, double distance) {
		System.out.println(""
				+ "\n The small lakes do not seem to be disturbing you.");
		
		double imputAngle = GolfPhysics.getInputAngle();
		double inputVelocity = GolfPhysics.getInputVelocity();
		
		return distance = GolfPhysics.getNextDistance(imputAngle, inputVelocity, distance);
		
	}
	
	public static double greenfieldGround(int shotsDone, double distance) {
		System.out.println(""
				+ "\n The terrain is flat and smooth you are quite."
				+ "\n Sure that as long as the ball is 10 m from the holl you will"
				+ "\n definitely succeed");
		
		double imputAngle = GolfPhysics.getInputAngle();
		double inputVelocity = GolfPhysics.getInputVelocity();
		
		return distance = GolfPhysics.getNextDistance(imputAngle, inputVelocity, distance);
		
	}
}



