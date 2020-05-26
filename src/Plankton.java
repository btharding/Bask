import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Plankton extends GameObject{
	private int direction;
	public static int spawnRate = 30;
	private static BufferedImage sprite = null;
	public static int upgradeTimer = 3000;
	
	public Plankton() {
		super(Game.WIDTH,  Game.rand.nextInt(Game.HEIGHT - Game.HEIGHT_BORDER-20)+20, ID.Plankton, 32, 32);
		if(sprite == null) {
			try {
				sprite = ImageIO.read( new File("./img/Plankton.png"));
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error in loading plankton.png");
			}
		}		
		velX = -7;
		if(Game.rand.nextInt(2) == 0) {
			this.direction = 1;
		}else {
			this.direction = -1;
		}
	}

	@Override
	public void tick() {
		x+=velX;
		y+=Math.sin(direction * 0.01*x);
		if(upgradeTimer <3000) {
			spawnRate = 5;
			upgradeTimer++;
		}else {
			spawnRate = 30;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, null);		
	}

}
