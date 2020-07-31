package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Model.MemberDTO;
import Model.PayDAO;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayGUI window = new PayGUI(null);
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PayGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBC30\uC1A1\uC9C0\uC815\uBCF4");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(31, 20, 79, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD560\uC778\uC5EC\uBD80");
		lblNewLabel_1.setBounds(53, 189, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JRadioButton btn_able = new JRadioButton("\uD574\uB2F9\uC5C6\uC74C");

		buttonGroup_1.add(btn_able);
		btn_able.setBounds(116, 185, 121, 23);
		frame.getContentPane().add(btn_able);
		
		JRadioButton btn_disabled = new JRadioButton("\uC7A5\uC560\uC778, \uAE30\uCD08\uC218\uAE09\uC790");
		btn_disabled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn_disabled.isSelected()) {
					PayDAO dao = new PayDAO();
					dao.discountCK(dto);
				}
			}
		});
		buttonGroup_1.add(btn_disabled);
		btn_disabled.setBounds(260, 185, 151, 23);
		frame.getContentPane().add(btn_disabled);
		
		
		JLabel label = new JLabel("\uB300\uC5EC\uC7A5\uC18C");
		label.setBounds(53, 224, 57, 15);
		frame.getContentPane().add(label);
		
		JRadioButton btn_direct = new JRadioButton("\uC9C1\uC811\uC218\uB839");
		buttonGroup_2.add(btn_direct);
		btn_direct.setBounds(116, 220, 121, 23);
		frame.getContentPane().add(btn_direct);
		
		JRadioButton btn_delivery = new JRadioButton("\uD0DD\uBC30");
		buttonGroup_2.add(btn_delivery);
		btn_delivery.setBounds(116, 245, 67, 23);
		frame.getContentPane().add(btn_delivery);
		
		JLabel label_2 = new JLabel("\uACB0\uC81C\uAE08\uC561 : 3000\uC6D0");
		label_2.setBounds(204, 249, 121, 15);
		frame.getContentPane().add(label_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\uD68C\uC6D0\uC815\uBCF4\uC640 \uB3D9\uC77C");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(31, 61, 121, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("\uC0C8\uB85C\uC785\uB825");
		buttonGroup.add(radioButton_4);
		radioButton_4.setBounds(31, 97, 79, 23);
		frame.getContentPane().add(radioButton_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 98, 278, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\uACB0\uC81C\uC815\uBCF4");
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		label_1.setBounds(31, 156, 79, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_3 = new JLabel("\uACB0\uC81C\uBC29\uBC95");
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		label_3.setBounds(31, 302, 79, 23);
		frame.getContentPane().add(label_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(31, 335, 363, 266);
		frame.getContentPane().add(tabbedPane);
		
		JPanel 무통장입급 = new JPanel();
		무통장입급.setToolTipText("");
		tabbedPane.addTab("\uBB34\uD1B5\uC7A5\uC785\uAE08", null, 무통장입급, null);
		무통장입급.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uC785\uAE08\uC740\uD589");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBounds(25, 27, 70, 31);
		무통장입급.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uAD6D\uBBFC\uC740\uD589", "\uD558\uB098\uC740\uD589", "\uC2E0\uD611", "\uB18D\uD611", "\uC6B0\uB9AC\uC740\uD589", "\uCE74\uCE74\uC624\uBC45\uD06C", "\uCF00\uC774\uBC45\uD06C", "\uAD11\uC8FC\uC740\uD589", "\uBD80\uC0B0\uC740\uD589", "\uB300\uAD6C\uC740\uD589"}));
		comboBox.setBounds(119, 32, 91, 21);
		무통장입급.add(comboBox);
		
		JLabel label_4 = new JLabel("\uC1A1\uAE08\uC790\uBA85");
		label_4.setFont(new Font("굴림", Font.BOLD, 12));
		label_4.setBounds(25, 67, 70, 31);
		무통장입급.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(119, 72, 91, 21);
		무통장입급.add(textField);
		textField.setColumns(10);
		
		JLabel label_5 = new JLabel("\uC785\uAE08\uACC4\uC88C");
		label_5.setFont(new Font("굴림", Font.BOLD, 12));
		label_5.setBounds(25, 105, 91, 31);
		무통장입급.add(label_5);
		
		JLabel lblNewLabel_3 = new JLabel("\uAD11\uC8FC\uC740\uD589 600162 - 121- 025842  \uC7A5\uB09C\uAC10\uB3C4\uC11C\uAD00");
		lblNewLabel_3.setBounds(94, 113, 264, 15);
		무통장입급.add(lblNewLabel_3);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uD604\uAE08\uC601\uC218\uC99D \uBC1C\uD589");
		chckbxNewCheckBox.setBounds(20, 142, 133, 23);
		무통장입급.add(chckbxNewCheckBox);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\uC18C\uB4DD\uACF5\uC81C\uC6A9");
		buttonGroup_3.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(106, 167, 104, 23);
		무통장입급.add(rdbtnNewRadioButton_2);
		
		JRadioButton radioButton_2 = new JRadioButton("\uC9C0\uCD9C\uC99D\uBE59\uC6A9");
		buttonGroup_3.add(radioButton_2);
		radioButton_2.setBounds(211, 167, 104, 23);
		무통장입급.add(radioButton_2);
		
		JLabel label_6 = new JLabel("\uC601\uC218\uC99D \uC6A9\uB3C4");
		label_6.setFont(new Font("굴림", Font.BOLD, 12));
		label_6.setBounds(25, 163, 70, 31);
		무통장입급.add(label_6);
		
		JButton button = new JButton("\uBB34\uD1B5\uC7A5\uC785\uAE08 \uACB0\uC81C\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
				frame.dispose();
				MainGUI mainGui = new MainGUI(dto);
				
			}
			
		});
		button.setBounds(94, 196, 170, 31);
		무통장입급.add(button);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\uC2E0\uC6A9\uCE74\uB4DC", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\uCE74\uB4DC\uC885\uB958");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_4.setBounds(12, 17, 57, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel label_7 = new JLabel("\uCE74\uB4DC\uBC88\uD638");
		label_7.setFont(new Font("굴림", Font.BOLD, 12));
		label_7.setBounds(12, 45, 57, 15);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("\uC720\uD6A8\uAE30\uAC04");
		label_8.setFont(new Font("굴림", Font.BOLD, 12));
		label_8.setBounds(12, 82, 57, 15);
		panel_1.add(label_8);
		
		JLabel label_10 = new JLabel("\uC8FC\uBE48\uBC88\uD638\uB4B7\uC790\uB9AC");
		label_10.setFont(new Font("굴림", Font.BOLD, 12));
		label_10.setBounds(12, 132, 101, 15);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("\uCE74\uB4DC\uBE44\uBC00\uBC88\uD638");
		label_11.setFont(new Font("굴림", Font.BOLD, 12));
		label_11.setBounds(12, 157, 101, 15);
		panel_1.add(label_11);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\uAD6D\uBBFC", "\uD604\uB300", "\uD558\uB098", "\uC2E0\uD55C", "\uAD11\uC8FC", "\uCE74\uCE74\uC624\uBC45\uD06C"}));
		comboBox_1.setBounds(87, 14, 91, 21);
		panel_1.add(comboBox_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(293, 45, 57, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(224, 45, 57, 21);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 45, 57, 21);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(86, 45, 57, 21);
		panel_1.add(textField_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"01\uC6D4", "02\uC6D4", "03\uC6D4", "04\uC6D4", "05\uC6D4", "06\uC6D4", "07\uC6D4", "08\uC6D4", "09\uC6D4", "10\uC6D4", "11\uC6D4", "12\uC6D4"}));
		comboBox_2.setBounds(87, 77, 91, 21);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"2020\uB144", "2021\uB144", "2022\uB144", "2023\uB144", "2024\uB144", "2025\uB144", "2026\uB144", "2027\uB144", "2028\uB144", "2029\uB144", "2030\uB144"}));
		comboBox_3.setBounds(190, 77, 91, 21);
		panel_1.add(comboBox_3);
		
		JLabel lblNewLabel_5 = new JLabel("XXXXXX-");
		lblNewLabel_5.setBounds(121, 132, 57, 15);
		panel_1.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(185, 129, 116, 21);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 154, 33, 21);
		panel_1.add(passwordField);
		
		JLabel label_9 = new JLabel("\uC55E 2\uC790\uB9AC");
		label_9.setBounds(167, 157, 57, 15);
		panel_1.add(label_9);
		
		JButton btnNewButton = new JButton("\uC2E0\uC6A9\uCE74\uB4DC \uACB0\uC81C\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
				frame.dispose();
				MainGUI mainGui = new MainGUI(dto);
			}
		});
		btnNewButton.setBounds(83, 192, 156, 35);
		panel_1.add(btnNewButton);
		
		JLabel lblXx = new JLabel("XX");
		lblXx.setBounds(143, 157, 22, 15);
		panel_1.add(lblXx);
	}
}
