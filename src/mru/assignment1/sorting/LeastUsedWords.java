package mru.assignment1.sorting;

import java.util.Comparator;
import mru.assignment1.model.Token;

/**
 * This class is used to sort the words by the number of times they appear in the file least to most.
 */
public class LeastUsedWords implements Comparator<Token> {
    
    public int compare(Token t1, Token t2) {

        if (t1.getIndividualWordCount() == t2.getIndividualWordCount()) {
            return t1.getWord().compareTo(t2.getWord());
        }
        
        return t1.getIndividualWordCount() - t2.getIndividualWordCount();
    }
}
