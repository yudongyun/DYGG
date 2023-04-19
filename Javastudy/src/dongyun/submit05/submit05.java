package dongyun.submit05;

public class submit05 {

	public static void main(String[] args) {

		// #1
		makeTree(3);
		makeTree(7);
		
		System.out.println("\n--------------------\n");
		
		// #2
		// 로꾸꺼를 메소드로 만들어서 
		// 파라미터로 들어온 String 문자열에 대해 뒤집은 결과를 리턴하는 메소드
		// String example = "로꾸꺼 로꾸꺼";
		// string result = reverseStr(example);
		// System.out.println(result);
		String stra = reverseStr("로꾸꺼 로꾸꺼");
		System.out.println(stra);
		
		System.out.println("\n--------------------\n");
		
		// #@
		String myBinaryStr = makeBinary(23);
		System.out.println(myBinaryStr);
		
		
		
		
	}
	// mainmethod 끝
	public static void makeTree(int num) {
		
			//	   *
			//    ***
			//   *****
			//  *******
			// *********
			
			// for 문에 n번 실행
			// 		i가 0, 1, 2, 3, 4 일때
			// 	공백은  4, 3, 2, 1, 0
			// 별표는 	1, 3, 5, 7, 9
			
			for(int i = 0; i < num; i++) {
				
				String spaceA = "";
				
				for(int k = 0; k < num-i; k++) {
					
					spaceA += " ";
					
				}
				
				String starsA = "";
				
				for(int k = 0; k < (i * 2) + 1; k++) {
					
					starsA += "*";
					
				}System.out.println(spaceA + starsA);
				
			}
	}
	
	public static String reverseStr(String SS) {
		
		
		String RR = "";
		for(int i = SS.length(); i >= 1; i--) {
			
			String str = SS.substring(i-1, i);
			RR += str;
			
		}
		return RR;
		
		
		
		
	}
	
	public static String makeBinary(int num) {
		
		String str = "";
		while(num >= 1) {
			str += num % 2; 
			 num /= 2;
		}
			
		String RR = "";
		for(int i = str.length(); i >= 1; i--) {
			
			String strr = str.substring(i-1, i);
				RR += strr; 
		}
		return RR;
	}
	
	
}

