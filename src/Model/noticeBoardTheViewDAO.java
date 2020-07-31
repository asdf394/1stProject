package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class noticeBoardTheViewDAO {
	public class NoticeBoardDAO {

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
					
					if(conn != null) {
						System.out.println("연결 성공");
					}else {
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
						if(rs != null) {
							
						}
						
						if(psmt != null) {
							psmt.close();
						}
						if(conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
}
}