package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.NoticeBoardDAO;
import Model.NoticeBoardDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

public class NewnoticeBoardGUI {

	private JFrame frame;
	private JTextField tf_title;
	private JTextField tf_content;
	private JTextField tf_name;
	private JTextField tf_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewnoticeBoardGUI window = new NewnoticeBoardGUI();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewnoticeBoardGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 520, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_title = new JLabel("\uC81C \uBAA9");
		lbl_title.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_title.setForeground(new Color(233, 113, 113));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(29, 193, 57, 15);
		frame.getContentPane().add(lbl_title);
		
		tf_title = new JTextField();
		tf_title.setBounds(98, 190, 357, 21);
		frame.getContentPane().add(tf_title);
		tf_title.setColumns(10);
		
		JLabel lb_content = new JLabel("\uB0B4 \uC6A9");
		lb_content.setFont(new Font("굴림", Font.BOLD, 15));
		lb_content.setForeground(new Color(233, 113, 113));
		lb_content.setHorizontalAlignment(SwingConstants.CENTER);
		lb_content.setBounds(29, 315, 57, 15);
		frame.getContentPane().add(lb_content);
		
		tf_content = new JTextField();
		tf_content.setBounds(98, 221, 357, 229);
		frame.getContentPane().add(tf_content);
		tf_content.setColumns(10);
		
		JButton bnt_new = new JButton("\uB4F1\uB85D");
		bnt_new.setForeground(Color.WHITE);
		bnt_new.setFont(new Font("굴림", Font.BOLD, 15));
		bnt_new.setBackground(new Color(242, 203, 97));
		bnt_new.setBackground(new Color(250, 236, 197));
		bnt_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_name.getText().trim().length()==0 || tf_name.getText().trim().equals("이름")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
					tf_name.grabFocus();
					return;
				}
				if(tf_ID.getText().trim().length()==0 || tf_ID.getText().trim().equals("아이디")) {
					JOptionPane.showMessageDialog(null, "ID를 입력해 주세요.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
					tf_ID.grabFocus();
					return;
				}
				if(tf_content.getText().trim().length()==0 || tf_content.getText().trim().equals("내용")) {
					JOptionPane.showMessageDialog(null, "내용을 입력해 주세요.", "내용 입력", JOptionPane.WARNING_MESSAGE);
					tf_content.grabFocus();
					return;
				}
				if(tf_title.getText().trim().length()==0 || tf_title.getText().trim().equals("제목")) {
					JOptionPane.showMessageDialog(null, "제목을 입력해 주세요.", "제목 입력", JOptionPane.WARNING_MESSAGE);
					tf_title.grabFocus();
					return;
				
				}else {
					JOptionPane.showMessageDialog(null, "등록이 완료되었습니다", "게시물 등록", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose(); // 창 닫기
					noticeBoardGUI borad = new noticeBoardGUI(); // 메인 창 띄우기 객체 생성
				}
				
				
				String name = tf_name.getText();
				String id = tf_ID.getText();
				String content = tf_content.getText();
				String title = tf_title.getText();
	
				NoticeBoardDTO dto = new NoticeBoardDTO(name, id, content, title);
				NoticeBoardDAO dao = new NoticeBoardDAO();
				dao.joinInsert(dto);
				
				
			}
		});
		bnt_new.setBounds(121, 471, 122, 33);
		frame.getContentPane().add(bnt_new);
		
		JLabel lbl_ID = new JLabel("I D");
		lbl_ID.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_ID.setForeground(new Color(233, 113, 113));
		lbl_ID.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ID.setBounds(29, 149, 57, 15);
		frame.getContentPane().add(lbl_ID);
		
		JLabel lbl_name = new JLabel("\uC774 \uB984");
		lbl_name.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_name.setForeground(new Color(233, 113, 113));
		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_name.setBounds(29, 110, 57, 15);
		frame.getContentPane().add(lbl_name);
		
		tf_name = new JTextField();
		tf_name.setColumns(10);
		tf_name.setBounds(98, 107, 180, 21);
		frame.getContentPane().add(tf_name);
		
		tf_ID = new JTextField();
		tf_ID.setColumns(10);
		tf_ID.setBounds(98, 146, 180, 21);
		frame.getContentPane().add(tf_ID);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 484, 541);
		panel.setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Bigname = new JLabel("\uAE00 \uC4F0 \uAE30");
		lbl_Bigname.setForeground(new Color(232, 74, 95));
		lbl_Bigname.setBounds(183, 27, 129, 24);
		panel.add(lbl_Bigname);
		lbl_Bigname.setFont(new Font("굴림", Font.BOLD, 30));
		lbl_Bigname.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bnt_close = new JButton("\uCDE8\uC18C");
		bnt_close.setForeground(Color.WHITE);
		bnt_close.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_ID.setBackground(new Color(233, 113, 113));
		bnt_close.setBounds(255, 462, 119, 33);
		panel.add(bnt_close);
		bnt_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "등록을 취소합니다", "게시글 등록", JOptionPane.ERROR_MESSAGE);
				frame.dispose();
				noticeBoardGUI NoticeBoradGUI = new noticeBoardGUI();
			}
		});
	}
}
