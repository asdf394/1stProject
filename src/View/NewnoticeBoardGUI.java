package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.NoticeBoardDAO;
import Model.NoticeBoardDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class NewnoticeBoardGUI {

	private JFrame frame;
	private JTextField tf_title;
	private JTextField tf_content;
	private JTextField tf_name;
	private JTextField tf_ID;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewnoticeBoardGUI window = new NewnoticeBoardGUI();
////					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public NewnoticeBoardGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 519, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton bnt_new = new JButton("\uB4F1\uB85D");
		bnt_new.setForeground(Color.WHITE);
		bnt_new.setFont(new Font("����", Font.BOLD, 15));
		bnt_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_name.getText().trim().length()==0 || tf_name.getText().trim().equals("�̸�")) {
					JOptionPane.showMessageDialog(null, "�̸��� �Է��� �ּ���.", "�̸� �Է�", JOptionPane.WARNING_MESSAGE);
					tf_name.grabFocus();
					return;
				}
				if(tf_ID.getText().trim().length()==0 || tf_ID.getText().trim().equals("���̵�")) {
					JOptionPane.showMessageDialog(null, "ID�� �Է��� �ּ���.", "���̵� �Է�", JOptionPane.WARNING_MESSAGE);
					tf_ID.grabFocus();
					return;
				}
				if(tf_content.getText().trim().length()==0 || tf_content.getText().trim().equals("����")) {
					JOptionPane.showMessageDialog(null, "������ �Է��� �ּ���.", "���� �Է�", JOptionPane.WARNING_MESSAGE);
					tf_content.grabFocus();
					return;
				}
				if(tf_title.getText().trim().length()==0 || tf_title.getText().trim().equals("����")) {
					JOptionPane.showMessageDialog(null, "������ �Է��� �ּ���.", "���� �Է�", JOptionPane.WARNING_MESSAGE);
					tf_title.grabFocus();
					return;
				
				}else {
					JOptionPane.showMessageDialog(null, "����� �Ϸ�Ǿ����ϴ�", "�Խù� ���", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose(); // â �ݱ�
					noticeBoardGUI borad = new noticeBoardGUI(); // ���� â ���� ��ü ����
				}
				
				
				String name = tf_name.getText();
				String id = tf_ID.getText();
				String content = tf_content.getText();
				String title = tf_title.getText();
	
				NoticeBoardDTO dto = new NoticeBoardDTO(name, id, content, title);
				NoticeBoardDAO dao = new NoticeBoardDAO();
				dao.joinInsert(dto);
				
				
			}
		});
		bnt_new.setBounds(105, 505, 124, 35);
		bnt_new.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(bnt_new);
		
		JButton bnt_close = new JButton("\uCDE8\uC18C");
		bnt_close.setFont(new Font("����", Font.BOLD, 15));
		bnt_close.setForeground(Color.WHITE);
		bnt_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "����� ����մϴ�", "�Խñ� ���", JOptionPane.ERROR_MESSAGE);
				frame.dispose();
				noticeBoardGUI NoticeBoradGUI = new noticeBoardGUI();
			}
		});
		bnt_close.setBounds(267, 505, 124, 35);
		bnt_close.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(bnt_close);
		
		JLabel lbl_Bigname = new JLabel("\uAE00\uC4F0\uAE30");
		lbl_Bigname.setFont(new Font("����", Font.BOLD, 30));
		lbl_Bigname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Bigname.setBounds(205, 25, 111, 46);
		lbl_Bigname.setForeground(new Color(240, 150, 97));
		frame.getContentPane().add(lbl_Bigname);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 81, 479, 414);
		panel.setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		tf_content = new JTextField();
		tf_content.setBounds(103, 150, 357, 229);
		panel.add(tf_content);
		tf_content.setColumns(10);
		
		JLabel lb_content = new JLabel("\uB0B4\uC6A9");
		lb_content.setFont(new Font("����", Font.BOLD, 15));
		lb_content.setBounds(49, 239, 48, 15);
		
		panel.add(lb_content);
		lb_content.setHorizontalAlignment(SwingConstants.CENTER);
		lb_content.setForeground(new Color(233, 113, 113));
		JLabel lbl_title = new JLabel("\uC81C\uBAA9");
		lbl_title.setFont(new Font("����", Font.BOLD, 15));
		lbl_title.setBounds(49, 123, 42, 15);
		
		panel.add(lbl_title);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setForeground(new Color(233, 113, 113));
		tf_title = new JTextField();
		tf_title.setBounds(103, 113, 357, 27);
		panel.add(tf_title);
		tf_title.setColumns(10);
		
		tf_ID = new JTextField();
		tf_ID.setBounds(103, 75, 180, 28);
		panel.add(tf_ID);
		tf_ID.setColumns(10);
		
		JLabel lbl_ID = new JLabel("I D");
		lbl_ID.setFont(new Font("����", Font.BOLD, 15));
		lbl_ID.setBounds(49, 79, 31, 15);
		lbl_ID.setForeground(new Color(233, 113, 113));
		panel.add(lbl_ID);
		lbl_ID.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_name = new JLabel("\uC774\uB984");
		lbl_name.setFont(new Font("����", Font.BOLD, 15));
		lbl_name.setBounds(49, 40, 42, 15);
		lbl_name.setForeground(new Color(233, 113, 113));
		panel.add(lbl_name);
		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
		
		tf_name = new JTextField();
		tf_name.setBounds(103, 36, 180, 27);
		panel.add(tf_name);
		tf_name.setColumns(10);
		
		String b = this.getClass().getResource("../img/tomato.png").getPath();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(b));
		lblNewLabel_1.setBounds(21, 34, 16, 21);
		panel.add(lblNewLabel_1);
		
		String c = this.getClass().getResource("../img/tomato.png").getPath();
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(c));
		label.setBounds(21, 75, 16, 21);
		panel.add(label);
		
		String d = this.getClass().getResource("../img/tomato.png").getPath();
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(d));
		label_1.setBounds(21, 117, 16, 21);
		panel.add(label_1);
		
		String e = this.getClass().getResource("../img/tomato.png").getPath();
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(e));
		label_2.setBounds(21, 239, 16, 21);
		panel.add(label_2);
		
		String a = this.getClass().getResource("../img/write.png").getPath();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(a));
		lblNewLabel.setBounds(144, 10, 64, 64);
		frame.getContentPane().add(lblNewLabel);
	}
}
