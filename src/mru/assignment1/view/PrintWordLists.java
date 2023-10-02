package mru.assignment1.view;

import java.util.ArrayList;

import mru.assignment1.model.Token;

public class PrintWordLists {

	private String word;
	
	public void totalWordCount(int totalWordCount) {
		System.out.println("Total Words: " + totalWordCount);
	}

	public void uniqueWordCount(int uniqueWordCount) {
		System.out.println("Unique Words: " + uniqueWordCount);
	}

	public void stopWordCount(int stopWordCount) {
		System.out.println("Stop Words: " + stopWordCount);
	}


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
