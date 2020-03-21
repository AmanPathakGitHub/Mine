package com.Wave.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.Wave.Main.Game.STATE;


public class Boss extends GameObject {

	Handler handler;
	int spawn;
	Random rand = new Random();
	private int timer = 30;
	private int timer2 = 50;
	static int BossHP = 100;
	int timer3 = 100;
	int timer4 = 30;
	int green = 255;
	int red = 255;
	Color col;
	Game game;
		
	public Boss(int x, int y, ID id , Handler handler,Game game) {
		super(x, y, id);
		
		xVel = 0;
		yVel = 3;
		
		this.handler = handler;
		this.game = game;
		
	}

	@Override
	public void tick() {

		col = new Color(red,0,green);
		
		
		x += xVel;
		y += yVel;
		spawn = rand.nextInt(10);
		collision();
		BossHP = Game.clamp(BossHP, 0, 100);
		
		//int timer5 = 60;
		
		if (BossHP == 0){
			spawn = 1;
			setX(330);
			setY(y);
			setyVel(0);
			setxVel(0);
			timer3--;
						
			if (timer3 == 0){
								
				handler.removeObject(this);
				game.gameState = STATE.Win;
				
				
				
			}
		}
		
		if (timer <= 0){
			setyVel(0);
			
		}else{
			timer--;
		}
		if (timer <= 0){
			timer2--;
		}
		if (timer2 <= 0){
			if (xVel == 0){
				setxVel(10);
				
			}
			
			if (spawn == 0)
			handler.addObject(new BossBullet(x, y, ID.Enemy, handler));
		}
		
		
		if (x <= 0 || x >= Screen.width - 60) xVel *= -1;
		//if (y <= 0 || y >= Screen.height - 72) yVel *= -1;
		collision();
		
		
		
		handler.addObject(new Trail(x, y, ID.Effects, Color.MAGENTA, handler, 64, 64, 0.05f , 1.0f));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(450, 15, 200, 32);
		g.setColor(col);
		
		g.fillRect(450, 15, BossHP * 2, 32);
		g.fillRect(x, y, 64, 64);
		g.setColor(Color.GRAY);
		g.drawRect(450, 15, 200, 32);
		if (BossHP == 0){
			for (int i = 0; i < timer; i++){
				
				
				
			}
		}
	    
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y , 64, 64);
	}
	public void collision(){
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempobject = handler.object.get(i);
			
			if (tempobject.getId() == ID.Player){
				if (getBounds().intersects(tempobject.getBounds())){
					//Collision code
					HUD.HEALTH = 0;
				} 
				if (tempobject.getId() == ID.Boss){
					if (getBounds().intersects(tempobject.getBounds())){
						//Collision code
						Boss.BossHP -= 35;
						//handler.removeObject(this);
					} 
				}
				
			
			}
			
		 }
		}
}
