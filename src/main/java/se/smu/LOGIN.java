package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;
import javax.swing.DefaultComboBoxModel;
import se.smu.Subject_Management;

public class LOGIN extends JFrame {
//o
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JCheckBox chckbxNewCheckBox;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private static final String DRIVER
    = "org.mariadb.jdbc.Driver";
    private static final String URL
    = "jdbc:mariadb://211.253.25.2:3306/Mixharmony";

   private static final String USER = "user"; //DB ID
   private static final String PASS = "1234"; //DB 패스워드

   public Connection getConn(){
       Connection con = null;
      
       try {
           Class.forName(DRIVER); //1. 드라이버 로딩
           con = DriverManager.getConnection(URL,USER,PASS); //2. 드라이버 연결
          
       } catch (Exception e) {
           e.printStackTrace();
       }
      
       return con;
   }
   
	/**
	 * Launch the application.
	 */
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("로그인");
		
		textField = new JTextField();
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getStyle() | Font.BOLD, 21f));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 0, 128));
		textField.setText("학교명");
		textField.setBounds(102, 22, 156, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		

		
		textField_1 = new JTextField();
		textField_1.setBounds(17, 201, 473, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("비밀번호");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(textField_3.getFont().deriveFont(textField_3.getFont().getStyle() | Font.BOLD, 21f));
		textField_3.setBounds(102, 257, 156, 46);
		textField_3.setBackground(new Color(0, 0, 128));
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"상명대학교", "국민대학교"}));
		comboBox.setBounds(17, 87, 473, 41);
		contentPane.add(comboBox);
		
		btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					//db connect
			        Connection con = null;       //연결
			        PreparedStatement ps = null; //명령
			        ResultSet rs = null;         //결과
					con = getConn();
		                String sql = "select * from userdb";
		                ps = con.prepareStatement(sql);
		                rs = ps.executeQuery();
				String s1 = textField_1.getText(); //textField input value
				String s2 = passwordField.getText(); //password field input value
				String s3 = comboBox.getSelectedItem().toString(); //comboBox select value
					
					while(rs.next())
					{
						if(s1.equals(rs.getString("id")) && s2.equals(rs.getString("pwd")) && s3.equals(rs.getString("sname"))) //compare value
						{
							Subject_Management Info = new Subject_Management(); //act class define
							Info.setVisible(true); //class act
							dispose(); //login section not see
							break;//id,pwd,sname correct 
						}
						else //no correct
						{
							JOptionPane.showMessageDialog(null, "No Correct", "Error", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
					
					
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
				}
			}
		});
        	btnNewButton.setForeground(new Color(255, 255, 255));
        	btnNewButton.setFont(new Font("굴림체", Font.BOLD, 18));
        	btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(338, 425, 146, 41);
		contentPane.add(btnNewButton);
		
		chckbxNewCheckBox = new JCheckBox("로그인 상태 유지");
		chckbxNewCheckBox.setFont(chckbxNewCheckBox.getFont().deriveFont(chckbxNewCheckBox.getFont().getStyle() | Font.BOLD, chckbxNewCheckBox.getFont().getSize() + 3f));
		chckbxNewCheckBox.setBackground(SystemColor.control);
		chckbxNewCheckBox.setForeground(Color.DARK_GRAY);
		chckbxNewCheckBox.setBounds(17, 377, 241, 41);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setIcon(new ImageIcon(LOGIN.class.getResource("/image/\uD559\uAD50\uBA85.jpg")));
		lblNewLabel.setBounds(17, 27, 52, 41);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"상명대학교", "국민대학교"}));
		comboBox_1.setBounds(17, 377, 241, 41);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setIcon(new ImageIcon(LOGIN.class.getResource("/image/free-vector-business-people-icons-22530 - \uBCF5\uC0AC\uBCF8-iloveimg-resized.jpg")));
		lblNewLabel_1.setBounds(17, 139, 52, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LOGIN.class.getResource("/image/ilovepdf_com.png")));
		lblNewLabel_2.setBounds(17, 257, 52, 41);
		contentPane.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setText("학번");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(textField_1.getFont().deriveFont(textField_1.getFont().getStyle() | Font.BOLD, 21f));
		textField_5.setBackground(new Color(0, 0, 128));
		textField_5.setBounds(102, 139, 156, 46);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(17, 313, 473, 41);
		contentPane.add(passwordField);
	}
}
