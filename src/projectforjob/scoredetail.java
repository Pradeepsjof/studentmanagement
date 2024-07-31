package projectforjob;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class scoredetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tid;
	private JTable table;
	private JTextField tscore;
	private JTextField tdescription;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scoredetail frame = new scoredetail();
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
			rs=stm.executeQuery("select stuid,stuname,phone from students");
			table_1.setModel(Dbutils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public scoredetail() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 823, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Score");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(333, 26, 117, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(34, 64, 339, 337);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Course Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(31, 110, 66, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Score");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(31, 155, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(127, 106, 175, 22);
		    	Connection con=myconnection.getConnection();
		        Statement stm;
		        ResultSet rs;
		    	try {
		            stm=con.createStatement();
		            rs=stm.executeQuery("select clabel from course");
		    		while(rs.next()) {
		    			String item=rs.getString("clabel");
		    			comboBox.addItem(item);
		    		}
		    	}catch(Exception ex) {
		    		ex.printStackTrace();
		    	}
		 
		panel.add(comboBox);
		
		JButton badd = new JButton("Add");
		badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String stuid=tid.getText();
				 String courlabel=(String)comboBox.getSelectedItem();
				 String score=tscore.getText();
				 String description=tdescription.getText();
				  
				 
				 if(tscore.getText().equals("")||tdescription.getText().equals("")) {
					 JOptionPane jp=new JOptionPane();
					 jp.showMessageDialog(null, "one or more text field didnot fillup");
				 }
				 else {
					 student s=new student();
					 s.insertscore(stuid,courlabel,score,description);
				 }
			}
		});
		badd.setFont(new Font("Tahoma", Font.BOLD, 14));
		badd.setBounds(214, 290, 88, 23);
		panel.add(badd);
		
		JButton bcancel = new JButton("Cancel");
		bcancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		bcancel.setBounds(127, 290, 77, 23);
		panel.add(bcancel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Student Id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(31, 55, 66, 14);
		panel.add(lblNewLabel_1_2);
		
		tid = new JTextField();
		tid.setColumns(10);
		tid.setBounds(127, 52, 175, 20);
		panel.add(tid);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Description");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(31, 209, 66, 14);
		panel.add(lblNewLabel_1_1_1);
		
		tscore = new JTextField();
		tscore.setColumns(10);
		tscore.setBounds(127, 152, 175, 20);
		panel.add(tscore);
		
		tdescription = new JTextField();
		tdescription.setColumns(10);
		tdescription.setBounds(127, 206, 175, 20);
		panel.add(tdescription);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(408, 64, 389, 336);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setRowHeight(30);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table_1.getSelectedRow();
				TableModel model=table_1.getModel();
				tid.setText(model.getValueAt(index, 0).toString());
			}
		});
		scrollPane.setViewportView(table_1);
		loaddata();
	}
}
