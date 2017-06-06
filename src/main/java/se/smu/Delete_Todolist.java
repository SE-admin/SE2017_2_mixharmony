package se.smu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete_Todolist extends JFrame {

	private JPanel contentPane;
	Todo_Management tList;
	public static JTable Todo_Data_Tb;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Delete_Todolist frame = new Delete_Todolist();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public Delete_Todolist()
	{
		
	}

	public Delete_Todolist(final String itemname, int row) {
		setTitle("TO DO 항목 삭제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		final JTable table = tList.Todo_Data_Tb;
		
		JTextArea Warning_Out = new JTextArea();
		Warning_Out.setEditable(false);
		Warning_Out.setWrapStyleWord(true);
		Warning_Out.setToolTipText("");
		Warning_Out.setText("                                            * 경 고 *\r\n\r\n                         TO DO 항목을 삭제 하시겠습니까?");
		Warning_Out.setLineWrap(true);
		Warning_Out.setForeground(Color.BLACK);
		Warning_Out.setFont(Warning_Out.getFont().deriveFont(Warning_Out.getFont().getStyle() | Font.BOLD, Warning_Out.getFont().getSize() + 6f));
		Warning_Out.setBackground(Color.WHITE);
		Warning_Out.setBounds(17, 15, 525, 146);
		contentPane.add(Warning_Out);
		
		JButton Cancel_Btn = new JButton("취소");
		Cancel_Btn.setForeground(Color.WHITE);
		Cancel_Btn.setFont(Cancel_Btn.getFont().deriveFont(Cancel_Btn.getFont().getStyle() | Font.BOLD, Cancel_Btn.getFont().getSize() + 2f));
		Cancel_Btn.setBackground(new Color(0, 0, 128));
		Cancel_Btn.setBounds(240, 196, 136, 33);
		//취소 버튼 구현
		Cancel_Btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		contentPane.add(Cancel_Btn);
		
		JButton Check_Btn = new JButton("확인");
		Check_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Todo_Dao dao = new Todo_Dao();
				boolean ok = dao.Delete_Todo(itemname);
				dispose();
			}
		});
		Check_Btn.setForeground(Color.WHITE);
		Check_Btn.setFont(Check_Btn.getFont().deriveFont(Check_Btn.getFont().getStyle() | Font.BOLD, Check_Btn.getFont().getSize() + 2f));
		Check_Btn.setBackground(new Color(0, 0, 128));
		Check_Btn.setBounds(406, 196, 136, 33);
		contentPane.add(Check_Btn);
	}
	
	//deleteMember
//	private void Delete_Todo(){
//		String itemname;
//		String deadline;
//		String rdeadline;
//		String importance;
//	}
}