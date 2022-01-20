public class Hand {
    
    public Card hand[]; 
    public static int deckPointer = 0;// points to the next card in the deck. Resets when the deck is shuffled
    public int cardsInHand =0;

    public Hand()
    {
        hand = new Card [5]; // player can only hold 5 cards at a time
        this.cardsInHand = 0;
        new DiscardPile();   // initialize the discard pile class for the constructor method

    }
    

    public void drawCardsFromDeck(Deck deck)
    {
        for (int i = 0; i < hand.length;i++)
        {
            
            hand[i] = deck.deckOfCards[deckPointer++];
            cardsInHand++;

            if (deckPointer == 52)
            {
                break;
            }
        }
    }

    public void displayHand()
    {
        for (int i = 0; i < 5;i++)
        {
            System.out.println((i+1)+".) "+hand[i].toString());
        }

        System.out.println("6.) Display Discard Pile");

    }

    public void playCard(int cardIndex)
    {
        if (cardIndex<0 || cardIndex>5)
        {
            System.out.println("INVALID CARD INDEX. PICK A VALID INDEX WHICH IS A NUMBER FROM 1 TO 5");
        }
        else if (hand[cardIndex].toString().equals("x"))
        {
            System.out.println("YOU PLAYED THIS CARD ALREADY. PICK ANOTHER INDEX THAT IS NOT "+cardIndex);
        }

        else{
        System.out.println("You played The "+ hand[cardIndex].toString());
        System.out.println("");

        DiscardPile.placeInDiscardPile(hand[cardIndex]);
        hand[cardIndex].playedCard = true;

        cardsInHand--;
        }
    }


}
