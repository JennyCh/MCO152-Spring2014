package charnetskaya.subwaymap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;

public class ShapeView extends JComponent {
	private final Trips trips;
	private final Routes routes;
	private final Shapes shapes;

	public ShapeView(Trips trips, Routes routes, Shapes shapes) {
		this.trips = trips;
		this.routes = routes;
		this.shapes = shapes;
	}

	@Override
	public void paintComponent(Graphics pen) {
		Graphics2D pen2D = (Graphics2D) pen;

		int height = getHeight();

		double minLon = this.shapes.getMinLon();
		double maxLat = this.shapes.getMaxLat();
		double latLength = this.shapes.getLatLength();
		double lonLength = this.shapes.getLonLength();
		List<String> shapeIds = this.shapes.getShapeIds();
		for (String shapeId : shapeIds) {

			List<Shape> list = this.shapes.getShapes(shapeId);

			Trip trip = this.trips.getTrip(shapeId);
			if (trip != null) {
				Color color = this.routes.getColor(trip.getRouteId());
				pen2D.setColor(color);
				for (int i = 1; i < list.size(); i++) {
					Shape a = list.get(i - 1);
					Shape b = list.get(i);

					int x1 = (int) ((a.getLon() - minLon) / lonLength * height);
					// System.out.println(a.getLon() + " " + minLon + " "
					// + lonLength + " " + height);
					int y1 = (int) ((maxLat - a.getLat()) / latLength * height);
					// System.out.println(maxLat + " " + a.getLat() + " "
					// + latLength);
					int x2 = (int) ((b.getLon() - minLon) / lonLength * height);
					// System.out.println(b.getLon() + " " + minLon +
					// lonLength);
					int y2 = (int) ((maxLat - b.getLat()) / latLength * height);
					// System.out.println(maxLat + " " + b.getLat() + " "
					// + latLength);

					pen2D.drawLine(x1, y1, x2, y2);

				}
			}

		}
	}
}
