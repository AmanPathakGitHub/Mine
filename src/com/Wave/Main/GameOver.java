package com.Wave.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.Wave.Main.Game.STATE;

public class GameOver extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private Random rand = new Random();
	public GameOver(Game game , Handler handler) {
		this.game = game;
		this.handler = handler;
		
		 
	}
	
	public void render (Graphics g){
		
		                                                                                                                                 
		
		Font fnt = new Font(null, Font.BOLD, 40);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Your score is: " + HUD.score, 147, 375);
		g.setColor(Color.red);
		fnt = new Font(null, Font.BOLD, 75);
		g.setFont(fnt);
		g.drawString("GameOver", 150, 200);
		g.setColor(Color.red);
		g.fillRect(100, 250, 120, 64);
		g.fillRect(450, 250, 120, 64);
		fnt = new Font(null, Font.BOLD, 30);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Restart", 105, 295);
		g.drawString("Menu", 470, 295);
		g.drawRect(100, 250, 120, 64);
		g.drawRect(450, 250, 120, 64);
		
		
	}
	
	public void tick(){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if (mx > x && mx < x + width){
			if (my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}
	
	public void mousePressed(MouseEvent e){
		
		
		
		
	}
	
	public void mouseReleased(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		if (game.gameState == STATE.GameOver){
			//restart
			if (mouseOver(mx, my, 100, 250, 120, 64)){
				handler.clearEnemy();
				HUD.level = 1;
				HUD.score = 0;
				HUD.HEALTH = 100;
				game.gameState = STATE.Game;
				handler.addObject(Game.player);
				HUD.GameOver = false;
				
				handler.addObject(new Enemy(rand.nextInt(Screen.width - 32),rand.nextInt(Screen.height - 72), ID.Enemy ,handler));
				
			
				
				//Menu
			}else if (mouseOver(mx, my, 450, 250, 120, 64)){
				handler.clearEnemy();
				game.gameState = STATE.Menu;
				for(int i = 0; i < 10; i++){                                                                                                    
					handler.addObject(new MenuParticle(rand.nextInt(Screen.width - 32), rand.nextInt(Screen.height - 72), ID.Effects, handler, game));
					                                                                                                                            
				}                                                                                                                               
			}
		}
	}
}
