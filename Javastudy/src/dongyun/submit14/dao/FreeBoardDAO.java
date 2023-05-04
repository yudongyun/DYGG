package dongyun.submit14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import dongyun.submit14.vo.FreeBoardVO;

public class FreeBoardDAO {

	private FreeBoardDAO() {}
	
	private static FreeBoardDAO instance = new FreeBoardDAO();
	
	public static FreeBoardDAO getInstance() {
		return instance;
	}
	
	// 게시판에 글 작성 메소드
	public int freesave(Connection conn, String title, String content, String author, String date) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO freeboard (");
		query.append("		  fb_number		");
		query.append("		, fb_title	");
		query.append("		, fb_content		");
		query.append("		, fb_author		");
		query.append("		, fb_date		");
		query.append(") VALUES (			");
		query.append("	(SELECT MAX(fb_number) + 1 FROM freeboard)  	");
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
	
	// 게시판의 글 목록을 조회하기
	public ArrayList<FreeBoardVO> FreeBoardList(Connection conn) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT				");
		query.append("		fb_number			");
		query.append("	, 	fb_title 		");
		query.append("	, 	fb_content			");
		query.append("	, 	fb_author			");
		query.append("	, 	fb_date			");
		query.append("FROM					");
		query.append("		freeboard			");
		query.append("ORDER BY	 				"); 
		query.append("		fb_number ASC		");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<FreeBoardVO> result = new ArrayList<>();
		
		while(rs.next()) {
			int number = rs.getInt("fb_number");
			String title = rs.getString("fb_title");
			String content = rs.getString("fb_content");
			String author = rs.getString("fb_author");
			String date = rs.getString("fb_date");
			
			FreeBoardVO freebod = new FreeBoardVO(number, title, content, author, date);
			
			result.add(freebod);
		}
		ps.close();
		rs.close();
		
		return result;
	}
	
	// 게시글 삭제하기
	public int freeDelete(Connection conn, int number) throws SQLException{
	    StringBuffer query = new StringBuffer();
	    query.append("DELETE FROM freeboard ");
	    query.append("WHERE fb_number = ? ");
	    
	    PreparedStatement ps = conn.prepareStatement(query.toString());
	    
	    int idx = 1;
	    
	    ps.setInt(idx++, number);
	    
	    int cnt = ps.executeUpdate();
	    
	    ps.close();
	    
	    return cnt;
	}
	
	
	
	
	
	
	
	
	
	
}
