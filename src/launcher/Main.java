/**
 * @author LeCuay
 * @author rodherp
 * @version 0.1
 */

package launcher;

import java.util.Arrays;
import java.util.ArrayList;

import deck.AbstractDeck;
import deck.PokerDeck;
import deck.DeckException;

/**
 * Launcher Class for the program to start
 */
public class Main {

    public static void main(String[] args) {
        PokerDeck deck = new PokerDeck(true, true);
        try {
            ArrayList<ArrayList<Integer>> handholdCards = deck.dealArrayListCards();
            String[][] parsedArray = deck.parseArray(handholdCards);
            System.out.println(AbstractDeck.deckToString(parsedArray));
        } catch(DeckException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(AbstractDeck.deckToString(deck.getDeck()));
        
    }

}