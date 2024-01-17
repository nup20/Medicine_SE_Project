package model;

public class User {
	private int uid;
	private String Fname;
	private String Lname;
	private String email;
	private String phone;
	private String password;
	private String role;
	

	public User(  String Fname,String Lname, String email, String phone,String password,String role) {
		super();
		this.Fname = Fname;
		this.Lname = Lname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}
	
	public User( int uid, String Fname,String Lname, String email, String phone,String password,String role) {
		super();
		this.uid = uid;
		this.Fname = Fname;
		this.Lname = Lname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}
	
	

	public User() {
		super();
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String Fname) {
		this.Fname = Fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String Lname) {
		this.Lname =Lname;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", role=" + role + "]";
	}
	




	
}

