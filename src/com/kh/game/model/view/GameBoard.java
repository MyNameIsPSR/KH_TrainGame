package com.kh.game.model.view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
 
public class GameBoard extends JPanel{
	private GamePanel gp;
	private JPanel GameBoard;
	
	public GameBoard(GamePanel gp) {
		this.gp = gp;
		this.GameBoard = this;
		
		this.setSize(400, 400);
		this.setLocation(0, 0);
		this.setLayout(new GridLayout(10, 10));
		
		
		/*int x = 0;
		int y = 0;
		String[][] sarr = new String[10][10];
		
		for(int i = 0; i < sarr.length; i++) {
			x = 0;
			for(int j = 0 ; j < sarr[i].length; j++) {
				JTextField tf = new JTextField();
				tf.setBackground(Color.LIGHT_GRAY);
				tf.setBounds(x, y, 40, 40);
				x += 40;
				this.add(tf);
			}
			y += 40;
		}*/
		
		gp.add(GameBoard);
	}
	
	
	public void munjae1() {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
