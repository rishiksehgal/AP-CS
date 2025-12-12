import java.util.Scanner;
import java.util.ArrayList;

/**
 * SportsInteraction handles all the input for the SportsStore.
 * 
 * @author Rishik Sehgal
 * @version Dec 12, 2025
 *
 */ 
public class SportsInteraction 
{
    private Scanner scanner;
    private SportsStore store;
    private boolean isRunning;
    private ArrayList<String> cart;
    private double checkout;

    /**
     * Creates a SportsInteraction object
     * @param s the SportsStore object to be utilized
     */
    public SportsInteraction(SportsStore s) 
    {
        scanner = new Scanner(System.in);
        store = s;
        isRunning = true;
        cart = new ArrayList<String>();
        checkout = 0.00;
    }
    
    /**
     * Starts the program
     */
    public void start() 
    {
        System.out.println();
        System.out.println();
        System.out.println("            " + store.getStoreName().toUpperCase() + " STORE");
        System.out.println();
        System.out.println();

        while(isRunning)
        {
            System.out.print("Wallet Balance: " + store.getWalletBalance() + 
                "  What do you want to do? (Jerseys/Shoes/Balls/Checkout/Exit)");
            String x = scanner.nextLine();
            if (x.toLowerCase().equals("checkout"))
            { 
                showCart();
                store.setWalletBalance(store.getWalletBalance() - checkout);
                checkout = 0.00;
                cart = new ArrayList<String>();
            }
            else if(x.toLowerCase().equals("exit"))
            {
                isRunning = false;
            }
            else
            {
                Merchandise m  = store.determineType(x);
                if (m != null) 
                {
                    store.goToItem(m); 
                    System.out.print("Do you want to add something to your cart? (Y/N)");
                    if (scanner.nextLine().toLowerCase().equals("y")) 
                    {
                        System.out.print("Choose an item? (1-4)");
                        int y = scanner.nextInt();
                        System.out.print("Quantity: ");
                        int z = scanner.nextInt();
                        scanner.nextLine();
                        if((checkout + (m.getPrice() * z)) > store.getWalletBalance())
                        {
                            System.out.println("Stop trying to shoplift.");
                        }
                        else
                        {
                            checkout += (m.getPrice() * (double) z);
                            cart.add(z + "  " + m.getItemNames()[y - 1] + " $" + 
                                m.getPrice() * (double) z);
                            System.out.println("Added to your cart.");
                        }
                    }
                }
            }
            
            System.out.println();
        }
    }

    /**
     * Displays the cart of the user if they wish to checkout.
     */
    public void showCart()
    {
        System.out.println();
        System.out.println("    CART");
        if (cart.isEmpty()) 
        {
            System.out.println("Empty Cart");
        }
        else
        {
            for(int i = 0; i < cart.size(); i++)
            {
                System.out.println(cart.get(i));
            }
        }
        System.out.println("Purchase Successful");
    }
}