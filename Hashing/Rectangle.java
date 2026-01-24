/**
 * Rectangle is a rectangle.
 *
 * @author Rishik Sehgal
 * @version 1
 */
public class Rectangle
{
    private int length;
    private int width;

    /**
     * Creates a Rectangle.
     *
     * @param len is the length
     * @param w the width
     */
    public Rectangle(int len, int w)
    {
        length = len;
        width = w;
    }

    /**
     * Returns the length.
     *
     * @return the length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Returns the width.
     *
     * @return the width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Returns the string corresponding to the rectangle
     *
     * @return string corresponding to the rectangle
     */
    public String toString()
    {
        return length + "x" + width;
    }

    /**
     * Determines if the rectangle is equal to another object
     *
     * @param obj being compared to
     * @return true if tthey are equal
     */
    public boolean equals(Object obj)
    {
        if ((obj instanceof Rectangle))
        {
            Rectangle casted = (Rectangle) obj;
            if(length == casted.getLength() && width == casted.getWidth())
            {
                return true;
            }
            return false;
        }
        return false;
        
    }

    /**
     * Returns the hashCode for the rectangle
     * @return the hashCode for the rectangle
     */
    public int hashCode()
    {
        return (getLength() + getWidth()) % 5;
    }
}