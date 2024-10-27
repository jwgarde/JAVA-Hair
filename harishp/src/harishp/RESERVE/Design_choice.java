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
public class Design_choice extends JPanel implements ActionListener{
	 public JFrame GDframe;
	 JLabel Title = new JLabel("Design_Choice", SwingConstants.CENTER);
	 private JTextField Design_choice;
	 JButton[] Menu_Title = new JButton[4];
	 public Design_choice(JFrame frame) {
		 
	    	this.GDframe = frame;
	        initialize();
	        start();
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void initialize() {
		setBackground(Color.white);
		setLayout(null);
		Design_choice = new JTextField("시술 메뉴");
		Design_choice.setHorizontalAlignment(SwingConstants.CENTER);
		Design_choice.setForeground(Color.BLACK);
		Design_choice.setFont(new Font("굴림", Font.BOLD, 18));
		Design_choice.setEditable(false);
		Design_choice.setBorder(new LineBorder(Color.BLACK, 2));
		Design_choice.setBackground(Color.WHITE);
		Design_choice.setBounds(229, 62, 336, 57);
        add(Design_choice);
        
        Title.setFont(new Font("Serif", Font.BOLD, 40));
        Title.setBorder(new EmptyBorder(20, 0, 0, 0));
        Title.setBounds(9, -24, 788, 99);
        add(Title);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.BLACK, 2));
        panel.setBounds(229, 116, 336, 330);
        add(panel);
        GridBagLayout gbl = new GridBagLayout(); //GridBagConstraints GridBagLayout의 컴포넌트크기 및 위치를 세밀하게 조정할 수 있게 설정 정보를 담고 있는 객체.
        panel.setLayout(gbl);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        
	}
	private void start() {
		
	}
}
