package harishp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class login_screen implements ActionListener{

    private JFrame frmGarden;
    private JLabel lblNewLabel;
    private JTextField txtphone;
    private JTextField txtpw;
    JButton login_btn = new JButton("로그인");
    JButton find_ID_btn = new JButton("아이디 찾기");
    JButton find_pw_btn = new JButton("비밀번호 찾기");
    JButton imfo_btn = new JButton("회원가입");
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login_screen window = new login_screen();
                    window.frmGarden.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public login_screen() {
        initialize();
        start();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmGarden = new JFrame();
        frmGarden.getContentPane().setBackground(new Color(255, 255, 255));
        frmGarden.setTitle("Garden");
        frmGarden.setBounds(100, 100, 800, 550);
        frmGarden.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmGarden.getContentPane().setLayout(null);
        
        // Create a JLabel with the desired text
        JLabel titleLabel = new JLabel("Hello, Garden hairshop", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 40)); // Set font size to 36
        titleLabel.setBorder(new EmptyBorder(20, 0, 0, 0)); // Add padding (top, left, bottom, right)
        titleLabel.setBounds(0, 0, frmGarden.getWidth(), 100); // Position at the top
        frmGarden.getContentPane().add(titleLabel);

        // Add the label to the top of the frame
        frmGarden.getContentPane().add(titleLabel, BorderLayout.NORTH);
        
        lblNewLabel = new JLabel("아이디");
        lblNewLabel.setBackground(new Color(192, 192, 192));
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        lblNewLabel.setBounds(99, 168, 107, 27); 
        frmGarden.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("비밀번호");
        lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(99, 275, 107, 27);
        frmGarden.getContentPane().add(lblNewLabel_1);
        
        txtphone = new JTextField();
        txtphone.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 16));
        txtphone.setForeground(new Color(0, 0, 0));
        txtphone.setBackground(new Color(255, 255, 255));
        txtphone.setBounds(218, 166, 350, 38);
        frmGarden.getContentPane().add(txtphone);
        txtphone.setColumns(10);
        
        txtpw = new JTextField();
        txtpw.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 16));
        txtpw.setBackground(new Color(255, 255, 255));
        txtpw.setColumns(10);
        txtpw.setBounds(218, 264, 350, 38);
        frmGarden.getContentPane().add(txtpw);
        
        login_btn.setBackground(new Color(255, 255, 255));
        login_btn.setFocusable(false);
        //btnNewButton.setOpaque(true);
        //btnNewButton.setBorderPainted(false);
        login_btn.setBounds(614, 200, 107, 57);
        frmGarden.getContentPane().add(login_btn);
        
        find_ID_btn.setBounds(159, 385, 123, 33);
        frmGarden.getContentPane().add(find_ID_btn);
        find_ID_btn.setFocusable(false);
        
        find_pw_btn.setFocusable(false);
        find_pw_btn.setBounds(327, 385, 123, 33);
        frmGarden.getContentPane().add(find_pw_btn);
        
        imfo_btn.setBounds(495, 385, 123, 33);
        frmGarden.getContentPane().add(imfo_btn);
        
        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
        lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\chlwj\\Pictures\\Screenshots\\스크린샷 2024-09-07 153611.png"));
        lblNewJgoodiesLabel.setBounds(22, 21, 123, 79);
        frmGarden.getContentPane().add(lblNewJgoodiesLabel);
        
        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
        lblNewJgoodiesLabel_1.setIcon(new ImageIcon("C:\\Users\\chlwj\\Pictures\\Screenshots\\스크린샷 2024-09-07 153644.png"));
        lblNewJgoodiesLabel_1.setBounds(629, 21, 114, 79);
        frmGarden.getContentPane().add(lblNewJgoodiesLabel_1);
    }
    public void start() {
    	 login_btn.addActionListener(this);
    	 find_ID_btn.addActionListener(this);
    	 find_pw_btn.addActionListener(this);
    	 imfo_btn.addActionListener(this);
    	 
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == find_ID_btn) {
			find_ID find_ID_Panel = new find_ID();
			frmGarden.setContentPane(find_ID_Panel);
			frmGarden.revalidate();
			
		}
		else if(source == find_pw_btn) {
			Find_PW find_PW_Panel = new Find_PW();
			frmGarden.setContentPane(find_PW_Panel);
			frmGarden.revalidate();
			
		}
		else if(source == imfo_btn) {
			Info_mod  info_Panel = new Info_mod();
			frmGarden.setContentPane(info_Panel);
			frmGarden.revalidate();
		}
		else {
			first_screen first_Panel = new first_screen(frmGarden);
			frmGarden.setContentPane(first_Panel);
			frmGarden.revalidate();
		}
		
	}
}