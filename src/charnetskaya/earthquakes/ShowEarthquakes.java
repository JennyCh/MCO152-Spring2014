package charnetskaya.earthquakes;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import com.google.gson.Gson;

public class ShowEarthquakes extends JFrame implements Runnable{
	private DataList list;
	private JList<String> jList;
	
	
	
	public ShowEarthquakes(){
		Thread t = new Thread(this);
		t.start();
		
		//this.jList = new JList<String>();
		//this.add(jList);
		this.setTitle("Earthquakes");
		this.setLocationRelativeTo(null);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setVisible(true);
		
		
		
	}
	
	

	@Override
	public void run() {
		
	URL url = null;
		
		try {
			url = new URL("http://earthquake-report.com/feeds/recent-eq?json");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URLConnection connection  = null;
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
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		//Map<String, String> map = new HashMap<String, String>();
		list = gson.fromJson(reader, DataList.class);

		String [] array = new String[list.size()];
		/*JLabel [] labels = new JLabel[list.size()];
		JLabel label;
		for(int i = 0; i < labels.length; i++){
			label = new JLabel (array[i]);
			label.setBackground(Color.GREEN);
			labels[i] = label;
		}*/
		
		for(int i = 0; i < list.size(); i++){
			
			array[i] = list.get(i).magnitude + " " + list.get(i).location;
			
		}
jList = new JList<String>(array);
		
		this.add(jList);
		//BuildLabels build = new BuildLabels(this, list);
		//build.start();
		this.setVisible(true);
		Update update = new Update();
		update.start();
		
		
	/*	
		JList<JLabel> labels = new JList<JLabel>();
		
		for(String str: array){
			labels.add(new JLabel(str));
		}
		
		
		this.add(labels);*/
		//JList<JLabel> l = new JList<JLabel>(labels);
		//jList = new JList<String>(array);
	
		//this.add(jList);
		//this.setVisible(true);
		/*for(Data item: list){
			System.out.println(item.location + " " + item.magnitude);
			BuildLabels build = new BuildLabels(jList, item.magnitude + " " + item.location);
			build.start();
		}
		jList = new JList<String>(list);
		this.add(jList);*/
	//System.out.println (list);
		
	}

	public static void main (String [] args){
		new ShowEarthquakes().setVisible(true);
		
	}
	
	private class Update extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					Thread.sleep(1000);repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	
}
