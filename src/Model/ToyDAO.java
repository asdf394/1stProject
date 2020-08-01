package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToyDAO {
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

	public ArrayList<ToyDTO> toyInfo() { // ���� ����
		ArrayList<ToyDTO> toyList = new ArrayList<ToyDTO>();
		getConnect();
		String sql = "select * from toy";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String domain = rs.getString(3);
				String develop = rs.getString(4);
				String age = rs.getString(5);
				int rent = rs.getInt(6);
				String img = rs.getString(7);
				String explain = rs.getString(8);

				toyList.add(new ToyDTO(no, name, domain, develop, age, rent, img, explain));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return toyList;
	}

	public int toyInsert(ToyDTO dto) throws FileNotFoundException { // ���� ���̺� �߰�
		int cnt = 0;

		getConnect();
		String sql = "insert into toy(no,name,domain,develop,age,rent,img) values(TOY_SEQ.NEXTVAL,?,?,?,?,?,?)";
		try {
			// File f = new File("./img/2.png");
			FileInputStream fis = new FileInputStream(dto.getImg());

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getDomain());
			psmt.setString(3, dto.getDevelop());
			psmt.setString(4, dto.getAge());
			psmt.setInt(5, dto.getRent());
			psmt.setString(6, dto.getImg());

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public ArrayList<ToyDTO> detailInfo(int num) { // �峭���� ����
		ArrayList<ToyDTO> toyList = new ArrayList<ToyDTO>();
		getConnect();
		String sql = "select * from toy where no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String domain = rs.getString(3);
				String develop = rs.getString(4);
				String age = rs.getString(5);
				int rent = rs.getInt(6);
				String img = rs.getString(7);
				String explain = rs.getString(8);

				toyList.add(new ToyDTO(no, name, domain, develop, age, rent, img, explain));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return toyList;
	}

	public ArrayList<ToyDTO> search(String num) { // �峭�� �����˻�
		ArrayList<ToyDTO> toyList = new ArrayList<ToyDTO>();
		getConnect();
		String sql = "select * from toy where name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String domain = rs.getString(3);
				String develop = rs.getString(4);
				String age = rs.getString(5);
				int rent = rs.getInt(6);
				String img = rs.getString(7);
				String explain = rs.getString(8);

				toyList.add(new ToyDTO(no, name, domain, develop, age, rent, img, explain));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return toyList;
	}

	// ����� 7/31 ����
	public int addBasket(ToyDTO Tdto, MemberDTO memDTO) { // ��ٱ��Ͽ� ���� ��� DB�� ����
		int cnt = 0;

		getConnect();

		String sql = "insert into toy_basket values(BASKET_SEQ.NEXTVAL,?,?)";
		try {
			// 1.ID, 2.�峭�� ��ȣ

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memDTO.getId());
			System.out.println("��ٱ��� ���� ��� ���̵� ���" + memDTO.getId());
			psmt.setInt(2, Tdto.getNo());

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}

	public void clearBasket() {// ������ ������ ��ٱ��� �ʱ�ȭ, ������ ����
		getConnect();
		String sql = "TRUNCATE TABLE TOY_BASKET";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void clearBasketSQ() { // ���� ������ �ٽ��� ������ �ʱ�ȭ
		getConnect();
		String sql1 = "drop sequence BASKET_SEQ";
		String sql2 = "CREATE SEQUENCE BASKET_SEQ INCREMENT BY 1 START WITH 1 MINVALUE 1 NOCYCLE";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.execute();
			psmt = conn.prepareStatement(sql2);
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public int countBK() { // ��ٱ��Ͽ� ��� �ִ� ���� ���ϱ�
		int cnt = 0;
		getConnect();
		String sql = "SELECT COUNT(*) FROM toy_basket";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	public int changeRent(int toyN) { // ��Ʈ ���� �� �뿩������ ���� rent = 1
		getConnect();
		int cnt = 0;
		String sql = "update TOY set RENT=1 where no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, toyN);

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