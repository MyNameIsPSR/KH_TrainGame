package com.kh.game.model.talk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.Ending;
import com.kh.game.model.view.MainFrame;
import com.kh.game.model.view.Player;

 
public class Talk4 extends JPanel{ 
	
	private MainFrame mf;
	private JPanel mainPage;
	private Player p;

	public Talk4(MainFrame mf, Player p) {
		this.mf = mf;
		this.mainPage = this; 
		this.p = p;
	
		//1. 메인 패널 크기 설정
		this.setBounds(0, 0, 900, 600); //위치 및 크기 조절
		this.setLayout(null); //레이아웃 설정

		//3) 컴포넌트 생성
		//4) 컴포넌트 배치
		/*JPanel all = new JPanel();
		all.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		
		JTextArea ta = new JTextArea("문지기 대화내용", 10, 70);
		JButton btn = new JButton(" next > ");
		btn.setLocation(700,470);
		btn.setSize(75,50);
		p1.setLayout(new BorderLayout());
		p1.add(ta, "North");
		p1.add(btn, "South");
		all.add(p1,"South");*/

		/*Image dk = new ImageIcon("직박구리/1085379995-findit2/cat1a.jpg")
				.getImage()
				.getScaledInstance(150,150,0);
		JLabel dki = new JLabel(new ImageIcon(dk));
		all.add(dki, "Center");*/

		//this.add(all);
		
		JLabel label = new JLabel("문지기와 대화 내용4!");
		label.setBounds(100, 100, 500, 50); //위치및 크기 조절 하는 메소드 반드시 필요!
		
		JButton button  = new JButton("다음");
		button.setBounds(400, 400, 100, 50);
		
		//성공했을 때 엔딩으로 가기(수정 필요)
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("대화화면으로 넘어왔습니다.");
				ChangePanel.changePanel(mf, mainPage, 
						new Ending(mf));
				System.out.println("엔딩으로 넘어갑니다.");
			}
		});
		
		this.add(label);
		this.add(button);
		
		mf.add(this);
		//System.out.println("Talk 성공적 호출");

		//2. 프레임 종료시 프로세스 종료
		//3. 화면에 보여지게 하는 메소드
		//this.setVisible(true);
	}

	
}

//5) 이벤트 처리


