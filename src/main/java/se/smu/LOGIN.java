package se.smu;

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
import se.smu.Subject_Management;

public class LOGIN extends JFrame {

	private JPanel contentPane;
	private JLabel School_Tf;
	private JTextField Id_In;
	private JLabel Password_Tf;
	private JComboBox Select_School_Btn;
	private JButton Login_Btn;
	private JCheckBox Stay_Login_Btn;
	private JLabel Id_Tf;
	private JPasswordField Password_In;
	private static final String DRIVER
    = "org.mariadb.jdbc.Driver";
    private static final String URL
    = "jdbc:mariadb://211.253.25.2:3306/Mixharmony";

   private static final String USER = "user"; //DB ID
   private static final String PASS = "1234"; //DB 패스워드
   private JPanel Panel_School;
   private JPanel Panel_Id;
   private JPanel Panel_Password;

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

	
	@SuppressWarnings("unchecked")
	public LOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("로그인");
		
		Panel_School = new JPanel();
		Panel_School.setBackground(new Color(0, 0, 128));
		Panel_School.setBounds(102, 22, 156, 46);
		contentPane.add(Panel_School);
		Panel_School.setLayout(null);
		
		School_Tf = new JLabel();
		School_Tf.setBounds(0, 0, 156, 46);
		Panel_School.add(School_Tf);
		School_Tf.setFont(School_Tf.getFont().deriveFont(School_Tf.getFont().getStyle() | Font.BOLD, 21f));
		School_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		School_Tf.setForeground(new Color(255, 255, 255));
		School_Tf.setBackground(new Color(0, 0, 128));
		School_Tf.setText("학교명");
				
		Id_In = new JTextField();
		Id_In.setBounds(17, 201, 473, 41);
		contentPane.add(Id_In);
		Id_In.setColumns(10);
		
		Panel_Password = new JPanel();
		Panel_Password.setBackground(new Color(0, 0, 128));
		Panel_Password.setBounds(102, 257, 156, 46);
		contentPane.add(Panel_Password);
		Panel_Password.setLayout(null);
		
		Password_Tf = new JLabel();
		Password_Tf.setBounds(0, 0, 156, 46);
		Panel_Password.add(Password_Tf);
		Password_Tf.setText("비밀번호");
		Password_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Password_Tf.setForeground(Color.WHITE);
		Password_Tf.setFont(Password_Tf.getFont().deriveFont(Password_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Password_Tf.setBackground(new Color(0, 0, 128));
		
		Select_School_Btn = new JComboBox();
		Select_School_Btn.setModel(new DefaultComboBoxModel(new String[] {"상명대학교(서울)", "상명대학교(천안)", "국민대학교", "단국대학교", "광운대학교", "홍익대학교", "경희대학교", "중앙대학교", "이화여자대학교"}));
		Select_School_Btn.setBounds(17, 87, 473, 41);
		contentPane.add(Select_School_Btn);
		
		Login_Btn = new JButton("로그인");
		Login_Btn.addActionListener(new ActionListener() {
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
				String s1 = Id_In.getText(); //textField input value
				String s2 = Password_In.getText(); //password field input value
				String s3 = Select_School_Btn.getSelectedItem().toString(); //comboBox select value
					
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
        	Login_Btn.setForeground(new Color(255, 255, 255));
        	Login_Btn.setFont(new Font("굴림체", Font.BOLD, 18));
        	Login_Btn.setBackground(new Color(0, 0, 128));
		Login_Btn.setBounds(338, 425, 146, 41);
		contentPane.add(Login_Btn);
		
		Stay_Login_Btn = new JCheckBox("로그인 상태 유지");
		Stay_Login_Btn.setFont(Stay_Login_Btn.getFont().deriveFont(Stay_Login_Btn.getFont().getStyle() | Font.BOLD, Stay_Login_Btn.getFont().getSize() + 3f));
		Stay_Login_Btn.setBackground(SystemColor.control);
		Stay_Login_Btn.setForeground(Color.DARK_GRAY);
		Stay_Login_Btn.setBounds(17, 377, 241, 41);
		contentPane.add(Stay_Login_Btn);
		
		JLabel School_Img = new JLabel("");
                School_Img.setIcon(new ImageIcon(LOGIN.class.getResource("/image/\uD559\uAD50\uBA85.jpg")));
		School_Img.setBounds(17, 27, 52, 41);
		contentPane.add(School_Img);
		
		JLabel Id_Img = new JLabel("");
                Id_Img.setIcon(new ImageIcon(LOGIN.class.getResource("/image/free-vector-business-people-icons-22530 - \uBCF5\uC0AC\uBCF8-iloveimg-resized.jpg")));
		Id_Img.setBounds(17, 139, 52, 41);
		contentPane.add(Id_Img);
		
		JLabel Password_Img = new JLabel("");
		Password_Img.setIcon(new ImageIcon(LOGIN.class.getResource("/image/ilovepdf_com.png")));
		Password_Img.setBounds(17, 257, 52, 41);
		contentPane.add(Password_Img);
		
		Panel_Id = new JPanel();
		Panel_Id.setBackground(new Color(0, 0, 128));
		Panel_Id.setBounds(102, 139, 156, 46);
		contentPane.add(Panel_Id);
		Panel_Id.setLayout(null);
		
		Id_Tf = new JLabel();
		Id_Tf.setBounds(0, 0, 156, 46);
		Panel_Id.add(Id_Tf);
		Id_Tf.setText("학번");
		Id_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Id_Tf.setForeground(Color.WHITE);
		Id_Tf.setFont(Id_In.getFont().deriveFont(Id_In.getFont().getStyle() | Font.BOLD, 21f));
		Id_Tf.setBackground(new Color(0, 0, 128));
		
		Password_In = new JPasswordField();
		Password_In.setBounds(17, 313, 473, 41);
		contentPane.add(Password_In);
	}
}
