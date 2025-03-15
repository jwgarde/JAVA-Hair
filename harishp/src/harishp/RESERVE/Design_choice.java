package harishp.RESERVE;

import harishp.first_screen;
import harishp.login_screen;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.*;
import harishp.DB;
import harishp.Reservation;
import harishp.User;
import harishp.RESERVE.Time_choice_r;
public class Design_choice extends JPanel implements ActionListener{
	 public JFrame GDframe;
	 JPanel designPanel = new JPanel();
	  ResultSet rs = null;
	   PreparedStatement insertStmt = null;
	 JLabel Title = new JLabel("Design Choice", SwingConstants.CENTER);
	 private User user; 
	 private JTextField Design_choice;
	 JToggleButton[] tglbtnNewToggleButtons =  {
		  new JToggleButton("커트"),
		  
		  new JToggleButton("펌"),
		  new JToggleButton("컬러"),
		  new JToggleButton("기타")
	 };
	 
	 private Reservation reservation;
	
	 public Design_choice(JFrame frame, Reservation reservation ,User user) {
		 	this.reservation = reservation;
	    	this.GDframe = frame;
	    	this.user = user;
	        initialize();

	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		

		for(int i = 0 ;  i < tglbtnNewToggleButtons.length; i++) {
			if(source == tglbtnNewToggleButtons[i]) {
				 tglbtnNewToggleButtons[i].setSelected(true);
			}
			else {
				 tglbtnNewToggleButtons[i].setSelected(false);
				}
			
			}
		 change_design();
		 
		 

	}
	private void initialize() {
		setBackground(Color.white);
		setLayout(null);
		  Design_choice = new JTextField("시술 메뉴");
	        Design_choice.setHorizontalAlignment(SwingConstants.CENTER);
	        Design_choice.setForeground(Color.BLACK);
	        Design_choice.setFont(new Font("굴림", Font.BOLD, 18));
	        Design_choice.setEditable(false);
	        Design_choice.setBorder(new LineBorder(Color.BLACK, 2));
	        Design_choice.setBackground(Color.WHITE);
	        Design_choice.setBounds(249, 62, 386, 57);
	        add(Design_choice);

	        Title.setFont(new Font("Serif", Font.BOLD, 40));
	        Title.setBorder(new EmptyBorder(20, 0, 0, 0));
	        Title.setBounds(9, -24, 868, 99);
	        add(Title);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.WHITE);
	        panel.setBorder(new LineBorder(Color.BLACK, 2));
	        panel.setBounds(249, 117, 386, 420);
	        panel.setLayout(new BorderLayout()); // BorderLayout 사용
	        add(panel);

	        JPanel buttonpanel = new JPanel();
	        buttonpanel.setLayout(new GridLayout(1, 4, 10, 10));
	        buttonpanel.setBackground(Color.WHITE);
	        panel.add(buttonpanel, BorderLayout.NORTH); // 버튼 패널을 북쪽에 추가

	        designPanel.setLayout(new GridLayout(0, 1, 10, 10));
	        designPanel.setBackground(Color.WHITE);
	        
	       
			/*
			 * for (int i = 1; i <= 20; i++) { JButton designButton = new JButton("디자인 " +
			 * i); designButton.setPreferredSize(new Dimension(300, 100));
			 * designButton.setBackground(Color.WHITE); designPanel.add(designButton); }
			 */
	        JScrollPane scrollPane = new JScrollPane(designPanel);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        panel.add(scrollPane, BorderLayout.CENTER); // 스크롤 패널을 중앙에 추가

	        // Toggle 버튼 배열 초기화       
	        for (int i = 0; i < tglbtnNewToggleButtons.length; i++) {
	        	if(i == 0) {
	       		 tglbtnNewToggleButtons[i].setSelected(true);
	        	}
	        	else {
	        		tglbtnNewToggleButtons[i].setSelected(false);
	        	}
	        	tglbtnNewToggleButtons[i].addActionListener(this);
	        	tglbtnNewToggleButtons[i].getName();
	            tglbtnNewToggleButtons[i].setPreferredSize(new Dimension(75, 30));
	            tglbtnNewToggleButtons[i].setBackground(Color.WHITE);
	            buttonpanel.add(tglbtnNewToggleButtons[i]);
	        }
	        change_design();
	       
	        setVisible(true);
        
	}
	public void change_design(){
		
		Connection conn = null;
	    PreparedStatement checksmt = null;
	    //ResultSet rs = null;
	    try {
	    	 conn = DB.getInstance().getConnection();
	    	String checkQ = "SELECT Design_num,Design_colum,Design_name,Design_pay,Design_detail FROM design WHERE Designer_ID = ? AND Design_colum = ?";
	    	checksmt = conn.prepareStatement(checkQ);
	    	checksmt.setString(1, reservation.GetDesigner_id());
	    	String selectedColumn = null;
	    	
	    	for(int i = 0; i < tglbtnNewToggleButtons.length; i++) {
	    		if (tglbtnNewToggleButtons[i].isSelected()) {
	    			
	    			selectedColumn = tglbtnNewToggleButtons[i].getText();
	    			
	    			 break;
	    	    }
	    	}
	    	 checksmt.setString(2, selectedColumn);
	    	 rs = checksmt.executeQuery();
	    	 
	    	 designPanel.removeAll();
	    	 
	         designPanel.revalidate(); // UI 업데이트
	         designPanel.repaint(); 
	    	 while(rs.next()) {
	    		 JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    		 buttonPanel.setBackground(Color.WHITE);
	    		 JButton designButton = new JButton("");
	    		 designButton.setPreferredSize(new Dimension(350, 150));
	    		 designButton.setBackground(Color.WHITE);
	    		 designButton.setName(rs.getString("Design_num"));
	    		 //designButton.setText(rs.getString("Design_name"));
	    		 JLabel design_label = new JLabel(rs.getString("Design_name"));
	    		 design_label.setFont(new Font("굴림", Font.BOLD, 13));
	    		 JLabel price_label = new JLabel(rs.getString("Design_pay")+ "원");
	    		 JLabel detail_label = new JLabel("<html><div style='text-align:left; width: 230px;'>"+ rs.getString("Design_detail")+"</div></html>");

	    		 JButton expend_button =  new JButton("더보기");
	    		  JPanel top = new JPanel(new BorderLayout());
	    		  
	    
	    
	    		 price_label.setFont(new Font("굴림", Font.BOLD, 13));
	    		 JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    		 JPanel expend_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    		 expend_panel.setBackground(Color.WHITE);
	    		 
	    		 JPanel DESIGN_PANEL = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    		 DESIGN_PANEL.setBackground(Color.WHITE);
	    		 expend_button.setBackground(Color.WHITE);
	    		 top.setBackground(Color.WHITE);
	    		 DESIGN_PANEL.add(design_label);
	    		 
	    		 
	    		 expend_panel.add(expend_button);
	    		 
	    		 top.add(DESIGN_PANEL, BorderLayout.WEST); // 왼쪽 정렬
	    		 top.add(expend_panel, BorderLayout.EAST); 
	    		 
	    		 
	    		 expend_panel.setBackground(Color.WHITE);
	    		 rightPanel.setBackground(Color.WHITE);
	    		 //expend_panel.setPreferredSize(new Dimension(20, 10));
	    		 rightPanel.add(price_label);
	    		 detail_label.setFont(new Font("굴림", Font.BOLD, 12));
	    		 detail_label.setPreferredSize(new Dimension(330, 100));
	    		 
	    		 designButton.setLayout(new BorderLayout());
	    		 designButton.add(top,BorderLayout.NORTH);
	    		 designButton.add(rightPanel ,BorderLayout.SOUTH);
	    		 designButton.add(detail_label,BorderLayout.CENTER);
	    		 //designButton.add(expend_panel,BorderLayout.NORTH);
	    		 buttonPanel.add(designButton);   // 버튼을 패널에 추가
	    		    designPanel.add(buttonPanel); 
		         //designPanel.add(designButton);
					
					 designButton.addMouseListener(new MouseAdapter(){ 
						 public void mouseClicked(MouseEvent e) { 
							 	
							 	 reservation.SetDesign_num(designButton.getName());
							 	 System.out.print(designButton.getText());
							 	//reservation.Setpayment_amount(design_Pay);
							 	String amountText = price_label.getText().replace("원", "");  
							 	UUID uuid = UUID.randomUUID();
							 	reservation.Setreserve_num(uuid.toString());
							 	
							 int amount = Integer.parseInt(amountText); 
							 reservation.Setpayment_amount(amount);

							 	final_reserve final_reserve_panel = new final_reserve(reservation,user);
							 	final_reserve_panel.setVisible(true);
							 	first_screen screen = new first_screen(GDframe,user);
							 	GDframe.setContentPane(screen);
								 GDframe.revalidate(); 
								 GDframe.repaint(); 
					  } });
					 
	    		    expend_button.addMouseListener(new  MouseAdapter(){
	    		    	 public void mouseClicked(MouseEvent e) {
	    		    		 reservation.SetDesign_num(designButton.getName());
	    		    		 System.out.println(designButton.getName());
	    		    		 System.out.println(design_label.getText());
	    		    		 expend expend_frame = new expend();
	    		    		 expend_frame.setVisible(true); 
	    		    	 }
	    		    });
		         
	    	 }
	    	
	    }catch(SQLException e) {
			 e.printStackTrace();
		 }
	}
 class expend extends JFrame{
		 public expend() {
			 initialize2(); 
		 }
		
	 private  void initialize2() {
		 	setSize(500,450);
		 	setBackground(new Color(255, 255, 255));
		 	JPanel extend_panel = new JPanel(new BorderLayout());
		 	extend_panel.setBackground(Color.WHITE);
		 	extend_panel.setBorder(new LineBorder(Color.BLACK, 2));
		 	
		 	add(extend_panel);
		 	Connection conn = null;
		    PreparedStatement checksmt = null;
		    ResultSet rs = null;
		    try {
		    	 conn = DB.getInstance().getConnection();
		    	String checkQ = "SELECT Design_name,Design_pay,Design_detail FROM design WHERE Design_num = ?";
		    	checksmt = conn.prepareStatement(checkQ);
		    	checksmt.setString(1, reservation.GetDesign_num());
		    	
		    	 rs = checksmt.executeQuery();
		    	 if (rs.next()) {
		    		 JLabel design_name = new JLabel();
		    		 design_name.setText(rs.getString("Design_name"));
		    		 
		    		 JPanel top = new JPanel(new FlowLayout());
		    		 top.add(design_name, BorderLayout.CENTER); 
		    		 top.setBackground(Color.WHITE);
		    		 design_name.setFont(new Font("굴림", Font.BOLD, 25));
		    		 extend_panel.add(top,BorderLayout.NORTH);
		    		 JLabel design_detail = new JLabel();
		    		 design_detail.setText("<html><div style='text-align:left; width: 230px;'>"+rs.getString("Design_detail")+"</div></html>");
		    		 design_detail.setFont(new Font("굴림", Font.BOLD, 15));
		    		 JPanel center = new JPanel(new FlowLayout());
		    		 center.setBackground(Color.WHITE);
		    		 center.add(design_detail, BorderLayout.CENTER); 
		    		 extend_panel.add(center,BorderLayout.CENTER);
		    		 JLabel design_price = new JLabel();
		    		 JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		    		
		    		 rightPanel.setBackground(Color.WHITE);
		    		 design_price.setFont(new Font("굴림", Font.BOLD, 15));
		    		 design_price.setText(rs.getString("Design_pay")+"원");
		    		 rightPanel.add(design_price);
		    		 //bottom.add(design_price, BorderLayout.EAST); 
		    		 extend_panel.add(rightPanel,BorderLayout.SOUTH);
		    		 
		    	 }
		    }catch(SQLException e) {
				 e.printStackTrace();
			 }
	 	}
}
 static class final_reserve  extends JFrame {
	 private Reservation reservation;
	 PreparedStatement insertStmt = null;
	 Connection conn = null;
	 ResultSet rs = null;
	 
	 private User USER;
	public final_reserve(Reservation reservation, User user){
		this.USER = user;
		this.reservation = reservation;
		 conn = DB.getInstance().getConnection(); // 연결 객체 초기화
		   initialize();
	
	}
	 private void initialize() {
		setTitle("예약 완료");
		System.out.print(reservation.Getreserve_num());
		 setSize(400,300);
		 setLocationRelativeTo(null);
		 JLabel reserve_label = new JLabel("예약이  완료되었습니다.", SwingConstants.CENTER);
		 reserve_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		 add(reserve_label, BorderLayout.CENTER);
         add(reserve_label);
         JLabel time_label = new JLabel("5", SwingConstants.CENTER);
         time_label.setBounds(100, 50, 100, 50);
         time_label.setFont(time_label.getFont().deriveFont(30.0f));
         try {
        	 
 			String insertQuery =  "INSERT INTO reserve_table (reserve_num, reserve_date,reserve_requirements,payment_amount,reserve_status,memeber_id,designer_id,Design_num)VALUES(?,?,?,?,?,?,?,?)";
 			insertStmt = conn.prepareStatement(insertQuery);
 			 insertStmt.setString(1, reservation.Getreserve_num());
 			 insertStmt.setDate(2, Date.valueOf(reservation.Getdate()));
 			 insertStmt.setString(3,"없음");
 			 insertStmt.setInt(4, reservation.Getpayment_amount());
 			 insertStmt.setBoolean(5,true);
 			 insertStmt.setString(6, USER.getID());
 			 insertStmt.setString(7, reservation.GetDesigner_id());
 			 insertStmt.setString(8, reservation.GetDesign_num());
 			 
 			// rs = insertStmt.executeQuery();
// 			 int rowsAffected = insertStmt.executeUpdate();
// 			 if(rowsAffected > 0) {
// 	
// 				 setVisible(true); 
// 				 login_screen login_panel = new login_screen(garden);
// 				 setContentPane(login_panel);
// 				 revalidate();
// 				 repaint(); 
// 				 
// 			 }
 		}catch(SQLException e1) {
 			e1.printStackTrace();
 		}finally {
			try {
                if (insertStmt != null) {
                	insertStmt.close();
                	
                }
                
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}
         add(time_label,BorderLayout.SOUTH);
         Timer timer = new Timer();
         final int[] count = {5};
         TimerTask task = new TimerTask() {

			@Override
			public void run() {
				count[0]--;
				SwingUtilities.invokeLater(() -> time_label.setText(String.valueOf(count[0])));
				
				if(count[0] <= 0) {
					
					dispose();
					timer.cancel(); 
					
				}
			}
        	 
         };
         timer.scheduleAtFixedRate(task, 0, 1000);
         setLocationRelativeTo(null);
         setVisible(true);
	 }
   }
}
