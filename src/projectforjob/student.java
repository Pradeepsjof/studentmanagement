package projectforjob;
import java.sql.*;

import javax.swing.JOptionPane;
public class student {
    public static void insertstudent(String name,String gender,String bdate,String phone,String address) {
    	Connection con=myconnection.getConnection();
    	PreparedStatement ps;
    	try {
    		ps=con.prepareStatement("insert into students (stuname,gender,birthdate,phone,address) values (?,?,?,?,?)");
    		ps.setString(1, name);
    		ps.setString(2, gender);
    		ps.setString(3, bdate);
    		ps.setString(4, phone);
    		ps.setString(5, address);
    		ps.executeUpdate();
    		JOptionPane jp=new JOptionPane();
    		jp.showMessageDialog(null,"New data inserted");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    public static void updatestudent(String name,String gender,String bdate,String phone,String address,String id) {
    	Connection con=myconnection.getConnection();
    	PreparedStatement ps;
    	try {
    		ps=con.prepareStatement("update students set stuname=?,gender=?,birthdate=?,phone=?,address=? where stuid=?");
    		ps.setString(1, name);
    		ps.setString(2, gender);
    		ps.setString(3, bdate);
    		ps.setString(4, phone);
    		ps.setString(5, address);
    		ps.setString(6, id);
    		ps.executeUpdate();
    		JOptionPane jp=new JOptionPane();
    		jp.showMessageDialog(null,"data updated sucucess");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    public static void deletestudent(String id) {
    	Connection con=myconnection.getConnection();
    	PreparedStatement ps;
    	try {
    		ps=con.prepareStatement("delete from students where stuid=?");
    		ps.setString(1, id);
    		ps.executeUpdate();
    		JOptionPane jp=new JOptionPane();
    		jp.showMessageDialog(null,"data deleted sucucess");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    public static void insertcourse(String label,String hours) {
    	Connection con=myconnection.getConnection();
    	PreparedStatement ps;
    	try {
    		ps=con.prepareStatement("insert into course (clabel,hours) values (?,?)");
    		ps.setString(1, label);
    		ps.setString(2, hours);
    		ps.executeUpdate();
    		JOptionPane jp=new JOptionPane();
    		jp.showMessageDialog(null,"New data inserted sucucess");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    public static void updatecourse(String label,String hours,String id) {
    	Connection con=myconnection.getConnection();
    	PreparedStatement ps;
    	try {
    		ps=con.prepareStatement("update course set clabel=?,hours=? where cid=?");
    		ps.setString(1, label);
    		ps.setString(2, hours);
    		ps.setString(3, id);
    		
    		ps.executeUpdate();
    		JOptionPane jp=new JOptionPane();
    		jp.showMessageDialog(null,"data updated sucucess");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    public static void deletecourse(String id) {
    	Connection con=myconnection.getConnection();
    	PreparedStatement ps;
    	try {
    		ps=con.prepareStatement("delete from course where cid=?");
    		ps.setString(1, id);
    		ps.executeUpdate();
    		JOptionPane jp=new JOptionPane();
    		jp.showMessageDialog(null,"data deleted sucucess");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    public static void insertscore(String id,String courlabel,String score,String description) {
    	Connection con=myconnection.getConnection();
    	PreparedStatement ps;
    	try {
    		ps=con.prepareStatement("insert into score (stuid,clabel,stuscore,description) values (?,?,?,?)");
    		ps.setString(1, id);
    		ps.setString(2, courlabel);
    		ps.setString(3, score);
    		ps.setString(4, description);
    		ps.executeUpdate();
    		JOptionPane jp=new JOptionPane();
    		jp.showMessageDialog(null,"New data inserted sucucess");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    public static void updatescore(String stuid,String clabel,String score,String description,String scid) {
    	Connection con=myconnection.getConnection();
    	PreparedStatement ps;
    	try {
    		ps=con.prepareStatement("update score set stuid=?,clabel=?,stuscore=?,description=? where scid=?");
    		ps.setString(1, stuid);
    		ps.setString(2, clabel);
    		ps.setString(3, score);
    		ps.setString(4, description);
    		ps.setString(5, scid);
    		ps.executeUpdate();
    		JOptionPane jp=new JOptionPane();
    		jp.showMessageDialog(null,"data updated sucucess");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    public static void deletescore(String scid) {
    	Connection con=myconnection.getConnection();
    	PreparedStatement ps;
    	try {
    		ps=con.prepareStatement("delete from score where scid=?");
    		ps.setString(1, scid);
    		ps.executeUpdate();
    		JOptionPane jp=new JOptionPane();
    		jp.showMessageDialog(null,"data deleted sucucess");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
