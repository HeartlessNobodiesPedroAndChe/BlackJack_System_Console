package deck;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author LeCuay
 * @version 0.1 Early
 */
public class BlackJackDeck extends AbstractDeck {

    /**
     * The number of players tha will be playing the game.
     */
    private int numberOfPlayer = 5;

    /**
     * Empty Constructor that loads a deck with a joker.
     */
    public BlackJackDeck(){super(true);}

    /**
     * Constructor that loads a deck.
     * @param deck The {@code 2D ArrayList} to load.
     */
    public BlackJackDeck(ArrayList<ArrayList<Integer>> deck){super(deck);}

    public String[][] dealStringCards() throws DeckException {
        Random random = new Random();
        String[][] dealedCards = new String[100][2];
        int suit, card, index = 0;

        while(hasNextCard()) {
            do {
                System.out.println("Deck Size: " + deck.size());
                suit = random.nextInt(deck.size());
                dealedCards[index][0] = getSuit(suit);
                System.out.println(suit);
            } while(!hasNextCardInSuit(dealedCards[index][0]));
            System.out.println("Deck Size at Suit " + getSuit(suit) + ": " + deck.get(index).size());
            card = random.nextInt(deck.get(index).size());
            dealedCards[index][1] = getCard(suit, card);
            System.out.println(card);
            ++index;
        }
        return dealedCards;
    }

    public ArrayList<ArrayList<Integer>> dealArrayListCards() throws DeckException {
        ArrayList<ArrayList<Integer>> dealedCards = new ArrayList<>();
        return dealedCards;
    }
    
}