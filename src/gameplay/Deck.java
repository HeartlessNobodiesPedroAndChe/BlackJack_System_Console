package gameplay;

import java.util.ArrayList;

/**
 * Class for the <b>Virtual Deck</b>.
 * <p>Every method in this class will be called by class instead of Object.</p>
 * 
 * @author LeCuay
 * @version 1.0
 * @see ArrayList
 */
public class Deck {

    /**
     * The <b>Virtual Deck</b> is based on a <i>Dual ArrayList of Integer</i>.
     */
    private static ArrayList<ArrayList<Integer>> deck = new ArrayList<>();

    /**
     * Automatic Deck constructor that load the <b>Virtual Deck</b>.
     */
    public Deck() {load_deck();}

    /**
     * This method will load the <b>Virtual Deck</b>'s'
     * <i>Suits</i> and <i>Cards</i> as <code>Integer</code> from 0 to 3 and 0 to 12.
     */
    private static void load_deck() {

        // Foor-loop for each suit
        for (int i = 0; i < 4; ++i) {
            // We need a ArrayList for each suit in the Deck
            deck.add(new ArrayList());

            // Foor-loop for each card
            for(int j = 0; i < 13; ++j) {
                // Then we set in every Suit ( deck_loaded.get(i) ) the value ( *.add(j) )
                deck.get(i).add(j);
            }
        }
    }

    /**
     * Simple method to get Suit Name by Number.
     * @param suit The suit number as <code>Integer</code>.
     * @return SuitName as <code>String</code>.
     */
    public static String getSuit(int suit) {
        String suitName = "";

        // Then we set that suit with real value
        switch(suit) {
            case 0:
                suitName = "Clubs";
                break;
            case 1:
                suitName = "Spades";
                break;
            case 2:
                suitName = "Hearts";
                break;
            case 3:
                suitName = "Diamonds";
                break;
        }

        return suitName;
    }
    
}