package com.kh.game.model.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		
		JTextArea ta = new JTextArea("<프롤로그>\r\n" + 
				"세계 78개 국이 지구 온난화 방지책으로 대기권에 살포한 CW-7의 부작용으로 \r\n" + 
				"새로운 빙하기가 찾아오게 되었다.\r\n" + 
				"지구는 생물체가 살 수 없는 혹한의 동토로 변해 버린다.\r\n" + 
				"\r\n" + 
				"CW-7의 부작용을 걱정하던 윌포드는 세계의 유명한 프로그래머들을 영입하여\r\n" + 
				"에너지 생산 시스템 및 자원 재생 시스템, 영구 동력 엔진 등 자급자족 시스템을 탑제한\r\n" + 
				"전 세계 순환 열차를 탄생시켰다.\r\n" + 
				"\r\n" + 
				"모두가 어리석다고 말했지만 한 순간 인류를 구한 영웅이 되었으며\r\n" + 
				"지금도 생존자들을 태운 유일한 생존지역으로 열차는 전 세계를 순환하고 있다.\r\n" + 
				"\r\n" + 
				"20년 후...\r\n" + 
				"\r\n" + 
				"유일한 생존지역인 열차는 철저한 신분제도가 존재했다.\r\n" + 
				"\r\n" + 
				"열차 개발에 영향력이 있었던 프로그래머들은 머리칸에서 호화로운 생활을..\r\n" + 
				"\r\n" + 
				"프로그램에 대해 알지 못하는 자들은 꼬리칸에서 지옥같은 삶을....\r\n" + 
				"\r\n" + 
				"이에 불만을 가지고 있던 <주인공>은 머리칸 탈환을 목표로 반란을 준비하고 있었으며\r\n" + 
				
				"이제 때가 되었다.....\r\n");
		ta.setBounds(120, 50, 650, 430);
	/*	ta.setLocation(40,340);
		ta.setSize(800,150);*/
		ta.setEditable(false);
		
		
		//버튼
		JButton btnStart = new JButton("게임 시작");
		btnStart.setBounds(650, 500, 150, 50);
		
		//패널에 추가
		this.add(ta);
		this.add(btnStart);
		this.add(backImg);
	
		btnStart.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChangePanel.changePanel(mf, prolog, new Talk(mf, 1));
			}
			
		});
		
		//프레임에 추가
		mf.add(this);
	} //end method
	
} //end class
