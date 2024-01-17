//package controller;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import model.User;
//
//public class mycontroll  {
//
//	Connection getConnect() throws ClassNotFoundException , SQLException{
//		
//		String url="jdbc:mysql://localhost:3306/medreg_1db";
//		String user="root";
//		String pass="abc123";
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con=DriverManager.getConnection(url,user,pass);
//		 return con;
//		
//	}
//	
//	public int insert(User u) {
//	    int a = 0;
//	    try {
//	        Connection con = getConnect();
//	        PreparedStatement ps = con.prepareStatement("insert into tbl1(fname, lname, email, phone, password, role) values(?,?,?,?,?,?)");
//
//	        ps.setString(1, u.getFname());
//	        ps.setString(2, u.getLname());
//	        ps.setString(3, u.getemail());
//	        ps.setString(4, u.getphone());
//	        ps.setString(5, u.getpassword());
//	        ps.setString(6, u.getrole());
//
//	        a = ps.executeUpdate();
//
//	        con.close();
//
//	    } catch (ClassNotFoundException | SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return a;
//	}
//
//	public boolean checkUser(String rname, String rpass) throws ClassNotFoundException, SQLException {
//	    boolean a = false;
//	    Connection con = getConnect();
//	    String sql = "SELECT * FROM  tbl1 where fname=? and password=?";
//	    try (PreparedStatement ps = con.prepareStatement(sql)) {
//	        ps.setString(1, rname);
//	        ps.setString(2, rpass);
//
//	        try (ResultSet rs = ps.executeQuery()) {
//	            a = rs.next();
//	        }
//	    } finally {
//	        con.close();
//	    }
//	    return a;
//	}
//
//	// ...
//
//	public ArrayList<User> show(int start, int total) {
//	    ArrayList<User> ull = new ArrayList<>();
//
//	    try {
//	        Connection con = getConnect();
//
//	        Statement st = con.createStatement();
//
//	        ResultSet rs = st.executeQuery("select * from tbl1 limit " + (start - 1) + ", " + total + "");
//
//	        while (rs.next()) {
//	            User u = new User();
//	            u.setUid(rs.getInt(1));
//	            u.setFname(rs.getString(2));
//	            u.setLname(rs.getString(3));
//	            u.setemail(rs.getString(4));
//	            u.setphone(rs.getString(5));
//	            u.setpassword(rs.getString(6));
//	            u.setrole(rs.getString(7)); 
//
//	            ull.add(u); 
//	        }
//
//	    } catch (ClassNotFoundException | SQLException e) {
//	        e.printStackTrace();
//	    }
//
//	    return ull;
//	}
//	}
//
//
//
//
//	
//	
//
//
