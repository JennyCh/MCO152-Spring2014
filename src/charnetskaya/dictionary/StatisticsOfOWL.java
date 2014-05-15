package charnetskaya.dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StatisticsOfOWL {

	private final ArrayList<StatisticsLetter> statUnits;

	public StatisticsOfOWL() {
		statUnits = new ArrayList<StatisticsLetter>();

		Letters[] enumLetters = Letters.values();

		for (int i = 0; i < enumLetters.length; i++) {
			statUnits.add(new StatisticsLetter(enumLetters[i].getLetter()));
		}

	}

	public ArrayList<StatisticsLetter> getStatUnits() {
		return statUnits;
	}

	private void calculateStatistics() throws FileNotFoundException {

		Dictionary dictionary = new Dictionary();
		ArrayList<Word> words = dictionary.getArray();

		for (StatisticsLetter letter : statUnits) {
			Integer numOccured = 0;
			Integer numWordsHaveLetter = 0;
			boolean occured = false;
			for (Word word : words) {
				occured = false;
				for (int i = 0; i < word.getWord().length(); i++) {

					if (letter.getLetter().equalsIgnoreCase(
							word.getWord().substring(i, i + 1))) {
						numOccured++;
						occured = true;

					}

				}
				if (occured) {
					numWordsHaveLetter++;
				}

			}

			letter.setTimesOccured(numOccured);
			letter.setNumWordsWhereLetterOccured(numWordsHaveLetter);
			letter.setPercentegeOccured((double) numWordsHaveLetter * 100
					/ words.size());

		}

	}

	public static void main(String[] args) throws Exception {
		StatisticsOfOWL statistics = new StatisticsOfOWL();
		statistics.calculateStatistics();
		ArrayList<StatisticsLetter> letters = statistics.getStatUnits();
		for (StatisticsLetter s : letters) {
			System.out.println(s);
		}

	}
}
