
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;

public class LeagueInvaders {
	static JFrame frame;
	GamePanel gamePanel;

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}

	public static void main(String[] args) {

		LeagueInvaders league = new LeagueInvaders();

		league.setup();
	
	}

	public void setup() {
		frame.setVisible(true);
		frame.add(gamePanel);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamePanel);

	}

	
	
	

}

//league Invaders
