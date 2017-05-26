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

public class Sort_Subject extends JFrame {
	
	public Add_Subject Add_Subject_Class;
	
	public Subject_Management Subject_Management_Class;

	JButton DayofweekBtn;


	
	//private Database database;
		
	public static void main (String[] args){
	
		new Sort_Subject();
	}
	
	
	
	
	public class getInfo_print {
		
		String name;
		String prof; 
		String week_time; 
		String year;
		String classnum;
		
		public getInfo_print (String subject_name, String professor, String day_of_week_time, String semester_year,
				String class_number) {
		
			
		
		}

		
	}
	
	class Dayofweek_sort {
		
	}
	
	
	class DayofweekBtnListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
		  }
		}


	
	public Sort_Subject() {
		
		
	
	 }

}
