package com.Wave.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BetterEnemy extends GameObject {

	Handler handler;
	public BetterEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
	}

	@Override
	public void tick() {
		
		x += xVel;
		y += yVel;
		
		
		if (Player.x > x){
			setxVel(1);
		}
		else if (Player.x < x){
			setxVel(-1);
		}else {
			setxVel(0);
		}
		if (Player.y > y){
			setyVel(1);
		} 
		else if (Player.y < y){
			setyVel(-1);
		}else {
			setyVel(0);
		}
		handler.addObject(new Trail(x, y, ID.Effects, Color.yellow, handler, 16, 16, 0.05f , 1.0f));
	}

	@Override
	public void render(Graphics g) {
		
		
		g.setColor(Color.yellow);
		g.fillRect(x, y, 16, 16);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y , 16, 16);
	}

}
