package dongyun.submit12;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Board {

	private int num;
	private String title;
	private String date;
	private String content;
	

	
	
	public Board() {}


	private static Board instance = new Board();
	
	public static Board getInstance() {
		return instance;
	}
	
	public Board(int num, String title, String date, String content) {
		super();
		Date dateToday = new Date(); // 현재시간 데이트 타입 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 새로운 포맷을 적용
		String strToday = sdf.format(dateToday);
		this.num = num;
		this.title = title;
		this.date = strToday;
		this.content = content;
	}
	
	
	
	

	@Override
	public String toString() {
		return "[" + num+". | " + title +" | " + date + "]";
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