package controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class mycontroll  {

	Connection getConnect() throws ClassNotFoundException , SQLException{
		
		String url="jdbc:mysql://localhost:3306/medreg_1db";
		String user="root";
		String pass="abc123";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		 return con;
		
	}
	
	public int insert(User u)
	{
		int a=0;
		try {
			Connection con=getConnect();
			PreparedStatement ps=con.prepareStatement("insert into tbl1(fname, lname, email, phone, password, role ) "
		    		+ "values(?,?,?,?,?,?)");
			
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getemail());
			ps.setString(4, u.getphone());
			ps.setString(5, u.getpassword());
			ps.setString(6, u.getrole());
			
			

           
			
		    a= ps.executeUpdate(); 
		  
		    con.close();
		  
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	
}

