package com.Wave.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;
import java.util.Random;

import com.Wave.Main.Game.STATE;

public class Menu extends MouseAdapter {
	
	Game game;
	Handler handler;
	Random rand = new Random();
	
	public Menu(Game game, Handler handler) {
		// TODO Auto-generated constructor stub
		this.game = game;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		if (game.gameState == STATE.Menu){
			//play
			if (mouseOver(mx, my, 300, 200, 100, 64)){
				HUD.level = 1;
				HUD.score = 0;
				handler.clearEnemy();
				game.gameState = STATE.Game;
				handler.addObject(Game.player);
				HUD.GameOver = false;
				
				handler.addObject(new Enemy(rand.nextInt(Screen.width - 32),rand.nextInt(Screen.height - 72), ID.Enemy ,handler));
			}
			//help
			if (mouseOver(mx, my, 100, 250, 200, 100)){
				game.gameState = STATE.Help;
			}
			
			if (mouseOver(mx, my, 500, 250, 100, 64)){
				System.exit(0);
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
	public void render(Graphics g){
		
		g.setFont(new Font(null, Font.BOLD , 75));
		g.setColor(Color.red);
		g.drawString("WAVE", 230, 100);
		
		g.setColor(Color.blue);
		g.fillRect(300, 200, 100, 64);
		g.setColor(Color.white);
		g.drawRect(300, 200, 100, 64);
		g.setColor(Color.black);
		Font fnt = new Font("fnt", Font.BOLD, 45);
		g.setFont(fnt);
		g.drawString("Play", 305, 250);
		
		
		g.setColor(Color.green);
		g.fillRect(100, 250, 100, 64);
		g.setColor(Color.white);
		g.drawRect(100, 250, 100, 64);
		g.setColor(Color.black);
		g.drawString("Help", 103, 300);
		
		g.setColor(Color.green);
		g.fillRect(500, 250, 100, 64);
		g.setColor(Color.white);
		g.drawRect(500, 250, 100, 64);
		g.setColor(Color.black);
		g.drawString("Quit", 505, 300);
		
		g.setColor(Color.ORANGE);
		g.fillRect(550, 50, 130, 64);
		g.setColor(Color.white);
		g.drawRect(550, 50, 130, 64);
		g.setColor(Color.black);
		g.drawString("Score", 555, 100);
		
		
	}
	
	public void tick (){
		
	}
}
