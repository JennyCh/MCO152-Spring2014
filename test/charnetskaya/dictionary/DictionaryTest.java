package charnetskaya.dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

	private ArrayList<Word> words;
	private Dictionary d;

	@Before
	public void setUp() {
		try {
			d = new Dictionary();
			words = d.getArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test() {
		boolean exists;

		exists = d.exists("AW");
		Assert.assertTrue(exists);

	}

}