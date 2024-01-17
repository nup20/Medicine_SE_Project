package model;

public class User2 {
	
		private int aid2;
		private String company2;
		private String medicine2;
		
		public	User2(){
			super();
		}
	
	public User2(String company2, String medicine2) {
		
		this.company2= company2;
		this.medicine2 = medicine2;
	}

	public User2(int aid2,String company2, String medicine2) {
		this.aid2= aid2;
		this.company2= company2;
		this.medicine2 = medicine2;
	}
	
	
	
	
	
	
	public int getaid2() {
		return aid2;
	}
	public void setaid(int aid2) {
		this.aid2 = aid2;
	}
	public String getcompany2() {
		return company2;
	}
	public void setcompany2(String company2) {
		this.company2 = company2;
	}
	public String getmedicine2() {
		return medicine2;
	}
	public void setmedicine2(String medicine2) {
		this.medicine2 =medicine2;
	}

	@Override
	public String toString() {
		return "User2 [aid2=" + aid2 + ", company2=" + company2 + ", medicine2=" + medicine2 + "]";
	}

	

	

}
