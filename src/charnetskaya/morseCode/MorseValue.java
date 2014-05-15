package charnetskaya.morseCode;

public class MorseValue {
	
	private String letter;
	private String morse;
	
	public MorseValue (String letter, String morse){
		this.letter = letter;
		this.morse = morse;
	}

	public String getLetter() {
		return letter;
	}

	public String getMorse() {
		return morse;
	}
	
	public String toString(){
		return "\n" + letter + "|" + morse +"|";
		
	}
	
	

}
