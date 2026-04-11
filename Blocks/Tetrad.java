import java.awt.Color;
import java.util.concurrent.Semaphore;

/**
* Tetrad class is a tetris block
* @author Rishik
* @version 1
*/
public class Tetrad
{
    private Block[] blocks;
    private MyBoundedGrid<Block> grid;
    private Semaphore lock;

    /**
     * Creates a Tetrad object with random atributes
     * @param g is the grid it is put in
     */
    public Tetrad(MyBoundedGrid<Block> g)
    {
        grid = g;
        blocks = new Block[4];
        lock = new Semaphore(1, true);
        for(int i = 0; i < 4; i++)
        {
            blocks[i] = new Block();
        }
        int x = (int) (Math.random() * 7);
        Color color;
        Location[] locs = new Location[4];
        int mid = grid.getNumCols() / 2;
        if(x == 0)
        {
            locs[0] = new Location(1, mid);
            locs[1] = new Location(0, mid);
            locs[2] = new Location(2, mid);
            locs[3] = new Location(3, mid);
            color = Color.RED;
        }
        else if(x == 1)
        {
            locs[0] = new Location(0, mid);
            locs[1] = new Location(0, mid-1);
            locs[2] = new Location(0, mid+1);
            locs[3] = new Location(1,mid);
            color = Color.GRAY;
        }
        else if(x == 2)
        {
            locs[0] = new Location(0, mid-1);
            locs[1] = new Location(0, mid);
            locs[2] = new Location(1, mid-1);
            locs[3] = new Location(1,mid);
            color = Color.CYAN;
        }
        else if(x == 3)
        {
            locs[0] = new Location(2, mid-1);
            locs[1] = new Location(0, mid-1);
            locs[2] = new Location(1, mid-1);
            locs[3] = new Location(2,mid);
            color = Color.YELLOW;
        }
        else if(x == 4)
        {
            locs[0] = new Location(2, mid);
            locs[1] = new Location(0, mid);
            locs[2] = new Location(1, mid);
            locs[3] = new Location(2,mid - 1);
            color = Color.MAGENTA;
        }
        else if(x == 5)
        {
            locs[0] = new Location(0, mid);
            locs[1] = new Location(0, mid-1);
            locs[2] = new Location(1, mid);
            locs[3] = new Location(1,mid+1);
            color = Color.BLUE;
        }
        else
        {
            locs[0] = new Location(0, mid);
            locs[1] = new Location(0, mid+1);
            locs[2] = new Location(1, mid-1);
            locs[3] = new Location(1,mid);
            color = Color.GREEN;
        }
        addToLocations(grid, locs);
        for(Block y: blocks)
        {
            y.setColor(color);
        }
    }

    /**
     * Adds given blocks to the given grid
     * @precondition blocks are not in any grid; locs.length = 4.
     * @postcondition The locations of blocks match locs, and blocks have been put in the grid.
     * @param grid the grid
     * @param locs are the locations
     */
    private void addToLocations(MyBoundedGrid<Block> grid, Location[] locs)
    {
        for (int i = 0; i < 4; i++)
        {
            blocks[i].putSelfInGrid(grid, locs[i]);
        }
    }

    /**
     * Removes blocks from grid
     * @precondition Blocks are in the grid.
     * @postcondition Returns old locations of blocks; blocks have been removed from grid.
     * @return old locations
     */
    private Location[] removeBlocks()
    {
        Location[] x = new Location[4];
        for (int i = 0; i < 4; i++)
        {
            x[i] = blocks[i].getLocation();
            blocks[i].removeSelfFromGrid();
        }
        return x;
    }

    /**
     * Determines if a group of locations are empty
     * @postcondition Returns true if each of locs is valid and empty in grid; false otherwise.
     * @param grid is the grid
     * @param locs are the locations
     * @return true if all of the locations are empty and valid locations
     */
    private boolean areEmpty(MyBoundedGrid<Block> grid, Location[] locs)
    {
        for (Location x : locs)
        {
            if (!grid.isValid(x) || grid.get(x) != null)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Moves tetrad by deltaRow rowa and deltaCol columns
     * @postcondition Attempts to move this tetrad deltaRow rows down and deltaCol columns to the right,
     * if those positions are valid and empty; returns true if successful and false otherwise.
     * @param deltaRow delta row
     * @param deltaCol delta col
     * @return true if it is moved
     */
    public boolean translate(int deltaRow, int deltaCol)
    {
        try
        {
            lock.acquire();
            Color color = blocks[0].getColor();
            Location[] x = removeBlocks();
            Location[] newLocs = new Location[4];
            for (int i = 0; i < 4; i++)
            {
                newLocs[i] = new Location(x[i].getRow() + deltaRow, x[i].getCol() + deltaCol);
            }
            if (areEmpty(grid, newLocs))
            {
                addToLocations(grid, newLocs);
                for(Block y: blocks)
                {
                    y.setColor(color);
                }
                return true;
            }
            else
            {
                addToLocations(grid, x);
                for(Block y: blocks)
                {
                    y.setColor(color);
                }
                return false;
            }
        }
        catch (InterruptedException e)
        {
            return false;
        }
        finally
        {
            lock.release();
        }
    }

    /**
     * Rotates tetrad 90 degrees clockwise about center
     * @postcondition Attempts to rotate this tetrad clockwise by 90 degrees about its center,
     * if the necessary positions are empty; returns true if successful and false otherwise.
     * @return true if it is rotated
     */
    public boolean rotate()
    {
        try
        {
            lock.acquire();
            Color color = blocks[0].getColor();
            Location[] oldLocs = removeBlocks();
            int cRow = oldLocs[0].getRow();
            int cCol = oldLocs[0].getCol();
            Location[] newLocs = new Location[4];
            for (int i = 0; i < 4; i++)
            {
                int row = oldLocs[i].getRow();
                int col = oldLocs[i].getCol();
                newLocs[i] = new Location(cRow - cCol + col, cRow + cCol - row);
            }
            if (areEmpty(grid, newLocs))
            {
                addToLocations(grid, newLocs);
                for(Block b : blocks)
                {
                    b.setColor(color);
                }
                return true;
            }
            else
            {
                addToLocations(grid, oldLocs);
                for(Block b : blocks)
                {
                    b.setColor(color);
                }
                return false;
            }
        }
        catch (InterruptedException e)
        {
            return false;
        }
        finally
        {
            lock.release();
        }
    }
}