package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ADD_SUBJECT extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADD_SUBJECT frame = new ADD_SUBJECT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ADD_SUBJECT() {
		setTitle("수강 과목 등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ADD_SUBJECT.class.getResource("/images/untitled.png")));
		label.setBounds(28, 15, 52, 41);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setText("과목명");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getStyle() | Font.BOLD, 21f));
		textField.setColumns(10);
		textField.setBackground(new Color(0, 0, 128));
		textField.setBounds(105, 15, 156, 46);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(28, 76, 473, 41);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ADD_SUBJECT.class.getResource("/images/imagesASJC4VFF.jpg")));
		label_1.setBounds(28, 139, 52, 41);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setText("담당 교수");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(textField_2.getFont().deriveFont(textField_2.getFont().getStyle() | Font.BOLD, 21f));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(0, 0, 128));
		textField_2.setBounds(105, 132, 156, 46);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(textField_3.getFont().deriveFont(textField_3.getFont().getStyle() | Font.BOLD, textField_3.getFont().getSize() + 2f));
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setText("교수님");
		textField_3.setColumns(10);
		textField_3.setBounds(28, 195, 473, 41);
		contentPane.add(textField_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ADD_SUBJECT.class.getResource("/images/imagesL3LZX0G1.jpg")));
		label_2.setBounds(28, 251, 52, 41);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setText("강의 요일");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(textField_4.getFont().deriveFont(textField_4.getFont().getStyle() | Font.BOLD, 21f));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(0, 0, 128));
		textField_4.setBounds(105, 246, 156, 46);
		contentPane.add(textField_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ADD_SUBJECT.class.getResource("/images/imagesL3LZX0G1.jpg")));
		label_3.setBounds(287, 251, 52, 41);
		contentPane.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setText("강의 시간");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(textField_5.getFont().deriveFont(textField_5.getFont().getStyle() | Font.BOLD, 21f));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(0, 0, 128));
		textField_5.setBounds(345, 246, 156, 46);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("요일");
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_6.setFont(textField_6.getFont().deriveFont(textField_6.getFont().getStyle() | Font.BOLD, textField_6.getFont().getSize() + 2f));
		textField_6.setColumns(10);
		textField_6.setBounds(28, 307, 231, 41);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("교시");
		textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_7.setFont(textField_7.getFont().deriveFont(textField_7.getFont().getStyle() | Font.BOLD, textField_7.getFont().getSize() + 2f));
		textField_7.setColumns(10);
		textField_7.setBounds(287, 307, 214, 41);
		contentPane.add(textField_7);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(ADD_SUBJECT.class.getResource("/images/calendar-page-en.jpg")));
		label_4.setBounds(28, 368, 52, 41);
		contentPane.add(label_4);
		
		textField_8 = new JTextField();
		textField_8.setText("강의 년도");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(textField_8.getFont().deriveFont(textField_8.getFont().getStyle() | Font.BOLD, 21f));
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(0, 0, 128));
		textField_8.setBounds(105, 363, 156, 46);
		contentPane.add(textField_8);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(ADD_SUBJECT.class.getResource("/images/calendar-page-en.jpg")));
		label_5.setBounds(287, 363, 52, 41);
		contentPane.add(label_5);
		
		textField_9 = new JTextField();
		textField_9.setText("강의 학기");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setForeground(Color.WHITE);
		textField_9.setFont(textField_9.getFont().deriveFont(textField_9.getFont().getStyle() | Font.BOLD, 21f));
		textField_9.setColumns(10);
		textField_9.setBackground(new Color(0, 0, 128));
		textField_9.setBounds(345, 363, 156, 46);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("년도");
		textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_10.setFont(textField_10.getFont().deriveFont(textField_10.getFont().getStyle() | Font.BOLD, textField_10.getFont().getSize() + 2f));
		textField_10.setColumns(10);
		textField_10.setBounds(28, 424, 231, 41);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("학기");
		textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_11.setFont(textField_11.getFont().deriveFont(textField_11.getFont().getStyle() | Font.BOLD, textField_11.getFont().getSize() + 2f));
		textField_11.setColumns(10);
		textField_11.setBounds(287, 424, 214, 41);
		contentPane.add(textField_11);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(ADD_SUBJECT.class.getResource("/images/imagesAN6AYLO3.jpg")));
		label_6.setBounds(28, 480, 52, 41);
		contentPane.add(label_6);
		
		textField_12 = new JTextField();
		textField_12.setText("분반");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setForeground(Color.WHITE);
		textField_12.setFont(textField_12.getFont().deriveFont(textField_12.getFont().getStyle() | Font.BOLD, 21f));
		textField_12.setColumns(10);
		textField_12.setBackground(new Color(0, 0, 128));
		textField_12.setBounds(105, 475, 156, 46);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("분반");
		textField_13.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_13.setFont(textField_13.getFont().deriveFont(textField_13.getFont().getStyle() | Font.BOLD, textField_13.getFont().getSize() + 2f));
		textField_13.setColumns(10);
		textField_13.setBounds(287, 480, 214, 41);
		contentPane.add(textField_13);
		
		JButton btnNewButton = new JButton("등록 확인");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD, btnNewButton.getFont().getSize() + 4f));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(357, 536, 144, 42);
		contentPane.add(btnNewButton);
	}

}
