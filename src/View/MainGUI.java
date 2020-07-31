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
import java.awt.Color;

public class MainGUI {

	private JFrame frame;
	MemberDTO loginDto = null;
	JButton btn_main_logout;
	JButton btn_main_showInfo;
	JButton btn_main_modify;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI(null);
					// MainGUI window = new MainGUI(null);
					// window.frame.setVisible(true); // 닫기 버튼 누르고 다시 메인 창으로 되돌아오려면 주석처리
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param dto
	 * @wbp.parser.entryPoint
	 */
	public MainGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
		btn_main_logout.setVisible(false);
		btn_main_showInfo.setVisible(false);
		btn_main_modify.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1028, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btn_main_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_main_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI mainGui = new MainGUI(dto);
			}
		});
		btn_main_logout.setFont(new Font("돋움체", Font.PLAIN, 15));
		btn_main_logout.setBounds(794, 53, 177, 40);
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
		btn_main_modify.setBounds(12, 336, 410, 66);
		frame.getContentPane().add(btn_main_modify);

		JButton btnNewButton = new JButton("\uC7A5\uB09C\uAC10 \uBCF4\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ToyInfoGUI toyinfo = new ToyInfoGUI();
			}
		});
		btnNewButton.setBounds(52, 168, 310, 85);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uAC8C\uC2DC\uD310 \uBCF4\uAE30");
		btnNewButton_1.setBounds(42, 92, 310, 66);
		frame.getContentPane().add(btnNewButton_1);
	}

	public void loginInfo(MemberDTO dto) {
		loginDto = dto;
		btn_main_logout.setVisible(true);
		btn_main_modify.setVisible(true);

		if (loginDto.getId().equals("a")) {
			btn_main_showInfo.setVisible(true);
		}
		JOptionPane.showMessageDialog(null, loginDto.getName() + "님 환영합니다.");
	}
}
