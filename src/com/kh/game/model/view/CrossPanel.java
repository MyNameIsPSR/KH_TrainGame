package com.kh.game.model.view;

import java.awt.*;

import javax.swing.*;

public class CrossPanel extends JPanel{
	private MainFrame mf;
	
	private JPanel CrossPanel;

	public CrossPanel(MainFrame mf) {
		this.mf = mf;
		this.CrossPanel = this;

		this.setSize(900, 600);
		this.setBackground(Color.gray);
		this.setLayout(null);

		Image title = new ImageIcon("images/cat.PNG").getImage().getScaledInstance(500, 40, 0);

		JLabel crossword = new JLabel(new ImageIcon(title));
		crossword.setSize(500, 40);
		crossword.setLocation(200, 30);

		new GamePanel(this, new GameBoard());

		this.add(crossword);
		mf.add(this);
	}
}
