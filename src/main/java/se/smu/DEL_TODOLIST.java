package java.se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DEL_TODOLIST extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DEL_TODOLIST frame = new DEL_TODOLIST();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DEL_TODOLIST() {
		setTitle("TO DO 항목 삭제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setToolTipText("");
		textArea.setText("                  * 경고 *\r\n\r\nTO DO 항목을 삭제 하시겠습니까?");
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
		button.setBounds(240, 196, 136, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("확인");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(button_1.getFont().deriveFont(button_1.getFont().getStyle() | Font.BOLD, button_1.getFont().getSize() + 2f));
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setBounds(406, 196, 136, 33);
		contentPane.add(button_1);
	}
}
