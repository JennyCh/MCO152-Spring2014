package charnetskaya.dictionary;

public class Word {
	private String word;
	private String description;
	
	public Word (String word, String description){
		this.word = word;
		this.description = description;
	}
	
	public Word(Word word){
		if(word != null){
			this.word = word.word;
			this.description = word.description;
		}
	}

	public String getWord() {
		return word;
	}

	public String getDescription() {
		return description;
	}
	
	public String toString (){
		return word + " | " + description;
	}
	

}
