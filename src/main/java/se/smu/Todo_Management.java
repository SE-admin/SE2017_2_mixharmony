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
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import se.smu.Subject_Management.Mouseclick;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Todo_Management extends JFrame {

	private JPanel contentPane;
	private JTable Todo_Data_Tb;
	private JPopupMenu popup = new JPopupMenu();
	private JMenuItem ChangeMenu = new JMenuItem("변경");
	private JMenuItem DeleteMenu = new JMenuItem("제거");

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Todo_Management frame = new Todo_Management();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Todo_Management() {
		setTitle("TO DO LIST");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton Logout_Btn = new JButton("로그아웃");
		Logout_Btn.setForeground(Color.WHITE);
		Logout_Btn.setFont(Logout_Btn.getFont().deriveFont(Logout_Btn.getFont().getStyle() | Font.BOLD, Logout_Btn.getFont().getSize() + 4f));
		Logout_Btn.setBackground(new Color(0, 0, 128));
		Logout_Btn.setBounds(580, 381, 144, 42);
		Logout_Btn.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						//
						LOGOUT Info = new LOGOUT();
						Info.setVisible(true);
						//
					}
				}
			    );
		contentPane.add(Logout_Btn);
		
		JButton Subject_Btn = new JButton("수강 과목");
		Subject_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				Subject_Management Info = new Subject_Management();
				Info.setVisible(true);
				dispose();
				//
			}
		});
		Subject_Btn.setForeground(Color.WHITE);
		Subject_Btn.setFont(Subject_Btn.getFont().deriveFont(Subject_Btn.getFont().getStyle() | Font.BOLD, Subject_Btn.getFont().getSize() + 4f));
		Subject_Btn.setBackground(new Color(0, 0, 128));
		Subject_Btn.setBounds(276, 381, 144, 42);
		contentPane.add(Subject_Btn);
		
		JScrollPane Todo_Scroll = new JScrollPane();
		Todo_Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Todo_Scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Todo_Scroll.setBounds(28, 39, 688, 294);
		contentPane.add(Todo_Scroll);
		
		Todo_Data_Tb = new JTable();
		Todo_Data_Tb.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TODO명", "마감 기한", "실제 마감일", "중요도"
			}
		));
		Todo_Data_Tb.getColumnModel().getColumn(0).setPreferredWidth(135);
		Todo_Data_Tb.getColumnModel().getColumn(1).setPreferredWidth(135);
		Todo_Data_Tb.getColumnModel().getColumn(2).setPreferredWidth(135);
		Todo_Data_Tb.setSurrendersFocusOnKeystroke(true);
		Todo_Data_Tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Todo_Data_Tb.setFont(Todo_Data_Tb.getFont().deriveFont(Todo_Data_Tb.getFont().getStyle() | Font.BOLD, 18f));
		Todo_Data_Tb.setFillsViewportHeight(true);
		Todo_Data_Tb.setColumnSelectionAllowed(true);
		Todo_Data_Tb.setCellSelectionEnabled(true);
		Todo_Data_Tb.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		//
		DefaultTableModel model = (DefaultTableModel) Todo_Data_Tb.getModel();
		Todo_Dao dao = new Todo_Dao();
		dao.userSelectAll(model);
		//
		Todo_Scroll.setViewportView(Todo_Data_Tb);
		
		JButton Add_Todo_Btn = new JButton("");
		Todo_Scroll.setRowHeaderView(Add_Todo_Btn);
		Add_Todo_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				Add_Todolist Info = new Add_Todolist();
				Info.setVisible(true);
				//
			}
		});
		Add_Todo_Btn.setIcon(new ImageIcon(Todo_Management.class.getResource("/image/add.png")));
		
		JComboBox Sort_Btn = new JComboBox();
		Sort_Btn.setFont(Sort_Btn.getFont().deriveFont(Sort_Btn.getFont().getStyle() | Font.BOLD, Sort_Btn.getFont().getSize() + 4f));
		Sort_Btn.setModel(new DefaultComboBoxModel(new String[] {"사전식순", "중요도순", "마감일순", "실제마감일순"}));
		Sort_Btn.setForeground(new Color(255, 255, 255));
		Sort_Btn.setBackground(new Color(0, 0, 128));
		Sort_Btn.setBounds(28, 381, 144, 42);
		contentPane.add(Sort_Btn);
		
		Todo_Data_Tb.addMouseListener(new Mouseclick());
	}
	
/*
	public void jTableRefresh(){
		Todo_Dao dao = new Todo_Dao();
		DefaultTableModel model = new DefaultTableModel(dao.getTodo_List(), getColumn());
		Todo_Data_Tb.setModel(model);
	}
*/

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
						Change_Todolist frame = new Change_Todolist();
						frame.setVisible(true); 
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}			
			});
	      
	      DeleteMenu.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						Delete_Todolist frame = new Delete_Todolist();
						frame.setVisible(true); 
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}			
			});
	   }

	   public void mouseClicked(MouseEvent e){
	      if(e.getButton() == 3){
	         popup.show((Component)e.getSource(), e.getX(), e.getY());
	      }
	      else{

	      }
	   }

	   public void actionPerformed(ActionEvent e) {
		   // TODO Auto-generated method stub
	   }
	}

}
