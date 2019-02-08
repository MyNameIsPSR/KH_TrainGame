package com.kh.game.model.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.model.talk.Talk;

//프롤로그 화면 예시(수정 필요!)
public class Prolog extends JPanel{
	
	private MainFrame mf;
	private JPanel prolog; 
	
	public Prolog(MainFrame mf) {
		this.mf = mf;
		this.prolog = this;
		
		//패널 설정
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);
		
		//백그라운드 이미지
		JLabel backImg = new JLabel(new ImageIcon(new ImageIcon("images/test.jpg")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);
		
		//버튼
		JButton btnStart = new JButton("게임 시작");
		btnStart.setBounds(650, 500, 150, 50);
		
		//패널에 추가
		this.add(btnStart);
		this.add(backImg);
		
		btnStart.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChangePanel.changePanel(mf, prolog, new Talk(mf));
			}
			
		});
		
		//프레임에 추가
		mf.add(this);
	} //end method
	
} //end class
