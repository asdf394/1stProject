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
import javax.swing.table.DefaultTableModel;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.ToyDAO;
import Model.ToyDTO;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 901, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(240, 150, 97));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(195, 33, 146, 34);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 86, 429, 396);
		scrollPane.getViewport().setBackground(new Color(250, 236, 197));
		
		frame.getContentPane().add(scrollPane);

		String[] colName = { "���̵�", "��й�ȣ", "�̸�", "ȸ���ּ�", "����ó", "���ο���" };
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

		JButton btnNewButton = new JButton("\uB2EB \uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("����", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI(null);
			}
		});
		btnNewButton.setBounds(5, 492, 429, 41);
		btnNewButton.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(btnNewButton);
		
		String a = this.getClass().getResource("../img/member.png").getPath();
		JLabel lblNewLabel_1 = new JLabel("");
		
		lblNewLabel_1.setIcon(new ImageIcon(a));
		lblNewLabel_1.setBounds(126, 10, 72, 66);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(445, 99, 840, 319);
		scrollPane.getViewport().setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(scrollPane_1);

		  String[] colName1 = { "��ȣ", "�̸�", "����", "�ߴ�����", "��뿬��", "�뿩����" };
		
	 
	      
	      DefaultTableModel model = new DefaultTableModel(null, colName1) {// ��Ŭ���� �⺻�� �� ���� ���°� �Ǵ� ���� ��������
				public boolean isCellEditable(int row, int col) {// DefaultTableModeld�� isCellEditable�� �������� (false��)
					return false;
				}
			};

			table = new JTable(model);
			scrollPane.setViewportView(table);
		
	}
	
}
