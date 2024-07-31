package projectforjob;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Allscore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allscore frame = new Allscore();
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
			rs=stm.executeQuery("select students.stuid,students.stuname,students.phone,score.clabel,score.stuscore from students inner join score on students.stuid=score.stuid ");
			table_1.setModel(Dbutils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public Allscore() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("All Score");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(179, 11, 117, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 66, 433, 343);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setRowHeight(30);
		scrollPane.setViewportView(table_1);
		loaddata();
		
	}

}
