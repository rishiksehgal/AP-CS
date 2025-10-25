import java.util.*;
/**
 * Solitaire Class used for Solitaire game
 * 
 * @author Rishik Sehgal
 * No assistance    
 * 
 * @version Oct 24, 2025
 */
public class Solitaire
{
    /**
     * Creates a Solitaire Object through main method
     * @param args pass things
     */
    public static void main(String[] args)
    {
        new Solitaire();
    }

    private Stack<Card> stock;
    private Stack<Card> waste;
    private Stack<Card>[] foundations;
    private Stack<Card>[] piles;
    private SolitaireDisplay display;

    /**
     * Creates a Solitaire Object creating all its instance variables, populates pile and stock.
     */
    public Solitaire()
    {
        foundations = new Stack[4];
        for(int i = 0; i < 4; i++) 
        {
            foundations[i] = new Stack<>();
        }
        piles = new Stack[7];
        for(int i = 0; i < 7; i++) 
        {
            piles[i] = new Stack<>();
        }
        stock = new Stack<>();
        waste = new Stack<>();
        display = new SolitaireDisplay(this);
        createStock();
        deal();
    }

    /**
     * Returns the card on top of the stock, null if empty
     * @return the card on top of the stock null if empty
     */
    public Card getStockCard()
    {
        if(!stock.isEmpty()) 
        {
            return stock.peek();
        }
        return null;
    }

    /**
     * Returns the card on top of the waste, null if empty
     * @return the card on top of the waste
     */
    public Card getWasteCard()
    {
        if(!waste.isEmpty()) 
        {
            return waste.peek();
        }
        return null;
    }

    //precondition:  0 <= index < 4
    //postcondition: returns the card on top of the given
    //               foundation, or null if the foundation
    //               is empty
    /**
     * Returns foundation card
     * @precondition: 0 <= index < 4
     * @postcondition: returns the card on top of the given
     * foundation, or null if the foundation is empty
     * @param index the foundation to get card from
     * @return the card on top of the given foundation
     */
    public Card getFoundationCard(int index)
    {
        if(!foundations[index].isEmpty()) 
        {
            return foundations[index].peek();
        }
        return null;
    }

    //precondition:  0 <= index < 7
    //postcondition: returns a reference to the given pile
    /**
     * Returns a reference to Pile
     * @precondition: 0 <= index < 7
     * @postcondition: returns a reference to the given pile
     * @param index the pile being searched from
     * @return a reference to the given pile
     */
    public Stack<Card> getPile(int index)
    {
        return piles[index];
    }

    /**
     * Called when the stock is clicked
     */
    public void stockClicked()
    {
        if(display.isWasteSelected() || display.isPileSelected()) 
        {
            return;
        }
        else if(stock.isEmpty()) 
        {
            resetStock();
        }
        else 
        {
            dealThreeCards();
        }
    }

    /**
     * Called when the waste is clicked.
     */
    public void wasteClicked()
    {
        if (!waste.isEmpty())
        {
            if (!display.isWasteSelected() && !display.isPileSelected())
            {
                display.selectWaste();
            }
            else if (display.isWasteSelected())
            {
                display.unselect();
            }
            System.out.println("waste clicked");
        }
    }
    /**
     * Called when the foundation is clicked
     * @precondition: 0 <= index < 4
     * @param index the index of the foundation clicked
     */
    public void foundationClicked(int index)
    {
        if(display.isWasteSelected())
        {
            if(canAddToFoundation(waste.peek(), index))
            {
                foundations[index].push(waste.pop());
            }
            display.unselect();
        }
        if(display.isPileSelected())
        {
            if(canAddToFoundation(piles[display.selectedPile()].peek(), index))
            {
                foundations[index].push(piles[display.selectedPile()].pop());
            }
            display.unselect();
        }
    }

    /**
     * Called when given pile is clicked
     * @precondition: 0 <= index < 7
     * @param index of the pile clicked
     */
    public void pileClicked(int index)
    {
        Stack<Card> stack = piles[index];
        if(display.isWasteSelected())
        {
            if(!waste.isEmpty() && canAddToPile(waste.peek(), index))
            {
                stack.push(waste.pop());
                display.unselect();      
            }
        
        }
        else if(!display.isPileSelected())
        {
            if(!stack.isEmpty() && stack.peek().isFaceUp())
            {
                display.selectPile(index);
            }
            else if (!stack.isEmpty() && !stack.peek().isFaceUp())
            {
                stack.peek().turnUp();
            }
        }
        else
        {
            int prev = display.selectedPile();
            if(prev == index)
            {
                display.unselect();
                return;
            }
            Stack<Card> tempStack = removeFaceUpCards(prev);
            Card bottom = bottomCard(tempStack);
            if(canAddToPile(bottom, index))
            {
                addToPile(tempStack, index);   
            }
            else
            {
                addToPile(tempStack, prev);
            }
            display.unselect();
        }
            
    }
        
    
    /**
     * Creates the Stock with every card and randomizes it
     */
    private void createStock()
    {
        ArrayList<Card> cards = new ArrayList<>();
        for(int j = 1; j <= 13; j++) 
        {
            cards.add(new Card(j, "h"));
            cards.add(new Card(j, "d"));
            cards.add(new Card(j, "c"));
            cards.add(new Card(j, "s"));
        }
        for(int i = cards.size() - 1; i >= 0; i--) 
        {
            int x = (int)(Math.random() * (i + 1));
            stock.push(cards.remove(x));
        }
    }

    /**
     * Deals the cards to each of the piles
     */
    private void deal()
    {
        for(int i = 0; i < 7; i++) 
        {
            for(int j = 0; j <= i; j++) 
            {
                Card x = stock.pop();
                if(j == i) 
                {
                    x.turnUp();
                }
                piles[i].push(x);
            }
        }
    }
    
    /**
     * Deals three cards to the waste
     */
    private void dealThreeCards()
    {
        for(int i = 0; i < 3; i++) 
        {
            if(!stock.isEmpty()) 
            {
                Card x = stock.pop();
                x.turnUp();
                waste.push(x);
            }
        }
    }

    /**
     * Resets the Stock
     */
    private void resetStock()
    {
        while(!waste.isEmpty()) 
        {
            Card x = waste.pop();
            x.turnDown();
            stock.push(x);
        }
    }
    
    //precondition:  0 <= index < 7  
    //postcondition: Returns true if the given card can be 
    // legally moved to the top of the given 
    // 
    /**
     * True if can add to pile
     * @precondition: 0 <= index < 7
     * @postcondition: Returns true if the given card can be legally moved
     * @param card being analyzed
     * @param index of pile being analyzed
     * @return true if can be moved
     */
    private boolean canAddToPile(Card card, int index)
    {
        Stack<Card> stack = piles[index];
        if(stack.isEmpty())
        {
            if(card.getRank() == 13)
            {
                return true;
            }
            return false;
        }
        else if(stack.peek().isFaceUp() && 
                card.getRank() == stack.peek().getRank() - 1 
                && card.isRed() != stack.peek().isRed())
        {
            return true;
        }
        return false;
        
        
    }
    //precondition:  0 <= index < 7 
    //postcondition: Removes all face-up cards on the top of 
    // the given pile; returns a stack 
    // containing these cards  
    /**
     * Removes face-up cards from pile and returns them 
     * @precondition: 0 <= index < 7 
     * @postcondition: Removes all face-up cards on the top of 
     * the given pile; returns a stack
     * containing these cards
     * @param index of pile
     * @return a stack containing face- up cards
     */
    private Stack<Card> removeFaceUpCards(int index)
    {
        Stack<Card> temp = new Stack();
        while (!piles[index].isEmpty() && piles[index].peek().isFaceUp())
        {
            temp.push(piles[index].pop());
        }
        return temp;
    }

    //precondition:  0 <= index < 7
    //postcondition: Removes elements from cards, and adds
    // them to the given pile
    private void addToPile(Stack<Card> cards, int index)
    {
        while(!cards.isEmpty())
        {
            piles[index].push(cards.pop());
        }
    }

    /**
     * Gets the bottom card of a Stack of Cards to be used in 
     * pileClicked
     * @param stack being analyzed
     * @return bottom card of Stack of Cards
     */
    private Card bottomCard(Stack<Card> stack)
    {
        Stack<Card> temp = new Stack<>();
        while(!stack.isEmpty())
        {
            temp.push(stack.pop());
        }
        Card b = temp.peek();
        while(!temp.isEmpty())
        {
            stack.push(temp.pop());
        }
        return b;
    }

    //precondition:  0 <= index < 4 
    //postcondition: Returns true if the given card can be 
    // legally moved to the top of the given 
    // foundation 
    /**
     * Returns true if card can be moved
     * @precondition: 0 <= index < 4 
     * @postcondition: Returns true if the given card can be
     * legally moved to the top of the given
     * foundation
     * @param card to be analyed
     * @param index of foundation
     * @return true if can be added
     */
    private boolean canAddToFoundation(Card card, int index)
    {
        Stack <Card> stack = foundations[index];
        if(stack.isEmpty())
        {
            return card.getRank() == 1;
        }
        Card temp = stack.peek();
        return temp.getRank() == card.getRank() - 1 && card.isRed() == temp.isRed();
    }

    /**
     * Gets the waste cards to be used to show all three 
     * @return the Waste cards
     */
    public ArrayList<Card> getWaste()
    {
        ArrayList<Card> wastelist = new ArrayList<>();
        Stack<Card> temp = new Stack<>();
        int size = Math.min(3, waste.size());
        for(int i = 0; i < size; i++)
        {
            temp.push(waste.pop());
        }

        while(!temp.isEmpty())
        {
            Card x = temp.pop();
            wastelist.add(x);
            waste.push(x);
        }
    
        return wastelist;
    }
    /**
     * Determines if the game is won
     * @return true if the game is won
     */
    public boolean isGameWon()
    {
        for (int i = 0; i < 4; i++)
        {
            if (foundations[i].size() != 13)
            {
                return false;
            }
        }
        return true;
    }
}