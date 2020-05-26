import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bubble extends GameObject{
	private Color color;
	public Bubble() {
		super(Game.WIDTH,  Game.rand.nextInt(Game.HEIGHT - Game.HEIGHT_BORDER-20)+20, ID.Bubble, Game.rand.nextInt(20)+2, 0);
		this.velX = -(Game.rand.nextInt(5)+5);
		this.velY = Game.rand.nextInt(6)-3;
		this.color = new Color(0,0,Game.rand.nextInt(155)+100,75);
	}
	@Override
	public void tick() {
		x += velX;
		y += velY;
	}
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.fillOval(x, y, width/2, width/2);
	}

}
