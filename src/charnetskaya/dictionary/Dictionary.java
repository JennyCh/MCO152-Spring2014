package charnetskaya.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {

	private final ArrayList<Word> words;
	private final Set<String> set;
	private final Map<String, String> map;

	@SuppressWarnings("resource")
	public Dictionary() throws FileNotFoundException {
		set = new HashSet<String>();
		words = new ArrayList<Word>();
		map = new HashMap<String, String>();
		Scanner in = null;
		File file = new File("OWL.txt");
		try {
			in = new Scanner(file);

			while (in.hasNext()) {
				String word = in.next();
				String desc = in.nextLine();
				set.add(word);
				map.put(word, desc);
				
				words.add(new Word(word, desc));
			}
		

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(
					"Dictionary file could not be located");
		}

	}

	public boolean exists(String word) {
		/*
		 * for (Word w : words) { if (w.getWord().equalsIgnoreCase(word)) {
		 * return true; } } return false;
		 */
		
		//return set.contains(word.toUpperCase());
		
		return map.containsKey(word.toUpperCase());
	}
	
	public Iterator<String> iterator(){
		return map.keySet().iterator();
	}

	public ArrayList<Word> getArray() {
		ArrayList<Word> copy = new ArrayList<Word>();
		for (Word w : words) {
			copy.add(new Word(w));
		}
		return copy;
	}

}
