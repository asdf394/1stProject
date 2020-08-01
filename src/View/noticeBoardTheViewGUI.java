package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Model.MemberDTO;
import Model.NoticeBoardDAO;
import Model.NoticeBoardDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class noticeBoardTheViewGUI {

	private JFrame frame;
	static int num;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					noticeBoardTheViewGUI window = new noticeBoardTheViewGUI(num);
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
	public noticeBoardTheViewGUI(int n, MemberDTO memDTO) {
		this.num = n;
		initialize(num, memDTO);
		frame.setVisible(true);
	}

	public ArrayList<NoticeBoardDTO> getNum() {
		NoticeBoardDAO dao = new NoticeBoardDAO();
		ArrayList<NoticeBoardDTO> dto = dao.detailInfo(num);
		return dto;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int num, MemberDTO memDTO) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 520, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_Id = new JLabel("I   D");
		lbl_Id.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Id.setBounds(87, 190, 37, 15);
		lbl_Id.setForeground(new Color(233, 113, 113));
		frame.getContentPane().add(lbl_Id);

		JLabel lbl_BigTitle = new JLabel("\uAC8C\uC2DC\uAE00");
		lbl_BigTitle.setFont(new Font("±¼¸²", Font.BOLD, 30));
		lbl_BigTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BigTitle.setBounds(179, 33, 159, 51);
		lbl_BigTitle.setForeground(new Color(240, 150, 97));
		frame.getContentPane().add(lbl_BigTitle);

		JButton btn_Befor = new JButton("\uB2EB\uAE30");
		btn_Befor.setForeground(Color.WHITE);
		btn_Befor.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btn_Befor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				noticeBoardGUI nba = new noticeBoardGUI(memDTO);
			}
		});
		btn_Befor.setBounds(263, 497, 117, 34);
		btn_Befor.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(btn_Befor);

		String no = null;
		String name = null;
		String id = null;
		String title = null;
		String content = null;
		if (getNum().size() != 0) {
			no = "" + getNum().get(0).getNo();
			name = getNum().get(0).getName();
			id = getNum().get(0).getID();
			title = getNum().get(0).getTITLE();
			content = getNum().get(0).getCONTENT();
		}
		JLabel lbl_Numberinfo = new JLabel(no);
		lbl_Numberinfo.setBackground(Color.WHITE);
		lbl_Numberinfo.setBounds(156, 113, 166, 23);
		frame.getContentPane().add(lbl_Numberinfo);

		JLabel lbl_Idinfo = new JLabel(id);
		lbl_Idinfo.setBounds(156, 186, 166, 23);
		frame.getContentPane().add(lbl_Idinfo);

		JLabel lbl_Titleinfo = new JLabel(title);
		lbl_Titleinfo.setBounds(156, 222, 166, 23);
		frame.getContentPane().add(lbl_Titleinfo);

		JLabel lbl_Infoinfo = new JLabel(content);
		lbl_Infoinfo.setBackground(Color.WHITE);
		lbl_Infoinfo.setBounds(87, 251, 335, 187);
		frame.getContentPane().add(lbl_Infoinfo);

		JButton btn_complete = new JButton("\uC218\uC815\uD558\uAE30");
		btn_complete.setForeground(Color.WHITE);
		btn_complete.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Ã¢ ´Ý±â
				noticeBoardCorrect mainGui = new noticeBoardCorrect(num, memDTO); // ¸ÞÀÎ Ã¢ ¶ç¿ì±â °´Ã¼ »ý¼º
			}
		});
		btn_complete.setBounds(96, 497, 117, 34);
		btn_complete.setBackground(new Color(240, 150, 97));
		frame.getContentPane().add(btn_complete);

		JPanel panel = new JPanel();
		panel.setBounds(24, 92, 450, 385);
		panel.setBackground(new Color(250, 236, 197));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbl_Name = new JLabel("\uC774 \uB984");
		lbl_Name.setBounds(63, 59, 36, 18);
		lbl_Name.setForeground(new Color(233, 113, 113));
		panel.add(lbl_Name);
		lbl_Name.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Name.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl_Title = new JLabel("\uC81C \uBAA9");
		lbl_Title.setBounds(63, 134, 47, 19);

		panel.add(lbl_Title);
		lbl_Title.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title.setForeground(new Color(233, 113, 113));
		JLabel lbl_Number = new JLabel("\uAE00\uBC88\uD638");
		lbl_Number.setBounds(53, 25, 57, 18);
		lbl_Number.setForeground(new Color(233, 113, 113));
		panel.add(lbl_Number);
		lbl_Number.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Number.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl_Nameinfo = new JLabel(name);
		lbl_Nameinfo.setBounds(131, 59, 166, 23);
		panel.add(lbl_Nameinfo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SMT068\\Desktop\\ball2.png"));
		lblNewLabel.setBounds(157, 36, 54, 48);
		frame.getContentPane().add(lblNewLabel);

	}
}
