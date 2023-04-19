package dongyun.submit12;

public class Board {

	private int num;
	private String title;
	private String date;
	private String content;
	
	
	public Board() {}


	public Board(int num, String title, String date, String content) {
		super();
		this.num = num;
		this.title = title;
		this.date = date;
		this.content = content;
	}
	
	
	
	

	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", date=" + date + ", content=" + content + "]";
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
