import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
public class ObjectManager {
Rocketship ship;
ArrayList<projectile>projectiles = new ArrayList<projectile>();
ArrayList <Alien>aliens = new ArrayList<Alien>();
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
	
	for (int i = 0; i < aliens.size(); i++) {
		
		 aliens.get(i).update();
		
		
	}

	for (int i = 0; i < projectiles.size(); i++) {
		
		
		projectiles.get(i).update();

		
	}

}

void draw(Graphics g){
	
	for (int i = 0; i < aliens.size(); i++) {

		aliens.get(i).draw(g);
		
		
	}
	
	for (int i =0; i < projectiles.size(); i++){
		
		
		
   projectiles.get(i).draw(g);
		
	}
	
	
}





void purgeObjects() {
	
	for (int i = 0; i < projectiles.size(); i++) {
		
		
		
		
		
	}
	
	
	for (int i =0; i < aliens.size(); i++) {
		
		
	}
	
}



}
	

	
                                                                                                                                  