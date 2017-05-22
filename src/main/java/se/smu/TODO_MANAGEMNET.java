package java.se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class TODO_MANAGEMNET extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TODO_MANAGEMNET frame = new TODO_MANAGEMNET();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TODO_MANAGEMNET() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TODO_MANAGEMNET.class.getResource("/images/alarm--alarm-icon-91768.png")));
		label.setBounds(449, 15, 50, 43);
		contentPane.add(label);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(TODO_MANAGEMNET.class.getResource("/images/add.png")));
		button.setBounds(53, 93, 398, 54);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(506, 0, 23, 510);
		contentPane.add(scrollPane);
		
		JButton button_1 = new JButton("정렬");
		button_1.setFont(button_1.getFont().deriveFont(button_1.getFont().getStyle() | Font.BOLD, button_1.getFont().getSize() + 2f));
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setBounds(17, 440, 102, 43);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("로그아웃");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(button_2.getFont().deriveFont(button_2.getFont().getStyle() | Font.BOLD, button_2.getFont().getSize() + 4f));
		button_2.setBackground(new Color(0, 0, 128));
		button_2.setBounds(341, 441, 144, 42);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("수강 과목");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(button_3.getFont().deriveFont(button_3.getFont().getStyle() | Font.BOLD, button_3.getFont().getSize() + 4f));
		button_3.setBackground(new Color(0, 0, 128));
		button_3.setBounds(164, 441, 144, 42);
		contentPane.add(button_3);
	}

}
