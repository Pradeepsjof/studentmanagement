package projectforjob;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentdetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tname;
	private JTextField tdate;
	private JTextField tphone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentdetail frame = new studentdetail();
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
	public studentdetail() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(103, 34, 114, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(29, 92, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(29, 135, 78, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Birthdate");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(29, 180, 78, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(29, 232, 78, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(29, 290, 78, 14);
		contentPane.add(lblNewLabel_1_4);
		
		tname = new JTextField();
		tname.setBounds(103, 89, 211, 20);
		contentPane.add(tname);
		tname.setColumns(10);
		
		tdate = new JTextField();
		tdate.setColumns(10);
		tdate.setBounds(103, 177, 211, 20);
		contentPane.add(tdate);
		
		tphone = new JTextField();
		tphone.setColumns(10);
		tphone.setBounds(103, 229, 211, 20);
		contentPane.add(tphone);
		
		JTextArea tAaddress = new JTextArea();
		tAaddress.setBounds(103, 285, 211, 105);
		contentPane.add(tAaddress);
		
		ButtonGroup bg=new ButtonGroup();
	
		JRadioButton radiomale = new JRadioButton("Male");
		radiomale.setBounds(103, 131, 61, 23);
		contentPane.add(radiomale);
		bg.add(radiomale);
		radiomale.setSelected(true);
		JRadioButton radiofemale = new JRadioButton("Female");
		radiofemale.setBounds(194, 131, 70, 23);
		contentPane.add(radiofemale);
		bg.add(radiofemale);
		
		
		JButton badd = new JButton("Add");
		badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 String name=tname.getText();
			 String gender="male";
			 if(radiofemale.isSelected()) {
				 gender="female";
			 }
			 String bdate=tdate.getText();
			 String phone=tphone.getText();
			 String address=tAaddress.getText();
			 
			 if(tname.getText().equals("")||tdate.getText().equals("") ||tphone.getText().equals("") ||tAaddress.getText().equals("") ) {
				 JOptionPane jp=new JOptionPane();
				 jp.showMessageDialog(null, "one or more text field didnot fillup");
			 }
			 else {
				 student s=new student();
				 s.insertstudent(name, gender, bdate, phone, address);
			 }
			}
		});
		badd.setFont(new Font("Tahoma", Font.BOLD, 14));
		badd.setBounds(225, 413, 89, 23);
		contentPane.add(badd);
		
		JButton bcancel = new JButton("Cancel");
		bcancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		bcancel.setBounds(108, 413, 89, 23);
		contentPane.add(bcancel);
	}
}
