package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class SUBJECT_MANAGEMENT extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SUBJECT_MANAGEMENT frame = new SUBJECT_MANAGEMENT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SUBJECT_MANAGEMENT() {
		setTitle("수강 과목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(192, 192, 192));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\u1\\Desktop\\church-bell_318-9123-iloveimg-resized (1).jpg"));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(492, 12, 54, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("정렬");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(btnNewButton_1.getFont().getStyle() | Font.BOLD, btnNewButton_1.getFont().getSize() + 4f));
		btnNewButton_1.setBounds(37, 424, 125, 41);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("로그아웃");
		button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, button.getFont().getSize() + 4f));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(421, 424, 125, 41);
		contentPane.add(button);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setFont(btnNewButton_2.getFont().deriveFont(btnNewButton_2.getFont().getStyle() | Font.BOLD, btnNewButton_2.getFont().getSize() + 14f));
		btnNewButton_2.setBounds(88, 102, 390, 49);
		contentPane.add(btnNewButton_2);
	}

}
