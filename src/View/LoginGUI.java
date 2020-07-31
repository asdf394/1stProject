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

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.DropMode;

public class LoginGUI {

	private JFrame frame;
	MemberDTO dto;
	private JTextField tf_id;
	private JLabel lblNewLabel_1;
	private JPasswordField pf_pw;

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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\SMT039\\Desktop\\\uBB34\uC81C.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 21));
		lblNewLabel_1.setBounds(178, 44, 467, 60);
		frame.getContentPane().add(lblNewLabel_1);

		tf_id = new JTextField();
		tf_id.setForeground(SystemColor.scrollbar);
		tf_id.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694");
		tf_id.setToolTipText("");
		tf_id.setBackground(new Color(255, 255, 255));
		tf_id.setBounds(481, 235, 218, 30);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);

		pf_pw = new JPasswordField();
		pf_pw.setToolTipText("");
		pf_pw.setBackground(new Color(255, 255, 255));
		pf_pw.setBounds(481, 299, 218, 30);
		frame.getContentPane().add(pf_pw);

		JButton btn_singIn = new JButton("");
		btn_singIn.setIcon(new ImageIcon("C:\\Users\\SMT039\\Desktop\\\uB85C\uADF8\uC778.png"));
		btn_singIn.setBounds(510, 359, 171, 38);
		frame.getContentPane().add(btn_singIn);

		JButton btn_singUP = new JButton("New button");
		btn_singUP.setBounds(548, 407, 97, 30);
		frame.getContentPane().add(btn_singUP);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SMT039\\Desktop\\12.png"));
		lblNewLabel.setBounds(0, 0, 831, 468);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 847, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
