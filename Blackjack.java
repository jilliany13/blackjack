package blackjack;
import java.util.Scanner;

/**
 * This is the class that runs the Blackjack game
 * It uses these classes: 
 *  - Calculator class - tracks who wins 
 *  - Player class 
 *  - 
 */
public class Blackjack {

    // Attributes 

    private Deck deck1;
    private Player p1;
    private Player p2;
    private Player dealer;
    private boolean isWin;
    private Scanner scan;
    private boolean inPlay;

    /**
     * Creates a Blackjack object
     */
    public Blackjack() {

        deck1 = new Deck();
        p1 = new Player();
        dealer = new Player();
        scan = new Scanner(System.in);
        inPlay = true;
    }

    private boolean hit() {

        // Get a card from the deck 
        int newCard = deck1.hit();

        System.out.println("Your card: " + newCard);

        // Add it to P1's total
        int total = p1.newTotal(newCard);

        System.out.println("Your Total: " + total);

        if(total > 21) {
            System.out.println("BUSTED! :(\n");
        }

        else if (total == 21) {
            System.out.println("Yay! You made it to 21!");
            this.stay();
        }

        // else, wait for another input to see what the user would like to do 

        return false;
    }

    /**
     * Starts the game 
     * @return
     */
    public boolean start() {

        // Start Dealing Cards to P1
        p1.setCards(deck1.hit(), deck1.hit());

        // Deal cards to the dealer
        dealer.setCards(deck1.hit(), deck1.hit());

        // Tells the Player what the first deal of cards were 
        System.out.println("You have these cards: " + p1.card1() + " and " + p1.card2());
        System.out.println("Total = " + p1.total());
        System.out.println("The dealer is showing: " + dealer.card1());

        while(p1.total() < 21 && inPlay) {

            this.askUserInput();
        }
        
        
        return true;
    }

    public boolean stay() {

        System.out.println("The dealer was showing: " + dealer.card1() + " and he also has: " + dealer.card2());
        System.out.println("Dealer Total: " + dealer.total());

        int d_total = dealer.total();

        // Dealer keeps hitting until they reach 17
        while(d_total < 17) {

            // Pause to build suspense 
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            int newCard = deck1.hit();
            System.out.println("Dealer's next card: " + newCard);
            d_total = dealer.newTotal(newCard);
            System.out.println("Dealer's Total: " + d_total); 
        }

        if(d_total > 21) {

            System.out.println("Dealer busted! You win!");
        }

        else {

            System.out.println("Your total: " + p1.total());

            if(d_total > p1.total()) {

                System.out.println("Sorry you lost :(");
            }
    
            else if (d_total == p1.total()) {
                System.out.println("Push!");
            }

            else {
                System.out.println("You won, yay!");
            }
        }

        inPlay = false;

        
        return true;

    }

    public boolean askUserInput() {

        // Takes user input 
        System.out.println("What would you like to do? \n1 = Hit \n2 = Stay \n3 = Double Down \n4 = Split");
        System.out.println("--------------------------------");

        int choice = scan.nextInt();
        String[] choices = {"None", "HIT", "STAY", "DOUBLE DOWN", "SPLIT"};

        System.out.println("You chose to " + choices[choice]);

        if(choice == 1) {
            this.hit();
        }

        else if(choice == 2) {
            this.stay();
        }

        return false;
    }

}