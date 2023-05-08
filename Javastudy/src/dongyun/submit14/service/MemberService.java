package dongyun.submit14.service;

import java.sql.Connection;
import java.sql.SQLException;

import ch14_jdbc_jsp.context.ConnectionPool;
import dongyun.submit14.dao.MemberDAO;
import dongyun.submit14.vo.MemberVO;

public class MemberService {

	private MemberService() {

	}

	private static MemberService instance = new MemberService();

	public static MemberService getInstance() {
		return instance;
	}

	private ConnectionPool cp = ConnectionPool.getInstance();

	private MemberDAO dao = MemberDAO.getInstance(); // 다오 소환

	// 회원가입 메소드 !

	public void newMember(String id, String pw, String name) {

		Connection conn = cp.getConnection();

		try {
			dao.newMember(conn, id, pw, name);
			System.out.println("회원가입이 완료되었습니다 ! ");
		} catch (SQLException e) {
			// DB에서 mem_id를 유니크 값으로 설정
			System.out.println("이미 가입된 아이디 입니다.");
		} finally {
			cp.releaseConnection(conn);
		}
	}
	
	// 로그인 메소드 !
	
	public MemberVO login(MemberVO mem) {
		
		Connection conn = cp.getConnection();
		
		MemberVO result = new MemberVO();
		
		try {
			result = dao.login(conn, mem);
		} catch (SQLException e) {
			System.out.println("등록되지않은 아이디입니다.");
		}finally {
			cp.releaseConnection(conn);
		}
		
		return result;
		
		
	}
	
	// 정보 조회 메소드
	
	public void showpro(String id) {
		
		Connection conn = cp.getConnection();
		
		try {
			dao.showpro(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		
	}
	
	
	
	
	
	
	
	

}
