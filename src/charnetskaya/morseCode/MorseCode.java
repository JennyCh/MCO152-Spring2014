package charnetskaya.morseCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MorseCode {

	private final Map<String, String> map;

	public MorseCode() {
		map = new HashMap<String, String>();

		map.put("A", ".-");
		map.put(".-", "A");
		map.put("B", "-...");
		map.put("-...", "B");
		map.put("C", "-.-.");
		map.put("-.-.", "C");
		map.put("D", "-..");
		map.put("-..", "D");
		map.put("E", ".");
		map.put(".", "E");
		map.put("F", "..-.");
		map.put("..-.", "F");
		map.put("G", "--.");
		map.put("--.", "G");
		map.put("H", "....");
		map.put("....", "H");
		map.put("I", "..");
		map.put("..", "I");
		map.put("J", ".---");
		map.put(".---", "J");
		map.put("K", "-.-");
		map.put("-.-", "K");
		map.put("L", ".-..");
		map.put(".-..", "L");
		map.put("M", "--");
		map.put("--", "M");
		map.put("N", "-.");
		map.put("-.", "N");
		map.put("O", "---");
		map.put("---", "O");
		map.put("P", ".--.");
		map.put(".--.", "P");
		map.put("Q", "--.-");
		map.put("--.-", "Q");
		map.put("R", ".-.");
		map.put(".-.", "R");
		map.put("S", "...");
		map.put("...", "S");
		map.put("T", "-");
		map.put("-", "T");
		map.put("U", "..-");
		map.put("..-", "U");
		map.put("V", "...-");
		map.put("...-", "V");
		map.put("W", ".--");
		map.put(".--", "W");
		map.put("X", "-..-");
		map.put("-..-", "X");
		map.put("Y", "-.--");
		map.put("-.--", "Y");
		map.put("Z", "--..");
		map.put("--..", "Z");
		map.put("0", "-----");
		map.put("-----", "0");
		map.put("1", ".----");
		map.put(".----", "1");
		map.put("2", "..---");
		map.put("..---", "2");
		map.put("3", "...--");
		map.put("...--", "3");
		map.put("4", "....-");
		map.put("....-", "4");
		map.put("5", ".....");
		map.put(".....", "5");
		map.put("6", "-....");
		map.put("-....", "6");
		map.put("7", "--...");
		map.put("--...", "7");
		map.put("8", "---..");
		map.put("---..", "8");
		map.put("9", "----.");
		map.put("----.", "9");
		map.put(" ", "/");
		map.put("/", " ");
	}

	public String toMorseCode(String plainText) {

		StringBuilder morseCode = new StringBuilder("");

		for (int i = 0; i < plainText.length(); i++) {
			String letter = String.valueOf(plainText.charAt(i)).toUpperCase();
			morseCode.append(map.get(letter));
			morseCode.append(" ");

		}
		if (morseCode.length() > 0) {
			int index = morseCode.lastIndexOf(" ");

			morseCode.deleteCharAt(index);
		}

		return morseCode.toString();

	}

	public String toPlainText(String morseCode) {

		StringBuilder plainText = new StringBuilder("");

		char[] morseChars = morseCode.toCharArray();

		ArrayList<String> morseStrings = new ArrayList<String>();

		StringBuilder morseLetter = new StringBuilder("");
		for (int i = 0; i < morseChars.length; i++) {
			if (morseChars[i] != ' ') {
				morseLetter.append(morseChars[i]);
				if (morseChars.length == (i + 1)) {
					morseStrings.add(morseLetter.toString());
					morseLetter = new StringBuilder("");
				}
			} else {
				morseStrings.add(morseLetter.toString());
				morseLetter = new StringBuilder("");
			}
		}

		for (String morseValue : morseStrings) {
			plainText.append(map.get(morseValue));
		}

		return plainText.toString();
	}

}
