import java.awt.*;
import java.util.*;

public class King extends Piece
{
	public King(Color color, String imageFileName)
	{
		super(color, imageFileName, 1000);
	}

	public ArrayList<Location> destinations()
	{
		ArrayList<Location> dests = new ArrayList<Location>();
		Location current = getLocation();

		for (int direction = Location.NORTH; direction < Location.FULL_CIRCLE;
			 direction += Location.HALF_RIGHT)
		{
			Location next = current.getAdjacentLocation(direction);
			if (isValidDestination(next))
				dests.add(next);
		}

		if (getBoard().canCastle(this, true))
			dests.add(new Location(current.getRow(), current.getCol() + 2));
		if (getBoard().canCastle(this, false))
			dests.add(new Location(current.getRow(), current.getCol() - 2));

		return dests;
	}

	public ArrayList<Location> attackLocations()
	{
		ArrayList<Location> attacks = new ArrayList<Location>();
		Location current = getLocation();

		for (int direction = Location.NORTH; direction < Location.FULL_CIRCLE;
			 direction += Location.HALF_RIGHT)
		{
			Location next = current.getAdjacentLocation(direction);
			if (getBoard().isValid(next))
				attacks.add(next);
		}

		return attacks;
	}
}
