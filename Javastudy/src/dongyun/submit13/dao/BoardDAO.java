package dongyun.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ch14_jdbc_jsp.vo.StudentVO;
import dongyun.submit13.vo.BoardVO;

public class BoardDAO {

	
	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	
	// 글을 저장하는 메소드 
	public int saveBoard(Connection conn, String title, String content, String author, String date) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO board (");
		query.append("		  board_no		");
		query.append("		, board_title	");
		query.append("		, board_content		");
		query.append("		, board_author		");
		query.append("		, board_date		");
		query.append(") VALUES (			");
		query.append("	(SELECT COUNT(*) + 1 FROM board)  	");
		query.append("		, ?				");
		query.append("		, ?				");
		query.append("		, ?				");
		query.append("		, ?				");
		query.append(" 			)			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		
		
		int idx = 1; 
		
		ps.setString(idx++, title);
		ps.setString(idx++, content);
		ps.setString(idx++, author);
		ps.setString(idx++, date);
		
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
	}
	
	// 목록 조회(select) 메소드
	
	public ArrayList<BoardVO> getBodList(Connection conn) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT				");
		query.append("		board_no			");
		query.append("	, board_title 		");
		query.append("	, board_content			");
		query.append("	, board_author			");
		query.append("	, board_date			");
		query.append("FROM					");
		query.append("		board			");
		query.append("ORDER BY	 				"); 
		query.append("		board_no ASC		"); // 주의: 세미콜론이 없음
		
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<BoardVO> result = new ArrayList<>();
		
		while(rs.next()) {
			int no = rs.getInt("board_no");
			String title = rs.getString("board_title");
			String content = rs.getString("board_content");
			String author = rs.getString("board_author");
			String date = rs.getString("board_date");
			BoardVO bord = new BoardVO(no, title, content, author, date);
			
			result.add(bord);
		}
		
		ps.close();
		rs.close();
		
		return result;
		
	}
	
//	// 글 번호 선택 메소드
//	
//	public ArrayList<BoardVO> showList(Connection conn) throws SQLException{
//		StringBuffer query = new StringBuffer();
//		query.append("SELECT				");
//		query.append("		board_no			");
//		query.append("	, board_title 		");
//		query.append("	, board_content			");
//		query.append("	, board_author			");
//		query.append("	, board_date			");
//		query.append("FROM					");
//		query.append("		board			");
//		query.append("WHERE					");
//		query.append("		board_no = ? 	");
//		
//		PreparedStatement ps = conn.prepareStatement(query.toString());
//		
//		ResultSet rs = ps.executeQuery();
//		
//		ArrayList<BoardVO> result2 = new ArrayList<>();
//		
//		while(rs.next()) {
//			int no = rs.getInt("board_no");
//			String title = rs.getString("board_title");
//			String content = rs.getString("board_content");
//			String author = rs.getString("board_author");
//			String date = rs.getString("board_date");
//			BoardVO bord = new BoardVO(no, title, content, author, date);
//			
//			result.add(bord);
//		}
//		
//		ps.close();
//		rs.close();
//		
//		return result;
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
