package charnetskaya.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeBoardTest {

	private TicTacToeBoard board;

	@Before
	public void setUp() throws Exception {
		board = new TicTacToeBoard();
	}

	@Test
	public void testReset() throws Exception {
		board.setSquare(new Location(0, 0), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.X);
		board.setSquare(new Location(0, 2), Symbol.X);
		/*
		 * board.setSquare(new Location(1,0), Symbol.X); board.setSquare(new
		 * Location(1,1), Symbol.X); board.setSquare(new Location(1,2),
		 * Symbol.X); board.setSquare(new Location(2,0), Symbol.X);
		 * board.setSquare(new Location(2,1), Symbol.X); board.setSquare(new
		 * Location(2,2), Symbol.X);
		 */

		board.reset();

		Assert.assertTrue(board.getBoard()[0][0] == null);
		Assert.assertTrue(board.getBoard()[0][1] == null);
		Assert.assertTrue(board.getBoard()[0][2] == null);

	}

	@Test
	public void testIsFull() {
		board.setMoves(9);
		Assert.assertTrue(board.isFull());
		board.setMoves(8);
		Assert.assertTrue(!board.isFull());
	}

	@Test
	public void testSetSquare() throws Exception {
		board.reset();

		board.setSquare(new Location(0, 0), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);

		Assert.assertTrue(board.getSquare(new Location(0, 0)) == Symbol.O);
		Assert.assertTrue(board.getSquare(new Location(2, 2)) == Symbol.X);

	}

	@Test
	public void getSquare() throws Exception {
		board.setSquare(new Location(0, 0), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);
		Assert.assertTrue(board.getSquare(new Location(0, 0)) == Symbol.O);
		Assert.assertTrue(board.getSquare(new Location(2, 2)) == Symbol.X);
	}

}
