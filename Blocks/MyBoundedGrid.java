import java.util.ArrayList;
/**
 * MyBoundedGrid is a grid that stores Objects in a 2d array.
 * @author Rishik Sehgal
 * @version 1
 * @param <E> all types of objects
 */
public class MyBoundedGrid<E>
{
    private Object[][] grid;

    /**
     * Creates a MyBoundedGrid object with the specified amount of rows and cols. 
     * @param rows num of rows
     * @param cols number of cols
     */
    public MyBoundedGrid(int rows, int cols)
    {
        grid = new Object[rows][cols];
    }

    /**
     * Returns the number of rows
     * @return the number of rows
     */
    public int getNumRows()
    {
        return grid.length;
    }

    /**
     * Returns the number of columns
     * @return the number of columns
     */
    public int getNumCols()
    {
        if (grid.length == 0)
        {
            return 0;
        }
        return grid[0].length;
    }

    /**
     * Determines if a location is valid
     * @param loc location being checked
     * @return true if valid location
     */
    public boolean isValid(Location loc)
    {
        return loc != null && loc.getRow() >= 0 && loc.getRow() < getNumRows() &&
               loc.getCol() >= 0 && loc.getCol() < getNumCols();
    }

    /**
     * Returns the object that is at the location
     * @param loc the location
     * @return the object
     */
    public E get(Location loc)
    {
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Not valid Location");
        }
        return (E) grid[loc.getRow()][loc.getCol()];
    }

    /**
     * Puts the given object at the location and returns the old one.
     * @param loc location
     * @param obj obkect
     * @return previous occupant
     */
    public E put(Location loc, E obj)
    {
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Not Valid Location");
        }
        E prev = (E) grid[loc.getRow()][loc.getCol()];
        grid[loc.getRow()][loc.getCol()] = obj;
        return prev;
    }

    /**
     * Removes object at given location and returns it
     * @param loc location
     * @return previous occupant
     */
    public E remove(Location loc)
    {
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Not Valid Location");
        }
        E prev = (E) grid[loc.getRow()][loc.getCol()];
        grid[loc.getRow()][loc.getCol()] = null;
        return prev;
    }

    /**
     * Returns a list of all occupied locations in this grid.
     * @return a list of occupied locations
     */
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> x = new ArrayList<Location>();
        for (int r = 0; r < getNumRows(); r++)
        {
            for (int c = 0; c < getNumCols(); c++)
            {
                if (grid[r][c] != null)
                {
                    x.add(new Location(r, c));
                }
            }
        }
        return x;
    }
}
