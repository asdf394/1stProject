package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Model.MemberDAO;
import Model.MemberDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class deleteGUI {

	private JFrame frame;
	private JTextField id_text;
	private JTextField pw_text;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					deleteGUI window = new deleteGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public deleteGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD68C \uC6D0 \uD0C8 \uD1F4");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(240, 150, 97));
		lblNewLabel.setBounds(170, 10, 133, 24);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(233, 113, 113));
		lblNewLabel_1.setBounds(54, 75, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("굴림", Font.BOLD, 15));
		lblPw.setForeground(new Color(233, 113, 113));
		lblPw.setBounds(54, 124, 57, 15);
		frame.getContentPane().add(lblPw);

		id_text = new JTextField();
		id_text.setBounds(123, 74, 204, 21);
		frame.getContentPane().add(id_text);
		id_text.setColumns(10);

		pw_text = new JTextField();
		pw_text.setColumns(10);
		pw_text.setBounds(123, 123, 204, 21);
		frame.getContentPane().add(pw_text);

		JButton btnNewButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = new MemberDAO();
				String id = id_text.getText();
				String pw = pw_text.getText();
				int cnt = dao.deletemember(id, pw);
				if(cnt == 0) {
					// 다이얼로그 띄우기
					// 에러메세지 -> 4개 매개변수
					// 빌드패스 사용
					JOptionPane.showMessageDialog(null, "다시입력해주세요", "로그인", JOptionPane.ERROR_MESSAGE);
					
				}else {
					frame.dispose();
					JOptionPane.showMessageDialog(null,  "회원탈퇴완료");
					MainGUI mainGui = new MainGUI(dto);
					
					
				}
			
			      
				
			}
		});
		btnNewButton.setBounds(101, 201, 97, 23);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("\uB2EB\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // 창 닫기
			}
		});
		button.setBounds(230, 201, 97, 23);
		frame.getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 51, 410, 137);
		panel.setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(panel);
	}
}
