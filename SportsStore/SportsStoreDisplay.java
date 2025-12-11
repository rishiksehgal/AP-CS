import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class SportsStoreDisplay extends JComponent
{
    private static final int IMAGE_WIDTH = 150;
    private static final int IMAGE_HEIGHT = 150;
    private static final int SPACING = 20;
    
    private JFrame frame;
    private SportsStore store;
    private Merchandise[] currentItems;
    private String currentSection;
    public SportsStoreDisplay(SportsStore store)
    {
        this.store = store;
        this.currentItems = null;
        this.currentSection = "";
        
        frame = new JFrame(store.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        this.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    public void paintComponent(Graphics g)
    {
        // White background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if (currentItems == null)
        {
            // Display store name centered
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            String name = store.getName();
            FontMetrics fm = g.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(name)) / 2;
            int y = (getHeight() + fm.getAscent()) / 2;
            g.drawString(name, x, y);
        }
        else
        {
            // Display section title
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 32));
            FontMetrics fm = g.getFontMetrics();
            int titleX = (getWidth() - fm.stringWidth(currentSection)) / 2;
            g.drawString(currentSection, titleX, 50);
            
            // Display 4 items in a 2x2 grid (simple placeholders)
            g.setFont(new Font("Arial", Font.PLAIN, 14));
            
            int startX = SPACING * 2;
            int startY = 80;
            int cellWidth = (getWidth() - SPACING * 5) / 2;
            int cellHeight = (getHeight() - startY - SPACING * 3) / 2;
            
            for (int i = 0; i < 4 && i < currentItems.length && currentItems[i] != null; i++)
            {
                int row = i / 2;
                int col = i % 2;
                
                int x = startX + col * (cellWidth + SPACING);
                int y = startY + row * (cellHeight + SPACING);
                
                // Draw border
                g.setColor(Color.GRAY);
                g.drawRect(x, y, cellWidth, cellHeight);
                
                // Draw placeholder image box
                int imgX = x + (cellWidth - IMAGE_WIDTH) / 2;
                int imgY = y + 10;
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(imgX, imgY, IMAGE_WIDTH, IMAGE_HEIGHT);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(imgX, imgY, IMAGE_WIDTH, IMAGE_HEIGHT);
                
                // Draw name
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 16));
                fm = g.getFontMetrics();
                String itemName = currentItems[i].getName();
                int nameX = x + (cellWidth - fm.stringWidth(itemName)) / 2;
                g.drawString(itemName, nameX, y + IMAGE_HEIGHT + 35);
                
                // Draw price
                g.setFont(new Font("Arial", Font.PLAIN, 14));
                String price = "Price: $" + currentItems[i].getCost();
                fm = g.getFontMetrics();
                int priceX = x + (cellWidth - fm.stringWidth(price)) / 2;
                g.drawString(price, priceX, y + IMAGE_HEIGHT + 55);
                
                // Draw stock
                String stock = "Stock: " + currentItems[i].getStock();
                int stockX = x + (cellWidth - fm.stringWidth(stock)) / 2;
                g.drawString(stock, stockX, y + IMAGE_HEIGHT + 75);
            }
        }
    }
    
    
    
    /**
     * Sets the current items to display
     */
    public void setCurrentItems(Merchandise[] items, String section)
    {
        this.currentItems = items;
        this.currentSection = section;
        repaint();
    }
    
    /**
     * Resets display to show store name
     */
    public void resetDisplay()
    {
        this.currentItems = null;
        this.currentSection = "";
        repaint();
    }
    
    // No console run loop in simplified display

    
    /**
     * Main method to start the application
     */
    public static void main(String[] args)
    {
        SportsStore store = new SportsStore("Nikidas Sports");
        SportsStoreDisplay display = new SportsStoreDisplay(store);
        // Example usage: to show a section call
        // display.setCurrentItems(store.getJerseys(), "Jerseys");
    }
}