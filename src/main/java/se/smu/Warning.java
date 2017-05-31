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

public class Warning extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warning frame = new Warning();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Warning() {
		setTitle("경고");
		setBounds(100, 100, 574, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JTextArea Warning_Out = new JTextArea();
		Warning_Out.setToolTipText("");
		Warning_Out.setText("                                           * 경 고 *\r\n\r\n                         모든 항목이 채워지지 않았습니다.\r\n");
		Warning_Out.setLineWrap(true);
		Warning_Out.setEditable(false);
		Warning_Out.setForeground(Color.BLACK);
		Warning_Out.setFont(Warning_Out.getFont().deriveFont(Warning_Out.getFont().getStyle() | Font.BOLD, Warning_Out.getFont().getSize() + 6f));
		Warning_Out.setBackground(Color.WHITE);
		Warning_Out.setBounds(17, 15, 525, 146);
		contentPane.add(Warning_Out);
		
		JButton button = new JButton("확인");
		button.setForeground(Color.WHITE);
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, button.getFont().getSize() + 2f));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(406, 188, 136, 33);
		contentPane.add(button);
	}

}
