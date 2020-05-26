import java.awt.Color;
import java.awt.Graphics;

public class GUI {
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawString("Score : " + Game.player.getScore(), 10, 20);
		g.drawString("Health: ", 10, 38);
		g.fillRect(55, 29, 100, 10);
		g.setColor(Color.GREEN);
		g.fillRect(55, 29, Game.player.getHealth(), 10);
		g.setColor(Color.WHITE);
		g.drawRect(55, 29, 100, 10);
	}
	
}
