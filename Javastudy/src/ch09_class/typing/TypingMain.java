package ch09_class.typing;

import java.util.ArrayList;
import java.util.Scanner;

public class TypingMain {

	public static void main(String[] args) {
		
		// 타자 연습 게임
		
		Scanner scan = new Scanner(System.in);
		
		// 단어 목록
		// static 메소드는 해당 클래스를 굳이 객체로 만들지 않아도 사용이 가능하다.
		// Math.random();		
		// Dictionary dict = new Dictionary(); // 스태틱 붙히면
		ArrayList<String> wordList = Dictionary.makeWordList(2);
		System.out.println(Dictionary.optionStudent);
		
		Dictionary dict = new Dictionary();
		System.out.println(dict.optionCoding);
		
		
		// 현재 시간 저장
		long before = System.currentTimeMillis();
		System.out.println(before);
		// 1970년 1월 1일을 기준으로 현재까지 경과된 시간을 밀리초 단위로 리턴
		// ( 1초 = 1000밀리초 )
		
		
		while(true) {
			// wordList에 담긴 단어가 랜덤하게 출력
			// = Math.random() 실행결과가 wordList의 인덱스 중 하나
			// = wordList의 인덱스 0 ~ wordList.size() - 1
			int randIdx = (int)(Math.random() * wordList.size());
			System.out.println(wordList.get(randIdx));
			
			
			// 출력된 단어를 입력
			System.out.print(">>>  ");
			String input = scan.nextLine();
			
			// 입력한 단어가 출력된 단어와 일치하는지 체크
			if(wordList.get(randIdx).equals(input)) {
				// 일치한다면 wordList 에서 해당 단어를 삭제
				wordList.remove(randIdx);
			}
			// 삭제된 0번이 없어지고 1번이 0번자리로 다시옴
			
			// 일치하지 않으면 해당 단어가 삭제되지 않아서 또 입력받음
			
			
			// 위 과정을 반복 실행 ( wordList.size()가 0이 될때까지 )
			if(wordList.size() == 0) {
				break;
			}
			
			
		}
		
		// 끝났을때의 시간
		long after = System.currentTimeMillis();
		
		// after 에서 before를 빼면, 타자를 친 시간이 구해진다.
		long diff = after - before; // diff는 밀리초 단위임
		
		// 보기 좋게 초 단위로 변환
		// 31870밀리초 -> 31.87초
		double result = diff / 1000.0; // 31.87초 이렇게 나옴
		System.out.println(result + "초 걸리셨어요. ");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
