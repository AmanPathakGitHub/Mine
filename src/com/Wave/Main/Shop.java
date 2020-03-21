package com.Wave.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.Wave.Main.Game.STATE;

public class Shop extends MouseAdapter {
	
	private Game game;
	private int Box1 = 1500;
	private int Box2 = 2000;
	private int Box3 = 300;
	
	private boolean fullhealth;
	
	public Shop(Game game) {
		
		this.game = game;
		fullhealth = true;
		
	}
	
	public void render(Graphics g){
		
		g.setColor(Color.WHITE);
		g.drawString("Your Score: " + HUD.score, 50, 50);
		g.setFont(new Font(null , Font.ITALIC , 40));
		g.drawString("Shop",  275, 50);
		
		if(fullhealth == true){
			g.drawString("You have full health", 150, 300);
		}
		
		
		//box 1
		g.setColor(Color.BLUE);
		g.setFont(new Font(null, 0, 20));
		g.drawRect(50, 100, 150, 150);
		g.drawString("Speed boost", 50, 120);
		g.drawString("Cost: " + Box1  , 50, 140);
		
		//box 2
		g.setColor(Color.red);
		g.setFont(new Font(null, 0, 20));
		g.drawRect(250, 100, 150, 150);
		g.drawString("Health Refill", 250, 120);
		g.drawString("Cost: " + Box2  , 250, 140);
		
		//box 3
		g.setColor(Color.green);
		g.setFont(new Font(null, 0, 20));
		g.drawRect(450, 100, 150, 150);
		g.drawString("Bullet", 450, 120);
		g.drawString("Cost: " + Box3  , 450, 140);
		
	}
	
	public void tick(){
		
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		
		if (game.gameState == STATE.Shop){
			//box 1
			if (mouseOver(mx, my, 50, 100, 150, 150)){
				if(HUD.score >= Box1){
					Player.speed += 2;
					HUD.score -= Box1;
				}
				fullhealth = false;

				
				//box 2
			}else if (mouseOver(mx, my, 250, 100, 150, 150)){
				if (HUD.score >= Box2 && HUD.HEALTH != 100){
					HUD.HEALTH = 100;
					HUD.score -= Box2;
				}else if (HUD.HEALTH == 100){
					fullhealth = true;
				}
				
				//box 3
			}else if (mouseOver(mx, my, 450, 100, 150, 150)){
				if (HUD.score >= Box3){
					Player.bullets += 1;
					HUD.score -= Box3;
				}
				fullhealth = false;

			}
		}
	
}
	
	public void mouseReleased(MouseEvent e){
		
	}
	private boolean mouseOver(int mx,int my, int x, int y, int width, int height){
		
		if (mx > x && mx < x + width){
			if (my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
		
	}
}
