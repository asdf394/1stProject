package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Model.MemberDTO;

public class MainGUI {

	private JFrame frame;
	static MemberDTO loginDto = null;
	JButton btn_main_logout;
	JButton btn_main_showInfo;
	JButton btn_main_modify;
	private JButton btn_show_board;
	private JLabel lblToyDelivery;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI(loginDto);
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
		btn_main_logout.setVisible(true);
		btn_main_showInfo.setVisible(true);
		btn_main_modify.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		if (dto == null) {
			System.out.println("로그인 안됨");
		} else {
			System.out.println("메인창 ID : " + dto.getId());
		}

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("굴림", Font.BOLD, 12));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		btn_main_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_main_logout.setForeground(Color.WHITE);
		btn_main_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginGUI login = new LoginGUI(null);
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다", "로그아웃", JOptionPane.INFORMATION_MESSAGE);
//				MainGUI mainGui = new MainGUI(dto);
			}
		});
		btn_main_logout.setFont(new Font("굴림", Font.BOLD, 15));
		btn_main_logout.setBounds(433, 347, 252, 66);
		btn_main_logout.setBackground(new Color(241, 95, 95));
		frame.getContentPane().add(btn_main_logout);

		btn_main_showInfo = new JButton("\uD68C\uC6D0\uC815\uBCF4\uBCF4\uAE30");
		btn_main_showInfo.setBackground(Color.PINK);
		btn_main_showInfo.setForeground(Color.WHITE);
		btn_main_showInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				if (loginDto.getId().equals("admin")) {
					MemberInfoGUI admin = new MemberInfoGUI(dto);
				} else {
					MemberInfoOnlyGUI member = new MemberInfoOnlyGUI(dto);
				}
			}
		});
		btn_main_showInfo.setFont(new Font("굴림", Font.BOLD, 15));
		btn_main_showInfo.setBounds(168, 423, 517, 66);
		frame.getContentPane().add(btn_main_showInfo);

		btn_main_modify = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		btn_main_modify.setForeground(Color.WHITE);
		btn_main_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateGUI update = new UpdateGUI(dto);
			}
		});
		btn_main_modify.setFont(new Font("굴림", Font.BOLD, 15));
		btn_main_modify.setBounds(168, 347, 253, 66);
		btn_main_modify.setBackground(new Color(241, 95, 95));
		frame.getContentPane().add(btn_main_modify);

		String a = this.getClass().getResource("../img/show_toy.png").getPath();
		JButton btn_showtoy = new JButton("");
		btn_showtoy.setIcon(new ImageIcon(a));
		btn_showtoy.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_showtoy.setFont(new Font("굴림", Font.BOLD, 15));
		btn_showtoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ToyInfoGUI toyinfo = new ToyInfoGUI(dto);
			}
		});

		btn_showtoy.setForeground(Color.WHITE);
		btn_showtoy.setBackground(new Color(242, 203, 97));
		btn_showtoy.setBounds(168, 117, 253, 220);
		frame.getContentPane().add(btn_showtoy);

//		String a = this.getClass().getResource("../img/troy.png").getPath();
//		String b = this.getClass().getResource("../img/car.png").getPath();
//		String c = this.getClass().getResource("../img/ring.png").getPath();
//
//		lbl_troy = new JLabel("");
//		lbl_troy.setIcon(new ImageIcon(a));
//		lbl_troy.setBackground(Color.WHITE);
//		lbl_troy.setBounds(44, 31, 469, 529);
//		frame.getContentPane().add(lbl_troy);

		String b = this.getClass().getResource("../img/board.png").getPath();
		btn_show_board = new JButton("");
		btn_show_board.setIcon(new ImageIcon(b));
		btn_show_board.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				noticeBoardGUI board = new noticeBoardGUI(dto);
			}
		});
		btn_show_board.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_show_board.setFont(new Font("굴림", Font.BOLD, 15));
		btn_show_board.setForeground(Color.WHITE);
		btn_show_board.setBackground(new Color(242, 203, 97));
		btn_show_board.setBounds(433, 117, 253, 220);
		frame.getContentPane().add(btn_show_board);

		lblToyDelivery = new JLabel("TOY DELIVERY");
		lblToyDelivery.setForeground(new Color(240, 150, 97));
		lblToyDelivery.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		lblToyDelivery.setBounds(294, 24, 291, 66);
		frame.getContentPane().add(lblToyDelivery);

	}

	public void loginInfo(MemberDTO dto) {
		loginDto = dto;
		btn_main_logout.setVisible(true);
		btn_main_modify.setVisible(true);

		JOptionPane.showMessageDialog(null, loginDto.getName() + "님 환영합니다.");
	}
}
