import java.awt.*;
import java.util.*;

public class Pawn extends Piece
{
	public Pawn(Color color, String imageFileName)
	{
		super(color, imageFileName, 1);
	}

	public ArrayList<Location> destinations()
	{
		ArrayList<Location> dests = new ArrayList<Location>();
		Board board = getBoard();
		Location current = getLocation();
		int direction = getColor().equals(Color.WHITE) ? -1 : 1;
		int startRow = getColor().equals(Color.WHITE) ? 6 : 1;

		Location oneForward = new Location(current.getRow() + direction, current.getCol());
		if (board.isValid(oneForward) && board.get(oneForward) == null)
		{
			dests.add(oneForward);

			Location twoForward = new Location(current.getRow() + 2 * direction, current.getCol());
			if (current.getRow() == startRow && board.isValid(twoForward) &&
				board.get(twoForward) == null)
			{
				dests.add(twoForward);
			}
		}

		addCaptureIfValid(dests, current.getRow() + direction, current.getCol() - 1);
		addCaptureIfValid(dests, current.getRow() + direction, current.getCol() + 1);

		return dests;
	}

	public ArrayList<Location> attackLocations()
	{
		ArrayList<Location> attacks = new ArrayList<Location>();
		Location current = getLocation();
		int direction = getColor().equals(Color.WHITE) ? -1 : 1;

		addAttackIfValid(attacks, current.getRow() + direction, current.getCol() - 1);
		addAttackIfValid(attacks, current.getRow() + direction, current.getCol() + 1);

		return attacks;
	}

	private void addCaptureIfValid(ArrayList<Location> dests, int row, int col)
	{
		Board board = getBoard();
		Location dest = new Location(row, col);
		if (!board.isValid(dest))
			return;

		Piece victim = board.get(dest);
		if (victim != null && !victim.getColor().equals(getColor()))
			dests.add(dest);
	}

	private void addAttackIfValid(ArrayList<Location> attacks, int row, int col)
	{
		Board board = getBoard();
		Location dest = new Location(row, col);
		if (board.isValid(dest))
			attacks.add(dest);
	}
}
