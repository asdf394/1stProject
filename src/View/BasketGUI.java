package View;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.ToyDAO;
import Model.ToyDTO;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

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
	public BasketGUI(ArrayList<ToyDTO> basketList) {
		initialize(basketList);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<ToyDTO> basketList) {
		frame = new JFrame();
		frame.setBounds(100, 100, 970, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uAD00\uC2EC \uC7A5\uB09C\uAC10");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel.setBounds(12, 11, 99, 36);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uB300\uC5EC\uD558\uC2E4 \uC7A5\uB09C\uAC10\uC744 \uACE0\uB974\uC138\uC694");
		lblNewLabel_1.setBounds(12, 57, 172, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 90, 930, 257);
		frame.getContentPane().add(scrollPane);

		String[] colBasket = { "장난감 번호", "장난감 이름", "영역", "발달 정보", "사용 연령" };
		ToyDAO dao = new ToyDAO();
//		ArrayList<ToyDTO> basketList = new ArrayList<ToyDTO>();
//		basketList.add(dto);
		Object[][] data = new Object[basketList.size()][5];

		for (int i = 0; i < data.length; i++) {
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(33, 369, 241, 59);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(323, 369, 226, 59);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("New button");
		button.setBounds(593, 369, 226, 59);
		frame.getContentPane().add(button);
	}
}
