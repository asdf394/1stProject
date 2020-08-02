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
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 520, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_Member = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		lbl_Member.setFont(new Font("±¼¸²", Font.BOLD, 30));
		lbl_Member.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Member.setBounds(146, 31, 259, 31);
		lbl_Member.setForeground(new Color(240, 150, 97));
		frame.getContentPane().add(lbl_Member);
		

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 236, 197));
		panel.setBounds(12, 92, 480, 385);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rb_disabled = new JRadioButton("\uC7A5\uC560\uC778, \uAE30\uCD08\uC218\uAE09\uC790");
		rb_disabled.setBounds(271, 319, 136, 23);
		rb_disabled.setBackground(new Color(250, 236, 197));
		panel.add(rb_disabled);
		buttonGroup.add(rb_disabled);
		
		JButton bnt_Ok = new JButton("\uC218\uC815\uC644\uB8CC");
		bnt_Ok.setForeground(Color.WHITE);
		bnt_Ok.setFont(new Font("±¼¸²", Font.BOLD, 15));
		bnt_Ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				MemberDAO dao = new MemberDAO();
				String pw = pw_1.getText();
				String name = tf_Name.getText();
				String address = tf_Address.getText();
				String phonenumber = tf_Phone.getText();
				System.out.println(dto.getId());
				String id = dto.getId();
				int saletarget = dto.getSaletarget();
				// System.out.println(pw,name,id,saletarget);

				int cnt = dao.updatemember(pw, name, address, phonenumber, saletarget, id);
				if (cnt == 0) {
					JOptionPane.showMessageDialog(null, id + pw + "´Ù½ÃÀÔ·ÂÇØÁÖ¼¼¿ä", "·Î±×ÀÎ", JOptionPane.ERROR_MESSAGE);

				} else {
					frame.dispose();
					JOptionPane.showMessageDialog(null, "È¸¿ø¼öÁ¤¿Ï·á");
					if (rb_disabled.isSelected()) {
						saletarget = 1;
					}

					MainGUI mainGui = new MainGUI(dto);
				}
			}
		});
		bnt_Ok.setBounds(80, 497, 96, 31);
		frame.getContentPane().add(bnt_Ok);
		bnt_Ok.setBackground(new Color(240, 150, 97));

		JButton bnt_refuse = new JButton("\uC218\uC815\uCDE8\uC18C");
		bnt_refuse.setForeground(Color.WHITE);
		bnt_refuse.setFont(new Font("±¼¸²", Font.BOLD, 15));
		bnt_refuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "¼öÁ¤À» Ãë¼ÒÇÕ´Ï´Ù", "È¸¿ø°¡ÀÔ", JOptionPane.ERROR_MESSAGE);
				frame.dispose(); // Ã¢ ´Ý±â
			}
		});
		bnt_refuse.setBounds(206, 497, 96, 31);
		bnt_refuse.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(bnt_refuse);

		JButton button = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("±¼¸²", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				deleteGUI delete = new deleteGUI(dto);
			}
		});
		button.setBounds(327, 497, 96, 31);
		button.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(button);

		JLabel lbl_Pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_Pw.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Pw.setBounds(72, 42, 87, 15);
		lbl_Pw.setForeground(new Color(233, 113, 113));

		panel.add(lbl_Pw);
		lbl_Pw.setHorizontalAlignment(SwingConstants.CENTER);

		pw_1 = new JPasswordField();
		pw_1.setBounds(166, 34, 241, 21);
		panel.add(pw_1);

		JLabel lbl_RePw = new JLabel("\uC7AC\uC785\uB825");
		lbl_RePw.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_RePw.setBounds(84, 99, 63, 15);
		lbl_RePw.setForeground(new Color(233, 113, 113));
		panel.add(lbl_RePw);
		lbl_RePw.setHorizontalAlignment(SwingConstants.CENTER);

		pw_2 = new JPasswordField();
		pw_2.setBounds(166, 96, 241, 21);
		panel.add(pw_2);

		JLabel lbl_Name = new JLabel("\uC774 \uB984");
		lbl_Name.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Name.setBounds(87, 156, 57, 15);
		lbl_Name.setForeground(new Color(233, 113, 113));
		panel.add(lbl_Name);
		lbl_Name.setHorizontalAlignment(SwingConstants.CENTER);

		tf_Name = new JTextField();
		tf_Name.setBounds(166, 153, 241, 21);
		panel.add(tf_Name);
		tf_Name.setColumns(10);

		JLabel lbl_Address = new JLabel("\uC8FC\uC18C");
		lbl_Address.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Address.setBounds(84, 213, 63, 15);
		lbl_Address.setForeground(new Color(233, 113, 113));
		panel.add(lbl_Address);
		lbl_Address.setHorizontalAlignment(SwingConstants.CENTER);

		tf_Address = new JTextField();
		tf_Address.setBounds(166, 210, 241, 21);
		panel.add(tf_Address);
		tf_Address.setColumns(10);

		tf_Phone = new JTextField();
		tf_Phone.setBounds(256, 264, 151, 21);
		tf_Phone.setForeground(new Color(233, 113, 113));

		panel.add(tf_Phone);
		tf_Phone.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(166, 264, 78, 21);
		comboBox.setBackground(new Color(250, 236, 197));
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "010", "011" }));

		JLabel lbl_Phone = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
		lbl_Phone.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Phone.setForeground(new Color(233, 113, 113));
		lbl_Phone.setBounds(71, 270, 89, 15);
		panel.add(lbl_Phone);
		lbl_Phone.setHorizontalAlignment(SwingConstants.CENTER);



		JRadioButton rb_No = new JRadioButton("\uD574\uB2F9\uC5C6\uC74C");
		rb_No.setBounds(166, 319, 87, 23);
		rb_No.setBackground(new Color(250, 236, 197));

		panel.add(rb_No);
		buttonGroup.add(rb_No);

		JLabel lbl_Sale = new JLabel("\uD560\uC778\uC0AC\uD56D");
		lbl_Sale.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Sale.setBounds(72, 327, 87, 15);

		panel.add(lbl_Sale);
		lbl_Sale.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Sale.setForeground(new Color(233, 113, 113));

		String b = this.getClass().getResource("../img/leaf.png").getPath();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(b));
		lblNewLabel_1.setBounds(46, 34, 30, 31);
		panel.add(lblNewLabel_1);

		String c = this.getClass().getResource("../img/leaf.png").getPath();
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(c));
		label.setBounds(46, 83, 30, 31);
		panel.add(label);

		String d = this.getClass().getResource("../img/leaf.png").getPath();
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(d));
		label_1.setBounds(45, 140, 30, 31);
		panel.add(label_1);

		String e = this.getClass().getResource("../img/leaf.png").getPath();
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(e));
		label_2.setBounds(46, 197, 30, 31);
		panel.add(label_2);

		String f = this.getClass().getResource("../img/leaf.png").getPath();
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(f));
		label_3.setBounds(46, 254, 30, 31);
		panel.add(label_3);

		String g = this.getClass().getResource("../img/leaf.png").getPath();
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(g));
		label_4.setBounds(46, 311, 30, 31);
		panel.add(label_4);
		
		String a = this.getClass().getResource("../img/change.png").getPath();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(a));
		lblNewLabel.setBounds(116, 31, 48, 31);
		frame.getContentPane().add(lblNewLabel);

	}
}
