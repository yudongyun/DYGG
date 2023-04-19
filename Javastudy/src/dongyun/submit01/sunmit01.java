package dongyun.submit01;

public class sunmit01 {

	public static void main(String[] args) {

		
		String name = "유동윤";
		int age = 27;
		double height = 178.5;
		String phone = "010-3025-0440";
		String email = "dbehddbs971205@naver.com";
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(phone);
		System.out.println(email);
		
		System.out.println("\n----------------------------------------------------\n");
		
		
		String enigma = "너오구늘리뭐너먹구지리";
		System.out.println(enigma.replace("너", ""));
		enigma = enigma.replace("너", "");
		System.out.println(enigma.replace("구", ""));
		enigma = enigma.replace("구", "");
		System.out.println(enigma.replace("리", ""));
		enigma = enigma.replace("리", "");
		
		// 양쪽 끝 공백 제거
		System.out.println(enigma.trim());
		
		System.out.println("\n----------------------------------------------------\n");
		
		String example = "278";
		System.out.println(example);
		
		String exampleA = "2";
		String exampleB = "7";
		String exampleC = "8";
		System.out.println(exampleA);
		System.out.println(exampleB);
		System.out.println(exampleC);
		
		// 각 문자열을 정수로 변환 후 정수 더하기
		int intNum = Integer.parseInt((exampleA));
		int intMum = Integer.parseInt((exampleB));
		int intBum = Integer.parseInt((exampleC));
		System.out.println(intNum + intMum + intBum);
		
		
		
		
		
		
		
	}

}
