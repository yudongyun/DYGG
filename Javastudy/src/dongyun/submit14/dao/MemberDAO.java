package dongyun.submit14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dongyun.submit14.vo.MemberVO;

public class MemberDAO {

	
	private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 회원가입하기
	
	public int newMember(Connection conn, String id, String pw, String name) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO members (");
		query.append("		  mem_id		");
		query.append("		, mem_password	");
		query.append("		, mem_name	");
		query.append(") VALUES (			");
		query.append("		  ?				");
		query.append("		, ?				");
		query.append("		, ?				");
		query.append(" 			)			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, id);
		ps.setString(idx++, pw);
		ps.setString(idx++, name);
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
	}
	
	// 로그인 메소드
	public MemberVO login(Connection conn, MemberVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT				");
		query.append("		mem_id			");
		query.append("	,   mem_password 		");
		query.append("FROM					");
		query.append("		members		"); 
		query.append("WHERE 1=1				"); 
		query.append(" AND mem_id = ?				"); 
		query.append(" AND mem_password = ?				"); 
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, mem.getId());
		ps.setString(idx++, mem.getPw());
		
		ResultSet rs = ps.executeQuery();
		
		MemberVO result = new MemberVO();
		
		while(rs.next()) {
			result.setId(rs.getString("mem_id"));
			result.setPw(rs.getString("mem_password"));
		}
		
		rs.close();
		ps.close();
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
