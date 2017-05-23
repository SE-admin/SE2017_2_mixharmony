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
	private JTextField Login_Tf;
	private JTextField Id_Tf;
	private JTextField Id_In;
	private JTextField Password_Tf;
	private JPasswordField Password_In;


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
		
		JLabel Login_Img = new JLabel("");
		Login_Img.setIcon(new ImageIcon(LOGIN.class.getResource("/image/\uD559\uAD50\uBA85.jpg")));
		Login_Img.setBounds(17, 27, 52, 41);
		contentPane.add(Login_Img);
		
		Login_Tf = new JTextField();
		Login_Tf.setFont(Login_Tf.getFont().deriveFont(Login_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Login_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Login_Tf.setForeground(new Color(255, 255, 255));
		Login_Tf.setBackground(new Color(0, 0, 128));
		Login_Tf.setText("학교명");
		Login_Tf.setBounds(102, 22, 156, 46);
		contentPane.add(Login_Tf);
		Login_Tf.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox Login_In = new JComboBox();
		Login_In.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Login_In.setEditable(true);
		Login_In.setBounds(17, 83, 473, 41);
		contentPane.add(Login_In);
		
		JLabel Id_Img = new JLabel("");
		Id_Img.setIcon(new ImageIcon(LOGIN.class.getResource("/image/free-vector-business-people-icons-22530 - \uBCF5\uC0AC\uBCF8-iloveimg-resized.jpg")));
		Id_Img.setBounds(17, 139, 52, 41);
		contentPane.add(Id_Img);
		
		Id_Tf = new JTextField();
		Id_Tf.setText("학번");
		Id_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Id_Tf.setForeground(Color.WHITE);
		Id_Tf.setFont(Id_Tf.getFont().deriveFont(Id_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Id_Tf.setColumns(10);
		Id_Tf.setBackground(new Color(0, 0, 128));
		Id_Tf.setBounds(102, 139, 156, 46);
		contentPane.add(Id_Tf);
		
		Id_In = new JTextField();
		Id_In.setText("");
		Id_In.setBounds(17, 201, 473, 41);
		contentPane.add(Id_In);
		Id_In.setColumns(10);
		
		JLabel Password_Img = new JLabel("");
		Password_Img.setIcon(new ImageIcon(LOGIN.class.getResource("/image/ilovepdf_com.png")));
		Password_Img.setBounds(17, 257, 52, 41);
		contentPane.add(Password_Img);
		
		Password_Tf = new JTextField();
		Password_Tf.setText("비밀번호");
		Password_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Password_Tf.setForeground(Color.WHITE);
		Password_Tf.setFont(Password_Tf.getFont().deriveFont(Password_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Password_Tf.setColumns(10);
		Password_Tf.setBackground(new Color(0, 0, 128));
		Password_Tf.setBounds(102, 257, 156, 46);
		contentPane.add(Password_Tf);
		
		Password_In = new JPasswordField();
		Password_In.setText("");
		Password_In.setColumns(10);
		Password_In.setBounds(17, 313, 473, 41);
		contentPane.add(Password_In);
		
		JCheckBox Stay_Login_Btn = new JCheckBox("로그인 상태 유지");
		Stay_Login_Btn.setFont(Stay_Login_Btn.getFont().deriveFont(Stay_Login_Btn.getFont().getStyle() | Font.BOLD, Stay_Login_Btn.getFont().getSize() + 3f));
		Stay_Login_Btn.setBackground(SystemColor.control);
		Stay_Login_Btn.setForeground(Color.DARK_GRAY);
		Stay_Login_Btn.setBounds(17, 377, 241, 41);
		contentPane.add(Stay_Login_Btn);
		
		Button Login_Btn = new Button("로그인");
		Login_Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Login_Btn.setForeground(new Color(255, 255, 255));
		Login_Btn.setFont(new Font("굴림체", Font.BOLD, 18));
		Login_Btn.setBackground(new Color(0, 0, 128));
		Login_Btn.setBounds(338, 425, 146, 41);
		contentPane.add(Login_Btn);
	}
}
