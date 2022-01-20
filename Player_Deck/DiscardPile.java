public class DiscardPile {
    private static Card [] discardPile;
    protected static int discardPointer; // points to the top of the discard pile. Resets when the deck is shuffled


    public DiscardPile()
    {
        discardPile = new Card[52];
        discardPointer =0;
        clearPile();
    }

    public void clearPile()
    {
        
        for(int i =0; i < discardPile.length;i++)
        {
            discardPile[i] =  null;
        }
    }

    public static void placeInDiscardPile(Card card)
    {
        discardPile[discardPointer++] =  card;
        
    }

    public static void displayDiscardPile()
    {
        System.out.println("");

        System.out.println("You played a "+(discardPointer)+" Cards");
        System.out.println("");

        for(int i =0; i < discardPointer ;i++)
        {
            System.out.println(discardPile[i].toString());
        }

            System.out.println("");
            System.out.println("");


    }

}
