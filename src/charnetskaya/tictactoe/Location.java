package charnetskaya.tictactoe;


public class Location {

	private final int x;
	private final int y;

	public Location(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public Location(Location location) {

		this.x = location.x;
		this.y = location.y;

	}

	public boolean equals(Location location) {
		return this.x == location.x && this.y == location.y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}
