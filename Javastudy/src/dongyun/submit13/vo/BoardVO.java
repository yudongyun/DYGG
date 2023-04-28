package dongyun.submit13.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {

	
	private int no;
	private String title;
	private String content;
	private String author;
	private String date;
	
	public BoardVO() {}

	public BoardVO(int no, String title, String content, String author, String date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
	}

	@Override
	public String toString() {
		return "동윤 커뮤니티 [번호 : " + no + ", 제목 : " + title + ", 내용 : " + content + ", 작성자 : " + author + ", 작성일자 :"
				+ date + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
	
	
}
