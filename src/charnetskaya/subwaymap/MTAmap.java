package charnetskaya.subwaymap;

import java.awt.Component;
import java.io.IOException;

import javax.swing.JFrame;

public class MTAmap extends JFrame {

	public MTAmap() {
		try {

			Component view = new ShapeView(new Trips(), new Routes(),
					new Shapes());
			this.add(view);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("MTA MAP");
			setSize(500, 500);
			setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new MTAmap();
	}
}
