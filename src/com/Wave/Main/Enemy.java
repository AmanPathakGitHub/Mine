package com.Wave.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Enemy extends GameObject {

	Handler handler;
		
	public Enemy(int x, int y, ID id , Handler handler) {
		super(x, y, id);
		
		xVel = -3;
		yVel = 3;
		
		this.handler = handler;
		
	}

	@Override
	public void tick() {
		
		x += xVel;
		y += yVel;
		
		if (x <= 0 || x >= Screen.width - 32) xVel *= -1;
		if (y <= 0 || y >= Screen.height - 72) yVel *= -1;
		
		
		handler.addObject(new Trail(x, y, ID.Effects, Color.red, handler, 32, 32, 0.09f , 1.0f));
	}

	@Override
	public void render(Graphics g) {
			
		g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);
		
	    
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y , 32, 32);
	}

}
