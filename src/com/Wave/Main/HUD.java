package com.Wave.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Thread.State;
import java.util.Random;

import javax.swing.JLabel;

import com.Wave.Main.Game.STATE;

public class HUD {

	public static int HEALTH = 100;
	Color healthColor = Color.GREEN;
	Random rand = new Random();
	
	static int score = 0;
	static int level = 1;
	
	static boolean GameOver = false;
	
	private Game game;
	private Handler handler;
	
	public HUD(Game game, Handler handler) {
		
		this.game = game;
		this.handler = handler;
		
	}
	
	public void tick(){
		
				
		HEALTH = Game.clamp(HEALTH, 0, 100);
		if (HEALTH == 0){
			GameOver = true;
			game.gameState = STATE.GameOver;
			
			for (int i = 0; i < handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				handler.clearEnemy();
				handler.removeObject(tempObject);
				HEALTH = 100;
				
			}
			if (game.gameState == STATE.GameOver){
				for(int i = 0; i < 10; i++){                                                                                                          
					handler.addObject(new MenuParticle(rand.nextInt(Screen.width - 32), rand.nextInt(Screen.height - 72), ID.Effects, handler, game));
					                                                                                                                                  
				}
			}
			   
			
			
						
		}else if(HEALTH <= 25){
			healthColor = Color.red;
		}else if (HEALTH <= 50){
			healthColor = Color.yellow;
		}else{
			healthColor = Color.green;
		}
		
		
		if (game.gameState == STATE.Game){
			score++;
		}else if (game.gameState == STATE.Menu){
			score = 0;
		}
		
		
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		HUD.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		HUD.level = level;
	}

	public void render(Graphics g){
		
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(healthColor);
		g.fillRect(15, 15, HEALTH * 2 , 32 );
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
		g.drawString("FPS: " + Game.frames, 15, 100);
		g.drawString("Bullets: " + Player.bullets , 15, 120);
		g.drawString("Press shift to open shop", 15, 140);
		
		
	}
}
