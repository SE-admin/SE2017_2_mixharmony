package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.Button;

public class LOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField textField_4;


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


	public LOGIN() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LOGIN.class.getResource("/image/\uD559\uAD50\uBA85.jpg")));
		lblNewLabel.setBounds(17, 27, 52, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getStyle() | Font.BOLD, 21f));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 0, 128));
		textField.setText("학교명");
		textField.setBounds(102, 22, 156, 46);
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
		comboBox.setBounds(17, 83, 473, 41);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LOGIN.class.getResource("/image/free-vector-business-people-icons-22530 - \uBCF5\uC0AC\uBCF8-iloveimg-resized.jpg")));
		label.setBounds(17, 139, 52, 41);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setText("학번");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(textField_1.getFont().deriveFont(textField_1.getFont().getStyle() | Font.BOLD, 21f));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(0, 0, 128));
		textField_1.setBounds(102, 139, 156, 46);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setBounds(17, 201, 473, 41);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(LOGIN.class.getResource("/image/ilovepdf_com.png")));
		label_1.setBounds(17, 257, 52, 41);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setText("비밀번호");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(textField_3.getFont().deriveFont(textField_3.getFont().getStyle() | Font.BOLD, 21f));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(0, 0, 128));
		textField_3.setBounds(102, 257, 156, 46);
		contentPane.add(textField_3);
		
		textField_4 = new JPasswordField();
		textField_4.setText("");
		textField_4.setColumns(10);
		textField_4.setBounds(17, 313, 473, 41);
		contentPane.add(textField_4);
		
		JCheckBox checkBox = new JCheckBox("로그인 상태 유지");
		checkBox.setFont(checkBox.getFont().deriveFont(checkBox.getFont().getStyle() | Font.BOLD, checkBox.getFont().getSize() + 3f));
		checkBox.setBackground(SystemColor.control);
		checkBox.setForeground(Color.DARK_GRAY);
		checkBox.setBounds(17, 377, 241, 41);
		contentPane.add(checkBox);
		
		Button button = new Button("로그인");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("굴림체", Font.BOLD, 18));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(338, 425, 146, 41);
		contentPane.add(button);
	}
}
