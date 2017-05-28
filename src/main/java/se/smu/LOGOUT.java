package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LOGOUT extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGOUT frame = new LOGOUT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LOGOUT() {
		setTitle("로그아웃");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea Warning_Out = new JTextArea();
		Warning_Out.setBackground(new Color(255, 255, 255));
		Warning_Out.setText("                                          * 경고 *\r\n\r\n           로그아웃을 하면 다음 접속시, 재 로그인을 해야 합니다.\r\n           로그아웃 하시겠습니까?");
		Warning_Out.setToolTipText("");
		Warning_Out.setFont(Warning_Out.getFont().deriveFont(Warning_Out.getFont().getStyle() | Font.BOLD, Warning_Out.getFont().getSize() + 6f));
		Warning_Out.setForeground(new Color(0, 0, 0));
		Warning_Out.setWrapStyleWord(true);
		Warning_Out.setLineWrap(true);
		Warning_Out.setBounds(17, 28, 525, 141);
		contentPane.add(Warning_Out);
		
		JButton Cancel_Btn = new JButton("취소");
		Cancel_Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		Cancel_Btn.setFont(Cancel_Btn.getFont().deriveFont(Cancel_Btn.getFont().getStyle() | Font.BOLD, Cancel_Btn.getFont().getSize() + 2f));
		Cancel_Btn.setBackground(new Color(0, 0, 128));
		Cancel_Btn.setForeground(new Color(255, 255, 255));
		Cancel_Btn.setBounds(221, 198, 136, 33);
		contentPane.add(Cancel_Btn);
		
		JButton Check_Btn = new JButton("확인");
		Check_Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LOGIN Info = new LOGIN();
				Info.setVisible(true);
				dispose();
			}
		});
		Check_Btn.setForeground(Color.WHITE);
		Check_Btn.setFont(Check_Btn.getFont().deriveFont(Check_Btn.getFont().getStyle() | Font.BOLD, Check_Btn.getFont().getSize() + 2f));
		Check_Btn.setBackground(new Color(0, 0, 128));
		Check_Btn.setBounds(406, 198, 136, 33);
		contentPane.add(Check_Btn);
	}
}
