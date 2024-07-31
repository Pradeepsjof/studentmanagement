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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class managescore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tstuid;
	private JTable table;
	private JTextField tscore;
	private JTextField tdescription;
	private JTable table_1;
	private JTextField tscid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managescore frame = new managescore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
	public void loaddata() {
		Connection con=myconnection.getConnection();
		Statement stm;
		ResultSet rs;
		try {
			stm=con.createStatement();
			rs=stm.executeQuery("select * from score");
			table_1.setModel(Dbutils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public managescore() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 817, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Score");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(333, 26, 117, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(30, 63, 339, 337);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Course label");
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

		
		JButton bupdate = new JButton("Edit");
		bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String scid=tscid.getText();
				String stuid=tstuid.getText();
				String clabel=(String)comboBox.getSelectedItem();
				String score=tscore.getText();
				String description=tdescription.getText();
				
				student s=new student();
				s.updatescore(stuid, clabel, score, description, scid);
				loaddata();
			}
		});
		bupdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		bupdate.setBounds(214, 290, 88, 23);
		panel.add(bupdate);
		
		JButton bdelete = new JButton("Delete");
		bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String scid=tscid.getText();
				student s=new student();
				s.deletescore(scid);
				loaddata();
			}
		});
		bdelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		bdelete.setBounds(127, 290, 77, 23);
		panel.add(bdelete);
		
		JLabel lblNewLabel_1_2 = new JLabel("Student Id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(31, 66, 66, 14);
		panel.add(lblNewLabel_1_2);
		
		tstuid = new JTextField();
		tstuid.setColumns(10);
		tstuid.setBounds(127, 63, 175, 20);
		panel.add(tstuid);
		
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
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Score Id");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2_1.setBounds(31, 24, 66, 14);
		panel.add(lblNewLabel_1_2_1);
		
		tscid = new JTextField();
		tscid.setColumns(10);
		tscid.setBounds(127, 21, 175, 20);
		panel.add(tscid);
		
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 63, 404, 337);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setRowHeight(30);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table_1.getSelectedRow();
				TableModel model=table_1.getModel();
				tscid.setText(model.getValueAt(index,0).toString());
				tstuid.setText(model.getValueAt(index, 1).toString());
				comboBox.setSelectedItem(model.getValueAt(index, 2).toString());
				tscore.setText(model.getValueAt(index, 3).toString());
				tdescription.setText(model.getValueAt(index, 4).toString());
				
			}
		});
		scrollPane.setViewportView(table_1);
		loaddata();
		
	}
}
