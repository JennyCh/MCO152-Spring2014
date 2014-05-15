package charnetskaya.computePI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BadPiGUI extends JFrame implements ActionListener, Runnable {
	private JButton button;
	private JTextArea area;

	public BadPiGUI() {
		button = new JButton("Start");
		area = new JTextArea();

		add(area, BorderLayout.NORTH);
		add(button, BorderLayout.SOUTH);

		button.addActionListener(this);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(200, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BadPiGUI();
	}
//
	public void run() {
		// TODO Auto-generated method stub
		int i = 1000000;
		double result = 0;
		for (int j = 1; j <= i; j++) {
			result += 4 * (Math.pow(-1, j + 1)) / (2 * j - 1);
			area.setText(String.valueOf(result));
			System.out.println ("i run");
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Thread t = new Thread(this);
		t.start();
	}

}
