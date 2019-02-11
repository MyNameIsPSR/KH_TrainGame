package com.kh.game.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.kh.game.model.talk.Talk3;
import com.kh.game.model.talk.Talk4;
import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.MainFrame;
import com.kh.game.model.view.Munjae1;
import com.kh.game.model.view.Munjae2;
import com.kh.game.model.view.Munjae3;
import com.kh.game.model.view.Player;
import com.kh.game.model.view.TimeLimiter;

public class DifferenceSpot extends JPanel{
	private JPanel ds = this;
	public static boolean spot1 = false;
	public static boolean spot2 = false;
	public static boolean spot3 = false;
	private JLabel munjae;
	private JLabel result;
	private JLabel life1;
	private JLabel life2;
	private JLabel life3;
	private int [] x;
	private int [] y;
	private int xRange = 40;
	private int yRange = 20;
	private MainFrame mf;
	private int life = 3;
	private ImageIcon icon = null;
	private JPanel panel2;
	private JPanel timer;
	private JButton button;
	private JButton button2;
	private JButton npc;
	private Player p;
	private DifferenceSpot dif = this;
	
	public DifferenceSpot(MainFrame mf, Player p) {
		CustomMouseAdapter cma = new CustomMouseAdapter();
		timer = new TimeLimiter(60, this);
		this.mf = mf;
		this.p = p;
		this.p.setStage(3);
		int random = (int)(Math.random()*3)+1;
		if(random == 1) {
			icon = new ImageIcon("직박구리/문제1.PNG");
			x = new int [] {231, 163, 120};
			y = new int [] {166, 214, 291};
			panel2 = new Munjae1();
			
		}else if (random == 2) {
			icon = new ImageIcon("직박구리/문제2.PNG");
			x = new int [] {402, 306, 88};
			y = new int [] {107, 160, 247};
			panel2 = new Munjae2();
			
		}else if (random == 3) {
			icon = new ImageIcon("직박구리/문제3.PNG");
			x = new int [] {248, 98, 207};
			y = new int [] {140, 202, 292};
			panel2 = new Munjae3();
		}
		
		JLabel title = new JLabel("틀린 그림 찾기");
		title.setLocation(390, 10);
		title.setSize(120, 70);

		result = new JLabel("게임 진행중...");
		result.setLocation(400, 500);
		result.setSize(120, 70);
		
		munjae = new JLabel(icon);
		munjae.setLocation(150, 70);
		munjae.setSize(600, 350);
		munjae.addMouseListener(cma);
		
		life1 = new JLabel("ㅇ");
		life1.setSize(20,20);
		life1.setLocation(800, 20);
		
		life2 = new JLabel("ㅇ");
		life2.setSize(20,20);
		life2.setLocation(825, 20);
		
		life3 = new JLabel("ㅇ");
		life3.setSize(20,20);
		life3.setLocation(850, 20);
		
		JTextField text = new JTextField();
		if(random == 1) {
			text.setText("자동완성에\n너무 익숙해진거 아닌가?");
		}else if(random == 2) {
			text.setText("try문과\nwhile문을\n다시공부해봐");
		}else {
			text.setText("길이를 아는\n방법은\n여러가지가 있지");
		}
		text.setLocation(19, 300);
		text.setSize(100, 150);
		text.setVisible(false);
		text.setEditable(false);
		
		
		
		npc = new JButton("NPC자리");
		npc.setSize(100, 100);
		npc.setLocation(19, 445);
		npc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == npc) {
					
					text.setVisible(true);
					
				}
				
			}
		});
		
		button = new JButton("게임 클리어!! 다음으로");
		button.setSize(200, 40);
		button.setLocation(350, 450);
		button.setVisible(false);
		
		button2 = new JButton("실패했습니다... 이전으로");
		button2.setSize(200, 40);
		button2.setLocation(350, 450);
		button2.setVisible(false);
		
		
		this.add(life1);
		this.add(life2);
		this.add(life3);
		this.add(text);
		this.add(timer);
		this.add(panel2);
		this.add(npc);
		this.setSize(900, 600);
		this.setLayout(null);
		this.setBackground(Color.gray);
		this.add(title);
		this.add(result);
		this.add(munjae);
		this.add(button);
		this.add(button2);
		
		//성공했을 때 대화화면으로 가기
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameSave save = new GameSave();
				save.save(dif.p, dif);
				System.out.println("틀린그림찾기 성공! 대화화면으로 넘어갑니다.");
				mf.getContentPane().removeAll(); //꼭 패널을 다 지워야만 넘어갈까..
				System.out.println("전부다 지웠습니다.");
				ChangePanel.changePanel(mf, ds, 
						new Talk4(mf, dif.p));
			}
		});
		
		//실패했을 때 대화내용으로 가기(수정필요)
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameSave save = new GameSave();
				save.save(dif.p, dif);
				
				System.out.println("틀린그림찾기 실패! 대화화면으로 넘어갑니다.");
				mf.getContentPane().removeAll();
				System.out.println("전부다 지웠습니다.");
				ChangePanel.changePanel(mf, ds, 
						new Talk3(mf, dif.p));
			}
		});
		
		mf.add(this);
	}
	
	
	
	public boolean range(int index, Point p) {
		
		int pointX = p.x;
		int pointY = p.y;
		
		return (pointX >=x[index]-xRange) && (pointX <=x[index]+xRange)
				&& (pointY >=y[index]-yRange) && (pointY <=y[index]+yRange);
	}
	
	
	
	
	class CustomMouseAdapter extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();
			
			if(range(0,p)) {
				DifferenceSpot.spot1 = true;
				munjae.repaint();
				result.setText("정답입니다!!");
			} else if(range(1,p)) {
				DifferenceSpot.spot2 = true;
				munjae.repaint();
				result.setText("정답입니다!!");
			}else if(range(2,p)) {
				DifferenceSpot.spot3 = true;
				munjae.repaint();
				result.setText("정답입니다!!");
			}else {
				life--;
				if(life == 2) {
					life1.setVisible(false);
				}else if(life == 1) {
					life2.setVisible(false);
				}else if(life == 0) {
					life3.setVisible(false);
				}
			}
			
			if(spot1 == true && spot2 == true && spot3 == true) {
				button.setVisible(true);
			}else if(life == 0) {
				button2.setVisible(true);
			}
			
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("X : " + e.getX() + " Y : " + e.getY());
		}
		
	}
	
	public JButton getButton2() {
		return button2;
	}

}























