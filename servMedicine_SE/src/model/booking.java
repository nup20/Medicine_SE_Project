package model;

public class booking {

	private int id;
	private  String company3;
	private String  medicine3;
	private String name3;
	private String  phone3;
	private String  quantity3;
public booking(String company3, String medicine3,String name3,String phone3 ,String quantity3) {
	super();
		this.company3= company3;
		this.medicine3 = medicine3;
		this.name3=name3;
		this.phone3 = phone3;
		this.quantity3 = quantity3;
		
	
}

	public booking(int id,String company3, String medicine3,String name3,String phone3 ,String quantity3) {
		super();
		this.id=id;
		this.company3= company3;
		this.medicine3 = medicine3;
		this.name3=name3;
		this.phone3 = phone3;
		this.quantity3 = quantity3;
	}
	
	
	
	
	
	

	public booking() {
		super();
	}

	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getcompany3() {
		return company3;
	}
	public void setcompany3(String company3) {
		this.company3 = company3;
	}
	public String getmedicine3() {
		return medicine3;
	}
	public void setmedicine3(String medicine3) {
		this.medicine3 =medicine3;
	}
	public String getname3() {
		return name3;
	}
	public void setname3(String name3) {
		this.name3 = name3;
	}
	public void setphone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getphone3() {
		return phone3;
	}
	public String getquantity3() {
		return quantity3;
	}
	public void setquantity3(String quantity3) {
		this.quantity3 =quantity3;
	}

	@Override
	public String toString() {
		return "booking [id=" + id + ", company3=" + company3 + ", medicine3=" + medicine3 + ", name3=" + name3
				+ ", phone3=" + phone3 + ", quantity3=" + quantity3 + "]";
	}

	

	
}
