package charnetskaya.subwaymap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {

	private final List<Shape> shapes;
	private final double maxLat = 40.903125;
	private final double maxLon = -73.755405;
	private final double minLat = 40.512764;
	private final double minLon = -74.251961;
	private final double latLength;
	private final double lonLength;

	public Shapes() throws IOException {
		this.shapes = new ArrayList<Shape>();

		CSVReader in = new CSVReader(new FileReader("shapes.txt"));
		String[] line;
		in.readNext();
		while ((line = in.readNext()) != null) {
			double lat = Double.valueOf(line[1]);
			double lon = Double.valueOf(line[2]);
			Shape shape = new Shape(line[0], lat, lon);
			shapes.add(shape);

			// this.maxLat = Math.max(this.maxLat, shape.getLat());
			// this.maxLon = Math.max(this.maxLon, shape.getLon());
			// this.minLat = Math.min(this.minLat, shape.getLat());
			// this.minLon = Math.min(this.minLon, shape.getLon());
		}

		this.latLength = Math.abs(this.maxLat - this.minLat);
		this.lonLength = Math.abs(this.maxLon - this.minLon);

	}

	public List<String> getShapeIds() {
		List<String> shapeIds = new ArrayList<String>();
		// boolean found = false;
		for (Shape shape : shapes) {
			if (!shapeIds.contains(shape.getShapeId())) {
				shapeIds.add(shape.getShapeId());
			}

		}
		return shapeIds;
	}

	public List<Shape> getShapes(String shapeId) {
		List<Shape> shapesID = new ArrayList<Shape>();
		for (Shape shape : shapes) {
			if (shapeId.equals(shape.getShapeId())) {
				shapesID.add(shape);
			}
		}
		return shapesID;
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public double getMaxLat() {
		return maxLat;
	}

	public double getMaxLon() {
		return maxLon;
	}

	public double getMinLat() {
		return minLat;
	}

	public double getMinLon() {
		return minLon;
	}

	public double getLatLength() {
		return latLength;
	}

	public double getLonLength() {
		return lonLength;
	}

}
