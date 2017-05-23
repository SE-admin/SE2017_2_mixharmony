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
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setToolTipText("");
		textArea.setText("                                              * 확 인 *\r\n\r\n                                       정보가 수정됩니다. \r\n                                       수정 하시겠습니까?");
		textArea.setLineWrap(true);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(textArea.getFont().deriveFont(textArea.getFont().getStyle() | Font.BOLD, textArea.getFont().getSize() + 6f));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(17, 15, 525, 146);
		contentPane.add(textArea);
		
		JButton button = new JButton("취소");
		button.setForeground(Color.WHITE);
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, button.getFont().getSize() + 2f));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(228, 201, 136, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("확인");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(button_1.getFont().deriveFont(button_1.getFont().getStyle() | Font.BOLD, button_1.getFont().getSize() + 2f));
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setBounds(401, 201, 136, 33);
		contentPane.add(button_1);
	}
}
