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

//����ȭ��(���� �ʿ�)
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

		JButton button1 = new JButton("�����ϱ�");
		JButton button2 = new JButton("�̾��ϱ�");

		button1.setSize(150, 40);
		button2.setSize(150, 40);

		button1.setLocation(300, 450);
		button2.setLocation(460, 450);

		this.add(button1);
		this.add(button2);

		//�����ϱ� ������ ��
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//�α��� ȭ������ ����
				ChangePanel.changePanel(mf, StartPanel, new MakePlayer(mf, p));
			}
		});

		//�̾��ϱ� ������ ��(���� �ʿ�!!)
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GameLoad load = new GameLoad();
				load.load(sp.p, sp, sp.mf);

				//�ϴ��� ����ĭ ȭ������ ����
				//���� ����
				//���Ͽ��� ��ġ �ҷ��� �� ��ġ���� ���� ������ �� �ֵ���!

			}
		});

		mf.add(this);
	}
}
