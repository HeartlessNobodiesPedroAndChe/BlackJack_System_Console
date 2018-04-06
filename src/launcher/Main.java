/**
 * @author LeCuay
 * @author rodherp
 * @version 0.1
 */

package launcher;

import java.util.Arrays;

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
            System.out.println(Arrays.deepToString(deck.dealArrayListCards().toArray()));
        } catch(DeckException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(AbstractDeck.deckToString(deck.getDeck()));
        
    }

}