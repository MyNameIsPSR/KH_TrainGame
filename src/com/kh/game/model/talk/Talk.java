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
      
      //ĭ���� �ٸ� ����
      switch(level) {
	      case 1://ù��° ĭ
	    	  System.out.println("ù��° ĭ�� �����߽��ϴ�.");
	    	  //��ȭ ���� ���� �ֱ�
	    	  talkArr.add("���� ! �� �ڸ��� ���ư���� !");
	    	  talkArr.add("�Ӹ�ĭ���� ���ڴٰ� ?!");
	    	  talkArr.add("�����̳� �ɽ��ߴµ� �߉籺 ! ");
	    	  talkArr.add("���� ������ ������ �ؼ� �̱�ٸ� ���� �������� !");
	    	  talkArr.add("��¥�� ����ĭ �ּ��̰� �̱� ���� �������� ���̾�.");
	    	  talkArr.add("� ������ �ϰڳ� ? ");
	    	  //������ �̹��� ����
	    	  dk = new ImageIcon("images/Ÿ�ļ���.jpg").getImage()
	        		  .getScaledInstance(150,150,0);
	    	  break;
	      case 2://�ι�° ĭ
	    	  System.out.println("�ι�° ĭ�� �����߽��ϴ�.");
	    	  //��ȭ ���� �ֱ�
	    	  talkArr.add("����ĭ ����� ��� ���⿡ �ִ� ���� ? ");
	    	  talkArr.add("<������ 1>�� ���ϰ� �ִ� �ž� ?!");
	    	  talkArr.add("�� ?! �Ӹ�ĭ���� ���ڴٰ� ?!");
	    	  talkArr.add("�� �� ������ �Ӹ�ĭ���� ���ڴٴ� �ٺ����� �־���...");
	    	  talkArr.add("�׷� ���� ������ �ؼ� �̱�ٸ� �����ָ�");
	    	  talkArr.add("� ������ �ϰڳ� ?");
	    	  //������ �̹��� ����
	    	  dk = new ImageIcon("images/ĿƼ������.jpg").getImage()
	        		  .getScaledInstance(150,150,0);
	    	  break;
	      case 3://����° ĭ
	    	  System.out.println("�ι�° ĭ�� �����߽��ϴ�.");
	    	  //��ȭ ���� �ֱ�
	    	  talkArr.add("�ϰ� ����ĭ���� �ݶ��� �����״ٴ� �ּ��̱� ~ ");
	    	  talkArr.add("���� ���������� ���� �����ٴ�... ���� �� ������... ");
	    	  talkArr.add("���� ���±��� ������ ������� �������� �����Ѵٸ� ���� ���ư��°� ���� �ž�");
	    	  talkArr.add("����� ���� �ʴ°� ��Ģ������ ������ ������ ���� ���� ���� �״�");
	    	  talkArr.add("��� ����ֵ��� ����...");
	    	  talkArr.add("�, ������ �ϰڳ�?");	
	    	  //������ �̹��� ����
	    	  dk = new ImageIcon("images/���̽�����.jpg").getImage()
	        		  .getScaledInstance(150,150,0);
	    	  break;
      } //end switch

      
      talkLabel = new JLabel(talkArr.get(index++));
      talkLabel.setBounds(40, 340, 800, 150); 
      
      JLabel dki = new JLabel(new ImageIcon(dk));
      dki.setBounds(350, 200, 150, 150);

      //���� ��ȭ �������� �ѱ�� ��ư
      btnNext = new JButton(" next > ");
      btnNext.setBounds(770, 500, 75, 30);
      btnNext.addActionListener(this);
      
      
      btnPre = new JButton("���� �ҷ�!");
      btnPre.addActionListener(this);

      btnGameStart = new JButton("���� �Ұ�!");
      btnGameStart.addActionListener(this);

      this.add(talkLabel);
      this.add(btnNext);
      this.add(dki);

      mf.add(this);
      System.out.println("Talk ������ ȣ��");
   }
   
   public void setLevel(int level) {
	   this.level = level;
   } //end method

	@Override
	public void actionPerformed(ActionEvent e) { //��ư ������ ��
		if(e.getSource() == btnNext) { //Next > ������ ��
			System.out.println("��ȭ �������� �ѱ��");
			if(index != talkArr.size() -1 ) { //��ȭ���� �ѱ��
				System.out.println("Next ��ư�� �������ϴ�.");
				talkLabel.setText(talkArr.get(index));
			} else { //������ ��ȭ�� ���� ��
				System.out.println("������ ��ȭ�� �Խ��ϴ�.");
				mainPage.remove(btnNext);
				mainPage.add(btnPre);
				mainPage.add(btnGameStart);
			    btnPre.setBounds(620, 500, 105, 30);
			    btnGameStart.setBounds(750, 500, 105, 30);		
			} //end if
			index++;
		} //end if
		if(e.getSource() == btnGameStart) { //�����ϱ� ��ư ������ ��
			switch(level) {
				case 1: //ù��° ĭ, OX����
					System.out.println("���� ���� ��ư�� �������ϴ�. OX���� �������� ���ϴ�.");
					gamePanel = new GameMain(mf, "O X����", "images/test.jpg", "����", 1);
					break;
				case 2://�ι�° ĭ, ���μ��� ��������
					System.out.println("���� ���� ��ư�� �������ϴ�. ���μ��� �������� �������� ���ϴ�.");
					gamePanel = new GameMain(mf, "���μ��� ��������", "images/test.jpg", "����", 2);
					break;
				case 3://����° ĭ, Ʋ�� �ڵ� ã��
			    	System.out.println("���� ���� ��ư�� �������ϴ�. ���μ��� �������� �������� ���ϴ�.");
			    	gamePanel = new GameMain(mf, "Ʋ���ڵ� ã��", "images/test.jpg", "����", 3);
					break;
			} //end switch
			if(gamePanel != null) {
				ChangePanel.changePanel(mf, mainPage, gamePanel);//�г� ��ü
			} //end if
		} //end if
		
	} //end method
}