package charnetskaya.homework;

public class Circle2D {

	private final double x;
	private final double y;
	private final double radius;

	public Circle2D() {
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}

	public Circle2D(double x, double y, double radius) {
		/*
		 * if (radius <= 0) { throw new
		 * InvalidValueException("radius must be bigger than 0"); } else {
		 */

		this.x = x;
		this.y = y;
		this.radius = radius;
		// }
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public boolean contains(double pointX, double pointY) {
		double distance = Math.sqrt((pointX - x) * (pointX - x) + (pointY - y)
				* (pointY - y));
		return distance < radius;
	}

	public boolean contains(Circle2D circle) {
		double distance = Math.sqrt((circle.x - x) * (circle.x - x)
				+ (circle.y - y) * (circle.y - y));
		return (distance + circle.radius) < radius;
	}

	public boolean overlaps(Circle2D circle) {
		double distance = Math.sqrt((circle.x - x) * (circle.x - x)
				+ (circle.y - y) * (circle.y - y));
		return distance < (radius + circle.radius);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

}
