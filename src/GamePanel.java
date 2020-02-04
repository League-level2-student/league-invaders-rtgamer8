import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	Rocketship ship = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(ship);
	int currentState = MENU;
	Font titleFont;

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 24);
		Timer frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 78, 100);

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press Enter to Start", 78, 400);

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press Space for Instructions", 78, 700);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		ship.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 78, 100);
		g.drawString("You killed  enemies", 78, 400);
		g.drawString("Press Enter to restart", 78, 700);

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {
		//call to thw object managers update mehtod
	}

	void updateEndState() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
 
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");

			ship.down();
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			ship.up();
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");

			ship.left();
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			ship.right();
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}


