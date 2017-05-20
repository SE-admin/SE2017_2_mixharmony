package java.se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;

public class LOGIN extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LOGIN();	
			}
		});
	}
	

	
	public LOGIN() {
		LOGIN frame = new LOGIN();
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon(LOGIN.class.getResource("https://github.com/SE-admin/SE2017_2_mixharmony.git\\학교명.jpg"));
		JLabel label = new JLabel(new ImageIcon(LOGIN.class.getResource("/images/학교명.jpg")));	
		label.setBounds(17, 15, 51, 46);
		contentPane.add(label);
		//contentPane.pack();
		//contentPane.setLocation(true);
		contentPane.setVisible(true);
	}
}
