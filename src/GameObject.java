import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public abstract class GameObject{

	protected int x, y, width, height;
	protected ID id;
	protected float velX, velY;
	protected BufferedImage sprite = null;
	
	public GameObject(int x, int y, ID id, int width, int height) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		Game.handler.addObject(this);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	public ID getId(){
		return id;
	}
	public void setId(ID id){
		this.id = id;
	}
	public float getVelX(){
		return velX;
	}
	public void setVelX(float velX){
		this.velX = velX;
	}
	public float getVelY(){
		return velY;
	}
	public void setVelY(float velY){
		this.velY = velY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
