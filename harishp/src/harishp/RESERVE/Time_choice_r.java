package harishp.RESERVE;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Time_choice_r extends JPanel  implements ActionListener {
	private int year = 0, month = 0,day = 0;
    private JTextField textField;
    JLabel label = new JLabel("00년00월", SwingConstants.CENTER);
    JButton[] M_buttons = new JButton[6];
    JButton[] A_buttons = new JButton[17];
    private Date_Time_Choice user;
    
    time_function TF = new time_function(year,month,day);
    public Time_choice_r(Date_Time_Choice User) {
    	this.user = User;
        initialize();
        //start();
    }

    private void initialize() {
    	
    	setBackground(Color.WHITE);
    	setLayout(null);
       // frame.setTitle("Garden");
        //frame.setBounds(100, 100, 800, 550);
        //frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //frame.getContentPane().setLayout(null);
        //frame.setResizable(false);
    	JTextField textField = new JTextField("시간 선택");
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("굴림", Font.BOLD, 18));
        textField.setEditable(false);
        textField.setBorder(new LineBorder(Color.BLACK, 2));
        textField.setBackground(Color.WHITE);
        textField.setBounds(229, 62, 336, 57);
        add(textField);

        JLabel lblDateAndTime = new JLabel("Date and Time", SwingConstants.CENTER);
        lblDateAndTime.setFont(new Font("Serif", Font.BOLD, 40));
        lblDateAndTime.setBorder(new EmptyBorder(20, 0, 0, 0));
        lblDateAndTime.setBounds(9, -24, 788, 99);
        add(lblDateAndTime);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.BLACK, 2));
        panel.setBounds(229, 116, 336, 330);
        add(panel);

        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);

        // 오전 패널
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel moringLabel = new JLabel("오전", SwingConstants.CENTER);
        moringLabel.setFont(new Font("굴림", Font.BOLD, 14));
        panel.add(moringLabel, gbc);

        for (int i = 0; i < M_buttons.length; i++) {
            M_buttons[i] = new JButton();
            M_buttons[i].setPreferredSize(new java.awt.Dimension(65, 30));
            gbc = new GridBagConstraints(); // 새 인스턴스 생성
            gbc.gridx = i % 4; // 4개씩 배치
            gbc.gridy = (i / 4) + 1; // 행 증가
            gbc.gridwidth = 1;
            gbc.insets = new Insets(2,8,2,8);
            panel.add(M_buttons[i], gbc);
        }

        // 오후 패널
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3; // 오후 버튼은 오전 버튼 아래에 배치
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        JLabel afternoonLabel = new JLabel("오후", SwingConstants.CENTER);
        afternoonLabel.setFont(new Font("굴림", Font.BOLD, 14));
        panel.add(afternoonLabel, gbc);

        for (int i = 0; i < A_buttons.length; i++) {
            A_buttons[i] = new JButton();
            A_buttons[i].setPreferredSize(new java.awt.Dimension(65, 30));
            gbc = new GridBagConstraints(); // 새 인스턴스 생성
            gbc.gridx = i % 4; // 4개씩 배치
            gbc.gridy = (i / 4) + 4; // 행 증가
            gbc.gridwidth = 1;
            gbc.insets = new Insets(2, 8, 2, 8);
            panel.add(A_buttons[i], gbc);
        }
        TF.setButton(M_buttons,A_buttons);
        TF.time_Set();
        panel.setVisible(true);
    }

   // private void start() {
    	//frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
   // }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: 버튼 클릭 시 동작 구현
    }
}
