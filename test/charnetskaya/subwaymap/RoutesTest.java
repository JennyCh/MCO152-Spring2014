package charnetskaya.subwaymap;

import java.awt.Color;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class RoutesTest {

	@Test
	public void setUpConstructor() throws IOException {
		new Routes();

	}

	@Test
	public void testGetColor() throws IOException {
		Routes routes = new Routes();
		Color color = new Color(238, 53, 46);
		Assert.assertEquals(color, routes.getColor("1"));
		color = new Color(153, 102, 51);
		Assert.assertEquals(color, routes.getColor("z"));
		Assert.assertNull(routes.getColor("h"));
	}

}
