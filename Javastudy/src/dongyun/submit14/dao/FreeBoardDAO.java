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
		query.append("	(freeboard_seq.nextval)  	");
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
		query.append("	, 	fb_like			");
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
			int like = rs.getInt("fb_like");
			
			FreeBoardVO freebod = new FreeBoardVO(number, title, content, author, date, like);
			
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
	
	
//	// 게시글 수정하기 메소드
	public int freeUpdate(Connection conn, int fbNumber, String title, String content, String date) throws SQLException {
	    StringBuffer query = new StringBuffer();
	    query.append("UPDATE freeboard ");
	    query.append("SET fb_title = ?, fb_content = ?, fb_date = ? ");
	    query.append("WHERE fb_number = ?");
	    
	    PreparedStatement ps = conn.prepareStatement(query.toString());
	    
	    int idx = 1;
	    
	    ps.setString(idx++, title);
	    ps.setString(idx++, content);
	    ps.setString(idx++, date);
	    ps.setInt(idx++, fbNumber);
	    
	    int cnt = ps.executeUpdate();
	    
	    ps.close();
	    
	    return cnt;
	}
	
	// 게시글 추천하기 메소드
	
	public int freeLike(Connection conn, int number) throws SQLException {
	    StringBuffer query = new StringBuffer();
	    query.append("UPDATE freeboard ");
	    query.append(" SET fb_like = fb_like + 1");
	    query.append("WHERE fb_number = ?");

	    PreparedStatement ps = conn.prepareStatement(query.toString());

	    ps.setInt(1, number);

	    int cnt = ps.executeUpdate();

	    ps.close();

	    return cnt;
	}
	
	// 정보 조회 하면서 게시글까지 조회하기 메소드
	public void showinfo(Connection conn, String id) throws SQLException {
		StringBuffer query = new StringBuffer();
	    query.append("SELECT fb_number, fb_title, fb_author ");
	    query.append("FROM freeboard ");
	    query.append("WHERE fb_author = ?");
		
	    PreparedStatement ps = conn.prepareStatement(query.toString());
	    ps.setString(1, id);
		
	    ResultSet rs = ps.executeQuery();
		
	    while (rs.next()) {
	        System.out.println("[ " + rs.getInt("fb_number") + " | " + rs.getString("fb_title") + " | " + rs.getString("fb_author") + " ]");
	    }
	    rs.close();
	    ps.close();
		
	}
	
	
	// 글의 개수를 카운트하기
	public int boardcount(Connection conn, String id) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT count(*) AS boardcount ");
		query.append("FROM freeboard ");
		query.append("WHERE fb_author = ?");
		
		int count = 0;
	    
	    PreparedStatement ps = conn.prepareStatement(query.toString());
	    ps.setString(1, id);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    if (rs.next()) {
	        count = rs.getInt("boardcount");
	    }
	    rs.close();
	    ps.close();
	    return count;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
