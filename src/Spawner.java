
public class Spawner {
	
	private int timer;
	
	public Spawner() {
		this.timer = 0;
	}
	
	public void tick() {
		timer++;
		if(timer % 2 == 0){
			new Bubble();
		}
		if(timer % Plankton.spawnRate == 0) {
			new Plankton();
		}
		if(timer % 75 == 0) {
			new Jellyfish();
		}
		if(timer % 200== 0) {
			new Orca();
		}
		if(timer % 1000 == 0) {
			new Anglerfish();
		}
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
}
