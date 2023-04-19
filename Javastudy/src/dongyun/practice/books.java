package dongyun.practice;

public class books {
	private String bookname;
	private int booknum;
	private boolean isbook;
	
	
	public books() {
		
	}
	
	public books(String bookname, int booknum, boolean isbook) {
		super();
		this.bookname = bookname;
		this.booknum = booknum;
		this.isbook = isbook;
	}


	@Override
	public String toString() {
		String bookstate = (isbook) ? ("대여중") : ("입고중"); 
		
		return "책 [책이름 : " + bookname + ", 책번호 : " + booknum + ", 대여 여부 : " + bookstate + "]";
	}


	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public int getBooknum() {
		return booknum;
	}


	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}


	public boolean isIsbook() {
		return isbook;
	}


	public void setIsbook(boolean isbook) {
		this.isbook = isbook;
	}
	
	
	
	
	
}
