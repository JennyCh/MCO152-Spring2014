package charnetskaya.tictactoe;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {
	/*
	 * //private Evaluator eval;
	 * 
	 * @Before public void setUp() throws Exception { TicTacToeBoard board = new
	 * TicTacToeBoard(); this.eval = new Evaluator(board);
	 * 
	 * board.setSquare(new Location(0,0), Symbol.X); board.setSquare(new
	 * Location(0,1), Symbol.X); board.setSquare(new Location(0,2), Symbol.X);
	 * board.setSquare(new Location(1,0), Symbol.X); board.setSquare(new
	 * Location(1,1), Symbol.X); board.setSquare(new Location(1,2), Symbol.X);
	 * board.setSquare(new Location(2,0), Symbol.X); board.setSquare(new
	 * Location(2,1), Symbol.X); board.setSquare(new Location(2,2), Symbol.X);
	 * System.out.println (board); }
	 */

	@Test
	public void testNoWinnerOnEmptyBoard() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator eval = new Evaluator(board);

		Assert.assertNull(eval.getWinner());
	}

	@Test
	public void testNoWimmerOnFullBoard() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator eval = new Evaluator(board);

		eval.getBoard().setSquare(new Location(0, 0), Symbol.X);
		eval.getBoard().setSquare(new Location(0, 1), Symbol.O);
		eval.getBoard().setSquare(new Location(0, 2), Symbol.O);
		eval.getBoard().setSquare(new Location(1, 0), Symbol.O);
		eval.getBoard().setSquare(new Location(1, 1), Symbol.X);
		eval.getBoard().setSquare(new Location(1, 2), Symbol.X);
		eval.getBoard().setSquare(new Location(2, 0), Symbol.X);
		eval.getBoard().setSquare(new Location(2, 1), Symbol.O);
		eval.getBoard().setSquare(new Location(2, 2), Symbol.O);

		Assert.assertNull(eval.getWinner());
	}

	@Test
	public void testEvaluate() {
		// fail("Not yet implemented");

		TicTacToeBoard board = new TicTacToeBoard();
		// -----------------------------------------------------
		Evaluator eval = new Evaluator(board);

		eval.getBoard().setSquare(new Location(0, 0), Symbol.X);
		eval.getBoard().setSquare(new Location(0, 1), Symbol.X);
		eval.getBoard().setSquare(new Location(0, 2), Symbol.X);

		eval.evaluate();

		List<Location> winningLocations = eval.getWinningSquares();
		Assert.assertTrue(winningLocations.size() == 3);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(0)
				.getX()][winningLocations.get(0).getY()] == Symbol.X);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(1)
				.getX()][winningLocations.get(1).getY()] == Symbol.X);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(2)
				.getX()][winningLocations.get(2).getY()] == Symbol.X);
		// ----------------------------------------------------------
		eval.getBoard().reset();
		eval = new Evaluator(board);

		eval.getBoard().setSquare(new Location(0, 1), Symbol.O);
		eval.getBoard().setSquare(new Location(1, 1), Symbol.O);
		eval.getBoard().setSquare(new Location(2, 1), Symbol.O);

		eval.evaluate();
		winningLocations = eval.getWinningSquares();

		Assert.assertTrue(winningLocations.size() == 3);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(0)
				.getX()][winningLocations.get(0).getY()] == Symbol.O);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(1)
				.getX()][winningLocations.get(1).getY()] == Symbol.O);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(2)
				.getX()][winningLocations.get(2).getY()] == Symbol.O);
		// -------------------------------------------------------------

		eval.getBoard().reset();
		eval = new Evaluator(board);

		eval.getBoard().setSquare(new Location(0, 0), Symbol.O);
		eval.getBoard().setSquare(new Location(1, 1), Symbol.O);
		eval.getBoard().setSquare(new Location(2, 2), Symbol.O);

		eval.evaluate();
		winningLocations = eval.getWinningSquares();

		Assert.assertTrue(winningLocations.size() == 3);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(0)
				.getX()][winningLocations.get(0).getY()] == Symbol.O);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(1)
				.getX()][winningLocations.get(1).getY()] == Symbol.O);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(2)
				.getX()][winningLocations.get(2).getY()] == Symbol.O);
		// -----------------------------------------------------------------

		eval.getBoard().reset();
		eval = new Evaluator(board);

		eval.getBoard().setSquare(new Location(2, 0), Symbol.O);
		eval.getBoard().setSquare(new Location(1, 1), Symbol.O);
		eval.getBoard().setSquare(new Location(0, 2), Symbol.O);

		eval.evaluate();
		winningLocations = eval.getWinningSquares();

		Assert.assertTrue(winningLocations.size() == 3);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(0)
				.getX()][winningLocations.get(0).getY()] == Symbol.O);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(1)
				.getX()][winningLocations.get(1).getY()] == Symbol.O);
		Assert.assertTrue(eval.getBoard().getBoard()[winningLocations.get(2)
				.getX()][winningLocations.get(2).getY()] == Symbol.O);

	}

	@Test
	public void testGetWinner() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator eval = new Evaluator(board);

		eval.getBoard().setSquare(new Location(2, 0), Symbol.O);
		eval.getBoard().setSquare(new Location(1, 1), Symbol.O);
		eval.getBoard().setSquare(new Location(0, 2), Symbol.O);

		eval.evaluate();

		Assert.assertTrue(eval.getWinner() == Symbol.O);
	}

}
