package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.controller.GameSave;
import com.kh.game.model.talk.Talk3;

//���μ��γ�������
public class CrossPanel extends JPanel implements ActionListener{
	private MainFrame mf; 
	private JButton btnNext = new JButton();
	private JPanel SubPanel;
	private Player p;
	private CrossPanel cp = this;

	public CrossPanel(MainFrame mf, Player p) {
		this.mf = mf;
		this.SubPanel = this;
		this.p = p;
		this.p.setStage(2);

		this.setSize(900, 600);
		this.setLocation(0, 0);
		this.setBackground(Color.gray);
		this.setLayout(null);

		Image title = new ImageIcon("images/cat.PNG").getImage().getScaledInstance(500, 40, 0);

		JLabel crossword = new JLabel(new ImageIcon(title));
		crossword.setSize(500, 40);
		crossword.setLocation(200, 30);


		this.add(crossword);
		mf.add(this);
		new GamePanel(this);
	}

	public void setBtnNext(JButton btnNext) { //GamePanel�κ��� next��ư�� �޾ƿ�
		this.btnNext = btnNext;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GameSave save = new GameSave();
		save.save(cp.p, cp);

		//������ ���н� ��ȭ ȭ������ �Ѿ��(�����ʿ�)
		ChangePanel.changePanel(mf, SubPanel, 
				new Talk3(mf, cp.p));
	}
} 

