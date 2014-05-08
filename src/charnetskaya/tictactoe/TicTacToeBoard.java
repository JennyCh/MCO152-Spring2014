package charnetskaya.tictactoe;


public class TicTacToeBoard {

	private final Symbol[][] board;
	private final int totalMoves = 9;
	private int moves;

	public TicTacToeBoard() {

		this.board = new Symbol[3][3];
		this.moves = 0;

	}

	public void reset() {

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = null;
			}
		}
		moves = 0;
	}

	public boolean isFull() {
		return moves >= totalMoves;
	}

	public void setMoves(int numMoves) {
		this.moves = numMoves;
	}

	public void setSquare(Location location, Symbol symbol) {

		if (board[location.getX()][location.getY()] == null) {
			board[location.getX()][location.getY()] = symbol;
			moves++;
		}

	}

	public Symbol getSquare(Location location) {

		return board[location.getX()][location.getY()];

	}

	public Symbol[][] getBoard() {
		return board;
	}

	public int getTotalMoves() {
		return totalMoves;
	}

	public int getMoves() {
		return moves;
	}

	@Override
	public String toString() {
		/* String info = ""; */
		StringBuilder info = new StringBuilder("");
		for (int row = 0; row < board.length; row++) {
			info.append("| ");
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] != null) {
					info.append(board[row][col] + " | ");
				} else {
					info.append("  | ");
				}
			}
			info.append("\n");
		}
		return info.toString();
	}

}
