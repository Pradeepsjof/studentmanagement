package projectforjob;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class mainframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe frame = new mainframe();
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
	public mainframe() {
		setTitle("Student Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(mainframe.class.getResource("/projectforjob/phone/imagesresize1.jpeg")));
		lblNewLabel.setBounds(0, 0, 1566, 768);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 22);
		lblNewLabel.add(menuBar);
		
		JMenu mnStudents = new JMenu("students");
		mnStudents.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnStudents);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentdetail sd=new studentdetail();
                sd.setVisible(true);
				sd.setLocationRelativeTo(null);
			   
			}
		});
		mnStudents.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Edit/delete");
		mntmNewMenuItem_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				managestudent ms=new managestudent();
				ms.setVisible(true);
				ms.setLocationRelativeTo(null);
			    
			    
			}
		});
		mnStudents.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("course");
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add");
		mntmNewMenuItem_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				coursedetail cd=new coursedetail();
				cd.setVisible(true);
				cd.setLocationRelativeTo(null);
			    
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Edit/delete");
		mntmNewMenuItem_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				managecourse mc=new managecourse();
				mc.setVisible(true);
				mc.setLocationRelativeTo(null);
			    
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("score");
		mnNewMenu_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Add");
		mntmNewMenuItem_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				scoredetail scd=new scoredetail();
				scd.setVisible(true);
				scd.setLocationRelativeTo(null);
			    
			    
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Edit/delete");
		mntmNewMenuItem_5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				managescore msc=new managescore();
				msc.setVisible(true);
				msc.setLocationRelativeTo(null);
			    
			    
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("All Score");
		mntmNewMenuItem_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmNewMenuItem_6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				Allscore as=new Allscore();
				as.setVisible(true);
				as.setLocationRelativeTo(null);
			    
			    
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
	}
}
