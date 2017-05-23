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

public class WARNING extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WARNING frame = new WARNING();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public WARNING() {
		setTitle("경고");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setToolTipText("");
		textArea.setText("                                           * 경 고 *\r\n\r\n                         모든 항목이 채워지지 않았습니다.\r\n");
		textArea.setLineWrap(true);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(textArea.getFont().deriveFont(textArea.getFont().getStyle() | Font.BOLD, textArea.getFont().getSize() + 6f));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(17, 15, 525, 146);
		contentPane.add(textArea);
		
		JButton button = new JButton("확인");
		button.setForeground(Color.WHITE);
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, button.getFont().getSize() + 2f));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(406, 188, 136, 33);
		contentPane.add(button);
	}

}
