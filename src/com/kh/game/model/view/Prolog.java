package com.kh.game.model.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.game.model.talk.Talk;

//���ѷα� ȭ�� ����(���� �ʿ�!)
public class Prolog extends JPanel{
	
	private MainFrame mf;
	private JPanel prolog; 
	
	public Prolog(MainFrame mf) {
		this.mf = mf;
		this.prolog = this;
		
		//�г� ����
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);
		
		//��׶��� �̹���
		JLabel backImg = new JLabel(new ImageIcon(new ImageIcon("images/test.jpg")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);
		
		JTextArea ta = new JTextArea("<���ѷα�>\r\n" + 
				"���� 78�� ���� ���� �³�ȭ ����å���� ���ǿ� ������ CW-7�� ���ۿ����� \r\n" + 
				"���ο� ���ϱⰡ ã�ƿ��� �Ǿ���.\r\n" + 
				"������ ����ü�� �� �� ���� Ȥ���� ����� ���� ������.\r\n" + 
				"\r\n" + 
				"CW-7�� ���ۿ��� �����ϴ� ������� ������ ������ ���α׷��ӵ��� �����Ͽ�\r\n" + 
				"������ ���� �ý��� �� �ڿ� ��� �ý���, ���� ���� ���� �� �ڱ����� �ý����� ž����\r\n" + 
				"�� ���� ��ȯ ������ ź�����״�.\r\n" + 
				"\r\n" + 
				"��ΰ� ����ٰ� �������� �� ���� �η��� ���� ������ �Ǿ�����\r\n" + 
				"���ݵ� �����ڵ��� �¿� ������ ������������ ������ �� ���踦 ��ȯ�ϰ� �ִ�.\r\n" + 
				"\r\n" + 
				"20�� ��...\r\n" + 
				"\r\n" + 
				"������ ���������� ������ ö���� �ź������� �����ߴ�.\r\n" + 
				"\r\n" + 
				"���� ���߿� ������� �־��� ���α׷��ӵ��� �Ӹ�ĭ���� ȣȭ�ο� ��Ȱ��..\r\n" + 
				"\r\n" + 
				"���α׷��� ���� ���� ���ϴ� �ڵ��� ����ĭ���� �������� ����....\r\n" + 
				"\r\n" + 
				"�̿� �Ҹ��� ������ �ִ� <���ΰ�>�� �Ӹ�ĭ Żȯ�� ��ǥ�� �ݶ��� �غ��ϰ� �־�����\r\n" + 
				
				"���� ���� �Ǿ���.....\r\n");
		ta.setBounds(120, 50, 650, 430);
	/*	ta.setLocation(40,340);
		ta.setSize(800,150);*/
		ta.setEditable(false);
		
		
		//��ư
		JButton btnStart = new JButton("���� ����");
		btnStart.setBounds(650, 500, 150, 50);
		
		//�гο� �߰�
		this.add(ta);
		this.add(btnStart);
		this.add(backImg);
	
		btnStart.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChangePanel.changePanel(mf, prolog, new Talk(mf, 1));
			}
			
		});
		
		//�����ӿ� �߰�
		mf.add(this);
	} //end method
	
} //end class
