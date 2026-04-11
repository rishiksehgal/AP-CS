import java.awt.*;
import java.util.*;

public class Bishop extends Piece
{
	public Bishop(Color color, String imageFileName)
	{
		super(color, imageFileName, 3);
	}

	public ArrayList<Location> destinations()
	{
		ArrayList<Location> dests = new ArrayList<Location>();
		sweep(dests, Location.NORTHEAST);
		sweep(dests, Location.SOUTHEAST);
		sweep(dests, Location.SOUTHWEST);
		sweep(dests, Location.NORTHWEST);
		return dests;
	}
}
