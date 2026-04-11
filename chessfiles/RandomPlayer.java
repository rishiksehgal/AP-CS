import java.awt.*;
import java.util.*;

public class RandomPlayer extends Player
{
	private Random random;

	public RandomPlayer(Board board, String name, Color color)
	{
		super(board, name, color);
		random = new Random();
	}

	public Move nextMove()
	{
		ArrayList<Move> moves = getBoard().allMoves(getColor());
		if (moves.isEmpty())
			return null;
		return moves.get(random.nextInt(moves.size()));
	}
}
