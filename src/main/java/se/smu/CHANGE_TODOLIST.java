package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CHANGE_TODOLIST extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHANGE_TODOLIST frame = new CHANGE_TODOLIST();
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
	public CHANGE_TODOLIST() {
		setTitle("to do 항목 편집");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setText("항목명");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getStyle() | Font.BOLD, 21f));
		textField.setColumns(10);
		textField.setBackground(new Color(0, 0, 128));
		textField.setBounds(86, 15, 156, 46);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(17, 71, 473, 41);
		panel.add(textField_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CHANGE_TODOLIST.class.getResource("/images/imagesK5B499QW.jpg")));
		label.setBounds(17, 15, 52, 41);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CHANGE_TODOLIST.class.getResource("/images/Deadline-Clock.jpg")));
		label_1.setBounds(17, 132, 52, 41);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setText("마감 기한");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(textField_2.getFont().deriveFont(textField_2.getFont().getStyle() | Font.BOLD, 21f));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(0, 0, 128));
		textField_2.setBounds(86, 127, 156, 46);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("월      일         시 까지");
		textField_3.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(textField_3.getFont().deriveFont(textField_3.getFont().getStyle() | Font.BOLD, textField_3.getFont().getSize() + 2f));
		textField_3.setColumns(10);
		textField_3.setBounds(17, 183, 473, 41);
		panel.add(textField_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(CHANGE_TODOLIST.class.getResource("/images/submitalisting.jpg")));
		label_2.setBounds(17, 244, 52, 41);
		panel.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setText("실제 마감일");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(textField_4.getFont().deriveFont(textField_4.getFont().getStyle() | Font.BOLD, 21f));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(0, 0, 128));
		textField_4.setBounds(86, 239, 156, 46);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("월      일         시 ");
		textField_5.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(textField_5.getFont().deriveFont(textField_5.getFont().getStyle() | Font.BOLD, textField_5.getFont().getSize() + 2f));
		textField_5.setColumns(10);
		textField_5.setBounds(17, 299, 473, 41);
		panel.add(textField_5);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(CHANGE_TODOLIST.class.getResource("/images/565112c0bf29a_thumb900.jpg")));
		label_3.setBounds(17, 360, 52, 41);
		panel.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setText("중요도");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(textField_6.getFont().deriveFont(textField_6.getFont().getStyle() | Font.BOLD, 21f));
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(0, 0, 128));
		textField_6.setBounds(86, 355, 156, 46);
		panel.add(textField_6);
		
		JButton button = new JButton("");
		button.setBounds(251, 360, 44, 41);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(301, 360, 44, 41);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(351, 360, 44, 41);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(398, 360, 44, 41);
		panel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBounds(446, 360, 44, 41);
		panel.add(button_4);
		
		JButton button_5 = new JButton("편집 등록");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(button_5.getFont().deriveFont(button_5.getFont().getStyle() | Font.BOLD, button_5.getFont().getSize() + 4f));
		button_5.setBackground(new Color(0, 0, 128));
		button_5.setBounds(351, 433, 139, 42);
		panel.add(button_5);
	}

}
