import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	super.speed=1;

	}

	void update() {

	}


	//	g.fillRect(x, y, width, height);
	void draw(Graphics g) {
	        g.fillRect(x, y, width, height);
	}


}
