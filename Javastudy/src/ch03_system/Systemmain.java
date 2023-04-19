package ch03_system;

import java.util.Scanner;

public class Systemmain {

	public static void main(String[] args) {
		// 표준 출력
		// 콘솔창에 텍스트 출력하기
		// println()
		// 콘솔창에 괄호안 내용을 출력 후 줄바꿈(개행문자) 해준다.
		
		System.out.println("start");
		System.out.println();  // 괄호에 아무것도 안적으면 줄바꿈만 일어남
		System.out.println("end");
		
		
		// print()
		// 괄호안 내용을 출력하기만 함
		// 줄바꿈 없이 그냥 가로로 출력된다.
		System.out.print("줄바꿈 안돼");
		System.out.print("보기 불편 ..");
		
		System.out.println("\n-------------------------------------\n");
		
		
		// 제어문자
		// 문자열 내에 역슬래시(\)를 이용하여 특정기능 사용 가능
		
		// \n 줄바꿈
		System.out.print("println처럼 동작\n");
		System.out.println("중간에 \n을 넣어보자");
		
		
		// \t 탭
		System.out.println("일\t월\t화\t수\t목");
		System.out.println("1\t2\t3\t4\t5");
		System.out.println("8\t9\t10\t11\t12");
		
		
		// 문자열 내에서 기능을 가지는 문자(\, ", ')
		// 얘네를 출력하고 싶으면 앞에 \을 붙여준다.
		
		System.out.println("개행문자는 \\n");
		System.out.println("소크라테스 왈 \"너 자신을 알라\"");
		
		// 특수문자도 출력 가능하다.
		System.out.println("*");
		
		
		System.out.println("\n-------------------------------------\n");
		
		// printf()
		// 콘솔창에 포맷 문자열(format string) 형태로 내용을 출력
		System.out.printf("%d명이 수업을 듣고 있습니다.\n", 24);
		System.out.printf("%d명이 %s을 듣고 있습니다.\n", 24, "수업");
		
		// 예시 (안중요)
		System.out.printf("%02d장 표준입출력\n", 3); // d앞에 숫자는 자리수 의미
		System.out.printf("원주율은 %.02f", 3.141592);
		System.out.printf("통장 잔고는 %,d원입니다.", 1000000);
		
		System.out.println("\n------------------표준입력-------------------\n");
		
		//Scanner 클래스로부터 객체 생성
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		System.out.print(">>> ");
		
		// 키보드 입력 받기
		String name = scan.nextLine();
		
		System.out.println(name + ": 좀 덥네요.");
		
		// scan.next() 또는 scan.nextInt() 등은 사용하지 않기..
		System.out.println("에어컨 희망 온도를 입력해주세요");
		System.out.print(">>> ");
		// .nextLine() 은 숫자를 입력해도 문자열로 가지고 온다
		
		int temper = Integer.parseInt(scan.nextLine()); // 정수열로 변환해주면 지속적으로 사용가능
		
		System.out.println("희망 온도 : " + temper);
		
		System.out.println("냉방/난방 선택해주세요");
		System.out.print(">>> ");
		String mode = scan.nextLine();
		System.out.println("모드 : " + mode);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
