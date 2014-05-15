package charnetskaya.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Circle2DTest {

	private Circle2D circleA;

	@Before
	public void setUp() {

		circleA = new Circle2D(0, 0, 5);

	}

	@Test
	public void testGetArea() {
		double area = circleA.getArea();
		Assert.assertEquals(78.5, area, 0.1);
	}

	@Test
	public void testGetPerimeter() {
		double perimeter = circleA.getPerimeter();

		Assert.assertEquals(31.4, perimeter, 0.1);

	}

	@Test
	public void testContainsDoubleDouble() {
		boolean contains = circleA.contains(2.0, 2.0);
		Assert.assertTrue(contains);
	}

	@Test
	public void testContainsCircle2D() {
		Circle2D anotherCircle = new Circle2D();
		boolean inside = circleA.contains(anotherCircle);
		Assert.assertTrue(inside);
	}

	@Test
	public void testOverlaps() {
		Circle2D circleB;

		circleB = new Circle2D(1, 1, 5);
		boolean overlaps = circleA.overlaps(circleB);
		Assert.assertTrue(overlaps);

	}

}
