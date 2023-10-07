package mru.assignment1.view;

import java.util.ArrayList;
import mru.assignment1.model.Token;

/**
 * This class is used to print the results of the program.
 */
/**
 * This class is responsible for printing various word lists to the console.
 */
public class PrintWordLists {

	/**
	 * Prints the total word count to the console.
	 * @param totalWordCount The total number of words.
	 */
	public void totalWordCount(int totalWordCount) {
		System.out.println("Total Words: " + totalWordCount);
	}

	/**
	 * Prints the unique word count to the console.
	 * @param uniqueWordCount The number of unique words.
	 */
	public void uniqueWordCount(int uniqueWordCount) {
		System.out.println("Unique Words: " + uniqueWordCount);
	}

	/**
	 * Prints the stop word count to the console.
	 * @param stopWordCount The number of stop words.
	 */
	public void stopWordCount(int stopWordCount) {
		System.out.println("Stop Words: " + stopWordCount);
	}

	/**
	 * Prints the 10 most frequently used words and their individual counts and their individual counts to the console.
	 * @param wordList The sorted list to print out.
	 */
	public void mostUsedWords(ArrayList<Token> wordList) {
		int i = 1;

		System.out.println();
		System.out.println("10 Most Frequent");
		for(Token wordToCheck: wordList) {
			if(i <= 10) {
				System.out.println(wordToCheck.getWord() + " : " + wordToCheck.getIndividualWordCount());
				i++;
			}
		}
	}

	/**
	 * Prints the 10 least frequently used words and their individual counts to the console.
	 * @param wordList The sorted list to print out.
	 */
    public void leastUsedWords(ArrayList<Token> wordList) {
   		int i = 1;

		System.out.println();
		System.out.println("10 Least Frequent");
		for(Token wordToCheck: wordList) {
			if(i <= 10) {
				System.out.println(wordToCheck.getWord() + " : " + wordToCheck.getIndividualWordCount());
				i++;
			}
		}
	}

	/**
	 * Prints all words and their individual counts to the console.
	 * @param wordList The sorted list to print out.
	 */
	/**
	 * Prints all the words in the given ArrayList along with their individual word count.
	 * 
	 * @param wordList the ArrayList of Token objects containing the words and their counts
	 */
	public void allWords(ArrayList<Token> wordList) {
		int i = 1;

		System.out.println();
		System.out.println("All");
		for(Token wordToCheck: wordList) {
			System.out.println(wordToCheck.getWord() + " : " + wordToCheck.getIndividualWordCount());
			i++;
		}
	}
}
