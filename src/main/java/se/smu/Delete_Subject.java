package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
//수정//
import javax.swing.table.DefaultTableModel;
import javax.swing.DropMode;

public class Delete_Subject extends JFrame {

	private JPanel contentPane;
	//수정//
	Subject_Management sList;
	public static JTable Subject_Data_Tb;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//수정//
					//int row = Subject_Data_Tb.getSelectedRow();
					//String subject = (String) Subject_Data_Tb.getValueAt(row,  0);
					Delete_Subject frame = new Delete_Subject();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Delete_Subject() {
		setTitle("수강 과목 삭제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		final JTable table = sList.Subject_Data_Tb;
		
		JTextArea Warning_Out = new JTextArea();
		Warning_Out.setEditable(false);
		Warning_Out.setBackground(new Color(255, 255, 255));
		Warning_Out.setText("                                              * 경 고 *\r\n\r\n                        해당 수강 과목을 삭제 하시겠습니까?");
		Warning_Out.setToolTipText("");
		Warning_Out.setFont(Warning_Out.getFont().deriveFont(Warning_Out.getFont().getStyle() | Font.BOLD, Warning_Out.getFont().getSize() + 6f));
		Warning_Out.setForeground(new Color(0, 0, 0));
		Warning_Out.setWrapStyleWord(true);
		Warning_Out.setLineWrap(true);
		Warning_Out.setBounds(17, 28, 525, 146);
		contentPane.add(Warning_Out);
		
		JButton Cancel_Btn = new JButton("취소");
		Cancel_Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				 
			}
		});
		Cancel_Btn.setFont(Cancel_Btn.getFont().deriveFont(Cancel_Btn.getFont().getStyle() | Font.BOLD, Cancel_Btn.getFont().getSize() + 2f));
		Cancel_Btn.setBackground(new Color(0, 0, 128));
		Cancel_Btn.setForeground(new Color(255, 255, 255));
		Cancel_Btn.setBounds(221, 198, 136, 33);
		contentPane.add(Cancel_Btn);
		
		JButton Check_Btn = new JButton("확인");
		//수정//
		Check_Btn.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.removeRow(0);
		        
		        //수정3//
				int row = (int)Subject_Data_Tb.getSelectedRow();
				if (row >0)
				{String id = (String) Subject_Data_Tb.getValueAt(row,  0);
				Delete_Subject(id);}
				
				//Delete_Subject(subject);
				//DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		        Subject_Dao dao = new Subject_Dao();
		        dao.userSelectAll(model);
				dispose();
			}
			
		});
		Check_Btn.setForeground(Color.WHITE);
		Check_Btn.setFont(Check_Btn.getFont().deriveFont(Check_Btn.getFont().getStyle() | Font.BOLD, Check_Btn.getFont().getSize() + 2f));
		Check_Btn.setBackground(new Color(0, 0, 128));
		Check_Btn.setBounds(406, 198, 136, 33);
		contentPane.add(Check_Btn);
	}

	//수정//
	private void Delete_Subject(String subject)
	{
		//Subject_Dto dto = getViewData();
		//Subject_Dao dao = new Subject_Dao();
		//boolean ok = dao.Delete_Subject(dto);
	}
	

	
	public void actionPerformed(ActionEvent arg0)
	{
		int row = Subject_Data_Tb.getSelectedRow();
		String id = (String) Subject_Data_Tb.getValueAt(row,  0);
		Delete_Subject(id);
		dispose();
	}
	
}
