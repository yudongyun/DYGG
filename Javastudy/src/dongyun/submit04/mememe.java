package dongyun.submit04;

import java.util.Scanner;

public class mememe {

	public static void main(String[] args) {

		int EVA = 10;
		int EVB = 4;
		
	while(true) {
	System.out.println("\n===========희영빌딩 엘베=================\n");
	Scanner scanA = new Scanner(System.in);
	
	System.out.println("승강기 A의 현재 위치 :" + EVA + "층");
	System.out.println("승강기 B의 현재 위치 :" + EVB + "층");
	System.out.println("몇층에 있나요 ?[종료하시려면 q 또는 exit 입력] ");
	String strA = scanA.nextLine();
	
	if(strA.equals("q") || strA.equals("exit")) {
		System.out.println("프로그램을 종료합니다.");
		break;
	}
	
		int floor = Integer.parseInt((strA));
		
		// 층수 차이 계산
		int diffA = Math.abs(EVA - floor); // 10 - 9 = 1
		int diffB = Math.abs(EVB - floor);
		
		if(diffA > diffB) {
			System.out.println("엘리베이터 B가 " + floor + "층으로 이동하였습니다.");
			EVB = floor;
		}else if(diffA < diffB) {
			System.out.println("엘리베이터 A가 " + floor + "층으로 이동하였습니다.");
			EVA = floor;
		}else {
			
			if(EVA > EVB) {
				System.out.println("엘리베이터 A가 " + floor + "층으로 이동하였습니다.");
				EVA = floor;
			}else {
				System.out.println("엘리베이터 A가 " + floor + "층으로 이동하였습니다.");
				EVA = floor;
			}
			
		}
		
		
		
		}
	}
}
