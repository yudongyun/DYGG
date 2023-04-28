package dongyun.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ch14_jdbc_jsp.context.ConnectionPool;
import ch14_jdbc_jsp.vo.StudentVO;
import dongyun.submit13.dao.BoardDAO;
import dongyun.submit13.vo.BoardVO;

public class BoardService {

	
	private BoardService() {}
	
	private static BoardService instance = new BoardService();
	
	public static BoardService getInstance() {
		return instance;
	}
	
	private ConnectionPool cp = ConnectionPool.getInstance();
	private BoardDAO dao = BoardDAO.getInstance();
	
	
	
	
	// 글 저장 메소드
	public void saveBoard(String title, String content, String author, String date) {
		
		Connection conn1 = cp.getConnection();
		 
		
		
		try {
			dao.saveBoard(conn1, title, content, author, date);
			System.out.println("글이 저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn1);
		}
		
	}

	// 글 목록 조회 메소드
	
	public ArrayList<BoardVO> getBodList(){
		Connection conn = cp.getConnection();
		
		ArrayList<BoardVO> result = new ArrayList<>();
		
		try {
			result = dao.getBodList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
