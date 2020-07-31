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

import Model.ToyDAO;
import Model.ToyDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
	public ToyDetailGUI(int num) {
		this.num = num;
		initialize();
		frame.setVisible(true);
	}

	
	
	public ArrayList<ToyDTO> getNum() {
		ToyDAO dao = new ToyDAO();
		ArrayList<ToyDTO> dto =dao.detailInfo(num);
		return dto;
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 821, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC601\uC5ED");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lblNewLabel.setBounds(366, 179, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uBC1C\uB2EC\uC815\uBCF4\r\n");
		label.setFont(new Font("±¼¸²", Font.BOLD, 16));
		label.setBounds(366, 258, 76, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC5F0\uB839");
		label_1.setFont(new Font("±¼¸²", Font.BOLD, 16));
		label_1.setBounds(366, 312, 57, 19);
		frame.getContentPane().add(label_1);
		
		JLabel label_3 = new JLabel("\uB300\uC5EC\uAD6C\uBD84");
		label_3.setFont(new Font("±¼¸²", Font.BOLD, 16));
		label_3.setBounds(366, 382, 76, 15);
		frame.getContentPane().add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("\uC7A5\uB09C\uAC10 \uC0C1\uC138\uC815\uBCF4\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 28));
		lblNewLabel_1.setBounds(64, 10, 644, 53);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\uC774\uC804\uD654\uBA74");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ToyInfoGUI toyInfoGUI =new ToyInfoGUI();
			}
		});
		btnNewButton.setBounds(696, 433, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		//String domain = getNum().get(0).getDomain();
		JLabel lb_domain = new JLabel(getNum().get(0).getDomain());
		lb_domain.setBounds(477, 178, 256, 19);
		frame.getContentPane().add(lb_domain);
		
		JLabel lb_develop = new JLabel(getNum().get(0).getDevelop());
		lb_develop.setBounds(477, 257, 256, 19);
		frame.getContentPane().add(lb_develop);
		
		JLabel lb_age = new JLabel(getNum().get(0).getAge());
		lb_age.setBounds(477, 312, 256, 19);
		frame.getContentPane().add(lb_age);
		
		String rent = Integer.toString(getNum().get(0).getRent());
		JLabel lb_rent = new JLabel(rent);
		lb_rent.setBounds(477, 381, 256, 19);
		frame.getContentPane().add(lb_rent);
		
		JLabel lblNewLabel_3 = new JLabel("\uC774\uB984");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lblNewLabel_3.setBounds(366, 100, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lb_name = new JLabel(getNum().get(0).getName());
		lb_name.setBounds(477, 101, 256, 15);
		frame.getContentPane().add(lb_name);
		
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(getNum().get(0).getImg()));
		lblNewLabel_2.setBounds(12, 66, 327, 369);
		frame.getContentPane().add(lblNewLabel_2);
		
		
	}
}
