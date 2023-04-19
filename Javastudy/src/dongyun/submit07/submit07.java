package dongyun.submit07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class submit07 {

	public static void main(String[] args) {
		
		ArrayList<Integer> result1 = new ArrayList<>();
		ArrayList<Integer> result2 = new ArrayList<>();
		// #1-1번 문제
		for (int i = 0; i < 10; i++) {
			int rand = (int) (Math.random() * 11) + 10;
			result1.add(rand);
		}
		System.out.println(result1);
		
		// #1-2번 문제 (for문 활용)
		for (int i = 0; i < result1.size(); i++) {
			if (!result2.contains(result1.get(i))) {
				result2.add(result1.get(i));
			}
		}
		System.out.println(result2);
		
		System.out.println("\n=============================\n");
		
		// #1-2번 중복제거 다른방법
		for(int i = 0; i < result1.size(); i++) {
			
			for(int k = result1.size()-1; k > i; k--) {
				if(result1.get(i) == result1.get(k)) {
					result1.remove(k);
				}
			}
			
		}
		System.out.println(result1);
		
		
		System.out.println("\n=============================\n");
		
		
		// #1-2번 문제 (HashSet 이용한 방법)
		HashSet<Integer> intSet = new HashSet<>();
		intSet.addAll(result1);
		System.out.println(intSet);

		// #1-3번 문제 (오름차순 정렬)
		Collections.sort(result2);
		System.out.println(result2);

		// #1-4번 문제 (내림차순 정렬)
		Collections.sort(result2, Collections.reverseOrder());
		System.out.println(result2);

		System.out.println("\n=============================\n");

		// 1-@ 문제 / a부터 b까지 랜덤 정수를 리턴해주는 메소드
		ArrayList<Integer> result = new ArrayList<>();

		int rand = makeintList(10, 20);
		System.out.print(rand);

		System.out.println("\n=============================\n");

		// #2번 문제

		ArrayList<String> husb = new ArrayList<String>();

		ArrayList<String> wife = new ArrayList<String>();

		wife.add("냉장고");
		wife.add("로봇청소기");
		wife.add("세탁기");
		wife.add("에어컨");

		husb.add("노트북");
		husb.add("TV");
		husb.add("에어컨");
		husb.add("플레이스테이션");
		husb.add("로봇청소기");

		System.out.println(husb);
		System.out.println(wife);

		System.out.println("\n=============================\n");

		// #2-1번 문제
		ArrayList<String> str = new ArrayList<String>();
		for (int i = 0; i < wife.size(); i++) {
			if (husb.contains(wife.get(i))) {
				str.add(wife.get(i));
			}
		}
		System.out.println(str); // 교집합

		System.out.println("\n=============================\n");

		// #2-2번 문제
		ArrayList<String> input = new ArrayList<String>();
		input.addAll(wife);
		// 새로운 리스트 input에 wife 값 복사
		for (int i = 0; i < husb.size(); i++) {
			if (!wife.contains(husb.get(i))) {
				input.add(husb.get(i));
			}
		}
		System.out.println(input); // 합집합

		// 교집합을 위한 .retainAll()
//		str.clear();
//		str.addAll(wife); // 아내의 구매목록을 전부 담기
//		str.retainAll(husb);
//		System.out.println(str); // 중복된 값만 갖게된다.
		
	} // main 끝

	public static int makeintList(int a, int b) {

		int result = 0;
		for (int i = 0; i < 1; i++) {
			int num = (int) (Math.random() * (b - a + 1)) + a;
			result = num;

		}

		return result;
	}

}
