package ch12_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExMethod {
	
	public static void indexing(int[] intArray) {
		
		try {
			System.out.println(intArray[10]);
		} catch (Exception e) {
			System.out.println("인덱싱 실패");
		}
	}
	
	// 입력받은 이름을 콘손창에 출력하는 메소드
	public static void printName(String name) throws Exception {
		
		// empty 체크
		// 파라미터로 들어온 name이 empty면 에러 발생 시키기
		if(name.length() == 0) {
			throw new BizException("API_001", "empty 들어옴 ㅡㅡ");
		}else if(name.matches(".*[0-9].*")) {
			throw new BizException("API_002", "숫자가 들어옴 ㅡㅡ");
		}
		
		System.out.println(name);
		
	}
	
	// 날짜 문자열을 입력하면 밀리초로 바꿔서 리턴
	// (yyyy.MM.dd)
	
	public static long dateMillSec(String date) throws ParseException {
		// "2023.04.21"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		// 에러 처리를 어디서 할지 선택 할 수 있음 ( main , method )
		Date temp = sdf.parse(date);
		return temp.getTime();
		
		
	}
	
	
	
	
}
