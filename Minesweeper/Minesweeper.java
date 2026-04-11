
/**
 * Minesweeper encapsulates the Minesweeper game.
 * 
 * This is where student code goes
 * 
 * @author Mr. Page
 * @author Alexandra Michael modified for Checkstyle
 * @author Susan King modified for comments and moves Main class to main method
 *                    in this class
 * @author March 20, 2025 Rishik Sehgal Added the primary code to the methods 
 *  setMines, countMines, pressed, scanField.
 * @version May 23, 2022
 */
public class Minesweeper
{
    // constants for the size of the field, can be deleted if using default constructor
    private static final int GRID_ROWS = 9;
    private static final int GRID_COLS = 9;
    private static final int NUM_MINES = 10;
    
    // references to the model and the view
    private MinefieldDisplay theDisplay;
    private Minefield theField;

    private boolean timerStarted;
    private boolean[][] flaggedCells;

    /**
     * Initializes the default Minesweeper game.
     */
    public Minesweeper()
    {
        // construct the grid and the display
        theField = new Minefield();
        theDisplay = new MinefieldDisplay(this, theField);
        theDisplay.setFace("/Users/rishiksehgal/dev/AP-CS/Minesweeper/smiley2.gif");
        // set up the mines
        setMines(NUM_MINES);
        flaggedCells = new boolean[theField.numRows()][theField.numCols()];
        timerStarted = false;
    }

    /**
     * Handles button presses.  This method is called whenever the user 
     * selects and clicks on a location within the mine field 
     * that has not been previously selected.
     * 
     * The view actionPerformed method calls this method and 
     * passes the row and col information as int values
     * 
     * @param row   the row the cursor was on when a button was pressed
     * @param col   the column the cursor was on when a button was pressed
     * @param rightButton   true if the right button is pressed; otherwise, 
     *                      false
     */
    public void pressed(int row, int col, boolean rightButton)
    {
        if (rightButton)
        {
            if (!theField.isVisited(row, col))
            {
                if (flaggedCells[row][col])
                {
                    flaggedCells[row][col] = false;
                    theDisplay.setText(row, col, "");
                }
                else
                {
                    flaggedCells[row][col] = true;
                    theDisplay.setText(row, col, "F");
                }
            }
            return;
        }

        if(flaggedCells[row][col])
        {
            return;
        }
        if(!timerStarted)
        {
            theDisplay.startTimer();
            timerStarted = true;
        }

        if(theField.isMine(row, col))
        {
            theDisplay.setFace("/Users/rishiksehgal/dev/AP-CS/Minesweeper/frowny.gif");
            theDisplay.showAll();
            theDisplay.stopTimer();
        }
        else
        {
            scanField(row, col);
            theDisplay.update();
        }
    }

    /**
     * Recursively scans the field and reveals all squares that do not contain mines.
     * Additionally, it labels the squares adjacent to mines with the number of mines 
     * adjacent.
     * 
     * @param row   the row of the cell to be processed
     * @param col   the column of the cell to be processed
     */
    public void scanField(int row, int col)
    {
        if(!theField.isValid(row, col) || theField.isVisited(row, col) || theField.isMine(row, col) 
            ||flaggedCells[row][col])
        {
            return;
        }
        theField.markVisited(row, col);
        if (countMines(row, col) == 0)
        {
            for (int i = row - 1; i <= row + 1; i++) 
            {
                for (int j = col - 1; j <= col + 1; j++) 
                {
                    if (i != row || j != col) 
                    {
                        scanField(i, j);
                    }
                }
            }
        }
    }

    /**
     * Sets up the mine field in a random pattern.
     * 
     * @param numMines  the number of mines that the user wants set up.
     */
    public void setMines(int numMines)
    {
        int count = 0;
        while (count < numMines) 
        {
            int x = (int) (Math.random() * theField.numRows());
            int y = (int) (Math.random() * theField.numCols());
            if (!theField.isMine(x, y)) 
            {
                theField.add(x, y);
                count++;
            }
        }

    }

    /**
     * Counts the number of mines adjacent to a given location.
     * 
     * @param row   the row of the cell in which adjacent mines are being counted
     * @param col   the column of the cell in which adjacent mines are being counted
     * @return the number of mines adjacent to the given location
     */
    public int countMines(int row, int col)
    {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) 
        {
            for (int c = col - 1; c <= col + 1; c++) 
            {
                if (theField.isValid(r, c) && theField.isMine(r, c)) 
                {
                    count++;
                }
            }
        }
        return count;
    }
      

    /**
     * Starts the game Minesweeper.
     * 
     * @param args  information from the command line
     */
    public static void main(String[] args)
    {
        Minesweeper gameMaster = new Minesweeper();
    }
}
