package ch03_system;

public class Comments {
	
	
	// 자바 문서(javadoc) 주석
	/**
	 * 바나나는 노랗다.
	 */
	static String banana = "바나나";
	
	
	
	public static void main(String[] args) {
		// 주석 (Comment)
		
		// 단일 주석 ( 코드앞에 // )
		// 참고로 프로그래밍 언어마다 다른 주석을 사용하는 경우가 많음
		// ( 파이썬 #, sql --, html <!-->, ...)
		// 단축키 [Ctrl + /]
		
		/* 
		 * 다중 주석
		 */ 
		
		// 자바 문서(javadoc) 주석
		String fruits = "APPLE";
		fruits.substring(2);
		
		
		// 보통은 메소드 사용법에 대해 설명하는 용도임.
		System.out.println(banana);  // banana에 바나나는 노랗다는 주석 검색 가능해짐
		
		// TODO 주석
		// 개발 중간에 틀을 짜듯이 구현해야할 부분을 계획해두는 용도임.
		// window - show view - tasks 에 TODO 주석들의 위치가 다 뜸
		
		// TODO 바나나를 콘솔창에 출력 할 예정
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
