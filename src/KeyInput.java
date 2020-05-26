import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if(Game.state == GameState.StartMenu) {

		}else if(Game.state == GameState.Playing) {
			if(key == KeyEvent.VK_UP) {
				Game.player.setVelY(-5);
				Game.player.setRotation(-10);
			}
			if(key == KeyEvent.VK_DOWN) {
				Game.player.setVelY(5);
				Game.player.setRotation(10);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);

		}

		if(Game.state == GameState.StartMenu) {
			if(key == KeyEvent.VK_ENTER) {
				Game.state = GameState.Playing;
			}else if(key == KeyEvent.VK_I) {
				Game.state = GameState.Instructions;
			}
		}else if(Game.state == GameState.Instructions) {
			if(key == KeyEvent.VK_SPACE) {
				Game.state = GameState.StartMenu;
			}
		}else if(Game.state == GameState.Paused) {
			if(key == KeyEvent.VK_SPACE) {
				Game.state = GameState.Playing;
			}
		}else if(Game.state == GameState.Dead) {
			if(key == KeyEvent.VK_SPACE) {
				Game.state = GameState.StartMenu;
				Game.player.setHealth(100);
				Game.player.setScore(0);
				Game.player.setY((Game.HEIGHT/2)-32);
				Game.spawner.setTimer(0);
				for(int i = 0; i<Game.handler.objects.size(); i++) {
					if(Game.handler.objects.get(i).getId()!=ID.Player) {
						Game.handler.objects.remove(Game.handler.objects.get(i));
					}
				}
			}
		}else{
			if(key == KeyEvent.VK_SPACE) {
				Game.state = GameState.Paused;
			}
			if(key == KeyEvent.VK_UP) {
				Game.player.setVelY(0);
				Game.player.setRotation(0);
			}
			if(key == KeyEvent.VK_DOWN) {
				Game.player.setVelY(0);
				Game.player.setRotation(0);
			}

		}
	}

}

