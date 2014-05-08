package charnetskaya.tictactoe;


import java.util.ArrayList;
import java.util.List;

public class Evaluator {

	private final TicTacToeBoard board;
	private final List<Location> winningLocations;

	public Evaluator(TicTacToeBoard board) {

		this.board = board;
		this.winningLocations = new ArrayList<Location>();

	}

	public TicTacToeBoard getBoard() {
		return board;
	}

	public void evaluate() {
		checkHorizontal();
		checkVertical();
		checkDiagonalDown();
		checkDiagonalUp();
	}

	public Symbol getWinner() {

		if (board.getMoves() > 0) {
			if (!winningLocations.isEmpty()) {
				return board.getBoard()[winningLocations.get(0).getX()][winningLocations
						.get(0).getY()];
			} else {
				return null;
			}
		} else {
			return null;
		}

		/*
		 * if (winningLocations.isEmpty()) { return null; } else { return
		 * board.getBoard()[winningLocations.get(0).getX()][winningLocations
		 * .get(0).getY()]; }
		 */
	}

	public List<Location> getWinningSquares() {

		if (winningLocations.isEmpty()) {
			return null;
		} else {
			List<Location> copy = new ArrayList<Location>();
			for (Location l : winningLocations) {
				copy.add(new Location(l));
			}
			return copy;
		}
	}

	private boolean checkIfLocationExists(Location l) {
		for (Location location : winningLocations) {
			if (l.equals(location)) {
				return true;
			}
		}
		return false;
	}

	private void checkDiagonalUp() {
		if (board.getBoard()[2][0] != null && board.getBoard()[1][1] != null
				&& board.getBoard()[0][2] != null) {

			if (board.getBoard()[2][0] == board.getBoard()[1][1]
					&& board.getBoard()[2][0] == board.getBoard()[0][2]) {

				Location l = new Location(2, 0);
				if (!checkIfLocationExists(l)) {
					winningLocations.add(l);
				}
				l = new Location(1, 1);
				if (!checkIfLocationExists(l)) {
					winningLocations.add(l);
				}
				l = new Location(0, 2);
				if (!checkIfLocationExists(l)) {
					winningLocations.add(l);
				}
			}
		}
	}

	private void checkDiagonalDown() {

		if (board.getBoard()[0][0] != null && board.getBoard()[1][1] != null
				&& board.getBoard()[2][2] != null) {

			if (board.getBoard()[0][0] == board.getBoard()[1][1]
					&& board.getBoard()[0][0] == board.getBoard()[2][2]) {

				Location l = new Location(0, 0);
				if (!checkIfLocationExists(l)) {
					winningLocations.add(l);
				}
				l = new Location(1, 1);
				if (!checkIfLocationExists(l)) {
					winningLocations.add(l);
				}
				l = new Location(2, 2);
				if (!checkIfLocationExists(l)) {
					winningLocations.add(l);
				}
			}

		}
	}

	private void checkVertical() {
		ArrayList<Location> v = null;

		for (int col = 0; col < board.getBoard()[0].length; col++) {
			v = new ArrayList<Location>();
			for (int row = 0; row < board.getBoard()[col].length; row++) {
				if (board.getBoard()[row][col] != null) {
					if (v.isEmpty()) {
						v.add(new Location(row, col));
					} else {
						if (board.getBoard()[row][col] == board.getBoard()[v
								.get(0).getX()][v.get(0).getY()]) {
							v.add(new Location(row, col));
						} else {
							break;
						}
					}
				} else {
					break;
				}
			}
			if (v.size() >= board.getBoard()[0].length) {
				for (Location l : v) {
					if (!checkIfLocationExists(l)) {
						winningLocations.add(new Location(l));
					}
				}
			}
		}
	}

	private void checkHorizontal() {
		ArrayList<Location> h = null;
		for (int row = 0; row < board.getBoard().length; row++) {
			h = new ArrayList<Location>();

			for (int col = 0; col < board.getBoard()[row].length; col++) {
				if (board.getBoard()[row][col] == null) {
					break;
				} else {
					if (h.isEmpty()) {
						Location l = new Location(row, col);
						h.add(l);

					} else {

						if (board.getBoard()[row][col]

						== board.getBoard()[h.get(0).getX()][h.get(0).getY()]) {
							Location lo = new Location(row, col);
							h.add(lo);

						} else {
							break;
						}
					}
				}
			}
			if (h.size() == board.getBoard().length) {
				for (Location l : h) {
					if (!checkIfLocationExists(l)) {
						winningLocations.add(new Location(l));
					}
				}
			}
		}
	}
}
