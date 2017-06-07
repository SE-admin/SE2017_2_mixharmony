package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import se.smu.Subject_Management.Mouseclick;
import se.smu.Todo_Dao;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import javax.swing.JCheckBox;

public class Todo_Management extends JFrame implements MouseListener,ActionListener{

	DefaultTableModel model;
	private JPanel contentPane;
	public static JTable Todo_Data_Tb;
	private JPopupMenu popup = new JPopupMenu();
	private JMenuItem ChangeMenu = new JMenuItem("변경");
	private JMenuItem DeleteMenu = new JMenuItem("제거");
	//combobox text send value
	public static String Sortcob;
	//checkbox state value
	public static boolean Checkbox_State;
	  Subject_Management sList;
	  String Clickdata =sList.Clickdata;
	Vector cols;
	Vector v;

	public Todo_Management() {
		Todo_Dao dao  = new Todo_Dao();
		v = dao.getTodo_List();
		System.out.println("v="+v);
		cols = getColumn();
		
		model = new DefaultTableModel(v,cols)//추가
		{
			public boolean isCellEditable(int i,int j)
			{
				return false;
			}
		};
				
		setTitle(Clickdata +"TO DO LIST");
		setBounds(100, 100, 975, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//sort class define
		final Sort_Todo std = new Sort_Todo();
		
		JButton Logout_Btn = new JButton("로그아웃");
		Logout_Btn.setForeground(Color.WHITE);
		Logout_Btn.setFont(Logout_Btn.getFont().deriveFont(Logout_Btn.getFont().getStyle() | Font.BOLD, Logout_Btn.getFont().getSize() + 4f));
		Logout_Btn.setBackground(new Color(0, 0, 128));
		Logout_Btn.setBounds(780, 381, 144, 42);
		Logout_Btn.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						int logout = JOptionPane.showConfirmDialog(null, "로그아웃을 하시겠습니까??", "*경고*", JOptionPane.YES_NO_OPTION);
						if(logout == JOptionPane.YES_OPTION){
							
							Login Info = new Login();
							Info.setVisible(true);
							dispose();
							
						}
						else{
							Todo_Management tList = new Todo_Management();
							tList.setVisible(true);
							dispose();
						}
					}
				}
			    );
		contentPane.add(Logout_Btn);

		JButton Subject_Btn = new JButton("수강 과목");
		Subject_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Subject_Management Info = new Subject_Management();
				Info.setVisible(true);
				dispose();

			}
		});
		Subject_Btn.setForeground(Color.WHITE);
		Subject_Btn.setFont(Subject_Btn.getFont().deriveFont(Subject_Btn.getFont().getStyle() | Font.BOLD, Subject_Btn.getFont().getSize() + 4f));
		Subject_Btn.setBackground(new Color(0, 0, 128));
		Subject_Btn.setBounds(400, 381, 144, 42);
		contentPane.add(Subject_Btn);
		
		JScrollPane Todo_Scroll = new JScrollPane();
		Todo_Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Todo_Scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Todo_Scroll.setBounds(28, 34, 900, 294);
		contentPane.add(Todo_Scroll);
		
		Todo_Data_Tb = new JTable(model);
	
//		Todo_Data_Tb.setModel(new DefaultTableModel(
//				
//			new Object[][] {
//			},
//			new String[] {
//				"TODO\uBA85", "\uB9C8\uAC10 \uAE30\uD55C", "\uC2E4\uC81C \uB9C8\uAC10\uC77C", "\uC911\uC694\uB3C4", "\uCF54\uBA58\uD2B8", "\uC644\uB8CC\uC5EC\uBD80"
//			}
//		));
		Todo_Data_Tb.getColumnModel().getColumn(0).setPreferredWidth(255);
		Todo_Data_Tb.getColumnModel().getColumn(1).setPreferredWidth(240);
		Todo_Data_Tb.getColumnModel().getColumn(2).setPreferredWidth(240);
		Todo_Data_Tb.getColumnModel().getColumn(3).setPreferredWidth(110);
		Todo_Data_Tb.getColumnModel().getColumn(4).setPreferredWidth(220);
		Todo_Data_Tb.getColumnModel().getColumn(5).setPreferredWidth(85);
		Todo_Data_Tb.setSurrendersFocusOnKeystroke(true);
		Todo_Data_Tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Todo_Data_Tb.setFont(new Font("굴림", Font.PLAIN, 12));
		Todo_Data_Tb.setFillsViewportHeight(true);
		Todo_Data_Tb.setColumnSelectionAllowed(true);
		Todo_Data_Tb.setCellSelectionEnabled(true);
		Todo_Data_Tb.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		
		
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		 
		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		 
		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = Todo_Data_Tb.getColumnModel();
		 
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		
		}

		DefaultTableModel model = (DefaultTableModel) Todo_Data_Tb.getModel();
		
//		Todo_Dao dao = new Todo_Dao();

		dao.userSelectAll(model);
	
		

		Todo_Scroll.setViewportView(Todo_Data_Tb);
		//combobox 텍스트 전달을 위해서 combobox선언위치를 이곳으로 변경
		final JComboBox Sort_Btn = new JComboBox();
		//check box 텍스트 전달을 위해서 check box 선언위치를 이곳으로 변경
		final JCheckBox Hide_Select = new JCheckBox("전체 항목 보기(완료항목)");
		//
		JButton Add_Todo_Btn = new JButton("");
		Todo_Scroll.setRowHeaderView(Add_Todo_Btn);
		Add_Todo_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Checkbox_State = Hide_Select.isSelected();
					Sortcob = Sort_Btn.getSelectedItem().toString();//send value
					Add_Todolist Info = new Add_Todolist();
					Info.setVisible(true); 

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		Add_Todo_Btn.setIcon(new ImageIcon(Todo_Management.class.getResource("/image/add.png")));
		
		
		Sort_Btn.setFont(Sort_Btn.getFont().deriveFont(Sort_Btn.getFont().getStyle() | Font.BOLD, Sort_Btn.getFont().getSize() + 4f));
		Sort_Btn.setModel(new DefaultComboBoxModel(new String[] {"사전식순", "중요도순", "마감일순", "실제마감일순","완료여부"}));
		Sort_Btn.setForeground(new Color(255, 255, 255));
		Sort_Btn.setBackground(new Color(0, 0, 128));
		Sort_Btn.setBounds(28, 381, 144, 42);
		contentPane.add(Sort_Btn);
		
		
		//checkbox event add
		Hide_Select.addItemListener(new ItemListener()
				{
					@Override
					public void itemStateChanged(ItemEvent arg0) {
						if(Hide_Select.isSelected()) //선택된 경우 o표시 제외
						{
							std.itemname_asc(); //all
						}
						else 
						{
							std.nocom_itemname_asc();//no complete
						}
					}});

		Hide_Select.setFont(Hide_Select.getFont().deriveFont(Hide_Select.getFont().getStyle() | Font.BOLD, 17f));
		Hide_Select.setBounds(28, 341, 225, 29);
		contentPane.add(Hide_Select);
		//sort 구현
		Sort_Btn.addItemListener(new ItemListener()
				{
					@Override
					public void itemStateChanged(ItemEvent e) {
						if(Sort_Btn.getSelectedItem().toString().equals("사전식순"))
						{
							
							if(Hide_Select.isSelected()) //all,check box select
							{
								std.itemname_asc();
							}
							else //no complete
							{
								std.nocom_itemname_asc();
							}
						}
	
						else if(Sort_Btn.getSelectedItem().toString().equals("완료여부"))
						{
							if(Hide_Select.isSelected()) //all,check box select
							{
								std.complete_asc();
							}
							else //no complete
							{
								std.nocom_itemname_asc();
							}
						}
						else if(Sort_Btn.getSelectedItem().toString().equals("마감일순"))
						{
							if(Hide_Select.isSelected()) //all,check box select
							{
								std.deadline_asc();
							}
							else //no complete
							{
								std.nocom_deadline_asc();
							}
						}
						else if(Sort_Btn.getSelectedItem().toString().equals("실제마감일순"))
						{
							if(Hide_Select.isSelected()) //all,check box select
							{
								std.rdeadline_asc();
							}
							else
							{
								std.nocom_rdeadline_asc();
							}
						}
//						 if(Sort_Btn.getSelectedItem().toString().equals("중요도순"))
						else
						{
							if(Hide_Select.isSelected()) //all,check box select
							{
								std.importance_desc();
							}
							else
							{
								std.nocom_importance_desc();
							}
						}
					}}
				);
		
		Todo_Data_Tb.addMouseListener(new Mouseclick());
	}
	
	public Vector getColumn(){
		Vector col = new Vector();
		col.add("TODO명");
		col.add("마감 기한");
		col.add("실제 마감일");
		col.add("중요도");
		col.add("코멘트");
		col.add("완료여부");
		return col;
	}
	

	public void jTableRefresh(){
		Todo_Dao dao = new Todo_Dao();
		DefaultTableModel model = new DefaultTableModel(dao.getTodo_List(), getColumn());
		Todo_Data_Tb.setModel(model);
		
	}
	
	public class Mouseclick extends MouseAdapter implements ActionListener
	{
		
	   public Mouseclick(){
	      popup.add(ChangeMenu);
	      popup.add(DeleteMenu);
	      
	      ChangeMenu.addActionListener(this);
	      DeleteMenu.addActionListener(this); 
	    
	      ChangeMenu.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					try {
							int row = Todo_Data_Tb.getSelectedRow(); //수정2
							String itemname = (String)Todo_Data_Tb.getValueAt(row,  0);
							Change_Todolist frame = new Change_Todolist(itemname);
							frame.setVisible(true); 
							
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}			
			});
	      
	      DeleteMenu.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						int row = Todo_Data_Tb.getSelectedRow();
						String itemname = (String) Todo_Data_Tb.getValueAt(row, 0);
						int del = JOptionPane.showConfirmDialog(null, "해당 To do 항목을 삭제하시겠습니까?", "*경고*", JOptionPane.YES_NO_OPTION);
						if(del == JOptionPane.YES_OPTION){
							
							Todo_Dao dao = new Todo_Dao();
							dao.Delete_Todo(itemname);
							
							if (row == -1)
							{
								return;
							}
							
							DefaultTableModel model = (DefaultTableModel) Todo_Data_Tb.getModel();
							model.removeRow(row); //삭제 추가
							
						}else{
							return;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}			
			});
	   }

	   public void mouseClicked(MouseEvent e){
	
		   int row = Todo_Data_Tb.rowAtPoint(e.getPoint());
		   int column = Todo_Data_Tb.columnAtPoint(e.getPoint());
		   if (row >= 0 && column == 0)
		   {
			   if(e.getButton() == 3){
			         popup.show((Component)e.getSource(), e.getX(), e.getY());
			      }

		   }      
	      
	   }

	   public void actionPerformed(ActionEvent e) {
		   // TODO Auto-generated method stub
	   }
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
