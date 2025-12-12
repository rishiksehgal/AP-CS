import java.util.Scanner;
public class SportsInteraction 
{
    private Scanner scanner;
    private SportsStore store;
    private boolean isRunning;
    
    public SportsInteraction(SportsStore s) 
    {
        scanner = new Scanner(System.in);
        store = s;
        isRunning = true;
    }
    
    public void start() 
    {
        System.out.println();
        System.out.println();
        System.out.println("           " + store.getStoreName().toUpperCase());
        System.out.println();
        System.out.println();
        
        while(isRunning)
        {
            System.out.print("Which section do you wish to browse? (Jerseys/Shoes/Balls/I want to leave your stupid store): ");
            String x = scanner.nextLine();
            Merchandise merchandise = store.getMerchandiseByType(x);
            if (merchandise != null) 
            {
                goToSection(x, merchandise);
                
                System.out.print("Do you wish to buy anything? (Y/N): ");
                if (scanner.nextLine().toUpperCase().equals("Y")) 
                {
                    System.out.print("Which item? (1-4): ");
                    scanner.nextInt();
                    System.out.print("How many?: ");
                    int quantity = scanner.nextInt();
                    if (quantity > merchandise.getLimit()) 
                    {
                        System.out.println("You have reached the limit for this category." + merchandise.getLimit() + " items. You are greedy.");
                    }
                    else 
                    {
                        double total = merchandise.getPrice() * quantity;
                        merchandise.reduceLimit(quantity);
                        
                        System.out.println("Purchase Successful!");
                        System.out.println("Your Total is $" + total);
                    }
                }
                scanner.nextLine();
            }
            else
            {
                isRunning = false;
            }
        }
    }
    
    public void goToSection(String section, Merchandise merchandise) 
    {
        System.out.println();
        System.out.println();
        System.out.println("           " + section.toUpperCase());
        System.out.println();
        System.out.println();
        String[] names = merchandise.getItemNames();
        for (int i = 0; i < names.length; i++) 
        {
            System.out.println((i + 1) + ". " + names[i] + "  $" + merchandise.getPrice() + " (Limit is " + merchandise.getLimit() + ")");
        }
        System.out.println();
        System.out.println();
    }
}