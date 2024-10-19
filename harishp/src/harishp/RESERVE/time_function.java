package harishp.RESERVE;
import javax.swing.JButton;
public class time_function {
	JButton[] M_buttons;
	JButton[] A_buttons;
	int hour, min;
	int year, month, day;
	public time_function(int year, int month, int day) {
			this.year = year;
			this.month = month;
			this.day = day;
			System.out.println(year);
			System.out.println(month);
			System.out.println(day);
	}
	public void setButton(JButton[] M_buttons,JButton[] A_buttons) {
		this.M_buttons = M_buttons;
		this.A_buttons = A_buttons;
		
	}
	public String setString() {
		return year + "년" + month + "월";
	}	
	public void time_Set() {
		for(int i = 0; i < M_buttons.length ; i++) {
			M_buttons[i].setText("");
			//buttons[i].setEnabled(false);
		}
		for(int i = 0; i < A_buttons.length ; i++) {
			A_buttons[i].setText("");
			//buttons[i].setEnabled(false);
		}
			hour = 9;
			min = 0;
			for(int i = 0; i < M_buttons.length; i++) {
				M_buttons[i].setText(String.format("%d:%02d",+hour,min));
				min += 30;
				if(min == 60) {
					hour += 1;
					min=0;
				}
			}
			hour = 12;
			min = 0;
			for(int i = 0; i < A_buttons.length; i++) {
				  A_buttons[i].setText(String.format("%d:%02d", (hour / 13) + hour % 13, min));
				min += 30;
				if(min == 60) {
					hour += 1;
					min = 0;
				}
			}
	}
}
