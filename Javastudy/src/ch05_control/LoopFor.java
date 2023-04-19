package ch05_control;

public class LoopFor {

	public static void main(String[] args) throws InterruptedException {
		// 콘솔창에 1부터 10까지 출력하세요
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println(6);
		System.out.println(7);
		System.out.println(8);
		System.out.println(9);
		System.out.println(10);
		
		System.out.println("\n---------------------\n");
		
		//for문
		for(int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		// for문 내에서 선언된 변수 i는
		// for문 종료 후 메모리에서 삭제된다.(변수의 scope)
//		System.out.println(i);
		
		// for문 내 변수 i는 for문의 반복횟수를 정하는게 주 목적
			// 꼭 변수 i를 for문 내에서 사용하지 않아도 된다.
		int one = 1;
		for(int i = 0; i < 10; i++) { // for문의 내부가 10번 반복실행
			System.out.println(one++);
		}
		
		
		// i는 for문 내에서 사용되는 변수명일뿐이므로
		// i가 아닌 다른 단어를 사용해도 된다.
		for(int x = 0; x < 5; x++) {
			System.out.println(x);
		}
		
		System.out.println("\n---------------------\n");
		// 변수의 사용범위(scope) 사용
		// 1부터 20까지 더하기
		
		int sum = 0;
		for(int i = 1; i <= 20; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		// 21부터 45까지 더하기
		
		int sumA = 0;
		for(int i = 21; i <= 45; i++) {
			sumA += i;
		}
		System.out.println(sumA);
		
		// 1부터 40까지 중 짝수끼리만 더한 값
		int sumB = 0;
		for(int i = 1; i <= 40; i++) {
			// 현재 i가 짝수인지 확인
			if(i % 2 == 0) {
				// 짝수라면 sum에 더한다.
				sumB += i;
			}
		}
		System.out.println(sumB);
		
		// 이렇게도 가능
		int sumC = 0;
		for(int i = 0; i <= 40; i = i + 2) {
			sumC += i;
		}
		System.out.println(sumC);
		
		// 0부터 2까지 0.2마다 출력
		for(double i = 0; i <= 2; i += 0.2) {
			System.out.println(i);
		} // 나오긴하는데 비추
		
		for(int i = 0; i <=20; i += 2) {
			System.out.println(i/10.0);
		} // 이것도 가능은 함
		
		// 증감식에 i++로 두고 위의 코드와 결과가 같도록
		for(int i = 0; i <= 20; i++){
			if(i % 2 == 0)
			System.out.println(i/10.0);
		}
		
		// 규칙을 파악
		// syso가 11번 실행 -> i = 0; i < 11
		// i = 0 -> 0
		// i = 1 -> 0.2
		// i = 2 -> 0.4
		// i = 3 -> 0.6
		// i = 10 -> 2.0
		// i에 2를 곱하고 10으로 나눈 값이 결과임
		
		for(int i = 0; i < 11; i++) {
			System.out.println( (i * 2) / 10.0);
		}
		
		
		System.out.println("\n---------------------\n");
		
		// 구구단 2단을 출력
		// 2 * 2 = 4
		// 2 * 3 = 6
		// 2 * 9 = 18
		
		for(int i = 1; i < 10; i++) {
			System.out.println("2 x " + i + " = " + (2 * i));
		}
		
		System.out.println("\n---------------------\n");
		
		// 아래의 5층 트리를 for문을 이용하여 구현
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");
		
		String tt = "";
		for(int i = 0; i < 5; i++) {
			tt += "*";
			System.out.println(tt);
		}
		
		
		System.out.println("\n----------국수나무-----------\n");
		
		// 나머지 연산자(%)의 사용 예시
		// for문 내에서 순환하는 숫자에 대해 사용
		
		// 국수공장에서 면을 20cm 뽑고 있는데
		// 5cm 마다 잘라주기
		for(int i = 0; i < 20; i++) {
			System.out.println(i+ ". ||||||||");
		
		
		// i가 4, 9, 14일때 선을 그어서 면을 잘라준다
			if(i % 5 == 4) {
			System.out.println("---------");
		}
	}
		
			System.out.println("\n----------신라면-----------\n");
		
		// 라면공장에서 면을 30cm 뽑고 있는데
		// 6cm 마다 잘라주어야한다
		
		for(int i = 0; i < 30; i++) {
			if(i % 2 == 0) {
			System.out.println("///////");
			}else {
				System.out.println("\\\\\\\\\\\\\\");
			}if(i % 6 == 5) {
				System.out.println("---------");
			}
			
			// 컴퓨터가 0.4초 쉼 (400ms)
			 Thread.sleep(400);
			
		}
		
		System.out.println("\n--------------------\n");
		
		// 10부터 1까지 출력
		
		for(int i = 10; i >= 1; i--) {
			System.out.println(i);
		}
		
		System.out.println("\n--------------------\n");
		
		// for문으로 String 응용	
		// 숫자의 각 자리수를 더한 결과를 for문으로 출력
		
		// 슈의 갯수는 ?
		String syu = "슛슈슉슈슈슉슈슈슈숭";
		
		// syu를 한글자씩 자르고
		// 자른 값이 "슈"인지 체크하고
		// "슈"가 맞다면 카운팅한다.
		
		int count = 0;
		for(int i = 0; i < syu.length(); i++) {
			String str = syu.substring(i, i+1);
			System.out.println(i + ":" + str);
			
			if(str.equals("슈")) {
				count++;
			}
			
		}
		System.out.println("슈의 갯수 : " + count);
		
		System.out.println("\n--------------------\n");
		
		// break 문
		// 반복문 내에서 break 문이 실행되면
		// 해당 반복문을 즉시 종료
		
		// 1부터 n까지 더한다고 했을때,
		// 더한 값이 100 이상이 되는 지점의 n을 구할때
		sum = 0;
		for(int i = 1; i < 9999; i++) {
			sum += i;
			
			if(sum >= 100) {
				System.out.println(i);
				break;
			}
			
		}
		
		// countinue 문
		// 구구단 6단을 출력하는데,
		// 너무 쉬운 1,2,3 부분은 출력 하지 않기
		for(int i = 1; i <= 9; i++) {
			if(i < 4) {
				continue;
			}
			
			System.out.println("6 X " + i + " = " + (6 * i));
			
		}
		System.out.println("\n--------------------\n");
		
		// 이중 for문
		// 구구단
		
		// 2 * 2 =4 
		// 2 * 3 = 6
		// 2 * 9 = 18
		// 3 * 2 = 6
		// 3 * 3 = 9
		// 3 * 9 = 27
		// 9 * 9 = 81
		
		for(int left = 2; left <= 9; left++) {
			
			for(int right = 2; right <= 9; right++) {
				System.out.println(left + " x " + right + " = " + (left * right));
			}
		}
		
		/*
		 * 디버깅 모드
		 * 코드라인 좌측 연두색 부분을 더블클릭 하여
		 * 점이 생기는데 이걸 breakpoint(초록점)을 만든 후 디버깅 실행
		 * 디버깅 실행 단축키 [f11]
		 * 
		 * 디버깅 목적
		 * 코드를 한줄한줄 실행해보며 , 변수에 어떤값이 담기고 있는지 확인
		 * 
		 * 디버깅 실행(상단 벌레 모양 아이콘 클릭도 가능)
		 * 처음에 디버깅 모드에 적합한 화면(perspective)
		 * 전환 여부를 묻는 창이 뜬다 (전환 하기) 
		 * 
		 * 코드들이 쭉 실행 되다가 breakpoint 가 있는 지점에
		 * 멈춰서 실행 대기를 한다
		 * 
		 * 이후 상단의 Run - step over [단축키 F6] 을 눌러
		 * 한줄한줄 코드를 실행해본다.
		 * 
		 * 디버깅 모드를 종료하시려면 terminate 단축키 [ctrl + f2]
		 * 콘솔창에 뜨는 빨간색 중지 버튼
		 * 
		 * 이후 원래 화면(perspective)로 돌아오려면
		 * 우측 상단에서 java 
		 * 
		 */
		
		System.out.println("\n--------------------\n");
		
		// 트리
		//     *
		//    **
		//   ***
		//  ****
		// *****
		
		for(int i = 0; i < 5; i++) {
			String space = "";
			// 외부 for문의 변수 i를 이용해서
			// 내부 for문의 반복횟수를 조정할 수 있다.
			for(int k = 0; k < 4-i; k++) {
				space += " ";
			}
			
			String stars = "";
			for(int k = 0; k < i+1; k++) {
				stars += "*";
			}
			System.out.println(space + stars);
			
		}
		
		System.out.println("\n--------------------\n");
		
		//     *
		//    ***
		//   *****
		//  *******
		// *********
		
		// for 문에 5번 실행
		// 		i가 0, 1, 2, 3, 4 일때
		// 	공백은  4, 3, 2, 1, 0
		// 별표는 	1, 3, 5, 7, 9
		
		for(int i = 0; i < 5; i++) {
			String spaceA = "";
			for(int k = 0; k < 4-i; k++) {
				spaceA += " ";
			}
			String starsA = "";
			for(int k = 0; k < (i * 2) + 1; k++) {
				starsA += "*";
			}System.out.println(spaceA + starsA);
		
		}
		
		//********* 
		// *******
		//  *****
		//   ***
		//    *
		
		// i가  0 1 2 3 4
		// 공백 0 1 2 3 4
		// 별은 9 7 5 3 1 이다
		
		for(int i = 0; i < 5; i++) {
			String spaceA = "";
			for(int k = 0; k < i; k++) {
				spaceA += " ";
			}
			String starsA = "";
			for(int k = 0; k <  9 - (i*2); k++) {
				starsA += "*";
			}System.out.println(spaceA + starsA);
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
