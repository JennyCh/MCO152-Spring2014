package charnetskaya.flicker;

import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {
	ImageIcon image = null;
	public DownloadImageThread(final JLabel label, final String url) {
		
		try {
		  
		    image = new ImageIcon(new URL(url));
		    label.setIcon(image);
		} catch (IOException e) {
		}
	}
	
	public void run(){
		super.run();
	}

}
