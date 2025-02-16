package harishp;


public class User {
	private static User instance;
	private String ID ;
	private String password ;
	private String name ;
	private String phone;
	private String gender;
	private String brith;
	
	private User() {}
	
	public static User getinstance() {
		if(instance == null) {
			instance = new User();
			
		}
		return instance;
		
	}
	public String getID() {
		return ID;
	}
	public String password() {
		return password;
	}
	public String phone() {
		return phone;
	}
	public String brith() {
		return brith;
	}
	public String name() {
		return name;
	}
	public String gender() {
		return gender;
	}
	
	public void SetString(String ID,String password, String phone, String brith, String name, String gender) { 
		this.ID = ID;
		this.password = password;
		this.phone = phone;
		this.brith = brith;
		this.name = name;
		this.gender = gender;
		
	}
}
