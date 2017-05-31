package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import se.smu.Add_Todolist.Star_Listener;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Change_Todolist extends JFrame {

	private JPanel contentPane;
	private JTextField Itemname_In;
	private JLabel Deadline_Tf;
	private JLabel Rdeadline_Tf;
	private JLabel Importance_Tf;
	private JTextField Deadline_Mon;
	private JTextField Deadline_Date;
	private JTextField Deadline_Time;
	private JTextField Rdeadline_Mon;
	private JTextField Rdeadline_Date;
	private JTextField Rdeadline_Time;
	private int choose_importance = 0;
	private JButton Importance_Star_Btn[] = new JButton[5];
	
	Todo_Management tList;
	
	
    private void ViewData(Todo_Dto vTo){
        
        String itemname = vTo.getItemname();
        String deadline = vTo.getDeadline();
        String rdeadline = vTo.getRdeadline();
        String importance = vTo.getImportance();
        String subject = vTo.getSubject();

        //수정//
        Itemname_In.setText(itemname);
        Deadline_Mon.setText(deadline);
        Deadline_Date.setText(deadline);
        Deadline_Time.setText(deadline);
        Rdeadline_Mon.setText(rdeadline);
        Rdeadline_Date.setText(rdeadline);
        Rdeadline_Time.setText(rdeadline);
        
        
//        Star_Listener Star_Listener = new Star_Listener();
//        if(Integer.parseInt(importance) == 1){
//    		Importance_Star_Btn[0].addMouseListener(Star_Listener);
//    		contentPane.add(Importance_Star_Btn[0]);
//        }else if(Integer.parseInt(importance) == 2){
//        	Importance_Star_Btn[1].addMouseListener(Star_Listener);
//    		contentPane.add(Importance_Star_Btn[1]);
//        }else if(Integer.parseInt(importance) == 3){
//        	Importance_Star_Btn[2].addMouseListener(Star_Listener);
//    		contentPane.add(Importance_Star_Btn[2]);
//        }else if(Integer.parseInt(importance) == 4){
//        	Importance_Star_Btn[3].addMouseListener(Star_Listener);
//    		contentPane.add(Importance_Star_Btn[3]);
//        }else if(Integer.parseInt(importance) == 5){
//        	Importance_Star_Btn[4].addMouseListener(Star_Listener);
//    		contentPane.add(Importance_Star_Btn[4]);
//        }
        
    }


	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Change_Todolist frame = new Change_Todolist();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		//new Change_Todolist();
	}
	
	class Star_Listener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			for(int i=0;i<Importance_Star_Btn.length;i++){
				Importance_Star_Btn[i].setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/star.png")));
			}
			for(int i=0;i<Importance_Star_Btn.length;i++){
				if(e.getSource() ==Importance_Star_Btn[i]){
					choose_importance = i+1;
					for(int j=0;j<=i;j++)
						Importance_Star_Btn[j].setIcon(new ImageIcon(Add_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
				}
			}
		}
	}

	public Change_Todolist(){
		
	}

	public Change_Todolist(String itemname) {
		setTitle("to do 항목 편집");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		final JTable table = tList.Todo_Data_Tb;
		
		JPanel Panel_Itemname = new JPanel();
		Panel_Itemname.setBackground(new Color(0, 0, 128));
		Panel_Itemname.setBounds(81, 15, 168, 41);
		contentPane.add(Panel_Itemname);
		
		JLabel lblNewLabel = new JLabel("항목명");
		Panel_Itemname.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, 21f));
		
		Itemname_In = new JTextField();
		Itemname_In.setText("");
		Itemname_In.setColumns(10);
		Itemname_In.setBounds(17, 71, 473, 41);
		contentPane.add(Itemname_In);
		
		JLabel Itemname_Img = new JLabel("");
		Itemname_Img.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/imagesK5B499QW.jpg")));
		Itemname_Img.setBounds(17, 15, 52, 41);
		contentPane.add(Itemname_Img);
		
		JLabel Deadline_Img = new JLabel("");
		Deadline_Img.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/Deadline-Clock.jpg")));
		Deadline_Img.setBounds(17, 132, 52, 41);
		contentPane.add(Deadline_Img);
		
		JPanel Panel_Deadline = new JPanel();
		Panel_Deadline.setBackground(new Color(0, 0, 128));
		Panel_Deadline.setBounds(86, 127, 162, 46);
		contentPane.add(Panel_Deadline);
		
		Deadline_Tf = new JLabel();
		Panel_Deadline.add(Deadline_Tf);
		Deadline_Tf.setText("마감 기한");
		Deadline_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Deadline_Tf.setForeground(Color.WHITE);
		Deadline_Tf.setFont(Deadline_Tf.getFont().deriveFont(Deadline_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Deadline_Tf.setBackground(new Color(0, 0, 128));
		
		JLabel Rdeadline_Img = new JLabel("");
		Rdeadline_Img.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/submitalisting.jpg")));
		Rdeadline_Img.setBounds(17, 244, 52, 41);
		contentPane.add(Rdeadline_Img);
		
		JPanel Panel_Rdeadline = new JPanel();
		Panel_Rdeadline.setBackground(new Color(0, 0, 128));
		Panel_Rdeadline.setBounds(86, 244, 166, 41);
		contentPane.add(Panel_Rdeadline);
		
		Rdeadline_Tf = new JLabel();
		Panel_Rdeadline.add(Rdeadline_Tf);
		Rdeadline_Tf.setText("실제 마감일");
		Rdeadline_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Rdeadline_Tf.setForeground(Color.WHITE);
		Rdeadline_Tf.setFont(Rdeadline_Tf.getFont().deriveFont(Rdeadline_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Rdeadline_Tf.setBackground(new Color(0, 0, 128));
		
		JLabel Importance_Img = new JLabel("");
		Importance_Img.setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		Importance_Img.setBounds(17, 360, 52, 41);
		contentPane.add(Importance_Img);
		
		JPanel Panel_Importance = new JPanel();
		Panel_Importance.setBackground(new Color(0, 0, 128));
		Panel_Importance.setBounds(86, 360, 157, 41);
		contentPane.add(Panel_Importance);
		
		Importance_Tf = new JLabel();
		Panel_Importance.add(Importance_Tf);
		Importance_Tf.setText("중요도");
		Importance_Tf.setHorizontalAlignment(SwingConstants.CENTER);
		Importance_Tf.setForeground(Color.WHITE);
		Importance_Tf.setFont(Importance_Tf.getFont().deriveFont(Importance_Tf.getFont().getStyle() | Font.BOLD, 21f));
		Importance_Tf.setBackground(new Color(0, 0, 128));
		
		Star_Listener Star_Listener = new Star_Listener();
		Importance_Star_Btn[0] = new JButton("");
		Importance_Star_Btn[0].setSelectedIcon(new ImageIcon(Change_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		Importance_Star_Btn[0].setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[0].setBounds(251, 360, 44, 41);
		Importance_Star_Btn[0].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[0]);
		
		Importance_Star_Btn[1] = new JButton("");
		Importance_Star_Btn[1].setSelectedIcon(new ImageIcon(Change_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		Importance_Star_Btn[1].setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[1].setBounds(301, 360, 44, 41);
		Importance_Star_Btn[1].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[1]);
		
		Importance_Star_Btn[2] = new JButton("");
		Importance_Star_Btn[2].setSelectedIcon(new ImageIcon(Change_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		Importance_Star_Btn[2].setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[2].setBounds(351, 360, 44, 41);
		Importance_Star_Btn[2].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[2]);
		
		Importance_Star_Btn[3] = new JButton("");
		Importance_Star_Btn[3].setSelectedIcon(new ImageIcon(Change_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		Importance_Star_Btn[3].setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[3].setBounds(398, 360, 44, 41);
		Importance_Star_Btn[3].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[3]);
		
		Importance_Star_Btn[4] = new JButton("");
		Importance_Star_Btn[4].setSelectedIcon(new ImageIcon(Change_Todolist.class.getResource("/image/565112c0bf29a_thumb900.jpg")));
		Importance_Star_Btn[4].setIcon(new ImageIcon(Change_Todolist.class.getResource("/image/star.png")));
		Importance_Star_Btn[4].setBounds(446, 360, 44, 41);
		Importance_Star_Btn[4].addMouseListener(Star_Listener);
		contentPane.add(Importance_Star_Btn[4]);
		
		Todo_Dao dao = new Todo_Dao();
		Todo_Dto vTo = dao.getTodo_Dto(itemname);
		//ViewData(vTo);
		
		JButton Signup_Btn = new JButton("편집 등록");
		Signup_Btn.setForeground(Color.WHITE);
		Signup_Btn.setFont(Signup_Btn.getFont().deriveFont(Signup_Btn.getFont().getStyle() | Font.BOLD, Signup_Btn.getFont().getSize() + 4f));
		Signup_Btn.setBackground(new Color(0, 0, 128));
		Signup_Btn.setBounds(351, 433, 139, 42);

		Signup_Btn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
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
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < model.getRowCount();) {
		            model.removeRow(0);
		        }
				Change_Todolist();
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				Todo_Dao dao = new Todo_Dao();
		        dao.userSelectAll(model);
				dispose();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				tList.jTableRefresh();
			}});
		
		contentPane.add(Signup_Btn);
		
		Deadline_Mon = new JTextField();
		Deadline_Mon.setText("");
		Deadline_Mon.setColumns(10);
		Deadline_Mon.setBounds(17, 188, 135, 41);
		contentPane.add(Deadline_Mon);
		
		JLabel Deadline_Mon_Lb = new JLabel("월");
		Deadline_Mon_Lb.setFont(Deadline_Mon_Lb.getFont().deriveFont(Deadline_Mon_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Mon_Lb.setBounds(156, 188, 30, 41);
		contentPane.add(Deadline_Mon_Lb);
		
		Deadline_Date = new JTextField();
		Deadline_Date.setText("");
		Deadline_Date.setColumns(10);
		Deadline_Date.setBounds(181, 188, 135, 41);
		contentPane.add(Deadline_Date);
		
		JLabel Deadline_Date_Lb = new JLabel("일");
		Deadline_Date_Lb.setFont(Deadline_Date_Lb.getFont().deriveFont(Deadline_Date_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Date_Lb.setBounds(318, 193, 30, 30);
		contentPane.add(Deadline_Date_Lb);
		
		Deadline_Time = new JTextField();
		Deadline_Time.setText("");
		Deadline_Time.setColumns(10);
		Deadline_Time.setBounds(340, 188, 135, 41);
		contentPane.add(Deadline_Time);
		
		JLabel Deadline_Time_Lb = new JLabel("시");
		Deadline_Time_Lb.setFont(Deadline_Time_Lb.getFont().deriveFont(Deadline_Time_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Deadline_Time_Lb.setBounds(473, 193, 30, 30);
		contentPane.add(Deadline_Time_Lb);
		
		Rdeadline_Mon = new JTextField();
		Rdeadline_Mon.setText("");
		Rdeadline_Mon.setColumns(10);
		Rdeadline_Mon.setBounds(17, 299, 135, 41);
		contentPane.add(Rdeadline_Mon);
		
		JLabel Rdeadline_Mon_Lb = new JLabel("월");
		Rdeadline_Mon_Lb.setFont(Rdeadline_Mon_Lb.getFont().deriveFont(Rdeadline_Mon_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Mon_Lb.setBounds(156, 300, 30, 41);
		contentPane.add(Rdeadline_Mon_Lb);
		
		Rdeadline_Date = new JTextField();
		Rdeadline_Date.setText("");
		Rdeadline_Date.setColumns(10);
		Rdeadline_Date.setBounds(181, 300, 135, 41);
		contentPane.add(Rdeadline_Date);
		
		JLabel Rdeadline_Date_Lb = new JLabel("일");
		Rdeadline_Date_Lb.setFont(Rdeadline_Date_Lb.getFont().deriveFont(Rdeadline_Date_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Date_Lb.setBounds(318, 304, 30, 30);
		contentPane.add(Rdeadline_Date_Lb);
		
		Rdeadline_Time = new JTextField();
		Rdeadline_Time.setText("");
		Rdeadline_Time.setColumns(10);
		Rdeadline_Time.setBounds(340, 299, 135, 41);
		contentPane.add(Rdeadline_Time);
		
		JLabel Rdeadline_Time_Lb = new JLabel("시");
		Rdeadline_Time_Lb.setFont(Rdeadline_Time_Lb.getFont().deriveFont(Rdeadline_Time_Lb.getFont().getStyle() | Font.BOLD, 18f));
		Rdeadline_Time_Lb.setBounds(473, 304, 30, 30);
		contentPane.add(Rdeadline_Time_Lb);
		
	}
	
	//수정//
	public Change_Todolist(String itemname, Todo_Management tList)
	{
		this.tList = tList;
		System.out.println("itemname="+itemname);
		Todo_Dto dto = getViewData();
		Todo_Dao dao = new Todo_Dao();
		Todo_Dto vTodolist = dao.getTodo_Dto(itemname);
		ViewData(vTodolist);
		
	}
	
	private void Change_Todolist(){
		Todo_Dto dto = getViewData();
		Todo_Dao dao = new Todo_Dao();
		boolean ok = dao.Change_Todo(dto);
	}
	
	
	public Todo_Dto getViewData() {
		Todo_Dto dto = new Todo_Dto();
		String itemname = Itemname_In.getText();
		String deadline = Deadline_Mon.getText() +"월"+ Deadline_Date.getText()+"일" + Deadline_Time.getText() +"시";
		String rdeadline = Rdeadline_Mon.getText() +"월"+ Rdeadline_Date.getText()+"일" + Rdeadline_Time.getText() +"시";
		String importance = Integer.toString(choose_importance);
//		String subject = JComboBox.getText();
		String subject = Itemname_In.getText(); //db 실행되는지만 확인
		
		dto.setItemname(itemname);
		dto.setDeadline(deadline);
		dto.setRdeadline(rdeadline);
		dto.setImportance(importance);
		dto.setSubject(subject);
	
	return dto;
	}
	
}
