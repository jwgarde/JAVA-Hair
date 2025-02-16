package harishp;

public class Designer {
	private static Designer instance;
	private String Designer_ID;
	private String Designer_Phone;
	private String Designer_gender;
	private String Designer_brith;
	private String Designer_pass;
	private String Designer_introduce;
	private String Designer_nickname;
	private String Designer_name;
	private boolean Designer_manager;
	private String Designer_priofile;
	private Designer (){};
	
	public static Designer getinstance() {
		if(instance == null) {
			instance = new Designer();
			
		}
		return instance;
		
	}
    public String getDesignerID() { return Designer_ID; }
    public String getPassword() { return Designer_pass; }
    public String getPhone() { return Designer_Phone; }
    public String getBirth() { return Designer_brith; }
    public String getName() { return Designer_name; }
    public String getGender() { return Designer_gender; }
    public String getIntroduce() { return Designer_introduce; }
    public String getNickname() { return Designer_nickname; }
    public String getProfile() { return Designer_priofile; }
    public boolean isManager() { return Designer_manager; }
	
public void SetString(String ID,String password, String phone, String brith, String name, String gender,String introduce, String Designer_nickname, String profile, boolean Designer_manager) { 
	this.Designer_ID = ID;
	this.Designer_pass = password;
	this.Designer_Phone = phone;
	this.Designer_brith = brith;
	this.Designer_name = name;
	this.Designer_gender = gender;
	this.Designer_introduce = introduce;
	this.Designer_nickname = Designer_nickname;
	this. Designer_priofile = profile;
	this.Designer_manager = Designer_manager;
	
}
}
