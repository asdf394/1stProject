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
import javax.swing.ImageIcon;

public class ToyInfoGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	int num;
	ArrayList<ToyDTO> basketList = new ArrayList<ToyDTO>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ToyInfoGUI window = new ToyInfoGUI();
//					// window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ToyInfoGUI(MemberDTO memDTO) {
		initialize(memDTO);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO memDTO) {
		System.out.println("토이 인포창 ID : " + memDTO.getId());
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("TOY INFORMATION");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(358, 31, 238, 39);
		lblNewLabel.setForeground(new Color(240, 150, 97));
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(18, 143, 840, 319);
		scrollPane.getViewport().setBackground(new Color(250, 236, 197));
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
			int rent = toyList.get(i).getRent();
			if (rent == 0) {
				data[i][5] = "대여 가능";
			} else {
				data[i][5] = "대여중";
			}

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

					System.out.println("0번째 값 : " + ToyDTOAL.get(0));

					int cnt = dao.addBasket(dto, memDTO); // 대여 테이블 저장
					if (cnt != 0) {
						System.out.println("장바구니 담기 완료");
					} else {
						System.out.println("장바구니 실패");
					}

					// System.out.println(ToyDTOAL.toString());

					for (int i = 0; i < basketList.size(); i++) {
						System.out.println("바스켓 숫자 출력" + basketList.get(i));
					}
				} else if (e.getClickCount() == 1) {
					int row = table.getSelectedRow();
					num = (int) table.getValueAt(row, 0);
				}

			}

		});

		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI(null);
			}
		});
		btnNewButton.setBounds(571, 492, 225, 39);
		btnNewButton.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC7A5\uB09C\uAC10 \uC815\uBCF4 \uB354\uBCF4\uAE30\r\n");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.out.println("토이창에서 상세페이지로 넘기기 " + memDTO.getId());
				ToyDetailGUI toydetailGUI = new ToyDetailGUI(num, memDTO);
			}
		});
		btnNewButton_1.setBounds(57, 492, 225, 39);
		btnNewButton_1.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uC7A5\uBC14\uAD6C\uB2C8 & \uACB0\uC81C\r\n");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.out.println("토이인포창 바스켓 리스트 : " + basketList.size());
				System.out.println("토이창에서 장바구니로 넘기기 " + memDTO.getId());
				BasketGUI basket = new BasketGUI(basketList, memDTO);
			}
		});
		btnNewButton_2.setBounds(318, 492, 225, 39);
		btnNewButton_2.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("\uC7A5\uB09C\uAC10\uAC80\uC0C9 :");

		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(240, 150, 97));

		lblNewLabel_1.setBounds(18, 92, 133, 39);
		lblNewLabel_1.setBackground(new Color(242, 203, 97));

		frame.getContentPane().add(lblNewLabel_1);

		JButton bt_search = new JButton("\uAC80\uC0C9\r\n");
		bt_search.setFont(new Font("굴림", Font.BOLD, 15));
		bt_search.setForeground(Color.WHITE);
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

		bt_search.setBounds(745, 90, 113, 43);
		bt_search.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(bt_search);

		textField = new JTextField();
		textField.setBounds(114, 92, 619, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		String a = this.getClass().getResource("../img/bear.png").getPath();
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(a));
		lblNewLabel_2.setBounds(304, 21, 57, 61);
		frame.getContentPane().add(lblNewLabel_2);
	}
}