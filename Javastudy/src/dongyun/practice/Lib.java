package dongyun.practice;

import java.util.ArrayList;

public class Lib {

	private ArrayList<books> bookList = new ArrayList<>();

	private Lib() {

		String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";

		String[] temp = strBooks.split(",");

		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp[i].trim();
		}

		for (int i = 0; i < temp.length; i++) {
			bookList.add(new books(temp[i], bookList.size() + 1, false));

		}

	}

	private static Lib instance = new Lib();

	public static Lib getInstance() {
		return instance;
	}
	
	// 책 목록을 조회한다.
	public void showBookList() {
		for(int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
		
	}
	
	// 책 입고하기
	public void inBook(int no) {
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getBooknum() == no) {
				bookList.get(i).setIsbook(false);
				System.out.println(bookList.get(i).getBookname() + "가 입고 되었습니다.");
			}
			
		}
	}
	
	// 책 대여하기
	public void useBook(int no) {
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getBooknum() == no) {
				bookList.get(i).setIsbook(true);
				System.out.println(bookList.get(i).getBookname() + "를 대여했습니다.");
			}
			
		}
		
		
	}
	
	// 책 검색하기 + 검색된 책 목록 리턴
	public ArrayList<books> searchBookList(String key){
		ArrayList<books> result = new ArrayList<>();
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getBookname().contains(key)) {
				result.add(bookList.get(i));
			}
			
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
