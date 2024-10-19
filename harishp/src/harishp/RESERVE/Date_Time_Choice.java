package harishp.RESERVE;
import java.util.Calendar;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import harishp.RESERVE.Time_choice_r;

public class Date_Time_Choice  implements  ActionListener{
	int year, month;
	public JFrame frame;
	private JTextField textField;
	JButton butttonBefore = new  JButton("<");
	JButton butttonafter = new  JButton(">");
	JLabel label = new JLabel("00년00월");
	JButton[] buttons = new JButton[49];
	String[] dayNames = {"일","월","화","수","목","금","토"};
	Calendar_fuction cF = new Calendar_fuction();
	//Date_Time_Choice User = new Date_Time_Choice();
	Date_Time_Choice User;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Date_Time_Choice window = new Date_Time_Choice();
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
	public Date_Time_Choice() {
		initialize();
		start();
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
		textField.setText("날짜 선택");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("굴림", Font.BOLD, 18));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setBackground(Color.WHITE);
		textField.setBounds(229, 62, 336, 57);
		frame.getContentPane().add(textField);
		
		
		
		
		
		JLabel lblDateAndTime = new JLabel("Date and Time", SwingConstants.CENTER);
		lblDateAndTime.setFont(new Font("Serif", Font.BOLD, 40));
		lblDateAndTime.setBorder(new EmptyBorder(20, 0, 0, 0));
		lblDateAndTime.setBounds(9, -24, 788, 99);
		frame.getContentPane().add(lblDateAndTime);
		//GridBagConstraints gbc_btnNewButton_15 = new GridBagConstraints();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(229, 116, 336, 330);
		frame.getContentPane().add(panel_1);
		butttonBefore.setFont(new Font("Gulim", Font.PLAIN, 12));
		butttonBefore.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(butttonBefore);
		panel_1.add(label);
		panel_1.add(butttonafter);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_2);
		label.setText(cF.setString());
		panel_2.setLayout(new GridLayout(7,7,1,1));	
		panel_2.setPreferredSize(new Dimension(330, 290));
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			panel_2.add(buttons[i]);
			buttons[i].setFont(new Font("굴림",Font.PLAIN,10));
			if(i < 7)buttons[i].setText(dayNames[i]);
			else buttons[i].addActionListener(new Date_BUTTON_ACTION(i));
			if(i % 7 == 0)buttons[i].setForeground(Color.RED);
			if(i % 7 == 6)buttons[i].setForeground(Color.BLUE);

		}
		cF.SetButton(buttons);
		cF.calSet();
	}
	private  class Date_BUTTON_ACTION implements ActionListener {
		int buttonIndex;
		Date_BUTTON_ACTION(int index){
			 this.buttonIndex = index;
		}
		public void actionPerformed(ActionEvent e) {
            // 버튼이 눌렸을 때 처리할 동작
            JButton clickedButton = (JButton) e.getSource();
            String buttonText = clickedButton.getText();

           if (!buttonText.isEmpty()) {  // 버튼에 날짜가 있을 때만 처리
               System.out.println("Button clicked: " + buttonText + " (Index: " + buttonIndex + ")");
                // 여기서 원하는 동작을 추가
               //객체 임이의로 생성
               Time_choice_r Timechoice_panel = new  Time_choice_r(User);
               frame.setContentPane(Timechoice_panel);     
               frame.revalidate(); 
               //현재의 레이아웃 관리자가 컴포넌트의 새로운 위치와 크기를 계산.
               
               //frame.repaint(); // 프레임 다시 그리기
           }
        }
	}
	private void start() {
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		butttonafter.addActionListener(this);
		butttonBefore.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int gap = 0;
		if(e.getSource() == butttonafter) {				// 1달 후 getSource = 어떤 버튼이 클리되었는지 확인
			gap = 1;
		} else if(e.getSource() == butttonBefore ) {		// 1달 전
			gap = -1;
		}
		cF.update(gap);
		label.setText(cF.setString());		// 년월 글자 갱신		
	}	
	

}
