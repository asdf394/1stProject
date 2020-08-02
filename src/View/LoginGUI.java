package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	MemberDTO dto;
	private JTextField tf_id;
	private JPasswordField pf_pw;
	private JLabel lbl_troy;
	private JLabel lbl_car;
	private JLabel lbl_ring;
	private JLabel lblId;
	private JLabel lblPw;
	private JLabel lbl_toy;
	private JLabel lb_delivery;

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
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		tf_id = new JTextField();
		tf_id.setForeground(SystemColor.scrollbar);
		tf_id.setToolTipText("");
		tf_id.setBackground(new Color(255, 255, 255));
		tf_id.setBounds(580, 286, 218, 30);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);

		pf_pw = new JPasswordField();
		pf_pw.setToolTipText("");
		pf_pw.setBackground(new Color(255, 255, 255));
		pf_pw.setBounds(580, 348, 218, 30);
		frame.getContentPane().add(pf_pw);

		JButton btn_login = new JButton("LOGIN");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = new MemberDAO();
				String id = tf_id.getText();
				String pw = pf_pw.getText();
				MemberDTO dto = dao.loginSelect(id, pw);
				if (dto == null) {
					// 다이얼로그 띄우기
					// 에러메세지 -> 4개 매개변수
					// 빌드패스 사용
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);
					pf_pw.setText(""); // 비밀번호만 사라진다
				} else {
					frame.dispose();
					MainGUI mainGui = new MainGUI(dto);
					mainGui.loginInfo(dto);
				}
			}
		});
		btn_login.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btn_login.setIcon(null);
		btn_login.setBounds(580, 398, 103, 30);
		btn_login.setBackground(new Color(240, 150, 97));
		btn_login.setForeground(Color.white);
		frame.getContentPane().add(btn_login);

		JButton btn_join = new JButton("JOIN");
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    frame.dispose();
				MemberShipGUI2 join = new MemberShipGUI2(dto);
			}
		});
		btn_join.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btn_join.setBackground(new Color(240, 150, 97));
		btn_join.setForeground(Color.white);
		btn_join.setBounds(689, 398, 109, 30);

		frame.getContentPane().add(btn_join);

		String a = this.getClass().getResource("../img/troy.png").getPath();
		String b = this.getClass().getResource("../img/car.png").getPath();
		String c = this.getClass().getResource("../img/ring.png").getPath();

		lbl_troy = new JLabel("");
		lbl_troy.setIcon(new ImageIcon(a));
		lbl_troy.setBackground(Color.WHITE);
		lbl_troy.setBounds(44, 31, 469, 529);
		frame.getContentPane().add(lbl_troy);

		lbl_car = new JLabel("");
		lbl_car.setIcon(new ImageIcon(b));
		lbl_car.setBounds(486, 279, 57, 48);
		frame.getContentPane().add(lbl_car);

		lbl_ring = new JLabel("");
		lbl_ring.setIcon(new ImageIcon(c));
		lbl_ring.setBounds(486, 330, 57, 48);
		frame.getContentPane().add(lbl_ring);

		lblId = new JLabel("ID");
		lblId.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(529, 286, 57, 29);
		frame.getContentPane().add(lblId);

		lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblPw.setBounds(526, 347, 57, 29);
		frame.getContentPane().add(lblPw);

		lbl_toy = new JLabel("TOY");
		lbl_toy.setFont(new Font("Bahnschrift", Font.BOLD, 60));
		lbl_toy.setBounds(476, 79, 116, 112);
		lbl_toy.setForeground(new Color(150, 60, 7));
		frame.getContentPane().add(lbl_toy);

		lb_delivery = new JLabel("DELIVERY");
		lb_delivery.setFont(new Font("Bahnschrift", Font.BOLD, 60));
		lb_delivery.setBounds(513, 143, 325, 112);
		lb_delivery.setForeground(new Color(240, 150, 97));
		frame.getContentPane().add(lb_delivery);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
