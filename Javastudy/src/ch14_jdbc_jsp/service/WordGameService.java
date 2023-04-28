package ch14_jdbc_jsp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import ch14_jdbc_jsp.dao.WordGameDAO;
import ch14_jdbc_jsp.vo.WordGameVO;

public class WordGameService {

	
	private WordGameService() {}
	
	private static WordGameService instance = new WordGameService();
	
	public static WordGameService getInstance() {
		return instance;
	}
	
	// 다오를 가져옴
	private WordGameDAO dao = WordGameDAO.getInstance();
	
	// 커넥션 풀을 가져옴
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	// 다오 메소드에서 윗단만 가져오기 ( 실행 부 )
	public ArrayList<WordGameVO> getWordList(){
		Connection conn = cp.getConnection();  // 파라미터 가져오기
		ArrayList<WordGameVO> result = new ArrayList<>(); // 빈 배열을 생성
		
		try { // 트라이,캐치 사용
			result = dao.getWordList(conn); // 잘 실행이 된다고 하면
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 빌려온 커넥션을 반납하는 finally 개념
			cp.releaseConnection(conn);
		} 
		
		return result; // 빈 배열 자체를 리턴함
		
	}
	
	
	
	
	
	
	
	
	
	
}
