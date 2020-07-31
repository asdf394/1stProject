package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.MemberDAO;
import Model.MemberDTO;

public class LoginGUI {

	private JFrame frame;
	private JTextField tf_id;
	private JPasswordField pf_login_pw;
	MemberDTO dto;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginGUI window = new LoginGUI(); // 객체생성/					window.frame.setVisible(true); // 창을 보여주겠다
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public LoginGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true); // Main 메소드를 주석처리해서 LoginGUI 단독으로 열릴 수 없다
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 956, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_1 = new JLabel("\uB85C\uADF8\uC778");
		lbl_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_1.setBounds(12, 21, 410, 42);
		frame.getContentPane().add(lbl_1);
		
		JLabel lbl_2 = new JLabel("\uC544 \uC774 \uB514");
		lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_2.setBounds(0, 88, 78, 29);
		frame.getContentPane().add(lbl_2);
		
		JLabel lbl_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_3.setBounds(0, 141, 78, 29);
		frame.getContentPane().add(lbl_3);
		
		tf_id = new JTextField();
		tf_id.setBounds(90, 85, 310, 32);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);
		
		JButton btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = new MemberDAO();
				String id = tf_id.getText();
				String pw = pf_login_pw.getText();
				MemberDTO dto = dao.loginSelect(id,pw);
				if(dto == null) {
					// 다이얼로그 띄우기
					// 에러메세지 -> 4개 매개변수
					// 빌드패스 사용
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);
					pf_login_pw.setText(""); // 비밀번호만 사라진다
				}else {
					frame.dispose();
					MainGUI mainGui = new MainGUI(dto);
					mainGui.loginInfo(dto);
				}
			
			}
		});
		btn_login.setBounds(54, 194, 155, 32);
		frame.getContentPane().add(btn_login);
		
		JButton btn_close = new JButton("\uB2EB\uAE30");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // 창 닫기
				MainGUI mainGui = new MainGUI(dto); // 메인 창 띄우기 객체 생성
			}
		});
		btn_close.setBounds(233, 194, 155, 32);
		frame.getContentPane().add(btn_close);
		
		pf_login_pw = new JPasswordField();
		pf_login_pw.setBounds(90, 138, 310, 32);
		frame.getContentPane().add(pf_login_pw);
	}
}











