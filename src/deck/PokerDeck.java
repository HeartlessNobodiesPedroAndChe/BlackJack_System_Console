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

    @Override
    public String[][] dealStringCards() {
        String[][] dealedCards = new String[2][5];
        return dealedCards;
    }

    @Override
    public ArrayList<ArrayList<Integer>> dealArrayListCards() {
        ArrayList<ArrayList<Integer>> dealedCards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            
        }
        return dealedCards;
    }
    
}