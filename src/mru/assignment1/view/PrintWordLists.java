package mru.assignment1.view;

import java.util.ArrayList;

import mru.assignment1.model.Token;

public class PrintWordLists {

	private String word;
	
	public void wordCount(ArrayList<Token> wordList) {
		for(Token wordToCheck: wordList) {
			word = wordToCheck.getWord();
			System.out.println(word);
		System.out.println("test");
		}
	}
	
}
