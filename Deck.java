package blackjack;

/**
 * 
 */
public class Deck {

    private int[] deck;
    
    public Deck() {

        // Creates a deck of 52 cards 
        deck = new int[52];

        // Fills the deck with 1 to 9
        for(int i = 0; i <= 35; i++) {
            deck[i] = i/4 + 1;
        }

        // Fills the deck with 10s (10, J, Q, K)
        for(int i = 36; i <= 51; i++) {
            deck[i] = 10;
        }

    }

    public int hit() {

        int x = (int) (Math.random() * 51);
        return deck[x];
    }

}
