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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ALARM_MANAGEMENT extends JFrame {

	private JPanel contentPane;
	private JTable Alarm_Anounce_Tb;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ALARM_MANAGEMENT frame = new ALARM_MANAGEMENT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ALARM_MANAGEMENT() {
		setTitle("알람 게시판");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel Alarm_Img = new JLabel("");
		Alarm_Img.setIcon(new ImageIcon(ALARM_MANAGEMENT.class.getResource("/image/alarm-clipart-Alarm-Clock-15-iloveimg-resized.png")));
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
	} 
}
