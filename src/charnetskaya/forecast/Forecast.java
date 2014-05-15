package charnetskaya.forecast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.gson.Gson;

public class Forecast extends JFrame implements ActionListener, Runnable {

	private JLabel cityLabel;
	private JTextField cityEnter;
	private JPanel topPanel;
	private JLabel resultLabel;
	private JLabel resultArea;
	private JPanel middlePanel;
	private JButton showForecast;
	private JPanel lowerPanel;
	private Temperatures list;

	public Forecast() {

		cityEnter = new JTextField(30);
		cityEnter.setText("london");

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Forecast");
		this.setLocation(100, 100);
		this.setSize(600, 600);
		this.setResizable(false);

		cityLabel = new JLabel("Enter city: ");

		resultLabel = new JLabel("");
		resultArea = new JLabel("");
		resultArea.setSize(600, 600);
		showForecast = new JButton("Show Forecast");
		showForecast.addActionListener(this);

		topPanel = new JPanel(new FlowLayout());
		topPanel.add(cityLabel);
		topPanel.add(cityEnter);

		middlePanel = new JPanel(new BorderLayout());
		middlePanel.add(resultLabel, BorderLayout.NORTH);
		middlePanel.add(resultArea, BorderLayout.CENTER);

		lowerPanel = new JPanel();
		lowerPanel.add(showForecast);

		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(middlePanel, BorderLayout.CENTER);
		this.add(lowerPanel, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {
		resultLabel.removeAll();

		resultArea.removeAll();
		repaint();
		if ("".equals(cityEnter.getText())) {
			resultLabel.setText("Please enter city");
			resultLabel.setForeground(Color.RED);
			repaint();
		} else {

			Thread t = new Thread(this);
			t.start();
		}
	}

	public void run() {
		URL url = null;
		try {
			url = new URL(
					"http://api.openweathermap.org/data/2.5/forecast/daily?q="
							+ cityEnter.getText()
							+ "&mode=gson&units=metric&cnt=7");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		URLConnection connection = null;
		try {
			connection = url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		InputStream in = null;
		try {
			in = connection.getInputStream();
		} catch (IOException e) {

			e.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		list = gson.fromJson(reader, Temperatures.class);

		resultLabel.setText("");
		try {
			resultArea.add(new ShapeView(list));
		} catch (NullPointerException e) {
			resultLabel
					.setText("City " + cityEnter.getText() + " is NOT FOUND");
			resultLabel.setForeground(Color.RED);
		}
		repaint();

	}

	public static void main(String[] args) {
		new Forecast();
	}
}
