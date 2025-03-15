package harishp.RESERVE;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import harishp.Reservation;
import harishp.User;

public class Time_choice_r extends JPanel  implements ActionListener {
	JFrame GDframe;
	private int year = 0, month = 0,day = 0;
  //  private JTextField textField;
    JLabel year_month = new JLabel("00년00월", SwingConstants.CENTER);
    JButton[] M_buttons = new JButton[6];
    JButton[] A_buttons = new JButton[17];
   
    private Reservation reservation;
    private User user ;
    
    time_function TF = new time_function(year,month,day);
    public Time_choice_r(JFrame frame,Reservation reservation, User user) {
    	this.reservation = reservation;
    	this.GDframe = frame;
    	this.user =  user;
        initialize();
        //start();
    }

    private void initialize() {
    	
    	setBackground(Color.WHITE);
    	setLayout(null);
    	JTextField textField = new JTextField("시간 선택");
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setForeground(Color.BLACK); 
        textField.setFont(new Font("굴림", Font.BOLD, 18));
        textField.setEditable(false);
        textField.setBorder(new LineBorder(Color.BLACK, 2));
        textField.setBackground(Color.WHITE);
        textField.setBounds(249, 62, 386, 57);
        add(textField);

        JLabel lblDateAndTime = new JLabel("Date and Time", SwingConstants.CENTER);
        lblDateAndTime.setFont(new Font("Serif", Font.BOLD, 40));
        lblDateAndTime.setBorder(new EmptyBorder(20, 0, 0, 0));
        lblDateAndTime.setBounds(9, -24, 868, 99);
        add(lblDateAndTime);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.BLACK, 2));
        panel.setBounds(249, 117, 386, 420);
        add(panel);

        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);

        // 오전 패널
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel moringLabel = new JLabel("오전", SwingConstants.CENTER);
        moringLabel.setFont(new Font("굴림", Font.BOLD, 14));
        panel.add(moringLabel, gbc);

        for (int i = 0; i < M_buttons.length; i++) {
            M_buttons[i] = new JButton();
            M_buttons[i] .addActionListener(this);
            M_buttons[i].setPreferredSize(new java.awt.Dimension(67, 35));
            gbc = new GridBagConstraints(); // 새 인스턴스 생성
            gbc.gridx = i % 4; // 4개씩 배치
            gbc.gridy = (i / 4) + 1; // 행 증가
            gbc.gridwidth = 1;
            gbc.insets = new Insets(4,8,4,8);
            panel.add(M_buttons[i], gbc);
        }

        // 오후 패널
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3; // 오후 버튼은 오전 버튼 아래에 배치
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        JLabel afternoonLabel = new JLabel("오후", SwingConstants.CENTER);
        afternoonLabel.setFont(new Font("굴림", Font.BOLD, 14));
        panel.add(afternoonLabel, gbc);

        for (int i = 0; i < A_buttons.length; i++) {
            A_buttons[i] = new JButton();
            A_buttons[i] .addActionListener(this);
            A_buttons[i].setPreferredSize(new java.awt.Dimension(67, 35));
            gbc = new GridBagConstraints(); // 새 인스턴스 생성
            gbc.gridx = i % 4; // 4개씩 배치
            gbc.gridy = (i / 4) + 4; // 행 증가
            gbc.gridwidth = 1;
            gbc.insets = new Insets(4, 8, 4, 8);
            panel.add(A_buttons[i], gbc);
        }
        TF.setButton(M_buttons,A_buttons);
        TF.time_Set();
        panel.setVisible(true);
    }

	/*
	 * private void start() {
	 * 
	 * }
	 */

    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
	   String timeText = null;
       for(int i = 0; i < A_buttons.length; i++) {
    	   if(source == A_buttons[i]) {
    		   timeText = A_buttons[i].getText() +" PM";
    	   }
    	   else {
    		   if(i < M_buttons.length) {
    			   if(source == M_buttons[i]) {
    				   timeText = M_buttons[i].getText() + " AM";
    	    	   }	
    		   }
    	   }
       }
      DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("h:mm a",Locale.ENGLISH);
      LocalTime time = LocalTime.parse(timeText, inputFormatter);
      	
      
      time.format(DateTimeFormatter.ofPattern("HH:mm"));	
       reservation.Settime(time);
       System.out.println(reservation.Gettime());
       
       Design_choice Design_panel = new Design_choice(GDframe,reservation,user);
	   GDframe.setContentPane(Design_panel);
	   GDframe.revalidate();
      }	
}
