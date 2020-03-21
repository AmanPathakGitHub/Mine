
package com.Wave.Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x , y;
	protected ID id;
	protected int xVel , yVel;

	
	 public GameObject(int x, int y , ID id) {
		
		 this.x = x;
		 this.y = y;
		 this.id = id;
	}
	
	 

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	
}
