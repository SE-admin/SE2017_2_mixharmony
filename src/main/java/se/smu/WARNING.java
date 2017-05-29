package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


@SuppressWarnings({ "unused", "serial" })
public class Warning extends JFrame {

	private JPanel contentPane;
	private JLabel message;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warning frame = new Warning("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void printMessage(String log) {
		
			message = new JLabel();
			message.setText(log);
			message.setHorizontalAlignment(SwingConstants.CENTER);
			message.setForeground(Color.BLACK);
			message.setFont(message.getFont().deriveFont(message.getFont().getStyle() | Font.BOLD, message.getFont().getSize() + 6f));
			message.setBounds(17, 15, 525, 146);
			contentPane.add(message);
	}
 //원하는 메시지를 인자로 주면, 이와 함께 Warning frame 출력 가능.		
	public Warning(String path) {
		
		setTitle("Warning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		printMessage(path);
		
		JButton button = new JButton("확인");
		button.setForeground(Color.WHITE);
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, button.getFont().getSize() + 2f));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(406, 188, 136, 33);
		contentPane.add(button);
		
		/*button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Subject_Management Info = new Subject_Management();
				Info.setVisible(true);
				dispose();
			}
		});*/
		
		JButton button2 = new JButton("아니요");
		button2.setForeground(Color.WHITE);
		button2.setFont(button2.getFont().deriveFont(button2.getFont().getStyle() | Font.BOLD, button2.getFont().getSize() + 2f));
		button2.setBackground(new Color(0, 0, 128));
		button2.setBounds(20, 188, 136, 33);
		contentPane.add(button2);
		
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
	

}
