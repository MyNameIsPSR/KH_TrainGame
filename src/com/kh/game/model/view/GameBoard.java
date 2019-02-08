package com.kh.game.model.view;

import java.awt.GridLayout;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
 
public class GameBoard extends JPanel{
	private GamePanel gp;
	private JPanel GameBoard;
	
	public GameBoard(GamePanel gp) {
		this.gp = gp;
		this.GameBoard = this;
		
		this.setSize(400, 400);
		this.setLocation(0, 0);
		this.setLayout(new GridLayout(10, 10));
		
		Set set = new LinkedHashSet();

		while(set.size() < 100) {
			set.add(new Random().nextInt(100) + 1);
		}

		Object[] obj = set.toArray();

		for(int i = 0; i < obj.length; i++) {
			String str = new Integer((int)obj[i]).toString();

			this.add(new JButton(str));
		}
		
		gp.add(GameBoard);
	}

}
