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

@SuppressWarnings("serial")
public class Change_Todolist extends JFrame {

	private JPanel contentPane;
	private JTextField Itemname_Tf;
	private JTextField Itemname_In;
	private JTextField Deadline_Tf;
	private JTextField Rdeadline_Tf;
	private JTextField Importance_Tf;
	private JTextField Deadline_Mon;
	private JTextField Deadline_Date;
	private JTextField Deadline_Time;
	private JTextField Rdeadline_Mon;
	private JTextField Rdeadline_Date;
	private JTextField Rdeadline_Time;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_Todolist frame = new Change_Todolist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Change_Todolist() {
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
		
		Itemname_Tf = new JTextField();
		Itemname_Tf.setText("항목명");
		Itemname_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Itemname_Tf.setForeground(Color.WHITE);
		Itemname_Tf.setFont(Itemname_Tf.getFont().deriveFont(Itemname_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Itemname_Tf.setColumns(10);
		Itemname_Tf.setBackground(new Color(0, 0, 128));
		Itemname_Tf.setBounds(86, 15, 156, 46);
		panel.add(Itemname_Tf);
		
		Itemname_In = new JTextField();
		Itemname_In.setText("");
		Itemname_In.setColumns(10);
		Itemname_In.setBounds(17, 71, 473, 41);
		panel.add(Itemname_In);
		
		JLabel Itemname_Img = new JLabel("");
		Itemname_Img.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/imagesK5B499QW.jpg")));
		Itemname_Img.setBounds(17, 15, 52, 41);
		panel.add(Itemname_Img);
		
		JLabel Deadline_Img = new JLabel("");
		Deadline_Img.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/Deadline-Clock.jpg")));
		Deadline_Img.setBounds(17, 132, 52, 41);
		panel.add(Deadline_Img);
		
		Deadline_Tf = new JTextField();
		Deadline_Tf.setText("마감 기한");
		Deadline_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Deadline_Tf.setForeground(Color.WHITE);
		Deadline_Tf.setFont(Deadline_Tf.getFont().deriveFont(Deadline_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Deadline_Tf.setColumns(10);
		Deadline_Tf.setBackground(new Color(0, 0, 128));
		Deadline_Tf.setBounds(86, 127, 156, 46);
		panel.add(Deadline_Tf);
		
		JLabel Rdeadline_Img = new JLabel("");
		Rdeadline_Img.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/submitalisting.jpg")));
		Rdeadline_Img.setBounds(17, 244, 52, 41);
		panel.add(Rdeadline_Img);
		
		Rdeadline_Tf = new JTextField();
		Rdeadline_Tf.setText("실제 마감일");
		Rdeadline_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Rdeadline_Tf.setForeground(Color.WHITE);
		Rdeadline_Tf.setFont(Rdeadline_Tf.getFont().deriveFont(Rdeadline_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Rdeadline_Tf.setColumns(10);
		Rdeadline_Tf.setBackground(new Color(0, 0, 128));
		Rdeadline_Tf.setBounds(86, 239, 156, 46);
		panel.add(Rdeadline_Tf);
		
		JLabel Importance_Img = new JLabel("");
		Importance_Img.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		Importance_Img.setBounds(17, 360, 52, 41);
		panel.add(Importance_Img);
		
		Importance_Tf = new JTextField();
		Importance_Tf.setText("중요도");
		Importance_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Importance_Tf.setForeground(Color.WHITE);
		Importance_Tf.setFont(Importance_Tf.getFont().deriveFont(Importance_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Importance_Tf.setColumns(10);
		Importance_Tf.setBackground(new Color(0, 0, 128));
		Importance_Tf.setBounds(86, 355, 156, 46);
		panel.add(Importance_Tf);
		
		JButton Importance_Star_Btn1 = new JButton("");
		Importance_Star_Btn1.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn1.setBounds(251, 360, 44, 41);
		panel.add(Importance_Star_Btn1);
		
		JButton Importance_Star_Btn2 = new JButton("");
		Importance_Star_Btn2.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn2.setBounds(301, 360, 44, 41);
		panel.add(Importance_Star_Btn2);
		
		JButton Importance_Star_Btn3 = new JButton("");
		Importance_Star_Btn3.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn3.setBounds(351, 360, 44, 41);
		panel.add(Importance_Star_Btn3);
		
		JButton Importance_Star_Btn4 = new JButton("");
		Importance_Star_Btn4.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn4.setBounds(398, 360, 44, 41);
		panel.add(Importance_Star_Btn4);
		
		JButton Importance_Star_Btn5 = new JButton("");
		Importance_Star_Btn5.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn5.setBounds(446, 360, 44, 41);
		panel.add(Importance_Star_Btn5);
		
		JButton Signup_Btn = new JButton("편집 등록");
		Signup_Btn.setForeground(Color.WHITE);
		Signup_Btn.setFont(Signup_Btn.getFont().deriveFont(Signup_Btn.getFont().getStyle() | Font.BOLD, Signup_Btn.getFont().getSize() + 4f));
		Signup_Btn.setBackground(new Color(0, 0, 128));
		Signup_Btn.setBounds(351, 433, 139, 42);
		panel.add(Signup_Btn);
		
		Deadline_Mon = new JTextField();
		Deadline_Mon.setText("");
		Deadline_Mon.setColumns(10);
		Deadline_Mon.setBounds(17, 188, 135, 41);
		panel.add(Deadline_Mon);
		
		JLabel Deadline_Mon_Lb = new JLabel("월");
		Deadline_Mon_Lb.setFont(Deadline_Mon_Lb.getFont().deriveFont(Deadline_Mon_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Mon_Lb.setBounds(156, 188, 30, 41);
		panel.add(Deadline_Mon_Lb);
		
		Deadline_Date = new JTextField();
		Deadline_Date.setText("");
		Deadline_Date.setColumns(10);
		Deadline_Date.setBounds(181, 188, 135, 41);
		panel.add(Deadline_Date);
		
		JLabel Deadline_Date_Lb = new JLabel("일");
		Deadline_Date_Lb.setFont(Deadline_Date_Lb.getFont().deriveFont(Deadline_Date_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Date_Lb.setBounds(318, 193, 30, 30);
		panel.add(Deadline_Date_Lb);
		
		Deadline_Time = new JTextField();
		Deadline_Time.setText("");
		Deadline_Time.setColumns(10);
		Deadline_Time.setBounds(340, 188, 135, 41);
		panel.add(Deadline_Time);
		
		JLabel Deadline_Time_Lb = new JLabel("시");
		Deadline_Time_Lb.setFont(Deadline_Time_Lb.getFont().deriveFont(Deadline_Time_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Time_Lb.setBounds(473, 193, 30, 30);
		panel.add(Deadline_Time_Lb);
		
		Rdeadline_Mon = new JTextField();
		Rdeadline_Mon.setText("");
		Rdeadline_Mon.setColumns(10);
		Rdeadline_Mon.setBounds(17, 299, 135, 41);
		panel.add(Rdeadline_Mon);
		
		JLabel Rdeadline_Mon_Lb = new JLabel("월");
		Rdeadline_Mon_Lb.setFont(Rdeadline_Mon_Lb.getFont().deriveFont(Rdeadline_Mon_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Mon_Lb.setBounds(156, 300, 30, 41);
		panel.add(Rdeadline_Mon_Lb);
		
		Rdeadline_Date = new JTextField();
		Rdeadline_Date.setText("");
		Rdeadline_Date.setColumns(10);
		Rdeadline_Date.setBounds(181, 300, 135, 41);
		panel.add(Rdeadline_Date);
		
		JLabel Rdeadline_Date_Lb = new JLabel("일");
		Rdeadline_Date_Lb.setFont(Rdeadline_Date_Lb.getFont().deriveFont(Rdeadline_Date_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Date_Lb.setBounds(318, 304, 30, 30);
		panel.add(Rdeadline_Date_Lb);
		
		Rdeadline_Time = new JTextField();
		Rdeadline_Time.setText("");
		Rdeadline_Time.setColumns(10);
		Rdeadline_Time.setBounds(340, 299, 135, 41);
		panel.add(Rdeadline_Time);
		
		JLabel Rdeadline_Time_Lb = new JLabel("시");
		Rdeadline_Time_Lb.setFont(Rdeadline_Time_Lb.getFont().deriveFont(Rdeadline_Time_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Time_Lb.setBounds(473, 304, 30, 30);
		panel.add(Rdeadline_Time_Lb);
	}
}
