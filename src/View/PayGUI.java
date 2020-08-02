package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Model.MemberDTO;
import Model.PayDAO;
import Model.ToyDAO;

public class PayGUI {

	private JFrame frame;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;

	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();

	PayDAO pDAO = new PayDAO();
	ToyDAO tDAO = new ToyDAO();
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PayGUI window = new PayGUI(null);
//					
//					//window.frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PayGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	private int place = 0; // 택배 유무 변수
	private int discount = 1; // 장애인 기초수급자 할인 여부
	private int pay_Total;

	private void initialize(MemberDTO dto) {
		pay_Total = pDAO.payCal(dto) * 20000;
		System.out.println("연회비 포함 금액 " + pDAO.payCal(dto) * 20000);
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 441, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 401, 560);
		panel.setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uBC30\uC1A1\uC9C0\uC815\uBCF4");
		lblNewLabel.setBounds(40, 10, 79, 23);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(233, 113, 113));

		JLabel lblNewLabel_1 = new JLabel("\uD560\uC778\uC5EC\uBD80");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setBounds(40, 170, 57, 15);
		lblNewLabel_1.setForeground(new Color(233, 113, 113));
		panel.add(lblNewLabel_1);

		JRadioButton btn_able = new JRadioButton("\uD574\uB2F9\uC5C6\uC74C");
		btn_able.setBounds(103, 166, 79, 23);
		btn_able.setForeground(new Color(233, 113, 113));
		panel.add(btn_able);

		buttonGroup_1.add(btn_able);
		btn_able.setBackground(new Color(250, 236, 197));

		JLabel lblNewLabel_7 = new JLabel(pay_Total + "");
		lblNewLabel_7.setBounds(124, 224, 110, 23);
		lblNewLabel_7.setForeground(new Color(233, 113, 113));
		panel.add(lblNewLabel_7);

		JRadioButton btn_disabled = new JRadioButton("\uC7A5\uC560\uC778, \uAE30\uCD08\uC218\uAE09\uC790");
		btn_disabled.setBounds(203, 166, 129, 23);
		btn_disabled.setForeground(new Color(233, 113, 113));
		panel.add(btn_disabled);
		btn_disabled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn_disabled.isSelected()) {
					PayDAO dao = new PayDAO();
					dao.discountCK(dto);
					discount = 2;
					pay_Total /= discount;
					lblNewLabel_7.setText(pay_Total + "");
				}
			}
		});
		buttonGroup_1.add(btn_disabled);
		btn_disabled.setBackground(new Color(250, 236, 197));
		btn_disabled.setForeground(new Color(233, 113, 113));

		JLabel label = new JLabel("\uB300\uC5EC\uC7A5\uC18C");
		label.setFont(new Font("굴림", Font.BOLD, 12));
		label.setBounds(40, 195, 57, 15);
		label.setForeground(new Color(233, 113, 113));
		panel.add(label);

		JRadioButton btn_direct = new JRadioButton("\uC9C1\uC811\uC218\uB839");
		btn_direct.setBounds(103, 191, 79, 23);
		panel.add(btn_direct);
		buttonGroup_2.add(btn_direct);
		btn_direct.setBackground(new Color(250, 236, 197));
		btn_direct.setForeground(new Color(233, 113, 113));

		JRadioButton btn_delivery = new JRadioButton("\uD0DD\uBC30");
		btn_delivery.setBounds(203, 191, 57, 23);
		btn_delivery.setForeground(new Color(233, 113, 113));
		panel.add(btn_delivery);
		btn_delivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btn_delivery.isSelected()) {

					PayDAO dao = new PayDAO();
					dao.placeCK(dto);// 택배 db 수정
					place = 1; // 0:직접수령, 1:택배
					pay_Total += 3000 * place;
					// TOTAL = PAY_YEAR * 20000 / DISCOUNT +3000* PLACE
					System.out.println("결제금액" + pay_Total);
					lblNewLabel_7.setText(pay_Total + "");
				}
			}
		});
		buttonGroup_2.add(btn_delivery);
		btn_delivery.setBackground(new Color(250, 236, 197));

		JLabel lblNewLabel_6 = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561");
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_6.setBounds(40, 224, 79, 23);
		lblNewLabel_6.setForeground(new Color(233, 113, 113));
		panel.add(lblNewLabel_6);

		JLabel label_2 = new JLabel("\uACB0\uC81C\uAE08\uC561 : 3000\uC6D0");
		label_2.setBounds(268, 195, 121, 15);
		label_2.setForeground(new Color(233, 113, 113));
		panel.add(label_2);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\uD68C\uC6D0\uC815\uBCF4\uC640 \uB3D9\uC77C");
		rdbtnNewRadioButton_3.setBounds(28, 39, 121, 23);
		panel.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setFont(new Font("굴림", Font.BOLD, 12));
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBackground(new Color(250, 236, 197));
		rdbtnNewRadioButton_3.setForeground(new Color(233, 113, 113));

		JRadioButton radioButton_4 = new JRadioButton("\uC0C8\uB85C\uC785\uB825");
		radioButton_4.setBounds(28, 75, 79, 23);
		panel.add(radioButton_4);
		radioButton_4.setFont(new Font("굴림", Font.BOLD, 12));
		buttonGroup.add(radioButton_4);
		radioButton_4.setBackground(new Color(250, 236, 197));
		radioButton_4.setForeground(new Color(233, 113, 113));

		textField_1 = new JTextField();
		textField_1.setBounds(113, 76, 255, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("\uACB0\uC81C\uC815\uBCF4");
		label_1.setBounds(40, 137, 79, 23);
		panel.add(label_1);
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		label_1.setForeground(new Color(233, 113, 113));

		JLabel label_3 = new JLabel("\uACB0\uC81C\uBC29\uBC95");
		label_3.setBounds(40, 272, 79, 23);
		panel.add(label_3);
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		label_3.setForeground(new Color(233, 113, 113));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 305, 363, 247);
		panel.add(tabbedPane);

		JPanel 무통장입급 = new JPanel();
		무통장입급.setForeground(Color.BLACK);
		무통장입급.setBackground(Color.WHITE);
		무통장입급.setToolTipText("");
		tabbedPane.addTab("\uBB34\uD1B5\uC7A5\uC785\uAE08", null, 무통장입급, null);
		무통장입급.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\uC785\uAE08\uC740\uD589");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBounds(25, 27, 70, 31);
		lblNewLabel_2.setForeground(new Color(233, 113, 113));
		무통장입급.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "\uAD6D\uBBFC\uC740\uD589", "\uD558\uB098\uC740\uD589", "\uC2E0\uD611", "\uB18D\uD611",
						"\uC6B0\uB9AC\uC740\uD589", "\uCE74\uCE74\uC624\uBC45\uD06C", "\uCF00\uC774\uBC45\uD06C",
						"\uAD11\uC8FC\uC740\uD589", "\uBD80\uC0B0\uC740\uD589", "\uB300\uAD6C\uC740\uD589" }));
		comboBox.setBounds(119, 32, 91, 21);
		comboBox.setForeground(new Color(233, 113, 113));
		무통장입급.add(comboBox);

		JLabel label_4 = new JLabel("\uC1A1\uAE08\uC790\uBA85");
		label_4.setFont(new Font("굴림", Font.BOLD, 12));
		label_4.setBounds(25, 67, 70, 31);
		label_4.setForeground(new Color(233, 113, 113));
		무통장입급.add(label_4);

		textField = new JTextField();
		textField.setBounds(119, 72, 91, 21);
		무통장입급.add(textField);
		textField.setColumns(10);

		JLabel label_5 = new JLabel("\uC785\uAE08\uACC4\uC88C");
		label_5.setFont(new Font("굴림", Font.BOLD, 12));
		label_5.setBounds(25, 105, 62, 31);
		label_5.setForeground(new Color(233, 113, 113));
		무통장입급.add(label_5);

		JLabel lblNewLabel_3 = new JLabel(
				"\uAD11\uC8FC\uC740\uD589 600162 - 121- 025842  \uC7A5\uB09C\uAC10\uB3C4\uC11C\uAD00");
		lblNewLabel_3.setBounds(94, 113, 264, 15);
		lblNewLabel_3.setForeground(new Color(233, 113, 113));
		무통장입급.add(lblNewLabel_3);

		JCheckBox chckbxNewCheckBox = new JCheckBox("\uD604\uAE08\uC601\uC218\uC99D \uBC1C\uD589");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(20, 142, 133, 23);
		chckbxNewCheckBox.setForeground(new Color(233, 113, 113));
		무통장입급.add(chckbxNewCheckBox);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\uC18C\uB4DD\uACF5\uC81C\uC6A9");
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		buttonGroup_3.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(106, 175, 104, 23);
		rdbtnNewRadioButton_2.setForeground(new Color(233, 113, 113));
		무통장입급.add(rdbtnNewRadioButton_2);

		JRadioButton radioButton_2 = new JRadioButton("\uC9C0\uCD9C\uC99D\uBE59\uC6A9");
		radioButton_2.setBackground(Color.WHITE);
		buttonGroup_3.add(radioButton_2);
		radioButton_2.setBounds(211, 175, 104, 23);
		radioButton_2.setForeground(new Color(233, 113, 113));
		무통장입급.add(radioButton_2);

		JLabel label_6 = new JLabel("\uC601\uC218\uC99D \uC6A9\uB3C4");
		label_6.setFont(new Font("굴림", Font.BOLD, 12));
		label_6.setBounds(25, 171, 70, 31);
		label_6.setForeground(new Color(233, 113, 113));
		무통장입급.add(label_6);

		JButton button = new JButton("\uACB0\uC81C\uD558\uAE30");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(40, 582, 157, 31);
		button.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
				frame.dispose();

				int count = tDAO.countBK(); // 장바구니 담겨 있는 개수 구하기
				int[] toyN = pDAO.selectToyNo(dto.getId(), count);
				System.out.println("대여할 사용자 : " + dto.getId());
				System.out.println("대여할 장난감 개수 : " + toyN.length);
				if (toyN.length != 0) {
					for (int j = 0; j < toyN.length; j++) {
						int cnt = pDAO.addRent(toyN[j], place);
						tDAO.changeRent(toyN[j]);
						System.out.println("토이넘버 출력" + toyN[j]);
						// 결제 테이블에 저장
						pDAO.insertPay(dto.getId(), discount, place, 0, toyN[j]);
						if (cnt != 0) {
							System.out.println("대여테이블에 값 넣기 성공");
						} else {
							System.out.println("대여테이블에 넣기 실패");
						}
					}

				}
				tDAO.clearBasket();
				tDAO.clearBasketSQ();
			}

		});
//		button.setBounds(94, 196, 170, 31);
//		무통장입급.add(button);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("\uC2E0\uC6A9\uCE74\uB4DC", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("\uCE74\uB4DC\uC885\uB958");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_4.setBounds(12, 33, 57, 15);
		lblNewLabel_4.setForeground(new Color(233, 113, 113));
		panel_1.add(lblNewLabel_4);

		JLabel label_7 = new JLabel("\uCE74\uB4DC\uBC88\uD638");
		label_7.setFont(new Font("굴림", Font.BOLD, 12));
		label_7.setBounds(12, 61, 57, 15);
		label_7.setForeground(new Color(233, 113, 113));
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("\uC720\uD6A8\uAE30\uAC04");
		label_8.setFont(new Font("굴림", Font.BOLD, 12));
		label_8.setBounds(12, 97, 57, 15);
		label_8.setForeground(new Color(233, 113, 113));
		panel_1.add(label_8);

		JLabel label_10 = new JLabel("\uC8FC\uBE48\uBC88\uD638\uB4B7\uC790\uB9AC");
		label_10.setFont(new Font("굴림", Font.BOLD, 12));
		label_10.setBounds(12, 125, 101, 15);
		label_10.setForeground(new Color(233, 113, 113));
		panel_1.add(label_10);

		JLabel label_11 = new JLabel("\uCE74\uB4DC\uBE44\uBC00\uBC88\uD638");
		label_11.setFont(new Font("굴림", Font.BOLD, 12));
		label_11.setBounds(12, 156, 101, 15);
		label_11.setForeground(new Color(233, 113, 113));
		panel_1.add(label_11);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "\uAD6D\uBBFC", "\uD604\uB300", "\uD558\uB098",
				"\uC2E0\uD55C", "\uAD11\uC8FC", "\uCE74\uCE74\uC624\uBC45\uD06C" }));
		comboBox_1.setBounds(87, 30, 91, 21);
		comboBox_1.setForeground(new Color(233, 113, 113));
		panel_1.add(comboBox_1);

		textField_2 = new JTextField();
		textField_2.setBounds(293, 61, 57, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(224, 61, 57, 21);
		panel_1.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 61, 57, 21);
		panel_1.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(86, 61, 57, 21);
		panel_1.add(textField_5);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "01\uC6D4", "02\uC6D4", "03\uC6D4", "04\uC6D4",
				"05\uC6D4", "06\uC6D4", "07\uC6D4", "08\uC6D4", "09\uC6D4", "10\uC6D4", "11\uC6D4", "12\uC6D4" }));
		comboBox_2.setBounds(87, 92, 91, 21);
		comboBox_2.setForeground(new Color(233, 113, 113));
		panel_1.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(
				new String[] { "2020\uB144", "2021\uB144", "2022\uB144", "2023\uB144", "2024\uB144", "2025\uB144",
						"2026\uB144", "2027\uB144", "2028\uB144", "2029\uB144", "2030\uB144" }));
		comboBox_3.setBounds(190, 92, 91, 21);
		comboBox_3.setForeground(new Color(233, 113, 113));
		panel_1.add(comboBox_3);

		JLabel lblNewLabel_5 = new JLabel("XXXXXX-");
		lblNewLabel_5.setBounds(121, 125, 57, 15);
		lblNewLabel_5.setForeground(new Color(233, 113, 113));
		panel_1.add(lblNewLabel_5);

		textField_6 = new JTextField();
		textField_6.setBounds(185, 122, 116, 21);
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(110, 153, 33, 21);
		panel_1.add(passwordField);

		JLabel label_9 = new JLabel("\uC55E 2\uC790\uB9AC");
		label_9.setBounds(167, 156, 57, 15);
		label_9.setForeground(new Color(233, 113, 113));
		panel_1.add(label_9);

		JLabel lblXx = new JLabel("XX");
		lblXx.setBounds(143, 156, 22, 15);
		lblXx.setForeground(new Color(233, 113, 113));
		panel_1.add(lblXx);

		JButton button_1 = new JButton("\uB2EB\uAE30");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(222, 580, 157, 31);
		button_1.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});

		String a = this.getClass().getResource("../img/flower.png").getPath();
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(a));
		lblNewLabel_8.setBounds(12, 10, 16, 23);
		panel.add(lblNewLabel_8);

		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(a));
		label_12.setBounds(12, 137, 16, 23);
		panel.add(label_12);

		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(a));
		label_13.setBounds(12, 272, 16, 23);
		panel.add(label_13);
	}
}
