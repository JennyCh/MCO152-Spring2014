package charnetskaya.morseCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testAlphabetToMorseCode() {
		MorseCode morseCode = new MorseCode();
		String alphabet = "5789";
		String code;

		code = morseCode.toMorseCode(alphabet);
		String expected = ".- -... -.-. . -.. ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
		expected = "..... --... ---.. ----.";
		// alphabet = "A B C";

		Assert.assertEquals(expected, code);
		
		
		expected = "- .... .-. . . / -... .-.. .. -. -.. / -- .. -.-. .";
		code = morseCode.toMorseCode("THREE BLIND MICE");
		Assert.assertEquals(expected, code);

	}

	@Test
	public void testMorseCodeToAlphabet() {

		MorseCode morseCode = new MorseCode();
		String morse = "- .... .-. . . / -... .-.. .. -. -.. / -- .. -.-. .";
		// ".- / -... / -.-."
		String words;

		words = morseCode.toPlainText(morse);
		/*
		 * System.out.println("words " + "|" + words + "|");
		 * System.out.println(words);
		 */
		String expected = "THREE BLIND MICE";
		Assert.assertEquals(expected, words);

	}

}
