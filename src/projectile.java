import java.awt.Color;
import java.awt.Graphics;

public class projectile extends GameObject {

	projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		int speed = 1;
		super.speed = 10;
	}

	void update() {

		y -= speed;
	}

	void draw() {
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
