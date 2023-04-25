package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDelete {

	public static void main(String[] args) {
		
		// 1. 드라이버 로딩
				// (프로젝트 내에서 단 한번만 실행이 되면 됨)
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("드라이버 등록 성공");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.out.println("드라이버 등록 실패");
					System.exit(0); // 현재 프로그램 종료
				}
				
				String url = "jdbc:oracle:thin:@192.168.1.39:1521:xe";
				String id = "jdbc";
				String pw = "oracle";
				
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null; // insert,update, delete 에는 resultset이 필요없음
				
				try {
					conn = DriverManager.getConnection(url, id, pw);
					
					StringBuffer query = new StringBuffer();
					query.append("DELETE students		");
					query.append("WHERE  1 = 1		    "); // 1=1 은 항상 true
					query.append("AND    stu_id = ?	    ");
					
					// 값에 대해 ?로 표기한 후 다음 단계에서 ?에 값을 채워주어도 된다.
					
					ps = conn.prepareStatement(query.toString());
					
					// 위에서부터 ?를 채워나가며,
					// 위에서부터 ?의 인덱스는 1부터 증가한다
					int idx = 1; // 중간에 수정할 일 있을때 숫자까지 바꿔줘야하니 idx++
					ps.setString(idx++, "d001");
					
					// 쿼리문 실행
					// insert, delete, update 문은
					// ps.executeUpdate() 실행
					// 기본적으로 자동커밋
					
					// cnt에는 'n행이 삭제 되었습니다'의 n이 저장된다.
					int cnt = ps.executeUpdate();
					
					System.out.println(cnt + "행 이(가) 삭되었습니다.");
					
					// 업데이트문 실행 후 SELECT문 실행하여 변경사항 확인하기
					
					query = new StringBuffer();
					query.append("SELECT			");
					query.append("		stu_id		");
					query.append("	, stu_password 	");
					query.append("	, stu_name		");
					query.append("	, stu_score		");
					query.append("FROM				");
					query.append("		students	");
					
					// 사용했던 ps는 한번 닫아준 뒤 사용
					ps.close();
					ps = conn.prepareStatement(query.toString());
					
					rs = ps.executeQuery();
					
					while(rs.next()) {
						String stuId = rs.getString("stu_id");
						String stuPw = rs.getString("stu_password");
						String stuName = rs.getString("stu_name");
						int stuScore = rs.getInt("stu_score");
						
						System.out.println("아이디: " + stuId
								+ "비밀번호: " + stuPw
								+ "이름: " + stuName
								+ "점수: " + stuScore);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally { 
					if(rs != null) try { rs.close();} catch (SQLException e) {e.printStackTrace();} 
					if(ps != null) try { ps.close();} catch (SQLException e) {e.printStackTrace();}
					if(conn != null) try { conn.close();} catch (SQLException e) {e.printStackTrace();}
				}
		
		
		
		
		
		
		
		
		
	}

}
