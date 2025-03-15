package harishp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import harishp.find_ID;
import harishp.Find_PW;
import javax.swing.ImageIcon;

public class login_screen extends JPanel implements ActionListener{

    private JFrame frmGarden ;
    private JTextField txtphone;
    private JPasswordField txtpw;
    JButton login_btn = new JButton("로그인");
    JButton find_ID_btn = new JButton("아이디 찾기");
    JButton find_pw_btn = new JButton("비밀번호 찾기");
    JButton SIGN_UP = new JButton("회원가입");
    JLabel login_check = new JLabel("");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
             
                	JFrame frame = new JFrame();
                	frame.setTitle("Garden");
                	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     frame.setBounds(100, 100, 900, 650);
                    login_screen panel = new login_screen(frame);
                    frame.setContentPane(panel);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public login_screen(JFrame frame) {
    	this.frmGarden = frame;
        initialize();
        start();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	//Connection connection = DB.getInstance().getConnection();
    	setLayout(null);   
        setBackground(new Color(255, 255, 255));
        
        
        // Create a JLabel with the desired text
        JLabel titleLabel = new JLabel("Hello, Garden hairshop", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 40)); // Set font size to 36
        titleLabel.setBounds(0, 0, 900, 100);
        add(titleLabel); // 

        // Add the label to the top of the frame
        
        JLabel id_label = new JLabel("아이디");
       // lblNewLabel.setBackground(new Color(192, 192, 192));
        id_label.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        id_label.setBounds(150, 200, 107, 27); 
        add(id_label);
        
        JLabel password_label = new JLabel("비밀번호");
        password_label.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        password_label.setBounds(150, 307, 107, 27);
       add(password_label);
        
        txtphone = new JTextField();
        txtphone.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 16));
        txtphone.setForeground(new Color(0, 0, 0));
       // txtphone.setBackground(new Color(255, 255, 255));
        txtphone.setBounds(270, 195, 350, 38);
        add(txtphone);
        txtphone.setColumns(10);
        
        txtpw = new JPasswordField(16);
        txtpw.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 16));
        txtpw.setBackground(new Color(255, 255, 255));
        txtpw.setColumns(10);
        txtpw.setBounds(270, 302, 350, 38);
        add(txtpw);
        
        login_btn.setBackground(new Color(255, 255, 255));
        login_btn.setFocusable(false);
        //btnNewButton.setOpaque(true);
        //btnNewButton.setBorderPainted(false);
        login_btn.setBounds(670, 240, 107, 57);
        add(login_btn);
        
        find_ID_btn.setBounds(180, 420, 150, 33);
        add(find_ID_btn);
        find_ID_btn.setFocusable(false);
        
        find_pw_btn.setFocusable(false);
        find_pw_btn.setBounds(380, 420, 150, 33);
       add(find_pw_btn);
        
        SIGN_UP.setBounds(580, 420, 150, 33);
        add(SIGN_UP);
        
        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
        lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\chlwj\\Pictures\\Screenshots\\스크린샷 2024-09-07 153611.png"));
        lblNewJgoodiesLabel.setBounds(22, 21, 123, 79);
        add(lblNewJgoodiesLabel);
        
        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
        lblNewJgoodiesLabel_1.setIcon(new ImageIcon("C:\\Users\\chlwj\\Pictures\\Screenshots\\스크린샷 2024-09-07 153644.png"));
        lblNewJgoodiesLabel_1.setBounds(730, 21, 123, 79);
        add(lblNewJgoodiesLabel_1);
    }
    public void start() {
    	 login_btn.addActionListener(this);
    	 find_ID_btn.addActionListener(this);
    	 find_pw_btn.addActionListener(this);
    	 SIGN_UP.addActionListener(this);
    	 
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == find_ID_btn) {
			find_ID find_ID_Panel = new find_ID();
			frmGarden.setContentPane(find_ID_Panel);
			
			
		}
		else if(source == find_pw_btn) {
			Find_PW find_PW_Panel = new Find_PW();
			frmGarden.setContentPane(find_PW_Panel);
			
			
		}
		else if(source == SIGN_UP) {
			SINGN_UP  SINGN_UP_Panel = new SINGN_UP(frmGarden);
			frmGarden.setContentPane(SINGN_UP_Panel);
			
		}
		else {
			if(txtphone.getText().equals("") ||txtpw.getPassword().length == 0  ) {
				login_check.setText("아이디 또는 비밀번호를 입력해주세요");
				login_check.setBounds(270, 322, 350, 38);
				login_check.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
				login_check.setBorder(new EmptyBorder(20, 0, 0, 0));
				login_check.setForeground(Color.RED);
				 if(!isAncestorOf(login_check)) {
					 add(login_check);
				 }
				 revalidate();
			     repaint();
			}
			else {
				Connection conn = null;
			    PreparedStatement checksmt = null;
			    ResultSet rs = null;
					
				    try {
				    	 conn = DB.getInstance().getConnection();
				    	 
				    	String checkQ = "SELECT id,name,brithday,password,gender,phone FROM member WHERE id = ? AND password = ?";
				    	checksmt = conn.prepareStatement(checkQ);
				    	checksmt.setString(1, txtphone.getText());
				        checksmt.setString(2, new String(txtpw.getPassword()));
				        
				        rs = checksmt.executeQuery();
				        if (rs.next()) {
				            String ID = rs.getString("id");  
				            String name = rs.getString("name");
				            String brithday = rs.getString("brithday");
				            String password = rs.getString("password");
				            String gender = rs.getString("gender");
				            String phone = rs.getString("phone");
				            
				            User user = User.getinstance();
				            user.SetString(ID, password, phone, brithday, name, gender);
				            first_screen first_screen = new first_screen(frmGarden,user);
				            frmGarden.setContentPane(first_screen);
				            frmGarden.revalidate();
				            
				            
				            
				        } else {
				        	login_check.setText("아이디 또는 비밀번호를 확인해주세요");
							login_check.setBounds(270, 322, 350, 38);
							login_check.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
							login_check.setBorder(new EmptyBorder(20, 0, 0, 0));
							login_check.setForeground(Color.RED);
							 if(!isAncestorOf(login_check)) {
								 add(login_check);
							 }
							 revalidate();
						     repaint();
				        }
				    
				} catch (SQLException e1) {
				    e1.printStackTrace();
				} 

			}
		
		}
		frmGarden.revalidate();
	}
}