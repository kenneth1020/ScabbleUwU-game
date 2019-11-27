/*****
 * 
 * kenneth tran
 * 10/23/19
 * Scabble game
 * This program will give you five words its the player job to used those five words
 * To make a word to get a point.
 * -------------------------------------------------
 *This part of the program is the constructor 
 *Creating the setter and getter
 */
public class Scabbles {
	private String words;
	
	public Scabbles() {
		words = "AAAAA";
	}
	public Scabbles(String words) {
		super();
		this.words = words;
	}
	/**
	 * @return the words
	 */
	public String getWords() {
		return words;
	}
	/**
	 * @param words the words to set
	 */
	public void setWords(String words) {
		this.words = words;
	}
	
	
	@Override
	public String toString() {
		return "Scrabble [ Words: " + words + "]";
}
	
}
