package com.kh.game.model.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.model.talk.Talk3;
 
//마지막 엔딩(예시)
//수정 필요!
public class Ending extends JPanel{
	
	private MainFrame mf;
	private JPanel ending;
	
	public Ending(MainFrame mf) {
		this.mf = mf;
		this.ending = this;
		
		//패널 설정
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);
		
		//백그라운드 이미지
		JLabel backImg = new JLabel(new ImageIcon(new ImageIcon("images/test.jpg")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);
		
		//버튼
		JButton btnStart = new JButton("종료");
		btnStart.setBounds(650, 500, 150, 50);
		
		//패널에 추가
		this.add(btnStart);
		this.add(backImg);
		
		btnStart.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ending.add(new JLabel("게임 종료"));
				ChangePanel.changePanel(mf, ending, 
						new StartPanel(mf));
				System.out.println("게임 종료!");
			}
			
		});
		
		//프레임에 추가
		mf.add(this);
	} //end method
	
} //end class
