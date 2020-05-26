import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Jellyfish extends GameObject{
	private int direction;
	private static BufferedImage sprite = null;
		
	public Jellyfish() {
		super(Game.WIDTH, Game.rand.nextInt(Game.HEIGHT - Game.HEIGHT_BORDER-20)+20,ID.Jellyfish, 32, 32);
		if(sprite == null) {
			try {
				sprite = ImageIO.read(new File("./img/Jellyfish.png"));
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error in loading shark.png");
			}
		}		
		this.velX = -5;
		if(Game.rand.nextInt(2) == 0) {
			this.direction = 1;
		}else {
			this.direction = -1;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x+6,y,19,32);
	}

	@Override
	public void tick() {
		x+=velX;
		y+=Math.sin(direction * 0.01*x);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, null);
	}

}
