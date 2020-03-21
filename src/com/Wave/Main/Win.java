package com.Wave.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.Wave.Main.Game.STATE;

public class Win extends MouseAdapter {
	Random rand = new Random();
	Color col;
	Game game;
	Handler handler;
	public Win(Handler handler , Game game) {
		this.handler = handler;
		this.game = game;
	}
	
	public void tick(){
		col = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
	}
	
	public void render(Graphics g){
		
		g.setFont(new Font(null, Font.BOLD, 75));
		g.setColor(Color.green);
		g.drawString("YOU WIN", 187, 200);
		g.fillRect(270, 250, 155, 64);
		g.setColor(col);
		g.setFont(new Font(null, Font.BOLD, 50));
		g.drawRect(270, 250, 155, 64);
		g.drawString("Finish", 275, 300);
	}
	
	private boolean mouseOver(int mx,int my, int x, int y, int width, int height){
		
		if (mx > x && mx < x + width){
			if (my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
		
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		
		if (mouseOver(mx, my, 270, 250, 155, 64)){
			System.exit(0);
		}
	}
}

