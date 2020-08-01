package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	// 1. 사용 할 필드 가져온다
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 2. 동적 로딩
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.DB연결

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";

			conn = DriverManager.getConnection(url, user_id, user_pw);

			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// close 메소드 가져오기
	}

	public void close() {

		try {
			if (rs != null) {

			}

			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int joinInsert(MemberDTO dto) {

		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		System.out.println(dto.getName());
		System.out.println(dto.getAddress());
		System.out.println(dto.getPhoneNumber());
		System.out.println(dto.getSaletarget());
		int cnt = 0;
		getConnect();
		String sql = "insert into TOY_MEMBER values(?,?,?,?,?,?,?)";
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getAddress());
			psmt.setString(5, dto.getPhoneNumber());
			psmt.setInt(6, dto.getSaletarget());
			psmt.setString(7, dto.getTerm());
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}

	public MemberDTO loginSelect(String id, String pw) {
		getConnect(); // 연결
		MemberDTO dto = null;
		String sql = "select * from TOY_MEMBER where id=? and pw=?"; // 매개변수 id,pw 위에 입력 loginSelect뒤에 입력
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String loginId = rs.getString(1);
				String loginPw = rs.getString(2);
				String name = rs.getString(3);
				String address = rs.getString(4);
				String phoneNumber = rs.getString(5);
				int saletarget = rs.getInt(6);
				dto = new MemberDTO(loginId, loginPw, name, address, phoneNumber, saletarget);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public ArrayList<MemberDTO> memberInfoSelect() {
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		getConnect();
		String sql = "select * from TOY_MEMBER";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String address = rs.getString(4);
				String phoneNumber = rs.getString(5);
				int saletarget = rs.getInt(6);
				String term = rs.getString(7);
				memberList.add(new MemberDTO(id, pw, name, address, phoneNumber, saletarget, term));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberList;
	}

	public int deletemember(String id, String pw) {
		int cnt = 0;
		getConnect();
		String sql = "delete from TOY_MEMBER where Id=? and pw=? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public int updatemember(String pw, String name, String address, String phonenumber, int saletarget, String id) {
		int cnt = 0;
		getConnect();
		String sql = "update TOY_MEMBER set pw=? , name=? , address=? , phone=? , saletarget = ? where id like ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, name);
			psmt.setString(3, address);
			psmt.setString(4, phonenumber);
			psmt.setInt(5, saletarget);
			psmt.setString(6, id);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public ArrayList<ToyDTO> memRentToy(Object value) { // 회원 대여장난감 번호, 이름 가져오기
		ArrayList<ToyDTO> toyList = new ArrayList<ToyDTO>();
		getConnect();
		String sql = "select no, name from toy where no in (select toy_no from toy_pay where id like ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setObject(1, value);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				toyList.add(new ToyDTO(name, no));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return toyList;
	}
}