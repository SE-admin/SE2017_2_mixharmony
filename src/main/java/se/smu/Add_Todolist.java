package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
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
import java.awt.SystemColor;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Add_Todolist extends JFrame {

	private JPanel contentPane;
	private JLabel Itemname_Tf;
	private JLabel Deadline_Tf;
	private JLabel Rdeadline_Tf;
	private JLabel Importance_Tf;
	
	private JTextField Itemname_In;
	private JTextField Comment_In;

	private JComboBox Deadline_Year;
	private JComboBox Deadline_Mon;
	private JComboBox Deadline_Date;
	private JComboBox Deadline_AmPm;
	private JComboBox Deadline_Time;

	private JComboBox Rdeadline_Year;
	private JComboBox Rdeadline_Mon;
	private JComboBox Rdeadline_Date;
	private JComboBox Rdeadline_AmPm;
	private JComboBox Rdeadline_Time;
	
//	private JComboBox Subject;
	private JComboBox Subject;
	private JComboBox Complete;

	private int choose_importance = 0;
	private JButton Importance_Star_Btn[] = new JButton[5];
	private JPanel Panel_For_Rdeadline;
	private JPanel Panel_For_Importance;
	Todo_Management tdm;
	
//	public static String cob;
	public static String DeadlineYear_cob;
	public static String DeadlineMon_cob;
	public static String DeadlineDate_cob;
	public static String DeadlineAmPm_cob;
	public static String DeadlineTime_cob;
	public static String RdeadlineYear_cob;
	public static String RdeadlineMon_cob;
	public static String RdeadlineDate_cob;
	public static String RdeadlineAmPm_cob;
	public static String RdeadlineTime_cob;
	
	public static String Subjectcob;//수강과목 box값 받기
	public static String Completecob;//완료여부 box값 받기
    Subject_Management sList;
    String Clickdata =sList.Clickdata;
	Todo_Management tList;
	
    private void ViewData(Todo_Dto vTo){
        
        String itemname = vTo.getItemname();
        //String deadline = vTo.getDeadline();
        String deadliney = vTo.getDeadliney();
        String deadlinem = vTo.getDeadlinem();
        String deadlined = vTo.getDeadlined();
        String deadline_ampm = vTo.getDeadline_ampm();
        String deadlinet = vTo.getDeadlinet();
        //String rdeadline = vTo.getRdeadline();
        String rdeadliney = vTo.getRdeadliney();
        String rdeadlinem = vTo.getRdeadlinem();
        String rdeadlined = vTo.getRdeadlined();
        String rdeadline_ampm = vTo.getRdeadline_ampm();
        String rdeadlinet = vTo.getRdeadlinet();
        String importance = vTo.getImportance();
        String comment = vTo.getComment();
        String subject = vTo.getSubject();
        String complete = vTo.getComplete();
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
		setTitle(Clickdata+" TO DO 항목 등록");
		setBounds(100, 100, 528, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		final JTable table1 = tdm.Todo_Data_Tb;
		
		//sort class define 
		Sort_Todo std1 = new Sort_Todo(); 
		
		JPanel Panel_For_Itemname = new JPanel();
		Panel_For_Itemname.setBackground(new Color(0, 0, 128));
		Panel_For_Itemname.setBounds(77, 15, 165, 41);
		contentPane.add(Panel_For_Itemname);
		
		Itemname_Tf = new JLabel();
		Panel_For_Itemname.add(Itemname_Tf);
		Itemname_Tf.setText("항목명");
		Itemname_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Itemname_Tf.setForeground(new Color(255, 255, 255));
		Itemname_Tf.setFont(Itemname_Tf.getFont().deriveFont(Itemname_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Itemname_Tf.setBackground(new Color(0, 0, 128));
		Itemname_Tf.setLabelFor(Itemname_In);
		
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
		
		JPanel Panel_For_Deadline = new JPanel();
		Panel_For_Deadline.setBackground(new Color(0, 0, 128));
		Panel_For_Deadline.setBounds(77, 127, 165, 46);
		contentPane.add(Panel_For_Deadline);
		
		Deadline_Tf = new JLabel();
		Panel_For_Deadline.add(Deadline_Tf);
		Deadline_Tf.setText("마감 기한");
		Deadline_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Deadline_Tf.setForeground(Color.WHITE);
		Deadline_Tf.setFont(Deadline_Tf.getFont().deriveFont(Deadline_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Deadline_Tf.setBackground(new Color(0, 0, 128));
		
		Deadline_Year = new JComboBox();
		Deadline_Year.setFont(Deadline_Year.getFont().deriveFont(Deadline_Year.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Year.setModel(new DefaultComboBoxModel(new String[] {"년도", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"}));
		Deadline_Year.setBounds(17, 183, 68, 41);
		contentPane.add(Deadline_Year);
		
		JLabel Deadline_Year_Lb = new JLabel("년");
		Deadline_Year_Lb.setFont(Deadline_Year_Lb.getFont().deriveFont(Deadline_Year_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Year_Lb.setBounds(87, 183, 30, 41);
		contentPane.add(Deadline_Year_Lb);
		
		Deadline_Date = new JComboBox();
		Deadline_Date.setModel(new DefaultComboBoxModel(new String[] {"  일", "   1", "   2", "   3", "   4", "   5", "   6", "   7", "   8", "   9", "  10", "  11", "  12", "  13", "  14", "  15", "  16", "  17", "  18", "  19", "  20", "  21", "  22", "  23", "  24", "  25", "  26", "  27", "  28", "  29", "  30", "  31"}));
		Deadline_Date.setFont(Deadline_Date.getFont().deriveFont(Deadline_Date.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Date.setBounds(220, 183, 68, 41);
		contentPane.add(Deadline_Date);
		
		JLabel Deadline_Date_Lb = new JLabel("일");
		Deadline_Date_Lb.setFont(Deadline_Date_Lb.getFont().deriveFont(Deadline_Date_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Date_Lb.setBounds(290, 188, 30, 30);
		contentPane.add(Deadline_Date_Lb);
		
		Deadline_Time = new JComboBox();
		Deadline_Time.setFont(Deadline_Time.getFont().deriveFont(Deadline_Time.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Time.setModel(new DefaultComboBoxModel(new String[] {"시간", "  1", "  2", "  3", "  4", "  5", "  6", "  7", "  8", "  9", " 10", " 11", " 12"}));
		Deadline_Time.setBounds(410, 183, 68, 41);
		contentPane.add(Deadline_Time);
		
		JLabel Deadline_Time_Lb = new JLabel("시");
		Deadline_Time_Lb.setFont(Deadline_Time_Lb.getFont().deriveFont(Deadline_Time_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Time_Lb.setBounds(481, 188, 30, 30);
		contentPane.add(Deadline_Time_Lb);
	
	
		
		JLabel Rdeadline_Img = new JLabel("");
		Rdeadline_Img.setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/submitalisting.jpg")));
		Rdeadline_Img.setBounds(17, 244, 52, 41);
		contentPane.add(Rdeadline_Img);
		
		Panel_For_Rdeadline = new JPanel();
		Panel_For_Rdeadline.setBackground(new Color(0, 0, 128));
		Panel_For_Rdeadline.setBounds(77, 244, 165, 41);
		contentPane.add(Panel_For_Rdeadline);
		
		Rdeadline_Tf = new JLabel();
		Panel_For_Rdeadline.add(Rdeadline_Tf);
		Rdeadline_Tf.setText("실제 마감일");
		Rdeadline_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Rdeadline_Tf.setForeground(Color.WHITE);
		Rdeadline_Tf.setFont(Rdeadline_Tf.getFont().deriveFont(Rdeadline_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Rdeadline_Tf.setBackground(new Color(0, 0, 128));
		
		Rdeadline_Mon = new JComboBox();
		Rdeadline_Mon.setModel(new DefaultComboBoxModel(new String[] {"  월", "   1", "   2", "   3", "   4", "   5", "   6", "   7", "   8", "   9", "  10", "  11", "  12"}));
		Rdeadline_Mon.setFont(Rdeadline_Mon.getFont().deriveFont(Rdeadline_Mon.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Mon.setBounds(120, 300, 68, 41);
		contentPane.add(Rdeadline_Mon);
		
		JLabel Rdeadline_Mon_Lb = new JLabel("월");
		Rdeadline_Mon_Lb.setFont(Rdeadline_Mon_Lb.getFont().deriveFont(Rdeadline_Mon_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Mon_Lb.setBounds(190, 305, 30, 30);
		contentPane.add(Rdeadline_Mon_Lb);
		
		Rdeadline_Date = new JComboBox();
		Rdeadline_Date.setModel(new DefaultComboBoxModel(new String[] {"  일", "   1", "   2", "   3", "   4", "   5", "   6", "   7", "   8", "   9", "  10", "  11", "  12", "  13", "  14", "  15", "  16", "  17", "  18", "  19", "  20", "  21", "  22", "  23", "  24", "  25", "  26", "  27", "  28", "  29", "  30", "  31"}));
		Rdeadline_Date.setFont(Rdeadline_Date.getFont().deriveFont(Rdeadline_Date.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Date.setBounds(220, 300, 68, 41);
		contentPane.add(Rdeadline_Date);
		
		JLabel Rdeadline_Date_Lb = new JLabel("일");
		Rdeadline_Date_Lb.setFont(Rdeadline_Date_Lb.getFont().deriveFont(Rdeadline_Date_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Date_Lb.setBounds(290, 305, 30, 30);
		contentPane.add(Rdeadline_Date_Lb);

		Rdeadline_Time = new JComboBox();
		Rdeadline_Time.setModel(new DefaultComboBoxModel(new String[] {"시간", "  1", "  2", "  3", "  4", "  5", "  6", "  7", "  8", "  9", " 10", " 11", " 12"}));
		Rdeadline_Time.setFont(Rdeadline_Time.getFont().deriveFont(Rdeadline_Time.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Time.setBounds(410, 299, 68, 41);
		contentPane.add(Rdeadline_Time);
		
		JLabel Rdeadline_Time_Lb = new JLabel("시");
		Rdeadline_Time_Lb.setFont(Rdeadline_Time_Lb.getFont().deriveFont(Rdeadline_Time_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Time_Lb.setBounds(481, 304, 30, 30);
		contentPane.add(Rdeadline_Time_Lb);
		
		JLabel Importance_Img = new JLabel("");
		Importance_Img.setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		Importance_Img.setBounds(17, 360, 52, 41);
		contentPane.add(Importance_Img);
		
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
		
		Panel_For_Importance = new JPanel();
		Panel_For_Importance.setBackground(new Color(0, 0, 128));
		Panel_For_Importance.setBounds(77, 360, 165, 41);
		contentPane.add(Panel_For_Importance);
		
		Importance_Tf = new JLabel();
		Panel_For_Importance.add(Importance_Tf);
		Importance_Tf.setText("중요도");
		Importance_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Importance_Tf.setForeground(Color.WHITE);
		Importance_Tf.setFont(Importance_Tf.getFont().deriveFont(Importance_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Importance_Tf.setBackground(new Color(0, 0, 128));
		
		Subject = new JComboBox();
		Subject.setFont(Subject.getFont().deriveFont(Subject.getFont().getStyle() | Font.BOLD, 18f));
		Subject.setModel(new DefaultComboBoxModel(new String[] {Clickdata}));
        Subject.setBounds(17, 482, 201, 37);
        contentPane.add(Subject);
		
		
		JButton Signup_Btn = new JButton("등록");
		Signup_Btn.setForeground(Color.WHITE);
		Signup_Btn.setFont(Signup_Btn.getFont().deriveFont(Signup_Btn.getFont().getStyle() | Font.BOLD, Signup_Btn.getFont().getSize() + 4f));
		Signup_Btn.setBackground(new Color(0, 0, 128));
		Signup_Btn.setBounds(371, 478, 118, 42);
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
//				cob = Subject.getSelectedItem().toString();
				
				//delete 
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
		        for (int i = 0; i < model.getRowCount();) {
		            model.removeRow(0);
		            }
		        //insert 
				DeadlineYear_cob = Deadline_Year.getSelectedItem().toString();
				DeadlineMon_cob = Deadline_Mon.getSelectedItem().toString();
				DeadlineDate_cob = Deadline_Date.getSelectedItem().toString();
				DeadlineAmPm_cob = Deadline_AmPm.getSelectedItem().toString();
				DeadlineTime_cob = Deadline_Time.getSelectedItem().toString();
				RdeadlineYear_cob = Rdeadline_Year.getSelectedItem().toString();
				RdeadlineMon_cob = Rdeadline_Mon.getSelectedItem().toString();
				RdeadlineDate_cob = Rdeadline_Date.getSelectedItem().toString();
				RdeadlineAmPm_cob = Rdeadline_AmPm.getSelectedItem().toString();
				RdeadlineTime_cob = Rdeadline_Time.getSelectedItem().toString();
				Subjectcob = Subject.getSelectedItem().toString();
				Completecob = Complete.getSelectedItem().toString();
				
				Insert_Todo();
				
				//update table
			    DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
		        Todo_Dao dao = new Todo_Dao();
		        dao.userSelectAll(model1);
		        //exit add_sub
				dispose();
				
				//SORT 구현 
				/* 
				 //update table & exit Add_Todolist 
				 if(tList.Sortcob.equals("사전식순")) 
				 { 
						if(tList.Checkbox_State == true) //all 
 				 		{ 
				 			std1.itemname_asc(); 
				 			dispose(); 
				 		} 
				 		else//no complete 
				 		{ 
				 			std1.nocom_itemname_asc(); 
				 			dispose(); 
				 		} 
				 } 
				 else if(tList.Sortcob.equals("중요도순")) 
				 { 
				 		if(tList.Checkbox_State == true) //all 
				 		{ 
				 			std1.importance_desc(); 
				 			dispose(); 
				 		} 
				 		else//no complete 
				 		{ 
							std1.nocom_importance_desc(); 
				 			dispose(); 
				 		} 
				 } 
				 else if(tList.Sortcob.equals("마감일순")) 
				 { 
						if(tList.Checkbox_State == true) 
				 		{ 
				 			std1.deadline_asc(); 
				 			dispose(); 
				 		} 
						else 
				 		{ 
							std1.nocom_deadline_asc(); 
				 			dispose(); 
				 		} 
				} 
				else if(tList.Sortcob.equals("실제마감일순")) 
				{ 
				 		if(tList.Checkbox_State == true) //all 
				 		{ 
				 			std1.rdeadline_asc(); 
				 			dispose(); 
						} 
				 		else//no complete 
				 		{ 
				 			std1.nocom_rdeadline_asc(); 
				 			dispose(); 
				 		} 
				 } 
				 else //"완료여부"일 경우 
				 { 
				 		if(tList.Checkbox_State == true) //all 
				 		{ 
				 			std1.complete_asc(); 
				 			dispose(); 
				 		} 
				 		else//no complete 
				 		{ 
				 			std1.nocom_itemname_asc(); 
				 			dispose(); 
				 		} 
				 } 
				 */ 

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				tList.jTableRefresh();
			}});
			contentPane.add(Signup_Btn);
			
			Deadline_Mon = new JComboBox();
			Deadline_Mon.setFont(Deadline_Mon.getFont().deriveFont(Deadline_Mon.getFont().getStyle() | Font.BOLD, 18f));
			Deadline_Mon.setModel(new DefaultComboBoxModel(new String[] {"  월", "   1", "   2", "   3", "   4", "   5", "   6", "   7", "   8", "   9", "  10", "  11", "  12"}));
			Deadline_Mon.setBounds(117, 183, 68, 41);
			contentPane.add(Deadline_Mon);
			
			JLabel Deadline_Mon_Lb = new JLabel("월");
			Deadline_Mon_Lb.setFont(Deadline_Mon_Lb.getFont().deriveFont(Deadline_Mon_Lb.getFont().getStyle() | Font.BOLD, 18f));
			Deadline_Mon_Lb.setBounds(190, 183, 30, 41);
			contentPane.add(Deadline_Mon_Lb);
			
			Deadline_AmPm = new JComboBox();
			Deadline_AmPm.setModel(new DefaultComboBoxModel(new String[] {"선택", "오전", "오후"}));
			Deadline_AmPm.setFont(Deadline_AmPm.getFont().deriveFont(Deadline_AmPm.getFont().getStyle() | Font.BOLD, 18f));
			Deadline_AmPm.setBounds(325, 183, 68, 41);
			contentPane.add(Deadline_AmPm);
			
			Rdeadline_Year = new JComboBox();
			Rdeadline_Year.setModel(new DefaultComboBoxModel(new String[] {"년도", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"}));
			Rdeadline_Year.setFont(Rdeadline_Year.getFont().deriveFont(Rdeadline_Year.getFont().getStyle() | Font.BOLD, 18f));
			Rdeadline_Year.setBounds(17, 300, 68, 41);
			contentPane.add(Rdeadline_Year);
			
			JLabel Rdeadline_Year_Lb = new JLabel("년");
			Rdeadline_Year_Lb.setFont(Rdeadline_Year_Lb.getFont().deriveFont(Rdeadline_Year_Lb.getFont().getStyle() | Font.BOLD, 18f));
			Rdeadline_Year_Lb.setBounds(87, 300, 30, 41);
			contentPane.add(Rdeadline_Year_Lb);
			
			Rdeadline_AmPm = new JComboBox();
			Rdeadline_AmPm.setModel(new DefaultComboBoxModel(new String[] {"선택", "오전", "오후"}));
			Rdeadline_AmPm.setFont(Rdeadline_AmPm.getFont().deriveFont(Rdeadline_AmPm.getFont().getStyle() | Font.BOLD, 18f));
			Rdeadline_AmPm.setBounds(325, 300, 68, 41);
			contentPane.add(Rdeadline_AmPm);
			
			JPanel Panel_For_Comment = new JPanel();
			Panel_For_Comment.setBackground(new Color(0, 0, 128));
			Panel_For_Comment.setBounds(77, 426, 103, 41);
			contentPane.add(Panel_For_Comment);
			Panel_For_Comment.setLayout(null);
			
			JLabel Comment_Lb = new JLabel("Comment");
			Comment_Lb.setBounds(0, 0, 103, 41);
			Panel_For_Comment.add(Comment_Lb);
			Comment_Lb.setForeground(new Color(255, 255, 255));
			Comment_Lb.setFont(Comment_Lb.getFont().deriveFont(Comment_Lb.getFont().getStyle() | Font.BOLD, 18f));
			Comment_Lb.setHorizontalAlignment(SwingConstants.CENTER);
			Comment_Lb.setBackground(new Color(0, 0, 128));
			
			Comment_In = new JTextField();
			Comment_In.setText("");
			Comment_In.setColumns(10);
			Comment_In.setBounds(188, 426, 308, 41);
			contentPane.add(Comment_In);
			
			JLabel Comment_Img = new JLabel("");
			Comment_Img.setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/untitled-iloveimg-resized.png")));
			Comment_Img.setBounds(17, 426, 52, 41);
			contentPane.add(Comment_Img);
			
			Complete = new JComboBox();
			Complete.setModel(new DefaultComboBoxModel(new String[] {" 완료여부", "      O", "      X"}));
			Complete.setFont(Complete.getFont().deriveFont(Complete.getFont().getStyle() | Font.BOLD, 18f));
			Complete.setBounds(235, 482, 109, 39);
			contentPane.add(Complete);
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
		//String deadline = Deadline_Year.getToolTipText() +"월"+ Deadline_Date.getToolTipText()+"일" + Deadline_Time.getToolTipText() +"시";
		String deadliney = DeadlineYear_cob;
		String deadlinem = DeadlineMon_cob;
		String deadlined = DeadlineDate_cob;
		String deadline_ampm = DeadlineAmPm_cob;
		String deadlinet = DeadlineTime_cob;
		//String rdeadline = Rdeadline_Mon.getToolTipText() +"월"+ Rdeadline_Date.getToolTipText()+"일" + Rdeadline_Time.getToolTipText() +"시";
		String rdeadliney = RdeadlineYear_cob;
		String rdeadlinem = RdeadlineMon_cob;
		String rdeadlined = RdeadlineDate_cob;
		String rdeadline_ampm = RdeadlineAmPm_cob;
		String rdeadlinet = RdeadlineTime_cob;
		String importance = Integer.toString(choose_importance);
		String comment = Comment_In.getText();
		String subject = Subjectcob;
		String complete = Completecob;
		
		dto.setItemname(itemname);
		//dto.setDeadline(deadline);
		dto.setDeadliney(deadliney);
		dto.setDeadlinem(deadlinem);
		dto.setDeadlined(deadlined);
		dto.setDeadline_ampm(deadline_ampm);
		dto.setDeadlinet(deadlinet);
		//dto.setRdeadline(rdeadline);
		dto.setRdeadliney(rdeadliney);
		dto.setRdeadlinem(rdeadlinem);
		dto.setRdeadlined(rdeadlined);
		dto.setRdeadline_ampm(rdeadline_ampm);
		dto.setRdeadlinet(rdeadlinet);
		dto.setImportance(importance);
		dto.setComment(comment);
		dto.setSubject(subject);
		dto.setComplete(complete);
		dto.setDeadline(deadliney, deadlinem, deadlined, deadline_ampm, deadlinet);//
		dto.setRdeadline(rdeadliney, rdeadlinem, rdeadlined, rdeadline_ampm, rdeadlinet);
		dto.setStar(importance); //중요도 별로 출력
	
	return dto;
	}
}