package charnetskaya.forecast;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;

import charnetskaya.forecast.Temperatures.Temp;

	public class ShapeView extends JComponent {
		private double min;
		private double max;
		private List<Temp> temps;
		private final int WIDTH = 600;
		private final int HEIGHT = 450;
		private int hIntervalPx;
	//	private Temperatures list;

		public ShapeView(Temperatures list) {

			this.temps = list.getList();

			min = temps.get(0).getRecord().getDay();
			max = temps.get(0).getRecord().getDay();

			for (Temp temp : temps) {
				if (temp.getRecord().getDay() < min) {
					min = temp.getRecord().getDay();
				}
				if (temp.getRecord().getDay() > max) {
					max = temp.getRecord().getDay();
				}
			}

			hIntervalPx = WIDTH / temps.size();

			this.setSize(WIDTH, HEIGHT);

		}

		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(5));
			g.setColor(Color.WHITE);
			g.fillRoundRect(0, 0, 600, 600, 0, 0);
			g.setColor(Color.BLACK);

			for (int i = 0; i < temps.size(); i++) {
				int x1 = hIntervalPx * i;

				int y1 = (int) ((int) HEIGHT - (((temps.get(i).getRecord()
						.getDay() - min)
						/ (max - min) * (HEIGHT))));

				if (i + 1 < temps.size()) {
					int x2 = hIntervalPx * (i + 1);
					int y2 = (int) ((int) HEIGHT - (((temps.get(i + 1)
							.getRecord().getDay() - min)
							/ (max - min) * (HEIGHT))));
					g.drawLine(x1 + 50, y1, x2 + 50, y2);

					g.drawString(
							String.valueOf(temps.get(i).getRecord().getDay()),
							0, y1);

				}

			}
			g2.setStroke(new BasicStroke(1));
			for (int i = 0; i < temps.size(); i++) {
				int y1 = (int) ((int) HEIGHT - (((temps.get(i).getRecord()
						.getDay() - min)
						/ (max - min) * (HEIGHT))));
				int x1 = hIntervalPx * i;
				g.setColor(Color.LIGHT_GRAY);
				g.drawLine(0, y1, x1 + 50, y1);
			}
		}
		
	}