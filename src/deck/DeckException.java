package deck;

/**
 * This class will get every error raised by our <b>Virtual Deck</b> and manage it.
 * 
 * @author LeCuay
 * @version 0.1
 * @see Exception
 */
public class DeckException extends Exception {

    public DeckException(String unknownError) {
        super(unknownError);
        System.err.println("Error at line: " + getStackTrace()[0].getLineNumber());
    }
    
}
