package deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * <i>Abstract Class</i> for multiple uses of a <b>Virtual Deck</b>. <br>
 * This abstract Class will be the base for other types of deck such as:
 * <ul>
 * <li>Poker Deck (without jokers)</li>
 * <li>Spanish Deck (without jokers)</li>
 * <li>Joker Deck (with one joker)</li>
 * </ul>
 * The Class is based on an <b>Abstract Deck</b> ({@literal 2D ArrayList<Integer>}) and a readable
 * <b>Virtual Deck</b> (String[][]) so we can read it.
 * 
 * @author LeCuay
 * @version 1.0 Early
 * @see ArrayList
 * @see Arrays
 * @see Collections
 */
public abstract class AbstractDeck {

    /**
     * The <b>Virtual Deck</b> is based on a <i>Dual ArrayList</i>  so cards' management will be way easier.
     */
    protected ArrayList<ArrayList<Integer>> deck = new ArrayList<>();

    /**
     * This boolean will set one Joker in our deck.
     */
    protected boolean singleJoker = false;

    /**
     * This boolean will set two jokers in our deck.
     */
    protected boolean dualJoker = false;

    /**
     * This boolean is true if there's any card in the deck and false otherwise.
     */
    protected boolean cardsInDeck = true;

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
     * This method check if must be any Joker in the <b>Virtual Deck</b> and fills it. <br>
     * The <b>Virtual Deck</b> it's filled by the following steps:
     * <ul>
     * <li>From 0 to {@code numberOfSuits - 1} will be the Suits (Clubs, Spades, Hearts, Diamonds and Jokers).</li>
     * <li>From 0 to 12 will be the Cards.</li>
     * <li>The Suit <i>Jokers</i> will have from 0 to 1 or just 0.
     * </ul>
     */
    private void loadDeck(){
        int numberOfSuits;
        int numberOfCards = 13;

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

    /**
     * This method sorts a {@code 2D ArrayList} <b>Virtual Deck</b> declared in params.
     * @param deck The {@code 2D ArrayList} to sort.
     * @return The same {@code 2D ArrayList} declared in params but sorted.
     */
    public static ArrayList<ArrayList<Integer>> sortDeck(ArrayList<ArrayList<Integer>> deck) {
        /* - - - DEPRECATED - - -
        Collections.sort(deck, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2){
                return o1.get(0).compareTo(o2.get(0));
            }
        });*/
        Collections.sort(deck, (ArrayList<Integer> o1, ArrayList<Integer> o2) -> o1.get(0).compareTo(o2.get(0)));
        return deck;
    }

    /**
     * Simple method to get Suit Name by number. <br>
     * For playing with Spanish Deck you must Override this method.
     * @param suit The number of the card from 0 to 3 (from 0 to 4 if there's any Joker).
     * @return That suit's name.
     * @exception DeckException In case you exceed the maximum bound setted for that Deck.
     */
    public String getSuit(int suit) throws DeckException {
        if (this.singleJoker || this.dualJoker) {
            if (suit > 4)
                throw new DeckException("You've exceed the maximum bound ("+suit+").");
            if (suit < 0)
                throw new DeckException("You can't set negative suits. ("+suit+").");
            switch(suit){
                case 0:
                    return "Clubs";
                case 1:
                    return "Spades";
                case 2:
                    return "Hearts";
                case 3:
                    return "Diamonds";
                case 4:
                    return "Jokers";
                default:
                    throw new DeckException("The suit number ("+suit+") is not allowed");
            }
        } else {
            if (suit > 3 || suit < 0)
                throw new DeckException("You've exceed the maximum bound ("+suit+").");
            switch(suit){
                case 0:
                    return "Clubs";
                case 1:
                    return "Spades";
                case 2:
                    return "Hearts";
                case 3:
                    return "Diamonds";
                default:
                    throw new DeckException(suit + " is not allowed.");
            }
        }
    }

    /**
     * Simple method to get Suit Number by its name. <br>
     * For playing with Spanish Deck you must Override this method.
     * @param suit The name of the suit.
     * @return The <b>virtual number</b> in the Deck of that suit.
     * @exception DeckException In case you exceed the bound setted for that Deck.
     */
    public int getSuit(String suit) throws DeckException {
        if (this.singleJoker || this.dualJoker) {
            switch(suit) {
                case "Clubs":
                    return 0;
                case "Spades":
                    return 1;
                case "Hearts":
                    return 2;
                case "Diamonds":
                    return 3;
                case "Jokers":
                    return 4;
                default:
                    throw new DeckException("The suit ("+suit+") in not recognized.");
            }
        } else {
            switch(suit) {
                case "Clubs":
                    return 0;
                case "Spades":
                    return 1;
                case "Hearts":
                    return 2;
                case "Diamonds":
                    return 3;
                default:
                    throw new DeckException("The suit ("+suit+") in not recognized.");
            }
        }
    }

    /**
     * Simple method to get Card Name by number. <br>
     * For playing with Spanish Deck you must Override this method. <br>
     * This method <b>DOES NOT CHECK</b> Joker card. <br>
     * Please use {@code getCard(int suit, int card)} if you are using Joker.
     * @param card The number of the card from 0 to 12.
     * @return That card's name.
     * @exception DeckException In case you exceed the bound setted for that Deck.
     */
    public String getCard(int card) throws DeckException{
        if(card > 12 || card < 0)
            throw new DeckException("You've exceed the bounds. ("+card+")");
        switch(card) {
            case 0:
                return "Ace";
            case 10:
                return "Jack";
            case 11:
                return "Queen";
            case 12:
                return "King";
            default:
                return Integer.toString(card + 1);
        }
    }

    /**
     * Simple method specifically made for getting Joker. <br>
     * The system works exactly like {@code getCard(int card)} but getting Jokers if it concerns.
     * @param suit The number of the suit from 0 to 4.
     * @param card The number of the card from 0 to 12 (0 to 1 if it has Jokers).
     * @return That card's name.
     * @exception DeckException In case you exceed the bound setted for that Deck.
     */
    public String getCard(int suit, int card) throws DeckException {
        if(this.singleJoker || this.dualJoker) {
            if (suit > 4 || suit < 0)
                throw new DeckException("You've exceed the bounds. ("+suit+")");
            switch(suit) {
                case 4:
                    return "Joker";
                default:
                    return getCard(card);
            }
        } else {
            if (card > 12 || card < 0)
                throw new DeckException("You've exceed the bounds. ("+card+")");
            switch(deck.get(suit).get(card)) {
                case 0:
                    return "Ace";
                case 10:
                    return "Jack";
                case 11:
                    return "Queen";
                case 12:
                    return "King";
                // Default will get any other value (2 - 10)
                default:
                    return Integer.toString(deck.get(suit).get(card) + 1);
            }
        }
    }

    /**
     * Simple method to get Card Number by its name. <br>
     * For playing with Spanish Deck you must Override this method. <br>
     * This method <b>DOES NOT CHECK</b> Joker card. <br>
     * Please use {@code getCard(String suit, String card)} if you are using Joker.
     * @param card The name of the card.
     * @return The <b>virtual number</b> of that card in the Deck.
     * @exception DeckException In case you set something not allowed.
     */
    public int getCard(String card) throws DeckException {
        switch(card) {
            case "Ace":
                return 0;
            case "Jack":
                return 10;
            case "Queen":
                return 11;
            case "King":
                return 12;
            default:
                try {
                    return Integer.parseInt(card) - 1;
                } catch (NumberFormatException e) {
                   throw new DeckException(card + " is not a Card neither a Number.");
                }
        }
    }

    /**
     * Simple method specifically made for getting Joker. <br>
     * The system works exactly like {@code getCard(int card)} but getting Jokers if it concerns.
     * @param suit The name of the suit.
     * @param card The name of the card.
     * @return That card's value
     * @exception DeckException In case you exceed the bound setted for that Deck.
     */
    public int getCard(String suit, String card) throws DeckException {
        if(this.singleJoker || this.dualJoker) {
            switch(suit) {
                case "Jokers":
                    // We will return 1 in case 0 is in "Jokers" suit or 0 in case is not.
                    return this.deck.get(this.getSuit(suit)).contains(0)?1:0;
                default:
                    return getCard(card);
            }
        } else {
            return getCard(card);
        }
    }

    /**
     * This method will parse a {@code 2D ArrayList} into a {@code String[][]}. <br>
     * The {@code String[][]} returned is based on two values: <b>Suit</b> and <b>Card</b>. <br>
     * <pre>
     * String[size of the {@code deck}][2] //[0] = Suit; [1] = Card;
     * </pre>
     * @param deck the {@code 2D ArrayList} to parse.
     * @return The {@code String[][]} deck.
     * @exception DeckException from {@code getCard()} method.
     */
    public String[][] parseArray(ArrayList<ArrayList<Integer>> deck) throws DeckException {
        String[][] parsedDeck = new String[deck.size()][2];
        for(int i = 0; i < parsedDeck.length; ++i) {
            parsedDeck[i][0] = getSuit(deck.get(i).get(0));
            parsedDeck[i][1] = getCard(deck.get(i).get(1));
        }

        return parsedDeck;
    }

    /**
     * This method will parse a {@code String[][]} into a {@code 2D ArrayList}. <br>
     * The {@code 2D ArrayList} returned is based on two values: <b>Suit</b> and <b>Card</b>. <br>
     * [0] = Suit; [1] = Card;
     * @param deck the {@code String[][]} to parse.
     * @return The {@code 2D ArrayList} deck.
     * @exception DeckException from {@code getCard()} method.
     */
    public ArrayList<ArrayList<Integer>> parseArray(String[][] deck) throws DeckException {
        ArrayList<ArrayList<Integer>> parsedDeck = new ArrayList<>();
        for (int i = 0; i < deck.length; ++i) {
            parsedDeck.add(new ArrayList<>());
            parsedDeck.get(i).add(getSuit(String[i][0]));
            parsedDeck.get(i).add(getCard(String[i][1]));
        }

        return parsedDeck;
    }

    /**
     * Simple method to check if there's next card in a suit by Suit Number.
     * @param suit The number of that suit in the <b>Virtual Deck</b>.
     * @return {@code true or false} depending on cards left in the suit.
     */
    public boolean hasNextCardInSuit(int suit) {
        return !deck.get(suit).isEmpty();                                                                                                                                                                             
    }

    /**
     * Simple method to check if there's next card in a suit by Suit Name.
     * @param suit The name of that suit in the <b>Virtual Deck</b>.
     * @return {@code true or false} depending on cards left in the suit.
     */
    public boolean hasNextCardInSuit(String suit) {
        return !deck.get(getSuit(suit)).isEmpty();
    }

    /**
     * Simple method to check if there's any card in the <b>Virtual Deck</b>.
     * @return {@code true or false} depending on cards left in the deck.
     */
    public boolean hasNextCard() {
        if(deck.isEmpty())
            cardsInDeck = false;
        return !deck.isEmpty();
    }

    /**
     * This method parse to a readable String the <b>Virtual Deck</b>
     * @param deck The {@code 2D ArrayList} to parse String.
     * @return A readable version of the {@code 2D ArrayList} <b>Virtual Deck</b>.
     */
    public static String deckToString(ArrayList<ArrayList<Integer>> deck) {
        return Arrays.deepToString(deck.toArray());
    }

    /**
     * This method parse to a readable String the <b>Virtual Deck</b>
     * @param deck The {@code String[][]} to parse String.
     * @return A readable version of the {@code String[][]} <b>Virtual Deck</b>.
     */
    public static String  deckToString(String[][] deck) {
        java.lang.StringBuilder readableDeck = new StringBuilder("[");
        for(String[] suit: deck) {
            readableDeck.append(Arrays.deepToString(suit) + ", ");
        }
        readableDeck.delete(readableDeck.length() - 2, readableDeck.length());
        readableDeck.append("]");

        return readableDeck.toString();
    }

    /**
     * Returns a readable String of the available cards by Suit and Card. <br>
     * The String will have this format: <br>
     * SUIT: [Card, Card, Card...]
     * @return An eye-friendly String of the <b>Virtual Deck</b>
     * @see StringBuilder
     */
    @Override
    public String toString() {
        java.lang.StringBuilder readableDeck = new StringBuilder("");
        try {
            for(ArrayList<Integer> array: deck) {
                readableDeck.append(getSuit(deck.indexOf(array)).toUpperCase() + ": [");
                for(Integer card: array) {
                    readableDeck.append(getCard(card) + ", ");
                }
                readableDeck.delete(readableDeck.length() - 2, readableDeck.length());
                if(!array.isEmpty())
                    readableDeck.append("]\n");
                else
                    readableDeck.append("\n");
            }
        } catch (DeckException e) {
            System.err.println(e.getMessage());
        }
        return readableDeck.toString();
    }

    /**
     * This method will give every Player the corresponding cards as a {@code 2D String Array}.
     * @return Dealed cards as {@code 2D String Array}.
     * @exception DeckException In case you exceed the bound setted for that Deck.
     */
    public abstract String[][] dealStringCards() throws DeckException;

    /**
     * This method will give every Player the corresponding cards as a {@code 2D ArrayList}.
     * @return Dealed cards as {@code 2D ArrayList}.
     * @exception DeckException In case you exceed the bound setted for that Deck.
     */
    public abstract ArrayList<ArrayList<Integer>> dealArrayListCards() throws DeckException;

    /**
     * This getter returns the <b>literal</b> <code>{@literal ArrayList<ArrayList<Integer>>}</code> deck.
     * @return The object's {@code 2D ArrayList}.
     */
    public ArrayList<ArrayList<Integer>> getDeck(){return this.deck;}

    /**
     * This getter checks if {@code boolean singleJoker} is activated.
     * @return {@code true or false} depending on the {@code singleJoker} variable.
     */
    public boolean isSingleJoker(){return this.singleJoker;}

    /**
     * This getter checks if {@code boolean dualJoker} is activated.
     * @return {@code true or false} depending on the {@code dualJoker} variable.
     */
    public boolean isDualJoker(){return this.dualJoker;}

    /**
     * This getter if there's any card left in the Deck.
     * @return {@code true or false} depending on the {@code cardsInDeck} variable. 
     */
    public boolean isCardsInDeck(){return this.cardsInDeck;}

    
}