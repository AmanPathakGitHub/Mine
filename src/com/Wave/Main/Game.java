package com.Wave.Main;

import java.awt.Canvas;
import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
private static final long serialVersionUID = 7711981806252101853L;
	
	private Handler handler;
	private Graphics g;
	private Thread thread;
	private boolean running = false;
	private Random rand = new Random();
	public static boolean paused = false;
	private HUD hud;
	private Trail trail;
	private Spawn spawn;
	private Menu menu;
	private Help help;
	private GameOver over;
	private Shop shop;
	private Win win;
	
	
	 static int frames;
	
	
	public static Player player;
	
	public enum STATE{
		Game,
		GameOver,
		Shop,
		Win,
		Help,
		Menu;
	}
	public STATE gameState = STATE.Menu;
	public Game() {
				
		help = new Help(this);
		
		handler = new Handler();
		over = new GameOver(this, handler);
		shop = new Shop(this);
		
		
		menu = new Menu(this , handler);
		this.addMouseListener(help);
		this.addMouseListener(over);
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		
		
		AudioPlayer.load();
		AudioPlayer.getMusic("music_menu").loop();
		
		new Screen(700, 500,  "Wave" , this);
		
		
		hud = new HUD(this, handler);
		spawn = new Spawn(handler, hud, this);
		player = new Player(100, 100, ID.Player , handler, this, spawn);
		this.addKeyListener(player);
		win = new Win(handler, this);
		this.addMouseListener(win);
		
		if (gameState == STATE.Game){
			handler.clearEnemy();
			HUD.HEALTH = 100;
			handler.addObject(player);
			
			
			handler.addObject(new Enemy(rand.nextInt(Screen.width - 32),rand.nextInt(Screen.height - 72), ID.Enemy ,handler));
		}else if (gameState == STATE.Menu){
			for(int i = 0; i < 10; i++){
				handler.addObject(new MenuParticle(rand.nextInt(Screen.width - 32), rand.nextInt(Screen.height - 72), ID.Effects, handler, this));
				
			}
		}		
		
		
	}
	
	
	public synchronized void start(){
		
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		
		try {
			thread.join();
			running = false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		
		
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
        
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                Game.frames = frames;            
                                //System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    }
		
	
	
	private void tick(){
		if (!paused){
			
			if (gameState == STATE.Game){
				handler.tick();
				hud.tick();
				spawn.tick();
			}
			
			if (gameState == STATE.Menu){
				handler.tick();
				menu.tick();
			}
			
			if (gameState == STATE.Help){
				handler.tick();
				help.tick();
			}
			if (gameState == STATE.GameOver){
				handler.tick();
				over.tick();
			}
			if (gameState == STATE.Shop){
				shop.tick();
			}
			if (gameState == STATE.Win){
				win.tick();
				handler.tick();
				
			}
		}
		
		
		
	}
	
	private void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null){
			
			this.createBufferStrategy(3);
			return;
		}
		
		 g = bs.getDrawGraphics();
		
		 g.clearRect(0, 0, 700, 500);
		
		
		 
		if (paused){
			g.setColor(Color.white);
			g.drawString("Paused", 100, 100);
		}
		
		if (gameState == STATE.Game){
			handler.render(g);
			hud.render(g);
			
		}
		if (gameState == STATE.Menu){
			handler.render(g);
			menu.render(g);
			
		}
		
		if (gameState == STATE.Help){
			handler.render(g);
			help.render(g);
			
		}
		if (gameState == STATE.GameOver){
			handler.render(g);
			over.render(g);
			
		}
		if (gameState == STATE.Shop){
			shop.render(g);
		}
		if (gameState == STATE.Win){
			win.render(g);
			handler.tick();
		}
	
		
		bs.show(); 
		g.dispose();
		
				
		
	}
	
	public static int clamp(int var, int min, int max){
		
		if (var >= max){
			return var = max;
		}else if(var <= min){
			return var = min;
		
		}else{
			return var;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		new Game();
	}
	

	

}
