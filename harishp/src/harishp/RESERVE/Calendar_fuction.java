package harishp.RESERVE;
import java.util.Calendar;
import javax.swing.JButton;
public class Calendar_fuction {
	JButton[] buttons;
	Calendar cal = Calendar.getInstance();
	int year, month;
	public Calendar_fuction() {
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
	}
	public void SetButton(JButton[] buttons) {
		this.buttons = buttons;
	}
	public String setString() {
		return year + "년" + month + "월";
	}

	public void calSet() {
		cal.set(year, month-1,1);
		int first_day = cal.get(Calendar.DAY_OF_WEEK);
		first_day--;
		for(int i = 7; i < buttons.length; i++) {
			buttons[i].setText("");
			buttons[i].setEnabled(false);
		}
		for(int i = 1;i <= cal.getActualMaximum(cal.DATE); i++) {
			buttons[6+first_day+i].setText(String.valueOf(i));
			buttons[6 + first_day + i].setEnabled(true);
		}
	}
	public void update(int gap) {
		for(int i = 7; i < buttons.length; i++) {
			buttons[i].setText("");
		}
		month += gap;
		if(month <= 0) {
			year--;
			month = 12;
		}
		else if(month >= 13) {
			year ++;
			month = 1;
			
		}
		calSet();
	}
}
