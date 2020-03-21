package com.Wave.Main;

import java.util.Random;

public class Spawn {

	Handler handler;
	HUD hud;
	Random rand = new Random();
	Game game;
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud ,Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		
	}
	
	public void tick(){
		
		if (!HUD.GameOver){
			scoreKeep++;
		}else {
			scoreKeep = 0;
		}
		
		
		if (scoreKeep >= 500){
			
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if (hud.getLevel() == 2){
				handler.addObject(new Enemy(rand.nextInt(Screen.width - 32),rand.nextInt(Screen.height - 72), ID.Enemy ,handler));				

			}else if (hud.getLevel() == 3){
				handler.addObject(new BetterEnemy(rand.nextInt(Screen.width - 32),rand.nextInt(Screen.height - 72),ID.Enemy , handler));

			}else if (hud.getLevel() == 4){
				handler.addObject(new FastEnemy(rand.nextInt(Screen.width - 32),rand.nextInt(Screen.height - 72),ID.Enemy , handler));
				handler.addObject(new Coin(rand.nextInt(Screen.width - 32), rand.nextInt(Screen.height - 72), ID.Coin, handler));
			}else if (hud.getLevel() == 5){
				handler.addObject(new FastEnemy(rand.nextInt(Screen.width - 32),rand.nextInt(Screen.height - 72),ID.Enemy , handler));

			}else if (hud.getLevel() == 6){
				handler.addObject(new Enemy(rand.nextInt(Screen.width - 32),rand.nextInt(Screen.height - 72), ID.Enemy ,handler));
			}else if (hud.getLevel() == 7){
				handler.addObject(new Coin(rand.nextInt(Screen.width - 32), rand.nextInt(Screen.height - 72), ID.Coin, handler));
			
			}else if (hud.getLevel() == 8){
				handler.clearEnemy();
				Game.player.setX(Screen.width - 32);
				Game.player.setY(Screen.height - 72);
				handler.addObject(Game.player);
				handler.addObject(new Boss(330, -56, ID.Boss, handler ,game));
			}
		}
	}
}
