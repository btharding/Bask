import java.awt.Graphics;
import java.util.LinkedList;

public class Handler{
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i = 0; i< objects.size(); i++) {
			GameObject object = objects.get(i);
			object.tick();
			if(object.getX()<-30) {
				objects.remove(object);
			}
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i< objects.size(); i++) {
				GameObject object = objects.get(i);
			if(object.getId()!=ID.Player) {
				object.render(g);
			}
		}		
	}
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
}
