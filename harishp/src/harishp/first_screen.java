package harishp;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class first_screen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first_screen window = new first_screen();
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
	public first_screen() {
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

		JLabel titleLabel = new JLabel("Hello, Garden hairshop", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
		titleLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
		titleLabel.setBounds(0, 0, 800, 100);
		frame.getContentPane().add(titleLabel);

		JButton btnNewButton_1_3 = new JButton("예약");
		btnNewButton_1_3.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(217, 170, 178, 113);
		btnNewButton_1_3.setFocusable(false);
		frame.getContentPane().add(btnNewButton_1_3);

		// JLabel로 변경 및 테두리 추가
		JLabel lblD = new JLabel("D-32", SwingConstants.CENTER);
		lblD.setFont(new Font("Serif", Font.PLAIN, 20));
		lblD.setBounds(144, 115, 521, 39);

		// JLabel에 테두리 추가 (검은색, 두께 2)
		lblD.setBorder(new LineBorder(Color.BLACK, 2));
		frame.getContentPane().add(lblD);
		
		JButton btnNewButton_1_3_1 = new JButton("예약 내역 조회");
		btnNewButton_1_3_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1_3_1.setBounds(414, 170, 178, 113);
		btnNewButton_1_3_1.setFocusable(false);
		frame.getContentPane().add(btnNewButton_1_3_1);
		
		JButton btnNewButton_1_3_2 = new JButton("정보수정");
		btnNewButton_1_3_2.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1_3_2.setBounds(217, 299, 178, 113);
		btnNewButton_1_3_2.setFocusable(false);
		frame.getContentPane().add(btnNewButton_1_3_2);
		
		JButton btnNewButton_1_3_3 = new JButton("디자이너");
		btnNewButton_1_3_3.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1_3_3.setBounds(414, 300, 178, 113);
		btnNewButton_1_3_3.setFocusable(false);
		frame.getContentPane().add(btnNewButton_1_3_3);
		
		JButton btnNewButton = new JButton("로그아웃");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(357, 430, 97, 34);
		frame.getContentPane().add(btnNewButton);
	}
}
