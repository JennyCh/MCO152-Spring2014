package charnetskaya.subwaymap;

public class Shape {

	private final String shapeId;
	private final double lat;
	private final double lon;

	public Shape(String shapeId, double lat, double lon) {
		super();
		this.shapeId = shapeId;
		this.lat = lat;
		this.lon = lon;
	}

	public String getShapeId() {
		return shapeId;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;

	}

	@Override
	public String toString() {
		return "Shape [shapeId=" + shapeId + ", lat=" + lat + ", lon=" + lon
				+ "]";
	}

}
