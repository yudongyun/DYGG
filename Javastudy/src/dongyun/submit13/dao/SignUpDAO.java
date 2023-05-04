package dongyun.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch14_jdbc_jsp.vo.StudentVO;
import dongyun.submit13.vo.SignUpVO;

public class SignUpDAO {
	
	
	private SignUpDAO() {}
	
	private static SignUpDAO instance = new SignUpDAO();
	
	public static SignUpDAO getInstance() {
		return instance;
	}
	
	// 회원가입(INSERT) 메소드
	
	public int regiSignup(Connection conn, String Id, String Password) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO signup (");
		query.append("		  signup_id		");
		query.append("		, signup_pw	");
		query.append(") VALUES (			");
		query.append("		  ?				");
		query.append("		, ?				");
		query.append(" 			)			");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, Id);
		ps.setString(idx++, Password);
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
		
	}
	
	
	// 로그인 메소드
	public SignUpVO login(Connection conn, SignUpVO sign) throws SQLException {
		
		StringBuffer query = new StringBuffer();
		query.append("SELECT				");
		query.append("		signup_id			");
		query.append("	,  signup_pw 		");
		query.append("FROM					");
		query.append("		signup		"); 
		query.append("WHERE 1=1				"); 
		query.append(" AND signup_id = ?				"); 
		query.append(" AND signup_pw = ?				"); 
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, sign.getId());
		ps.setString(idx++, sign.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		SignUpVO result = new SignUpVO();
		
		while(rs.next()) {
			result.setId(rs.getString("signup_id"));
			result.setId(rs.getString("signup_pw"));
		}
		
		rs.close();
		ps.close();
		
		return result;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
