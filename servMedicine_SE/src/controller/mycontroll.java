package controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public boolean checkUser(String rname, String rpass) {
		boolean a=true;
		
		try {
			Connection con=getConnect();
			String sql="SELECT * FROM  tbl1 where fname=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, rname);
			ps.setString(2, rpass);
			
			ResultSet rs=ps.executeQuery();
			
			a= rs.absolute(1);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
	}

	
	
}

