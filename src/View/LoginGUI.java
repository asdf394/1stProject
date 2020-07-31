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
//					LoginGUI window = new LoginGUI(); // ��ü����/					window.frame.setVisible(true); // â�� �����ְڴ�
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
		frame.setVisible(true); // Main �޼ҵ带 �ּ�ó���ؼ� LoginGUI �ܵ����� ���� �� ����
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
		lbl_1.setFont(new Font("����", Font.PLAIN, 20));
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
					// ���̾�α� ����
					// �����޼��� -> 4�� �Ű�����
					// �����н� ���
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α���", JOptionPane.ERROR_MESSAGE);
					pf_login_pw.setText(""); // ��й�ȣ�� �������
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
				frame.dispose(); // â �ݱ�
				MainGUI mainGui = new MainGUI(dto); // ���� â ���� ��ü ����
			}
		});
		btn_close.setBounds(233, 194, 155, 32);
		frame.getContentPane().add(btn_close);
		
		pf_login_pw = new JPasswordField();
		pf_login_pw.setBounds(90, 138, 310, 32);
		frame.getContentPane().add(pf_login_pw);
	}
}











