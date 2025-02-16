package harishp.RESERVE;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import harishp.DB;
import harishp.Designer;
import harishp.Reservation;
import harishp.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class Designer_see extends JPanel implements ActionListener {
	int Designer_page = 0;
	private JFrame GDframe;
	private JTextField designer_name = new JTextField();;
	private JButton review_btn;
	private JButton before_btn;
	private JButton after_btn;
	private JTextArea textArea;
	JLabel imagelabel = new JLabel("");
	JLabel title_Label = new JLabel("Designer", SwingConstants.CENTER);
	private JButton contentpane_before;
	private JButton reserve_check_BTN; 

	public Designer_see(JFrame frame2) {
		// TODO Auto-generated constructor stub
		this.GDframe = frame2;
		initialize();
		try {
			setDeigner();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		title_Label.setBounds(9, -24, 868, 99);
		add(title_Label);
		
		imagelabel.setIcon(null);
		imagelabel.setBounds(249, 117, 386, 330);
		imagelabel.setBorder(new LineBorder(Color.BLACK, 2));
		add(imagelabel);
		
		review_btn = new JButton("★방분자 리뷰 100");
		review_btn.setForeground(new Color(33, 120, 216));
		review_btn.setFont(new Font("굴림", Font.PLAIN, 10));
		review_btn.setBounds(470, 97, 212, 23);
		review_btn.setOpaque(false); // 버튼 배경을 투명하게 설정
		review_btn.setContentAreaFilled(false);
		review_btn.setBorderPainted(false);
		add(review_btn);
		
		designer_name.setEditable(false);
		designer_name.setFont(new Font("굴림", Font.BOLD, 18));
		designer_name.setForeground(new Color(0, 0, 0));
		designer_name.setBackground(new Color(255, 255, 255));
		designer_name.setHorizontalAlignment(SwingConstants.CENTER);
		designer_name.setText("");
		designer_name.setColumns(10);
		designer_name.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		designer_name.setBounds(249, 62, 386, 57);
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
		after_btn.setBounds(632, 226, 97, 62);
		after_btn.setOpaque(false); // 버튼 배경을 투명하게 설정
		after_btn.setContentAreaFilled(false);
		after_btn.setBorderPainted(false);
		after_btn.setFocusable(false);
		add(after_btn);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 445, 386, 95);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		textArea.setEditable(false);
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
       reserve_check_BTN.setBounds(395, 550, 97, 23);
       reserve_check_BTN.setFocusable(false);
       add(reserve_check_BTN);
        
	}
	public void start() {
		reserve_check_BTN.addActionListener(this);
		before_btn.addActionListener(this);
		after_btn.addActionListener(this);
	}
	 public void actionPerformed(ActionEvent e) {
		 Object source = e.getSource();
		 if(source == reserve_check_BTN) {
			
			 Designer designer =  Designer.getinstance();
			 Reservation reservation = new Reservation();
			 reservation.SetDesigner_id(designer.getDesignerID());
			 Date_Time_Choice Date_Time_panel = new Date_Time_Choice(GDframe,reservation);
			 GDframe.setContentPane(Date_Time_panel);
			 GDframe.revalidate(); 
		 }
		 if(source == before_btn) {
			 if(Designer_page > 0) {
				 try {
					Designer_page--;
					setDeigner();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 } 
			 else {
				 Designer_page = 0;
			 }
		 }
		 else if(source == after_btn) {
			 
			 try {
				   Designer_page++;
					setDeigner();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 }
	 }
	 public void setDeigner() throws IOException {
		 Connection conn = null;
		 PreparedStatement selectsmt = null;
		 ResultSet rs = null;
		 
		 try {
			 conn = DB.getInstance().getConnection();
			 String select_Q =  "SELECT Designer_id, Designer_phone,Designer_gender,Designer_brith,Designer_pass,Designer_introduce,Designer_nickname,Designer_name,Designer_manager,profile FROM designer ORDER BY Designer_ID LIMIT 1 OFFSET ?";
			 selectsmt = conn.prepareStatement(select_Q);
			 selectsmt.setInt(1, Designer_page);
			 rs = selectsmt.executeQuery();
			 if (rs.next()) {
				    Designer designer =  Designer.getinstance();
				    designer.SetString(rs.getString("Designer_id"), rs.getString("Designer_pass"),  rs.getString("Designer_phone"), rs.getString("Designer_brith"),  rs.getString("Designer_name"),  rs.getString("Designer_gender"),  rs.getString("Designer_introduce"), rs.getString("Designer_nickname"), rs.getString("profile"),rs.getBoolean("Designer_manager"));
				    designer_name.setText(designer.getNickname() + " 디자이너");
				    File file = new File(designer.getProfile());
				    BufferedImage img = ImageIO.read(file);
				    Image scaledImage = img.getScaledInstance(386, 330, Image.SCALE_SMOOTH);
				    imagelabel.setIcon(new ImageIcon(scaledImage));
				    textArea.setText(designer.getIntroduce());
				    add(imagelabel);
				    revalidate();
				    repaint();
				    
				    
				}
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
	 }
}
