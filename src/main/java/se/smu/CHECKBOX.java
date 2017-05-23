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
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setToolTipText("");
		textArea.setText("                                           * 확 인 *\r\n\r\n                     모든 항목이 정상적으로 등록되었습니다.");
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
		button.setBounds(399, 188, 136, 33);
		contentPane.add(button);
	}
}
