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
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.ImageIcon;

public class NewnoticeBoardGUI {

	private JFrame frame;
	private JTextField tf_title;
	private JTextField tf_content;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewnoticeBoardGUI window = new NewnoticeBoardGUI();
////					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public NewnoticeBoardGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 519, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton bnt_new = new JButton("\uB4F1\uB85D");
		bnt_new.setForeground(Color.WHITE);
		bnt_new.setFont(new Font("굴림", Font.BOLD, 15));
		bnt_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					String name = dto.getName();
					String id = dto.getId();
					String content = tf_content.getText();
					String title = tf_title.getText();
					
					NoticeBoardDTO dto = new NoticeBoardDTO(name, id, content, title);
					NoticeBoardDAO dao = new NoticeBoardDAO();
					dao.joinInsert(dto);
					
				}
				
				JOptionPane.showMessageDialog(null, "등록이 완료되었습니다", "게시물 등록", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose(); // 창 닫기
				noticeBoardGUI board = new noticeBoardGUI(dto); // 메인 창 띄우기 객체 생성
				
				
				
			}
		});
		bnt_new.setBounds(105, 505, 124, 35);
		bnt_new.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(bnt_new);
		
		JButton bnt_close = new JButton("\uCDE8\uC18C");
		bnt_close.setFont(new Font("굴림", Font.BOLD, 15));
		bnt_close.setForeground(Color.WHITE);
		bnt_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "등록을 취소합니다", "게시글 등록", JOptionPane.ERROR_MESSAGE);
				frame.dispose();
				noticeBoardGUI NoticeBoradGUI = new noticeBoardGUI(dto);
			}
		});
		bnt_close.setBounds(267, 505, 124, 35);
		bnt_close.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(bnt_close);
		
		JLabel lbl_Bigname = new JLabel("\uAE00\uC4F0\uAE30");
		lbl_Bigname.setFont(new Font("굴림", Font.BOLD, 30));
		lbl_Bigname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Bigname.setBounds(205, 25, 111, 46);
		lbl_Bigname.setForeground(new Color(240, 150, 97));
		frame.getContentPane().add(lbl_Bigname);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 81, 479, 414);
		panel.setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		tf_content = new JTextField();
		tf_content.setBounds(103, 99, 357, 280);
		panel.add(tf_content);
		tf_content.setColumns(10);
		
		JLabel lb_content = new JLabel("\uB0B4\uC6A9");
		lb_content.setFont(new Font("굴림", Font.BOLD, 15));
		lb_content.setBounds(49, 224, 48, 15);
		
		panel.add(lb_content);
		lb_content.setHorizontalAlignment(SwingConstants.CENTER);
		lb_content.setForeground(new Color(233, 113, 113));
		JLabel lbl_title = new JLabel("\uC81C\uBAA9");
		lbl_title.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_title.setBounds(49, 48, 42, 15);
		
		panel.add(lbl_title);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setForeground(new Color(233, 113, 113));
		tf_title = new JTextField();
		tf_title.setBounds(103, 38, 357, 27);
		panel.add(tf_title);
		tf_title.setColumns(10);
		
		String b = this.getClass().getResource("../img/tomato.png").getPath();
		
		String c = this.getClass().getResource("../img/tomato.png").getPath();
		
		String d = this.getClass().getResource("../img/tomato.png").getPath();
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(d));
		label_1.setBounds(21, 42, 16, 21);
		panel.add(label_1);
		
		String e = this.getClass().getResource("../img/tomato.png").getPath();
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(e));
		label_2.setBounds(21, 224, 16, 21);
		panel.add(label_2);
		
		String a = this.getClass().getResource("../img/write.png").getPath();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(a));
		lblNewLabel.setBounds(144, 10, 64, 64);
		frame.getContentPane().add(lblNewLabel);
	}
}
