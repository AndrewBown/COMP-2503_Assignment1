package mru.assignment1.model;

public class Token implements Comparable<Token>{

	int individual_word_count;
	int total_word_count;
	String word;
	int count;

	
	public Token(String word) {
		this.word = word;
		this.count = 0;
	}
	
	public boolean equals(Token t) {
		
		
		return this.word == t.getWord();
	}
	
	public int compareTo(Token t) {

		return 0;
	}
	
	public void increaseCount() {
		count += 1;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getWord() {
		return word;
	}
}
