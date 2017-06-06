package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Alarm_Management extends JFrame {

	private JPanel contentPane;
	private JTable Alarm_Anounce_Tb;
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




	public Alarm_Management() {
		setTitle("알람 게시판");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel Alarm_Img = new JLabel("");
		Alarm_Img.setIcon(new ImageIcon(Alarm_Management.class.getResource("/image/alarm-clipart-Alarm-Clock-15-iloveimg-resized.png")));
		Alarm_Img.setBounds(101, 15, 409, 284);
		contentPane.add(Alarm_Img);
		
		JScrollPane Alarm_Scroll = new JScrollPane();
		Alarm_Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Alarm_Scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Alarm_Scroll.setBounds(17, 314, 543, 294);
		contentPane.add(Alarm_Scroll);
		
		Alarm_Anounce_Tb = new JTable();
		Alarm_Anounce_Tb.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uACFC\uBAA9\uBA85", "todo\uBA85", "\uB9C8\uAC10 \uAE30\uD55C", "\uC911\uC694\uB3C4"
			}
		));
		Alarm_Anounce_Tb.getColumnModel().getColumn(0).setPreferredWidth(110);
		Alarm_Anounce_Tb.getColumnModel().getColumn(1).setPreferredWidth(99);
		Alarm_Anounce_Tb.getColumnModel().getColumn(2).setPreferredWidth(104);
		Alarm_Anounce_Tb.getColumnModel().getColumn(3).setPreferredWidth(82);
		Alarm_Scroll.setViewportView(Alarm_Anounce_Tb);
		Alarm_Anounce_Tb.setSurrendersFocusOnKeystroke(true);
		Alarm_Anounce_Tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Alarm_Anounce_Tb.setFont(Alarm_Anounce_Tb.getFont().deriveFont(Alarm_Anounce_Tb.getFont().getStyle() | Font.BOLD, Alarm_Anounce_Tb.getFont().getSize() + 2f));
		Alarm_Anounce_Tb.setFillsViewportHeight(true);
		Alarm_Anounce_Tb.setColumnSelectionAllowed(true);
		Alarm_Anounce_Tb.setCellSelectionEnabled(true);
		Alarm_Anounce_Tb.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		
		DefaultTableModel model = (DefaultTableModel) Alarm_Anounce_Tb.getModel();
		userSelectAll4(model);
	} 
	
	public static int calint() //현재시간 int형으로 변환 메소드
	{
		int nowtime = 0;
		Calendar cal = Calendar.getInstance(); //시간가져오는 변수
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhh"); //시간을 원하는 형태로 변환
		SimpleDateFormat sdf1 = new SimpleDateFormat("a");
		String ampm = sdf1.format(cal.getTime());
		if(ampm.equals("오후")) //오후
		{
			String nowstring = sdf.format(cal.getTime()); //string형 현재시간
			nowtime = Integer.parseInt(nowstring);
			nowtime = nowtime + 12;
		}
		else //오전
		{
			String nowstring = sdf.format(cal.getTime()); //string형 현재시간
			nowtime = Integer.parseInt(nowstring);
		}	
		return nowtime; //int형 현재시간
	}
	
	public static int deint(String time) //문자열을 int형으로 변환 메소드,숫자없는 문자열은 오류 발생
	{
		int transint = 0; //return int값
		String tmsub = "", aaa = "", tmp = "";
		int i = 0; 
		
		for(int i1=0; i1<time.length(); i1++) {  //문자열을 1개 문자단위로 비교
			tmsub = time.substring(i1, i1+1);
		if(tmsub.equals("0") || tmsub.equals("1") ||tmsub.equals("2") || tmsub.equals("3") ||
				tmsub.equals("4") || tmsub.equals("5") || tmsub.equals("6") || tmsub.equals("7") ||
				tmsub.equals("8") || tmsub.equals("9") ){ 
		tmp=tmp+tmsub; //한자리 숫자문자를 구분하기 위해 임시저장
		
		i++; //숫자문자가 몇개인지 파악
		}
		else
		{
			if(tmsub.equals("") || tmsub == null)
			{
				// catch
			}
			else if(i == 1) //1개숫자문자일경우 앞에 0을 붙임
			{
				tmp = "0" + tmp;
				aaa = aaa + tmp;
				i = 0;
				tmp = "";
			}
			else
			{
				aaa = aaa + tmp;
				i = 0;
				tmp = "";
			}
			
		}
		} 
		
		transint = Integer.parseInt(aaa); //변환
		
		return transint;

	}
	
	public void userSelectAll4(DefaultTableModel model) {
		   
		   
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	   
	    try {
	        con = getConn();
	        String sql = "select * from tododb";
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();
	       
	        // DefaultTableModel에 있는 데이터 지우기
	        for (int i = 0; i < model.getRowCount();) {
	            model.removeRow(0);
	        }
	        //real time part
	        
	        while(rs.next())
	        {
	        	if(rs.getString("deadline").equals("") || rs.getString("deadline") == null)
	        	{
	        		//catch exception
	        	}
	        	else
	        	{
	        		if(rs.getString("deadline_ampm").equals("오후")) //afternoon.night
	        		{
	        			int l = deint(rs.getString("deadline")) + 12;
	        			int j = calint();
	        			if((l - j) < 100 && (l - j) > 0 )
	        			{
	        				Object data[] = { rs.getString("subject"), rs.getString("itemname"),
	        						rs.getString("deadline"), rs.getString("star")
		                        	};

	        				model.addRow(data);
	        			}
	        			else
	        			{
        				//not alarm list(too early,too late)
	        			}
	        		}
	        		else
	        		{
	        			int l = deint(rs.getString("deadline"));
	        			int j = calint();	

	        			if((l-j) < 100 && (l-j) > 0 )
	        			{
	        				Object data[] = { rs.getString("subject"), rs.getString("itemname"),
	        						rs.getString("deadline"), rs.getString("star")
		                        	};

	        				model.addRow(data);
	        			}
	        			else
	        			{
	        				//not alarm list(too early,too late)
	        			}
	        		}
	        	}
	        }

	    } catch (SQLException e) {
	        System.out.println(e + "=> userSelectAll fail");
	    } finally{
	       
	        if(rs!=null)
	            try {
	                rs.close();
	            } catch (SQLException e2) {
	                // TODO Auto-generated catch block
	                e2.printStackTrace();
	            }
	        if(ps!=null)
	            try {
	                ps.close();
	            } catch (SQLException e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
	            }
	        if(con!=null)
	            try {
	                con.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	    }
	}
	
	    
}
