package com.Wave.Main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {

	private Handler handler;
	private float alpha;
	private int width, height;
	float life;
	private Color color;
	
	// life = 0.1 - 0.001
	
	public Trail(int x, int y, ID id, Color color,  Handler handler, int width, int height, float life, float alpha ) {
		super(x, y, id);
		
		this.handler = handler;
		this.height = height;
		this.width = width;
		this.life = life;
		this.color = color;
		this.alpha = alpha;
	}


	public void tick() {
		
		if (alpha > life){
			alpha -= (life - 0.001f);
			
			
		}else {
			handler.removeObject(this);
		}
		
	}


	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha){
		
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
