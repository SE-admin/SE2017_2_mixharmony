package se.smu;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class SUBJECT_MANAGEMENT extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SUBJECT_MANAGEMENT frame = new SUBJECT_MANAGEMENT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SUBJECT_MANAGEMENT() {
		
		setTitle("수강 과목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SUBJECT_MANAGEMENT.class.getResource("/image/alarm--alarm-icon-91768.png")));
		lblNewLabel.setBounds(392, 15, 50, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(SUBJECT_MANAGEMENT.class.getResource("/image/add.png")));
		btnNewButton.setBounds(51, 81, 368, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("정렬");
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(17, 428, 102, 43);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("로그아웃");
		button.setForeground(Color.WHITE);
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, button.getFont().getSize() + 4f));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(298, 428, 144, 42);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(462, 0, 23, 510);
		contentPane.add(scrollPane);
	}
}
