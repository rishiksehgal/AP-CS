/**
* Tetris class represents a game of Tetris
* @author Rishik
* @version 1
*/
public class Tetris implements ArrowListener
{
    private MyBoundedGrid<Block> grid;
    private BlockDisplay display;
    private Tetrad current;

    /**
     * Creates a Tetris game by creating a Tetris object
     */
    public Tetris()
    {
        grid = new MyBoundedGrid<>(20, 10);
        display = new BlockDisplay(grid);
        display.setTitle("Tetris");
        display.setArrowListener(this);
        current = new Tetrad(grid);
        display.showBlocks();
    }

    /**
     * Plays the game and drops a tetrad every second.
     */
    public void play()
    {
    while (true)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }

        if(!current.translate(1,0))
        {
            clearCompletedRows();
            current = new Tetrad(grid);
        }

        display.showBlocks();
    }
}

    /**
     * Clears all completed rows
     */
    private void clearCompletedRows()
    {
        for (int row = grid.getNumRows() - 1; row >= 0; row--)
        {
            if (isCompletedRow(row))
            {
                clearRow(row);
                row++;
            }
        }
    }

    /**
     * Determines if a row is completed
     * @param row the row being analyzed
     * @return true if the row is completed
     */
    private boolean isCompletedRow(int row)
    {
        for (int i = 0; i < grid.getNumCols(); i++)
        {
            if (grid.get(new Location(row, i)) == null)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Clears the row and moves all higher rows down
     * @param row is the row to be cleared
     */
    private void clearRow(int row)
    {
        for (int i = 0; i < grid.getNumCols(); i++)
        {
            grid.remove(new Location(row, i));
        }
        for (int i = 0; i < row; i++)
        {
            for (int k = 0; k < grid.getNumCols(); k++)
            {
                if(grid.get(new Location(i,k)) instanceof Block)
                {
                    Block temp = grid.get(new Location(i, k));
                    temp.moveTo(new Location(i+1, k));
                }
            }
        }
    }

    /**
     * Rotates block around its center 90 degrees. 
     */
    @Override
    public void upPressed()
    {
        current.rotate();
        display.showBlocks();
    }

    /**
     * Moves the piece down
     */
    @Override
    public void downPressed()
    {
        current.translate(1, 0);
        display.showBlocks();
    }

    /**
     * Moves piece to the left
     */
    @Override
    public void leftPressed()
    {
        current.translate(0, -1);
        display.showBlocks();
    }

    /**
     * Moves the piece to the right
     */
    @Override
    public void rightPressed()
    {
        current.translate(0, 1);
        display.showBlocks();
    }

    /**
     * Main method that runs the game
     * @param args thingy
     */
    public static void main(String[] args)
    {

        Tetris x = new Tetris();
        while(true)
        {
            x.play();
        }
    }
}
