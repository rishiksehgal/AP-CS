import java.awt.*;
import java.util.*;

public class HumanPlayer extends Player
{
	private BoardDisplay display;

	public HumanPlayer(Board board, String name, Color color, BoardDisplay display)
	{
		super(board, name, color);
		this.display = display;
	}

	public Move nextMove()
	{
		ArrayList<Move> legalMoves = getBoard().allMoves(getColor());
		if (legalMoves.isEmpty())
			return null;

		Move move = display.selectMove();
		while (!legalMoves.contains(move))
			move = display.selectMove();
		return move;
	}
}
