package deck;

import java.util.ArrayList;

/**
 * <i>Abstract Class</i> for multiple uses of a <b>Virtual Deck</b>. <br/>
 * This abstract Class will be the base for other types of deck such as:
 * <ul>
 * <li>Poker Deck (without jokers)</li>
 * <li>Spanish Deck (without jokers)</li>
 * <li>Joker Deck (with one joker)</li>
 * </ul>
 * And future implements.
 * 
 * @author LeCuay
 * @version 0.1 Early
 * @see ArrayList
 */
public abstract class AbstractDeck {

    /**
     * The <b>Virtual Deck</b> is based on a <i>Dual ArrayList</i>  so cards' management will be way easier.
     */
    private ArrayList<ArrayList<Integer>> deck = new ArrayList<>();

    /**
     * This boolean will set one Joker in our deck.
     */
    private boolean singleJoker = false;

    /**
     * This boolean will set two jokers in our deck.
     */
    private boolean dualJoker = false;

    /**
     * The empty constructor automatically loads a deck without Jokers.
     */
    protected AbstractDeck(){this.loadDeck();}

    /**
     * This constructor allows the user to put a Joker in the deck.
     * @param singleJoker The boolean must be <code>true</code> if you want a Joker in the <b>Virtual Deck</b>.
     */
    protected AbstractDeck(boolean singleJoker){
        this.singleJoker = singleJoker;
        this.loadDeck();
    }
    
    /**
     * This constructor allows the user to put two Jokers in the deck.
     * @param singleJoker In order to avoid having 3 Jokers will be set {@code false} by default.
     * @param dualJoker The boolean must be <code>true</code> if you want two Jokers in the <b>Virtual Deck</b>.
     */
    protected AbstractDeck(boolean singleJoker, boolean dualJoker){
        // Setting default value
        singleJoker = false;

        this.dualJoker = dualJoker;
        this.loadDeck();
    }

    /**
     * This constructor allows the user to use a custom <b>Virtual Deck</b>.
     * @param deck The deck you want to play with as <code>{@literal ArrayList<ArrayList<Integer>>}</code>.
     */
    protected AbstractDeck(ArrayList<ArrayList<Integer>> deck){
        this.deck = deck;
    }

    /**
     * This method check if must be any Joker in the <b>Virtual Deck</b> and fills it. <br/>
     * The <b>Virtual Deck</b> it's filled by the following steps:
     * <ul>
     * <li>From 0 to {@code numberOfSuits - 1} will be the Suits (Clubs, Spades, Hearts, Diamonds and Jokers).</li>
     * <li>From 0 to 12 will be the Cards.</li>
     * <li>The Suit <i>Jokers</i> will have from 0 to 1 or just 0.
     * </ul>
     */
    private void loadDeck(){
        byte numberOfSuits;
        byte numberOfCards = 13;

        // Checking if there's any Joker in the Deck
        if(this.singleJoker || this.dualJoker) {
            numberOfSuits = 5;
        } else {
            numberOfSuits = 4;
        }

        for (int i = 0; i < numberOfSuits; ++i) {
            // We add a new ArrayList. One per Suit
            deck.add(new ArrayList<>());

            // We check if the actual Suit is Jokers
            if(numberOfSuits == 5 && i == 4) {
                // Checking how many Jokers must be added
                if (this.singleJoker) {
                    numberOfCards = 1;
                }
                if (this.dualJoker) {
                    numberOfCards = 2;
                }
            }
            for (int j = 0; j < numberOfCards; j++) {
                // We set in every Suit ( deck_loaded.get(i) ) the value ( *.add(j) )
                deck.get(i).add(j);
            }
        }
    }

    
}