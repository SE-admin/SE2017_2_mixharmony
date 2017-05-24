package se.smu;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Subject_Management extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JScrollPane scrollPane;
	private JTable Subject_Data_Tb;


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
		
		setTitle("수강 과목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		

		JButton Add_Subject_Btn = new JButton("");
		Add_Subject_Btn.setIcon(new ImageIcon(Subject_Management.class.getResource("/image/add.png")));
		Add_Subject_Btn.setBounds(51, 73, 627, 54);
		contentPane.add(Add_Subject_Btn);
		
		JButton Subject_Scroll = new JButton("로그아웃");
		Subject_Scroll.setForeground(Color.WHITE);
		Subject_Scroll.setFont(Subject_Scroll.getFont().deriveFont(Subject_Scroll.getFont().getStyle() | Font.BOLD, Subject_Scroll.getFont().getSize() + 4f));
		Subject_Scroll.setBackground(new Color(0, 0, 128));
		Subject_Scroll.setBounds(562, 451, 144, 42);
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
		Subject_Data_Scroll.setBounds(17, 142, 688, 294);
		contentPane.add(Subject_Data_Scroll);
		
		Subject_Data_Tb = new JTable();
		Subject_Data_Tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Subject_Data_Tb.setFillsViewportHeight(true);
		Subject_Data_Tb.setFont(Subject_Data_Tb.getFont().deriveFont(Subject_Data_Tb.getFont().getStyle() | Font.BOLD, Subject_Data_Tb.getFont().getSize() + 2f));
		Subject_Data_Tb.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"수강 과목", "TODO수", "년도", "학기", "시간" , "요일", "분반"
			}
		));
		Subject_Data_Tb.getColumnModel().getColumn(0).setPreferredWidth(100);
		Subject_Data_Tb.getColumnModel().getColumn(3).setPreferredWidth(51);
		Subject_Data_Tb.getColumnModel().getColumn(5).setPreferredWidth(51);
		Subject_Data_Tb.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		Subject_Data_Tb.setSurrendersFocusOnKeystroke(true);
		Subject_Data_Tb.setCellSelectionEnabled(true);
		Subject_Data_Tb.setColumnSelectionAllowed(true);
		Subject_Data_Scroll.setViewportView(Subject_Data_Tb);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"사전식순", "시간순", "요일순", "분반순"}));
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(comboBox.getFont().deriveFont(comboBox.getFont().getStyle() | Font.BOLD, comboBox.getFont().getSize() + 4f));
		comboBox.setBackground(new Color(0, 0, 128));
		comboBox.setBounds(17, 451, 144, 42);
		contentPane.add(comboBox);

	}
}