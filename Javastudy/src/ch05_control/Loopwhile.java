package ch05_control;

import java.util.Scanner;

public class Loopwhile {

	public static void main(String[] args) {
		// while문
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
			// for문을 while문으로 굳이 바꾼다면 ,,
			
		int i = 1; // 초기화식
		while(i <= 10) { // 조건식
			// 조건문이 false가 되면 while 문 종료 true면 내부 실행
			
			System.out.println(i);
			i++; // 증감식
		}
		
		// while 문으로 구구단 2단
		// 2 * 2 = 4
		// 2 * 3 = 6
		// while는 반복횟수가 정해지지 않은 경우 사용
		
		System.out.println("\n--------------------\n");
		// 콘솔형 프로그램
		
		Scanner scan = new Scanner(System.in);
		boolean isRun = true;
		
//		while(isRun) {
//			System.out.println("이름 입력[종료는 q 또는 Q]");
//			System.out.print(">>> ");
//			
//			String input = scan.nextLine();
//			
//			if(input.equals("q") || input.equals("Q")) {
//			//if(input.equalsIgnorecase("q")) { // 대소문자 구문없이 체크
//				System.out.println("프로그램을 종료합니다.");
//				isRun = false;
//				// break; (else 를 굳이 안써도 아래는 실행을 안함) 
//			}else {
//				System.out.println(input + "님 환영합니다.");
//			}
//			
//		}
		
		System.out.println("\n--------------------\n");
		
				
		
		System.out.println("\n--------------------\n");
		
		// do-while문
		isRun = false;
		
		// 반복해야할 내용이 최소 한번은 실행되게끔
		// 하고 싶을때 사용(굳이 몰라도 된다)
		
		do {
			// 반복될 내용 작성
			System.out.println("하이");
		}while (isRun);
		
		System.out.println("\n--------------------\n");
		
		// while문 또한 다중으로 사용이 가능
		// while문으로 구구단
		// 2 * 2 = 4
		// 2 * 3 = 6
		
		int left = 2;
		while(left <= 9) {
			
			int right =2;
			while(right <= 9) {
				System.out.println(left + "x" + right + "=" + (left * right));
				
				right++;
			}
			left++;
		}
		
		// 포켓몬스터
		
		int enemyHp = 100;
		
		outer : while(true) {
			System.out.println("야생의 파이리를 만났습니다.");
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 공격 | 2. 도망");
			System.out.print(">>>   ");
			
			int command = Integer.parseInt(scan.nextLine());
			
			if(command == 1) {
				//TODO 공격
				while(true) {
					System.out.println("공격 방법 선택");
					System.out.println("1. 백만볼트 | 2. 전광석화 | 3. 취소");
					System.out.print(">>>   ");
					
					int select = Integer.parseInt(scan.nextLine());
					
					if(select == 1) {
					System.out.println("피~까~~츄!!");
					enemyHp -= 20;
				}else if(select == 2) {
					System.out.println("삐까삐까앙");
					enemyHp -= 10;
				}else if(select == 3) {
					System.out.println("공격 취소");
					// 내부 while문은 종료
					// 외부 while문은 계속 실행
					break;
				}
				System.out.println("파이리의 현재체력 : " + enemyHp);
				
				// 파이리 죽음
				if(enemyHp <= 0) {
					System.out.println("파이리를 처치했습니다.");
//					System.exit(0);  // 프로그램 종료
					// 내부에서 외부 while 문 중지
					break outer;
				}
					
				}
			}else if(command == 2) {
				// 도망
				System.out.println("도망쳤습니다.");
				break;
			}
				
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
