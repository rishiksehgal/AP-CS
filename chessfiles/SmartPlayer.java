import java.awt.*;
import java.util.*;

public class SmartPlayer extends Player
{
	private int lookAhead;

	public SmartPlayer(Board board, String name, Color color)
	{
		this(board, name, color, 2);
	}

	public SmartPlayer(Board board, String name, Color color, int lookAhead)
	{
		super(board, name, color);
		this.lookAhead = Math.max(1, lookAhead);
	}

	public Move nextMove()
	{
		ArrayList<Move> moves = getBoard().allMoves(getColor());
		if (moves.isEmpty())
			return null;

		Move bestMove = moves.get(0);
		int bestValue = Integer.MIN_VALUE;

		for (Move move : moves)
		{
			getBoard().executeMove(move);
			int value = valueOfMeanestResponse(lookAhead - 1);
			getBoard().undoMove(move);

			if (value > bestValue)
			{
				bestValue = value;
				bestMove = move;
			}
		}

		return bestMove;
	}

	public int score()
	{
		if (getBoard().isCheckmate(getColor()))
			return -100000;
		if (getBoard().isCheckmate(opponentColor()))
			return 100000;
		if (getBoard().isStalemate(getColor()) || getBoard().isStalemate(opponentColor()))
			return 0;

		int total = 0;

		for (Location loc : getBoard().getOccupiedLocations())
		{
			Piece piece = getBoard().get(loc);
			if (piece.getColor().equals(getColor()))
				total += piece.getValue();
			else
				total -= piece.getValue();
		}

		return total;
	}

	private int valueOfMeanestResponse(int movesToLookAhead)
	{
		if (movesToLookAhead == 0)
			return score();

		ArrayList<Move> opponentMoves = getBoard().allMoves(opponentColor());
		if (opponentMoves.isEmpty())
			return score();

		int worstValue = Integer.MAX_VALUE;

		for (Move move : opponentMoves)
		{
			getBoard().executeMove(move);
			int value = valueOfBestMove(movesToLookAhead - 1);
			getBoard().undoMove(move);
			worstValue = Math.min(worstValue, value);
		}

		return worstValue;
	}

	private int valueOfBestMove(int movesToLookAhead)
	{
		if (movesToLookAhead == 0)
			return score();

		ArrayList<Move> moves = getBoard().allMoves(getColor());
		if (moves.isEmpty())
			return score();

		int bestValue = Integer.MIN_VALUE;

		for (Move move : moves)
		{
			getBoard().executeMove(move);
			int value = valueOfMeanestResponse(movesToLookAhead - 1);
			getBoard().undoMove(move);
			bestValue = Math.max(bestValue, value);
		}

		return bestValue;
	}

	private Color opponentColor()
	{
		return getColor().equals(Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
}
