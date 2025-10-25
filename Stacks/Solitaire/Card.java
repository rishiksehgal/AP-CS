/**
 * Card class that is used for Solitaire game
 * 
 * @author Rishik Sehgal
 * No assistance    
 * 
 * @version Oct 20, 2025
 */
public class Card 
{
    private int rank;
    private String suit;
    private boolean isFaceUp;

    /**
     * Creates a Card object with the provided rank and suit.
     * @param rank the rank given to the card 
     * @param suit the suit given to the card
     */
    public Card(int rank, String suit) 
    {
        this.rank = rank;
        this.suit = suit;
        this.isFaceUp = false;
    }

    /**
     * Gets the rank of the card.
     * @return the rank of the card
     */
    public int getRank() 
    {
        return rank;
    }

    /**
     * Gets the suit of the card.
     * @return the suit of the card
     */
    public String getSuit() 
    {
        return suit;
    }
    /**
     * Determines if the card is facing up.
     * @return true if the card is facing up
     */
    public boolean isFaceUp() 
    {
        return isFaceUp;
    }

    /**
     * Determines if the card is red
     * @return true if the card is red
     */
    public boolean isRed() 
    {
        return suit.equals("h") || suit.equals("d");
    }

    /**
     * Turns the card face up.
     */
    public void turnUp() 
    {
        isFaceUp = true;
    }

    /**
     * Turns the card face down.
     */
    public void turnDown() 
    {
        isFaceUp = false;
    }

    /**
     * Returns the file name of the card image corresponding to this card.Doesn't work with my PC :(
     * @return the file name of the card image
     */
    public String getFileName() 
    {
        String initial = "/Users/rishiksehgal/dev/AP-CS/Stacks/Solitaire/cards/";
        String end = ".gif";
        if (!isFaceUp()) // if face down
        {
            return initial + "backapcsds" + end;
        }
        else // if face up
        {
            String r;
            if (rank == 1)
            {
                r = "a";
            }
            else if (rank == 10)
            {
                r = "t";
            }
            else if (rank == 11)
            {
                r = "j";
            }
            else if (rank == 12)
            {
                r = "q";
            }
            else if (rank == 13)
            {
                r = "k";
            }
            else
            {
                r = String.valueOf((rank));
            }
            return initial + r + suit + end;
        }
    }
}

