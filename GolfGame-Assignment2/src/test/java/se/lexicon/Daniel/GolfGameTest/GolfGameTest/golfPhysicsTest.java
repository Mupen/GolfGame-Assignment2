package se.lexicon.Daniel.GolfGameTest.GolfGameTest;

import org.junit.Assert;
import org.junit.Test;


public class golfPhysicsTest{
	
	@Test
	public void test_getNextDistance() {
	double newDistance = GolfPhysics.getNextDistance(45, 60, 320);
	Assert.assertEquals(newDistance, -47.35, 0);
	}

}