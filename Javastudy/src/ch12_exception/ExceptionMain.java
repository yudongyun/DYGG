package ch12_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ExceptionMain {

	public static void main(String[] args){

		// 보통 예외가 발생한 상황에 대해 에러가 났다고 표현
		// 현업에서는 뻑났다 .. 라고 말함
		// 예외는 굳이 나누면 예측 가능한 예외 / 예측하지 못한 예외로 나눔

		// 예외 상황에서 예외처리를 해줘야 우리가 만든 에러페이지라도 보여줄수 있다.

		int[] intArray = { 1, 2, 3 };

		// 에러가 나도 트라이캐치를 하면 빨간에러가 나와도 출력은 실행은 된다.

		try {
			System.out.println(intArray[3]);
			System.out.println("인덱싱 성공");
		} catch (ArrayIndexOutOfBoundsException except) {
			// ArrayIndexOutOfBoundsException
			// try 블록 내에서 발생할 수 있는 에러 종류에 대한 클래스
			// 해당 에러가 발생하면 catch 블록 내부가 실행
			System.out.println("예외 발생!!");
			System.out.println("에러메세지 : " + except.getMessage());

			// 항상 우리가 보면 에러 로그 출력임
			// system.err.println() 으로 출력
			// syso랑 출력되는 타이밍이 자기 맘대로 출력된다

			except.printStackTrace();
		}

		System.out.println("인덱싱 종료");

		System.err.println("빨간글씨 차차");

		try {
			System.out.println(intArray[1]);
			System.out.println("인덱싱 성공");
		} catch (Exception e) {
			System.out.println("예외 발생 2");
			System.out.println("에러메세지 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("인덱싱 종료2");

		// 예외 처리를 하고자 하는 코드 선택 후
		// 마우스 우클릭 - surround whth - try catch 클릭
		try {
			System.out.println(intArray[4]);
		} catch (Exception e) {
			e.printStackTrace();
			// 이 자리에 에러 페이지로 이동시키는 코드가 들어간다
		}

		// 일반적으로 예외처리는 충분한 테스트 이후
		// 개발 막바지에 적용을 하는 편임

		System.out.println("\n=========================\n");

		// 콘솔형 프로그램에서 숫자를 입력하지 않으면
		// 다시 입력할 수 있도록
		Scanner scan = new Scanner(System.in);

//		while (true) {
//			System.out.println("행동을 선택하라 ..");
//			System.out.println("1. 밥 먹기 | 2. 잠 자기 | 3. 종료");
//			System.out.print(">>  ");
//
//			int command = 0;
//			try {
//				command = Integer.parseInt(scan.nextLine());
//			} catch (NumberFormatException e) {
//				System.out.println("숫자만 입력하세여 !");
//				continue; // 숫자를 입력하지 않으면 while 문 앞으로 이동함
//			}
//
//			if (command == 1) {
//				System.out.println("냠냠냠");
//			} else if (command == 2) {
//				System.out.println("크어어어ㅓ어엉");
//			} else if (command == 3) {
//				System.out.println("종료");
//				break;
//			} else {
//				System.out.println("1, 2, 3 중 하나를 입력하세영");
//			}
//
//		}

		System.out.println("\n=========================\n");
		
		// 원래는 SELECT 문 1줄 이상 출력이 되는데
		// WHERE 절을 걸었더니 SELECT 문이 0줄로 출력이 된다 
		// 시스템 상 에러는 안남 -> 우리가 직접 에러 발생시킴
		
		// 충분히 예측되는 예외의 경우
		// 따로 Exception 클래스를 만들어서 다룬다.
		// 비즈니스 Exception -> BizException
		
		ExMethod.indexing(intArray); // 클래스 내 메소드로도 try 문 작성된다.
		
		
		// 에러 처리를 해줘야 하기 때문에 
		// 해당 메소드를 최종적으로 실행하는 곳에서는
		// try catch 를 해줘야함
		try {
			ExMethod.printName("동윤33");
		} catch (BizException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getErrCode());
			// 에러페이지로 전환
		} catch (Exception e) {
			e.printStackTrace();
			// 에러페이지로 전환
		}
		
		System.out.println("이름 출력 끝 ~ ");
		
		
		
		try {
			System.out.println(ExMethod.dateMillSec("2023.04.20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n=========================\n");
		
		try {
			ExMethod.printName("동윤");
		} catch (BizException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생하든 안하든 실행될 명령어 입력
			// 주로 try 블록 내에서 사용된 객체를 close 할때 사용
			System.out.println("항상 실행");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
