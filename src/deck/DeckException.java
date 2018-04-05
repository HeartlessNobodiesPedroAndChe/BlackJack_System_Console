package deck;

import java.lang.Exception;

public class DeckException extends Exception {

    public DeckException(String unknownError) {
        super(unknownError);
    }
    
}
