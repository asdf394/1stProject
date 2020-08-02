package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeBoardDAO {

	// 1. ��� �� �ʵ� �����´�
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 2. ���� �ε�
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.DB����

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";

			conn = DriverManager.getConnection(url, user_id, user_pw);

			if (conn != null) {
				System.out.println("���� ����");
			} else {
				System.out.println("���� ����");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// close �޼ҵ� ��������
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

	public ArrayList<NoticeBoardDTO> noticeInfoSelect() {
		ArrayList<NoticeBoardDTO> Toy_boardList = new ArrayList<NoticeBoardDTO>();
		getConnect();
		String sql = "select * from toy_board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString(4);
				String title = rs.getString(5);
				Toy_boardList.add(new NoticeBoardDTO(no, name, id, content, title));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return Toy_boardList;
	}

	public int joinInsert(NoticeBoardDTO dto) {// TOY_BOARD_SEQ.NEXTVAL

		System.out.println("�Խ��� ��� �̸� : "+dto.getName());
		System.out.println("�Խ��� ��� ���̵� : "+dto.getID());
		System.out.println(dto.getCONTENT());
		System.out.println(dto.getTITLE());
		int cnt = 0;
		getConnect();
		String sql = "insert into TOY_BOARD values(BOARD_SEQ.NEXTVAL,?,?,?,?)";
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getID());
			psmt.setString(3, dto.getCONTENT());
			psmt.setString(4, dto.getTITLE());
			cnt = psmt.executeUpdate();

			if (cnt >= 0) {
				System.out.println("����");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}

	public ArrayList<NoticeBoardDTO> search(String check) { // �Խñ� ��ȸ
		ArrayList<NoticeBoardDTO> searchList = new ArrayList<NoticeBoardDTO>();
		System.out.println(check);
		getConnect();
		String sql = "select * from toy_board where name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, check);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString(4);
				String title = rs.getString(5);
				searchList.add(new NoticeBoardDTO(no, name, id, content, title));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return searchList;
	}

	public ArrayList<NoticeBoardDTO> detailInfo(int num) { // �峭���� ����
		ArrayList<NoticeBoardDTO> BoardList = new ArrayList<NoticeBoardDTO>();
		getConnect();
		String sql = "select * from toy_board where no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString(4);
				String title = rs.getString(5);

				BoardList.add(new NoticeBoardDTO(no, name, id, content, title));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return BoardList;
	}
	public int boardUpdate(String title, String content, int no) {
		int cnt = 0;
		getConnect();
		String sql = "update toy_board set title=? , content=? where no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, no);
			
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public int boardDelete(String title) {
		int cnt = 0;
		getConnect();
		String sql = "delete from toy_board where TITLE=? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}
