package com.Wave.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class BossBullet extends GameObject {

	Handler handler;
	Random rand = new Random();
		
	public BossBullet(int x, int y, ID id , Handler handler) {
		super(x, y, id);
		
		xVel = (rand.nextInt(5 - -5) + -5);
		yVel = 5;
		
		this.handler = handler;
		
	}

	@Override
	public void tick() {
		
		x += xVel;
		y += yVel;
		
		//if (x <= 0 || x >= Screen.width - 32) xVel *= -1;
		//if (y <= 0 || y >= Screen.height - 72) yVel *= -1;
		
		
		
		handler.addObject(new Trail(x, y, ID.Effects, Color.red, handler, 16, 16, 0.09f , 1.0f));
		if (y >= Screen.height){
			handler.removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
			
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
		
	    
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y , 16, 16);
	}

}

