import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Menu {
	
	private static HashMap<GameState, File> displayOptions = new HashMap<>();
	
	public Menu() {
		displayOptions.put(GameState.StartMenu,new File("./img/Start.png"));
		displayOptions.put(GameState.Instructions, new File("./img/Instructions.png"));
		displayOptions.put(GameState.Paused, new File("./img/Pause.png"));
		displayOptions.put(GameState.Dead, new File("./img/Dead.png"));
	}
	
	public void render(Graphics g) {
		File temp = displayOptions.get(Game.state);
		try {
			g.drawImage(ImageIO.read(temp), 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(Game.state == GameState.Paused) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 35));
			g.drawString(""+Game.player.getScore(), 300, 227);
			g.drawString(""+Game.player.getHealth(), 300, 273);
		}else if(Game.state == GameState.Dead) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 45));
			g.drawString(""+Game.player.getScore(), 360, 215);
		}
	}
	
}
