package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Model.MemberDAO;
import Model.MemberDTO;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class MemberShipGUI2 {

	private JFrame frame;
	private JTextField tf_Name;
	private JTextField tf_Id;
	private JTextField tf_Phone;
	private JTextField tf_Address;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int saletarget;
	private JPasswordField pw_1;
	private JPasswordField pw_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MemberShipGUI2 window = new MemberShipGUI2(null);
//					//window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MemberShipGUI2(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 520, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 77, 480, 405);
		panel.setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Address = new JLabel("\uC8FC \uC18C");
		lbl_Address.setBounds(49, 212, 57, 15);
		lbl_Address.setForeground(new Color(233, 113, 113));
		panel.add(lbl_Address);
		lbl_Address.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_Address.setHorizontalAlignment(SwingConstants.CENTER);
		
		tf_Address = new JTextField();
		tf_Address.setBounds(136, 209, 260, 21);
		panel.add(tf_Address);
		tf_Address.setColumns(10);
		
		JLabel lbl_Name = new JLabel("\uC774 \uB984");
		lbl_Name.setBounds(49, 170, 57, 15);
		lbl_Name.setForeground(new Color(233, 113, 113));
		panel.add(lbl_Name);
		lbl_Name.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_Name.setHorizontalAlignment(SwingConstants.CENTER);
		
		tf_Name = new JTextField();
		tf_Name.setBounds(136, 167, 260, 21);
		panel.add(tf_Name);
		tf_Name.setColumns(10);
		
		JLabel lbl_RePw = new JLabel("\uC7AC\uC785\uB825");
		lbl_RePw.setBounds(49, 128, 63, 15);
		panel.add(lbl_RePw);
		lbl_RePw.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_RePw.setForeground(new Color(233, 113, 113));
		lbl_RePw.setHorizontalAlignment(SwingConstants.CENTER);
		
		pw_2 = new JPasswordField();
		pw_2.setBounds(136, 125, 260, 21);
		panel.add(pw_2);
		
		JLabel lbl_Pw = new JLabel("P W");
		lbl_Pw.setBounds(49, 86, 57, 15);
		panel.add(lbl_Pw);
		lbl_Pw.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_Pw.setForeground(new Color(233, 113, 113));
		lbl_Pw.setHorizontalAlignment(SwingConstants.CENTER);
		
		pw_1 = new JPasswordField();
		pw_1.setBounds(136, 83, 260, 21);
		panel.add(pw_1);
		
		JLabel lbl_Phone = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		lbl_Phone.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_Phone.setBounds(52, 263, 83, 15);
		lbl_Phone.setForeground(new Color(233, 113, 113));
		panel.add(lbl_Phone);
		lbl_Phone.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(250, 236, 197));
		comboBox.setBounds(136, 257, 60, 21);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"010", "011"}));
		
		tf_Phone = new JTextField();
		tf_Phone.setBounds(208, 257, 188, 21);
		panel.add(tf_Phone);
		tf_Phone.setColumns(10);
		
		JRadioButton rb_No = new JRadioButton("\uD574\uB2F9\uC5C6\uC74C");
		rb_No.setForeground(Color.DARK_GRAY);
		rb_No.setBackground(new Color(250, 236, 197));
		rb_No.setFont(new Font("굴림", Font.BOLD, 15));
		rb_No.setBounds(136, 305, 90, 23);
		panel.add(rb_No);
		buttonGroup.add(rb_No);
		
		JRadioButton rb_disabled = new JRadioButton("\uC7A5\uC560\uC778, \uAE30\uCD08\uC218\uAE09\uC790");
		rb_disabled.setForeground(Color.DARK_GRAY);
		rb_disabled.setBackground(new Color(250, 236, 197));
		rb_disabled.setFont(new Font("굴림", Font.BOLD, 15));
		rb_disabled.setBounds(232, 305, 164, 23);
		panel.add(rb_disabled);
		buttonGroup.add(rb_disabled);
		
		JLabel lbl_Sale = new JLabel("\uD560\uC778\uC0AC\uD56D");
		lbl_Sale.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_Sale.setForeground(new Color(233, 113, 113));
		lbl_Sale.setBounds(49, 309, 71, 15);
		
		panel.add(lbl_Sale);
		lbl_Sale.setHorizontalAlignment(SwingConstants.CENTER);
		
		String a = this.getClass().getResource("../img/flower.png").getPath();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(a));
		lblNewLabel.setBounds(30, 37, 16, 21);
		panel.add(lblNewLabel);
		
		JLabel lbl_Id = new JLabel("I D");
		lbl_Id.setBounds(49, 37, 57, 15);
		panel.add(lbl_Id);
		lbl_Id.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_Id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Id.setForeground(new Color(233, 113, 113));
		
		tf_Id = new JTextField();
		tf_Id.setBounds(136, 37, 261, 21);
		panel.add(tf_Id);
		tf_Id.setColumns(10);
		
		String b = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(b));
		label.setBounds(30, 83, 16, 21);
		panel.add(label);
		
		String c = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(c));
		label_1.setBounds(30, 167, 16, 21);
		panel.add(label_1);
		
		String d = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(d));
		label_2.setBounds(30, 125, 16, 21);
		panel.add(label_2);
		
		String e = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(e));
		label_3.setBounds(30, 210, 16, 21);
		panel.add(label_3);
		
		String f = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(f));
		label_4.setBounds(30, 260, 16, 21);
		panel.add(label_4);
		
		String g = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(g));
		label_5.setBounds(30, 305, 16, 21);
		panel.add(label_5);
		
		JLabel lbl_Member = new JLabel("\uD68C \uC6D0 \uAC00 \uC785");
		lbl_Member.setBounds(186, 21, 164, 35);
		frame.getContentPane().add(lbl_Member);
		lbl_Member.setFont(new Font("굴림", Font.BOLD, 30));
		lbl_Member.setForeground(new Color(240, 150, 97));
		lbl_Member.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bnt_Ok = new JButton("\uAC00\uC785\uC644\uB8CC");
		bnt_Ok.setBounds(74, 505, 164, 31);
		frame.getContentPane().add(bnt_Ok);
		bnt_Ok.setFont(new Font("굴림", Font.BOLD, 15));
		bnt_Ok.setForeground(Color.white);
		bnt_Ok.setBackground(new Color(240, 150, 97));
		
		JButton bnt_refuse = new JButton("\uAC00\uC785\uCDE8\uC18C");
		bnt_refuse.setBounds(262, 505, 164, 31);
		frame.getContentPane().add(bnt_refuse);
		bnt_refuse.setFont(new Font("굴림", Font.BOLD, 15));
		bnt_refuse.setForeground(Color.white);
		bnt_refuse.setBackground(new Color(250, 236, 197));
		bnt_refuse.setBackground(new Color(240, 150, 97));
		
		String h = this.getClass().getResource("../img/horse.png").getPath();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(h));
		lblNewLabel_1.setBounds(105, 21, 57, 36);
		frame.getContentPane().add(lblNewLabel_1);
		bnt_refuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "가입을 취소합니다", "회원가입", JOptionPane.ERROR_MESSAGE);
				frame.dispose(); // 창 닫기
				LoginGUI login = new LoginGUI(dto); // 메인 창 띄우기 객체 생성
			}
		});
		bnt_Ok.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
					if(tf_Id.getText().trim().length()==0 || tf_Id.getText().trim().equals("아이디")) {
						JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
						tf_Id.grabFocus();
						return;
					}
					if(pw_1.getText().trim().length()==0) {
						JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.", "비밀번호 입력", JOptionPane.WARNING_MESSAGE);
						pw_1.grabFocus();
						return;
					}
					if(pw_2.getText().trim().length()==0) {
						JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력해 주세요.", "비밀번호 확인 입력", JOptionPane.WARNING_MESSAGE);
						pw_2.grabFocus();
						return;
					}
					if(!(pw_1.getText().trim().equals(pw_2.getText().trim()))) {
						JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다.!!", "비밀번호 확인", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(tf_Address.getText().trim().length()==0 || tf_Address.getText().trim().equals("주소")) {
						JOptionPane.showMessageDialog(null, "주소를 입력해 주세요.", "주소 입력", JOptionPane.WARNING_MESSAGE);
						tf_Address.grabFocus();
						return;
					}
					
					if(tf_Phone.getText().trim().length()==0 || tf_Phone.getText().trim().equals("핸드폰 번호")) {
						JOptionPane.showMessageDialog(null, "핸드폰 번호를 입력해 주세요.", "핸드폰 번호 입력", JOptionPane.WARNING_MESSAGE);
						tf_Phone.grabFocus();
						return;
					}
					if(tf_Name.getText().trim().length()==0 || tf_Name.getText().trim().equals("이름")) {
						JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
						tf_Name.grabFocus();
						return;
					}else {
						JOptionPane.showMessageDialog(null, "가입을 축하드립니다", "회원가입", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose(); // 창 닫기
						LoginGUI login = new LoginGUI(dto); // 메인 창 띄우기 객체 생성
					}
					
					
					String id = tf_Id.getText();
					String pw = pw_1.getText();
					
					String name = tf_Name.getText();
					String address = tf_Address.getText();
					String phonenumber = tf_Phone.getText();
				
					
				
					if(rb_No.isSelected()) {
						saletarget = 1;// 할인 해당없음
					}else if(rb_disabled.isSelected()) {
						saletarget = 2;// 장애인, 기초수급자
					}
					
					
					MemberDTO dto = new MemberDTO(id,pw, name, address, phonenumber, saletarget);
					MemberDAO dao = new MemberDAO();
					dao.joinInsert(dto);
			}		
			});
		
		
	}
		}