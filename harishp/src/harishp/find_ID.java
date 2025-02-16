package harishp;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class find_ID extends JPanel{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	/**
	 * Create the application.
	 */
	public find_ID() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(Color.WHITE);
		setLayout(null);
	    
	    JLabel lblFindId = new JLabel("Find ID", SwingConstants.CENTER);
	    lblFindId.setFont(new Font("Serif", Font.BOLD, 40));
	    lblFindId.setBorder(new EmptyBorder(20, 0, 0, 0));
	    lblFindId.setBounds(0, 0, 900, 100);
	    add(lblFindId);
	    
	    textField = new JTextField();
	    textField.setText("이름");
	    textField.setColumns(10);
	    textField.setBounds(250, 150, 405, 31);
	    add(textField);
	    
	    textField_1 = new JTextField();
	    textField_1.setText("생년월일");
	    textField_1.setColumns(10);
	    textField_1.setBounds(250, 254, 405, 31);
	    add(textField_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setText("전화번호");
	    textField_2.setColumns(10);
	    textField_2.setBounds(250, 358, 405, 31);
	    add(textField_2);
	    
	    JButton btnNewButton_1_1_1 = new JButton("이전");
	    btnNewButton_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	    btnNewButton_1_1_1.setBounds(235, 460, 181, 31);
	    add(btnNewButton_1_1_1);
	    
	    JButton btnNewButton_1_1_1_1 = new JButton("아이디 찾기");
	    btnNewButton_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	    btnNewButton_1_1_1_1.setBounds(451, 460, 189, 31);
	    add(btnNewButton_1_1_1_1);
	}
}

