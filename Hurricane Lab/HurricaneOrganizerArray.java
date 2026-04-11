import java.io.*;
import java.util.Scanner;

/**
 * Models hurricane information, works with Hurricane class
 * and the user to manipulate an array of hurricane data.
 * 
 * Data came from http://www.aoml.noaa.gov/hrd/tcfaq/E23.html except for 2018.
 * 2018 data came from https://en.wikipedia.org/wiki/2018_Atlantic_hurricane_season.
 *
 * @author Rishik Sehgal 
 * @version January 17, 2019
 * @version February 10, 2020 Polished code via variable names
 * @version February 23, 2026 Rishik was here
 */
public class HurricaneOrganizerArray
{
    private Hurricane [] hurricanes;

    /**
     * Creates a hurricane organizer
     * 
     * @param filename is the name of the file
     * @throws IOException  if file with the hurricane information cannot be found
     * 
     */
    public HurricaneOrganizerArray(String filename)throws IOException
    {
        readFile(filename);   
    }

    /**
     * Comment this method even though you did not write it.
     * @param filename is the name of the file
     * @return the length of the file
     * @throws IOException  if file with the hurricane information cannot be found
     */
    private static int determineFileLength(String filename) throws IOException
    {
        Scanner inFile = new Scanner(new File(filename));
        int counter = 0;

        while(inFile.hasNextLine())
        {
            counter++;
            inFile.nextLine();
        }
        inFile.close();
        return counter;
    }

    /**
     * Reads the file
     * @param filename file being read
     */
    public void readFile(String filename) throws IOException
    {
        hurricanes = new Hurricane [determineFileLength(filename)];
        int hurYear, hurPressure, hurSpeed;
        String hurName, hurMonth;
        Scanner inFile = new Scanner(new File(filename));

        for(int i = 0; i < hurricanes.length; i++)
        {
            hurYear = inFile.nextInt();
            hurMonth = inFile.next();
            hurPressure = inFile.nextInt();
            hurSpeed = inFile.nextInt();
            String tempName = inFile.nextLine();
            hurName = "";
            for(int k = 0; k < tempName.length(); k++)
            {
                char c = tempName.charAt(k);
                if(('a' <= c && c <= 'z') || ('A' <= c && c <='Z'))
                    hurName += c;
            }
            Hurricane h = new Hurricane(hurYear, hurMonth, hurPressure, hurSpeed, hurName);
            hurricanes [i] = h;
        }
        inFile.close();
    }

    /**
     * Determines the maxwindspeed
     * @return the max wind speed
     */
    public int findMaxWindSpeed( )
    {
        if (hurricanes.length == 0)
        {
            return 0;
        }
        int temp = 0;
        for (int i = 1; i < hurricanes.length; i++)
        {
            if (hurricanes[i].getSpeed() > hurricanes[temp].getSpeed())
            {
                temp = i;
            }
        }
        return hurricanes[temp].getSpeed();
    }

    /**
     * Determines the max pressure
     * @return the max pressure
     */
    public int findMaxPressure( )
    {
        if (hurricanes.length == 0)
        {
            return 0;
        }
        int temp = 0;
        for (int i = 1; i < hurricanes.length; i++)
        {
            if (hurricanes[i].getPressure() > hurricanes[temp].getPressure())
            {
                temp = i;
            }
        }
        return hurricanes[temp].getPressure();
    }

    /**
     * Determines the minimum windspeed
     * @return the minimum wind speed
     */
    public int findMinWindSpeed( )
    {
        if (hurricanes.length == 0)
        {
            return 0;
        }
        int temp = 0;
        for (int i = 1; i < hurricanes.length; i++)
        {
            if (hurricanes[i].getSpeed() < hurricanes[temp].getSpeed())
            {
                temp = i;
            }
        }
        return hurricanes[temp].getSpeed();
    }

    /**
     * Determines the minimum pressure
     * @return the minimum pressure
     */
    public int findMinPressure( )
    {
        if (hurricanes.length == 0)
        {
            return 0;
        }
        int temp = 0;
        for (int i = 1; i < hurricanes.length; i++)
        {
            if (hurricanes[i].getPressure() < hurricanes[temp].getPressure())
            {
                temp = i;
            }
        }
        return hurricanes[temp].getPressure();
    }

    /**
     * Returns the average wind speed of the hurricanes
     * @return the average wind speed of the hurricanses
     */
    public double calculateAverageWindSpeed( )
    {
        if (hurricanes.length == 0)
        {
            return 0.0;
        }
        double x = 0;
        for (int i = 0; i < hurricanes.length; i++)
        {
            x += hurricanes[i].getSpeed();
        }
        return x / hurricanes.length;
    }

    /**
     * Returns the average pressure of the hurricanes
     * @return average pressure of the hurricanes
     */
    public double calculateAveragePressure( )
    {
        if (hurricanes.length == 0)
        {
            return 0.0;
        }
        double x = 0;
        for (int i = 0; i < hurricanes.length; i++)
        {
            x += hurricanes[i].getPressure();
        }
        return x / hurricanes.length;
    }

    /**
     * Returns the average category of the hurricanes
     * @return average category of the hurricanes
     */
    public double calculateAverageCategory( )
    {
        if (hurricanes.length == 0)
        {
            return 0.0;
        }
        double x = 0;
        for (int i = 0; i < hurricanes.length; i++)
        {
            x += hurricanes[i].getCategory();
        }
        return x / hurricanes.length;
    }
    
    /**
     * Sorts ascending based upon the hurricanes' years,
     * The algorithm is selection sort.
     */
    public void sortYears()
    {
        for (int i = 0; i < hurricanes.length - 1; i++)
        {
            int min = i;
            for (int j = i + 1; j < hurricanes.length; j++)
            {
                if (hurricanes[j].getYear() < hurricanes[min].getYear())
                {
                    min = j;
                }
            }
            Hurricane temp = hurricanes[i];
            hurricanes[i] = hurricanes[min];
            hurricanes[min] = temp;
        }
    }

    /**
     * Lexicographically sorts hurricanes based on the hurricanes' name, 
     * using insertion sort.
     */
    public void sortNames()
    {
        for (int i = 1; i < hurricanes.length; i++)
        {
            Hurricane x = hurricanes[i];
            int a = i - 1;
            while (a >= 0 && hurricanes[a].getName().compareTo(x.getName()) > 0)
            {
                hurricanes[a + 1] = hurricanes[a];
                a--;
            }
            hurricanes[a + 1] = x;
        }
    }

    /**
     * Sorts descending based upon the hurricanes' categories,
     * using selection sort.
     */
    public void sortCategories()
    {
        for (int i = 0; i < hurricanes.length - 1; i++)
        {
            int max = i;
            for (int j = i + 1; j < hurricanes.length; j++)
            {
                if (hurricanes[j].getCategory() > hurricanes[max].getCategory())
                {
                    max = j;
                }
            }
            Hurricane temp = hurricanes[i];
            hurricanes[i] = hurricanes[max];
            hurricanes[max] = temp;

        }
    }  

    /**
     * Sorts descending based upon pressures using a non-recursive merge sort.
     */
    public void sortPressures()
    {
        for (int width = 1; width < hurricanes.length; width *= 2)
        {
            for (int left = 0; left < hurricanes.length; left += 2 * width)
            {
                int right = Math.min(left + 2 * width, hurricanes.length);
                sortPressuresHelper(left, right);
            }
        }
    }
    
    /**
     * Sorts descending a portion of array based upon pressure, 
     * using selection sort.
     * 
     * @param   start   the first index to start the sort
     * @param   end     one past the last index to sort; hence, end position
     *                  is excluded in the sort
     */
    private void sortPressuresHelper (int start, int end)
    {
        for (int i = start; i < end - 1; i++)
        {
            int max= i;
            for (int j = i + 1; j < end; j++)
            {
                if (hurricanes[j].getPressure() > hurricanes[max].getPressure())
                {
                    max = j;
                }
            }
            Hurricane temp = hurricanes[i];
            hurricanes[i] = hurricanes[max];
            hurricanes[max] = temp;
        }
    }

    /**
     * Sorts ascending based upon wind speeds using a recursive merge sort. 
     * @param low is the low
     * @param high is the high
     */
    public void sortWindSpeeds(int low, int high)
    {
        low = Math.max(0, low);
        high = Math.min(hurricanes.length - 1, high);
        if (low >= high)
        {
            return;
        }
        int m = (low + high) / 2;
        sortWindSpeeds(low, m);
        sortWindSpeeds(m + 1, high);
        mergeWindSpeedsSortHelper(low, m + 1, high);
    }

    /**
     * Merges two consecutive parts of an array, using wind speed as a criteria
     * and a temporary array.  The merge results in an ascending sort between
     * the two given indices.
     * 
     * @precondition the two parts are sorted ascending based upon wind speed
     * 
     * @param low   the starting index of one part of the array.
     *              This index is included in the first half.
     * @param mid   the starting index of the second part of the array.
     *              This index is included in the second half.
     * @param high  the ending index of the second part of the array.  
     *              This index is included in the merge.
     */
    private void mergeWindSpeedsSortHelper(int low, int mid, int high)
    {
        Hurricane[] temp = new Hurricane[high - low + 1];
        int i = low;
        int j = mid;
        int k = 0;
        while (i <= mid - 1 && j <= high)
        {
            if (hurricanes[i].getSpeed() <= hurricanes[j].getSpeed())
            {
                temp[k++] = hurricanes[i++];
            }
            else
            {
                temp[k++] = hurricanes[j++];
            }
        }
        while (i <= mid - 1)
        {
            temp[k++] = hurricanes[i++];
        }
        while (j <= high)
        {
            temp[k++] = hurricanes[j++];
        }
        for (k = 0; k < temp.length; k++) 
        {
            hurricanes[low + k] = temp[k];
        }
    }

    /**
     * Sequential search for all the hurricanes in a given year.
     * 
     * @param   year is the year
     * @return  an array of objects in Hurricane that occured in
     *          the parameter year
     */
    public Hurricane [] searchYear(int year)
    {
        int count = 0;
        for (int i = 0 ; i < hurricanes.length; i ++)
        {
            if (hurricanes[i].getYear() == year)
            {
                count++;
            }
        }
        if (count == 0) 
        {
            return new Hurricane[0];
        }
        Hurricane[] m = new Hurricane[count];
        int j = 0;
        for (int i = 0; i < hurricanes.length; i++)
        {
            if (hurricanes[i].getYear() == year)
            {
                m[j++] = hurricanes[i];
            }
        }
        return m;
    }     

    /**
     * Binary search for a hurricane name.
     * 
     * @param  name   hurricane name being search
     * @return a Hurricane array of all objects in hurricanes with specified name. 
     *         Returns null if there are no matches
     */
    public Hurricane[ ] searchHurricaneName(String name)
    {
        sortNames();
        return searchHurricaneNameHelper(name, 0, hurricanes.length - 1);
    }

    /**
     * Recursive binary search for a hurricane name.  This is the helper
     * for searchHurricaneName.
     * 
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name  hurricane name to search for
     * @param   low   the smallest index that needs to be checked
     * @param   high  the highest index that needs to be checked
     * @return  a Hurricane array of all Hurricane objects with a specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] searchHurricaneNameHelper(String name, int low , int high)
    {
        if (low > high)
        {
            return null;
        }
        int mid = (low + high) / 2;
        int c = name.compareTo(hurricanes[mid].getName());
        if (c == 0)
        {
            return retrieveMatchedNames(name, mid);
        }
        else if (c < 0)
        {
            return searchHurricaneNameHelper(name, low, mid - 1);
        }
        else
        {
            return searchHurricaneNameHelper(name, mid + 1, high);
        }
    }

    /**
     * Supports Binary Search method to get the full range of matches.
     * 
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name hurricane name being search for
     * @param   index  the index where a match was found
     * @return  a Hurricane array with objects from hurricanes with specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] retrieveMatchedNames (String name, int index)
    {
        int start = index;
        while (start - 1 >= 0 && hurricanes[start - 1].getName().equals(name))
        {
            start--;
        }
        int end = index;
        while (end + 1 < hurricanes.length && hurricanes[end + 1].getName().equals(name))
        {
            end++;
        }
        int len = end - start + 1;
        if(len == 0)
        {
            return null;
        }
        Hurricane[] matches = new Hurricane[len];
        for (int i = 0; i < len; i++)
        { 
            matches[i] = hurricanes[start + i];
        }
        return matches;
    }

    /**
     * Prints Header
     */
    public void printHeader()
    {
        System.out.println("\n\n");
        System.out.printf("%-4s %-5s %-15s %-5s %-5s %-5s \n", 
            "Year", "Mon.", "Name", "Cat.", "Knots", "Pressure");
    }

    /**
     * Prints Hurricanes
     */
    public void printHurricanes()
    {
        printHurricanes(hurricanes);
    }

    /**
     * Prints hurricane
     * @param hurs hurricane array
     */
    public void printHurricanes(Hurricane [] hurs)
    {
        if(hurs.length == 0)
        {
            System.out.println("\nVoid of hurricane data.");
            return;
        }
        printHeader();
        for(Hurricane h: hurs)
        {
            System.out.println(h);
        }
    }

    /**
     * Prints menu
     */
    public void printMenu()
    {
        System.out.println("\n\nEnter option: ");
        System.out.println("\t 1 - Print all hurricane data \n" +
            "\t 2 - Print maximum and minimum data \n" +
            "\t 3 - Print averages \n" +
            "\t 4 - Sort hurricanes by year \n" +
            "\t 5 - Sort hurricanes by name \n" +
            "\t 6 - Sort hurricanes by category, descending \n" +
            "\t 7 - Sort hurricanes by pressure, descending \n" +
            "\t 8 - Sort hurricanes by speed \n" + 
            "\t 9 - Search for hurricanes for a given year \n" +
            "\t10 - Search for a given hurricane by name \n" +
            "\t11 - Quit \n");
    }

    /**
     * Prints max and min
     */
    public void printMaxAndMin( )
    {
        System.out.println("Maximum wind speed is " + 
            findMaxWindSpeed( ) +
            " knots and minimum wind speed is " + 
            findMinWindSpeed( ) + " knots.");
        System.out.println("Maximum pressure is " + 
            findMaxPressure( ) +
            " and minimum pressure is " + 
            findMinPressure( ) + ".");
    }

    /**
     * Prints averages
     */
    public void printAverages( )
    {
        System.out.printf("Average wind speed is %5.2f knots. \n" , 
            calculateAverageWindSpeed( ));
        System.out.printf("Average pressure is %5.2f. \n" , 
            calculateAveragePressure( ));
        System.out.printf("Average category is %5.2f. \n" , 
            calculateAverageCategory( ));
    }

    /**
     * Interacts with user
     * @return true if done
     */
    public boolean interactWithUser( )
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        printMenu();
        int choice = in.nextInt();
        // clear the input buffer
        in.nextLine();

        if(choice == 1)
        {
            printHurricanes( ); 
        }
        else if (choice == 2)
        {
            printMaxAndMin( );
        }
        else if (choice == 3)
        {
            printAverages( );
        }
        else if(choice == 4)
        {
            sortYears();
            printHurricanes( );
        }
        else if(choice == 5)
        {
            sortNames();
            printHurricanes( );
        }
        else if(choice == 6)
        {
            sortCategories();
            printHurricanes( );
        }
        else if(choice == 7)
        {
            sortPressures();
            printHurricanes( );
        }
        else if(choice == 8)
        {
            sortWindSpeeds(0, hurricanes.length - 1);
            printHurricanes( );
        }
        else if(choice == 9)
        {
            System.out.print("\n\tWhich year do you want to search for?\n\t");
            int year = in.nextInt();
            printHurricanes(searchYear(year));
        }
        else if(choice == 10)
        {
            System.out.print("\n\tWhich name do you want to search for?\n\t");
            String name = in.next();
            printHurricanes(searchHurricaneName(name));
        }
        else if (choice == 11)
        {
            done = true;
        }  
        return done;
    }

    /**
     * Comment the method even though you did not write it.
     * 
     * @param args  user's information from the command line
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     */
    public static void main (String [] args) throws IOException
    {
        HurricaneOrganizerArray cane = new HurricaneOrganizerArray("hurricanedata.txt");
        boolean areWeDoneYet = false;
        while ( ! areWeDoneYet)
        {
            areWeDoneYet = cane.interactWithUser( );    
        }
    }
}
