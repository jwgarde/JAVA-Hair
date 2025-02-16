package harishp;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import harishp.*;
import harishp.RESERVE.*;

public class first_screen  extends JPanel implements ActionListener{
	private JFrame frame;
	JLabel titleLabel = new JLabel("Hello, Garden hairshop", SwingConstants.CENTER);
	JButton reserve_btn = new JButton("예약");
	JLabel name_label = new JLabel("", SwingConstants.CENTER);
	JButton reserve_search_Btn = new JButton("예약 내역 조회");
	JButton info_modify= new JButton("정보수정");
	JButton Designer_SEE = new JButton("디자이너");
	JButton btnNewButton = new JButton("로그아웃");
	
	public first_screen(JFrame frame) {
		this.frame = frame;
		initialize();
		start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBackground(Color.white);
		setLayout(null);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
		titleLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
		titleLabel.setBounds(0, 0, 900, 99);
		add(titleLabel);

		reserve_btn.setFont(new Font("굴림", Font.BOLD, 20));
		reserve_btn.setBounds(260, 170, 178, 113);
		reserve_btn.setFocusable(false);
		add(reserve_btn);

		// JLabel로 변경 및 테두리 추가
		name_label.setFont(new Font("굴림", Font.BOLD, 20));
		name_label.setBounds(190, 115, 521, 39);
		User user = User.getinstance();
		
		name_label.setText(user.name() + "님");
		
		add(name_label);
		// JLabel에 테두리 추가 (검은색, 두께 2)
		name_label.setBorder(new LineBorder(Color.BLACK, 2));
		add(name_label);
		
		reserve_search_Btn.setFont(new Font("굴림", Font.BOLD, 20));
		reserve_search_Btn.setBounds(457, 170, 178, 113);
		reserve_search_Btn.setFocusable(false);
		add(reserve_search_Btn);
		
		
		info_modify.setFont(new Font("굴림", Font.BOLD, 20));
		info_modify.setBounds(260, 299, 178, 113);
		info_modify.setFocusable(false);
		add(info_modify);
		
		Designer_SEE.setFont(new Font("굴림", Font.BOLD, 20));
		Designer_SEE.setBounds(457, 300, 178, 113);
		Designer_SEE.setFocusable(false);
		add(Designer_SEE);
		
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(395, 450, 97, 34);
		add(btnNewButton);
		
	}
	 public void start() {
		 btnNewButton.addActionListener(this);
		 reserve_btn.addActionListener(this);
		 reserve_search_Btn.addActionListener(this);
		 info_modify.addActionListener(this);
		 Designer_SEE.addActionListener(this);
		 
	 }
	 public void actionPerformed(ActionEvent e) {
	        Object source = e.getSource();
	        if(source == Designer_SEE || source == reserve_btn) {
	        	Designer_see designer_frame = new Designer_see(frame);
	        	 frame.setContentPane(designer_frame);
	        	 
	        	 
	        }
	        else if(source == btnNewButton) {
	        	login_screen login_frame = new login_screen(frame); 
	        	frame.setContentPane(login_frame);
	        	 
	        }
	        else if(source == info_modify) {
	        	Info_mod info_modify_frame = new Info_mod(frame);
	        	frame.setContentPane(info_modify_frame);
	        	
	        }
	        frame.revalidate();
	 }
}
