package charnetskaya.prime;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class CalculatePrimeNumbers extends JFrame implements Runnable,
		ActionListener {
	private JTextArea area;
	private JButton button;
	private JScrollBar bar;
	private int set = 1000;

	public CalculatePrimeNumbers() {
		area = new JTextArea();
		bar = new JScrollBar();
		area.add(bar);
		button = new JButton("Start");
		button.addActionListener(this);

		add(area, BorderLayout.NORTH);
		add(button, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		// TODO Auto-generated method stub
		String text = "";
		boolean is = false;
		for (int j = 1; j <= set; j++) {
			for (int i = 2; i < j;) {
				if (j % i == 0) {
					break;
				} else {
					is = true;
				}
				if (is) {
					text = String.valueOf(j);
					area.setText(area.getText() + " " + text);
				}
				break;
			}

		}

	}

	public static void main(String[] args) {
		new CalculatePrimeNumbers();
	}
}
