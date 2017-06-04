package se.smu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import se.smu.Todo_Dao;

@SuppressWarnings({ "unused", "serial" })


public class Sort_Todo extends JFrame {
	
	public Todo_Management Todo_Management_Class;
	//public  Add_Todolist Add_Todolist_Class;

	
	//button 사용여부?
	JButton ImportanceBtn;
	JButton DeadlineBtn;
	JButton RDeadlineBtn;
	JButton StartdateBtn;

	//private Database database;

	//class 사용x,메소드로 구현
	public static void main (String[] args){			
	}
	
	public class getInfo_print {	
	}
	
	class Importance_sort {
	}
	
	class Deadline_sort {
	}
	
	class RDeadline_sort {
	}
	
	class Startdate_sort {
	}
	
	public Sort_Todo () {		
	 }
	//구현된 메소드

	//no complete
	public void nocom_itemname_asc()
	{
		DefaultTableModel model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        Todo_Dao dao = new Todo_Dao();
        dao.userSelectAll(model);
	}
	public void nocom_deadline_asc()
	{
		DefaultTableModel model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        Todo_Dao dao = new Todo_Dao();
        dao.userSelectAll3(model,1);
	}
	public void nocom_rdeadline_asc()
	{
		DefaultTableModel model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        Todo_Dao dao = new Todo_Dao();
        dao.userSelectAll3(model,2);
	}
	public void nocom_importance_desc()
	{
		DefaultTableModel model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        Todo_Dao dao = new Todo_Dao();
        dao.userSelectAll3(model,3);
	}
	
	//all
	public void itemname_asc()
	{
		DefaultTableModel model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        Todo_Dao dao = new Todo_Dao();
        dao.userSelectAll1(model,1);
	}
	public void deadline_asc()
	{
		DefaultTableModel model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        Todo_Dao dao = new Todo_Dao();
        dao.userSelectAll1(model,2);
	}
	public void rdeadline_asc()
	{
		DefaultTableModel model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        Todo_Dao dao = new Todo_Dao();
        dao.userSelectAll1(model,3);
	}
	public void importance_desc()
	{
		DefaultTableModel model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        Todo_Dao dao = new Todo_Dao();
        dao.userSelectAll1(model,4);
	}
	public void complete_asc()
	{
		DefaultTableModel model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
            }
	    model = (DefaultTableModel) Todo_Management_Class.Todo_Data_Tb.getModel();
        Todo_Dao dao = new Todo_Dao();
        dao.userSelectAll1(model,5);
	}
}




