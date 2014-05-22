package charnetskaya.weatherForecastParsingGsonPractice;

import java.util.ArrayList;

public class Forecast {
	
	/*
	 * parsing gson link at http://api.openweathermap.org/data/2.5/forecast/daily?q=brooklyn&mode=gson&units=metric&cnt=7
	 */

	@Override
	public String toString() {
		String info = "";
		info = "Forecast [cod=" + cod + ", message=" + message + ", city="
				+ city + ", cnt=" + cnt + ", list=";

				for(Weather l: list){
					info += "\n" + list;
				}
				return info;
	}
	public int cod;
	public String message;
	public City city;
	public int cnt;
	public ArrayList<Weather> list;

	public class City {
		@Override
		public String toString() {
			return "City [id=" + id + ", name=" + name + ", coord=" + coord
					+ ", country=" + country + ", population=" + population
					+ "]";
		}

		public long id;
		public String name;
		public Coordinates coord;
		public String country;
		public double population;

		public class Coordinates {
			public double lon;
			public double lat;
		}
	}

	public class Weather {
		@Override
		public String toString() {
			return "Weather [dt=" + dt + ", temp=" + temp + ", pressure="
					+ pressure + ", humidity=" + humidity + ", weather="
					+ weather + ", speed=" + speed + ", deg=" + deg
					+ ", clouds=" + clouds + ", rain=" + rain + "]";
		}

		public long dt;
		public Temperature temp;
		public double pressure;
		public double humidity;
		public ArrayList<Conditions> weather;
		public double speed;
		public double deg;
		public double clouds;
		public double rain;

		public class Temperature {
			@Override
			public String toString() {
				return "Temperature [day=" + day + ", min=" + min + ", max="
						+ max + ", night=" + night + ", eve=" + eve + ", morn="
						+ morn + "]";
			}
			public double day;
			public double min;
			public double max;
			public double night;
			public double eve;
			public double morn;
		}

		public class Conditions {
			@Override
			public String toString() {
				return "Conditions [id=" + id + ", main=" + main
						+ ", description=" + description + ", icon=" + icon
						+ "]";
			}
			public int id;
			public String main;
			public String description;
			public String icon;
		}

	}
}
