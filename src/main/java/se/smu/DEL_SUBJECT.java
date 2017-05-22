package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.DropMode;

public class DEL_SUBJECT extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DEL_SUBJECT frame = new DEL_SUBJECT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DEL_SUBJECT() {
		setTitle("수강 과목 삭제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setText("                  * 경고 *\r\n\r\n수강과목을 삭제 하시겠습니까?");
		textArea.setToolTipText("");
		textArea.setFont(textArea.getFont().deriveFont(textArea.getFont().getStyle() | Font.BOLD, textArea.getFont().getSize() + 6f));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(17, 28, 525, 146);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("취소");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD, btnNewButton.getFont().getSize() + 2f));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(221, 198, 136, 33);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("확인");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, button.getFont().getSize() + 2f));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(406, 198, 136, 33);
		contentPane.add(button);
	}

}
