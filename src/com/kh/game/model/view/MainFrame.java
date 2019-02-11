package com.kh.game.model.view;

import javax.swing.JFrame;

import com.kh.game.model.talk.Talk;
 
public class MainFrame extends JFrame{
	
	public MainFrame() { //팀별로 하나만 작성
		this.setSize(900, 600);
		this.setLayout(null);
		
		//new CrossPanel(this);
		new StartPanel(this);
		
		//new Talk(this, 1);
		
		this.setResizable(false);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
