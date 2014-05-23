package charnetskaya.earthquakes;

import java.awt.Color;

import javax.swing.JLabel;

public class BuildLabel extends Thread{

	private JLabel label;
	private String data;
	private Color color;
	
	public BuildLabel (Color color, String data){
		this.color = color;
		this.data = data;
	}
	
	public void run(){
		this.label = new JLabel(data);
		this.label.setBackground(color);
	}

	public JLabel getLabel() {
		return label;
	}
	
}
