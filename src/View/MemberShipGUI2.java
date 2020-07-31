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
//					MemberShipGUI2 window = new MemberShipGUI2(dto);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1027, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_Member = new JLabel("\uD68C \uC6D0 \uAC00 \uC785");
		lbl_Member.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Member.setBounds(12, 20, 410, 31);
		frame.getContentPane().add(lbl_Member);
		
		JLabel lbl_Name = new JLabel("\uC774 \uB984");
		lbl_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Name.setBounds(12, 165, 57, 15);
		frame.getContentPane().add(lbl_Name);
		
		tf_Name = new JTextField();
		tf_Name.setBounds(81, 162, 96, 21);
		frame.getContentPane().add(tf_Name);
		tf_Name.setColumns(10);
		
		JLabel lbl_Id = new JLabel("Id");
		lbl_Id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Id.setBounds(12, 75, 57, 15);
		frame.getContentPane().add(lbl_Id);
		
		tf_Id = new JTextField();
		tf_Id.setBounds(81, 72, 116, 21);
		frame.getContentPane().add(tf_Id);
		tf_Id.setColumns(10);
		
		JLabel lbl_Pw = new JLabel("Password");
		lbl_Pw.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Pw.setBounds(12, 106, 63, 15);
		frame.getContentPane().add(lbl_Pw);
		
		JLabel lbl_RePw = new JLabel("\uC7AC\uC785\uB825");
		lbl_RePw.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_RePw.setBounds(12, 137, 63, 15);
		frame.getContentPane().add(lbl_RePw);
		
		JLabel lbl_Phone = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
		lbl_Phone.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Phone.setBounds(12, 268, 71, 15);
		frame.getContentPane().add(lbl_Phone);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"010", "011"}));
		comboBox.setBounds(81, 265, 86, 21);
		frame.getContentPane().add(comboBox);
		
		tf_Phone = new JTextField();
		tf_Phone.setColumns(10);
		tf_Phone.setBounds(179, 265, 161, 21);
		frame.getContentPane().add(tf_Phone);
		
		JLabel lbl_Address = new JLabel("\uC8FC\uC18C");
		lbl_Address.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Address.setBounds(12, 200, 63, 15);
		frame.getContentPane().add(lbl_Address);
		
		tf_Address = new JTextField();
		tf_Address.setColumns(10);
		tf_Address.setBounds(81, 196, 259, 21);
		frame.getContentPane().add(tf_Address);
		
		JRadioButton rb_No = new JRadioButton("\uD574\uB2F9\uC5C6\uC74C");
		buttonGroup.add(rb_No);
		rb_No.setBounds(76, 309, 80, 23);
		frame.getContentPane().add(rb_No);
		
		JRadioButton rb_disabled = new JRadioButton("\uC7A5\uC560\uC778, \uAE30\uCD08\uC218\uAE09\uC790");
		buttonGroup.add(rb_disabled);
		rb_disabled.setBounds(160, 309, 143, 23);
		frame.getContentPane().add(rb_disabled);
		
		JButton bnt_Ok = new JButton("\uAC00\uC785\uC644\uB8CC");
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
						MainGUI mainGui = new MainGUI(dto); // 메인 창 띄우기 객체 생성
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
		bnt_Ok.setBounds(12, 362, 185, 31);
		frame.getContentPane().add(bnt_Ok);
		
		JButton bnt_refuse = new JButton("\uAC00\uC785\uCDE8\uC18C");
		bnt_refuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "가입을 취소합니다", "회원가입", JOptionPane.ERROR_MESSAGE);
				frame.dispose(); // 창 닫기
				MainGUI mainGui = new MainGUI(dto); // 메인 창 띄우기 객체 생성
			}
		});
		bnt_refuse.setBounds(237, 362, 185, 31);
		frame.getContentPane().add(bnt_refuse);
		
		JLabel lbl_Sale = new JLabel("\uD560\uC778\uC0AC\uD56D");
		lbl_Sale.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Sale.setBounds(12, 313, 57, 15);
		frame.getContentPane().add(lbl_Sale);
		
		pw_1 = new JPasswordField();
		pw_1.setBounds(81, 103, 116, 21);
		frame.getContentPane().add(pw_1);
		
		pw_2 = new JPasswordField();
		pw_2.setBounds(81, 134, 116, 21);
		frame.getContentPane().add(pw_2);
		
		
	}
		}