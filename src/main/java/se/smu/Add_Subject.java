package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingWorker.StateValue;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;
public class Add_Subject extends JFrame {


	private JLabel Subject_Tf; // 
	private JLabel Professor_Tf;
	private JLabel Year_Tf;
	private JLabel Semester_Tf;
	private JLabel Dayofweek_Tf;
	private JLabel Period_Tf;
	private JLabel Divclass_Tf;
	
	private JComboBox Subject_In;
	private JComboBox Year_In;
	private JComboBox Semester_In;
	private JComboBox Divclass_In;
	private JComboBox Dayofweek_In;
	
	private JTextField Professor_In;
	private JTextField Period_In;

	
	private JPanel contentPane; //내용 패널
	private JPanel Panel_Subject;
	private JPanel Panel_Professor;
	private JPanel Panel_Dayofweek;
	private JPanel Panel_Period;
	private JPanel Panel_Year;
	private JPanel Panel_Semester;
	private JPanel Panel_Divclass;
	
	public static String Subjectcob; //수강과목 box값 받기
	public static String Dayofweekcob;//요일 box값 받기
	public static String Yearcob;//년도 box값 받기
	public static String Semestercob;//학기 box값 받기
	public static String Divclasscob;//분반 box값 받기
	
	//class value
	
	Subject_Management sList;

 private void ViewData(Subject_Dto vSub){
 JScrollPane Dayofweek_Scoll;  
 
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
		setBounds(100, 100, 551, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		final JTable table = sList.Subject_Data_Tb;
		//sort class 선언
		final Sort_Subject ssb = new Sort_Subject();
		
		JLabel Subject_Img = new JLabel("");
		Subject_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/untitled.png")));
		Subject_Img.setBounds(28, 15, 52, 41);
		contentPane.add(Subject_Img);
		
		Panel_Subject = new JPanel();
		Panel_Subject.setBackground(new Color(0, 0, 128));
		Panel_Subject.setBounds(93, 15, 168, 41);
		contentPane.add(Panel_Subject);
		
		Subject_Tf = new JLabel();
		Panel_Subject.add(Subject_Tf);
		Subject_Tf.setText("과목명");
		Subject_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Subject_Tf.setForeground(Color.WHITE);
		Subject_Tf.setFont(Subject_Tf.getFont().deriveFont(Subject_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Subject_Tf.setBackground(new Color(0, 0, 128));
		
		Subject_In = new JComboBox();
		Subject_In.setFont(Subject_In.getFont().deriveFont(Subject_In.getFont().getStyle() | Font.BOLD, 18f));
		Subject_In.setModel(new DefaultComboBoxModel(new String[] {"수강 과목 선택", "소프트웨어 공학", "데이터 베이스", "알고리즘", "공학 설계", "프로그래밍1", "프로그래밍2", "컴퓨터와 소프트웨어의 이해", "이산 수학", "컴퓨터 네트워크", "소프트웨어 개발", "인문학 특강", "융복합과 이해", "성공학 특강", "결혼과 사회", "자연과학세계"}));
		Subject_In.setBounds(28, 76, 473, 41);
		contentPane.add(Subject_In);
		
		JLabel Professor_Img = new JLabel("");
		Professor_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/imagesASJC4VFF.jpg")));
		Professor_Img.setBounds(28, 139, 52, 41);
		contentPane.add(Professor_Img);
		
		Panel_Professor = new JPanel();
		Panel_Professor.setBackground(new Color(0, 0, 128));
		Panel_Professor.setBounds(93, 139, 168, 41);
		contentPane.add(Panel_Professor);
		
		Professor_Tf = new JLabel();
		Panel_Professor.add(Professor_Tf);
		Professor_Tf.setText("담당 교수");
		Professor_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Professor_Tf.setForeground(Color.WHITE);
		Professor_Tf.setFont(Professor_Tf.getFont().deriveFont(Professor_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Professor_Tf.setBackground(new Color(0, 0, 128));
		
		Professor_In = new JTextField();
		Professor_In.setHorizontalAlignment(SwingConstants.RIGHT);
		Professor_In.setFont(Professor_In.getFont().deriveFont(Professor_In.getFont().getStyle() | Font.BOLD, 18f));
		Professor_In.setColumns(10);
		Professor_In.setBounds(28, 195, 378, 41);
		contentPane.add(Professor_In);
		
		JLabel Dayofweek_Img = new JLabel("");
		Dayofweek_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/imagesL3LZX0G1.jpg")));
		Dayofweek_Img.setBounds(28, 251, 52, 41);
		contentPane.add(Dayofweek_Img);
		
		Panel_Dayofweek = new JPanel();
		Panel_Dayofweek.setBackground(new Color(0, 0, 128));
		Panel_Dayofweek.setBounds(97, 251, 164, 41);
		contentPane.add(Panel_Dayofweek);
		
		Dayofweek_Tf = new JLabel();
		Panel_Dayofweek.add(Dayofweek_Tf);
		Dayofweek_Tf.setText("강의 요일");
		Dayofweek_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Dayofweek_Tf.setForeground(Color.WHITE);
		Dayofweek_Tf.setFont(Dayofweek_Tf.getFont().deriveFont(Dayofweek_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Dayofweek_Tf.setBackground(new Color(0, 0, 128));
		JLabel Period_Img = new JLabel("");
		Period_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/imagesL3LZX0G1.jpg")));
		Period_Img.setBounds(287, 251, 52, 41);
		contentPane.add(Period_Img);
		
		Panel_Period = new JPanel();
		Panel_Period.setBackground(new Color(0, 0, 128));
		Panel_Period.setBounds(356, 251, 156, 41);
		contentPane.add(Panel_Period);
		
		Period_Tf = new JLabel();
		Panel_Period.add(Period_Tf);
		Period_Tf.setText("강의 시간");
		Period_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Period_Tf.setForeground(Color.WHITE);
		Period_Tf.setFont(Period_Tf.getFont().deriveFont(Period_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Period_Tf.setBackground(new Color(0, 0, 128));
		
		Period_In = new JTextField();
		Period_In.setHorizontalAlignment(SwingConstants.RIGHT);
		Period_In.setFont(Period_In.getFont().deriveFont(Period_In.getFont().getStyle() | Font.BOLD, 18f));
		Period_In.setBounds(287, 307, 181, 41);
		contentPane.add(Period_In);
		
		JLabel Year_Img = new JLabel("");
		Year_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/calendar-page-en.jpg")));
		Year_Img.setBounds(28, 368, 52, 41);
		contentPane.add(Year_Img);
		
		Panel_Year = new JPanel();
		Panel_Year.setBackground(new Color(0, 0, 128));
		Panel_Year.setBounds(97, 368, 164, 41);
		contentPane.add(Panel_Year);
		
		Year_Tf = new JLabel();
		Panel_Year.add(Year_Tf);
		Year_Tf.setText("강의 년도");
		Year_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Year_Tf.setForeground(Color.WHITE);
		Year_Tf.setFont(Year_Tf.getFont().deriveFont(Year_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Year_Tf.setBackground(new Color(0, 0, 128));
		
		JLabel Semester_Img = new JLabel("");
		Semester_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/calendar-page-en.jpg")));
		Semester_Img.setBounds(287, 363, 52, 41);
		contentPane.add(Semester_Img);
		
		Panel_Semester = new JPanel();
		Panel_Semester.setBackground(new Color(0, 0, 128));
		Panel_Semester.setBounds(356, 363, 156, 41);
		contentPane.add(Panel_Semester);
		
		Semester_Tf = new JLabel();
		Panel_Semester.add(Semester_Tf);
		Semester_Tf.setText("강의 학기");
		Semester_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Semester_Tf.setForeground(Color.WHITE);
		Semester_Tf.setFont(Semester_Tf.getFont().deriveFont(Semester_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Semester_Tf.setBackground(new Color(0, 0, 128));
		
		Year_In = new JComboBox();
		Year_In.setFont(Year_In.getFont().deriveFont(Year_In.getFont().getStyle() | Font.BOLD, 18f));
		Year_In.setModel(new DefaultComboBoxModel(new String[] {"년도 선택", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"}));
		Year_In.setBounds(28, 424, 181, 41);
		contentPane.add(Year_In);
		
		Semester_In = new JComboBox();
		Semester_In.setFont(Semester_In.getFont().deriveFont(Semester_In.getFont().getStyle() | Font.BOLD, 18f));
		Semester_In.setModel(new DefaultComboBoxModel(new String[] {"학기 선택", "1", "2"}));
		Semester_In.setBounds(287, 424, 181, 41);
		contentPane.add(Semester_In);
		
		JLabel Divclass_Img = new JLabel("");
		Divclass_Img.setIcon(new ImageIcon(Add_Subject.class.getResource("/image/imagesAN6AYLO3.jpg")));
		Divclass_Img.setBounds(28, 480, 52, 41);
		contentPane.add(Divclass_Img);
		
		Panel_Divclass = new JPanel();
		Panel_Divclass.setBackground(new Color(0, 0, 128));
		Panel_Divclass.setBounds(97, 480, 169, 41);
		contentPane.add(Panel_Divclass);
		
		Divclass_Tf = new JLabel();
		Panel_Divclass.add(Divclass_Tf);
		Divclass_Tf.setText("분반");
		Divclass_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Divclass_Tf.setForeground(Color.WHITE);
		Divclass_Tf.setFont(Divclass_Tf.getFont().deriveFont(Divclass_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Divclass_Tf.setBackground(new Color(0, 0, 128));
		
		Divclass_In = new JComboBox();
		Divclass_In.setFont(Divclass_In.getFont().deriveFont(Divclass_In.getFont().getStyle() | Font.BOLD, 18f));
		Divclass_In.setModel(new DefaultComboBoxModel(new String[] {"분반 선택", "1", "2", "3"}));
		Divclass_In.setBounds(287, 480, 181, 41);
		contentPane.add(Divclass_In);
		
		Dayofweek_In = new JComboBox();
		Dayofweek_In.setFont(Dayofweek_In.getFont().deriveFont(Dayofweek_In.getFont().getStyle() | Font.BOLD, 18f));
		Dayofweek_In.setModel(new DefaultComboBoxModel(new String[] {"선택", "월", "화", "수", "목", "금", "토"}));
		Dayofweek_In.setBounds(28, 307, 181, 41);
		contentPane.add(Dayofweek_In);
		
		

		
		JButton Check_Btn = new JButton("등록 확인");
		Check_Btn.setBackground(new Color(0, 0, 128));
		Check_Btn.setFont(Check_Btn.getFont().deriveFont(Check_Btn.getFont().getStyle() | Font.BOLD, 22f));
		Check_Btn.setForeground(new Color(255, 255, 255));
		Check_Btn.setBounds(357, 536, 144, 42);
		Check_Btn.addMouseListener(new MouseListener()
				{

					public void mouseClicked(MouseEvent arg0) {

					}

					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					
					public void mousePressed(MouseEvent arg0) {	
						
						if (Professor_In.getText().equals("") || Period_In.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "모든 항목이 채워지지 않았습니다.", "Error", JOptionPane.WARNING_MESSAGE);
							return;

						}
						//combobox가 사전식순일떄 table 추가방식
						if(sList.Sortcob.equals("사전식순"))
						{	
				  //db insert data
							Subjectcob = Subject_In.getSelectedItem().toString();
							Dayofweekcob =Dayofweek_In.getSelectedItem().toString();
							Yearcob =Year_In.getSelectedItem().toString();
							Semestercob =Semester_In.getSelectedItem().toString();
							Divclasscob =Divclass_In.getSelectedItem().toString();
								
							if (Subjectcob == "수강 과목 선택" || Dayofweekcob == "선택" || Yearcob == "년도 선택"
									|| Semestercob == "학기 선택" || Divclasscob == "분반 선택")
							{
								JOptionPane.showMessageDialog(null, "모든 항목이 채워지지 않았습니다.", "Error", JOptionPane.WARNING_MESSAGE);
								return;

							}
							
				  Insert_Subject();
				  //update table
					 ssb.Subject_Sort();
				  //exit add_sub
						dispose();
						}
						//combobox가 요일별일때 table 추가방식
						else
						{
					  //db insert data
					  Insert_Subject();
					  //update table(요일)
						ssb.Dayofweek_Sort();
					  //exit add_sub
							dispose();
						}
						
					}

					
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						//sList.jTableRefresh();
						}});
		
		contentPane.add(Check_Btn);
		
		JLabel Professor_Lb = new JLabel("교수님");
		Professor_Lb.setFont(Professor_Lb.getFont().deriveFont(Professor_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Professor_Lb.setBounds(423, 195, 78, 41);
		contentPane.add(Professor_Lb);
		
		JLabel Date_Lb = new JLabel("요일");
		Date_Lb.setFont(Date_Lb.getFont().deriveFont(Date_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Date_Lb.setBounds(222, 307, 58, 41);
		contentPane.add(Date_Lb);
		
		JLabel Time_Lb = new JLabel("교시");
		Time_Lb.setFont(Time_Lb.getFont().deriveFont(Time_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Time_Lb.setBounds(485, 307, 44, 41);
		contentPane.add(Time_Lb);
		
		JLabel Year_Lb = new JLabel("년도");
		Year_Lb.setFont(Year_Lb.getFont().deriveFont(Year_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Year_Lb.setBounds(222, 424, 58, 41);
		contentPane.add(Year_Lb);
		
		JLabel Semester_Lb = new JLabel("학기");
		Semester_Lb.setFont(Semester_Lb.getFont().deriveFont(Semester_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Semester_Lb.setBounds(482, 424, 47, 41);
		contentPane.add(Semester_Lb);
		
		JLabel Divclass_Lb = new JLabel("분반");
		Divclass_Lb.setFont(Divclass_Lb.getFont().deriveFont(Divclass_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Divclass_Lb.setBounds(482, 480, 47, 41);
		contentPane.add(Divclass_Lb);
		

	
	}
	//삽입
	
	private void Insert_Subject(){
		 Subject_Dto dto = getViewData();
	  Subject_Dao dao = new Subject_Dao(); 
	  boolean ok = dao.Insert_Subject(dto);
		
	}
	public Subject_Dto getViewData() {
		Subject_Dto dto = new Subject_Dto();
  	    String subject = Subjectcob;
	    String professor = Professor_In.getText();
	    String dayofweek = Dayofweekcob;
	    String period = Period_In.getText();
	    String year = Yearcob + "년";
	    String semester = Semestercob + "학기";
	    String divclass = Divclasscob+ "분반";
	  
	  
	  
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