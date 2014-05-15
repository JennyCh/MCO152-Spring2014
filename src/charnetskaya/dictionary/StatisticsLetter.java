package charnetskaya.dictionary;

import java.text.DecimalFormat;

public class StatisticsLetter {

	private final String letter;
	private Integer timesOccured;
	private Integer numWordsWhereLetterOccured;
	private Double percentegeOccured;

	public StatisticsLetter(String letter) /* throws Exception */{
		// if(letter != null){
		this.letter = letter;
		this.timesOccured = 0;
		this.percentegeOccured = 0.0;
		this.numWordsWhereLetterOccured = 0;
		// }else{
		// throw new Exception ("you haven't provided letter");
		// }
	}

	public Integer getNumWordsWhereLetterOccured() {
		return numWordsWhereLetterOccured;
	}

	public void setNumWordsWhereLetterOccured(Integer numWordsWhereLetterOccured) {
		this.numWordsWhereLetterOccured = numWordsWhereLetterOccured;
	}

	public String getLetter() {
		return letter;
	}

	public Integer getTimesOccured() {
		return timesOccured;
	}

	public void setTimesOccured(Integer num) {
		this.timesOccured = num;
	}

	public Double getPercentegeOccured() {
		return percentegeOccured;
	}

	public void setPercentegeOccured(Double p) {
		this.percentegeOccured = p;
	}

	@Override
	public String toString() {
		DecimalFormat fr = new DecimalFormat("#.00");
		return new StringBuilder(letter + " " + timesOccured + " "
				+ fr.format(percentegeOccured) + "%").toString();
	}

}
