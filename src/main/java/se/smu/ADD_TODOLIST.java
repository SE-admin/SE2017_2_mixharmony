package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ADD_TODOLIST extends JFrame {

	private final JPanel contentPane;
	private JTextField Todo_name;
	private JTextField Jtf_todo_name;
	private JTextField Deadline;
	private JTextField Jtf_dead_month;
	private JTextField Jtf_dead_date;
	private JTextField Jtf_dead_time;
	private JTextField Real_deadline;
	private JTextField Jtf_realDead_month;
	private JTextField Jtf_realDead_date;
	private JTextField Jtf_realDead_time;
	private JTextField Priority;
    private void ViewData(Todo_Dto vTo){
        
        String itemname = vTo.getItemname();
        String deadline = vTo.getDeadline();
        String rdeadline = vTo.getRdeadline();
        String importance = vTo.getImportance();
        String comment = vTo.getComment();
    }




	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADD_TODOLIST frame = new ADD_TODOLIST();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ADD_TODOLIST() {
		setTitle("TO DO 항목 등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		Todo_name = new JTextField();
		Todo_name.setText("항목명");
		Todo_name.setHorizontalAlignment(SwingConstants.CENTER);
		Todo_name.setForeground(Color.WHITE);
		Todo_name.setFont(Todo_name.getFont().deriveFont(Todo_name.getFont().getStyle() | Font.BOLD, 21f));
		Todo_name.setColumns(10);
		Todo_name.setBackground(new Color(0, 0, 128));
		Todo_name.setBounds(86, 15, 156, 46);
		contentPane.add(Todo_name);
		
		Jtf_todo_name = new JTextField();
		Jtf_todo_name.setText("");
		Jtf_todo_name.setColumns(10);
		Jtf_todo_name.setBounds(17, 71, 473, 41);
		contentPane.add(Jtf_todo_name);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/imagesK5B499QW.jpg")));
		label.setBounds(17, 15, 52, 41);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/Deadline-Clock.jpg")));
		label_1.setBounds(17, 132, 52, 41);
		contentPane.add(label_1);
		
		Deadline = new JTextField();
		Deadline.setText("마감 기한");
		Deadline.setHorizontalAlignment(SwingConstants.CENTER);
		Deadline.setForeground(Color.WHITE);
		Deadline.setFont(Deadline.getFont().deriveFont(Deadline.getFont().getStyle() | Font.BOLD, 21f));
		Deadline.setColumns(10);
		Deadline.setBackground(new Color(0, 0, 128));
		Deadline.setBounds(86, 127, 156, 46);
		contentPane.add(Deadline);
		
		Jtf_dead_month = new JTextField();
		Jtf_dead_month.setText("");
		Jtf_dead_month.setColumns(10);
		Jtf_dead_month.setBounds(17, 183, 135, 41);
		contentPane.add(Jtf_dead_month);
		
		JLabel Jlb_dead_month = new JLabel("월");
		Jlb_dead_month.setFont(Jlb_dead_month.getFont().deriveFont(Jlb_dead_month.getFont().getStyle() | Font.BOLD, 17f));
		Jlb_dead_month.setBounds(155, 183, 30, 30);
		contentPane.add(Jlb_dead_month);
		
		Jtf_dead_date = new JTextField();
		Jtf_dead_date.setText("");
		Jtf_dead_date.setColumns(10);
		Jtf_dead_date.setBounds(180, 183, 135, 41);
		contentPane.add(Jtf_dead_date);
		
		JLabel Jlb_dead_date = new JLabel("일");
		Jlb_dead_date.setFont(Jlb_dead_month.getFont().deriveFont(Jlb_dead_date.getFont().getStyle() | Font.BOLD, 17f));
		Jlb_dead_date.setBounds(318, 183, 30, 30);
		contentPane.add(Jlb_dead_date);
		
		Jtf_dead_time = new JTextField();
		Jtf_dead_time.setText("");
		Jtf_dead_time.setColumns(10);
		Jtf_dead_time.setBounds(343, 183, 135, 41);
		contentPane.add(Jtf_dead_time);
		
		JLabel Jlb_dead_time = new JLabel("시");
		Jlb_dead_time.setFont(Jlb_dead_time.getFont().deriveFont(Jlb_dead_time.getFont().getStyle() | Font.BOLD, 15f));
		Jlb_dead_time.setBounds(481, 183, 30, 30);
		contentPane.add(Jlb_dead_time);
	
	
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/submitalisting.jpg")));
		label_2.setBounds(17, 244, 52, 41);
		contentPane.add(label_2);
		
		Real_deadline = new JTextField();
		Real_deadline.setText("실제 마감일");
		Real_deadline.setHorizontalAlignment(SwingConstants.CENTER);
		Real_deadline.setForeground(Color.WHITE);
		Real_deadline.setFont(Real_deadline.getFont().deriveFont(Real_deadline.getFont().getStyle() | Font.BOLD, 21f));
		Real_deadline.setColumns(10);
		Real_deadline.setBackground(new Color(0, 0, 128));
		Real_deadline.setBounds(86, 239, 156, 46);
		contentPane.add(Real_deadline);
		
		Jtf_realDead_month = new JTextField();
		Jtf_realDead_month.setText("");
		Jtf_realDead_month.setColumns(10);
		Jtf_realDead_month.setBounds(17, 299, 135, 41);
		contentPane.add(Jtf_realDead_month);
		
		JLabel Jlb_realDead_month = new JLabel("월");
		Jlb_realDead_month.setFont(Jlb_realDead_month.getFont().deriveFont(Jlb_realDead_month.getFont().getStyle() | Font.BOLD, 17f));
		Jlb_realDead_month.setBounds(155, 299, 30, 30);
		contentPane.add(Jlb_realDead_month);
		
		Jtf_realDead_date = new JTextField();
		Jtf_realDead_date.setText("");
		Jtf_realDead_date.setColumns(10);
		Jtf_realDead_date.setBounds(180, 299, 135, 41);
		contentPane.add(Jtf_realDead_date);
		
		JLabel Jlb_realDead_date = new JLabel("일");
		Jlb_realDead_date.setFont(Jlb_realDead_date.getFont().deriveFont(Jlb_realDead_date.getFont().getStyle() | Font.BOLD, 17f));
		Jlb_realDead_date.setBounds(318, 299, 30, 30);
		contentPane.add(Jlb_realDead_date);

		Jtf_realDead_time = new JTextField();
		Jtf_realDead_time.setText("");
		Jtf_realDead_time.setColumns(10);
		Jtf_realDead_time.setBounds(343, 299, 135, 41);
		contentPane.add(Jtf_realDead_time);
		
		JLabel Jlb_realDead_time = new JLabel("시");
		Jlb_realDead_time.setFont(Jlb_realDead_time.getFont().deriveFont(Jlb_realDead_time.getFont().getStyle() | Font.BOLD, 15f));
		Jlb_realDead_time.setBounds(481, 299, 30, 30);
		contentPane.add(Jlb_realDead_time);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		label_3.setBounds(17, 360, 52, 41);
		contentPane.add(label_3);
		
		Priority = new JTextField();
		Priority.setText("중요도");
		Priority.setHorizontalAlignment(SwingConstants.CENTER);
		Priority.setForeground(Color.WHITE);
		Priority.setFont(Priority.getFont().deriveFont(Priority.getFont().getStyle() | Font.BOLD, 21f));
		Priority.setColumns(10);
		Priority.setBackground(new Color(0, 0, 128));
		Priority.setBounds(86, 355, 156, 46);
		contentPane.add(Priority);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		button.setBounds(251, 360, 44, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		button_1.setBounds(301, 360, 44, 41);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		button_2.setBounds(351, 360, 44, 41);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		button_3.setBounds(398, 360, 44, 41);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(ADD_TODOLIST.class.getResource("/image/star.png")));
		button_4.setBounds(446, 360, 44, 41);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("등록");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(button_5.getFont().deriveFont(button_5.getFont().getStyle() | Font.BOLD, button_5.getFont().getSize() + 4f));
		button_5.setBackground(new Color(0, 0, 128));
		button_5.setBounds(372, 433, 118, 42);
		button_5.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Insert_Todo();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
			contentPane.add(button_5);
	}
//삽입
	private void Insert_Todo(){
		 Todo_Dto dto = getViewData();
		 Todo_Dao dao = new Todo_Dao();       
		 boolean ok = dao.Insert_Todo(dto);
	}
	public Todo_Dto getViewData() {
		Todo_Dto dto = new Todo_Dto();
		String itemname = Jtf_todo_name.getText();
		String deadline = Jtf_dead_month.getText();
		String rdeadline = Jtf_realDead_month.getText();
//		String importance = priority.getText();
//		String comment = textField_10.getText();
		
		
		dto.setItemname(itemname);
		dto.setDeadline(deadline);
		dto.setRdeadline(rdeadline);
//		dto.setImportance(importance);
//		dto.setComment(comment);
	
	return dto;
	}
}

