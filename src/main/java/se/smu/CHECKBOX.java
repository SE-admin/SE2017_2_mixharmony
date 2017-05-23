package se.smu;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;


public class CHECKBOX extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHECKBOX frame = new CHECKBOX();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CHECKBOX() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
		setTitle("확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JTextArea Anounce_Out = new JTextArea();
		Anounce_Out.setWrapStyleWord(true);
		Anounce_Out.setToolTipText("");
		Anounce_Out.setText("                                           * 확 인 *\r\n\r\n                     모든 항목이 정상적으로 등록되었습니다.");
		Anounce_Out.setLineWrap(true);
		Anounce_Out.setForeground(Color.BLACK);
		Anounce_Out.setFont(Anounce_Out.getFont().deriveFont(Anounce_Out.getFont().getStyle() | Font.BOLD, Anounce_Out.getFont().getSize() + 6f));
		Anounce_Out.setBackground(Color.WHITE);
		Anounce_Out.setBounds(17, 15, 525, 146);
		contentPane.add(Anounce_Out);
		
		JButton Check_Btn = new JButton("확인");
		Check_Btn.setForeground(Color.WHITE);
		Check_Btn.setFont(Check_Btn.getFont().deriveFont(Check_Btn.getFont().getStyle() | Font.BOLD, Check_Btn.getFont().getSize() + 2f));
		Check_Btn.setBackground(new Color(0, 0, 128));
		Check_Btn.setBounds(399, 188, 136, 33);
		contentPane.add(Check_Btn);
	}
}
