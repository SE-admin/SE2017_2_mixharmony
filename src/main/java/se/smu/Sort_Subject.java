package se.smu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.HashMap;
import java.util.Vector;
import java.util.Collections;
import java.util.Iterator;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings({ "unused", "serial" })

public class SORT_SUBJECT extends JFrame {
	
	public Add_Subject Add_Subject_Class;
	
	private JPanel content_panel;
	private JTextField submain_subject_name;
	public JTextField subject_name;
	private JTextField submain_professor;
	public JTextField professor;
	private JTextField submain_day_of_week_time;
	public JTextField day_of_week_time;
	private JTextField submain_semester_year;
	public JTextField semester_year;
	private JTextField submain_class_number;
	public JTextField class_number;

	
	//private Database database;
		
	public static void main (String[] args){
	
		new SORT_SUBJECT();
	}
	
	
	
	JTextArea Jta;
	class getInfo {
		
		String name;
		String prof; 
		String week_time; 
		String year;
		String classnum;
		
		public getInfo (String subject_name, String professor, String day_of_week_time, String semester_year,
				String class_number) {
		
			name = subject_name;
			prof = professor;
			week_time = day_of_week_time;
			year = semester_year;
			classnum = class_number;
		
		}

		public String print() {
			return name + prof + week_time + year + classnum + "\n";
		}
	}
	
	HashMap<String, getInfo> subInfo = new HashMap<String, getInfo>();
	
	class BtnListener implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("등록확인"))
			{
		    	String subname = subject_name.getText();
			    String pro = professor.getText();
			    String date = day_of_week_time.getText();
			    String semest = semester_year.getText();
			    String cnum = class_number.getText();
			    
			    subject_name.setText("");
		    	professor.setText("");
		    	day_of_week_time.setText("");
		    	semester_year.setText("");
		    	class_number.setText("");
			    
				subInfo.put(subname, new getInfo(subname, pro, date, semest, cnum));
			}
			if(b.getText().equals("정렬"))
			{
				Vector<String> v = new Vector<String>(subInfo.keySet());
		    	Collections.sort(v);
		    	Iterator<String> it = v.iterator();
		    	while (it.hasNext()) {
		    		getInfo p = (getInfo) subInfo.get(it.next());
		    		Jta.setText(p.print());
		    	}
		    	
		    	subject_name.setText("");
		    	professor.setText("");
		    	day_of_week_time.setText("");
		    	semester_year.setText("");
		    	class_number.setText("");
			}
		  }
		}


	
	public SORT_SUBJECT () {
		
		
	
	 }

}
