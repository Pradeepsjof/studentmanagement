package projectforjob;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class managestudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tname;
	private JTextField tdate;
	private JTextField tphone;
	private JTextField tid;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managestudent frame = new managestudent();
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
	public void loaddata() {
		Connection con=myconnection.getConnection();
		Statement stm;
		ResultSet rs;
		try {
			stm=con.createStatement();
			rs=stm.executeQuery("select * from students");
			table.setModel(Dbutils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public managestudent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 910, 594);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setLocation(0, -21);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(46, 55, 299, 457);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Manage Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(298, 11, 169, 21);
		contentPane.add(lblNewLabel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(30, 92, 78, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(29, 135, 78, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Birthdate");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(29, 180, 78, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(29, 232, 78, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(29, 290, 78, 14);
		panel.add(lblNewLabel_1_4);
		
		tname = new JTextField();
		tname.setBounds(103, 89, 177, 20);
		panel.add(tname);
		tname.setColumns(10);
		
		tdate = new JTextField();
		tdate.setColumns(10);
		tdate.setBounds(103, 177, 177, 20);
		panel.add(tdate);
		
		tphone = new JTextField();
		tphone.setColumns(10);
		tphone.setBounds(103, 229, 177, 20);
		panel.add(tphone);
		
		JTextArea tAaddress = new JTextArea();
		tAaddress.setBounds(103, 285, 177, 105);
		panel.add(tAaddress);
		
		ButtonGroup bg=new ButtonGroup();
		JRadioButton radiomale = new JRadioButton("Male");
		radiomale.setBounds(105, 131, 59, 23);
		panel.add(radiomale);
		bg.add(radiomale);
		radiomale.setSelected(true);
		JRadioButton radiofemale = new JRadioButton("Female");
		radiofemale.setBounds(194, 131, 70, 23);
		panel.add(radiofemale);
		bg.add(radiofemale);
		
		JButton bupdate = new JButton("Edit");
		bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String id=tid.getText();
				 String name=tname.getText();
				 String gender="male";
				 if(radiofemale.isSelected()) {
					 gender="female";
				 }
				 String bdate=tdate.getText();
				 String phone=tphone.getText();
				 String address=tAaddress.getText();
				 
				 
			     student s=new student();
			     s.updatestudent(name, gender, bdate, phone, address,id);
				 loaddata();
			}
		});
		bupdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		bupdate.setBounds(202, 413, 78, 23);
		panel.add(bupdate);
		
		JButton bdelete = new JButton("delete");
		bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=tid.getText();
				student s=new student();
				s.deletestudent(id);
				loaddata();
			}
		});
		bdelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		bdelete.setBounds(108, 413, 84, 23);
		panel.add(bdelete);
		
		JLabel lblNewLabel_1_5 = new JLabel("Id");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5.setBounds(30, 45, 78, 14);
		panel.add(lblNewLabel_1_5);
		
		tid = new JTextField();
		tid.setColumns(10);
		tid.setBounds(103, 42, 177, 20);
		panel.add(tid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(357, 55, 527, 457);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
				TableModel model=table.getModel();
				tid.setText(model.getValueAt(index, 0).toString());
				tname.setText(model.getValueAt(index, 1).toString());
				if(model.getValueAt(index, 2).toString().equals("male")) {
					radiomale.setSelected(true);
					radiofemale.setSelected(false);
				}
				else {
					radiomale.setSelected(false);
					radiofemale.setSelected(true);
				}
				tdate.setText(model.getValueAt(index, 3).toString());
				tphone.setText(model.getValueAt(index, 4).toString());
				tAaddress.setText(model.getValueAt(index, 5).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		loaddata();
	}
}
