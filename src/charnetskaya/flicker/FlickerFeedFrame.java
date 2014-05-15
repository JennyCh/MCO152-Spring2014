package charnetskaya.flicker;

import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private FlickerFeed feed = null;
	private JPanel mainPanel;

	public FlickerFeedFrame() throws IOException {

		mainPanel = new JPanel(new FlowLayout());
this.add(mainPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		JScrollPane pane = new JScrollPane(mainPanel,
				JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.setContentPane(pane);
		this.setVisible(true);

		DownloadFlickerFeedThread t = new DownloadFlickerFeedThread(this);
		t.start();
		loadImages(t.getList());

	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 * 
	 * @throws IOException
	 */
	public void loadImages(final FlickerFeed feed) {
		JLabel label = null;
		ArrayList<Item> list = feed.getItems();
		for (int i = 0; i < 20; i++) {
			label = new JLabel();
			DownloadImageThread t = new DownloadImageThread(label, list.get(i)
					.getMedia().getM());
			t.start();
			mainPanel.add(label);
		}

	}

	public static void main(final String args[]) throws IOException {
		new FlickerFeedFrame().setVisible(true);
	}

}
