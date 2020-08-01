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

	// 국경아 7/31 수정
	public int addBasket(ToyDTO Tdto, MemberDTO memDTO) { // 장바구니에 넣을 경우 DB에 저장
		int cnt = 0;

		getConnect();

		String sql = "insert into toy_basket values(BASKET_SEQ.NEXTVAL,?,?)";
		try {
			// 1.ID, 2.장난감 번호

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memDTO.getId());
			System.out.println("장바구니 담을 경우 아이디 출력" + memDTO.getId());
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

	public void clearBasket() {// 결제를 누르면 장바구니 초기화, 시퀀스 수정
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

	public void clearBasketSQ() { // 결제 누르면 바스켓 시쿼스 초기화
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

	public int countBK() { // 장바구니에 들어 있는 개수 구하기
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

	public int changeRent(int toyN) { // 렌트 됐을 때 대여중으로 변경 rent = 1
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