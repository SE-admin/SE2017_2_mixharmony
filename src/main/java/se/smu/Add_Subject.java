package se.smu;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Add_Subject extends JFrame {

	private JPanel contentPane;
	private JTextField Subject_Tf;
	private JTextField Subject_In;
	private JTextField Professor_Tf;
	private JTextField Professor_In;
	private JTextField Dayofweek_Tf;
	private JTextField Period_Tf;
	private JTextField Dayofweek_In;
	private JTextField Period_In;
	private JTextField Year_Tf;
	private JTextField Semester_Tf;
	private JTextField Year_In;
	private JTextField Semester_In;
	private JTextField Divclass_Tf;
	private JTextField Divclass_In;
	Subject_Management sList;
	
    private void ViewData(Subject_Dto vSub){
       
        String subject = vSub.getSubject();
        String professor = vSub.getProfessor();
        String dayofweek = vSub.getDayofweek();
        String period = vSub.getPeriod();
        String year = vSub.getYear();
        String semester = vSub.getSemester();
        String divclass = vSub.getDivclass();
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Subject frame = new Add_Subject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Add_Subject() {
		
		
		setTitle("수강 과목 등록");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JTable table = sList.Subject_Data_Tb;
		
		
		
		JLabel Subject_Img = new JLabel("");
		Subject_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/untitled.png")));
		Subject_Img.setBounds(28, 15, 52, 41);
		contentPane.add(Subject_Img);
		
		Subject_Tf = new JTextField();
		Subject_Tf.setText("과목명");
		Subject_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Subject_Tf.setForeground(Color.WHITE);
		Subject_Tf.setFont(Subject_Tf.getFont().deriveFont(Subject_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Subject_Tf.setColumns(10);
		Subject_Tf.setBackground(new Color(0, 0, 128));
		Subject_Tf.setBounds(105, 15, 156, 46);
		contentPane.add(Subject_Tf);
		
		Subject_In = new JTextField();
		Subject_In.setText("");
		Subject_In.setColumns(10);
		Subject_In.setBounds(28, 76, 473, 41);
		contentPane.add(Subject_In);
		
		JLabel Professor_Img = new JLabel("");
		Professor_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/imagesASJC4VFF.jpg")));
		Professor_Img.setBounds(28, 139, 52, 41);
		contentPane.add(Professor_Img);
		
		Professor_Tf = new JTextField();
		Professor_Tf.setText("담당 교수");
		Professor_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Professor_Tf.setForeground(Color.WHITE);
		Professor_Tf.setFont(Professor_Tf.getFont().deriveFont(Professor_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Professor_Tf.setColumns(10);
		Professor_Tf.setBackground(new Color(0, 0, 128));
		Professor_Tf.setBounds(105, 134, 156, 46);
		contentPane.add(Professor_Tf);
		
		Professor_In = new JTextField();
		Professor_In.setFont(Professor_In.getFont().deriveFont(Professor_In.getFont().getStyle() | Font.BOLD, Professor_In.getFont().getSize() + 2f));
		Professor_In.setHorizontalAlignment(SwingConstants.RIGHT);
		Professor_In.setText("교수님");
		Professor_In.setColumns(10);
		Professor_In.setBounds(28, 195, 473, 41);
		contentPane.add(Professor_In);
		
		JLabel Dayofweek_Img = new JLabel("");
		Dayofweek_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/imagesL3LZX0G1.jpg")));
		Dayofweek_Img.setBounds(28, 251, 52, 41);
		contentPane.add(Dayofweek_Img);
		
		Dayofweek_Tf = new JTextField();
		Dayofweek_Tf.setText("강의 요일");
		Dayofweek_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Dayofweek_Tf.setForeground(Color.WHITE);
		Dayofweek_Tf.setFont(Dayofweek_Tf.getFont().deriveFont(Dayofweek_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Dayofweek_Tf.setColumns(10);
		Dayofweek_Tf.setBackground(new Color(0, 0, 128));
		Dayofweek_Tf.setBounds(105, 246, 156, 46);
		contentPane.add(Dayofweek_Tf);
		
		JLabel Period_Img = new JLabel("");
		Period_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/imagesL3LZX0G1.jpg")));
		Period_Img.setBounds(287, 251, 52, 41);
		contentPane.add(Period_Img);
		
		Period_Tf = new JTextField();
		Period_Tf.setText("강의 시간");
		Period_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Period_Tf.setForeground(Color.WHITE);
		Period_Tf.setFont(Period_Tf.getFont().deriveFont(Period_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Period_Tf.setColumns(10);
		Period_Tf.setBackground(new Color(0, 0, 128));
		Period_Tf.setBounds(345, 246, 156, 46);
		contentPane.add(Period_Tf);
		
		Dayofweek_In = new JTextField();
		Dayofweek_In.setText("요일");
		Dayofweek_In.setHorizontalAlignment(SwingConstants.RIGHT);
		Dayofweek_In.setFont(Dayofweek_In.getFont().deriveFont(Dayofweek_In.getFont().getStyle() | Font.BOLD, Dayofweek_In.getFont().getSize() + 2f));
		Dayofweek_In.setColumns(10);
		Dayofweek_In.setBounds(28, 307, 231, 41);
		contentPane.add(Dayofweek_In);
		
		Period_In = new JTextField();
		Period_In.setText("교시");
		Period_In.setHorizontalAlignment(SwingConstants.RIGHT);
		Period_In.setFont(Period_In.getFont().deriveFont(Period_In.getFont().getStyle() | Font.BOLD, Period_In.getFont().getSize() + 2f));
		Period_In.setColumns(10);
		Period_In.setBounds(287, 307, 214, 41);
		contentPane.add(Period_In);
		
		JLabel Year_Img = new JLabel("");
		Year_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/calendar-page-en.jpg")));
		Year_Img.setBounds(28, 368, 52, 41);
		contentPane.add(Year_Img);
		
		Year_Tf = new JTextField();
		Year_Tf.setText("강의 년도");
		Year_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Year_Tf.setForeground(Color.WHITE);
		Year_Tf.setFont(Year_Tf.getFont().deriveFont(Year_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Year_Tf.setColumns(10);
		Year_Tf.setBackground(new Color(0, 0, 128));
		Year_Tf.setBounds(105, 363, 156, 46);
		contentPane.add(Year_Tf);
		
		JLabel Semester_Img = new JLabel("");
		Semester_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/calendar-page-en.jpg")));
		Semester_Img.setBounds(287, 363, 52, 41);
		contentPane.add(Semester_Img);
		
		Semester_Tf = new JTextField();
		Semester_Tf.setText("강의 학기");
		Semester_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Semester_Tf.setForeground(Color.WHITE);
		Semester_Tf.setFont(Semester_Tf.getFont().deriveFont(Semester_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Semester_Tf.setColumns(10);
		Semester_Tf.setBackground(new Color(0, 0, 128));
		Semester_Tf.setBounds(345, 363, 156, 46);
		contentPane.add(Semester_Tf);
		
		Year_In = new JTextField();
		Year_In.setText("년도");
		Year_In.setHorizontalAlignment(SwingConstants.RIGHT);
		Year_In.setFont(Year_In.getFont().deriveFont(Year_In.getFont().getStyle() | Font.BOLD, Year_In.getFont().getSize() + 2f));
		Year_In.setColumns(10);
		Year_In.setBounds(28, 424, 231, 41);
		contentPane.add(Year_In);
		
		Semester_In = new JTextField();
		Semester_In.setText("학기");
		Semester_In.setHorizontalAlignment(SwingConstants.RIGHT);
		Semester_In.setFont(Semester_In.getFont().deriveFont(Semester_In.getFont().getStyle() | Font.BOLD, Semester_In.getFont().getSize() + 2f));
		Semester_In.setColumns(10);
		Semester_In.setBounds(287, 424, 214, 41);
		contentPane.add(Semester_In);
		
		JLabel Divclass_Img = new JLabel("");
		Divclass_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/imagesAN6AYLO3.jpg")));
		Divclass_Img.setBounds(28, 480, 52, 41);
		contentPane.add(Divclass_Img);
		
		Divclass_Tf = new JTextField();
		Divclass_Tf.setText("분반");
		Divclass_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Divclass_Tf.setForeground(Color.WHITE);
		Divclass_Tf.setFont(Divclass_Tf.getFont().deriveFont(Divclass_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Divclass_Tf.setColumns(10);
		Divclass_Tf.setBackground(new Color(0, 0, 128));
		Divclass_Tf.setBounds(105, 475, 156, 46);
		contentPane.add(Divclass_Tf);
		
		Divclass_In = new JTextField();
		Divclass_In.setText("분반");
		Divclass_In.setHorizontalAlignment(SwingConstants.RIGHT);
		Divclass_In.setFont(Divclass_In.getFont().deriveFont(Divclass_In.getFont().getStyle() | Font.BOLD, Divclass_In.getFont().getSize() + 2f));
		Divclass_In.setColumns(10);
		Divclass_In.setBounds(287, 480, 214, 41);
		contentPane.add(Divclass_In);
		
		JButton Check_Btn = new JButton("등록 확인");
		Check_Btn.setBackground(new Color(0, 0, 128));
		Check_Btn.setFont(Check_Btn.getFont().deriveFont(Check_Btn.getFont().getStyle() | Font.BOLD, Check_Btn.getFont().getSize() + 4f));
		Check_Btn.setForeground(new Color(255, 255, 255));
		Check_Btn.setBounds(357, 536, 144, 42);
		Check_Btn.addMouseListener(new MouseListener()
				{

					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					
					public void mousePressed(MouseEvent arg0) {	
						/*
						Insert_Subject();	
						dispose();
                        Subject_Management frame = new Subject_Management();  
                        frame.setVisible(true);   
                        */
						//기존 table data delete
						DefaultTableModel model = (DefaultTableModel) table.getModel();
				        for (int i = 0; i < model.getRowCount();) {
				            model.removeRow(0);
				            }
				        //db insert data
				        Insert_Subject();
				        //update table
					    DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				        Subject_Dao dao = new Subject_Dao();
				        dao.userSelectAll(model);
				        //exit add_sub
						dispose();
						
					}

					
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						//sList.jTableRefresh();
						}});
		
		contentPane.add(Check_Btn);
	
	}
	//삽입
	
	private void Insert_Subject(){
		 Subject_Dto dto = getViewData();
	     Subject_Dao dao = new Subject_Dao();       
	     boolean ok = dao.Insert_Subject(dto);
		
	}
	public Subject_Dto getViewData() {
		Subject_Dto dto = new Subject_Dto();
        String subject = Subject_In.getText();
        String professor = Professor_In.getText();
        String dayofweek = Dayofweek_In.getText();
        String period = Period_In.getText();
        String year = Year_In.getText();
        String semester = Semester_In.getText();
        String divclass = Divclass_In.getText();
        
        
        
        dto.setSubject(subject);
        dto.setProfessor(professor);
        dto.setDayofweek(dayofweek);
        dto.setPeriod(period);
        dto.setYear(year);
        dto.setSemester(semester);
        dto.setDivclass(divclass);

       
        return dto;
	}
	
}