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
import javax.swing.JTextArea;

public class UpdateGUI {

	private JFrame frame;
	private JTextField tf_Name;
	private JTextField tf_Phone;
	private JTextField tf_Address;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField pw_1;
	private JPasswordField pw_2;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateGUI window = new UpdateGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public UpdateGUI(MemberDTO dto) {
		
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_Member = new JLabel("\uC815 \uBCF4 \uC218 \uC815");
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
		
		JButton bnt_Ok = new JButton("\uC218\uC815\uC644\uB8CC");
		bnt_Ok.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
					
					MemberDAO dao = new MemberDAO();
					String pw = pw_1.getText();
					String name = tf_Name.getText();
					String address = tf_Address.getText();
					String phonenumber = tf_Phone.getText();
					System.out.println(dto.getId());
					String id= dto.getId();
					int saletarget = dto.getSaletarget();
					//System.out.println(pw,name,id,saletarget);
				
				
					int cnt = dao.updatemember(pw, name, address, phonenumber, saletarget,id);
					if(cnt == 0) {
						JOptionPane.showMessageDialog(null, id+pw+"다시입력해주세요", "로그인", JOptionPane.ERROR_MESSAGE);
						
						
					}else {
						frame.dispose();
						JOptionPane.showMessageDialog(null,  "회원수정완료");
						if(rb_disabled.isSelected()) {
							saletarget = 1;
						}
					
						MainGUI mainGui = new MainGUI(dto);
					}
			}
		}
			);
		bnt_Ok.setBounds(12, 362, 96, 31);
		frame.getContentPane().add(bnt_Ok);
		
		JButton bnt_refuse = new JButton("\uC218\uC815\uCDE8\uC18C");
		bnt_refuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "수정을 취소합니다", "회원가입", JOptionPane.ERROR_MESSAGE);
				frame.dispose(); // 창 닫기
			}
		});
		bnt_refuse.setBounds(120, 362, 96, 31);
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
		
		JButton button = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		button.setBounds(240, 362, 96, 31);
		frame.getContentPane().add(button);
		
		
	}
		}
