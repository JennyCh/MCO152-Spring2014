package charnetskaya.triangle;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void testFor3() {
		String expected = "  *\n * *\n*****\n";
		Triangle triangle;

		triangle = new Triangle(3);
		Assert.assertEquals(expected, triangle.toString());

	}

	@Test
	public void testFor5() {
		String expected = "    *\n   * *\n  *   *\n *     *\n*********\n";
		Triangle triangle;

		triangle = new Triangle(5);
		Assert.assertEquals(expected, triangle.toString());

	}

}
