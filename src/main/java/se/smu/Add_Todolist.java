package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import se.smu.Add_Todolist;
//import se.smu.Add_Todolist.Star_Listener;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Add_Todolist extends JFrame {

	private JPanel contentPane;
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
	private JTextField Subject_Name;
	private int choose_importance = 0;
	private JButton Importance_Star_Btn[] = new JButton[5];
	JButton Signup_Btn; /////
	
    private void ViewData(Todo_Dto vTo){
        
        String itemname = vTo.getItemname();
        String deadline = vTo.getDeadline();
        String rdeadline = vTo.getRdeadline();
        String importance = vTo.getImportance();
//      String subject = vTo.getSubject();
    }

//////////////생성자
//    public Add_Todolist(String itemname, String deadline, String rdeadline, String importance){
//    	Signup_Btn.setEnabled(false);
//    	Signup_Btn.setVisible(false);
//    	
//    	Todo_Dao dao = new Todo_Dao();
//    	Todo_Dto vTo = dao.getTodo_DtO(itemname);
//    	ViewData(vTo);
//    }
    

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Todolist frame = new Add_Todolist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	class Star_Listener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			for(int i=0;i<Importance_Star_Btn.length;i++){
				Importance_Star_Btn[i].setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/star.png")));
			}
			for(int i=0;i<Importance_Star_Btn.length;i++){
				if(e.getSource() ==Importance_Star_Btn[i]){
					choose_importance = i+1;
					for(int j=0;j<=i;j++)
						Importance_Star_Btn[j].setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
				}
			}
		}
	}

	public Add_Todolist() {
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
		Itemname_Img.setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/imagesK5B499QW.jpg")));
		Itemname_Img.setBounds(17, 15, 52, 41);
		contentPane.add(Itemname_Img);
		
		JLabel Deadline_Img = new JLabel("");
		Deadline_Img.setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/Deadline-Clock.jpg")));
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
		Rdeadline_Img.setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/submitalisting.jpg")));
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
		Importance_Img.setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
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
		
		Star_Listener Star_Listener = new Star_Listener();
		Importance_Star_Btn[0] = new JButton("");
		Importance_Star_Btn[0].setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[0].setBounds(251, 360, 44, 41);
		Importance_Star_Btn[0].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[0]);
		
		Importance_Star_Btn[1] = new JButton("");
		Importance_Star_Btn[1].setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[1].setBounds(301, 360, 44, 41);
		Importance_Star_Btn[1].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[1]);
		
		Importance_Star_Btn[2] = new JButton("");
		Importance_Star_Btn[2].setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[2].setBounds(351, 360, 44, 41);
		Importance_Star_Btn[2].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[2]);
		
		Importance_Star_Btn[3] = new JButton("");
		Importance_Star_Btn[3].setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[3].setBounds(398, 360, 44, 41);
		Importance_Star_Btn[3].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[3]);
		
		Importance_Star_Btn[4] = new JButton("");
		Importance_Star_Btn[4].setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[4].setBounds(446, 360, 44, 41);
		Importance_Star_Btn[4].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[4]);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"소프트웨어공학,"}));
        comboBox.setBounds(17, 455, 218, 30);
        contentPane.add(comboBox);
        
        Subject_Name = new JTextField();
        Subject_Name.setText("과목명선택");
        Subject_Name.setBounds(17, 424, 116, 21);
        contentPane.add(Subject_Name);
        Subject_Name.setColumns(10);
		
		
		Signup_Btn = new JButton("등록");
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
		 Subject_Dao dao2 = new Subject_Dao();
		 boolean ok = dao.Insert_Todo(dto);
	}
	public Todo_Dto getViewData() {
		Todo_Dto dto = new Todo_Dto();
		Subject_Dto dto1 = new Subject_Dto();
		String itemname = Itemname_In.getText();
		String deadline = Deadline_Mon.getText() +"월"+ Deadline_Date.getText()+"일" + Deadline_Time.getText() +"시";
		String rdeadline = Rdeadline_Mon.getText() +"월"+ Rdeadline_Date.getText()+"일" + Rdeadline_Time.getText() +"시";
		String importance = Integer.toString(choose_importance);
//		String subject = JComboBox.getText();
		
		
		dto.setItemname(itemname);
		dto.setDeadline(deadline);
		dto.setRdeadline(rdeadline);
		dto.setImportance(importance);
//		dto.setSubject(subject);
	
	return dto;
	}
}
