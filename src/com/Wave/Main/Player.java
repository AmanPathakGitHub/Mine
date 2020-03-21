package com.Wave.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import com.Wave.Main.Game.STATE;

public class Player extends GameObject implements KeyListener  {

	public static int x , y;
	static int speed = 5;
	Handler handler;
	Random rand = new Random();
	static int bullets = 0;

	Spawn spawn;
	boolean[] keyDown = new boolean[4];
	/*
	 * keyDown[0] = W
	 * keyDown[1] = A
	 * keyDown[2] = S
	 * keyDown[3] = D
	 */
	
	Game game;
	public Player(int x, int y, ID id, Handler handler, Game game ,Spawn spawn) {
		super(x, y, id);
				
		Player.x = x;
		Player.y = y;
		this.game = game;
		this.spawn = spawn;
		this.handler = handler;
		
		for (int i = 0; i < keyDown.length; i++) {
			keyDown[i] = false;
		}
		
			
	}


	public void tick() {
				
		x += xVel;
		y += yVel;
		
		x = Game.clamp(x, 0, Screen.width - 32);
		y = Game.clamp(y, 0, Screen.height - 72);
		handler.addObject(new Trail(x, y, ID.Effects, Color.green, handler, 32, 32, 0.09f , 1.0f));
		collision();
	}

	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.fillRect(x, y, 32, 32);
		
		
	}
	
	public void collision(){
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempobject = handler.object.get(i);
			
			if (tempobject.getId() == ID.Enemy){
				if (getBounds().intersects(tempobject.getBounds())){
					//Collision code
					HUD.HEALTH -= 2;
				} 
				
			
			}
			
		 }
		}

		
	


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_W:
			
			setyVel(speed * -1);
			keyDown[0] = true;
			break;
		case KeyEvent.VK_A:
			setxVel(speed * -1);
			keyDown[1] = true;

			break;
		case KeyEvent.VK_S:
			setyVel(speed);
			keyDown[2] = true;

			break;
		case KeyEvent.VK_D:
			setxVel(speed);		
			keyDown[3] = true;

			break;
		case KeyEvent.VK_P:
			if (game.gameState == STATE.Game){
				if (Game.paused == true){
					Game.paused = false;
				}else Game.paused = true;
			}
			break;
		case KeyEvent.VK_SHIFT:
			if (game.gameState == STATE.Game){
									
				game.gameState = STATE.Shop;
			}else if (game.gameState == STATE.Shop){
				game.gameState = STATE.Game;
				
				
			}
			
			break;
		case KeyEvent.VK_SPACE:
			if (bullets > 0){
				bullets--;
				handler.addObject(new PlayerBullet(x, y, ID.PlayerItem, handler));
			}
			
			
			
			break;
		
		
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_W:
			
			//setyVel(0);
			keyDown[0] = false;
			break;
		case KeyEvent.VK_A:
			//setxVel(0);
			keyDown[1] = false;
			break;
		case KeyEvent.VK_S:
			//setyVel(0);
			keyDown[2] = false;
			break;
		case KeyEvent.VK_D:
			//setxVel(0);
			keyDown[3] = false;
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(1);
			break;
		
			
		}
		if (!keyDown[0] && !keyDown[2]){
			setyVel(0);
		}
		if (!keyDown[1] && !keyDown[3]){
			setxVel(0);
		}
		
		
	}


	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y , 32, 32);
	}

}
