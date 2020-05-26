import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Orca extends GameObject{
	
	private float rotation;
	private static BufferedImage sprite = null;

	public Orca() {
		super(Game.WIDTH, Game.rand.nextInt(Game.HEIGHT - Game.HEIGHT_BORDER-20)+20, ID.Orca, 64, 32);
		if(sprite == null) {
			try {
				sprite = ImageIO.read(new File("./img/Orca.png"));;
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error in loading orca.png");
			}
		}
		this.velX = (Game.player.getX()+150 - this.x)/30;
		this.velY = (Game.player.getY()+44 - this.y)/30;
		this.rotation = (float) Math.atan(this.velY/this.velX);
	}
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.rotate(rotation, x+64, y+32);
		g2d.drawImage(sprite, x, y, null);
		g2d.rotate(-rotation, x+64, y+32);
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
	}

}
