package projectforjob;
import java.sql.*;
public class myconnection {
        public static Connection getConnection() {
        	Connection con=null;
        	try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_sys?characterEncoding=utf8","root","maathavan2270");
        
        	}catch(Exception e){
        		e.printStackTrace();
        		
        	}
        	return con;
        }
}
