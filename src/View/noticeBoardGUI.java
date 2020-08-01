package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Model.NoticeBoardDAO;
import Model.NoticeBoardDTO;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class noticeBoardGUI {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField tf_check;
	int num;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					noticeBoardGUI window = new noticeBoardGUI();
////					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public noticeBoardGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tf_check = new JTextField();
		tf_check.setBounds(132, 86, 576, 34);
		frame.getContentPane().add(tf_check);
		tf_check.setColumns(10);
		
		JLabel lbl_notice = new JLabel("\uAC8C \uC2DC \uD310");
		lbl_notice.setForeground(Color.BLACK);
		lbl_notice.setForeground(new Color(240, 150, 97));
		lbl_notice.setFont(new Font("굴림", Font.BOLD, 30));
		lbl_notice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_notice.setBounds(284, 10, 241, 65);
		frame.getContentPane().add(lbl_notice);
		
		JButton btn_make = new JButton("\uAE00 \uC791\uC131");
		btn_make.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				NewnoticeBoardGUI nba = new NewnoticeBoardGUI(); 
				
			}
		});
		btn_make.setBounds(174, 507, 158, 37);
		frame.getContentPane().add(btn_make);
		
		JButton btn_close = new JButton("\uB2EB\uAE30");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // 창 닫기
				MainGUI mainGui = new MainGUI(null); // 메인 창 띄우기 객체 생성
			}
		});
		btn_close.setBounds(379, 507, 119, 37);
		frame.getContentPane().add(btn_close);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 146, 779, 348);
		frame.getContentPane().add(scrollPane);
			
		String[] colName = {"NO", "ID", "NAME", "TITLE", "CONTENT"};
		NoticeBoardDAO dao = new NoticeBoardDAO();
		ArrayList<NoticeBoardDTO> Toy_boardList = dao.noticeInfoSelect();
		Object[][] data = new Object[Toy_boardList.size()][5];
		for(int i=0; i<data.length; i++) {
			data[i][0] = Toy_boardList.get(i).getNo();
			data[i][1] = Toy_boardList.get(i).getID();
			data[i][2] = Toy_boardList.get(i).getName();
			data[i][3] = Toy_boardList.get(i).getTITLE();
			data[i][4] = Toy_boardList.get(i).getCONTENT();
		}
		DefaultTableModel model = new DefaultTableModel(data, colName) {//셀클릭시 기본은 셀 편집 상태가 되는 것을 막기위해
	         public boolean isCellEditable(int row, int col) {//DefaultTableModeld의 isCellEditable를 재정의함 (false로)
	             return false;
	         } 
	      };
	      
	    table = new JTable(model);
	    
	    table.addMouseListener(new MouseAdapter() {
	    	@Override
	         public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	               ArrayList<NoticeBoardDTO> TheView = new ArrayList<NoticeBoardDTO>();
	               NoticeBoardDAO dao = new NoticeBoardDAO();
	               int row = table.getSelectedRow();
	               num = (int) table.getValueAt(row, 0);
	               

	               System.out.println(TheView.toString());
	               frame.dispose();
	               noticeBoardTheViewGUI nba = new noticeBoardTheViewGUI(num);
	               
	            }

	            }
	         

	      });

		scrollPane.setViewportView(table);
		
		JButton btn_check = new JButton("\uAC8C\uC2DC\uAE00 \uC870\uD68C");
		btn_check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] colName = { "NO", "ID", "NAME", "TITLE", "CONTENT"};
	            NoticeBoardDAO dao = new  NoticeBoardDAO();
	            ArrayList<NoticeBoardDTO> searchList = dao.search(tf_check.getText());
	            System.out.println(searchList.get(0).getID());
	            Object[][] data = new Object[searchList.size()][5];
	            if(searchList.size() != 0) {
	            	
	            	for (int i = 0; i < data.length; i++) {
	            		data[i][0] = searchList.get(i).getNo();
	            		data[i][1] = searchList.get(i).getID();
	            		data[i][2] = searchList.get(i).getName();
	            		data[i][3] = searchList.get(i).getTITLE();
	            		data[i][4] = searchList.get(i).getCONTENT();
	            		
	            		
	            	}
	            	
	            }
	            table = new JTable(data, colName);
	            scrollPane.setViewportView(table);
	         }
	      });
		btn_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btn_check.setBounds(720, 85, 108, 35);
		frame.getContentPane().add(btn_check);
		
		JLabel lbl_check = new JLabel("\uAC8C\uC2DC\uAE00 \uC870\uD68C");
		lbl_check.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_check.setBounds(22, 87, 108, 31);
		frame.getContentPane().add(lbl_check);
		
	
	}
}
