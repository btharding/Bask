import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -1930825029999864569L;
	
	public static final int WIDTH_BORDER = 14;
	public static final int HEIGHT_BORDER = 37;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final String TITLE = "SHARKY";
	
	private Thread thread;
	private boolean running = false;
	
	public static Handler handler = new Handler();
	public static Player player = new Player(100, (HEIGHT/2)-32);
	public static Spawner spawner = new Spawner();
	public static Random rand = new Random();
	public static GUI gui  = new GUI();
	
	public static GameState state;
	public static Menu menu;

	public static void main(String[] args){
		new Game();		
	}	
	
	public Game() {
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH+WIDTH_BORDER, HEIGHT+HEIGHT_BORDER, TITLE, this);
		state = GameState.StartMenu;
		menu = new Menu();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		this.requestFocus();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
				frames ++;
			
				if(System.currentTimeMillis() - timer >1000) {
					timer += 1000;
					frames = 0;
				}
			}
		}
		stop();
	}
	
	private void tick() {
		if(state == GameState.StartMenu) {
			
		}else if(state == GameState.Playing) {
			handler.tick();
			spawner.tick();
		}

	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0,90,126));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		if(state != GameState.Playing) {
			menu.render(g);
		}else{
			handler.render(g);
			player.render(g);
			gui.render(g);
		}

		
		g.dispose();
		bs.show();
	}


}
