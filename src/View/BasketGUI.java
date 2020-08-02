package View;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.MemberDTO;
import Model.ToyDAO;
import Model.ToyDTO;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BasketGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BasketGUI window = new BasketGUI(dto);
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
	public BasketGUI(ArrayList<ToyDTO> basketList, MemberDTO dto) {
		initialize(basketList, dto);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<ToyDTO> basketList, MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uAD00\uC2EC \uC7A5\uB09C\uAC10");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(362, 34, 197, 36);
		lblNewLabel.setForeground(new Color(240, 150, 97));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"\uB300\uC5EC\uD558\uC2E4 \uC7A5\uB09C\uAC10\uC744 \uC120\uD0DD\uD558\uC138\uC694");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(233, 113, 113));
		lblNewLabel_1.setBounds(43, 80, 217, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 113, 860, 353);
		scrollPane.getViewport().setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(scrollPane);

		String[] colBasket = { "장난감 번호", "장난감 이름", "영역", "발달 정보", "사용 연령" };
		ToyDAO dao = new ToyDAO();
//		ArrayList<ToyDTO> basketList = new ArrayList<ToyDTO>();
//		basketList.add(dto);
		System.out.println("바스켓 리스트 사이즈 ㅣ " + basketList.size());
		Object[][] data = new Object[basketList.size()][5];

		for (int i = 0; i < data.length; i++) {
			System.out.println("장바구니 담긴 장난감 번호 : " + basketList.get(i).getNo());
			System.out.println(basketList.get(i).getName());
			data[i][0] = basketList.get(i).getNo();
			data[i][1] = basketList.get(i).getName();
			data[i][2] = basketList.get(i).getDomain();
			data[i][3] = basketList.get(i).getDevelop();
			data[i][4] = basketList.get(i).getAge();

//			Icon addIcon = new ImageIcon(basketList.get(i).getImg());
//			data[i][1] = addIcon;

			// lblNewLabel_2.setIcon(new ImageIcon(getNum().get(0).getImg()));
		}

		table = new JTable(data, colBasket);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("\uB300 \uC5EC \uD558 \uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("결제창에서 페이창으로 넘기기 " + dto.getId());
				PayGUI pay = new PayGUI(dto);
			}
		});
		btnNewButton.setBounds(139, 492, 241, 36);
		btnNewButton.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uB4A4 \uB85C \uAC00 \uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ToyInfoGUI toyList = new ToyInfoGUI(dto);
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(519, 492, 226, 36);
		btnNewButton_1.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(btnNewButton_1);

		String a = this.getClass().getResource("../img/toycar.png").getPath();
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(a));
		lblNewLabel_2.setBounds(309, 21, 70, 49);
		frame.getContentPane().add(lblNewLabel_2);

		String b = this.getClass().getResource("../img/check2.png").getPath();
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(b));
		lblNewLabel_3.setBounds(16, 80, 23, 23);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
