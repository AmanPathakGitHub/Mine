package com.Wave.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.Wave.Main.Game.STATE;

public class Help extends MouseAdapter{

	private Game game;
	
	public Help(Game game) {
		
		this.game = game;
	}
	
	public void render(Graphics g){
		
		Font fnt = new Font("fnt" , Font.ITALIC , 30);
		Font fnt2;
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Help", 320, 50);
		
		
		g.drawString("How to Play:", 25, 100);
		fnt2 = new Font("Fnt2", Font.ITALIC, 25);
		g.setFont(fnt2);
		g.drawString("-Dodge ememies to get as many points as possible.", 25, 125);
		g.drawString("-Do not die", 25, 150);
		g.drawString("-Grab blue orbs to heal yourself", 25, 175);
		
		
		g.setFont(fnt);
		g.drawString("Controls:", 25, 225);
		
		g.setFont(fnt2);
		g.drawString("-Use WASD to move", 25, 250);
		g.drawString("-Use P to pause", 25, 275);

		
		g.setFont(fnt);
		g.drawString("Enemies", 25, 310);
		g.setFont(fnt2);
		g.setColor(Color.red);
		g.fillRect(25, 325, 32, 32);
		g.drawString("Bounces around screen", 75, 350);
		g.setColor(Color.yellow);
		g.fillRect(25, 370, 16, 16);
		g.drawString("Follows you", 75, 390);
		g.setColor(Color.cyan);
		g.fillRect(25, 400, 32, 32);
		g.drawString("Goes up and down REALLY fast", 75, 425);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Orb", 490, 300);
		g.setColor(Color.blue);
		g.fillRoundRect(495, 325, 16, 16, 16, 16);
		
		
		g.setColor(Color.green);
		g.fillRect(530, 375, 120, 64);
		g.setColor(Color.white);
		g.drawRect(530, 375, 120, 64);
		
		g.setColor(Color.black);
		g.drawString("Back", 555, 418);
		

		
	}
	
	public void tick(){
		
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		
		if (game.gameState == STATE.Help){
			if (mouseOver(mx, my, 530, 375, 120, 64)){
				game.gameState = STATE.Menu;
				
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){

		if (mx > x && mx < x + width){
			if (my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
		
	}
}
