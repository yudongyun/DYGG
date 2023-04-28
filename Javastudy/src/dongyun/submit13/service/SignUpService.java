package dongyun.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;

import ch14_jdbc_jsp.context.ConnectionPool;
import ch14_jdbc_jsp.vo.StudentVO;
import dongyun.submit13.dao.SignUpDAO;
import dongyun.submit13.vo.SignUpVO;

public class SignUpService {
	
	
	private SignUpService() {}
	
	private static SignUpService instance = new SignUpService();
	
	public static SignUpService getInstance() {
		return instance;
	}
	
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	private SignUpDAO dao = SignUpDAO.getInstance(); // 다오 불러오기
	
	// 회원가입(INSERT) 메소드
	
	public void regiSignup(String Id, String Password) {
		
		Connection conn = cp.getConnection();
		
		try {
			dao.regiSignup(conn, Id, Password);
			System.out.println("회원가입 성공이용 ~");
		} catch (SQLException e) {
			System.out.println(" 이미 가입된 아이디 입니다.");
		} finally {
			cp.releaseConnection(conn);
		}
		
	}


	
	
	
	// 로그인(SELECT) 메소드
	public SignUpVO login(SignUpVO sign) {
		Connection conn = cp.getConnection();
		
		SignUpVO result = new SignUpVO();
		
		
		try {
			result = dao.login(conn, sign);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		
		return result;
	}












	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
