package charnetskaya.weatherForecastParsingGsonPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class DisplayGsonFile {
	
	public static void main (String [] args) throws IOException{
		URL url = null;
		
		url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=brooklyn&mode=gson&units=metric&cnt=7");
		URLConnection connection  = null;
		connection = url.openConnection();
		Gson gson = new Gson();
		InputStream in = null;
		in = connection.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Forecast data = gson.fromJson(reader, Forecast.class);
		
		System.out.println (data);
		
	}

}
