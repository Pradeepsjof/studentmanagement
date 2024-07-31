package projectforjob;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class managecourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tlabel;
	private JTextField tid;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managecourse frame = new managecourse();
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
			rs=stm.executeQuery("select * from course");
			table_1.setModel(Dbutils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public managecourse() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("Manage Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(275, 23, 117, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(41, 61, 272, 269);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(31, 110, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hour");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(31, 155, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		tlabel = new JTextField();
		tlabel.setBounds(84, 107, 175, 20);
		panel.add(tlabel);
		tlabel.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(87, 152, 57, 20);
		panel.add(spinner);
		
		JButton bupdate = new JButton("Edit");
		bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String id=tid.getText();
				 String label=tlabel.getText();
			
				 String hour=spinner.getValue().toString();
				 
				 
			     student s=new student();
			     s.updatecourse(label, hour,id);
				 loaddata();
			}
		});
		bupdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		bupdate.setBounds(171, 212, 88, 23);
		panel.add(bupdate);
		
		JButton bdelete = new JButton("Delete");
		bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=tid.getText();
				student s=new student();
				s.deletecourse(id);
				loaddata();
			}
		});
		bdelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		bdelete.setBounds(84, 212, 77, 23);
		panel.add(bdelete);
		
		JLabel lblNewLabel_1_2 = new JLabel("Id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(31, 55, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		tid = new JTextField();
		tid.setColumns(10);
		tid.setBounds(84, 52, 175, 20);
		panel.add(tid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(335, 62, 351, 268);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setRowHeight(30);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table_1.getSelectedRow();
				TableModel model=table_1.getModel();
				tid.setText(model.getValueAt(index, 0).toString());
				tlabel.setText(model.getValueAt(index, 1).toString());	
				spinner.setValue(model.getValueAt(index, 2));
			}
		});
		scrollPane.setViewportView(table_1);
		loaddata();
	}

}
