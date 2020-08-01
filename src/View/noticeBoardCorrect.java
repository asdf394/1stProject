package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.NoticeBoardDAO;
import Model.NoticeBoardDTO;
import javax.swing.JTextArea;


public class noticeBoardCorrect {

	private JFrame frame;
	static int num;
	private JTextField tf_title;
	private JTextField tf_content;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					noticeBoardCorrect window = new noticeBoardCorrect(num);
//	//				window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		}

	/**
	 * Create the application.
	 */
	public noticeBoardCorrect(int n) {
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
		frame.setBounds(100, 100, 450, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\uC81C\uBAA9");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 122, 57, 23);
		frame.getContentPane().add(label);
		

		JButton bnt_complete = new JButton("\uC218\uC815 \uC644\uB8CC");
		
		bnt_complete.setBounds(80, 430, 97, 23);
		frame.getContentPane().add(bnt_complete);
		String no = null;
		String title = null;
		String content = null;
		if(getNum().size() != 0) {
			no = ""+getNum().get(0).getNo();
			title = getNum().get(0).getTITLE();
			content = getNum().get(0).getCONTENT();
		}
		
		
		bnt_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "수정이 완료되었습니다", "게시글 수정", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose(); // 창 닫기
				String title = tf_title.getText();
				String content = tf_content.getText();
				
				NoticeBoardDTO dto = new NoticeBoardDTO(title, content);
				NoticeBoardDAO dao = new NoticeBoardDAO();
				dao.boardUpdate(title, content, num);
				
				noticeBoardGUI mainGui = new noticeBoardGUI(); // 메인 창 띄우기 객체 생성
			}
		
			

	
		});
		
		JLabel lbl_BigName = new JLabel("\uAC8C\uC2DC\uAE00 \uC218\uC815");
		lbl_BigName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BigName.setBounds(12, 21, 410, 40);
		frame.getContentPane().add(lbl_BigName);
		
		
		tf_title = new JTextField(title);
		tf_title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_title.getText().trim().length()==0 || tf_title.getText().trim().equals("제목")) {
					JOptionPane.showMessageDialog(null, "제목을 입력해 주세요.", "제목 입력", JOptionPane.WARNING_MESSAGE);
					tf_title.grabFocus();
					return;
				}
			}
		});
		tf_title.setBounds(81, 123, 116, 21);
		frame.getContentPane().add(tf_title);
		tf_title.setColumns(10);
		
		tf_content = new JTextField(content);
		tf_content.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_content.getText().trim().length()==0 || tf_content.getText().trim().equals("내용")) {
					JOptionPane.showMessageDialog(null, "내용을 입력해 주세요.", "내용 입력", JOptionPane.WARNING_MESSAGE);
					tf_content.grabFocus();
					return;
				}
			}
		});
		tf_content.setColumns(10);
		tf_content.setBounds(12, 155, 410, 265);
		frame.getContentPane().add(tf_content);
		
		JLabel lbl_Number = new JLabel("\uAE00 \uBC88\uD638");
		lbl_Number.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Number.setBounds(12, 89, 57, 23);
		frame.getContentPane().add(lbl_Number);
		
		JLabel lblNewLabel = new JLabel(num+"");
		lblNewLabel.setBounds(81, 89, 116, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_delete = new JButton("\uC0AD\uC81C");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "정말로 삭제하겠습니까?", "게시물 삭제", JOptionPane.INFORMATION_MESSAGE);
				
				String title = tf_title.getText();
				String content = tf_content.getText();
				NoticeBoardDTO dto = new NoticeBoardDTO(title, content);
				NoticeBoardDAO dao = new NoticeBoardDAO();
				dao.boardDelete(title);
				
				JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다", "게시물 삭제", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose(); // 창 닫기
				noticeBoardGUI borad = new noticeBoardGUI(); // 메인 창 띄우기 객체 생성
				
			}
		});
		btn_delete.setBounds(257, 430, 97, 23);
		frame.getContentPane().add(btn_delete);
	}
}
