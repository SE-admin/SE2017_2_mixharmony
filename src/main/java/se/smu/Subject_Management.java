package se.smu;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Subject_Management extends JFrame implements MouseListener,ActionListener{
	Vector v;
	Vector cols;
	DefaultTableModel model;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JScrollPane scrollPane;
	public static JTable Subject_Data_Tb;
	private JPopupMenu popup = new JPopupMenu();
	private JMenuItem ChangeMenu = new JMenuItem("변경");
	private JMenuItem DeleteMenu = new JMenuItem("제거");

	//수정//
	public static int row;
	public static String subject;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			 public void run() {
				try {
					Subject_Management frame = new Subject_Management();
					frame.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Subject_Management() {
		Subject_Dao dao  = new Subject_Dao();
		dao = new Subject_Dao();
		v = dao.getSubject_List();
		System.out.println("v="+v);
		cols = getColumn();
		
		model = new DefaultTableModel(v,cols);
		
		setTitle("수강 과목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JButton Subject_Scroll = new JButton("로그아웃");
		Subject_Scroll.setForeground(Color.WHITE);
		Subject_Scroll.setFont(Subject_Scroll.getFont().deriveFont(Subject_Scroll.getFont().getStyle() | Font.BOLD, Subject_Scroll.getFont().getSize() + 4f));
		Subject_Scroll.setBackground(new Color(0, 0, 128));
		Subject_Scroll.setBounds(562, 451, 144, 42);
		Subject_Scroll.addActionListener(new ActionListener()
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
		contentPane.add(Subject_Scroll);

		JButton Alarm_Btn = new JButton("");
		Alarm_Btn.setIcon(new ImageIcon(Subject_Management.class.getResource("/image/alarm--alarm-icon-91768.png")));
		Alarm_Btn.setBounds(655, 15, 50, 43);
		contentPane.add(Alarm_Btn);

		
		JButton New_Alarm_Btn = new JButton("");
		New_Alarm_Btn.setIcon(new ImageIcon(Subject_Management.class.getResource("/image/%C0̹%CC%C1%F6_007-iloveimg-resized.png")));
		New_Alarm_Btn.setBounds(588, 15, 50, 43);
		contentPane.add(New_Alarm_Btn);
		
		JScrollPane Subject_Data_Scroll = new JScrollPane();
		Subject_Data_Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Subject_Data_Scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Subject_Data_Scroll.setBounds(17, 90, 688, 346);
		contentPane.add(Subject_Data_Scroll);
		
		Subject_Data_Tb = new JTable(model);
		scrollPane = new JScrollPane(Subject_Data_Tb);
        add(scrollPane);
		Subject_Data_Tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Subject_Data_Tb.setFillsViewportHeight(true);
		Subject_Data_Tb.setFont(Subject_Data_Tb.getFont().deriveFont(Subject_Data_Tb.getFont().getStyle() | Font.BOLD, Subject_Data_Tb.getFont().getSize() + 2f));

		Subject_Data_Tb.getColumnModel().getColumn(0).setPreferredWidth(100);
		Subject_Data_Tb.getColumnModel().getColumn(3).setPreferredWidth(51);
		Subject_Data_Tb.getColumnModel().getColumn(5).setPreferredWidth(51);
		Subject_Data_Tb.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		Subject_Data_Tb.setSurrendersFocusOnKeystroke(true);
		Subject_Data_Tb.setCellSelectionEnabled(true);
		Subject_Data_Tb.setColumnSelectionAllowed(true);
		Subject_Data_Scroll.setViewportView(Subject_Data_Tb);
		

		JButton Add_Subject_Btn = new JButton("");
		Subject_Data_Scroll.setRowHeaderView(Add_Subject_Btn);
		Add_Subject_Btn.setIcon(new ImageIcon(Subject_Management.class.getResource("/image/add.png")));
		Add_Subject_Btn.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				try {
					Add_Subject frame = new Add_Subject();
					frame.setVisible(true); 
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}			
		});
		
		JComboBox Sort_Subject_Btn = new JComboBox();
		Sort_Subject_Btn.setModel(new DefaultComboBoxModel(new String[] {"사전식순", "요일순"}));
		Sort_Subject_Btn.setForeground(Color.WHITE);
		Sort_Subject_Btn.setFont(Sort_Subject_Btn.getFont().deriveFont(Sort_Subject_Btn.getFont().getStyle() | Font.BOLD, Sort_Subject_Btn.getFont().getSize() + 4f));
		Sort_Subject_Btn.setBackground(new Color(0, 0, 128));
		Sort_Subject_Btn.setBounds(17, 451, 144, 42);
		contentPane.add(Sort_Subject_Btn);

		Subject_Data_Tb.addMouseListener(new Mouseclick());
	}
	
	public Vector getColumn(){
		Vector col = new Vector();
		col.add("수강과목");
		col.add("교수");
		col.add("요일");
		col.add("시간");
		col.add("년도");
		col.add("학기");
		col.add("분반");
		return col;
	}


	public void jTableRefresh(){
		Subject_Dao dao = new Subject_Dao();
		DefaultTableModel model = new DefaultTableModel(dao.getSubject_List(), getColumn());
		Subject_Data_Tb.setModel(model);
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
						Change_Subject frame = new Change_Subject();
						frame.setVisible(true); 
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}			
			});
	      
	      DeleteMenu.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						//수정//
						/*
						row = Subject_Data_Tb.getSelectedRow();
						subject = (String) Subject_Data_Tb.getValueAt(row,  0);
						Delete_Subject frame = new Delete_Subject(row);
						 */
						Delete_Subject frame = new Delete_Subject();
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
	    	  Todo_Management Info = new Todo_Management(); //act class define
	  		  Info.setVisible(true); //class act
	      }
	   }
	   public void actionPerformed(ActionEvent e) {
		   // TODO Auto-generated method stub

	   }
	}
	 public void actionPerformed(ActionEvent e) {
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


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
