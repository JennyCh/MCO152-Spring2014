package charnetskaya.screenResulutions;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame  extends JFrame{
	
	public static void main (String [] args) throws InterruptedException{
		DisplayMode displayMode;
		if(args.length == 3){
			displayMode = new DisplayMode(
					Integer.parseInt(args[0]), 
					Integer.parseInt(args[1]), 
					Integer.parseInt(args[2]), 
					DisplayMode.REFRESH_RATE_UNKNOWN
					);
		}else{
			displayMode = new DisplayMode(1024,768,16, DisplayMode.REFRESH_RATE_UNKNOWN);
		}
		
		Frame test = new Frame();
		test.run(displayMode);
	}
	
	private static final long DEMO_TIME =10000;
	private static final int FONT_SIZE = 24;
	private SimpleScreenManager screen; 
	private boolean loaded;
	private Image bgImage = null;
	
	
	public void run (DisplayMode displayMode) throws InterruptedException{
		setBackground(Color.pink);
		setForeground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 24));
		loaded = false;
		screen = new SimpleScreenManager();
		
		try{
			screen.setFullScreen(displayMode, this);
			Thread.sleep(5000);
			loadImages();
			try{
				Thread.sleep(DEMO_TIME);
			}catch(InterruptedException e){}
		}finally{
			screen.restoreScreen();
		}
	}
	
	public void loadImages(){
		bgImage = loadImage("rain.jpg");
		System.out.println ("loaded");
		loaded = true;
		repaint();
	}
	
	private Image loadImage(String fileName){
		return new ImageIcon(fileName).getImage();
	}
	
	public void paint(Graphics g){
		
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		//g.drawString("Hello World", 20, 50);
		//
		if(loaded){
			System.out.println ("begin");
		g.drawImage(bgImage, 0 , 0, null);
		}else{
			g.drawString("Loading Images..."	, 5, FONT_SIZE);
		}
	}
	
	public void drawImage(Graphics g, Image image, int x, int y, String caption){
		//System.out.println("here");
		g.drawImage(image, x, y, null);
		//g.drawString(caption, x+5, y+FONT_SIZE + image.getHeight(null));
		System.out.println("there");
	}
/*	public Frame(){
	JFrame window = new JFrame();
	DisplayMode displayMode = new DisplayMode(1280,1024,15,75);
	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = environment.getDefaultScreenDevice();
	device.setFullScreenWindow(window);
	device.setDisplayMode(displayMode);
	
	}
	public static void main (String [] args){
		new Frame();
	}
	*/
	
	
	
}
