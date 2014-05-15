package charnetskaya.checkers;

import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {

		return x < WIDTH && x >= 0 && y < HEIGHT && y >= 0;

	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		return board[x][y] == null;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = null;
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		board[1][0] = Piece.WHITE_MAN;
		board[3][0] = Piece.WHITE_MAN;
		board[5][0] = Piece.WHITE_MAN;
		board[7][0] = Piece.WHITE_MAN;
		board[0][1] = Piece.WHITE_MAN;
		board[2][1] = Piece.WHITE_MAN;
		board[4][1] = Piece.WHITE_MAN;
		board[6][1] = Piece.WHITE_MAN;
		board[1][2] = Piece.WHITE_MAN;
		board[3][2] = Piece.WHITE_MAN;
		board[5][2] = Piece.WHITE_MAN;
		board[7][2] = Piece.WHITE_MAN;

		board[0][5] = Piece.RED_MAN;
		board[2][5] = Piece.RED_MAN;
		board[4][5] = Piece.RED_MAN;
		board[6][5] = Piece.RED_MAN;
		board[1][6] = Piece.RED_MAN;
		board[3][6] = Piece.RED_MAN;
		board[5][6] = Piece.RED_MAN;
		board[7][6] = Piece.RED_MAN;
		board[0][7] = Piece.RED_MAN;
		board[2][7] = Piece.RED_MAN;
		board[4][7] = Piece.RED_MAN;
		board[6][7] = Piece.RED_MAN;
	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder boardString = new StringBuilder();
		int col = 0;

		while (col < HEIGHT) {
			for (int row = 0; row < board[col].length; row++) {
				if (board[row][col] == null) {
					boardString.append("-");
				} else
					boardString.append(board[row][col]);

			}
			boardString.append("\n");
			col++;

		}

		return boardString.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {

		if (isOnBoard(move.getX1(), move.getY1())
				&& isOnBoard(move.getX2(), move.getY2())) {
			if (isEmptySquare(move.getX2(), move.getY2())) {

				Piece piece = getPiece(move.getY1(), move.getX1());
				if (piece.equals(Piece.WHITE_MAN)) {
					if (move.getY2() == 7) {
						piece = Piece.WHITE_KING;
					}
				} else {
					if (move.getY2() == 0) {
						piece = Piece.RED_KING;
					}
				}

				setPiece(move.getY2(), move.getX2(), piece);

				removePiece(move.getY1(), move.getX1());
			}
		}
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		// CHECK IF ALL OF THEM ON BOARD
		if (isOnBoard(jump.getX1(), jump.getX2())
				&& isOnBoard(jump.getY1(), jump.getY2())
				&& isOnBoard(jump.getCaptureX(), jump.getCaptureY())) {
			// check if landing square is empty
			if (isEmptySquare(jump.getY1(), jump.getY2())) {
				Piece piece = getPiece(jump.getY1(), jump.getX1());
				// check if capture piece is enemy color
				if (getPiece(jump.getCaptureY(), jump.getCaptureX())
						.isEnemyColor(piece.getColor())) {

					if (Piece.WHITE_MAN.equals(piece)) {
						if (jump.getY2() == 7) {
							piece = Piece.WHITE_KING;
						}
					} else if (Piece.RED_MAN.equals(piece)) {
						if (jump.getY2() == 0) {
							piece = Piece.RED_KING;
						}
					}

					setPiece(jump.getY2(), jump.getX2(), piece);
					removePiece(jump.getCaptureY(), jump.getCaptureX());
					removePiece(jump.getY1(), jump.getX1());
				}
			}

		}
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {

		Piece piece = getPiece(y, x);
		if (piece == null) {
			return new ArrayList<Move>(0);
		} else {
			List<Move> moves = new ArrayList<Move>(4);
			if (Piece.WHITE_MAN.equals(piece)) {
				if (isOnBoard(x - 1, y + 1) && isEmptySquare(x - 1, y + 1)) {
					moves.add(new Move(x, y, x - 1, y + 1));
				}
				if (isOnBoard(x + 1, y + 1) && isEmptySquare(x + 1, y + 1)) {
					moves.add(new Move(x, y, x + 1, y + 1));
				}
			} else if (Piece.RED_MAN.equals(piece)) {
				if (isOnBoard(x - 1, y - 1) && isEmptySquare(x - 1, y - 1)) {
					moves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isOnBoard(x + 1, y - 1) && isEmptySquare(x + 1, y - 1)) {
					moves.add(new Move(x, y, x + 1, y - 1));
				}
			} else {
				if (isOnBoard(x - 1, y - 1) && isEmptySquare(x - 1, y - 1)) {
					moves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isOnBoard(x + 1, y - 1) && isEmptySquare(x + 1, y - 1)) {
					moves.add(new Move(x, y, x + 1, y - 1));
				}
				if (isOnBoard(x - 1, y + 1) && isEmptySquare(x - 1, y + 1)) {
					moves.add(new Move(x, y, x - 1, y + 1));
				}
				if (isOnBoard(x + 1, y + 1) && isEmptySquare(x + 1, y + 1)) {
					moves.add(new Move(x, y, x + 1, y + 1));
				}
			}

			return moves;
		}
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		Piece piece = getPiece(y, x);
		if (piece == null) {
			return new ArrayList<Jump>(0);
		} else {
			List<Jump> jumps = new ArrayList<Jump>();
			if (Piece.WHITE_MAN.equals(piece)) {
				if (isOnBoard(x - 1, y + 1)
						&& isOnBoard(x - 2, y + 2)
						&& !isEmptySquare(x - 1, y + 1)
						&& getPiece(y + 1, x - 1)
								.isEnemyColor(piece.getColor())
						&& isEmptySquare(x - 2, y + 2)) {
					jumps.add(new Jump(y, x, x - 1, y + 1, x - 2, y + 2));
				}
				if (isOnBoard(x + 1, y + 1)
						&& isOnBoard(x + 2, y + 2)
						&& !isEmptySquare(x + 1, y + 1)
						&& getPiece(y + 1, x + 1)
								.isEnemyColor(piece.getColor())
						&& isEmptySquare(x + 2, y + 2)) {
					jumps.add(new Jump(y, x, x + 1, y + 1, x + 2, y + 2));
				}

			} else if (Piece.RED_MAN.equals(piece)) {
				if (isOnBoard(x - 1, y - 1)
						&& isOnBoard(x - 2, y - 2)
						&& !isEmptySquare(x - 1, y - 1)
						&& getPiece(y - 1, x - 1)
								.isEnemyColor(piece.getColor())
						&& isEmptySquare(x - 2, y - 2)) {
					jumps.add(new Jump(y, x, x - 1, y - 1, x - 2, y - 2));
				}
				if (isOnBoard(x + 1, y - 1)
						&& isOnBoard(x + 2, y - 2)
						&& !isEmptySquare(x + 1, y - 1)
						&& getPiece(y - 1, x + 1)
								.isEnemyColor(piece.getColor())
						&& isEmptySquare(x + 2, y - 2)) {
					jumps.add(new Jump(y, x, x + 1, y - 1, x + 2, y - 2));
				}
			} else {
				if (isOnBoard(x - 1, y - 1)
						&& isOnBoard(x - 2, y - 2)
						&& !isEmptySquare(x - 1, y - 1)
						&& getPiece(y - 1, x - 1)
								.isEnemyColor(piece.getColor())
						&& isEmptySquare(x - 2, y - 2)) {
					jumps.add(new Jump(y, x, x - 1, y - 1, x - 2, y - 2));
				}
				if (isOnBoard(x + 1, y - 1)
						&& isOnBoard(x + 2, y - 2)
						&& !isEmptySquare(x + 1, y - 1)
						&& getPiece(y - 1, x + 1)
								.isEnemyColor(piece.getColor())
						&& isEmptySquare(x + 2, y - 2)) {
					jumps.add(new Jump(y, x, x + 1, y - 1, x + 2, y - 2));
				}
				if (isOnBoard(x - 1, y + 1)
						&& isOnBoard(x - 2, y + 2)
						&& !isEmptySquare(x - 1, y + 1)
						&& getPiece(y + 1, x - 1)
								.isEnemyColor(piece.getColor())
						&& isEmptySquare(x - 2, y + 2)) {
					jumps.add(new Jump(y, x, x - 1, y + 1, x - 2, y + 2));
				}
				if (isOnBoard(x + 1, y + 1)
						&& isOnBoard(x + 2, y + 2)
						&& !isEmptySquare(x + 1, y + 1)
						&& getPiece(y + 1, x + 1)
								.isEnemyColor(piece.getColor())
						&& isEmptySquare(x + 2, y + 2)) {
					jumps.add(new Jump(y, x, x + 1, y + 1, x + 2, y + 2));
				}

			}
			return jumps;
		}

	}
}
