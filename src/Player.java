import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Player extends GameObject{
	private int score = 0;
	private int health = 100;
	private float rotation = 0;
	private static BufferedImage sprite;

	public Player(int x, int y){		
		super(x, y, ID.Player, 192, 64);
		try {
			sprite = ImageIO.read(new File("./img/Shark.png"));;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in loading shark.png");
		}
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x+135, y+20, 30, 44);
	}

	public void tick(){
		if(this.health <= 0) {
			Game.state = GameState.Dead;
		}
		if((this.y + this.velY)>0 && (this.y + this.velY)<(Game.HEIGHT - this.height +2)) {
			this.y += this.velY;
		}
		checkCollisions();
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(Math.toRadians(rotation), x+160, y+42);
		g2d.drawImage(sprite, x, y, null);
		g2d.rotate(Math.toRadians(-rotation), x+160, y+42);
	}
	
	public void checkCollisions() {
		for(int i = 0; i< Game.handler.objects.size(); i++) {
			GameObject object = Game.handler.objects.get(i);
			if(object.getId()!=ID.Player) {
				if(object.getBounds().intersects(this.getBounds())) {
					if(object.getId() == ID.Plankton) {
						Game.handler.objects.remove(object);
						this.score ++;
					}
					if(object.getId() == ID.Jellyfish) {
						Game.handler.objects.remove(object);
						this.health-=5;
					}
					if(object.getId() == ID.Orca) {
						Game.handler.objects.remove(object);
						this.health -= 20;
					}
					if(object.getId() == ID.Anglerfish) {
						Game.handler.objects.remove(object);
						Plankton.upgradeTimer = 0;
					}
				}
			}
		}
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getRotation() {
		return rotation;
	}
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
}
