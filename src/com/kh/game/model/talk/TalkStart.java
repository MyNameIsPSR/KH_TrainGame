package com.kh.game.model.talk;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.MainFrame;

public class TalkStart extends JPanel {
	
	private MainFrame mf;
	private JPanel ts;
	private int level;
	private Image dk;
	private JLabel dkl;
	
	public TalkStart(MainFrame mf, int level) {
		this.mf = mf;
		this.ts = this;
		this.level = level;
		
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);
		
		dk = new ImageIcon("images/타냐선아.jpg")
				.getImage()
				.getScaledInstance(150, 150, 0);
		dkl = new JLabel(new ImageIcon(dk));
		dkl.setBounds(350, 200, 150, 150);
		dkl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, ts, new Talk(mf, 1));
				
			}
		});
		
		this.add(dkl);
		
		mf.add(this);
		
	}
	
	

}
