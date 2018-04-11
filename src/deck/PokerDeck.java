package deck;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class for the <b>Virtual Deck</b>.
 * <p>Every method in this class will be called by class instead of Object.</p>
 * 
 * @author LeCuay
 * @version 1.0
 * @see ArrayList
 * @see Random
 * @see AbstractDeck
 */
public class PokerDeck extends AbstractDeck{

    /**
     * Empty constructor that automatically loads a <b>Virtual Deck</b>.
     * @see AbstractDeck
     */
    public PokerDeck(){super();}

    /**
     * This constructor allows the user to use a custom <b>Virtual Deck</b>.
     * @param deck The deck you want to play with as <code>{@literal ArrayList<ArrayList<Integer>>}</code>.
     * @see AbstractDeck
     */
    public PokerDeck(ArrayList<ArrayList<Integer>> deck) {super(deck);}

    /**
     * This method will give 5 random cards to the player.
     * @return Dealed Cards as {@code String[Handhold card number][0=Suit, 1=Card number]}
     */
    @Override
    public String[][] dealStringCards() throws DeckException{
        String[][] dealedCards = new String[5][2];
        Random random = new Random();

        // This for-each loop will do 5 loops.
        for (String[] dealedCard: dealedCards) {
            // We get random suit (from 0 to the number of suits)
            int suit = random.nextInt(this.deck.size());
            dealedCard[0] = this.getSuit(suit);
            // We get random card in that suit (from 0 to the number of cards)
            int card = random.nextInt(this.deck.get(suit).size());
            dealedCard[1] = this.getCard(suit, card);
            // Removing dealed card from the Virtual Deck
            this.deck.get(suit).remove(card);
        }

        return dealedCards;
    }

    /**
     * This method will give 5 random cards to the player.
     *@return Dealed Cards as {@code 2D ArrayList[Handhold card number][0=Suit, 1=Card number]}
     */
    @Override
    public ArrayList<ArrayList<Integer>> dealArrayListCards() throws DeckException {
        ArrayList<ArrayList<Integer>> dealedCards = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; ++i) {
            // We create an ArrayList for every loop
            dealedCards.add(i, new ArrayList<>());

            // We get random suit (from 0 to the number of suits)
            int suit = random.nextInt(this.deck.size());
            dealedCards.get(i).add(0, suit);
            // We get random card in that suit (from 0 to the number of cards)
            int card = random.nextInt(this.deck.get(suit).size());
            dealedCards.get(i).add(1, this.getCard(this.getSuit(suit), this.getCard(card)));
            // Removing dealed card from the Virtual Deck
            this.deck.get(suit).remove(card);
        }

        return dealedCards;
    }
    
}