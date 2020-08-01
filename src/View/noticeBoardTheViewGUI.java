package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Model.NoticeBoardDAO;
import Model.NoticeBoardDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class noticeBoardTheViewGUI {

	private JFrame frame;
	static int num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					noticeBoardTheViewGUI window = new noticeBoardTheViewGUI(num);
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public noticeBoardTheViewGUI(int n) {
		this.num = n;
		initialize(num);
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
	private void initialize(int num) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_Number = new JLabel("\uAE00 \uBC88\uD638");
		lbl_Number.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Number.setBounds(12, 71, 57, 13);
		frame.getContentPane().add(lbl_Number);
		
		JLabel lbl_Name = new JLabel("\uD68C\uC6D0\uC774\uB984");
		lbl_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Name.setBounds(12, 109, 57, 15);
		frame.getContentPane().add(lbl_Name);
		
		JLabel lbl_Id = new JLabel("\uD68C\uC6D0 ID");
		lbl_Id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Id.setBounds(12, 143, 57, 15);
		frame.getContentPane().add(lbl_Id);
		
		JLabel lbl_Title = new JLabel("\uC81C\uBAA9");
		lbl_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title.setBounds(12, 179, 57, 15);
		frame.getContentPane().add(lbl_Title);
		
		JLabel lbl_BigTitle = new JLabel("\uAC8C\uC2DC\uAE00");
		lbl_BigTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BigTitle.setBounds(12, 10, 410, 51);
		frame.getContentPane().add(lbl_BigTitle);
		
		JButton btn_Befor = new JButton("\uB2EB\uAE30");
		btn_Befor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				noticeBoardGUI nba = new noticeBoardGUI();
			}
		});
		btn_Befor.setBounds(257, 448, 97, 23);
		frame.getContentPane().add(btn_Befor);
		
		String no = null;
		String name=null;
		String id = null;
		String title = null;
		String content = null;
		if(getNum().size() != 0) {
			no = ""+getNum().get(0).getNo();
			name = getNum().get(0).getName();
			id = getNum().get(0).getID();
			title = getNum().get(0).getTITLE();
			content = getNum().get(0).getCONTENT();
		}
		JLabel lbl_Numberinfo = new JLabel(no);
		lbl_Numberinfo.setBounds(81, 66, 166, 23);
		frame.getContentPane().add(lbl_Numberinfo);
		
		JLabel lbl_Nameinfo = new JLabel(name);
		lbl_Nameinfo.setBounds(81, 105, 166, 23);
		frame.getContentPane().add(lbl_Nameinfo);
		
		JLabel lbl_Idinfo = new JLabel(id);
		lbl_Idinfo.setBounds(81, 139, 166, 23);
		frame.getContentPane().add(lbl_Idinfo);
		
		JLabel lbl_Titleinfo = new JLabel(title);
		lbl_Titleinfo.setBounds(81, 175, 166, 23);
		frame.getContentPane().add(lbl_Titleinfo);
		
		JLabel lbl_Infoinfo = new JLabel(content);
		lbl_Infoinfo.setBounds(12, 222, 410, 216);
		frame.getContentPane().add(lbl_Infoinfo);
		
		JButton btn_complete = new JButton("\uC218\uC815\uD558\uAE30");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Ã¢ ´Ý±â
				noticeBoardCorrect mainGui = new noticeBoardCorrect(num); // ¸ÞÀÎ Ã¢ ¶ç¿ì±â °´Ã¼ »ý¼º
			}
		});
		btn_complete.setBounds(80, 448, 97, 23);
		frame.getContentPane().add(btn_complete);
		
		
		
	}
}
