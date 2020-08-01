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
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int payCal(MemberDTO dto) { // total �ݾ� ��� �Լ�
		getConnect();
		int result = 0;
		String sql = "select SALETARGET from TOY_MEMBER where id like ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			System.out.println("payCal �Լ� ���̵� �޾ƿ��� : "+ dto.getId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
		// TOTAL = PAY_YEAR * 20000 / DISCOUNT +3000* PLACE
	}

	public int payCk(MemberDTO dto) {// ��ȸ�� ���� ��� ȸ�� �Ⱓ ����
		getConnect();
		int cnt = 0;
		String sql = "insert into toy_member(term) values(sysdate+ (INTERVAL '1' YEAR)) where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// �峭�� �뿩���� rent = 1�� �ٲٱ�
	public int rentCk(ToyDTO dto) {
		getConnect();
		int cnt = 0;
		String sql = "update toy set rent= 1 where no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNo());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public int discountCK(MemberDTO dto) { // ���� ���� �Ǻ� , �����, ���ʼ����� ���� Ȯ��

		getConnect();
		int cnt = 0;
		String sql = "update toy_pay set discount=2 where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;

	}

	// ����� 7/31 ����
	public int placeCK(MemberDTO dto) { // �ù� ���� DB�� ����
		getConnect();
		int cnt = 0;
		String sql = "update TOY_PAY set place=1 where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// ���� ������ �뿩���̺� �߰��ϱ�

	public int addRent(int toyN, int place) { // ���� �������� �峭�� �뿩 ���̺�� �ֱ�
		int cnt = 0;

		getConnect();

		String sql = "insert into toy_rental values(?,?,SYSDATE + 7)";
		try {
			// 1.ID, 2.�峭�� ��ȣ

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, toyN);
			psmt.setInt(2, place);

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}

	public int[] selectToyNo(String login_Id, int BKSize) { // ��ٱ��Ͽ� �ִ� ���̳ѹ� �迭�� �ѱ��, ��ٱ��� ������ ��������
		int[] toyN = new int[BKSize];
		getConnect();
		String sql = "select toy_no from toy_basket where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, login_Id);
			rs = psmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				toyN[i] = rs.getInt(1);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return toyN;
	}

	// ���� ������ ���� ���̺� �߰�
	public int insertPay(String id, int discount, int place, int year, int toy_no) {
		int cnt = 0;

		getConnect();

		String sql = "insert into toy_pay(no,id,discount,place,pay_year,toy_no) values(PAY_SEQ.NEXTVAL,?,?,?,?,?)";
		try {
			// 1.ID, 2.�峭�� ��ȣ

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setInt(2, discount);
			psmt.setInt(3, place);
			psmt.setInt(4, year);
			psmt.setInt(5, toy_no);

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}
}
