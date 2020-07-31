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
	
	public int payCal(PayDTO dto) { //total 금액 계산 함수
		return dto.getPay_year()*20000 / dto.getDiscount() + 3000 * dto.getPlace();
		//TOTAL = PAY_YEAR * 20000 / DISCOUNT +3000* PLACE
		
	}
	
	public int payCk(MemberDTO dto) {//연회비 냈을 경우 회원 기간 설정
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

	//장난감 대여여부 rent = 1로 바꾸기
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

	public int discountCK(MemberDTO dto) { //할인 여부 판별 , 장애인, 기초수급자 인지 확인

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
	
	//결제 됐을때 대여테이블에 추가하기
	public void addToy() {
		
	}
}
