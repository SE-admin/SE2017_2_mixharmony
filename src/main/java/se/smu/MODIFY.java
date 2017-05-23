package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class MODIFY extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MODIFY frame = new MODIFY();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MODIFY() {
		setTitle("확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JTextArea Check_Out = new JTextArea();
		Check_Out.setWrapStyleWord(true);
		Check_Out.setToolTipText("");
		Check_Out.setText("                                              * 확 인 *\r\n\r\n                                       정보가 수정됩니다. \r\n                                       수정 하시겠습니까?");
		Check_Out.setLineWrap(true);
		Check_Out.setForeground(Color.BLACK);
		Check_Out.setFont(Check_Out.getFont().deriveFont(Check_Out.getFont().getStyle() | Font.BOLD, Check_Out.getFont().getSize() + 6f));
		Check_Out.setBackground(Color.WHITE);
		Check_Out.setBounds(17, 15, 525, 146);
		contentPane.add(Check_Out);
		
		JButton Cancel_Btn = new JButton("취소");
		Cancel_Btn.setForeground(Color.WHITE);
		Cancel_Btn.setFont(Cancel_Btn.getFont().deriveFont(Cancel_Btn.getFont().getStyle() | Font.BOLD, Cancel_Btn.getFont().getSize() + 2f));
		Cancel_Btn.setBackground(new Color(0, 0, 128));
		Cancel_Btn.setBounds(228, 201, 136, 33);
		contentPane.add(Cancel_Btn);
		
		JButton Check_Btn = new JButton("확인");
		Check_Btn.setForeground(Color.WHITE);
		Check_Btn.setFont(Check_Btn.getFont().deriveFont(Check_Btn.getFont().getStyle() | Font.BOLD, Check_Btn.getFont().getSize() + 2f));
		Check_Btn.setBackground(new Color(0, 0, 128));
		Check_Btn.setBounds(401, 201, 136, 33);
		contentPane.add(Check_Btn);
	}
}
