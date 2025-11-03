/**
 * CafeteriaTester tests CafeteriaQueue Class
 * @author Rishik Sehgal
 * @version Nov 2, 2025
 */
public class CafeteriaTester 
{
    /**
     * Tests CafeteriaQueue Class
     * @param args thingy
     */
    public static void main(String[] args) 
    {
        CafeteriaQueue c = new CafeteriaQueue();
        c.addStudent("Freshman", 1,"Freshman");
        c.addStudent("Mason", 2,"Sophomore");
        c.addStudent("Gary", 3,"SuperSenior");
        System.out.println("Queue Size = " + c.a.size());
        while(c.a.size() > 0)
        {
            System.out.println("Served " + c.serveStudent().printDetails());
        }
        c.addStudent("Gooner", 4, "Sophomore");
        System.out.println("Queue Size = " + c.a.size());
        System.out.println("Served" + c.serveStudent().printDetails());
        System.out.println("isEmpty:" + c.a.isEmpty());
        c.addStudent("Lebron", 67, "Goat");
        System.out.println("Peek: " + c.a.element().printDetails());
        System.out.println("Size: " + c.a.size());
        System.out.println("Served: " + c.serveStudent().printDetails());

    }

}
