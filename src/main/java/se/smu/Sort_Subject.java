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
import javax.swing.table.DefaultTableModel;
import se.smu.Subject_Dao;

@SuppressWarnings({ "unused", "serial" })

public class Sort_Subject extends JFrame {
	
	public Add_Subject Add_Subject_Class;
	
	Subject_Management Subject_Management_Class;

	JButton DayofweekBtn;


	



	
	
	
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
	

	

	public void Dayofweek_Sort() //dayofweek asc
	{
		
		//delete
		
		DefaultTableModel model = (DefaultTableModel) Subject_Management_Class.Subject_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
            
        //insert
        
	    model = (DefaultTableModel) Subject_Management_Class.Subject_Data_Tb.getModel();
        Subject_Dao dao = new Subject_Dao();
        dao.userSelectAll2(model, 1); //monday
        dao.userSelectAll2(model, 2); //tuesday
        dao.userSelectAll2(model, 3); //wednesday
        dao.userSelectAll2(model, 4); //thursday
        dao.userSelectAll2(model, 5); //friday
        dao.userSelectAll2(model, 6); //saturday
        dao.userSelectAll2(model, 7); //etc day
        
	}
	
	public void Subject_Sort()//subject asc
	{
		//delete
		DefaultTableModel model = (DefaultTableModel) Subject_Management_Class.Subject_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Subject_Management_Class.Subject_Data_Tb.getModel();
        Subject_Dao dao = new Subject_Dao();
        //insert
        dao.userSelectAll(model);
	}
	


}
