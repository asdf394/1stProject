package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.MemberDAO;
import Model.MemberDTO;
import javax.swing.JLabel;

public class MainGUI {

	private JFrame frame;
	MemberDTO loginDto = null;
	JButton btn_main_login;
	JButton btn_main_join;
	JButton btn_main_delete;
	JButton btn_main_logout;
	JButton btn_main_showInfo;
	JButton btn_main_modify;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI(null);
					// window.frame.setVisible(true); // 닫기 버튼 누르고 다시 메인 창으로 되돌아오려면 주석처리
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param dto 
	 */
	public MainGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
		btn_main_logout.setVisible(false);
		btn_main_showInfo.setVisible(false);
		btn_main_modify.setVisible(false);
		btn_main_delete.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1028, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btn_main_login = new JButton("\uB85C\uADF8\uC778");
		btn_main_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // main GUI가 꺼진다
				LoginGUI login = new LoginGUI(dto); // 로그인 객체 생성

			}
		});
		btn_main_login.setFont(new Font("돋움체", Font.PLAIN, 15));
		btn_main_login.setBounds(12, 15, 410, 66);
		frame.getContentPane().add(btn_main_login);

		btn_main_join = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_main_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MemberShipGUI2 join = new MemberShipGUI2(dto);
			}
		});
		btn_main_join.setFont(new Font("돋움체", Font.PLAIN, 15));
		btn_main_join.setBounds(12, 96, 410, 66);
		frame.getContentPane().add(btn_main_join);

		btn_main_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_main_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI mainGui = new MainGUI(dto);
			}
		});
		btn_main_logout.setFont(new Font("돋움체", Font.PLAIN, 15));
		btn_main_logout.setBounds(12, 177, 410, 66);
		frame.getContentPane().add(btn_main_logout);

		btn_main_showInfo = new JButton("\uD68C\uC6D0\uC815\uBCF4\uBCF4\uAE30");
		btn_main_showInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberInfoGUI memberInfo = new MemberInfoGUI();
			}
		});
		btn_main_showInfo.setFont(new Font("돋움체", Font.PLAIN, 15));
		btn_main_showInfo.setBounds(12, 415, 410, 66);
		frame.getContentPane().add(btn_main_showInfo);

		btn_main_modify = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		btn_main_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateGUI update = new UpdateGUI(dto);
			}
		});
		btn_main_modify.setFont(new Font("돋움체", Font.PLAIN, 15));
		btn_main_modify.setBounds(12, 339, 410, 66);
		frame.getContentPane().add(btn_main_modify);

		btn_main_delete = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btn_main_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				deleteGUI delete = new deleteGUI(dto);
			}
		});
		btn_main_delete.setBounds(12, 253, 410, 73);
		frame.getContentPane().add(btn_main_delete);
		
		JButton button = new JButton("\uACB0\uC81C\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayGUI pay = new PayGUI(dto);
			}
		});
		button.setFont(new Font("돋움체", Font.PLAIN, 15));
		button.setBounds(516, 15, 410, 66);
		frame.getContentPane().add(button);
	}

	public void loginInfo(MemberDTO dto) {
		loginDto = dto;
		btn_main_login.setVisible(false);
		btn_main_join.setVisible(false);
		btn_main_delete.setVisible(true);
		btn_main_logout.setVisible(true);
		btn_main_modify.setVisible(true);

		if (loginDto.getId().equals("a")) {
			btn_main_showInfo.setVisible(true);
		}
		JOptionPane.showMessageDialog(null, loginDto.getName() + "님 환영합니다.");
	}

}
