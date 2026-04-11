import java.awt.*;
import java.util.*;

public class Rook extends Piece
{
	public Rook(Color color, String imageFileName)
	{
		super(color, imageFileName, 5);
	}

	public ArrayList<Location> destinations()
	{
		ArrayList<Location> dests = new ArrayList<Location>();
		sweep(dests, Location.NORTH);
		sweep(dests, Location.EAST);
		sweep(dests, Location.SOUTH);
		sweep(dests, Location.WEST);
		return dests;
	}
}
