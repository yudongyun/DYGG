package dongyun.submit02;

import java.util.Scanner;

public class Submit02 {

	public static void main(String[] args) {
		//Scanner 클래스로부터 객채 생성
		
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		System.out.print(">>>   ");
		
		// 키보드 입력
		String name = scan.nextLine();
		
		System.out.println("국어 점수를 입력해주세요.");
		System.out.print(">>>   ");
		
		int A = Integer.parseInt(scan.nextLine());
		
		System.out.println("영어 점수를 입력해주세요.");
		System.out.print(">>>   ");
		
		int B = Integer.parseInt(scan.nextLine());
		
		System.out.println("수학 점수를 입력해주세요.");
		System.out.print(">>>   ");
		
		int C = Integer.parseInt(scan.nextLine());
		
		String colA = name;
		int colB = A;
		int colC = B;
		int colD = C;
		double all = (double)(colB + colC + colD) / 3;
		
		System.out.println("이름 :" + colA);
		System.out.println("국어 :" + colB);
		System.out.println("영어 :" + colC);
		System.out.println("수학 :" + colD);
		System.out.println("평균 :" + String.format("%.2f", all)); // System.out.printf("평균: %.2f", all); --> 이거로 해도 됩니다.
		
		String grade = (all >= 90) ? ("A") : ((all >= 80) ? ("B") : ("C"));
		System.out.println("등급: " + grade);
		
		System.out.println("\n--------------------------------\n");
		
		String idBack = "1231476";
		//System.out.println(idBack.substring(0, 1));
		
		int intNum = Integer.parseInt(idBack.substring(0, 1));
		//System.out.println(intNum);
		
		String check = ((intNum % 2 == 1)) ? ("남성") : ("여성");
		System.out.println(check);
		
		
		
	}

}
