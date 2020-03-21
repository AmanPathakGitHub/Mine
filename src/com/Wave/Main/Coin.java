package com.Wave.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coin extends GameObject{

	Handler handler;
	public Coin(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempobject = handler.object.get(i);
			
		if (tempobject.getId() == ID.Player){
			if (getBounds().intersects(tempobject.getBounds())){
				
				HUD.score += 1000;
				handler.removeObject(this);
				
			}
		}
	}
		
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		//g.drawRect(x, y, 16, 16);
		g.fillRoundRect(x, y, 16, 16, 16, 16);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y , 16, 16);
	}

}
