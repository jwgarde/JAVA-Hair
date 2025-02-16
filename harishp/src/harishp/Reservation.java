package harishp;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
	private String reserve_num;
	private  String User_id;
	private String Designer_id;
	private String Design_num;
	private LocalTime time;
	private LocalDate date;
	private String requirements;
	private int payment_amount;
	private boolean status = false;
	
	public Reservation() {
		time = null;
		reserve_num = null;
		date = null;
		requirements = null;
		payment_amount = 0;
		status = false;
		User_id = null;
		Designer_id = null;
		Design_num = null;
	}
	public String  Getreserve_num() {return reserve_num;}
	public void Setreserve_num(String reserve_num) {this.reserve_num = reserve_num;}
	
	public LocalDate  Getdate() {return date;}
	public void Setdate(LocalDate date) {this.date = date;}
	
	public LocalTime  Gettime() {return time;}
	public void Settime(LocalTime time) {this.time = time;}
	
	public String  Getrequirements() {return requirements;}
	public void Setrequirements(String requirements) {this.requirements = requirements;}
	
	public int  Getpayment_amount() {return payment_amount;}
	public void Setpayment_amount(int payment_amount) {this.payment_amount = payment_amount;}

	
	public boolean  GetStatus() {return status;}
	public void SetStatus(boolean Status) {this.status = Status;}
	

	public String GetUser_id() {return User_id;}
	public void SetUser_id(String User_id) {this.User_id = User_id;}
	
	
	public String GetDesigner_id() {return Designer_id;}
	public void SetDesigner_id(String Designer_id) {this.Designer_id = Designer_id;}
	
	

	public String GetDesign_num() {return Design_num;}
	public void SetDesign_num(String Design_num) {this.Design_num = Design_num;}
	
}
