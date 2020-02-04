import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship ship;
ArrayList projectiles = new ArrayList();
ArrayList aliens = new ArrayList();
Random random = new Random();
ObjectManager(Rocketship rocket){
	
ship = rocket;

}

void addProjectile(){
		
}


void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}

void update(){
	
	
	
}

void draw() {
	
}

void purgeObjects() {
	
}

	}
	
	
	
	
	
                                                                                                                                  