package charnetskaya.weather;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.google.gson.Gson;

public class WeatherGB extends JFrame implements ActionListener, Runnable {

	private JLabel cityLabel;
	private JTextField cityEnter;
	private JLabel resultArea;
	private JButton showWeather;
	private Conditions list;
	private StringBuilder modName;

	public WeatherGB() throws IOException {

		// System.out.println(list);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Weather");
		this.setLocation(100,100);
		this.setSize(600, 600);

		cityLabel = new JLabel("Enter city:  ");
		cityEnter = new JTextField();
		resultArea = new JLabel("");
		showWeather = new JButton("Show Weather");
		showWeather.addActionListener(this);

		this.add(cityLabel, BorderLayout.WEST);
		this.add(cityEnter, BorderLayout.NORTH);
		this.add(resultArea, BorderLayout.CENTER);
		this.add(showWeather, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new WeatherGB();
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if ("".equals(cityEnter)) {

		} else {
			Thread t = new Thread(this);
			t.start();
			String cityName = cityEnter.getText();
			char [] name = cityName.toCharArray();
			 modName = new StringBuilder();
			for(char n: name){
				if (n == ' '){
					n = '+';
				}
				modName.append(n);
			}
			
			JOptionPane.showMessageDialog(null, modName);
					
		
			
			resultArea.setText(list.toString());
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		URL url = null;
		try {
			url = new URL(
					"http://api.openweathermap.org/data/2.5/weather?q=" + modName);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URLConnection connection = null;
		try {
			connection = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		InputStream in = null;
		try {
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(in));

		list = gson.fromJson(reader, Conditions.class);
	}

}
