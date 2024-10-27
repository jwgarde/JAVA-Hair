package harishp;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Find_PW extends JPanel{
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the application.
	 */
	public Find_PW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(Color.WHITE);
		setLayout(null);
	    JLabel lblFindId = new JLabel("Find PW", SwingConstants.CENTER);
	    lblFindId.setFont(new Font("Serif", Font.BOLD, 40));
	    lblFindId.setBorder(new EmptyBorder(20, 0, 0, 0));
	    lblFindId.setBounds(0, 0, 800, 100);
	    add(lblFindId);
	    
	    textField = new JTextField();
	    textField.setText("이름");
	    textField.setColumns(10);
	    textField.setBounds(197, 150, 405, 31);
	    add(textField);
	    
	    textField_1 = new JTextField();
	    textField_1.setText("전화번호");
	    textField_1.setColumns(10);
	    textField_1.setBounds(197, 290, 405, 31);
	    add(textField_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setText("생년월일");
	    textField_2.setColumns(10);
	    textField_2.setBounds(197, 358, 405, 31);
	    add(textField_2);
	    
	    JButton btnNewButton_1_1_1 = new JButton("이전");
	    btnNewButton_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	    btnNewButton_1_1_1.setBounds(197, 443, 181, 31);
	    add(btnNewButton_1_1_1);
	    
	    JButton btnNewButton_1_1_1_1 = new JButton("비밀번호 찾기");
	    btnNewButton_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	    btnNewButton_1_1_1_1.setBounds(421, 443, 181, 31);
	    add(btnNewButton_1_1_1_1);
	    
	    textField_3 = new JTextField();
	    textField_3.setText("아이디");
	    textField_3.setColumns(10);
	    textField_3.setBounds(197, 216, 405, 31);
	    add(textField_3);
	}
}
