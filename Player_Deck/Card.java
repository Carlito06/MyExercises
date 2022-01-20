public class Card {
    //Card Type
    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;


    //Card Value (2-10 is ARE NOT SYMBOLIZED)
    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    private final int suit;
    private final int value;

    protected boolean playedCard;


  

    public Card(int suit, int value)
    {
        this.suit = suit;
        this.value = value;
        this.playedCard = false;
    }

    public int getValue()
    {
        return value;
    }

    public int getSuit()
    {
        return suit;
    }

    public String getSuitAsString()
    {
        switch(suit)
        {
            case SPADES: return "Spades";
            case HEARTS: return "Hearts";
            case DIAMONDS: return "Diamonds";
            default: return "Clubs";
        }
    }

    public String getValueAsString()
    {
        switch(value)
        {
            case ACE: return "Ace";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case JACK: return "Jack";
            case QUEEN: return "Queen";
            default: return "King";
        }
    }

    public String toString()
    {
        if (playedCard == true)
        {
            return "PLAYED: "+getValueAsString() +" of "+ getSuitAsString(); //RETURNS x if you played the card already
        }

        return getValueAsString() +" of "+ getSuitAsString();
    }




// referencing: https://math.hws.edu/eck/cs124/javanotes6/c5/s4.html#OOP.4.2
// http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/10/deck-of-cards.html

}
