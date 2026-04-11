import java.awt.*;
import java.util.*;

public class Knight extends Piece
{
	private static final int[][] OFFSETS = {
		{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
		{1, -2}, {1, 2}, {2, -1}, {2, 1}
	};

	public Knight(Color color, String imageFileName)
	{
		super(color, imageFileName, 3);
	}

	public ArrayList<Location> destinations()
	{
		ArrayList<Location> dests = new ArrayList<Location>();
		Location current = getLocation();

		for (int[] offset : OFFSETS)
		{
			Location next = new Location(current.getRow() + offset[0],
										 current.getCol() + offset[1]);
			if (isValidDestination(next))
				dests.add(next);
		}

		return dests;
	}
}
