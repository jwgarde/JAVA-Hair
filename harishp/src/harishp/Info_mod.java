package harishp;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Info_mod extends JPanel implements ActionListener{
	private JFrame Info_frame; 
	JLabel lblInfo = new JLabel("Info", SwingConstants.CENTER);
	JTextField[] textFields = new JTextField[5];
	User user = User.getinstance();
	String[] placeholderTexts = {
				user.getID(),
				user.password(),
				user.name(),
				user.phone(),
				user.brith()
	   };
	public class Booleanstruct{
		public boolean pass = false;
		
	}
	JLabel PASS_info_CHECK = new JLabel("");
	JLabel Phone_checck = new JLabel("");
	Booleanstruct struct = new Booleanstruct();
	 PreparedStatement checksmt = null;
	 PreparedStatement updatetStmt = null;
	 ResultSet rs = null;
	 JButton btnNewButton_1_1_1 = new JButton("이전");
	 JButton btnNewButton_1_1_1_1 = new JButton("수정");
	/**
	 * Create the application.
	 */
	 public boolean phone = true;
	 public boolean pass = true;
	public Info_mod(JFrame Info_frame) {
		this.Info_frame = Info_frame;
		initialize();
		start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblInfo.setFont(new Font("Serif", Font.BOLD, 40));
		lblInfo.setBorder(new EmptyBorder(20, 0, 0, 0));
		lblInfo.setBounds(0, 0, 900, 100);
		add(lblInfo);
		
		btnNewButton_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(240, 460, 195, 31);
		add(btnNewButton_1_1_1);
		
		btnNewButton_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setBounds(447, 460, 195, 31);
		add(btnNewButton_1_1_1_1);
		
		int x = 240, y = 85, z = 405, q = 31;
		for(int i = 0; i < textFields.length; i++) {
			textFields[i] = new JTextField(placeholderTexts[i], 20);
			 textFields[i] .setBounds(x,y,z,q);
	    	  textFields[i].setColumns(10); 
			if(i == 0 || i == 2||i ==  4) {
				textFields[i].setEditable(false);
			}
			 add(textFields[i]);
			 y+=65;
		
		}

			textFields[1].addFocusListener(new FocusListener(){

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					PASS_info_CHECK.setText("");
					
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					String PASS = textFields[1].getText();
					if(!isValidPassword(PASS) || PASS.equals("")) {
						PASS_info_CHECK.setText("잘못된 비밀번호 형식입니다.");
						PASS_info_CHECK.setBounds(240,165,405,31);
						PASS_info_CHECK.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
						PASS_info_CHECK.setBorder(new EmptyBorder(20, 0, 0, 0));
						PASS_info_CHECK.setForeground(Color.RED);
						pass = false;
					}
					else {
						PASS_info_CHECK.setText("사용가능한 비밀번호입니다.");
						PASS_info_CHECK.setBounds(235, 165, 405, 33);
						PASS_info_CHECK.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
						PASS_info_CHECK.setBorder(new EmptyBorder(20, 0, 0, 0));
						PASS_info_CHECK.setForeground(new Color(0,128,0));
						pass =true;
					}
					if(!isAncestorOf(PASS_info_CHECK)) {
						add(PASS_info_CHECK);
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
			
			
			textFields[3].addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					Phone_checck.setText("");
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					// TODO Auto-generated method stub
					if( textFields[3].getText().equals("") || !textFields[3].getText().matches("^010-[0-9]{4}-[0-9]{4}$")) {
						Phone_checck.setText("올바른 전화번호 형식에 맞게 작성해주세요");
						Phone_checck.setBounds(235, 295, 405, 33);
						Phone_checck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
						Phone_checck.setBorder(new EmptyBorder(20, 0, 0, 0));
						Phone_checck.setForeground(Color.RED);
					}
					else {
						try {
							Connection conn = DB.getInstance().getConnection();
							 String checkQuery = "SELECT COUNT(*) FROM member WHERE phone = ?";
							 checksmt = conn.prepareStatement(checkQuery);
							 checksmt.setString(1,  textFields[3].getText());
							 rs = checksmt.executeQuery();
								
							 if(rs.next() && rs.getInt(1) > 0) {
								 if(!textFields[3].getText().equals(user.phone())) {
									Phone_checck.setText("이미 가입된 전화번호입니다.");
								 	Phone_checck.setBounds(235, 295, 405, 33);
								 	Phone_checck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
								 	Phone_checck.setBorder(new EmptyBorder(20, 0, 0, 0));
								 	Phone_checck.setForeground(Color.RED);
								 	phone = false;
								 }
								 else {
									 phone =  true; 
								 }
							 }
							 else {
								 Phone_checck.setText("사용가능한 전화번호입니다.");
								 Phone_checck.setBounds(235, 295, 405, 33);
								 Phone_checck.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
								 Phone_checck.setBorder(new EmptyBorder(20, 0, 0, 0));
								 Phone_checck.setForeground(new Color(0,128,0));
								 phone =  true;
							 }
							
						}catch(SQLException d){
							 d.printStackTrace();
						}
						if(!isAncestorOf(Phone_checck)) {
							 add(Phone_checck);
						 }
					}
					
				}
				
			});
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
		}
		
		 
	private void start() {
		btnNewButton_1_1_1_1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == btnNewButton_1_1_1_1) {
			if(phone &&  pass ) {
				Connection conn = DB.getInstance().getConnection();
				try {
					String update = "UPDATE member SET password = ?, phone = ? WHERE id = ?";
					updatetStmt = conn.prepareStatement(update);
					updatetStmt.setString(1,textFields[1].getText());
					updatetStmt.setString(2,textFields[3].getText());
					updatetStmt.setString(3,user.getID());
				    int rowsAffected = updatetStmt.executeUpdate();{
				    	if(rowsAffected > 0) {
				    		user.SetString(user.getID(),textFields[1].getText(),textFields[3].getText() , user.brith(), user.name(), user.gender());
				    		first_screen first_screen = new first_screen(Info_frame,user);
				    		Info_frame.setContentPane(first_screen);
				    		Info_frame.revalidate();
				    	}
				    }
				}catch(SQLException d){
					d.printStackTrace();
				}finally {
					try {
		                if (updatetStmt != null) {
		                	updatetStmt.close();
		                	
		                }
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
				}
			}
		}
		 revalidate();
		 repaint();
		
	}
}
