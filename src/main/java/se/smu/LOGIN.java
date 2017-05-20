package main.java.se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.TrayIcon;

import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Label;
import java.awt.Component;

public class LOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LOGIN() {
		
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 608);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getStyle() | Font.BOLD, 21f));
		textField.setForeground(new Color(255, 255, 255));
		textField.setText("학교명");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(0, 0, 102));
		textField.setBounds(77, 15, 149, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setIgnoreRepaint(true);
		choice.setBounds(10, 73, 419, 34);
		contentPane.add(choice);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 18, 50, 40);
		contentPane.add(lblNewLabel);
		

	}
}
