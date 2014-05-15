package charnetskaya.stock;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import charnetskaya.stocks.AmexData;
import charnetskaya.stocks.DailyPrice;

public class AmexDataTest {

	private AmexData amex;
	@Before
	public void testConstructor() {
		
		try {
			amex = new AmexData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fail("exception thrown");
		}
	}
	@Test
	public void testContains(){
		
			Assert.assertTrue(amex.contains("AIP"));
			Assert.assertTrue(amex.contains("AHY"));
			Assert.assertTrue(amex.contains("BZM"));
			Assert.assertTrue(amex.contains("ZN"));
			Assert.assertTrue(amex.contains("ZBB"));
			Assert.assertFalse(amex.contains("AAAA"));
	
	}
	@Test
	public void testGetPrices (){
		
			List<DailyPrice> expected = amex.getPrices("AIP");
			Assert.assertEquals(expected.size(), 6412);
			expected = amex.getPrices("ZBB");
			Assert.assertEquals(expected.size(), 667);
		
			expected = amex.getPrices("AAAA");
			Assert.assertEquals(expected.size(), 0);
		
	}
	
	@Test
	public void getPricesByDate (){
		Calendar begin = new GregorianCalendar(2007,7,2);
		Calendar finish = new GregorianCalendar(2007,7,9);
		Date start = new Date(begin.getTimeInMillis());
		Date end = new Date(finish.getTimeInMillis());
		List<DailyPrice> expected = amex.getPrices("ZBB", start, end);
		Assert.assertEquals(expected.size(), 5);
		
		expected = amex.getPrices("AAA", start, end);
		Assert.assertEquals(expected.size(), 0);
		
		start = end = new Date();
		expected = amex.getPrices("ZBB", start, end);
		Assert.assertEquals(expected.size(), 0);
		
		begin = new GregorianCalendar(2007,7,9);
		finish = new GregorianCalendar(2007,7,2);
		start = new Date(begin.getTimeInMillis());
		end = new Date(finish.getTimeInMillis());
		expected = amex.getPrices("ZBB", start, end);
		Assert.assertEquals(expected.size(), 0);
		
		
		
				
		
		
	}

}
