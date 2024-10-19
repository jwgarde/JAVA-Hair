package harishp.RESERVE;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class Designer_see {

	private JFrame frame;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Designer_see window = new Designer_see();
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
	public Designer_see() {
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
		
		JLabel lblInfo = new JLabel("Designer", SwingConstants.CENTER);
		lblInfo.setFont(new Font("Serif", Font.BOLD, 40));
		lblInfo.setBorder(new EmptyBorder(20, 0, 0, 0));
		lblInfo.setBounds(9, -24, 788, 99);
		frame.getContentPane().add(lblInfo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(229, 116, 336, 263);
		lblNewLabel.setBorder(new LineBorder(Color.BLACK, 2));
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("★방분자 리뷰 100");
		btnNewButton.setForeground(new Color(33, 120, 216));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton.setBounds(444, 97, 132, 23);
		btnNewButton.setOpaque(false); // 버튼 배경을 투명하게 설정
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("굴림", Font.BOLD, 20));
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("최정원 원장");
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setBounds(229, 62, 336, 57);
		frame.getContentPane().add(textField_1);
		
		btnNewButton_1 = new JButton("<");
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton_1.setBounds(150, 226, 97, 62);
		btnNewButton_1.setOpaque(false); // 버튼 배경을 투명하게 설정
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusable(false);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton(">");
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton_2.setToolTipText("");
		btnNewButton_2.setBounds(552, 226, 97, 62);
		btnNewButton_2.setOpaque(false); // 버튼 배경을 투명하게 설정
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusable(false);
		frame.getContentPane().add(btnNewButton_2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 377, 336, 78);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		textArea.setEditable(false);
		textArea.setText("안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.안도건 병신입니다.");
		scrollPane.setViewportView(textArea);
		 // 줄바꿈 설정 (선택 사항)
        textArea.setLineWrap(true);  // 자동 줄바꿈
        textArea.setWrapStyleWord(true); 
        textArea.setCaretPosition(0);
        
        JButton btnNewButton_2_1 = new JButton("←");
        btnNewButton_2_1.setToolTipText("");
        btnNewButton_2_1.setOpaque(false);
        btnNewButton_2_1.setFont(new Font("굴림", Font.BOLD, 25));
        btnNewButton_2_1.setContentAreaFilled(false);
        btnNewButton_2_1.setBorderPainted(false);
        btnNewButton_2_1.setBounds(-16, 10, 97, 62);
        frame.getContentPane().add(btnNewButton_2_1);
        btnNewButton_2_1.setFocusable(false);
        
        JButton btnNewButton_3 = new JButton("예약");
        btnNewButton_3.setBounds(349, 470, 97, 23);
        btnNewButton_3.setFocusable(false);
        frame.getContentPane().add(btnNewButton_3);
	}
}
