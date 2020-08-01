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

	public int payCal(MemberDTO dto) { // total 금액 계산 함수
		getConnect();
		int result = 0;
		String sql = "select SALETARGET from TOY_MEMBER where id like ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			System.out.println("payCal 함수 아이디 받아오기 : "+ dto.getId());
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

	public int payCk(MemberDTO dto) {// 연회비 냈을 경우 회원 기간 설정
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

	// 장난감 대여여부 rent = 1로 바꾸기
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

	public int discountCK(MemberDTO dto) { // 할인 여부 판별 , 장애인, 기초수급자 인지 확인

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

	// 국경아 7/31 수정
	public int placeCK(MemberDTO dto) { // 택배 여부 DB에 수정
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

	// 결제 됐을때 대여테이블에 추가하기

	public int addRent(int toyN, int place) { // 결제 눌렀을때 장난감 대여 테이블로 넣기
		int cnt = 0;

		getConnect();

		String sql = "insert into toy_rental values(?,?,SYSDATE + 7)";
		try {
			// 1.ID, 2.장난감 번호

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

	public int[] selectToyNo(String login_Id, int BKSize) { // 장바구니에 있는 토이넘버 배열로 넘기기, 장바구니 사이즈 가져오기
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

	// 결제 됐을때 결제 테이블에 추가
	public int insertPay(String id, int discount, int place, int year, int toy_no) {
		int cnt = 0;

		getConnect();

		String sql = "insert into toy_pay(no,id,discount,place,pay_year,toy_no) values(PAY_SEQ.NEXTVAL,?,?,?,?,?)";
		try {
			// 1.ID, 2.장난감 번호

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
