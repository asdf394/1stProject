package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.ToyDAO;
import Model.ToyDTO;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class MemberInfoOnlyGUI {

   private JFrame frame;
   private JTable table_1;

   /**
    * Launch the application.
    */

   /*
    * public static void main(String[] args) { EventQueue.invokeLater(new
    * Runnable() { public void run() { try { MemberInfo window = new MemberInfo();
    * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
    * } }); } /*
    * 
    * 
    * 
    * 
    * /** Create the application.
    */
   public MemberInfoOnlyGUI() {
      initialize();
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.getContentPane().setBackground(Color.WHITE);
      frame.setBounds(100, 100, 901, 601);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
      lblNewLabel.setForeground(new Color(240, 150, 97));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(363, 33, 146, 34);
      frame.getContentPane().add(lblNewLabel);
      String[] colName = { "번호", "이름", "영역", "발달정보", "사용연령", "대여여부" };

      MemberDAO dao = new MemberDAO();
      ArrayList<MemberDTO> memberList = dao.memberInfoSelect();
      Object[][] data = new Object[memberList.size()][7];
      for (int i = 0; i < data.length; i++) {
         data[i][0] = memberList.get(i).getId();
         data[i][1] = memberList.get(i).getPw();
         data[i][2] = memberList.get(i).getName();
         data[i][3] = memberList.get(i).getAddress();
         data[i][4] = memberList.get(i).getPhoneNumber();
         data[i][5] = memberList.get(i).getSaletarget();
      }

      DefaultTableModel model = new DefaultTableModel(data, colName) {// 셀클릭시 기본은 셀 편집 상태가 되는 것을 막기위해
         public boolean isCellEditable(int row, int col) {// DefaultTableModeld의 isCellEditable를 재정의함 (false로)
            return false;
         }
      };
      JButton btnNewButton = new JButton("\uB2EB \uAE30");
      btnNewButton.setForeground(Color.WHITE);
      btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            MainGUI main = new MainGUI(null);
         }
      });
      btnNewButton.setBounds(294, 492, 227, 41);
      btnNewButton.setBackground(new Color(240, 150, 97));
      frame.getContentPane().add(btnNewButton);

      String a = this.getClass().getResource("../img/member.png").getPath();
      JLabel lblNewLabel_1 = new JLabel("");

      lblNewLabel_1.setIcon(new ImageIcon(a));
      lblNewLabel_1.setBounds(294, 10, 72, 66);
      frame.getContentPane().add(lblNewLabel_1);

      // 국경아 수정 8월 1일
      // 선택한 회원의 장난감 리스트로 반환

      String[] colName1 = { "장난감번호", "장난감이름" };
      DefaultTableModel model1 = new DefaultTableModel(colName1, 0);
      
      JPanel panel = new JPanel();
      panel.setBounds(12, 77, 847, 405);
      panel.setBackground(new Color(250, 236, 197));
      frame.getContentPane().add(panel);
      panel.setLayout(null);
      
            JScrollPane scrollPane_1 = new JScrollPane();
            scrollPane_1.setBounds(432, 22, 403, 373);
            panel.add(scrollPane_1);
            
                  table_1 = new JTable();
                  scrollPane_1.setViewportView(table_1);
                  
                        table_1 = new JTable(model1);
                        table_1.setBounds(0, 10, 422, 148);
                        scrollPane_1.setViewportView(table_1);
                        
                        JLabel lbl_Id = new JLabel("\uC544\uC774\uB514");
                        lbl_Id.setFont(new Font("굴림", Font.BOLD, 12));
                        lbl_Id.setBounds(57, 26, 57, 15);
                        panel.add(lbl_Id);
                        lbl_Id.setHorizontalAlignment(SwingConstants.CENTER);
                        
                        JLabel lbl_Name = new JLabel("\uC774 \uB984");
                        lbl_Name.setFont(new Font("굴림", Font.BOLD, 12));
                        lbl_Name.setBounds(57, 79, 57, 15);
                        panel.add(lbl_Name);
                        lbl_Name.setHorizontalAlignment(SwingConstants.CENTER);
                        
                        JLabel lbl_Address = new JLabel("\uC8FC \uC18C");
                        lbl_Address.setFont(new Font("굴림", Font.BOLD, 12));
                        lbl_Address.setBounds(57, 131, 57, 15);
                        panel.add(lbl_Address);
                        lbl_Address.setHorizontalAlignment(SwingConstants.CENTER);
                        
                        JLabel lbl_YearMoney = new JLabel("\uC5F0\uD68C\uBE44");
                        lbl_YearMoney.setFont(new Font("굴림", Font.BOLD, 12));
                        lbl_YearMoney.setBounds(57, 191, 57, 15);
                        panel.add(lbl_YearMoney);
                        lbl_YearMoney.setHorizontalAlignment(SwingConstants.CENTER);
                        
                        JLabel lbl_Info = new JLabel("\uAE30\uBCF8\uC815\uBCF4");
                        lbl_Info.setFont(new Font("굴림", Font.BOLD, 12));
                        lbl_Info.setBounds(57, 245, 57, 15);
                        panel.add(lbl_Info);
                        lbl_Info.setHorizontalAlignment(SwingConstants.CENTER);
                        
                        String b = this.getClass().getResource("../img/flower.png").getPath();
                        JLabel label = new JLabel("");
                        label.setIcon(new ImageIcon(b));
                        label.setBounds(40, 22, 16, 23);
                        panel.add(label);
                        
                        String c = this.getClass().getResource("../img/flower.png").getPath();
                        JLabel label_1 = new JLabel("");
                        label_1.setIcon(new ImageIcon(c));
                        label_1.setBounds(40, 79, 16, 23);
                        panel.add(label_1);
                        
                        String d = this.getClass().getResource("../img/flower.png").getPath();
                        JLabel label_2 = new JLabel("");
                        label_2.setIcon(new ImageIcon(d));
                        label_2.setBounds(40, 127, 16, 23);
                        panel.add(label_2);
                        
                        String e = this.getClass().getResource("../img/flower.png").getPath();
                        JLabel label_3 = new JLabel("");
                        label_3.setIcon(new ImageIcon(e));
                        label_3.setBounds(40, 183, 16, 23);
                        panel.add(label_3);
                        
                        String f = this.getClass().getResource("../img/flower.png").getPath();
                        JLabel label_4 = new JLabel("");
                        label_4.setIcon(new ImageIcon(f));
                        label_4.setBounds(40, 237, 16, 23);
                        panel.add(label_4);
                        
                        JLabel lblNewLabel_2 = new JLabel("");
                        lblNewLabel_2.setBounds(126, 26, 150, 15);
                        panel.add(lblNewLabel_2);
                        
                        JLabel label_5 = new JLabel("");
                        label_5.setBounds(126, 79, 150, 15);
                        panel.add(label_5);
                        
                        JLabel label_6 = new JLabel("");
                        label_6.setBounds(126, 131, 150, 15);
                        panel.add(label_6);
                        
                        JLabel label_7 = new JLabel("");
                        label_7.setBounds(126, 191, 150, 15);
                        panel.add(label_7);
                        
                        JLabel label_8 = new JLabel("");
                        label_8.setBounds(52, 280, 313, 115);
                        panel.add(label_8);
   }
}