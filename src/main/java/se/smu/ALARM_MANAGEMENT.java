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

public class ALARM_MANAGEMENT extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


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
		setBounds(100, 100, 477, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ALARM_MANAGEMENT.class.getResource("/image/alarm-clipart-Alarm-Clock-15-iloveimg-resized.png")));
		lblNewLabel.setBounds(35, 15, 387, 269);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(17, 299, 393, 259);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(17, 297, 421, 261);
		contentPane.add(scrollPane);
	}
}
