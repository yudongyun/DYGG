package dongyun.submit06;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class submit06 {

	public static void main(String[] args) {

		// #1
		String[] nameList = { "이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민",
				"최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬" };

		int count = 0;
		for (int i = 0; i < nameList.length; i++) {
			nameList[i] = nameList[i].substring(0, 1);

			if (nameList[i].equals("이")) {
				count++;
			}
		}
		printArray(nameList); // 성만 자른 값
		
		System.out.println("\n--------------\n");

		System.out.println("이씨 성을 가진 배우가 총 " + count + "명 있습니다.");

		System.out.println("\n--------------\n");

		
		
		
		
		// #2

		int[] intArr = { 23, 456, 213, 32, 464, 1, 2, 4 };

		// 오름차순 정렬, 맨 마지막이 가장 큼
		// 오름차순 정렬, 맨 처음이 가장 작음
		Arrays.sort(intArr);
		int str = intArr[7];
		for (int i = 0; i < intArr.length; i++) {

			if (intArr[i] > str) {
				str = intArr[i];
			}
		}
		System.out.println("최대값 : " + str);

		int srt = intArr[0];
		for (int i = 0; i < intArr.length; i++) {

			if (intArr[i] <= srt) {
				srt = intArr[i];
			}
		}
		System.out.println("최소값 : " + srt);

		System.out.println("\n--------------\n");

		
		
		
		
		// #3

		// 로또번호 추출 1 ~ 45
		int[] mylotto = makeLotto(6);
		for (int i = 0; i < mylotto.length; i++) {
			System.out.print(mylotto[i] + " ");
		}
		
		
		
		
		
	} // 메인메소드 끝지점

	// 로또번호 메소드
	public static int[] makeLotto(int num) {

		int lotto[] = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			int numA = (int) (Math.random() * 45) + 1;
			lotto[i] = numA;

			// 6개의 숫자 중 중복값이 있을 시 i - 1로 변환
			for (int k = 0; k < i; k++) {
				if (lotto[i] == lotto[k]) {
					i--;
					break;
				}
			}

		}
		
		return lotto;
	}

	public static void swap(int p_a, int p_b) {
		int temp = p_a;
		p_a = p_b;
		p_b = temp;

	}

	// 자리 바꾸기 메소드를 만들기

	public static void swap(int idxA, int idxB, int[] numArray) {
		int temp = numArray[idxA];
		numArray[idxA] = numArray[idxB];
		numArray[idxB] = temp;

	}

	// 메소드 오버로딩

	public static void printArray(int[] intArray) {

		for (int i = 0; i < intArray.length; i++) {
			// i가 마지막일때는 뒤에 콤마를
			// 붙이지 않고 개행문자도 넣는다.

			if (i == intArray.length - 1) {
				System.out.println(intArray[i]);
				break;
			}
			System.out.print(intArray[i] + ", ");
		}

	}

	public static void printArray(String[] strArray) {

		for (int i = 0; i < strArray.length; i++) {
			// i가 마지막일때는 뒤에 콤마를
			// 붙이지 않고 개행문자도 넣는다.

			if (i == strArray.length - 1) {
				System.out.println(strArray[i]);
				break;
			}
			System.out.print(strArray[i] + ", ");
		}

	}

	public static String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());

		return bytesToHex(md.digest());
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

}
