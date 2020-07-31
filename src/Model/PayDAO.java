package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public void getConnect() {
		try {
			// 1.�����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DB����
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";
			conn = DriverManager.getConnection(url, user_id, user_pw);
			if (conn != null) {
				System.out.println("���� ����");
			} else {
				System.out.println("�������");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {		
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt!=null) {
			psmt.close();}
			if(conn != null) {
				conn.close();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
	}
	
	public int payCal(PayDTO dto) { //total �ݾ� ��� �Լ�
		return dto.getPay_year()*20000 / dto.getDiscount() + 3000 * dto.getPlace();
		//TOTAL = PAY_YEAR * 20000 / DISCOUNT +3000* PLACE
		
	}
	
	public int payCk(MemberDTO dto) {//��ȸ�� ���� ��� ȸ�� �Ⱓ ����
		getConnect();
		int cnt=0;
		String sql = "insert into toy_member(term) values(sysdate+ (INTERVAL '1' YEAR)) where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId()); 
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}

	//�峭�� �뿩���� rent = 1�� �ٲٱ�
	public int rentCk(ToyDTO dto) {
		getConnect();
		int cnt=0;
		String sql = "update toy set rent= 1 where no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNo()); 
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}

	public int discountCK(MemberDTO dto) { //���� ���� �Ǻ� , �����, ���ʼ����� ���� Ȯ��

		getConnect();
		int cnt=0;
		String sql = "update toy_pay set discount=2 where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId()); 

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
		
	}
	
	//���� ������ �뿩���̺� �߰��ϱ�
	public void addToy() {
		
	}
}
