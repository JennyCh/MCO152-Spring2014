package charnetskaya.computePI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ComputePI extends JFrame {

	public ComputePI() {
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		final JButton button = new JButton("Start");
		final JTextArea area = new JTextArea();
		button.addActionListener(new ActionListener() {

			
	
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				int i = 1000;

				double result = 0;

				
					for (int j = 1; j <= i; j++) {
						result += 4 *(Math.pow(-1, j + 1)) / (2 * j - 1);
						
						area.setText(String.valueOf(result));
						

					}

			}

		});

		this.setLayout(new BorderLayout());

		this.add(area, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);

		this.setVisible(true);
	}



	public static void main(String[] args) {

		new ComputePI();
	}

}
