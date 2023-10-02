package mru.assignment1.control;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import mru.assignment1.model.Token;
import mru.assignment1.sorting.*;
import mru.assignment1.view.PrintWordLists;

public class A1 {
	private Scanner fileReader;
	private File text;
	private PrintWordLists printWords;
	private ArrayList<Token> wordList;
	private ArrayList<String> stopWords;
	private int totalWordCount;
	private int stopWordWordCount;
	private int uniqueWordCount;

	
	
	private final String FILE_PATH = "res/input.txt";

	
	public A1() {
		fileReader = new Scanner(System.in);
		printWords = new PrintWordLists();
		wordList = new ArrayList<Token>();
		stopWords = new ArrayList<String>(Arrays.asList("a", "about", "all", "am", "an", "and",
		 "any", "are", "as", "at", "be", "been", "but", "by", "can", "cannot", "could", "did",
		 "do", "does", "else", "for", "from", "get", "got", "had", "has", "have", "he", "her", "hers",
		 "him", "his", "how", "i", "if", "in", "into", "is", "it", "its", "like", "more", "me", "my",
		 "no", "now", "not", "of", "on", "one", "or", "our", "out", "said", "say", "says", "she",
		 "so", "some", "than", "that", "the", "their", "them", "then", "there", "these", "they",
		 "this", "to", "too", "us", "upon", "was", "we", "were", "what", "with", "when", "where",
		 "which", "while", "who", "whom", "why", "will", "you", "your"));
				
		try {
			text = new File(FILE_PATH);
			fileReader = new Scanner(text);
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		A1 A1Manager = new A1();
		A1Manager.checkWords();


		A1Manager.printResults();
	}


	public void printResults() {
		printWords.totalWordCount(totalWordCount);
		printWords.uniqueWordCount(uniqueWordCount);
		printWords.stopWordCount(stopWordWordCount);

		Collections.sort(wordList, new mostUsedWords());
		printWords.mostUsedWords(wordList);

		Collections.sort(wordList, new LeastUsedWords());
		printWords.leastUsedWords(wordList);
		
		Collections.sort(wordList);
		printWords.allWords(wordList);
	}
		

    public void checkWords() {
		ArrayList<String> allWordsString = new ArrayList<String>();
		ArrayList<Token> allWordsToken = new ArrayList<Token>();

    	while(fileReader.hasNextLine()) {
			String currLine = fileReader.nextLine().strip().toLowerCase().replaceAll("[^A-Za-z ]", "").replaceAll("\s+", " "); 		// used https://stackoverflow.com/questions/7233447/a-regex-to-match-strings-with-alphanumeric-spaces-and-punctuation for help with regex
			if(!(currLine.equals(""))) {
				for(String individualWordsInLine: currLine.strip().split(" ")) {
					Token word;
					word = new Token(individualWordsInLine, totalWordCount, stopWordWordCount, uniqueWordCount); 

					if(!(allWordsString.contains(word.getWord()))) {

						if(stopWords.contains(word.getWord())) {
							word.increaseIndividualWordCount();
							word.increaseStopWordWordCount();
							word.increaseTotalWordCount();
							allWordsString.add(word.getWord());
							allWordsToken.add(word);
						} else {
							word.increaseIndividualWordCount();
							word.increaseTotalWordCount();
							word.increaseUniqueWordCount();
							wordList.add(word);
							allWordsString.add(word.getWord());
							allWordsToken.add(word);
						}
					} else {
						for(Token wordToCheck: allWordsToken) {
							if(wordToCheck.getWord().equals(word.getWord())) {
								word.setIndividualWordCount(wordToCheck.getIndividualWordCount() + 1);
								wordToCheck.setIndividualWordCount(word.getIndividualWordCount());
								break;
							}
						}
						word.increaseTotalWordCount();
						if(stopWords.contains(word.getWord())) {
							word.increaseStopWordWordCount();
						} 
					}
					totalWordCount = word.getTotalWordCount();
					stopWordWordCount = word.getStopWordWordCount();
					uniqueWordCount = word.getUniqueWordCount();
				}
			}
    	}	
	}
}
