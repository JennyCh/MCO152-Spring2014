package charnetskaya.smily;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ViewComponent extends JComponent {

	public ViewComponent() {
		this.setSize(100, 100);

	}

	@Override
	public void paintComponent(Graphics pen) {
		// super.paint(pen);
		// pen.drawRect(0, 0, 100, 100);
		pen.setColor(Color.BLUE);
		pen.fillRect(0, 0, this.getWidth(), this.getHeight());
		// pen.fillOval(0, 0, 75, 75);
		/*
		 * int value = comp.getValue();
		 * 
		 * switch (value){ case 0: pen.setColor(Color.WHITE); break; case 1:
		 * pen.setColor(Color.GREEN); break; case 2: pen.setColor(Color.YELLOW);
		 * break; case 3: pen.setColor(Color.RED); break; }
		 */
		pen.setColor(Color.YELLOW);
		pen.fillOval(0, 0, this.getWidth() - 4, this.getHeight() - 4);

		pen.setColor(Color.BLACK);
		pen.fillOval(15, 15, 15, 15);
		pen.fillOval(65, 15, 15, 15);

		pen.fillArc(100, 100, 100, 100, 70, 30);
		pen.drawLine(15, 75, 15, 56);
	}

	/*
	 * public ArrayComponent getComp(){ return comp; }
	 */
}
