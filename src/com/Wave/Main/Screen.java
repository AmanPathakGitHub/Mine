package com.Wave.Main;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Screen extends Canvas {

	
	private static final long serialVersionUID = 1L;
	public static int width, height;
	private String name;
	private Game game;
	

	public Screen(int width, int height, String name , Game game) {
		
		Screen.height = height;
		Screen.width = width;
		this.name = name;
		this.game = game;
		
		createscreen();
		game.start();
		
	}
	
	public void createscreen(){
		
		JFrame window = new JFrame(name);
		
		
		window.setPreferredSize(new Dimension(width, height));
		window.setMaximumSize(new Dimension(width, height));
		window.setMinimumSize(new Dimension(width, height));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.getContentPane().setBackground(Color.black);
		window.setFont(new Font(null, Font.BOLD, 75));
		window.add(game);
				
		window.addKeyListener(Game.player);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}
}
