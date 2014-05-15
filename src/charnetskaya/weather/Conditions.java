package charnetskaya.weather;

import java.util.ArrayList;

public class Conditions {
	private Coord coord;
	private Sys sys;
	private ArrayList<Weather> weather;
	private String base;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	
	
	private long dt;
	private long id;
	private String name;
	private int cod;
	@Override
	public String toString() {
		return "Conditions [coord=" + coord + ", sys=" + sys + ", weather="
				+ weather + ", base=" + base + ", main=" + main + ", wind="
				+ wind + ", clouds=" + clouds + ", dt=" + dt + ", id=" + id
				+ ", name=" + name + ", cod=" + cod + "]";
	}
	
	
}
