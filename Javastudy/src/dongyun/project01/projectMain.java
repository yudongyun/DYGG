package dongyun.project01;

import java.util.ArrayList;
import java.util.Scanner;

public class projectMain {

	public static void main(String[] args) throws InterruptedException {

		
		
		System.out.println("\n" + 
				" _       _________ _______  _______       _________ _______        _______  _______  _______  ______  \n" + 
				"( \\      \\__   __/(  ____ \\(  ____ \\      \\__   __/(  ____ \\      (  ____ \\(  ___  )(  ___  )(  __  \\ \n" + 
				"| (         ) (   | (    \\/| (    \\/         ) (   | (    \\/      | (    \\/| (   ) || (   ) || (  \\  )\n" + 
				"| |         | |   | (__    | (__             | |   | (_____       | |      | |   | || |   | || |   ) |\n" + 
				"| |         | |   |  __)   |  __)            | |   (_____  )      | | ____ | |   | || |   | || |   | |\n" + 
				"| |         | |   | (      | (               | |         ) |      | | \\_  )| |   | || |   | || |   ) |\n" + 
				"| (____/\\___) (___| )      | (____/\\      ___) (___/\\____) |      | (___) || (___) || (___) || (__/  )\n" + 
				"(_______/\\_______/|/       (_______/      \\_______/\\_______)      (_______)(_______)(_______)(______/ \n" + 
				"                                                                                                      \n" + 
				"");
		 
		// 동윤이 객체 생성 (개발자, 백수)
//		codingdy dy = new codingdy("동윤", 27, 2, 50, 60, 40);
//		nocodingdy dy2 = new nocodingdy("동윤", 27, 90000000, 300);
		
		Scanner scan2 = new Scanner(System.in);
		
		
		
		System.out.println("▶▶ 이름을 입력해주세요");
		System.out.print("입력 : ");
		String id = scan2.nextLine();
		
		
		System.out.println("▶▶ 나이를 입력해주세요");
		System.out.print("입력 : ");
		int age = Integer.parseInt(scan2.nextLine());
		
		codingdy dy = new codingdy(id, age, 2, 50, 60, 40);
		nocodingdy dy2 = new nocodingdy(id, age, 90000000, 300);
		
		System.out.println("▶▶ 장래희망을 선택해주세요");
		System.out.println("1. 개발자 | 2. 돈 많은 백수");
		System.out.print("입력 : ");
		
		
		int select = Integer.parseInt(scan2.nextLine());
		
		if(select == 1) {
			dy.start();
			System.out.println(dy);
		}else if(select == 2){
			dy2.start2();
			System.out.println(dy2);
		}
		
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("        ↓      ");
		System.out.println("        ↓      ");
		System.out.println("        ↓      ");
		
		
		
		
		while(select == 1) {
			Thread.sleep(800);
			System.out.println("↓↓↓↓↓↓↓↓↓↓  행동을 선택해주세요  ↓↓↓↓↓↓↓↓↓");
			Thread.sleep(800);
			System.out.println("1. JAVA 공부 | 2. 술한잔 | 3. 운동 | 4. 휴식 | 5. 현재 상태 보기 | 6. 종료");
			System.out.print("입력 : ");
			
			int command = Integer.parseInt(scan.nextLine());
			
			if(command == 1) {
				// TODO 공부하기
				dy.study();
				if(dy.endstreng() == true) {
					break;
				}else if(dy.unhappy() == true) {
					break;
				}else if(dy.codingmaster() == true) {
					break;
				}
			}else if(command == 2) {
				// TODO 놀기
				dy.party();
				if(dy.endstreng() == true) {
					break;
				}else if(dy.nocodingmaster() == true) {
					break;
				}
			}else if(command == 3) {
				// TODO 운동
				dy.hellth();
				if(dy.endstreng() == true) {
					break;
				}
			}else if(command == 4) {
				// TODO 휴식
				dy.free();
				if(dy.nocodingmaster() == true) {
					break;
				}
			}else if(command == 5) {
				// TODO 현재 상태 보기
				dy.state();
				System.out.println(dy);
			}else if(command == 6) {
				// TODO 종료
				dy.end();
				break;
			}
		}
		while(select == 2) {
			Thread.sleep(800);
			System.out.println("↓↓↓↓↓↓↓↓↓↓  행동을 선택해주세요  ↓↓↓↓↓↓↓↓↓");
			Thread.sleep(800);
			System.out.println("1. 쇼핑하기 | 2. 운동하기 | 3. 도박하기 | 4. 현재 상태 보기 | 5. 종료");
			System.out.print("입력 : ");
			
			int command = Integer.parseInt(scan.nextLine());
			
			if(command == 1) {
				dy2.shopping();
				
			}else if(command == 2) {
				dy2.hellth2();
				
			}else if(command == 3) {
				dy2.gamb();
				if(dy2.nomoney() == true) {
					break;
				}
				if(dy2.yesmoney() == true) {
					break;
				}
			}else if(command == 4) {
				dy2.state2();
				System.out.println(dy2);
			}else if(command == 5) {
				dy2.end2();
				break;
			}
			
		}
		
		
		
		
		
		
		
		
		
		// 메소드를 파서 파라미터로 들어온 문자열 출력, 출력 전에 sleep걸기 
		
		
		
		
		
		
		
		
		
		
	}

}
