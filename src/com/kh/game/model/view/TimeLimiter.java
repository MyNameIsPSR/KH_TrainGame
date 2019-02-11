package com.kh.game.model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.kh.game.controller.DifferenceSpot;



public class TimeLimiter extends JPanel{
	
	private int maxTime;
	private Timer timer1 = null;
	public JLabel tLabel = null;
	public TimeLimiter timer = this;

	public TimeLimiter(int maxTime, DifferenceSpot dif) {
		this.setBounds(10, 10, 60, 50);
		tLabel = new JLabel("" + this.maxTime);
		tLabel.setSize(60, 40);
		tLabel.setLocation(20, 5);
		tLabel.setBackground(Color.DARK_GRAY);
		tLabel.setFont(new Font("Gothic", 0, 20));
		tLabel.setForeground(Color.RED);
		
		timer1 = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.maxTime >= 0) {
					tLabel.setText("" +(timer.maxTime--));
				}else {
					timer1.stop();
					dif.getButton2().setVisible(true);
				}
				if(dif.spot1 == true && dif.spot2 == true && dif.spot3 == true){
					timer1.stop();
				}
			}
		});
		
		this.setLayout(null);
		this.maxTime = maxTime;
		this.add(tLabel, BorderLayout.CENTER);
		timer1.start();

	}
	
}
