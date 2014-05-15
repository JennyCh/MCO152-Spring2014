package charnetskaya.touro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TouroHTML {

	public static void main (String [] args) throws IOException{
		URL url = new URL("http://www.touro.edu/students");
		
		URLConnection connection = url.openConnection();
		
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String line;
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
	}
}
