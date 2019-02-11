package com.kh.game.model.gameMain;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.controller.DifferenceSpot;
import com.kh.game.model.talk.Talk3;
import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.DescripDlg;
import com.kh.game.model.view.MainFrame;
import com.kh.game.model.view.Player;
 
public class GameMain3 extends JPanel implements ActionListener{
	private MainFrame mf;
	private JPanel gameMain;
	private Dialog descip;
	private String title;
	private String imgAdd;
	private String description;
	private JButton[] btnGame = new JButton[3];
	private Player p;
	
	public GameMain3(MainFrame mf, String title, String imgAdd, String description, Player p) {
		///초기화
		this.mf = mf;
		this.gameMain = this;
		this.title = title;
		this.imgAdd = imgAdd;
		this.description = description;
		this.p = p;
		
		//메인 패널 설정
		this.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		//레이블 설정
		JLabel label = new JLabel(title);
		label.setFont(new Font("Courier", Font.BOLD, 25));
		label.setLocation(410, 40);
		label.setSize(300, 60);
		
		//게임 이미지
		JLabel gameImg = new JLabel(new ImageIcon(new ImageIcon(imgAdd)
				.getImage()
				.getScaledInstance(700, 400, 0)));
		gameImg.setBounds(100, 100, 700, 400);
		
		//버튼
		String[] btnStr = {"돌아 가기", "게임 설명", "게임 시작"};
		
		int y = 0;
		for(int i = 0; i < btnGame.length; i++) {
			btnGame[i] = new JButton(btnStr[i]);
			btnGame[i].setBounds(650, 300 + y, 100, 30);
			this.add(btnGame[i]);
			btnGame[i].addActionListener(this);
			y += 40;
		} //end for(i)

		//추가
		this.add(label); //게임 타이틀
		this.add(gameImg); //게임 이미지
		
		//컨테이너에 추가
		mf.add(gameMain);
	} //end constr

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGame[0]) {
			ChangePanel.changePanel(mf, gameMain, 
					new Talk3(mf, p));
		} else if(e.getSource() == btnGame[1]) {
			new DescripDlg(mf, title, description);
		} else if(e.getSource() == btnGame[2]) {
			new DifferenceSpot(mf, p);
			ChangePanel.changePanel(mf, gameMain, 
					new DifferenceSpot(mf, p));
		} //end if
	} //end method

} //end class
