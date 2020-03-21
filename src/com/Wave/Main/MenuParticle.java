package com.Wave.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.Wave.Main.Game.STATE;


public class MenuParticle extends GameObject {

	Handler handler;
	
	Random rand = new Random();
	Color col = new Color(rand.nextInt(255) ,rand.nextInt(255), rand.nextInt(255));
	private Game game;
		
	public MenuParticle(int x, int y, ID id , Handler handler, Game game) {
		super(x, y, id);
		
		xVel = (rand.nextInt(7 - -7) + -7);
		yVel = (rand.nextInt(7 - -7) + -7);
		
		if (xVel == 0) xVel = 2;
		if (yVel == 0)yVel = 2;
		
		
		this.handler = handler;
		this.game = game;
		
	}

	@Override
	public void tick() {
		
		x += xVel;
		y += yVel;
		
		if (x <= 0 || x >= Screen.width - 32) xVel *= -1;
		if (y <= 0 || y >= Screen.height - 72) yVel *= -1;
		
		if (game.gameState == STATE.GameOver){
			col = Color.red;
		}else if (game.gameState == STATE.Win){
			col = Color.green;
		}
		
		
		handler.addObject(new Trail(x, y, ID.Effects, col, handler, 32, 32, 0.09f , 1.0f));
	}

	@Override
	public void render(Graphics g) {
			
		g.setColor(col);
		g.fillRect(x, y, 32, 32);
		
	    
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y , 32, 32);
	}

}
