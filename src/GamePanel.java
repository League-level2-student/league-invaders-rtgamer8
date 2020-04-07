import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Timer alienspawn;
	Rocketship ship = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(ship);
	int currentState = MENU;
	Font titleFont;

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 24);
		Timer frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

		loadImage("wallpaper.png");

	}

	void startGame() {

		alienspawn = new Timer(1000, manager);
		alienspawn.start();

	}

	void endgame() {

		alienspawn.stop();
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
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		}
		
		ship.draw(g);
		manager.draw(g);
		g.setFont(titleFont);
		g.setColor(Color.GREEN);
		g.drawString(manager.getscore()+ "", 78, 700);
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
		manager.update();
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
				endgame();
				
				currentState = MENU;
			} else {
				currentState++;
		

			}
			if (currentState == GAME) {
				ship= new Rocketship(250, 700, 50, 50);
				manager = new ObjectManager(ship);
				startGame();
			
			}

		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == GAME) {
			manager.addProjectile(ship.getProjectile());
			System.out.println("space" + currentState);
		}
		
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
