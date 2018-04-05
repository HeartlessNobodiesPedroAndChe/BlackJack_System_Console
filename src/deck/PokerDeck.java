package deck;

import java.util.ArrayList;

/**
 * Class for the <b>Virtual Deck</b>.
 * <p>Every method in this class will be called by class instead of Object.</p>
 * 
 * @author LeCuay
 * @version 1.0
 * @see ArrayList
 */
public class PokerDeck extends AbstractDeck{

    /**
     * Empty constructor that automatically loads a <b>Virtual Deck</b>
     * @see AbstractDeck
     */
    public PokerDeck(){}

    /**
     * This constructor allows the user to put a Joker in the deck.
     * @param singleJoker The boolean must be <code>true</code> if you want a Joker in the <b>Virtual Deck</b>.
     * @see AbstractDeck
     */
    public PokerDeck(boolean singleJoker){
        super(singleJoker);
    }

    /**
     * This constructor allows the user to put two Jokers in the deck.
     * @param singleJoker In order to avoid having 3 Jokers will be set {@code false} by default.
     * @param dualJoker The boolean must be <code>true</code> if you want two Jokers in the <b>Virtual Deck</b>.
     * @see AbstractDeck
     */
    public PokerDeck(boolean singleJoker, boolean dualJoker) {
        super(singleJoker, dualJoker);
    }

    /**
     * This constructor allows the user to use a custom <b>Virtual Deck</b>.
     * @param deck The deck you want to play with as <code>{@literal ArrayList<ArrayList<Integer>>}</code>.
     * @see AbstractDeck
     */
    public PokerDeck(ArrayList<ArrayList<Integer>> deck) {
        super(deck);
    }

    /**
     * ---UNFINISHED---
     */
    @Override
    public String[][] dealStringCards() {
        String[][] dealedCards = new String[2][5];
        return dealedCards;
    }

    /**
     * ---UNFINISHED---
     */
    @Override
    public ArrayList<ArrayList<Integer>> dealArrayListCards() {
        ArrayList<ArrayList<Integer>> dealedCards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            
        }
        return dealedCards;
    }
    
}