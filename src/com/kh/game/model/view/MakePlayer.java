package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
 
//캐릭터 생성(수정필요!)
public class MakePlayer extends JPanel{
	private MainFrame mf;
	private JPanel makePlayer;
	private String charactName;
	
	public MakePlayer(MainFrame mf) {
		//초기화
		this.mf = mf;
		this.makePlayer = this;
		
		
		//메인 패널 설정
		this.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		//배경 이미지 설정
		JLabel backImg = new JLabel(new ImageIcon(new ImageIcon("images/test.jpg")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);
		
		//레이블 설정
		JLabel label = new JLabel("캐릭터 생성");
		label.setFont(new Font("Courier", Font.BOLD, 25));
		label.setLocation(390, 50);
		label.setSize(200, 60);
		
		//캐릭터 이미지
		JLabel characImg = new JLabel(new ImageIcon(new ImageIcon("images/남궁소희.jpg")
				.getImage()
				.getScaledInstance(179, 273, 0)));
		characImg.setBounds(150, 130, 179, 273);
		
		//스피너
		String[] items = {"남궁소희", "메이슨지현", "앤드류도연", "요나세령",
				"커티스정언", "타냐선아"};
		JComboBox characCB = new JComboBox(items);
		characCB.setBounds(150, 410, 179, 30);
		
		
		characCB.addActionListener(new ActionListener() {//콤보박스에 이벤트 연결하기
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				
				charactName = (String) cb.getSelectedItem();
				
				Image img = new ImageIcon("images/" + charactName + ".jpg")
							.getImage()
							.getScaledInstance(179, 273, 0);
				
				characImg.setIcon(new ImageIcon(img));
			} //end method
			
		}); //end listener
		
		//이름입력!
		JLabel nameLabel = new JLabel("이름을 입력해 주세요!");
		nameLabel.setFont(new Font("Courier", Font.BOLD, 22));
		nameLabel.setForeground(Color.WHITE); //글씨 색상
		nameLabel.setBounds(480, 80, 300, 200);
		JTextField nameTf = new JTextField(20);
		nameTf.setFont(new Font("Courier", Font.BOLD, 20));
		nameTf.setText("Player1");
		nameTf.selectAll();
		nameTf.setBounds(400, 200, 400, 50);
		
		//게임시작 버튼(수정 필요!)
		JButton btnStart = new JButton("Next > ");
		btnStart.setBounds(650, 270, 150, 50);
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//생성시 데이터를 저장할 파일 필요!
				ChangePanel.changePanel(mf, makePlayer, 
						new Prolog(mf));
			}
		});
		
		//컴포넌트에 추가		
		this.add(label); //"캐릭터 생성" 텍스트
		this.add(characImg); //캐릭터 선택 이미지
		this.add(characCB); //사진 선택 스피너
		this.add(nameLabel); //"이름을 입력해 주세요"
		this.add(nameTf); //이름입력 텍스트 필드
		this.add(btnStart); //게임시작 버튼
		
		this.add(backImg); //배경 이미지
		mf.add(this);
		//System.out.println("MakePlayer 성공적으로 호출");
	} //end constr
	
} //end class
