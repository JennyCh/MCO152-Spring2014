package charnetskaya.forecast;

import java.util.ArrayList;
import java.util.List;

public class Temperatures

{
	private ArrayList<Temp> list;

	public List<Temp> getList() {

		return list;
	}

	public class Temp implements Comparable<Temp> {
		private Record temp;

		public Record getRecord() {
			return temp;
		}

		class Record {
			private double day;

			public double getDay() {
				return day;
			}

		}

		public int compareTo(Temp temp) {
			// TODO Auto-generated method stub
			if (this.getRecord().getDay() > temp.getRecord().getDay()) {
				return 1;
			} else if (this.getRecord().getDay() < temp.getRecord().getDay()) {
				return -1;
			}
			return 0;
		}

	}

}
