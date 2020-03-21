package com.Wave.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scores extends MouseAdapter {
	
	private int[] scores;
	
	public Scores() throws FileNotFoundException {
		File input = new File("res/Scores");
		Scanner scan = new Scanner(input);
		scores = new int[3];
		
		for(int i = 0; scan.hasNextLine(); i++){
			scores[i] = scan.nextInt();
			System.out.println(scores[i]);
		}
		
	}
	
	public void render(Graphics g){
		Font fnt = new Font("fnt" , Font.ITALIC , 30);
		g.setFont(fnt);
		g.setColor(Color.ORANGE);
		
	}
	
	public void tick(){
		
	}
}
