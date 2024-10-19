package harishp;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SINGN_UP {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SINGN_UP window = new SINGN_UP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SINGN_UP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("Garden");
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    
	    textField = new JTextField();
	    textField.setText("아이디");
	    textField.setBounds(206, 90, 405, 31);
	    frame.getContentPane().add(textField);
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setText("비밀번호");
	    textField_1.setColumns(10);
	    textField_1.setBounds(206, 151, 405, 31);
	    frame.getContentPane().add(textField_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setText("이름");
	    textField_2.setColumns(10);
	    textField_2.setBounds(206, 217, 405, 31);
	    frame.getContentPane().add(textField_2);
	    
	    textField_3 = new JTextField();
	    textField_3.setText("전화번호");
	    textField_3.setColumns(10);
	    textField_3.setBounds(206, 283, 405, 31);
	    frame.getContentPane().add(textField_3);
	    
	    JLabel titleLabel = new JLabel("Sign Up", SwingConstants.CENTER);
	    titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
	    titleLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
	    titleLabel.setBounds(12, -24, 788, 99);
	    frame.getContentPane().add(titleLabel);
	    
	    JToggleButton tglbtnNewToggleButton = new JToggleButton("남성");
	    tglbtnNewToggleButton.setBackground(new Color(171, 180, 237));
	    tglbtnNewToggleButton.setBounds(285, 397, 99, 23);
	    frame.getContentPane().add(tglbtnNewToggleButton);
	    
	    JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("여성");
	    tglbtnNewToggleButton_1.setBackground(new Color(242, 181, 182));
	    tglbtnNewToggleButton_1.setBounds(422, 397, 99, 23);
	    frame.getContentPane().add(tglbtnNewToggleButton_1);
	    
	    JButton btnNewButton = new JButton("아이디 중복 확인");
	    btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 10));
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton.setBounds(647, 94, 125, 23);
	    frame.getContentPane().add(btnNewButton);
	    
	    JButton btnNewButton_1_1 = new JButton("회원가입");
	    btnNewButton_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	    btnNewButton_1_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton_1_1.setBounds(422, 443, 189, 31);
	    frame.getContentPane().add(btnNewButton_1_1);
	    
	    JButton btnNewButton_1_1_1 = new JButton("이전");
	    btnNewButton_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	    btnNewButton_1_1_1.setBounds(206, 443, 181, 31);
	    frame.getContentPane().add(btnNewButton_1_1_1);
	    
	    textField_4 = new JTextField();
	    textField_4.setText("생년월일");
	    textField_4.setColumns(10);
	    textField_4.setBounds(206, 349, 405, 31);
	    frame.getContentPane().add(textField_4);
	    
	}
}

