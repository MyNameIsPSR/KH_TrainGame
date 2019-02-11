package com.kh.game.model.talk;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.model.gameMain.GameMain;
import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.MainFrame;

public class Talk extends JPanel implements ActionListener{ 

   private MainFrame mf;
   private JPanel mainPage;
   private int level;
   private ArrayList<String> talkArr = new ArrayList<String>();
   private int index = 0;
   private JPanel gamePanel;
   private JButton btnNext, btnPre, btnGameStart;
   private JLabel talkLabel;
   private Image dk;
   

   public Talk(MainFrame mf, int level) {
      this.mf = mf;
      this.mainPage = this; 
      this.level = level;

      this.setBounds(0, 0, 900, 600);
      this.setLayout(null);      
      
      //칸마다 다른 설정
      switch(level) {
	      case 1://첫번째 칸
	    	  System.out.println("첫번째 칸에 도착했습니다.");
	    	  //대화 내용 집어 넣기
	    	  talkArr.add("뭐야 ! 얼른 자리로 돌아가라고 !");
	    	  talkArr.add("머리칸으로 가겠다고 ?!");
	    	  talkArr.add("가뜩이나 심심했는데 잘됬군 ! ");
	    	  talkArr.add("나랑 간단한 게임을 해서 이긴다면 문을 열어주지 !");
	    	  talkArr.add("어짜피 꼬리칸 애송이가 이길 일은 없겠지만 말이야.");
	    	  talkArr.add("어때 게임을 하겠나 ? ");
	    	  //문지기 이미지 설정
	    	  dk = new ImageIcon("images/타냐선아.jpg").getImage()
	        		  .getScaledInstance(150,150,0);
	    	  break;
	      case 2://두번째 칸
	    	  System.out.println("두번째 칸에 도착했습니다.");
	    	  //대화 내용 넣기
	    	  talkArr.add("꼬리칸 사람이 어떻게 여기에 있는 거지 ? ");
	    	  talkArr.add("<문지기 1>은 뭐하고 있는 거야 ?!");
	    	  talkArr.add("뭐 ?! 머리칸으로 가겠다고 ?!");
	    	  talkArr.add("몇 년 전에도 머리칸으로 가겠다는 바보들이 있었지...");
	    	  talkArr.add("그럼 나랑 게임을 해서 이긴다면 보내주마");
	    	  talkArr.add("어때 게임을 하겠나 ?");
	    	  //문지기 이미지 설정
	    	  dk = new ImageIcon("images/커티스정언.jpg").getImage()
	        		  .getScaledInstance(150,150,0);
	    	  break;
	      case 3://세번째 칸
	    	  System.out.println("두번째 칸에 도착했습니다.");
	    	  //대화 내용 넣기
	    	  talkArr.add("니가 꼬리칸에서 반란을 일으켰다는 애송이군 ~ ");
	    	  talkArr.add("하필 마지막에서 나를 만났다니... 운이 참 없구나... ");
	    	  talkArr.add("나를 여태까지 만났던 문지기들 수준으로 생각한다면 당장 돌아가는게 좋을 거야");
	    	  talkArr.add("상대해 주지 않는게 규칙이지만 어차피 너한테 지는 일은 없을 테니");
	    	  talkArr.add("잠깐 놀아주도록 하지...");
	    	  talkArr.add("어때, 게임을 하겠나?");	
	    	  //문지기 이미지 설정
	    	  dk = new ImageIcon("images/메이슨지현.jpg").getImage()
	        		  .getScaledInstance(150,150,0);
	    	  break;
      } //end switch

      
      talkLabel = new JLabel(talkArr.get(index++));
      talkLabel.setBounds(40, 340, 800, 150); 
      
      JLabel dki = new JLabel(new ImageIcon(dk));
      dki.setBounds(350, 200, 150, 150);

      //다음 대화 내용으로 넘기는 버튼
      btnNext = new JButton(" next > ");
      btnNext.setBounds(770, 500, 75, 30);
      btnNext.addActionListener(this);
      
      
      btnPre = new JButton("포기 할래!");
      btnPre.addActionListener(this);

      btnGameStart = new JButton("도전 할게!");
      btnGameStart.addActionListener(this);

      this.add(talkLabel);
      this.add(btnNext);
      this.add(dki);

      mf.add(this);
      System.out.println("Talk 성공적 호출");
   }
   
   public void setLevel(int level) {
	   this.level = level;
   } //end method

	@Override
	public void actionPerformed(ActionEvent e) { //버튼 눌렀을 때
		if(e.getSource() == btnNext) { //Next > 눌렀을 때
			System.out.println("대화 다음으로 넘기기");
			if(index != talkArr.size() -1 ) { //대화내용 넘기기
				System.out.println("Next 버튼을 눌렀습니다.");
				talkLabel.setText(talkArr.get(index));
			} else { //마지막 대화에 왔을 때
				System.out.println("마지막 대화에 왔습니다.");
				mainPage.remove(btnNext);
				mainPage.add(btnPre);
				mainPage.add(btnGameStart);
			    btnPre.setBounds(620, 500, 105, 30);
			    btnGameStart.setBounds(750, 500, 105, 30);		
			} //end if
			index++;
		} //end if
		if(e.getSource() == btnGameStart) { //게임하기 버튼 눌렀을 때
			switch(level) {
				case 1: //첫번째 칸, OX게임
					System.out.println("게임 시작 버튼을 눌렀습니다. OX퀴즈 메인으로 갑니다.");
					gamePanel = new GameMain(mf, "O X퀴즈", "images/test.jpg", "설명", 1);
					break;
				case 2://두번째 칸, 가로세로 낱말퀴즈
					System.out.println("게임 시작 버튼을 눌렀습니다. 가로세로 낱말퀴즈 메인으로 갑니다.");
					gamePanel = new GameMain(mf, "가로세로 낱말퀴즈", "images/test.jpg", "설명", 2);
					break;
				case 3://세번째 칸, 틀린 코드 찾기
			    	System.out.println("게임 시작 버튼을 눌렀습니다. 가로세로 낱말퀴즈 메인으로 갑니다.");
			    	gamePanel = new GameMain(mf, "틀린코드 찾기", "images/test.jpg", "설명", 3);
					break;
			} //end switch
			if(gamePanel != null) {
				ChangePanel.changePanel(mf, mainPage, gamePanel);//패널 교체
			} //end if
		} //end if
		
	} //end method
}