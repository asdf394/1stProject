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
			// 1.동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DB연결
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";
			conn = DriverManager.getConnection(url, user_id, user_pw);
			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결실패");
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

	public ArrayList<ToyDTO> toyInfo() { // 토이 정보
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

	public int toyInsert(ToyDTO dto) throws FileNotFoundException { // 토이 테이블 추가
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

	public ArrayList<ToyDTO> detailInfo(int num) { // 장난감상세 정보
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

	public ArrayList<ToyDTO> search(String num) { // 장난감 정보검색
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
}