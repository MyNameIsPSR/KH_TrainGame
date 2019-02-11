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
import com.kh.game.model.talk.Talk;
import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.CrossPanel;
import com.kh.game.model.view.DescripDlg;
import com.kh.game.model.view.MainFrame;
import com.kh.game.model.view.OXPlay;
 
public class GameMain extends JPanel implements ActionListener{
	private MainFrame mf;
	private JPanel gameMain;
	private Dialog descip;
	private String title;
	private String imgAdd;
	private String description;
	private JButton[] btnGame = new JButton[3];
	private int level;
	
	public GameMain(MainFrame mf, String title, String imgAdd, String description, int level) {
		///�ʱ�ȭ
		this.mf = mf;
		this.gameMain = this;
		this.title = title;
		this.imgAdd = imgAdd;
		this.description = description;
		this.level = level;
		
		//���� �г� ����
		this.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		//���̺� ����
		JLabel label = new JLabel(title);
		label.setFont(new Font("Courier", Font.BOLD, 25));
		label.setLocation(410, 40);
		label.setSize(300, 60);
		
		//���� �̹���
		JLabel gameImg = new JLabel(new ImageIcon(new ImageIcon(imgAdd)
				.getImage()
				.getScaledInstance(700, 400, 0)));
		gameImg.setBounds(100, 100, 700, 400);
		
		//��ư
		String[] btnStr = {"���� ����", "���� ����", "���� ����"};
		
		int y = 0;
		for(int i = 0; i < btnGame.length; i++) {
			btnGame[i] = new JButton(btnStr[i]);
			btnGame[i].setBounds(650, 300 + y, 100, 30);
			this.add(btnGame[i]);
			btnGame[i].addActionListener(this);
			y += 40;
		} //end for(i)
		
/*		btnGame[1].addActionListener(new ActionListener() { //���Ӽ��� ��ư ������ ��
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DescripDlg(mf, title, description);
			} //end method
			
		}); //end listener
*/		
		//�߰�
		this.add(label); //���� Ÿ��Ʋ
		this.add(gameImg); //���� �̹���
		
		//�����̳ʿ� �߰�
		mf.add(gameMain);
	} //end constr

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnGame[0]) {
			ChangePanel.changePanel(mf, gameMain, 
					new Talk(mf, 1));
		} else if(e.getSource() == btnGame[1]) {
			new DescripDlg(mf, title, description);
		} else if(e.getSource() == btnGame[2]) { //���ӽ��� ��ư ������ ��
			switch(level) {
			case 1: //OX����
				ChangePanel.changePanel(mf, gameMain, new OXPlay(mf));
				break;
			case 2: //���μ��γ�������
				ChangePanel.changePanel(mf, gameMain, new CrossPanel(mf));
				break;
			case 3: //Ʋ���ڵ� ã��
				ChangePanel.changePanel(mf, gameMain, new DifferenceSpot(mf));
				break;
			} //end switch			
		} //end if
		
	} //end method

} //end class
