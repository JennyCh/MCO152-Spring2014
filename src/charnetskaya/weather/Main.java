package charnetskaya.weather;

import com.google.gson.annotations.SerializedName;

public class Main {

	private double temp;
	private int pressure;
	private int humidity;
	@SerializedName("temp_min")
	private double tempMin;
	@SerializedName("temp_max")
	private double tempMax;
	public double getTemp() {
		return temp;
	}
	public int getPressure() {
		return pressure;
	}
	public int getHumidity() {
		return humidity;
	}
	public double getTempMin() {
		return tempMin;
	}
	public double getTempMax() {
		return tempMax;
	}
	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + ", humidity="
				+ humidity + ", tempMin=" + tempMin + ", tempMax=" + tempMax
				+ "]";
	}
	
	
}
