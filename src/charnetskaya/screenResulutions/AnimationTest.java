package charnetskaya.screenResulutions;

import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class AnimationTest {

	public static void main (String [] args){
		DisplayMode displayMode;
		
		displayMode = new DisplayMode(1024, 768,16,DisplayMode.REFRESH_RATE_UNKNOWN);
		AnimationTest test = new AnimationTest();
		test.run(displayMode);
		
		
	}
	
	private static final long DEMO_TIME = 5000;
	
	private SimpleScreenManager screen;
	private Image bgImage;
	private Animation anim;
	
	public void loadImages(){
		bgImage = loadImage("pic.jpg");
		Image player1 = loadImage("mikey1.jpg");
		Image player2 = loadImage("mikey2.jpg");
		Image player3 = loadImage("mikey3.jpg");
		
		
		anim = new Animation();
		anim.addFrame(player1,  250);
		anim.addFrame(player2,  250);
		anim.addFrame(player3,  150);
		anim.addFrame(player2,  150);
		anim.addFrame(player3,  200);
		anim.addFrame(player1,  150);
		
	}
	
	private Image loadImage(String fileName){
		return new ImageIcon(fileName).getImage();
	}
	
	public void run(DisplayMode displayMode){
		screen = new SimpleScreenManager();
		try{
			screen.setFullScreen(displayMode, new JFrame());
			loadImages();
			animationLoop();
		}finally{
			screen.restoreScreen();
		}
	}
	
	public void animationLoop(){
		long startTime = System.currentTimeMillis();
		long currTime = startTime;
		
		while(currTime - startTime < DEMO_TIME){
			long elapsedTime = System.currentTimeMillis() - currTime;
			currTime += elapsedTime;
			
			anim.update(elapsedTime);
			
			Graphics g = screen.getFullScreenWindow().getGraphics();
			draw(g);
			g.dispose();
			
			try{
				Thread.sleep(20);
				
			}catch(InterruptedException e){}
			
		}
	}
	
	public void draw (Graphics g){
	//	g.drawImage(bgImage, 0, 0, null);
		g.drawImage(anim.getImage(), 0, 0, null);
	}
}
