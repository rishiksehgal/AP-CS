import java.awt.*;
import java.util.*;

public class Game
{
	public static void main(String[] args)
	{
		Board board = new Board();
		setupBoard(board);
		BoardDisplay display = new BoardDisplay(board);

		Player white = new HumanPlayer(board, "White (Human)", Color.WHITE, display);
		Player black = new SmartPlayer(board, "Black (Smart)", Color.BLACK, 2);
		play(board, display, white, black);
	}

	private static void setupBoard(Board board)
	{
		Piece[] blackBackRow = {
			new Rook(Color.BLACK, "black_rook.gif"),
			new Knight(Color.BLACK, "black_knight.gif"),
			new Bishop(Color.BLACK, "black_bishop.gif"),
			new Queen(Color.BLACK, "black_queen.gif"),
			new King(Color.BLACK, "black_king.gif"),
			new Bishop(Color.BLACK, "black_bishop.gif"),
			new Knight(Color.BLACK, "black_knight.gif"),
			new Rook(Color.BLACK, "black_rook.gif")
		};

		Piece[] whiteBackRow = {
			new Rook(Color.WHITE, "white_rook.gif"),
			new Knight(Color.WHITE, "white_knight.gif"),
			new Bishop(Color.WHITE, "white_bishop.gif"),
			new Queen(Color.WHITE, "white_queen.gif"),
			new King(Color.WHITE, "white_king.gif"),
			new Bishop(Color.WHITE, "white_bishop.gif"),
			new Knight(Color.WHITE, "white_knight.gif"),
			new Rook(Color.WHITE, "white_rook.gif")
		};

		for (int col = 0; col < 8; col++)
		{
			blackBackRow[col].putSelfInGrid(board, new Location(0, col));
			new Pawn(Color.BLACK, "black_pawn.gif").putSelfInGrid(board, new Location(1, col));
			new Pawn(Color.WHITE, "white_pawn.gif").putSelfInGrid(board, new Location(6, col));
			whiteBackRow[col].putSelfInGrid(board, new Location(7, col));
		}
	}

	private static void nextTurn(Board board, BoardDisplay display, Player player)
	{
		String title = player.getName();
		if (board.inCheck(player.getColor()))
			title += " - Check";
		display.setTitle(title);
		Move move = player.nextMove();
		if (move == null)
			return;

		board.executeMove(move);
		display.clearColors();
		display.setColor(move.getSource(), Color.YELLOW);
		display.setColor(move.getDestination(), Color.YELLOW);

		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
	}

	public static void play(Board board, BoardDisplay display, Player white, Player black)
	{
		Player current = white;
		Player other = black;

		while (true)
		{
			if (board.isCheckmate(current.getColor()))
			{
				display.setTitle(current.getName() + " - Checkmate");
				break;
			}
			if (board.isStalemate(current.getColor()))
			{
				display.setTitle(current.getName() + " - Stalemate");
				break;
			}

			nextTurn(board, display, current);

			Player temp = current;
			current = other;
			other = temp;
		}
	}
}
