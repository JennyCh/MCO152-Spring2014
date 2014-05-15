package charnetskaya.subwaymap;

import java.awt.Color;

public class Route {

	private final String routeId;
	private final Color color;

	public String getRouteId() {
		return routeId;
	}

	public Color getColor() {

		return color;
	}

	public Route(String routeId, Color color) {
		super();
		this.routeId = routeId;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", color=" + color + "]";
	}

}
