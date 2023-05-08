package dongyun.submit14.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import dongyun.submit14.dao.FreeBoardDAO;
import dongyun.submit14.vo.FreeBoardVO;


public class FreeBoardService {

	private FreeBoardService() {}
	
	private static FreeBoardService instance = new FreeBoardService();
	
	public static FreeBoardService getInstance() {
		return instance;
	}
		
	
	
	private ConnectionPool cp = ConnectionPool.getInstance();
	private FreeBoardDAO dao = FreeBoardDAO.getInstance();
	
	
	// 게시판 글 작성 메소드
	
	public void freesave(String title, String content, String author, String date) {
		
		Connection conn = cp.getConnection();
		
		
		try {
			dao.freesave(conn, title, content, author, date);
			System.out.println("게시글이 등록 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		
		
	}
	
	// 글 목록 조회 메소드
	
	public ArrayList<FreeBoardVO> FreeBoardList(){
		
		Connection conn = cp.getConnection();
		
		ArrayList<FreeBoardVO> result = new ArrayList<>();
		
		try {
			result = dao.FreeBoardList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		
		return result;
		
	}
	
	
	// 글 삭제 메소드
	
	public int freeDelete(int number) {
		
		Connection conn = cp.getConnection();
		
		int delete = 0;
		
		try {
	        delete = dao.freeDelete(conn, number);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        cp.releaseConnection(conn);
	    }
	    
	    return delete;
		
	}
	
	// 게시글 수정 메소드
	
	public void freeUpdate(int fbNumber, String title, String content, String date) {
		
		Connection conn = cp.getConnection();
		
		try {
			dao.freeUpdate(conn, fbNumber, title, content, date);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        cp.releaseConnection(conn);
	    }
		
	}
	
	// 게시글 추천 메소드
	
	public int freeLike(int number) {
		
		Connection conn = cp.getConnection();

	    int result = 0;

	    try {
	        result = dao.freeLike(conn, number);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        cp.releaseConnection(conn);
	    }

	    return result;
	}
	
	// 정보 조회 하면서 게시글까지 조회하기 메소드
	public void showinfo(String id) {
		
		Connection conn = cp.getConnection();
		
		try {
			dao.showinfo(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}
	
	// 글의 개수 카운트 메소드
	
	public int boardcount(String id) {
		
		Connection conn = cp.getConnection();
		
		int result = 0;
		
		try {
			result = dao.boardcount(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			cp.releaseConnection(conn);
		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
}
