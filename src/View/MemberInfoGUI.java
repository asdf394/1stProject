package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import Model.MemberDAO;
import Model.MemberDTO;

public class MemberInfoGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MemberInfo window = new MemberInfo();
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * } }); } /*
	 * 
	 * 
	 * 
	 * 
	 * /** Create the application.
	 */
	public MemberInfoGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 410, 34);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 54, 410, 347);
		frame.getContentPane().add(scrollPane);

		String[] colName = { "아이디", "비밀번호", "이름", "회원주소", "연락처", "할인여부" };
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberList = dao.memberInfoSelect();
		Object[][] data = new Object[memberList.size()][7];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = memberList.get(i).getId();
			data[i][1] = memberList.get(i).getPw();
			data[i][2] = memberList.get(i).getName();
			data[i][3] = memberList.get(i).getAddress();
			data[i][4] = memberList.get(i).getPhoneNumber();
			data[i][5] = memberList.get(i).getSaletarget();
		}

		table = new JTable(data, colName);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(12, 411, 410, 41);
		frame.getContentPane().add(btnNewButton);
	}
}
