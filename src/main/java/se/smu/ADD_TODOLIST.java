package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ADD_TODOLIST extends JFrame {

	private final JPanel contentPane;
	private JTextField Itemname_Tf;
	private JTextField Itemname_In;
	private JTextField Deadline_Tf;
	private JTextField Deadline_Mon;
	private JTextField Deadline_Date;
	private JTextField Deadline_Time;
	private JTextField Rdeadline_Tf;
	private JTextField Rdeadline_Mon;
	private JTextField Rdeadline_Date;
	private JTextField Rdeadline_Time;
	private JTextField Importance_Tf;
    private void ViewData(Todo_Dto vTo){
        
        String itemname = vTo.getItemname();
        String deadline = vTo.getDeadline();
        String rdeadline = vTo.getRdeadline();
        String importance = vTo.getImportance();
        String comment = vTo.getComment();
    }




	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADD_TODOLIST frame = new ADD_TODOLIST();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ADD_TODOLIST() {
		setTitle("TO DO 항목 등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		Itemname_Tf = new JTextField();
		Itemname_Tf.setText("항목명");
		Itemname_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Itemname_Tf.setForeground(Color.WHITE);
		Itemname_Tf.setFont(Itemname_Tf.getFont().deriveFont(Itemname_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Itemname_Tf.setColumns(10);
		Itemname_Tf.setBackground(new Color(0, 0, 128));
		Itemname_Tf.setBounds(86, 15, 156, 46);
		contentPane.add(Itemname_Tf);
		
		Itemname_In = new JTextField();
		Itemname_In.setText("");
		Itemname_In.setColumns(10);
		Itemname_In.setBounds(17, 71, 473, 41);
		contentPane.add(Itemname_In);
		
		JLabel Itemname_Img = new JLabel("");
		Itemname_Img.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/imagesK5B499QW.jpg")));
		Itemname_Img.setBounds(17, 15, 52, 41);
		contentPane.add(Itemname_Img);
		
		JLabel Deadline_Img = new JLabel("");
		Deadline_Img.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/Deadline-Clock.jpg")));
		Deadline_Img.setBounds(17, 132, 52, 41);
		contentPane.add(Deadline_Img);
		
		Deadline_Tf = new JTextField();
		Deadline_Tf.setText("마감 기한");
		Deadline_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Deadline_Tf.setForeground(Color.WHITE);
		Deadline_Tf.setFont(Deadline_Tf.getFont().deriveFont(Deadline_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Deadline_Tf.setColumns(10);
		Deadline_Tf.setBackground(new Color(0, 0, 128));
		Deadline_Tf.setBounds(86, 127, 156, 46);
		contentPane.add(Deadline_Tf);
		
		Deadline_Mon = new JTextField();
		Deadline_Mon.setText("");
		Deadline_Mon.setColumns(10);
		Deadline_Mon.setBounds(17, 183, 135, 41);
		contentPane.add(Deadline_Mon);
		
		JLabel Deadline_Mon_Lb = new JLabel("월");
		Deadline_Mon_Lb.setFont(Deadline_Mon_Lb.getFont().deriveFont(Deadline_Mon_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Mon_Lb.setBounds(155, 183, 30, 41);
		contentPane.add(Deadline_Mon_Lb);
		
		Deadline_Date = new JTextField();
		Deadline_Date.setText("");
		Deadline_Date.setColumns(10);
		Deadline_Date.setBounds(180, 183, 135, 41);
		contentPane.add(Deadline_Date);
		
		JLabel Deadline_Date_Lb = new JLabel("일");
		Deadline_Date_Lb.setFont(Deadline_Date_Lb.getFont().deriveFont(Deadline_Date_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Date_Lb.setBounds(318, 188, 30, 30);
		contentPane.add(Deadline_Date_Lb);
		
		Deadline_Time = new JTextField();
		Deadline_Time.setText("");
		Deadline_Time.setColumns(10);
		Deadline_Time.setBounds(343, 183, 135, 41);
		contentPane.add(Deadline_Time);
		
		JLabel Deadline_Time_Lb = new JLabel("시");
		Deadline_Time_Lb.setFont(Deadline_Time_Lb.getFont().deriveFont(Deadline_Time_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Time_Lb.setBounds(481, 188, 30, 30);
		contentPane.add(Deadline_Time_Lb);
	
	
		
		JLabel Rdeadline_Img = new JLabel("");
		Rdeadline_Img.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/submitalisting.jpg")));
		Rdeadline_Img.setBounds(17, 244, 52, 41);
		contentPane.add(Rdeadline_Img);
		
		Rdeadline_Tf = new JTextField();
		Rdeadline_Tf.setText("실제 마감일");
		Rdeadline_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Rdeadline_Tf.setForeground(Color.WHITE);
		Rdeadline_Tf.setFont(Rdeadline_Tf.getFont().deriveFont(Rdeadline_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Rdeadline_Tf.setColumns(10);
		Rdeadline_Tf.setBackground(new Color(0, 0, 128));
		Rdeadline_Tf.setBounds(86, 239, 156, 46);
		contentPane.add(Rdeadline_Tf);
		
		Rdeadline_Mon = new JTextField();
		Rdeadline_Mon.setText("");
		Rdeadline_Mon.setColumns(10);
		Rdeadline_Mon.setBounds(17, 299, 135, 41);
		contentPane.add(Rdeadline_Mon);
		
		JLabel Rdeadline_Mon_Lb = new JLabel("월");
		Rdeadline_Mon_Lb.setFont(Rdeadline_Mon_Lb.getFont().deriveFont(Rdeadline_Mon_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Mon_Lb.setBounds(155, 304, 30, 30);
		contentPane.add(Rdeadline_Mon_Lb);
		
		Rdeadline_Date = new JTextField();
		Rdeadline_Date.setText("");
		Rdeadline_Date.setColumns(10);
		Rdeadline_Date.setBounds(180, 299, 135, 41);
		contentPane.add(Rdeadline_Date);
		
		JLabel Rdeadline_Date_Lb = new JLabel("일");
		Rdeadline_Date_Lb.setFont(Rdeadline_Date_Lb.getFont().deriveFont(Rdeadline_Date_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Date_Lb.setBounds(318, 304, 30, 30);
		contentPane.add(Rdeadline_Date_Lb);

		Rdeadline_Time = new JTextField();
		Rdeadline_Time.setText("");
		Rdeadline_Time.setColumns(10);
		Rdeadline_Time.setBounds(343, 299, 135, 41);
		contentPane.add(Rdeadline_Time);
		
		JLabel Rdeadline_Time_Lb = new JLabel("시");
		Rdeadline_Time_Lb.setFont(Rdeadline_Time_Lb.getFont().deriveFont(Rdeadline_Time_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Time_Lb.setBounds(481, 304, 30, 30);
		contentPane.add(Rdeadline_Time_Lb);
		
		JLabel Importance_Img = new JLabel("");
		Importance_Img.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		Importance_Img.setBounds(17, 360, 52, 41);
		contentPane.add(Importance_Img);
		
		Importance_Tf = new JTextField();
		Importance_Tf.setText("중요도");
		Importance_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Importance_Tf.setForeground(Color.WHITE);
		Importance_Tf.setFont(Importance_Tf.getFont().deriveFont(Importance_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Importance_Tf.setColumns(10);
		Importance_Tf.setBackground(new Color(0, 0, 128));
		Importance_Tf.setBounds(86, 355, 156, 46);
		contentPane.add(Importance_Tf);
		
		JButton Importance_Star_Btn1 = new JButton("");
		Importance_Star_Btn1.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		Importance_Star_Btn1.setBounds(251, 360, 44, 41);
		contentPane.add(Importance_Star_Btn1);
		
		JButton Importance_Star_Btn2 = new JButton("");
		Importance_Star_Btn2.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		Importance_Star_Btn2.setBounds(301, 360, 44, 41);
		contentPane.add(Importance_Star_Btn2);
		
		JButton Importance_Star_Btn3 = new JButton("");
		Importance_Star_Btn3.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		Importance_Star_Btn3.setBounds(351, 360, 44, 41);
		contentPane.add(Importance_Star_Btn3);
		
		JButton Importance_Star_Btn4 = new JButton("");
		Importance_Star_Btn4.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		Importance_Star_Btn4.setBounds(398, 360, 44, 41);
		contentPane.add(Importance_Star_Btn4);
		
		JButton Importance_Star_Btn5 = new JButton("");
		Importance_Star_Btn5.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		Importance_Star_Btn5.setBounds(446, 360, 44, 41);
		contentPane.add(Importance_Star_Btn5);
		
		JButton Signup_Btn = new JButton("등록");
		Signup_Btn.setForeground(Color.WHITE);
		Signup_Btn.setFont(Signup_Btn.getFont().deriveFont(Signup_Btn.getFont().getStyle() | Font.BOLD, Signup_Btn.getFont().getSize() + 4f));
		Signup_Btn.setBackground(new Color(0, 0, 128));
		Signup_Btn.setBounds(372, 433, 118, 42);
		Signup_Btn.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Insert_Todo();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
			contentPane.add(Signup_Btn);
	}
//삽입
	private void Insert_Todo(){
		 Todo_Dto dto = getViewData();
		 Todo_Dao dao = new Todo_Dao();       
		 boolean ok = dao.Insert_Todo(dto);
	}
	public Todo_Dto getViewData() {
		Todo_Dto dto = new Todo_Dto();
		String itemname = Itemname_In.getText();
		String deadline = Deadline_Mon.getText();
		String rdeadline = Rdeadline_Mon.getText();
//		String importance = priority.getText();
//		String comment = textField_10.getText();
		
		
		dto.setItemname(itemname);
		dto.setDeadline(deadline);
		dto.setRdeadline(rdeadline);
//		dto.setImportance(importance);
//		dto.setComment(comment);
	
	return dto;
	}
}

