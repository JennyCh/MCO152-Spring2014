package charnetskaya.smily;

import java.awt.Component;

import javax.swing.JFrame;

public class SmilyFace extends JFrame {

	public SmilyFace() {
		this.setSize(600, 800);
		this.setTitle("Smile");

		Component c = new ViewComponent();
		this.add(c);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new SmilyFace();
	}
}
