package harishp;

import java.awt.event.FocusEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.FocusListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import harishp.login_screen;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import harishp.SINGN_UP.singn_up;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class SINGN_UP extends JPanel implements ActionListener{

private static final FocusListener FoucusListener = null;
	//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_3;
//	private JTextField textField_4;
	JTextField[] textFields = new JTextField[5];
	 String[] placeholderTexts = {
	            "아이디",
	            "비밀번호     ex)영문 숫자 포함 최대 11글자",
	            "이름",
	            "전화번호     ex)010XXXXXXXX",
	            "생년월일     ex)20030728 "
	   };
	private JFrame frmGarden;
	 JToggleButton tglbtnNewToggleButton = new JToggleButton("남자");
	 JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("여자");
	 JButton btnNewButton = new JButton("아이디 중복 확인");
	 String gender = "";
	 PreparedStatement checksmt = null;
	 PreparedStatement insertStmt = null;
	 ResultSet rs = null;
	 boolean check_membership = false;
	 JLabel idcheck = new JLabel("");
	 JLabel passwordcheck = new JLabel("");
	 JLabel namecheck = new JLabel();
	 JLabel phonecheck = new JLabel();
	 JLabel btirhdaycheck = new JLabel();
	 JButton btnNewButton_1_1 = new JButton("회원가입");
	 
	 public class Booleanstruct{
		 public boolean id = false;
		 public boolean PW = false;
		 public boolean brtih = false;
		 public boolean name = false;
		 public boolean phone  = false;
		 
	 }
	 Booleanstruct struct = new Booleanstruct();
	
	 /**
	 * Create the application.
	 */
	public SINGN_UP(JFrame FRAME) {
		this.frmGarden = FRAME;
		initialize();
		start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(Color.WHITE);
		setLayout(null);    
	    JLabel titleLabel = new JLabel("Sign Up", SwingConstants.CENTER);
	    titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
	    titleLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
	    titleLabel.setBounds(55, -24, 788, 99);
	    add(titleLabel);
	    
	    tglbtnNewToggleButton.setBackground(new Color(171, 180, 237));
	    tglbtnNewToggleButton.setBounds(314, 397, 99, 23);
	    add(tglbtnNewToggleButton);
	    
	    tglbtnNewToggleButton_1.setBackground(new Color(242, 181, 182));
	    tglbtnNewToggleButton_1.setBounds(451, 397, 99, 23);
	    add(tglbtnNewToggleButton_1);
	    
	    
	    btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 10));
	    btnNewButton.setBounds(647, 94, 125, 23);
        add(btnNewButton);
	    
	    btnNewButton_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	    btnNewButton_1_1.setBounds(451, 460, 189, 31);
	    add(btnNewButton_1_1);
	    
	    JButton btnNewButton_1_1_1 = new JButton("이전");
	    btnNewButton_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	    btnNewButton_1_1_1.setBounds(235, 460, 181, 31);
	    add(btnNewButton_1_1_1);
	    
	    
	    int x = 235, y =  90 , z =  405, q =31 ;
	    for(int i = 0; i < textFields.length; i++) {
	    	  textFields[i] = new JTextField(placeholderTexts[i], 20);
	    	  textFields[i] .setBounds(x,y,z,q);
	    	  textFields[i].setColumns(10); 
	    	  int finalI = i;
	    	  textFields[i].addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                    if (textFields[finalI].getText().equals(placeholderTexts[finalI])) {
	                        textFields[finalI].setText("");
	                      //  textFields[finalI].setForeground(Color.BLACK); // 텍스트 색상 변경
	                    }
	                }
	            });
	    	  add(textFields[i]);
	    	  y += 61;
	    	  
	    }
	    for (JTextField textField : textFields) {
	    textFields[1].addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {//텍스트 필드에 포커스가 들어왔을 때
				
				passwordcheck.setText("");
				struct.PW = false;
			}

			@Override
			public void focusLost(FocusEvent e) { //포커스가 텍스트필드에서 사라졌을 때 실행 텍스트 필드의 라벨을 가져온다
				
				if(textField == textFields[1]) {
					
				String password = textFields[1].getText();
				if(!isValidPassword(password)) {
					passwordcheck.setText("잘못된 비밀번호 형식입니다.");
					passwordcheck.setBounds(235, 166, 405, 33);
					passwordcheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
					passwordcheck.setBorder(new EmptyBorder(20, 0, 0, 0));
					passwordcheck.setForeground(Color.RED);
					
				}
				else {
					passwordcheck.setText("사용가능한 비밀번호입니다.");
					passwordcheck.setBounds(235, 166, 405, 33);
					passwordcheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
					passwordcheck.setBorder(new EmptyBorder(20, 0, 0, 0));
					passwordcheck.setForeground(new Color(0,128,0));
					struct.PW = true;
					
				}
				if(!isAncestorOf(passwordcheck)) {
					add(passwordcheck);
				}
				}
				 revalidate();
                 repaint();
				
			}
			public static boolean isValidPassword(String password)  {
		    	return password.length() >= 8 && 
		    			password.length() < 13 &&
		    			password.matches(".*[a-zA-Z].*") && 	
		    			password.matches(".*\\d.*");
		    			
		    }
	    	
	    });
	    
	    textFields[0].addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				idcheck.setText("");
				struct.id = false;
				
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(textFields[0].getText().equals("")) {
					
					idcheck.setText("잘못된 아이디 형식입니다.");
					 idcheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
					 idcheck.setBorder(new EmptyBorder(20, 0, 0, 0));
					 idcheck.setBounds(235, 105, 405, 33);
					 idcheck.setForeground(Color.RED);
					 if(!isAncestorOf(idcheck)) {
						 add(idcheck);
					 }
					
				}
				
			}
	    
	    	
	    });
	    textFields[2].addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				namecheck.setText("");
				struct.name = false;
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(textFields[2].getText().equals("")) {
					namecheck.setText("이름을 입력해주세요!");
					namecheck.setBounds(235, 227, 405, 33);
					namecheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
					namecheck.setBorder(new EmptyBorder(20, 0, 0, 0));
					namecheck.setForeground(Color.RED);
					 if(!isAncestorOf(namecheck)) {
						 add(namecheck);
					 }
				}
				else {
					struct.name = true;
				}
				
			}
	    	
	    });
	    textFields[3].addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				phonecheck.setText("");
				struct.phone = false;
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if( textFields[3].getText().equals("") || !textFields[3].getText().matches("^010-[0-9]{4}-[0-9]{4}$")) {
					phonecheck.setText("올바른 전화번호 형식에 맞게 작성해주세요");
					phonecheck.setBounds(235, 288, 405, 33);
					phonecheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
					phonecheck.setBorder(new EmptyBorder(20, 0, 0, 0));
					phonecheck.setForeground(Color.RED);
				}
				else {
					try {
						 Connection conn = DB.getInstance().getConnection();
						 String checkQuery = "SELECT COUNT(*) FROM member WHERE phone = ?";
						 checksmt = conn.prepareStatement(checkQuery);
						 checksmt.setString(1,  textFields[3].getText());
						 rs = checksmt.executeQuery();
							
						 if(rs.next() && rs.getInt(1) > 0) {
							 phonecheck.setText("이미 가입된 전화번호입니다.");
							 phonecheck.setBounds(235, 288, 405, 33);
							 phonecheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
							 phonecheck.setBorder(new EmptyBorder(20, 0, 0, 0));
							 phonecheck.setForeground(Color.RED);
						 }
						 else {
							 phonecheck.setText("사용가능한 전화번호입니다.");
							 phonecheck.setBounds(235, 288, 405, 33);
							 phonecheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
							 phonecheck.setBorder(new EmptyBorder(20, 0, 0, 0));
							 phonecheck.setForeground(new Color(0,128,0));
							 struct.phone = true;
						 }
						 
					}catch(SQLException d){
						 d.printStackTrace();
					}
		
				}
				if(!isAncestorOf(phonecheck)) {
					 add(phonecheck);
				 }
				
			}
	    	
	    });

	    }
	    
	    textFields[3].getDocument().addDocumentListener(new DocumentListener(){
	    	private boolean isUpdating = false;
			@Override
			
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(!isUpdating ) {
				addHypen(e);
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(!isUpdating) {
					addHypen(e);
					}
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(!isUpdating) {
					addHypen(e);
					}
				
			}
			
			private void addHypen(DocumentEvent e) {
				isUpdating = true; 
				 SwingUtilities.invokeLater(()->{
					 String text = textFields[3].getText().replaceAll("-","");
					 text = text.replaceAll("[^0-9]", "");
					 if(text.length() > 11) {
						 text = text.substring(0,11);
					 }
					 StringBuilder sb = new StringBuilder();
					 for(int i = 0; i < text.length(); i++) {
						 sb.append(text.charAt(i));
						 if((i == 2 || i == 6) && i != text.length()-1) {
							 sb.append("-");
						 }
						 
					 }
					 if (!sb.toString().equals(textFields[3].getText())) {
			                textFields[3].setText(sb.toString());
			         }
					 textFields[3].setCaretPosition(sb.length());
					 isUpdating = false;
				 });
			}
	    	
	    });
	    textFields[4].addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				btirhdaycheck.setText("");
				struct.brtih = false;
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
				try {
					
					LocalDate.parse(textFields[4].getText(),formatter);
					btirhdaycheck.setText("");
					struct.brtih = true;
					
				}catch(DateTimeParseException c) {
					btirhdaycheck.setText("올바른 날짜 형식이 올바르지 않거나 유효하지 않은 날짜입니다.");
					btirhdaycheck.setBounds(235, 349, 405, 33);
					btirhdaycheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
					btirhdaycheck.setBorder(new EmptyBorder(20, 0, 0, 0));
					btirhdaycheck.setForeground(Color.RED);
				}
				finally{
					if(!isAncestorOf(btirhdaycheck)) {
					 add(btirhdaycheck);
					 
					}
					repaint();
				}
				
			}
	    	
	    	
	    });
	    
	   

	    
	    
	}
	private void start() {
		tglbtnNewToggleButton.addActionListener(this);
		tglbtnNewToggleButton_1.addActionListener(this);
		btnNewButton.addActionListener(this);
		btnNewButton_1_1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		 Object source = e.getSource(); 
		 if(source == tglbtnNewToggleButton) {
			 gender = "남자";
			 tglbtnNewToggleButton_1.setSelected(false); 
			 
			 
		 }
		 else if(source == tglbtnNewToggleButton_1) {
			 gender = "여자";
			 tglbtnNewToggleButton.setSelected(false);
		 }
		 
		 else if(source == btnNewButton) {
			 if(textFields[0].getText().isEmpty()) {
					idcheck.setText("아이디를 입력해주세요");
					idcheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
					idcheck.setBorder(new EmptyBorder(20, 0, 0, 0));
					idcheck.setBounds(235, 105, 405, 33);
					idcheck.setForeground(Color.RED);
					 if(!isAncestorOf(idcheck)) {
						 add(idcheck);
					 }
			 }
			 else {
				 try {
					 Connection conn = DB.getInstance().getConnection();
					
					 String checkQuery = "SELECT COUNT(*) FROM member WHERE id = ?";
					 checksmt = conn.prepareStatement(checkQuery);
					 checksmt.setString(1, textFields[0].getText());
				
					 rs = checksmt.executeQuery();
				
					 if(rs.next() && rs.getInt(1) > 0) {
					
						 idcheck.setText("이미 존재하는 아이디 입니다.");
						 idcheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
						 idcheck.setBorder(new EmptyBorder(20, 0, 0, 0));
						 idcheck.setBounds(235, 105, 405, 33);
						 idcheck.setForeground(Color.RED);
						 if(!isAncestorOf(idcheck)) {
							 add(idcheck);
						 }
					
					 }
					 else {
						 struct.id = true;
						 idcheck.setText("사용 가능한 아이디입니다.");
						 idcheck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
						 idcheck.setBorder(new EmptyBorder(20, 0, 0, 0));
						 idcheck.setBounds(235, 105, 405, 33);
						 idcheck.setForeground(new Color(0,128,0));
						 if(!isAncestorOf(idcheck)) {
							 add(idcheck);
						 }
						 
					 }
				
			}catch(SQLException d){
				 d.printStackTrace();
			}
			finally {
				
			}
			 }
		 }
		 else if(source == btnNewButton_1_1) {
			 if(struct.id && struct.PW && struct.brtih && struct.name && struct.phone ) {
				 if(tglbtnNewToggleButton_1.isSelected() || tglbtnNewToggleButton.isSelected()) {
					 Connection conn = DB.getInstance().getConnection();
					 try {
						 String insertQuery  = "INSERT INTO member (id, name,brithday,password,gender,phone)VALUES(?,?,?,?,?,?)"	;
						 insertStmt = conn.prepareStatement(insertQuery);
						
						 insertStmt.setString(1, textFields[0].getText());
						 insertStmt.setString(2, textFields[2].getText());
						 insertStmt.setString(3, textFields[4].getText());
						 insertStmt.setString(4, textFields[1].getText());
						 if(tglbtnNewToggleButton.isSelected()) {
							 insertStmt.setString(5, tglbtnNewToggleButton.getText());
						 }
						 else {
							 insertStmt.setString(5, tglbtnNewToggleButton_1.getText());
						 }
						 insertStmt.setString(6, textFields[3].getText());
						 int rowsAffected = insertStmt.executeUpdate();
						 if(rowsAffected > 0) {
							 singn_up sign_frame = new singn_up(); 
							 sign_frame.setVisible(true); 
							 login_screen login_panel = new login_screen(frmGarden);
							 frmGarden.setContentPane(login_panel);
							 frmGarden.revalidate();
							 frmGarden.repaint(); 
							 
						 }
						 else {
							 System.out.print("실패");
						 }
						 
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
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
				 }
			 }
		 }
		 revalidate();
		 repaint();
	
		
	}
	

 static class singn_up extends JFrame{
	 public singn_up() {
		 initialize2(); 
	 }
	 private void initialize2() {
		 setTitle("회원가입");
		 setSize(400,300);
		 setLocationRelativeTo(null);
		 JLabel singn_label = new JLabel("회원가입이 완료되었습니다.", SwingConstants.CENTER);
		 singn_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		 add(singn_label, BorderLayout.CENTER);
         add(singn_label);
         JLabel time_label = new JLabel("5", SwingConstants.CENTER);
         time_label.setBounds(100, 50, 100, 50);
         time_label.setFont(time_label.getFont().deriveFont(30.0f));
         
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




