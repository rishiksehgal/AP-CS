import java.io.*;
/**
 * Tests the scanner class
 *
 * @author Anu Datar
 * @version 05/17/2018
 */
public class ScannerTester
{
    /**
     *  Main tester method 
     *
     * @param  str array of String objects 
     */
    public static void main(String[] str) throws FileNotFoundException
    {
        FileReader reader = new FileReader(new File("./AuthorLab/MysteryText/mystery1.txt"));
        Scanner scanner = new Scanner(reader);
        
        while(scanner.hasNextToken())
        {
            System.out.println(scanner.nextToken());
        }
    }
}
