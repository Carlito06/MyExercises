import java.util.Scanner;
public class Game
{
    public static void main(String[] args) {

        int totalPlayedCards = 0;
        
        Scanner sc1 = new Scanner(System.in); // card index

        

        System.out.println("Welcome to my Card Game");


        Deck deck = new Deck();
        System.out.println("");
        System.out.println("Shuffling Deck...");

        deck.shuffle();

        Hand hand = new Hand();
        System.out.println("");
        System.out.println("Drawing cards from Deck...");

        hand.drawCardsFromDeck(deck);


        while(hand.cardsInHand !=0)
        {
            System.out.println("");

            System.out.println("What card would you like to play?");
            System.out.println("Enter 6 to display Discard Pile.");
            System.out.println("");


            
            hand.displayHand();

            int cardIndex = sc1.nextInt();

            if (cardIndex == 6)
            {
                DiscardPile.displayDiscardPile();
            }

            else{
                hand.playCard(cardIndex-1);
                totalPlayedCards++;
            }


            while (hand.cardsInHand == 0 && DiscardPile.discardPointer!=52)
            {
                System.out.println("Drawing more cards...");
                hand.drawCardsFromDeck(deck);
            }

            if (DiscardPile.discardPointer==52)
            {
                System.out.println("Would you like to play again?");
                System.out.println("1 = Yes");
                System.out.println("2 = No");

                int x = sc1.nextInt();

                if (x == 1)
                {
                     deck = new Deck();
                    System.out.println("");
                    System.out.println("Shuffling Deck...");

                    deck.shuffle();

                    hand = new Hand();
                    System.out.println("");
                    System.out.println("Drawing cards from Deck...");

                    hand.drawCardsFromDeck(deck);
                }

            }

        }
        
        sc1.close();

        System.out.println("You played a total amount of "+totalPlayedCards+ " Cards!");


    }
}