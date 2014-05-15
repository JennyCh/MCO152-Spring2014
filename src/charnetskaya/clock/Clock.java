package charnetskaya.clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Clock extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private static int w = 600;
	private static int h = 626;
	private final Image img = Toolkit.getDefaultToolkit().createImage(
			"kitty.jpg");


	public Clock() {

		this.setTitle("Clock");
		this.setSize(w, h);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(new ComponentView());
		this.setVisible(true);

		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private class ComponentView extends JComponent {

		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics pen) {
			int center = h / 2;
			double time = (int) System.currentTimeMillis();
			int radius = h - 100;
			int sin;
			int cos;
			pen.setColor(Color.WHITE);
			pen.fillRect(0, 0, w, h);

			pen.setColor(Color.PINK);
			pen.fillOval(0, 0, w - 5, h - 30);

			pen.setColor(Color.CYAN);
			pen.fillOval(20, 20, w - 40, h - 70);

			pen.drawImage(img, 0, 0, null);

			pen.setColor(Color.PINK);
			pen.setFont(new Font("Helvetica", Font.BOLD, 24));
			pen.drawString("LEAH DINA", 225, 500);
			Graphics2D pen2 = (Graphics2D) pen;
			pen2.setStroke(new BasicStroke(10));
			radius = h - 130;
			time = System.currentTimeMillis() % 60000.0 / 60000 * Math.PI * 2;
			sin = (int) ((center) + (Math.sin(time) * radius / 2));
			cos = (int) ((center) - (Math.cos(time) * radius / 2));

			pen2.setColor(Color.RED);
			pen2.drawLine(center, center, sin, cos);

			radius = h - 150;
			time = System.currentTimeMillis() % 3600000.0 / 3600000 * Math.PI
					* 2;
			sin = (int) ((center) + (Math.sin(time) * radius / 2));
			cos = (int) ((center) - (Math.cos(time) * radius / 2));

			pen2.setColor(Color.BLUE);
			pen2.drawLine(center, center, sin, cos);

			radius = h - 300;

			time = System.currentTimeMillis() % 43200000.00 / 43200000.00
					* Math.PI * 2 + 1;
			// System.out.println ("--> " + System.currentTimeMillis() %
			// 43200000.00);
			// System.out.println (System.currentTimeMillis() % 43200000.00/
			// 43200000);
			sin = (int) ((center) - (Math.sin(time) * radius / 2));
			cos = (int) ((center) + (Math.cos(time) * radius / 2));

			pen2.setColor(Color.YELLOW);
			pen2.drawLine(center, center, sin, cos);

		}
	}

	public static void main(String[] args) {
		new Clock();
	}

}
