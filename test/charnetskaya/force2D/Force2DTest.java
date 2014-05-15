package charnetskaya.force2D;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Force2DTest {

	private Force2D force;
	private Force2D force2;

	@Before
	public void setUp() throws Exception {
		force = new Force2D(5.0, 5.0);
		force2 = new Force2D(5, 5);

	}

	@Test
	public void testGetMagnitude() {
		double magnitudeRecieved = force.getMagnitude();
		double assumedMagnitude = 7.0710678118654755;

		Assert.assertTrue(assumedMagnitude == magnitudeRecieved);
	}

	@Test
	public void testGetAngle() {
		double angleRecieved = force.getAngle();
		double assumedAngle = 45.0;

		Assert.assertTrue(assumedAngle == angleRecieved);
	}

	@Test
	public void testAddForce() throws Exception {
		Force2D addedForce = force.add(new Force2D(3.0, 3.0));
		double addedX = 8.0;
		double addedY = 8.0;

		Assert.assertTrue(addedForce.getX() == addedX
				&& addedForce.getY() == addedY);
	}
}
