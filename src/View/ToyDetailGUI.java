package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

import Model.MemberDTO;
import Model.ToyDAO;
import Model.ToyDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class ToyDetailGUI {

	private JFrame frame;
	private int num;
	ToyDAO dao;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ToyDetailGUI window = new ToyDetailGUI();
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
	public ToyDetailGUI(int num, MemberDTO dto) {
		this.num = num;
		initialize(num, dto);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public ArrayList<ToyDTO> getNum() {
		ToyDAO dao = new ToyDAO();
		ArrayList<ToyDTO> dto = dao.detailInfo(num);
		return dto;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int num, MemberDTO dto) {
		System.out.println("ÅäÀÌ µðÅ×ÀÏÃ¢ ID : " + dto.getId());
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_sector = new JLabel("\uC601\uC5ED");
		lbl_sector.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lbl_sector.setForeground(new Color(240, 97, 97));
		lbl_sector.setBounds(505, 202, 57, 15);
		frame.getContentPane().add(lbl_sector);

		JLabel lbl_info = new JLabel("\uBC1C\uB2EC\uC815\uBCF4\r\n");
		lbl_info.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lbl_info.setForeground(new Color(240, 97, 97));
		lbl_info.setBounds(505, 267, 76, 15);
		frame.getContentPane().add(lbl_info);

		JLabel lbl_age = new JLabel("\uC5F0\uB839");
		lbl_age.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lbl_age.setForeground(new Color(240, 97, 97));
		lbl_age.setBounds(505, 335, 57, 19);
		frame.getContentPane().add(lbl_age);

		JLabel lbl_rent = new JLabel("\uB300\uC5EC\uAD6C\uBD84");
		lbl_rent.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lbl_rent.setForeground(new Color(240, 97, 97));
		lbl_rent.setBounds(505, 405, 76, 15);
		frame.getContentPane().add(lbl_rent);

		JLabel lblNewLabel_1 = new JLabel("\uC7A5\uB09C\uAC10 \uC0C1\uC138\uC815\uBCF4\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lblNewLabel_1.setBounds(338, 21, 256, 53);
		lblNewLabel_1.setForeground(new Color(240, 150, 97));
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ToyInfoGUI toyInfoGUI = new ToyInfoGUI(dto);
			}
		});
		btnNewButton.setBounds(366, 496, 174, 40);
		btnNewButton.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(btnNewButton);

		// String domain = getNum().get(0).getDomain();
		JLabel lb_domain = new JLabel(getNum().get(0).getDomain());
		lb_domain.setForeground(new Color(233, 113, 113));
		lb_domain.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lb_domain.setBounds(616, 201, 256, 19);
		frame.getContentPane().add(lb_domain);

		JLabel lb_develop = new JLabel(getNum().get(0).getDevelop());
		lb_develop.setForeground(new Color(233, 113, 113));
		lb_develop.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lb_develop.setBounds(616, 266, 256, 19);
		frame.getContentPane().add(lb_develop);

		JLabel lb_age = new JLabel(getNum().get(0).getAge());
		lb_age.setForeground(new Color(233, 113, 113));
		lb_age.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lb_age.setBounds(616, 335, 256, 19);
		frame.getContentPane().add(lb_age);

		int rent = getNum().get(0).getRent();
		String rent1;
		if (rent == 0) {
			rent1 = "´ë¿© °¡´É";
		} else {
			rent1 = "´ë¿© Áß";
		}
		JLabel lb_rent = new JLabel(rent1);
		lb_rent.setForeground(new Color(233, 113, 113));
		lb_rent.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lb_rent.setBounds(616, 404, 256, 19);

		frame.getContentPane().add(lb_rent);

		JLabel lbl_name = new JLabel("\uC774\uB984");
		lbl_name.setBackground(new Color(0, 204, 102));
		lbl_name.setForeground(new Color(233, 113, 113));
		lbl_name.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lbl_name.setBounds(505, 123, 57, 15);

		frame.getContentPane().add(lbl_name);

		JLabel lb_name = new JLabel(getNum().get(0).getName());
		lb_name.setForeground(new Color(233, 113, 113));
		lb_name.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lb_name.setBounds(616, 124, 256, 15);
		frame.getContentPane().add(lb_name);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(getNum().get(0).getImg()));
		lblNewLabel_2.setBounds(58, 109, 339, 357);
		frame.getContentPane().add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 236, 197));
		panel.setBounds(37, 94, 815, 386);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(379, 12, 0, 0);
		panel.add(lblNewLabel);
		
		String b = this.getClass().getResource("../img/flower.png").getPath();
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(b));
		lblNewLabel_3.setBounds(438, 22, 22, 29);
		panel.add(lblNewLabel_3);
		
		String c = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(c));
		label.setBounds(438, 101, 22, 29);
		panel.add(label);
		
		String d = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(d));
		label_1.setBounds(438, 164, 22, 29);
		panel.add(label_1);
		
		String e = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(e));
		label_2.setBounds(438, 233, 22, 29);
		panel.add(label_2);
		
		String f = this.getClass().getResource("../img/flower.png").getPath();
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(f));
		label_3.setBounds(438, 303, 22, 29);
		panel.add(label_3);

		String a = this.getClass().getResource("../img/cube.png").getPath();
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(a));
		lblNewLabel_4.setBounds(319, 27, 57, 47);
		frame.getContentPane().add(lblNewLabel_4);

	}
}
