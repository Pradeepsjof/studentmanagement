package projectforjob;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class coursedetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tlabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coursedetail frame = new coursedetail();
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
	public coursedetail() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 412, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(142, 33, 117, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(41, 61, 328, 219);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(39, 48, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hour");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(39, 96, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		tlabel = new JTextField();
		tlabel.setBounds(125, 45, 175, 20);
		panel.add(tlabel);
		tlabel.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(125, 93, 57, 20);
		panel.add(spinner);
		
		JButton badd = new JButton("Add");
		badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String label=tlabel.getText();
				 String hour=spinner.getValue().toString();
				 
				 if(tlabel.getText().equals("")||spinner.getValue().toString().equals("")) {
					 JOptionPane jp=new JOptionPane();
					 jp.showMessageDialog(null, "one or more text field didnot fillup");
				 }
				 else {
					 student s=new student();
					 s.insertcourse(label,hour);
				 }
			}
		});
		badd.setFont(new Font("Tahoma", Font.BOLD, 14));
		badd.setBounds(212, 158, 88, 23);
		panel.add(badd);
		
		JButton bcancel = new JButton("Cancel");
		bcancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		bcancel.setBounds(125, 160, 77, 23);
		panel.add(bcancel);
	}
}
