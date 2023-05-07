package dongyun.submit14.vo;

import java.util.ArrayList;

public class FreeBoardVO {
	
	private int no;
	private String title;
	private String content;
	private String author;
	private String date;
	private int like;
	
	public FreeBoardVO() {}

	public FreeBoardVO(int no, String title, String content, String author, String date, int like) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.like = like;
	}

	@Override
	public String toString() {
		return "FreeBoardVO [no=" + no + ", title=" + title + ", content=" + content + ", author=" + author + ", date="
				+ date + ", like=" + like + "]";
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

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	
	
	
}
