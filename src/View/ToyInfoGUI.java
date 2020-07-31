package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTable;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.ToyDAO;
import Model.ToyDTO;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ToyInfoGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	int num;
	ArrayList<ToyDTO> basketList = new ArrayList<ToyDTO>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToyInfoGUI window = new ToyInfoGUI();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ToyInfoGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 1085, 679);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC7A5\uB09C\uAC10 \uC815\uBCF4\r\n");
		lblNewLabel.setFont(new Font("돋움체", Font.BOLD, 27));
		lblNewLabel.setBounds(46, 10, 327, 39);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 214, 1029, 319);
		frame.getContentPane().add(scrollPane);

		String[] colName = { "번호", "이름", "영역", "발달정보", "사용연령", "대여여부" };
		ToyDAO dao = new ToyDAO();
		ArrayList<ToyDTO> toyList = dao.toyInfo();
		Object[][] data = new Object[toyList.size()][8];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = toyList.get(i).getNo();
			data[i][1] = toyList.get(i).getName();
			data[i][2] = toyList.get(i).getDomain();
			data[i][3] = toyList.get(i).getDevelop();
			data[i][4] = toyList.get(i).getAge();
			data[i][5] = toyList.get(i).getRent();

		}

		DefaultTableModel model = new DefaultTableModel(data, colName) {// 셀클릭시 기본은 셀 편집 상태가 되는 것을 막기위해
			public boolean isCellEditable(int row, int col) {// DefaultTableModeld의 isCellEditable를 재정의함 (false로)
				return false;
			}
		};

		table = new JTable(model);
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					ArrayList<ToyDTO> ToyDTOAL = new ArrayList<ToyDTO>();
					ToyDAO dao = new ToyDAO();
					int row = table.getSelectedRow();
					num = (int) table.getValueAt(row, 0);
					ToyDTOAL = dao.detailInfo(num);
					ToyDTO dto = ToyDTOAL.get(0);
					basketList.add(dto);

					// System.out.println(ToyDTOAL.toString());

					for (int i = 0; i < basketList.size(); i++) {
						System.out.println(basketList.get(i));
					}
				} else if (e.getClickCount() == 1) {
					int row = table.getSelectedRow();
					num = (int) table.getValueAt(row, 0);
				}

			}

		});

		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(42, 543, 97, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC7A5\uB09C\uAC10 \uC815\uBCF4 \uB354\uBCF4\uAE30\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ToyDetailGUI toydetailGUI = new ToyDetailGUI(num);
			}
		});
		btnNewButton_1.setBounds(822, 543, 225, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uC7A5\uBC14\uAD6C\uB2C8 & \uACB0\uC81C\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BasketGUI basket = new BasketGUI(basketList);
			}
		});
		btnNewButton_2.setBounds(188, 543, 148, 23);
		frame.getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("\uC7A5\uB09C\uAC10\uAC80\uC0C9 :");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(46, 59, 105, 39);
		frame.getContentPane().add(lblNewLabel_1);

		JButton bt_search = new JButton("\uAC80\uC0C9\r\n");
		bt_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] colName = { "번호", "이름", "영역", "발달정보", "사용연령", "대여여부" };
				ToyDAO dao = new ToyDAO();
				ArrayList<ToyDTO> change = dao.search(textField.getText());
				Object[][] data = new Object[change.size()][6];
				for (int i = 0; i < data.length; i++) {
					data[i][0] = change.get(i).getNo();
					data[i][1] = change.get(i).getName();
					data[i][2] = change.get(i).getDomain();
					data[i][3] = change.get(i).getDevelop();
					data[i][4] = change.get(i).getAge();
					data[i][5] = change.get(i).getRent();

					table = new JTable(data, colName);
					scrollPane.setViewportView(table);
				}
			}
		});

		bt_search.setBounds(877, 57, 113, 43);
		frame.getContentPane().add(bt_search);

		textField = new JTextField();
		textField.setBounds(151, 59, 697, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}