package com.kh.game.model.view;

import java.awt.Font;
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
import javax.swing.JTextField;

import com.kh.game.controller.GameSave;
import com.kh.game.model.talk.Talk2;

//OX���ȭ��(���� �ʿ�!)
public class OXResult extends JPanel {
	
	private MainFrame mf;
	private JPanel oxResult;
	private Player p;
	private OXResult ox = this;

	public OXResult(MainFrame mf, Player p) {
		this.mf = mf; 
		this.oxResult = this;
		this.p = p;
		ox.p.setStage(1);
		
		this.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		
		JLabel label = new JLabel("OX");
		label.setFont(new Font("���",Font.BOLD,30));
		label.setSize(50,50);
		label.setLocation(425, 10);
		
		
		JTextField jtf = new JTextField(50);
		jtf.setSize(800,50);
		jtf.setLocation(40, 50);
		
		Image icon = new ImageIcon("images/test.jpg")
				.getImage().getScaledInstance(150, 150, 0);
		JLabel imgLabel= new JLabel(new ImageIcon(icon));
		imgLabel.setBounds(50, 120, 800, 400);
		
		
		JButton obutton = new JButton("NEXT");
		obutton.setFont(new Font("���",Font.BOLD,30));
		obutton.setSize(390,100);
		obutton.setLocation(40,420);
		
		obutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameSave save = new GameSave();
				save.save(ox.p, ox);
				
				//������ ���п��ο� ���� ��ȭ������ �޶�� ��
				ChangePanel.changePanel(mf, oxResult, 
						new Talk2(mf, ox.p));
			}
		});
		
		
		
		this.add(label);
		this.add(jtf);
		this.add(obutton);
	
		mf.add(this);
	} //end constr
	
} //end class
