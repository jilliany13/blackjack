package blackjack;

/**
 * 
 */
public class Player {

    private int card1;
    private int card2;
    private int total; 
    private boolean bust;
    

    public Player() {
        
        card1 = 0;
        card2 = 0;
    }

    /**
     * Sets the players cards
     * @param c1 - card1
     * @param c2 - card2
     */
    public void setCards(int c1, int c2) {
        card1 = c1;
        card2 = c2;
        total = c1 + c2;
    }

    // Keep track of the cards in case: 
        // Blackjack 
        // Split
        // Double Down 
    public int card1() {
        return card1;
    }

    public int card2() {
        return card2;
    }

    


    // @TODO Calculate the new total every time a card is added 

    // This will get called after all of the cards get dealt 
    public int total() {
        return total;
    }

    /**
     * Adds new card to the total and returns it
     * @param newCard - new card that was added
     * @return
     */
    public int newTotal(int newCard) {

        total += newCard;
        return total;
    }

}

