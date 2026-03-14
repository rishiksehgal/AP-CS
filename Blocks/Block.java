import java.awt.Color;
/**
* class BLock encapsulates a Block abstraction which can be placed into a Gridworld style grid
* You are expected to comment this class according to the style guide.
* @author Rishik
* @version 1
*/
public class Block
{
    private MyBoundedGrid<Block> grid;
    private Location location;
    private Color color;
    /**
    * constructs a blue block, because blue is the greatest color ever!
    */
    public Block()
    {
        color = Color.BLUE;
        grid = null;
        location = null;
    }
    /**
    * Returns the color
    * @return the color
    */
    public Color getColor()
    {
        return color;
    }
    /**
    * Sets the color
    * @param newColor the new color
    */
    public void setColor(Color newColor)
    {
        color = newColor;
    }
    
    /**
    * Returns the grid
    * @return the grid
    */
    public MyBoundedGrid<Block> getGrid()
    {
        return grid;
    }
    
    /**
    * Returns the location
    * @return the location
    */
    public Location getLocation()
    {
        return location;
    }
    
    /**
    * Removes this Block from the Grid
    */
    public void removeSelfFromGrid()
    {
        if (grid != null)
        {
            grid.remove(location);
            grid = null;
            location = null;
        }
    }
    
    /**
    * Puts this block in a grid
    * @param gr grid to insert in
    * @param loc location to insert at
    */
    public void putSelfInGrid(MyBoundedGrid<Block> gr, Location loc)
    {
        if(gr == null || loc == null)
        {
            return;
        }
        Block x = gr.get(loc);
        if (x != null)
        {
            x.removeSelfFromGrid();
        }
        gr.put(loc, this);
        grid = gr;
        location = loc;
    }

    /**
    * Moves Block to a different location
    * @param newLocation location being moved to
    */
    public void moveTo(Location newLocation)
    {
        if (grid == null && newLocation == null || location.equals(newLocation))
        {
            return;
        }
        Block x = grid.get(newLocation);
        if (x != null)
        {
            x.removeSelfFromGrid();
        }
        grid.remove(getLocation());
        location = newLocation;
        grid.put(getLocation(), this);
    }

    /**
    * returns a string with the location and color of this block
    * @return String with the location and color of this block
    */
    public String toString()
    {
        return "Block[location=" + location + ",color=" + color + "]";
    }
}