package charnetskaya.checkers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";

		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {
		CheckerBoard board = new CheckerBoard();
		Assert.assertFalse(board.isOnBoard(-1, -1));
		Assert.assertFalse(board.isOnBoard(8, 8));
		Assert.assertFalse(board.isOnBoard(0, 8));
		Assert.assertFalse(board.isOnBoard(8, 0));

		Assert.assertTrue(board.isOnBoard(0, 0));
		Assert.assertTrue(board.isOnBoard(7, 0));
		Assert.assertTrue(board.isOnBoard(0, 7));
		Assert.assertTrue(board.isOnBoard(7, 7));

		Assert.assertTrue(board.isOnBoard(4, 4));
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {
		CheckerBoard board = new CheckerBoard();

		Assert.assertTrue(board.isEmptySquare(0, 0));
		board.setPiece(0, 0, Piece.WHITE_MAN);
		Assert.assertFalse(board.isEmptySquare(0, 0));
	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();

		Assert.assertFalse(board.isEmptySquare(1, 0));
		Assert.assertFalse(board.isEmptySquare(4, 5));
		Assert.assertFalse(board.isEmptySquare(7, 2));
		Assert.assertFalse(board.isEmptySquare(6, 7));

		board.clear();
		Assert.assertTrue(board.isEmptySquare(1, 0));
		Assert.assertTrue(board.isEmptySquare(4, 5));
		Assert.assertTrue(board.isEmptySquare(7, 2));
		Assert.assertTrue(board.isEmptySquare(6, 7));
	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		CheckerBoard board = new CheckerBoard();

		Assert.assertTrue(board.isEmptySquare(1, 0));
		Assert.assertTrue(board.isEmptySquare(4, 5));
		Assert.assertTrue(board.isEmptySquare(7, 2));
		Assert.assertTrue(board.isEmptySquare(6, 7));

		board.resetNewGame();
		Assert.assertFalse(board.isEmptySquare(1, 0));
		Assert.assertFalse(board.isEmptySquare(4, 5));
		Assert.assertFalse(board.isEmptySquare(7, 2));
		Assert.assertFalse(board.isEmptySquare(6, 7));

	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		CheckerBoard board = new CheckerBoard();

		Move move = new Move(1, 0, 2, 1);

		board.setPiece(0, 1, Piece.WHITE_MAN);

		Assert.assertFalse(board.isEmptySquare(1, 0));
		Assert.assertTrue(board.isEmptySquare(2, 1));

		board.execute(move);

		Assert.assertTrue(board.isEmptySquare(1, 0));
		Assert.assertFalse(board.isEmptySquare(2, 1));

	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {

		CheckerBoard board = new CheckerBoard();

		Move move = new Move(5, 6, 6, 7);

		board.setPiece(6, 5, Piece.WHITE_MAN);

		Assert.assertFalse(board.isEmptySquare(5, 6));

		board.execute(move);
		Assert.assertTrue(board.isEmptySquare(5, 6));
		Assert.assertFalse(board.isEmptySquare(6, 7));
		Assert.assertEquals(Piece.WHITE_KING, board.getPiece(7, 6));

	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() {

		CheckerBoard board = new CheckerBoard();

		Move move = new Move(4, 1, 3, 0);
		board.setPiece(1, 4, Piece.RED_MAN);

		Assert.assertFalse(board.isEmptySquare(4, 1));
		board.execute(move);

		Assert.assertTrue(board.isEmptySquare(4, 1));
		Assert.assertFalse(board.isEmptySquare(3, 0));
		Assert.assertEquals(Piece.RED_KING, board.getPiece(0, 3));
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		CheckerBoard board = new CheckerBoard();

		Jump jump = new Jump(5, 4, 4, 3, 3, 2);
		board.setPiece(4, 5, Piece.WHITE_MAN);
		board.setPiece(3, 4, Piece.RED_MAN);

		Assert.assertFalse(board.isEmptySquare(5, 4));
		Assert.assertFalse(board.isEmptySquare(4, 3));
		Assert.assertTrue(board.isEmptySquare(3, 2));

		board.execute(jump);

		Assert.assertTrue(board.isEmptySquare(5, 4));
		Assert.assertTrue(board.isEmptySquare(4, 3));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(2, 3));
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();

		Jump jump = new Jump(7, 2, 6, 1, 5, 0);

		board.setPiece(2, 7, Piece.RED_MAN);
		board.setPiece(1, 6, Piece.WHITE_MAN);

		Assert.assertFalse(board.isEmptySquare(7, 2));
		Assert.assertFalse(board.isEmptySquare(6, 1));
		Assert.assertTrue(board.isEmptySquare(5, 0));

		board.execute(jump);

		Assert.assertTrue(board.isEmptySquare(7, 2));
		Assert.assertTrue(board.isEmptySquare(6, 1));
		Assert.assertFalse(board.isEmptySquare(5, 0));
		Assert.assertEquals(Piece.RED_KING, board.getPiece(0, 5));

	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {

		CheckerBoard board = new CheckerBoard();

		Jump jump = new Jump(0, 5, 1, 6, 2, 7);
		board.setPiece(5, 0, Piece.WHITE_MAN);
		board.setPiece(6, 1, Piece.RED_MAN);

		Assert.assertFalse(board.isEmptySquare(0, 5));
		Assert.assertFalse(board.isEmptySquare(1, 6));
		Assert.assertTrue(board.isEmptySquare(2, 7));

		board.execute(jump);

		Assert.assertTrue(board.isEmptySquare(0, 5));
		Assert.assertTrue(board.isEmptySquare(1, 6));
		Assert.assertFalse(board.isEmptySquare(2, 7));
		Assert.assertEquals(Piece.WHITE_KING, board.getPiece(7, 2));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		CheckerBoard board = new CheckerBoard();

		Assert.assertEquals(0, board.getMoves(5, 2).size());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();

		board.setPiece(4, 5, Piece.RED_MAN);
		Assert.assertFalse(board.isEmptySquare(5, 4));

		List<Move> moves = board.getMoves(5, 4);

		List<Move> expected = new ArrayList<Move>(2);
		expected.add(new Move(5, 4, 4, 3));
		expected.add(new Move(5, 4, 6, 3));

		Assert.assertEquals(expected, moves);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();

		board.setPiece(4, 5, Piece.RED_KING);

		Assert.assertFalse(board.isEmptySquare(5, 4));
		List<Move> moves = board.getMoves(5, 4);
		List<Move> expected = new ArrayList<Move>(4);
		expected.add(new Move(5, 4, 4, 3));
		expected.add(new Move(5, 4, 6, 3));
		expected.add(new Move(5, 4, 4, 5));
		expected.add(new Move(5, 4, 6, 5));

		// for(int i = 0; i < moves.size(); i++){
		Assert.assertEquals(moves.get(0), expected.get(0));
		Assert.assertEquals(moves.get(1), expected.get(1));
		Assert.assertEquals(moves.get(2), expected.get(2));
		Assert.assertEquals(moves.get(3), expected.get(3));
		// }
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();

		board.setPiece(4, 5, Piece.WHITE_MAN);

		Assert.assertFalse(board.isEmptySquare(5, 4));
		List<Move> moves = board.getMoves(5, 4);
		List<Move> expected = new ArrayList<Move>(2);

		expected.add(new Move(5, 4, 4, 5));
		expected.add(new Move(5, 4, 6, 5));
		Assert.assertEquals(moves.get(0), expected.get(0));
		Assert.assertEquals(moves.get(1), expected.get(1));

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();

		board.setPiece(4, 5, Piece.WHITE_KING);

		Assert.assertFalse(board.isEmptySquare(5, 4));
		List<Move> moves = board.getMoves(5, 4);
		List<Move> expected = new ArrayList<Move>(4);
		expected.add(new Move(5, 4, 4, 3));
		expected.add(new Move(5, 4, 6, 3));
		expected.add(new Move(5, 4, 4, 5));
		expected.add(new Move(5, 4, 6, 5));

		Assert.assertEquals(moves.get(0), expected.get(0));
		Assert.assertEquals(moves.get(1), expected.get(1));
		Assert.assertEquals(moves.get(2), expected.get(2));
		Assert.assertEquals(moves.get(3), expected.get(3));
		
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		
		CheckerBoard board = new CheckerBoard();

		board.setPiece(4, 5, Piece.RED_KING);
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(3, 6, Piece.RED_KING);
		board.setPiece(5, 4, Piece.RED_KING);
		board.setPiece(5, 6, Piece.RED_KING);
		Assert.assertFalse(board.isEmptySquare(5, 4));
		List<Move> moves = board.getMoves(5, 4);
		List<Move> expected = new ArrayList<Move>(0);
		
		Assert.assertEquals(expected.toString(), moves.toString());
	
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		CheckerBoard board = new CheckerBoard();
		
		board.setPiece(7, 0, Piece.RED_KING);
		List<Move> moves = board.getMoves(0, 7);
		List<Move> expected = new ArrayList<Move>(1);
		expected.add(new Move(0,7,1,6));
		Assert.assertEquals(expected.toString(), moves.toString());
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_KING);
		
		List<Move> moves = board.getMoves(7, 0);
		List<Move> expected = new ArrayList<Move>(1);
		expected.add(new Move(7,0,6,1));
		Assert.assertEquals(expected.toString(), moves.toString());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		
		List<Jump> possibleJumps = board.getJumps(3, 4);
		List<Jump> expectedJumps = new ArrayList<Jump>();
	
		
		Assert.assertEquals(expectedJumps, possibleJumps);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		//Assert.fail("test not implemented");
		CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 3, Piece.RED_KING);
		List<Jump> possibleJumps = board.getJumps(3, 4);
		List<Jump> expectedJumps = new ArrayList<Jump>();
		Assert.assertEquals(expectedJumps, possibleJumps);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(2, 3, Piece.WHITE_MAN);
		board.setPiece(2, 5, Piece.WHITE_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		board.setPiece(4, 5, Piece.WHITE_MAN);
		
		List<Jump> possibleJumps = board.getJumps(4, 3);
		List<Jump> expectedJumps = new ArrayList<Jump>();
		
		expectedJumps.add(new Jump(3,4,3,2,2,1));
		expectedJumps.add(new Jump(3,4,5,2,6,1));
		expectedJumps.add(new Jump(3,4,3,4,2,5));
		expectedJumps.add(new Jump(3,4,5,4,6,5));
		
		Assert.assertEquals(expectedJumps, possibleJumps);
	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_MAN);
		board.setPiece(2, 3, Piece.WHITE_MAN);
		board.setPiece(2, 5, Piece.WHITE_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		board.setPiece(4, 5, Piece.WHITE_MAN);
		
		List<Jump> possibleJumps = board.getJumps(4, 3);
		List<Jump> expectedJumps = new ArrayList<Jump>();
		
		expectedJumps.add(new Jump(3,4,3,2,2,1));
		expectedJumps.add(new Jump(3,4,5,2,6,1));
		
		Assert.assertEquals(expectedJumps, possibleJumps);
	}

}
