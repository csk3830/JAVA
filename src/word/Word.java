package word;

import java.util.ArrayList;
import java.util.List;

public class Word {
	
	private int wordId;
	private String word;
	private List<String> meanings = new ArrayList<String>();
	
	public Word(int wordId, String word, List<String> meanings) {
		this.wordId = wordId;
		this.word = word;
		this.meanings = meanings;
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<String> getMeanings() {
		return meanings;
	}

	public void setMeanings(List<String> meanings) {
		this.meanings = meanings;
	}

	@Override
	public String toString() {
		return wordId + "." + word + ":" + meanings;
	}


	

	
	
	
}
