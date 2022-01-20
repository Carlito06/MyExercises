import java.lang.Math;
public class Deck {

    protected Card [] deckOfCards;

    public Deck()
    {
        deckOfCards = new Card[52];

        int i =0; // index (final index should = 51 as there are 52 cards in a deck)
        for (int suit = Card.SPADES; suit<=Card.CLUBS;suit++)
        {
            for(int value = 1; value <= 13;value++)
            {

                //post increment after creating the card
                this.deckOfCards[i++] = new Card(suit, value);


            }
        }
    }


    public void displayDeck()
    {
        int i =0;
        while (i!=52)
        {
            System.out.println(deckOfCards[i++].toString());
        }
    }

    public void shuffle()
    {
        Hand.deckPointer = 0;
        DiscardPile.discardPointer =0;
        int card1Index;
        int card2Index;

        for (int i =0; i < deckOfCards.length;i++)
        {
            card1Index = (int) (Math.random() * deckOfCards.length); // pick 2 random cards in the deck and swap them (does this n times)
            card2Index = (int) (Math.random() * deckOfCards.length);

            Card tmp = deckOfCards[card1Index];
            deckOfCards[card1Index] = deckOfCards[card2Index];
            deckOfCards[card2Index] = tmp;
        }

        
    }

    
}
