package harishp.RESERVE;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class Designer_see extends JPanel implements ActionListener{

	private JFrame GDframe;
	private JTextField designer_name;
	private JButton review_btn;
	private JButton before_btn;
	private JButton after_btn;
	private JTextArea textArea;
	JLabel title_Label = new JLabel("Designer", SwingConstants.CENTER);
	private JButton contentpane_before;
	private JButton reserve_check_BTN; 

	public Designer_see(JFrame frame2) {
		// TODO Auto-generated constructor stub
		this.GDframe = frame2;
		initialize();
		start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBackground(Color.white);
		setLayout(null);
		title_Label.setFont(new Font("Serif", Font.BOLD, 40));
		title_Label.setBorder(new EmptyBorder(20, 0, 0, 0));
		title_Label.setBounds(9, -24, 788, 99);
		add(title_Label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(229, 116, 336, 263);
		lblNewLabel.setBorder(new LineBorder(Color.BLACK, 2));
		add(lblNewLabel);
		
		review_btn = new JButton("★방분자 리뷰 100");
		review_btn.setForeground(new Color(33, 120, 216));
		review_btn.setFont(new Font("굴림", Font.PLAIN, 10));
		review_btn.setBounds(444, 97, 132, 23);
		review_btn.setOpaque(false); // 버튼 배경을 투명하게 설정
		review_btn.setContentAreaFilled(false);
		review_btn.setBorderPainted(false);
		add(review_btn);
		
		designer_name = new JTextField();
		designer_name.setEditable(false);
		designer_name.setFont(new Font("굴림", Font.BOLD, 20));
		designer_name.setForeground(new Color(0, 0, 0));
		designer_name.setBackground(new Color(255, 255, 255));
		designer_name.setHorizontalAlignment(SwingConstants.CENTER);
		designer_name.setText("최정원 원장");
		designer_name.setColumns(10);
		designer_name.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		designer_name.setBounds(229, 62, 336, 57);
		add(designer_name);
		
		before_btn = new JButton("<");
		before_btn.setFont(new Font("굴림", Font.BOLD, 25));
		before_btn.setBounds(150, 226, 97, 62);
		before_btn.setOpaque(false); // 버튼 배경을 투명하게 설정
		before_btn.setContentAreaFilled(false);
		before_btn.setBorderPainted(false);
		before_btn.setFocusable(false);
		add(before_btn);
		
		after_btn = new JButton(">");
		after_btn.setFont(new Font("굴림", Font.BOLD, 25));
		after_btn.setToolTipText("");
		after_btn.setBounds(552, 226, 97, 62);
		after_btn.setOpaque(false); // 버튼 배경을 투명하게 설정
		after_btn.setContentAreaFilled(false);
		after_btn.setBorderPainted(false);
		after_btn.setFocusable(false);
		add(after_btn);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 377, 336, 78);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		textArea.setEditable(false);
		textArea.setText("");
		scrollPane.setViewportView(textArea);
		 // 줄바꿈 설정 (선택 사항)
        textArea.setLineWrap(true);  // 자동 줄바꿈
        textArea.setWrapStyleWord(true); 
        textArea.setCaretPosition(0);
        
        contentpane_before = new JButton("←");
        contentpane_before.setToolTipText("");
        contentpane_before.setOpaque(false);
        contentpane_before.setFont(new Font("굴림", Font.BOLD, 25));
        contentpane_before.setContentAreaFilled(false);
        contentpane_before.setBorderPainted(false);
        contentpane_before.setBounds(-16, 10, 97, 62);
        add(contentpane_before);
        contentpane_before.setFocusable(false);
        
       reserve_check_BTN = new JButton("예약");
       reserve_check_BTN.setBounds(349, 470, 97, 23);
       reserve_check_BTN.setFocusable(false);
       add(reserve_check_BTN);
        
	}
	public void start() {
		reserve_check_BTN.addActionListener(this);
	}
	 public void actionPerformed(ActionEvent e) {
		 Object source = e.getSource();
		 if(source == reserve_check_BTN) {
			 Date_Time_Choice Date_Time_panel = new Date_Time_Choice(GDframe);
			 GDframe.setContentPane(Date_Time_panel);
			 GDframe.revalidate(); 
		 }
	 }
}
