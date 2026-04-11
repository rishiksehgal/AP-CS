/**
 * Models hurricane information, including categories.  
 * Works with HurricaneOrganizer, provides object and comparison skeletons.
 * 
 * @author Rishik Sehgal
 * @version February 23rd, 2026
 */
public class Hurricane
{
    
    //Instance variables
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;
    private int category;

    /**
     * Initializes a Hurricane object with no information.
     */
    public Hurricane( )
    {
        
    }

    /**
     * Initializes a Hurricane object with historical information.
     * 
     * @param year      year the hurricane took place
     * @param month     month in String format
     * @param pressure  hurricane's pressure
     * @param speed     hurricane's speed in knots
     * @param name      hurricane's name
     */
    public Hurricane(int year, String month, 
        int pressure, int speed, String name)
    {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
        this.category = determineCategory(speed);
    }

    /**
     * Based upon Saffir/Simpson Hurricane Scale, figures out
     * the category using wind speed in knots.
     * 
     * Use https://en.wikipedia.org/wiki/Saffir%E2%80%93Simpson_scale.
     * 
     * @param knots     wind speed in knots
     * @return Saffir/Simpson Hurricane Scale category
     */
    public int determineCategory(int knots)
    {
        if (knots >= 157)
        {
            return 5;
        }
        else if (knots >= 130)
        {
            return 4;
        }
        else if (knots >= 111)
        {
            return 3;
        }
        else if (knots >= 96)
        {
            return 2;
        }
        else if (knots >= 74)
        {
            return 1;
        }
        return 0;
    }

    //Getters

    /**
     * Returns the name
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the month
     * @return month
     */
    public String getMonth()
    {
        return month;
    }

    /**
     * Returns the pressure
     * @return pressure
     */
    public int getPressure()
    {
        return pressure;
    }

    /**
     * Returns the speed
     * @return speed
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * Returns the year
     * @return year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the category
     * @return category
     */
    public int getCategory()
    {
        return category;
    }

    /**
     * Prints the toString
     */
    public void print()
    {
        System.out.println(toString( ));
    }

    /**
     * Returns the toString representation of the Hurricane
     * @return the representation of the Hurricane
     */
    public String toString()
    {
        return String.format("%-4d %-5s %-15s %-5d %5d %5d ", 
               year, month, name, category, speed, pressure);
    }

    /**
     * Compares the year of the Hurricane to another hurricane
     * @param h is the hurricane being compared to
     * @return the difference in the years of the two hurricanes
     */
    public int compareYearTo(Hurricane h)
    {
        return getYear() - h.getYear();
    }

    /**
     * Compares the names of the two hurricanes
     * @param h is the hurricane being compared to
     * @return the number result from comparing their names
     */
    public int compareNameTo(Hurricane h)
    {
        return getName().compareTo(h.getName());
    }

    /**
     * Compares the pressures of the two hurricanes
     * @param h is the hurricane being compared to
     * @return the pressure difference
     */
    public int comparePressureTo(Hurricane h)
    {
        return getPressure() - h.getPressure();
    }

    /**
     * Compares the speeds of the two hurricanes
     * @param h is the hurricane being compared to
     * @return the speed difference
     */
    public int compareSpeedTo(Hurricane h)
    {
        return getSpeed() - h.getSpeed();
    }

    /**
     * Compares the categories of the two hurricanes
     * @param h is the hurricane being compared to
     * @return the category difference
     */
    public int compareCategoryTo(Hurricane h)
    {
        return getCategory() - h.getCategory();
    }
}
