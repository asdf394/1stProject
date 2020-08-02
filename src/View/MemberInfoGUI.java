package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JTable table_1;
	private Object toyNo;// ����� ���� 8�� 1��
	private int delRow;

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
		String[] colName = { "��ȣ", "�̸�", "����", "�ߴ�����", "��뿬��", "�뿩����" };

		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberList = dao.memberInfoSelect();
		Object[][] data = new Object[memberList.size()][7];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = memberList.get(i).getId();
			data[i][1] = memberList.get(i).getPw();
			data[i][2] = memberList.get(i).getName();
			data[i][3] = memberList.get(i).getAddress();
			data[i][4] = memberList.get(i).getPhoneNumber();
			if (memberList.get(i).getSaletarget() == 2) { // ���ʼ�����,�����
				data[i][5] = "50% ���δ����";
			} else {
				data[i][5] = "";
			}
		}

		DefaultTableModel model = new DefaultTableModel(data, colName) {// ��Ŭ���� �⺻�� �� ���� ���°� �Ǵ� ���� ��������
			public boolean isCellEditable(int row, int col) {// DefaultTableModeld�� isCellEditable�� �������� (false��)
				return false;
			}
		};
		table = new JTable(model);
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
		scrollPane_1.setBounds(445, 124, 428, 319);
		scrollPane.getViewport().setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		// ����� ���� 8�� 1��
		// ������ ȸ���� �峭�� ����Ʈ�� ��ȯ

		String[] colName1 = { "�峭����ȣ", "�峭���̸�" };
		DefaultTableModel model1 = new DefaultTableModel(colName1, 0);

		table_1 = new JTable(model1);
		table_1.setBounds(0, 10, 422, 148);
		scrollPane_1.setViewportView(table_1);

		table.addMouseListener(new MouseAdapter() {
			ArrayList<ToyDTO> memberList1 = new ArrayList<ToyDTO>();

			@Override

			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					// ���� Ŭ���� ���� ID��������

					int row = table.getSelectedRow();
					Object value = table.getValueAt(row, 0);
					System.out.println("������ ���� ID : " + value);

					memberList1 = dao.memRentToy(value);

					System.out.println("�뿩�峭�� ����" + memberList1.size());
					Object[][] data1 = new Object[memberList1.size()][2];
					if (data1.length > 0) {
						for (int i = 0; i < data1.length; i++) {
							data1[i][0] = memberList1.get(i).getNo();
							data1[i][1] = memberList1.get(i).getName();
							System.out.println("�峭�� �ѹ� : " + memberList1.get(i).getNo());
							model1.addRow(data1[i]);
						}
					} else {
						System.out.println("�뿩�� �峭���� ����");
					}

				}
			}

		});
		// ����� ���� 8�� 1��
		// ȸ���� ���� �峭�� ���������� �ش� �� �޾ƿ���

		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					// Ŭ���� ���� �峭�� �ѹ� ��������
					delRow = table_1.getSelectedRow();
					toyNo = table_1.getValueAt(delRow, 0);
					System.out.println("������ ���� �峭�� ��ȣ : " + toyNo);
				}
			}
		});

		JButton btnNewButton_1 = new JButton("\uBC18\uD658 \uC644\uB8CC");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToyDAO tDAO = new ToyDAO();
				int cnt1 = tDAO.returnToy(toyNo);
				if (cnt1 != 0) {
					System.out.println("���� ��ȯ��");
				} else {
					System.out.println("���� ��ȯ�ȵ�");
				}
				int cnt2 = tDAO.delToyRent(toyNo);
				if (cnt2 != 0) {
					System.out.println(toyNo + "�뿩���̺��� ����");
				} else {
					System.out.println(toyNo + "�뿩���̺��� ���� �ȵ�");
				}
				model1.removeRow(delRow);

			}
		});
		btnNewButton_1.setBounds(616, 459, 97, 23);
		frame.getContentPane().add(btnNewButton_1);

		/////////// ������� ����

	}
}