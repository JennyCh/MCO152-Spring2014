package charnetskaya.computePI;

import javax.swing.JTextArea;

public class PiCalcTread extends Thread{

	private JTextArea area;
	
	public PiCalcTread( JTextArea area){
		this.area = area;
	}
	
	public void run(){
		int i = 1000000;

		double result = 0;

		
			for (int j = 1; j <= i; j++) {
				result += 4 *(Math.pow(-1, j + 1)) / (2 * j - 1);
				
				area.setText(String.valueOf(result));
				

			}
	}
}
