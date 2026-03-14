/**
 * MyLocation represents two coordinates for a location
 * 
 * @author Rishik Sehgal
 * @version Mar 2, 2026
 *
 */ 
public class MyLocation implements Comparable
{
    private int row;
    private int col;

    /**
     * Constructor: MyLocation()
     * Usage: MyLocation loc = new MyLocation(row, col);
     * -----------------------------
     * creates a MyLocation object with the given row & col
     * 
     * @param r - row of this MyLocation
     * @param c - column of this MyLocaiton
     */
    public MyLocation(int r, int c)
    {
        row = r;
        col = c;
    }

    /**
     * Method: getRow()
     * Usage: returns row
     * @return row
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Method: getCol()
     * Usage: returns col
     * @return col
     */
    public int getCol()
    {
        return col;
    }

    /**
     * Method: equals()
     * Usage:Determines if two objects are equivalent
     * @param other object being analyzed
     * @return true if objects are equal
     */
    public boolean equals(Object other)
    {
        if (!(other instanceof MyLocation)) 
        {
            return false;
        }
        MyLocation x = (MyLocation) other;
        return getRow() == x.getRow() && getCol() == x.getCol();
    }

    /**
     * Method: toString()
     * Usage: Returns String representation of location
     * @return string representation of location
    */
    public String toString()
    {
        return "(" + row + ", " + col + ")";
    }

    /**
     * Method: compareTo()
     * Usage: Compares two Location objects
     * @param x object being compared to
     * @return a positive number if current location is larger than x
     */
    public int compareTo(Object x)
    {
        if (x == null) 
        {
            throw new NullPointerException();
        }
        else if (!(x instanceof MyLocation))
        {
            throw new ClassCastException("Object has to be a MyLocation Object");
        }
        MyLocation y = (MyLocation) x;
        if (getRow() != y.getRow())
        {
            return getRow() - y.getRow();
        }
        return getCol() - y.getCol();
    }
}