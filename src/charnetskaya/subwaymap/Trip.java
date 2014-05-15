package charnetskaya.subwaymap;

public class Trip {
	private final String routeId;
	private final String shapeId;

	public Trip(String routeId, String tripId, String shapeId) {
		super();

		this.routeId = routeId;
		this.shapeId = shapeId;
	}

	public String getRouteId() {
		return routeId;
	}

	public String getShapeId() {
		return shapeId;
	}

	@Override
	public String toString() {
		return "Trip [routeId=" + routeId + ", shapeId=" + shapeId + "]";
	}

}
