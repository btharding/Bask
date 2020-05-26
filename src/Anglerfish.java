import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Anglerfish extends GameObject{
	
	private static BufferedImage sprite = null;

	public Anglerfish() {
		super(Game.WIDTH, Game.rand.nextInt(Game.HEIGHT - Game.HEIGHT_BORDER-20)+20, ID.Anglerfish, 64, 32);
		if(sprite == null) {
			try {
				sprite = ImageIO.read( new File("./img/Anglerfish.png"));
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error in loading anglerfish.png");
			}
		}
	}

	@Override
	public void tick() {
		x -= 5;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, null);
	}

}
