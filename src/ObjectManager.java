import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObjectManager implements ActionListener
 {
	Rocketship ship;
	ArrayList<projectile> projectiles = new ArrayList<projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;

	ObjectManager(Rocketship rocket) {

		ship = rocket;

	}

	void addProjectile(projectile p) {
projectiles.add(p);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {

		for (int i = 0; i < aliens.size(); i++) {

			aliens.get(i).update();

		}

		for (int i = 0; i < projectiles.size(); i++) {

			projectiles.get(i).update();

		}

		
		
		checkCollision();
		purgeObjects();
		
		
	}

	void draw(Graphics g) {

		for (int i = 0; i < aliens.size(); i++) {

			aliens.get(i).draw(g);

		}

		for (int i = 0; i < projectiles.size(); i++) {

			projectiles.get(i).draw(g);

		}

	}

	void purgeObjects() {

		for (int i = projectiles.size() - 1; i >= 0; i--) {

			if (projectiles.get(i).isActive == false) {

				projectiles.remove(i);

			}

		}

		for (int i = 0; i < aliens.size(); i++) {

			if (aliens.get(i).isActive == false) {

				aliens.remove(i);
			}

		}

	}

void checkCollision() {
	for (int i = 0; i < aliens.size(); i++) {
		
		for (int j = 0; j < projectiles.size(); j++) {
			
	if(aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)){
		aliens.get(i).isActive=false;
		projectiles.get(j).isActive=false;
	}
		}
		
		if (ship.collisionBox.intersects(aliens.get(i).collisionBox)) {
			
			ship.isActive=false;
	}
	
	
	
		
	}
	
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
		System.out.println(aliens.size());
	}
}


