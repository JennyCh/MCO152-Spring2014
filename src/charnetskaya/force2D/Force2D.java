package charnetskaya.force2D;

public class Force2D {

	private final double x;
	private final double y;

	/*
	 * public Force2D(Integer x, Integer y) throws NullPointerException { if (x
	 * == null || y == null) { throw new NullPointerException(
	 * "null data passed to Force2D constructor"); } else { this.x = (double) x;
	 * this.y = (double) y; } }
	 */

	public Force2D(double x, double y) {

		this.x = x;
		this.y = y;

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		return Math.sqrt(x * x + y * y);
	}

	public double getAngle() {
		double radians = Math.atan2(y, x);
		return radians * 180 / Math.PI;
	}

	public Force2D add(Force2D force) {
		return new Force2D(x + force.getX(), y + force.getY());
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}
