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
      lblNewLabel.setFont(new Font("����", Font.BOLD, 30));
      lblNewLabel.setForeground(new Color(240, 150, 97));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(195, 33, 146, 34);
      frame.getContentPane().add(lblNewLabel);
      String[] colName = { "��ȣ", "�̸�", "����", "�ߴ�����", "��뿬��", "�뿩����" };

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

      DefaultTableModel model = new DefaultTableModel(data, colName) {// ��Ŭ���� �⺻�� �� ���� ���°� �Ǵ� ���� ��������
         public boolean isCellEditable(int row, int col) {// DefaultTableModeld�� isCellEditable�� �������� (false��)
            return false;
         }
      };
      JButton btnNewButton = new JButton("\uB2EB \uAE30");
      btnNewButton.setForeground(Color.WHITE);
      btnNewButton.setFont(new Font("����", Font.BOLD, 15));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            MainGUI main = new MainGUI(null);
         }
      });
      btnNewButton.setBounds(5, 492, 429, 41);
      btnNewButton.setBackground(new Color(240, 150, 97));
      frame.getContentPane().add(btnNewButton);

      String a = this.getClass().getResource("../img/member.png").getPath();
      JLabel lblNewLabel_1 = new JLabel("");

      lblNewLabel_1.setIcon(new ImageIcon(a));
      lblNewLabel_1.setBounds(126, 10, 72, 66);
      frame.getContentPane().add(lblNewLabel_1);

      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(445, 99, 428, 319);
      frame.getContentPane().add(scrollPane_1);

      table_1 = new JTable();
      scrollPane_1.setViewportView(table_1);

      // ����� ���� 8�� 1��
      // ������ ȸ���� �峭�� ����Ʈ�� ��ȯ

      String[] colName1 = { "�峭����ȣ", "�峭���̸�" };
      DefaultTableModel model1 = new DefaultTableModel(colName1, 0);

      table_1 = new JTable(model1);
      table_1.setBounds(0, 10, 422, 148);
      scrollPane_1.setViewportView(table_1);
      
      JLabel lbl_Id = new JLabel("\uC544\uC774\uB514");
      lbl_Id.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_Id.setBounds(12, 106, 57, 15);
      frame.getContentPane().add(lbl_Id);
      
      JTextArea ta_Id = new JTextArea();
      ta_Id.setBounds(81, 102, 146, 24);
      frame.getContentPane().add(ta_Id);
      
      JLabel lbl_Name = new JLabel("\uC774\uB984");
      lbl_Name.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_Name.setBounds(12, 159, 57, 15);
      frame.getContentPane().add(lbl_Name);
      
      JTextArea ta_Name = new JTextArea();
      ta_Name.setBounds(81, 155, 146, 24);
      frame.getContentPane().add(ta_Name);
      
      JLabel lbl_Address = new JLabel("\uC8FC\uC18C");
      lbl_Address.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_Address.setBounds(12, 211, 57, 15);
      frame.getContentPane().add(lbl_Address);
      
      JTextArea ta_Address = new JTextArea();
      ta_Address.setBounds(81, 207, 146, 24);
      frame.getContentPane().add(ta_Address);
      
      JLabel lbl_YearMoney = new JLabel("\uC5F0\uD68C\uBE44");
      lbl_YearMoney.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_YearMoney.setBounds(12, 271, 57, 15);
      frame.getContentPane().add(lbl_YearMoney);
      
      JLabel lbl_Info = new JLabel("\uAE30\uBCF8\uC815\uBCF4");
      lbl_Info.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_Info.setBounds(12, 325, 57, 15);
      frame.getContentPane().add(lbl_Info);
      
      JTextArea ta_YearMoney = new JTextArea();
      ta_YearMoney.setBounds(81, 267, 146, 24);
      frame.getContentPane().add(ta_YearMoney);
      
      JTextArea ta_Info = new JTextArea();
      ta_Info.setBounds(12, 350, 422, 132);
      frame.getContentPane().add(ta_Info);
   }
}