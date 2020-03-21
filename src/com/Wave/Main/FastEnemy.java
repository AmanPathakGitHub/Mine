package com.Wave.Main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

	Handler handler;
		
	public FastEnemy(int x, int y, ID id , Handler handler) {
		super(x, y, id);
		
		xVel = 2;
		yVel = 8;
		
		this.handler = handler;
		
	}

	@Override
	public void tick() {
		
		x += xVel;
		y += yVel;
		
		if (x <= 0 || x >= Screen.width - 32) xVel *= -1;
		if (y <= 0 || y >= Screen.height - 72) yVel *= -1;
		
		
		handler.addObject(new Trail(x, y, ID.Effects, Color.CYAN, handler, 32, 32, 0.09f , 1.0f));
	}

	@Override
	public void render(Graphics g) {
			
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 32, 32);
		
	    
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y , 32, 32);
	}

}
