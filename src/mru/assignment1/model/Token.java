package mru.assignment1.model;

public class Token implements Comparable<Token>{

	int individualWordCount;
	int totalWordCount;
	int stopWordWordCount;
	int uniqueWordCount;
	String word;

	
	public Token(String word, int totalWordCount, int stopWordWordCount, int uniqueWordCount) {
		this.word = word;
		this.totalWordCount = totalWordCount;
		this.stopWordWordCount = stopWordWordCount;
		this.uniqueWordCount = uniqueWordCount;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Token)) {
			return false;
		}
		Token t = (Token) obj;
		return this.word.equals(t.getWord());
	}
	
	public int compareTo(Token t) {
        return this.word.compareTo(t.word);
    }
		
	public String getWord() {
		return word;
	}

	public void increaseIndividualWordCount() {
		individualWordCount += 1;
	}

	public void increaseTotalWordCount() {
		totalWordCount += 1;
	}

	public void setIndividualWordCount(int individualWordCount) {
		this.individualWordCount = individualWordCount;
	}

	public int getIndividualWordCount() {
		return individualWordCount;
	}

	public int getTotalWordCount() {
		return totalWordCount;
	}

	public void increaseStopWordWordCount() {
		stopWordWordCount += 1;
	}

	public int getStopWordWordCount() {
		return stopWordWordCount;
	}

	public void increaseUniqueWordCount() {
		uniqueWordCount += 1;
	}

	public int getUniqueWordCount() {
		return uniqueWordCount;
	}


	

}
