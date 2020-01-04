import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
public class LeagueInvaders {
	static JFrame frame;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
public static void main(String[] args) {
	
	GamePanel panel = new GamePanel();



frame = new JFrame();
frame.setVisible(true);
frame.add(panel);
frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
frame.pack();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}



	
} 




