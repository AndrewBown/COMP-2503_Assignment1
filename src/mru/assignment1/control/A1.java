package mru.assignment1.control;

import java.util.ArrayList;
import java.util.Scanner;
import mru.assignment1.model.Token;
import mru.assignment1.view.PrintWordLists;

public class A1 {
	private Scanner input;
	private Token words;
	private PrintWordLists printWords;
	private static A1 A1Manager;
	private ArrayList<Token> wordList;
	
	
	private String currWord;
	private final String FILE_PATH = "res/input.txt";

	
	
	public A1() {
		input = new Scanner(System.in);
		printWords = new PrintWordLists();
		wordList = new ArrayList<Token>();
		A1Manager = new A1();
		
		createTokenArrayList();
	}
	
	public static void main(String[] args) throws Exception {
		A1Manager.createTokenArrayList();
		
		
		A1Manager.printResults();
    }

	public void printResults() {
		printWords.wordCount(wordList);
//		printWords.mostUsedWords(wordList);
//		printWords.leastUsedWords(wordList);
		
	}
	
	
    public void createTokenArrayList() {
    	while(input.hasNextLine()) {
    		currWord = input.nextLine();
    		words = new Token(currWord.strip().toLowerCase().replaceAll("/[^A-Za-z]/g", "")); // used https://www.reddit.com/r/learnjavascript/comments/qvm6ra/regex_for_removing_numbers_and_punctuation_from/ for regex
    		
    		wordList.add(words);
    	}
		
	}

}
