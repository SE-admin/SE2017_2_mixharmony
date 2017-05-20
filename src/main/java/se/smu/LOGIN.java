package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class LOGIN extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField textField_4;
	private JLabel lblNewLabel;
	
	public LOGIN() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(0, 0, 128));
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getStyle() | Font.BOLD, 18f));
		textField.setForeground(Color.WHITE);
		textField.setText("학교명");
		textField.setBounds(75, 26, 156, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		comboBox.setEditable(true);
		comboBox.setBounds(17, 81, 459, 40);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("학번");
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
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText("비밀번호");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(textField_3.getFont().deriveFont(textField_3.getFont().getStyle() | Font.BOLD, 18f));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(0, 0, 128));
		textField_3.setBounds(75, 257, 156, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JPasswordField();
		textField_4.setColumns(10);
		textField_4.setBounds(17, 312, 459, 40);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD, btnNewButton.getFont().getSize() + 2f));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(329, 403, 136, 40);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("로그인 상태 유지");
		chckbxNewCheckBox.setFont(chckbxNewCheckBox.getFont().deriveFont(chckbxNewCheckBox.getFont().getStyle() | Font.BOLD, chckbxNewCheckBox.getFont().getSize() + 3f));
		chckbxNewCheckBox.setBounds(17, 373, 199, 40);
		contentPane.add(chckbxNewCheckBox);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(17, 26, 51, 40);
		contentPane.add(lblNewLabel);
		

	}
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
}
