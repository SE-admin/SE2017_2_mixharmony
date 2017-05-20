package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.ScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public ADD_SUBJECT() {
		setTitle("수강 과목 등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 15, 51, 42);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\u1\\Downloads\\untitled-iloveimg-resized.png"));
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(0, 0, 128));
		textField.setForeground(new Color(255, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getStyle() | Font.BOLD, textField.getFont().getSize() + 4f));
		textField.setText("과목명");
		textField.setBounds(85, 15, 156, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(17, 72, 518, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\u1\\Downloads\\imagesASJC4VFF-iloveimg-resized.jpg"));
		label.setBounds(18, 125, 50, 40);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setText("담당 교수");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(textField_2.getFont().deriveFont(textField_2.getFont().getStyle() | Font.BOLD, textField_2.getFont().getSize() + 4f));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(0, 0, 128));
		textField_2.setBounds(85, 123, 156, 42);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(textField_3.getFont().deriveFont(textField_3.getFont().getStyle() | Font.BOLD, textField_3.getFont().getSize() + 4f));
		textField_3.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_3.setText("교수님");
		textField_3.setColumns(10);
		textField_3.setBounds(17, 180, 518, 38);
		contentPane.add(textField_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\u1\\Downloads\\imagesL3LZX0G1-iloveimg-resized.jpg"));
		label_1.setBounds(18, 233, 50, 40);
		contentPane.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setText("강의 요일");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(textField_4.getFont().deriveFont(textField_4.getFont().getStyle() | Font.BOLD, textField_4.getFont().getSize() + 4f));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(0, 0, 128));
		textField_4.setBounds(85, 233, 156, 42);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("요일");
		textField_5.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_5.setFont(textField_5.getFont().deriveFont(textField_5.getFont().getStyle() | Font.BOLD, textField_5.getFont().getSize() + 4f));
		textField_5.setColumns(10);
		textField_5.setBounds(17, 288, 225, 38);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("강의 시간");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(textField_6.getFont().deriveFont(textField_6.getFont().getStyle() | Font.BOLD, textField_6.getFont().getSize() + 4f));
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(0, 0, 128));
		textField_6.setBounds(379, 233, 156, 42);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("교시");
		textField_7.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_7.setFont(textField_7.getFont().deriveFont(textField_7.getFont().getStyle() | Font.BOLD, textField_7.getFont().getSize() + 4f));
		textField_7.setColumns(10);
		textField_7.setBounds(310, 288, 225, 38);
		contentPane.add(textField_7);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\u1\\Downloads\\imagesL3LZX0G1-iloveimg-resized.jpg"));
		label_2.setBounds(312, 233, 50, 40);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\u1\\Downloads\\images24QP25ES-iloveimg-resized.jpg"));
		label_3.setBounds(17, 341, 50, 40);
		contentPane.add(label_3);
		
		textField_8 = new JTextField();
		textField_8.setText("강의 년도");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(textField_8.getFont().deriveFont(textField_8.getFont().getStyle() | Font.BOLD, textField_8.getFont().getSize() + 4f));
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(0, 0, 128));
		textField_8.setBounds(85, 339, 156, 42);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("년도");
		textField_9.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_9.setFont(textField_9.getFont().deriveFont(textField_9.getFont().getStyle() | Font.BOLD, textField_9.getFont().getSize() + 4f));
		textField_9.setColumns(10);
		textField_9.setBounds(17, 396, 225, 38);
		contentPane.add(textField_9);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\u1\\Downloads\\images24QP25ES-iloveimg-resized.jpg"));
		label_4.setBounds(310, 341, 50, 40);
		contentPane.add(label_4);
		
		textField_10 = new JTextField();
		textField_10.setText("강의 학기");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(textField_10.getFont().deriveFont(textField_10.getFont().getStyle() | Font.BOLD, textField_10.getFont().getSize() + 4f));
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(0, 0, 128));
		textField_10.setBounds(379, 341, 156, 42);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("학기");
		textField_11.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_11.setFont(textField_11.getFont().deriveFont(textField_11.getFont().getStyle() | Font.BOLD, textField_11.getFont().getSize() + 4f));
		textField_11.setColumns(10);
		textField_11.setBounds(310, 396, 225, 38);
		contentPane.add(textField_11);
	}
}
