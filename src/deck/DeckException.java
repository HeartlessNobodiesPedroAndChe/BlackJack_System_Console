package deck;

import java.lang.Exception;

public class DeckException extends Exception {

    public DeckException(String unknownError) {
        super(unknownError);
    }
    
}

public class outOfBoundDeckException extends Exception {

    public outOfBoundDeckException(byte bound, String error) {
        super(error + "\nYou exceed the maximum bound: " + bound);
    }

}
