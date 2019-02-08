package com.kh.game.model.view;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DescripDlg {
	private Dialog dlg;
	private MainFrame mf; 
	private String title;
	private String description;
	
	public DescripDlg(MainFrame mf, String title, String description) {
		//초기화
		this.mf = mf;
		this.title = title;
		this.description = description;
		
		//다이얼로그 객체 만들기
		dlg = new Dialog(mf, title);
		dlg.setBounds(250, 100, 800, 500);
		dlg.setLayout(null);
		
		//레이블 설정
		JLabel label = new JLabel(title);
		label.setFont(new Font("Courier", Font.BOLD, 25));
		label.setLocation(330, 50);
		label.setSize(200, 60);
		
		//텍스트 영역
		JTextArea descrip = new JTextArea(20, 50);
		JScrollPane scroll = new JScrollPane(descrip,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descrip.setFont(new Font("Courier", Font.BOLD, 18));
		descrip.append(description); //텍스트 설정
		descrip.setEditable(false); //편집불가
		descrip.setCaretPosition(descrip.getDocument().getLength());
		scroll.setLocation(100, 120);
		scroll.setSize(600, 300);
		
		
		//닫기 버튼
		JButton btnDlgClose = new JButton("닫기");
		btnDlgClose.setBounds(630, 430, 70, 30);
		
		btnDlgClose.addActionListener(new ActionListener() { //닫기 버튼 눌렀을 때

			@Override
			public void actionPerformed(ActionEvent e) {
				dlg.dispose(); //다이얼로그 닫기
			} //end method
			
		}); //end listener
		
		//다이얼로그에 추가
		dlg.add(label); //레이블 추가
		dlg.add(scroll); //텍스트 영역 추가
		dlg.add(btnDlgClose); //닫기 버튼 추가
		
		//다이얼로그 띄우기
		dlg.setVisible(true);
	} //end constr

} //end class
