package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class CreatePatientScreen_gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePatientScreen_gui frame = new CreatePatientScreen_gui();
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
	public CreatePatientScreen_gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLastName = new JLabel("First Name");
		lblLastName.setBounds(41, 81, 74, 35);
		contentPane.add(lblLastName);
		
		JLabel label = new JLabel("Last Name");
		label.setBounds(41, 48, 74, 35);
		contentPane.add(label);
		
		JLabel lblAddrez = new JLabel("Suffix");
		lblAddrez.setBounds(41, 123, 74, 35);
		contentPane.add(lblAddrez);
		
		JLabel lblMi = new JLabel("M.I.");
		lblMi.setBounds(41, 164, 74, 35);
		contentPane.add(lblMi);
		
		JLabel lblMf = new JLabel("M/F");
		lblMf.setBounds(41, 205, 74, 35);
		contentPane.add(lblMf);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(41, 250, 74, 35);
		contentPane.add(lblDob);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(41, 291, 74, 35);
		contentPane.add(lblAge);
		
		JLabel label_4 = new JLabel("First Name");
		label_4.setBounds(41, 339, 74, 35);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("First Name");
		label_5.setBounds(41, 380, 74, 35);
		contentPane.add(label_5);
	}
}
