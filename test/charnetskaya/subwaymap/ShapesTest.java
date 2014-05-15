package charnetskaya.subwaymap;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ShapesTest {

	@Test
	public void testConst() throws IOException {

		new Shapes();

	}

	@Test
	public void testGetShapes() throws IOException {
		final Shapes shapes = new Shapes();
		final List<Shape> shapeList = shapes.getShapes("1..S03R");
		Assert.assertNotNull(shapeList);
		Assert.assertEquals(266, shapeList.size());

	}

}
