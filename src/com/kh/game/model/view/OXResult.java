package com.kh.game.model.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.game.model.talk.Talk;

//OX결과화면(수정 필요!)
public class OXResult extends JPanel {
	
	private MainFrame mf;
	private JPanel oxResult;

	public OXResult(MainFrame mf) {
		this.mf = mf; 
		this.oxResult = this;
		
		this.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		
		JLabel label = new JLabel("OX");
		label.setFont(new Font("고딕",Font.BOLD,30));
		label.setSize(50,50);
		label.setLocation(425, 10);
		
		
		JTextField jtf = new JTextField(50);
		jtf.setSize(800,50);
		jtf.setLocation(40, 50);
		
		Image icon = new ImageIcon("images/test.jpg")
				.getImage().getScaledInstance(150, 150, 0);
		JLabel imgLabel= new JLabel(new ImageIcon(icon));
		imgLabel.setBounds(50, 120, 800, 400);
		this.add(imgLabel);
		
		JButton obutton = new JButton("NEXT");
		obutton.setFont(new Font("고딕",Font.BOLD,30));
		obutton.setSize(390,100);
		obutton.setLocation(40,420);
		
		obutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//성공과 실패여부에 따라서 대화내용이 달라야 함
				ChangePanel.changePanel(mf, oxResult, 
						new Talk(mf, 2));
			}
		});
		
		
		
		this.add(label);
		this.add(jtf);
		this.add(obutton);
	
		mf.add(this);
	} //end constr
	
} //end class
