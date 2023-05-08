package dongyun.submit14.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import dongyun.submit14.dao.BoardReviewDAO;
import dongyun.submit14.vo.BoardReviewVO;

public class BoardReviewService {

	private BoardReviewService() {
	}

	private static BoardReviewService instance = new BoardReviewService();

	public static BoardReviewService getInstance() {
		return instance;
	}

	private ConnectionPool cp = ConnectionPool.getInstance();
	private BoardReviewDAO dao = BoardReviewDAO.getInstance();

	// 댓글 등록 메소드
	public void reviewSave(int fbNumber, String content, String author, String date) {

		Connection conn2 = cp.getConnection();

		try {
			dao.reviewSave(conn2, fbNumber, content, author, date);
			System.out.println("댓글이 등록 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn2);
		}

	}

	// 댓글 목록 조회 메소드
	public ArrayList<BoardReviewVO> reviewList(int fb_number) {

		Connection conn = cp.getConnection();

		ArrayList<BoardReviewVO> result = new ArrayList<>();

		try {
			result = dao.reviewList(conn, fb_number);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}

		return result;

	}

	// 댓글 삭제 메소드
	public int reviewDelete(int fbNumber) {

		Connection conn = cp.getConnection();

		int delete = 0;

		try {
			delete = dao.reviewDelete(conn, fbNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return delete;
	}
	
	
	// 정보 조회 하면서 댓글까지 조회하기 메소드
	
	public void showreinfo(String id) {
		
		Connection conn = cp.getConnection();
		
		try {
			dao.showreinfo(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}
	
	

}
