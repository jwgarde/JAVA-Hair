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

public class Date_Time_Choice extends JPanel implements ActionListener {
    int year, month;
    public JFrame GDframe;
    private JTextField date_choice;
    JButton butttonBefore = new JButton("<");
    JButton butttonafter = new JButton(">");
    JLabel label = new JLabel("00년00월");
    JButton[] buttons = new JButton[49];
    String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
    Calendar_fuction cF = new Calendar_fuction();
    Date_Time_Choice User;
    JLabel date_choice_title = new JLabel("Date and Time", SwingConstants.CENTER);
    /**
     * Launch the application.
     */

    /**
     * Create the application.
     */
    public Date_Time_Choice(JFrame frame) {
    	this.GDframe = frame;
        initialize();
        start();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	setBackground(Color.white);
		setLayout(null);
		date_choice = new JTextField();
		date_choice.setText("날짜 선택");
		date_choice.setHorizontalAlignment(SwingConstants.CENTER);
		date_choice.setForeground(Color.BLACK);
		date_choice.setFont(new Font("굴림", Font.BOLD, 18));
		date_choice.setEditable(false);
		date_choice.setColumns(10);
		date_choice.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		date_choice.setBackground(Color.WHITE);
		date_choice.setBounds(229, 62, 336, 57);
        add(date_choice);
        
        date_choice_title.setFont(new Font("Serif", Font.BOLD, 40));
        date_choice_title.setBorder(new EmptyBorder(20, 0, 0, 0));
        date_choice_title.setBounds(9, -24, 788, 99);
        add(date_choice_title);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel_1.setBounds(229, 116, 336, 330);
        add(panel_1);
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
        panel_2.setLayout(new GridLayout(7, 7, 1, 1));
        panel_2.setPreferredSize(new Dimension(330, 290));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            panel_2.add(buttons[i]);
            buttons[i].setFont(new Font("굴림", Font.PLAIN, 10));
            if (i < 7) buttons[i].setText(dayNames[i]);
            buttons[i].addActionListener(this);  // 모든 버튼에 같은 리스너 적용
            if (i % 7 == 0) buttons[i].setForeground(Color.RED);
            if (i % 7 == 6) buttons[i].setForeground(Color.BLUE);
 
        }
        cF.SetButton(buttons);
        cF.calSet();
    }


    private void start() {
        butttonafter.addActionListener(this);
        butttonBefore.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) { //이벤트를 처리를 담당하는 메서드중 하나 , ActionListener 인터페이스의 추상 메서드
        Object source = e.getSource();  //다양한 객체의 타입을 담을 수 있게 해준다.
        int gap = 0;

        // '앞으로' 버튼 클릭 시
        if (source == butttonafter) {
            gap = 1;
            cF.update(gap);  // 1달 후 계산
            label.setText(cF.setString());  // 년월 글자 갱신
        }
        
        else if (source == butttonBefore) {
            gap = -1;
            cF.update(gap);  // 1달 전 계산
            label.setText(cF.setString());  // 년월 글자 갱신
        }
        
        // 날짜 버튼 클릭 시 (배열을 사용하여 모든 날짜 버튼 확인)
        else {
            for (int i = 7; i < buttons.length; i++) {  // 첫 번째 7개는 요일 버튼이므로 제외
                if (source == buttons[i]) {
                    String buttonText = buttons[i].getText();  // 버튼 텍스트 가져오기
                    if (!buttonText.isEmpty()) {  // 텍스트가 있을 경우만 처리
                        System.out.println("Button clicked: " + buttonText + " (Index: " + i + ")");
                        // Time_choice_r 객체 생성 및 패널 전환
                        Time_choice_r Timechoice_panel = new Time_choice_r(GDframe);
                        GDframe.setContentPane(Timechoice_panel);
                        GDframe.revalidate(); //레이아웃 새로고침
                    }
                }
            }
        }
    }
}
