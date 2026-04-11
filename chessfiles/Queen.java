import java.awt.*;
import java.util.*;

public class Queen extends Piece
{
	public Queen(Color color, String imageFileName)
	{
		super(color, imageFileName, 9);
	}

	public ArrayList<Location> destinations()
	{
		ArrayList<Location> dests = new ArrayList<Location>();
		for (int direction = Location.NORTH; direction < Location.FULL_CIRCLE;
			 direction += Location.HALF_RIGHT)
		{
			sweep(dests, direction);
		}
		return dests;
	}
}
