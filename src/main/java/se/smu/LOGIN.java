package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class LOGIN extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
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
	public LOGIN() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\u1\\Desktop\\1146202131-school-house-clip-art-pictures-image-quotes-at-buzzquotes-com-zrxlal-clipart-iloveimg-resized.jpg"));
		lblNewLabel.setBounds(17, 26, 50, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(0, 0, 128));
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getStyle() | Font.BOLD, 18f));
		textField.setForeground(Color.WHITE);
		textField.setText("       학교명");
		textField.setBounds(75, 26, 156, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(17, 81, 459, 40);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\u1\\Desktop\\free-vector-business-people-icons-22530 - 복사본-iloveimg-resized.jpg"));
		label.setForeground(new Color(0, 0, 128));
		label.setBackground(new Color(0, 0, 128));
		label.setBounds(17, 142, 50, 40);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setText("        학번");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(textField_1.getFont().deriveFont(textField_1.getFont().getStyle() | Font.BOLD, 18f));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(0, 0, 128));
		textField_1.setBounds(75, 142, 156, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(17, 197, 459, 40);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\u1\\Desktop\\잠듬-iloveimg-resized.png"));
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setBackground(new Color(0, 0, 128));
		label_2.setBounds(17, 257, 50, 40);
		contentPane.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setText("     비밀번호");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(textField_3.getFont().deriveFont(textField_3.getFont().getStyle() | Font.BOLD, 18f));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(0, 0, 128));
		textField_3.setBounds(75, 257, 156, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(17, 312, 459, 40);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(17, 379, 28, 27);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1 = new JLabel("로그인 상태 유지");
		lblNewLabel_1.setFont(lblNewLabel_1.getFont().deriveFont(lblNewLabel_1.getFont().getStyle() | Font.BOLD, 18f));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBounds(53, 382, 178, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD, btnNewButton.getFont().getSize() + 2f));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBounds(329, 403, 136, 40);
		contentPane.add(btnNewButton);
	}
}
