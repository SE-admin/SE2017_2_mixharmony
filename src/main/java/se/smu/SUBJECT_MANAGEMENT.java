package se.smu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;


@SuppressWarnings("serial")
public class SUBJECT_MANAGEMENT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public SUBJECT_MANAGEMENT() {
		setTitle("수강 과목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\u1\\Desktop\\church-bell_318-9123-iloveimg-resized (1).jpg"));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(494, 15, 52, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("정렬");
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(btnNewButton_1.getFont().getStyle() | Font.BOLD, btnNewButton_1.getFont().getSize() + 4f));
		btnNewButton_1.setBounds(37, 424, 125, 41);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("로그아웃");
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, button.getFont().getSize() + 4f));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(421, 424, 125, 41);
		contentPane.add(button);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setFont(btnNewButton_2.getFont().deriveFont(btnNewButton_2.getFont().getStyle() | Font.BOLD, btnNewButton_2.getFont().getSize() + 14f));
		btnNewButton_2.setBounds(96, 102, 390, 49);
		contentPane.add(btnNewButton_2);
	}

}
