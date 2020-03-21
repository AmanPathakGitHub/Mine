package com.Wave.Main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scores extends MouseAdapter {
	
	private String[] scores;
	
	public Scores() throws FileNotFoundException {
		File input = new File("res/Scores");
		Scanner scan = new Scanner(input);
		scores = new String[3];
		
		for(int i = 0; scan.hasNextLine(); i++){
			scores[i] = scan.nextLine();
			System.out.println(scores[i]);
		}
				
	}
	
	public void render(Graphics g){
		
	}
	
	public void tick(){
		
	}
}
