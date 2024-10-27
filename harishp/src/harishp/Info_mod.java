package harishp;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Info_mod extends JPanel{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the application.
	 */
	public Info_mod() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		JLabel lblInfo = new JLabel("Info", SwingConstants.CENTER);
		lblInfo.setFont(new Font("Serif", Font.BOLD, 40));
		lblInfo.setBorder(new EmptyBorder(20, 0, 0, 0));
		lblInfo.setBounds(12, -24, 788, 99);
		add(lblInfo);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setText("아이디");
		textField.setColumns(10);
		textField.setBounds(200, 85, 405, 31);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("비밀번호");
		textField_1.setColumns(10);
		textField_1.setBounds(200, 150, 405, 31);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("이름");
		textField_2.setColumns(10);
		textField_2.setBounds(200, 223, 405, 31);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("전화번호");
		textField_3.setColumns(10);
		textField_3.setBounds(200, 310, 405, 31);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setText("생년월일");
		textField_4.setColumns(10);
		textField_4.setBounds(200, 399, 405, 31);
		add(textField_4);
		
		JButton btnNewButton_1_1_1 = new JButton("이전");
		btnNewButton_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(200, 454, 181, 31);
		add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("수정");
		btnNewButton_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setBounds(422, 454, 181, 31);
		add(btnNewButton_1_1_1_1);
	}
}
