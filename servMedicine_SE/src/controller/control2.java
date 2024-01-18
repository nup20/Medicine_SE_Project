package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;
import model.User2;

public class control2 {
    Connection getConnect() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/medreg_1db";
        String user = "root";
        String pass = "abc123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;

    }

    public int insert_med(User2 u) {
        int a = 0;
        try {
            Connection con = getConnect();
            PreparedStatement ps = con.prepareStatement("insert into addmed_2tbl(company, medicine) values(?,?)");

            ps.setString(1, u.getcompany2());
            ps.setString(2, u.getmedicine2());

            a = ps.executeUpdate();

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public ArrayList<User2> show(int start, int total) {
        ArrayList<User2> ul = new ArrayList<>();

        try {
            Connection con = getConnect();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from addmed_2tbl limit " + (start - 1) + ", " + total + "");

            while (rs.next()) {
                User2 u = new User2();
                u.setaid(rs.getInt(1));
                u.setcompany2(rs.getString(2));
                u.setmedicine2(rs.getString(3));

                ul.add(u);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return ul;
    }
    
    
    public int insert(User u) {
	    int a = 0;
	    try {
	        Connection con = getConnect();
	        PreparedStatement ps = con.prepareStatement("insert into tbl1(fname, lname, email, phone, password, role) values(?,?,?,?,?,?)");

	        ps.setString(1, u.getFname());
	        ps.setString(2, u.getLname());
	        ps.setString(3, u.getemail());
	        ps.setString(4, u.getphone());
	        ps.setString(5, u.getpassword());
	        ps.setString(6, u.getrole());

	        a = ps.executeUpdate();

	        con.close();

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return a;
	}

	public boolean checkUser(String rname, String rpass) throws ClassNotFoundException, SQLException {
	    boolean a = false;
	    Connection con = getConnect();
	    String sql = "SELECT * FROM  tbl1 where fname=? and password=?";
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, rname);
	        ps.setString(2, rpass);

	        try (ResultSet rs = ps.executeQuery()) {
	            a = rs.next();
	        }
	    } finally {
	        con.close();
	    }
	    return a;
	}

	// ...

	public ArrayList<User> show1(int start, int total) {
	    ArrayList<User> ull = new ArrayList<>();

	    try {
	        Connection con = getConnect();

	        Statement st = con.createStatement();

	        ResultSet rs = st.executeQuery("select * from tbl1 limit " + (start - 1) + ", " + total + "");

	        while (rs.next()) {
	            User u = new User();
	            u.setUid(rs.getInt(1));
	            u.setFname(rs.getString(2));
	            u.setLname(rs.getString(3));
	            u.setemail(rs.getString(4));
	            u.setphone(rs.getString(5));
	            u.setpassword(rs.getString(6));
	            u.setrole(rs.getString(7)); 

	            ull.add(u); 
	        }

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return ull;
	}

//	public boolean getUserRole(String role1) throws ClassNotFoundException, SQLException {
//		String aa;
//	    Connection con = getConnect();
//	    String sql = "SELECT * FROM  tbl1 where role=?";
//	    try (PreparedStatement ps = con.prepareStatement(sql)) {
//	        ps.setString(1, role1);
//	       
//
//	        try (ResultSet rs = ps.executeQuery()) {
//	            aa = rs.next();
//	        }
//	    } finally {
//	        con.close();
//	    }
//	    return aa;
//	}
	
	
	public String getUserRole(String rname) throws ClassNotFoundException, SQLException {
	    String aa = null;
	    Connection con = getConnect();
	    String sql = "SELECT role FROM tbl1 WHERE fname=?";
	    
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, rname);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                aa = rs.getString("role");
	            }
	        }
	    } finally {
	        con.close();
	    }

	    return aa;
	}


	
	
	public int deletUser(int aid2) throws ClassNotFoundException, SQLException {
		Connection con=getConnect();     
		//step 3
		PreparedStatement st=con.prepareStatement("delete from addmed_2tbl where aid=?");
		st.setInt(1, aid2);
				
		System.out.println("Step 3");
		        
		//step4
		int a=st.executeUpdate();
		System.out.println("Step 4");
		
		//step 5
		con.close();
		System.out.println("Step 5");
		return a;
}
	
	
	
	
	
		
	}
	



