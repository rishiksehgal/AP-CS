import java.awt.Color;
import java.util.concurrent.Semaphore;

/**
 * Tetrad class represents a tetrad (group of 4 blocks) in Tetris.
 */
public class Tetrad
{
    private Block[] blocks;
    private MyBoundedGrid<Block> grid;
    private Semaphore lock;

    /**
     * Constructs a Tetrad with random shape and color, placed at the top middle of the grid.
     * @param grid the grid to place the tetrad in
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
     * Adds the blocks to the specified locations in the grid.
     * Precondition: blocks are not in any grid; locs.length = 4.
     * Postcondition: The locations of blocks match locs, and blocks have been put in the grid.
     * @param grid the grid
     * @param locs the locations
     */
    private void addToLocations(MyBoundedGrid<Block> grid, Location[] locs)
    {
        for (int i = 0; i < 4; i++)
        {
            blocks[i].putSelfInGrid(grid, locs[i]);
        }
    }

    /**
     * Removes the blocks from the grid.
     * Precondition: Blocks are in the grid.
     * Postcondition: Returns old locations of blocks; blocks have been removed from grid.
     * @return the old locations
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
     * Checks if all locations are valid and empty in the grid.
     * Postcondition: Returns true if each of locs is valid and empty in grid; false otherwise.
     * @param grid the grid
     * @param locs the locations
     * @return true if all empty and valid
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
     * Attempts to move this tetrad deltaRow rows down and deltaCol columns to the right.
     * Postcondition: Attempts to move this tetrad deltaRow rows down and deltaCol columns to the right,
     * if those positions are valid and empty; returns true if successful and false otherwise.
     * @param deltaRow the row delta
     * @param deltaCol the col delta
     * @return true if moved
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
     * Attempts to rotate this tetrad clockwise by 90 degrees about its center.
     * Postcondition: Attempts to rotate this tetrad clockwise by 90 degrees about its center,
     * if the necessary positions are empty; returns true if successful and false otherwise.
     * @return true if rotated
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