package com.kh.game.model.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.kh.game.controller.DifferenceSpot;
import com.kh.game.controller.GameLoad;
import com.kh.game.model.talk.Talk;

//시작화면(수정 필요)
public class StartPanel extends JPanel{
	private MainFrame mf;
	private JPanel StartPanel; 
	private Player p;
	private StartPanel sp = this;

	public StartPanel(MainFrame mf, Player p) {
		this.mf = mf;
		this.StartPanel = this;
		this.p = p;

		this.setSize(900, 600);
		this.setBackground(Color.gray);
		this.setLayout(null);

		JButton button1 = new JButton("새로하기");
		JButton button2 = new JButton("이어하기");

		button1.setSize(150, 40);
		button2.setSize(150, 40);

		button1.setLocation(300, 450);
		button2.setLocation(460, 450);

		this.add(button1);
		this.add(button2);

		//새로하기 눌렀을 때
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//로그인 화면으로 가기
				ChangePanel.changePanel(mf, StartPanel, new MakePlayer(mf, p));
			}
		});

		//이어하기 눌렀을 때(수정 필요!!)
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GameLoad load = new GameLoad();
				load.load(sp.p, sp, sp.mf);

				//일단은 꼬리칸 화면으로 가기
				//향후 수정
				//파일에서 위치 불러와 그 위치에서 부터 시작할 수 있도록!

			}
		});

		mf.add(this);
	}
}
