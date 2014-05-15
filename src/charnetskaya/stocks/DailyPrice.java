package charnetskaya.stocks;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class DailyPrice implements Comparable<DailyPrice> {

	private String exchange;
	private String stockSymbol;
	private Date date;
	private double stockPriceOpen;
	private double stockPriceHigh;
	private double stockPriceLow;
	private double stockPriceClose;
	private int stockVolume;
	private double stockPriceAdjClose;

	public DailyPrice(String[] nextLine) throws IOException {
		// String [] nextLine;
		// while((nextLine = reader.readNext()) != null){

		this.exchange = nextLine[0];
		this.stockSymbol = nextLine[1];

		StringTokenizer token = new StringTokenizer(nextLine[2], "-");
		// System.out.println (nextLine[2]);
		ArrayList<Integer> triDate = new ArrayList<Integer>(3);
		while (token.hasMoreElements()) {
			// System.out.println (token.nextElement());
			triDate.add(Integer.parseInt((String) token.nextElement()));
		}

		Calendar cal = new GregorianCalendar(triDate.get(0),
				triDate.get(1) - 1, triDate.get(2));
		this.date = new Date(cal.getTimeInMillis());

		this.stockPriceOpen = Double.parseDouble((String) nextLine[3]);
		this.stockPriceHigh = Double.parseDouble((String) nextLine[4]);
		this.stockPriceLow = Double.parseDouble((String) nextLine[5]);
		this.stockPriceClose = Double.parseDouble((String) nextLine[6]);
		this.stockVolume = Integer.parseInt((String) nextLine[7]);
		this.stockPriceAdjClose = Double.parseDouble((String) nextLine[8]);

		// }
	}

	public DailyPrice(DailyPrice record) {
		this.exchange = record.exchange;
		this.stockSymbol = record.stockSymbol;
		this.date = record.date;
		this.stockPriceOpen = record.stockPriceOpen;
		this.stockPriceHigh = record.stockPriceHigh;
		this.stockPriceLow = record.stockPriceLow;
		this.stockPriceClose = record.stockPriceClose;
		this.stockVolume = record.stockVolume;
		this.stockPriceAdjClose = record.stockPriceAdjClose;
	}

	public String getExchange() {
		return exchange;
	}

	public String getSymbol() {
		return stockSymbol;
	}

	public Date getDate() {
		return date;
	}

	public double getOpenPrice() {
		return stockPriceOpen;
	}

	public double getHighPrice() {
		return stockPriceHigh;
	}

	public double getLowPrice() {
		return stockPriceLow;
	}

	public double getClosePrice() {
		return stockPriceClose;
	}

	public int getStockVolume() {
		return stockVolume;
	}

	public double getStockPriceAdjClose() {
		return stockPriceAdjClose;
	}

	@Override
	public String toString() {
		SimpleDateFormat fr = new SimpleDateFormat("MM/dd/yyyy");
		return "date=" + fr.format(date.getTime());

	}

	public int compareTo(DailyPrice arg0) {
		return this.date.compareTo(date);
	}

}
