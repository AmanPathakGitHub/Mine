package com.Wave.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PlayerBullet extends GameObject {

	Handler handler;
	Random rand = new Random();
		
	public PlayerBullet(int x, int y, ID id , Handler handler) {
		super(x, y, id);
		
		xVel = 0;
		yVel = -5;
		
		this.handler = handler;
		
	}

	@Override
	public void tick() {
		
		x += xVel;
		y += yVel;
		
		if (xVel == 0){
			xVel++;
		}else if (yVel == 0){
			yVel++;
		
		}
		
		if (x <= 0 || x >= Screen.width - 32) xVel *= -1;
		if (y <= 0 || y >= Screen.height - 60) yVel *= -1;
				
		
		
		collision();
		collision2();
		
		
		handler.addObject(new Trail(x, y, ID.Effects, Color.green, handler, 16, 16, 0.09f , 1.0f));
	}

	@Override
	public void render(Graphics g) {
			
		g.setColor(Color.green);
		g.fillRect(x, y, 16, 16);
		
	    
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y , 16, 16);
	}
	
	public void collision(){
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempobject = handler.object.get(i);
			
			if (tempobject.getId() == ID.Enemy){
				if (getBounds().intersects(tempobject.getBounds())){
					//Collision code
					handler.removeObject(tempobject);
					handler.removeObject(this);
					
				
				
				}
			}
			
		 }
		}
	
	public void collision2(){
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempobject = handler.object.get(i);
			
			if (tempobject.getId() == ID.Boss){
				if (getBounds().intersects(tempobject.getBounds())){
					//Collision code
					Boss.BossHP -= 32;
					handler.removeObject(this);
					
				
				
				}
			}
			
		 }
		}


}
