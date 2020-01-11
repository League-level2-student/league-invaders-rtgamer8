import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 78, 100);
	
		g.setFont(Enter);
		g.setColor(Color.YELLOW);
		g.drawString("Press Enter to Start", 78, 400);
	
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
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
	}

	void updateEndState() {
		
	}

 
}	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
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
		
		

		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		    if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		        System.out.println("DOWN");
		    }
		    
		    
		    
		    if (e.getKeyCode()==KeyEvent.VK_UP) {
		        System.out.println("UP");
		    }
		    
		    
		    if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		        System.out.println("LEFT");
		    }
		    
		    
		    if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		        System.out.println("RIGHT");
		    }
		    
		    
		    
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
}



