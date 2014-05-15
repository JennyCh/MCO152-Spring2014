package charnetskaya.subwaymap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes {

	private final List<Route> routes;

	public Routes() throws IOException {
		this.routes = new ArrayList<Route>();

		CSVReader in = new CSVReader(new FileReader("routes.txt"));

		String[] line;

		in.readNext();
		while ((line = in.readNext()) != null) {
			int color = 0;
			Color c = null;
			if (!"".equals(line[7])) {
				color = Integer.parseInt(line[7], 16);
				c = new Color(color);
			}
			routes.add(new Route(line[0], c));

		}
		/*
		 * for (Route r : routes) { System.out.println(r); }
		 */

	}

	public List<Route> getRoutes() {
		return routes;
	}

	public Color getColor(String routeId) {

		for (Route route : routes) {
			if (routeId.equalsIgnoreCase(route.getRouteId())) {
				return route.getColor();
			}
		}
		return null;
	}

}
