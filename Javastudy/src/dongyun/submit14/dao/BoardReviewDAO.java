package dongyun.submit14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dongyun.submit14.vo.BoardReviewVO;
import dongyun.submit14.vo.FreeBoardVO;

public class BoardReviewDAO {
	
	private BoardReviewDAO() {}
	
	private static BoardReviewDAO instance = new BoardReviewDAO();
	
	public static BoardReviewDAO getInstance() {
		return instance;
	}
	
	// 댓글 등록 메소드
	public int reviewSave(Connection conn, int fbNumber, String content, String author, String date) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO boardreview (");
		query.append("		  br_number		");
		query.append("		, fb_number		");
		query.append("		, br_content		");
		query.append("		, br_author		");
		query.append("		, br_date		");
		query.append(") VALUES (			");
		query.append("	(SELECT NVL(MAX(br_number),0) + 1 FROM boardreview) 	");
		query.append("		, ?				");
		query.append("		, ?				");
		query.append("		, ?				");
		query.append("		, ?				");
		query.append(" 			)			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		
		ps.setInt(idx++, fbNumber);
		ps.setString(idx++, content);
		ps.setString(idx++, author);
		ps.setString(idx++, date);
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
	}
	
	// 댓글 조회 메소드
	public ArrayList<BoardReviewVO> reviewList(Connection conn, int fbNumber) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT				");
		query.append("		br_number		");
		query.append("	, 	fb_number 		");
		query.append("	, 	br_content		");
		query.append("	, 	br_author		");
		query.append("	, 	br_date			");
		query.append("FROM					");
		query.append("		boardreview		");
		query.append("WHERE 					");
		query.append("		fb_number = ?	");
		query.append("ORDER BY 				");
		query.append("		br_number ASC	");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ps.setInt(1, fbNumber);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<BoardReviewVO> result = new ArrayList<>();
		
		while(rs.next()) {
			int number = rs.getInt("br_number");
			String content = rs.getString("br_content");
			String author = rs.getString("br_author");
			String date = rs.getString("br_date");
			
			BoardReviewVO boardReview = new BoardReviewVO(number, fbNumber, content, author, date);
			
			result.add(boardReview);
		}
		ps.close();
		rs.close();
		
		return result;
	}
	
	// 댓글 삭제하기 메소드
	// 게시글 댓글 삭제하기
	public int reviewDelete(Connection conn, int fbNumber) throws SQLException{
	    StringBuffer query = new StringBuffer();
	    query.append("DELETE FROM boardreview ");
	    query.append("WHERE fb_number = ? ");
	    
	    PreparedStatement ps = conn.prepareStatement(query.toString());
	    
	    int idx = 1;
	    
	    ps.setInt(idx++, fbNumber);
	    
	    int cnt = ps.executeUpdate();
	    
	    ps.close();
	    
	    return cnt;
	}
	
	
	
	
	
	
	
	
	
}
