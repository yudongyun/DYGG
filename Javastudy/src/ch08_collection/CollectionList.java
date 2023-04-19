package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

public class CollectionList {

	public static void main(String[] args) {
		// 리스트의 선언 ( ArrayList )
		// 1.
		ArrayList<String> students = new ArrayList<String>();
		// <String> 이 부분을 제너릭(Generic) 이라고 부른다.

		// 2. 오른쪽에 제너릭은 생략이 가능하다.
		ArrayList<String> strList = new ArrayList<>();

		// Collection 들은 객체만 담을 수 있다.
		// 참조타입들 = 객체
		ArrayList<Integer> intList = new ArrayList<>();

		// int 쓰면 안되서 Integer로 써야한다
		// Wrapper Class
		// 기본 타입의 데이터를 객체(참조타입)로
		// 사용해야 하는 경우 사용

		int num = 12;

		// 얘를 기본타입의 데이터를 Wrapper 클래스 객체로 변환
		// = 박싱(boxing)
		Integer numClass = new Integer(num);
		System.out.println(numClass);

		// 오토 박싱(auto boxing)
		Integer autoNum = num;
		System.out.println(autoNum);

		// Wrapper 클래스 객체에 저장된 값을
		// 기본 타입의 데이터로 꺼내기
		// = 언박싱(unboxing)

		int temp = autoNum.intValue();
		System.out.println(temp);

		// 오토 언박싱
		int autoTemp = autoNum;

		// 한줄요약
		// 오토 박싱과 언박싱이 알아서 잘 되므로,
		// 우리가 Wrapper 클래스를 사용하는데 불편함은 없다.

		System.out.println("\n--------------\n");

		// .size()
		// 담고 있는 데이터 수 리턴 ex) length()
		System.out.println(intList); // 아무것도 없음
		System.out.println(intList.size()); // 아무것도 없어서 size가 0 임

		// .add()
		// ArrayList 에 값 담기
		intList.add(5);
		System.out.println(intList.size()); // 5라는 데이터를 1개 담았기 때문에 1 리턴

		intList.add(1); // 값을 하나씩 넣어야함
		intList.add(2);
		intList.add(3);
		intList.add(4);

		// syso에 컬렉션 객체를 넣으면, 자동으로 내부 값이 출력된다.
		System.out.println(intList);

		students.add("동윤");
		students.add("민기");
		students.add("성복");
		students.add("창연");
		students.add("혜라");

		System.out.println(students);

		// 제너릭<> 타입과 일치하는 데이터만 추가를 할수 있다.
//		students.add(13); // 이렇게하면 안들어가짐

		System.out.println("\n--------------\n");

		// .get(인덱스)
		// 해당 인덱스의 값을 리턴함

		System.out.println(students.get(0));

		// .set(인덱스, 값)
		// 해당 인덱스의 값을 괄호 안 값으로 변경함
		students.set(2, "유정");
		System.out.println(students);

		// .contains(값)
		// 리스트 안에 해당 값이 존재하면 true 리턴
		// 존재하지 않으면 false 리턴
		System.out.println(students.contains("유정")); // true로 출력

		// .indexOf(값)
		// 리스트 안에 해당 값이 인덱스 몇번에 존재하는지 리턴
		// 존재하면 해당 인덱스를 리턴, 없다면 -1을 리턴함
		// -1 리턴 여부로 contains 처럼 사용이 가능하다.
		System.out.println(students.indexOf("창연") != -1);

		// .isEmpty()
		// 리스트가 비어있는지 체크
		// 비어있다면 true / 아니라면 false 리턴
		// .size() == 0 와 같다
		System.out.println(students.isEmpty());
		System.out.println(students.size() == 0);

		// .remove(인덱스)
		// 해당 인덱스의 값을 삭제한다.
		students.remove(3);
		System.out.println(students);

		// .remove(값)
		// 리스트에 해당 값이 있으면 삭제도 한다
		students.remove("민기");
		System.out.println(students);

		// 리스트에 없는 값을 삭제하면 ?
		students.remove("아무말");
		System.out.println(students); // 아무일도 일어나지 않는다.

		// .clear()
		// 리스트를 비움(size가 0이 된다)
		students.clear();
		System.out.println(students);

		// 초기화해도 리스트를 비울 수 있다.
		intList = new ArrayList<>(); // 새로 만드는거랑 비슷하게 비어있는상태로 출력된다 ( 초기화 )
		System.out.println(intList);

		System.out.println("\n--------------\n");

		students.add("동윤");
		students.add("민기");
		students.add("성복");
		students.add("창연");
		students.add("혜라");

		System.out.println(students);

		// for문으로 리스트 내 데이터 처리
		// 모든 요소에 넘버링을 추가한다 ( 1. 동윤, 2. 민기 )

		for (int i = 0; i < students.size(); i++) {
			students.set(i, (i + 1) + ". " + students.get(i));
		}
		System.out.println(students);

		System.out.println("\n--------------\n");

		// 리스트 복사
		ArrayList<String> copyList = new ArrayList<>();
		// students 의 모든 값들이 copyList에 담긴다.
		copyList.addAll(students);
		System.out.println(copyList);

		// 리스트 복사2
		ArrayList<String> copyList2 = new ArrayList<>(students);
		System.out.println(copyList2);

		// 리스트 복사3
		ArrayList<String> copyList3 = new ArrayList<>();
		for (int i = 0; i < students.size(); i++) {
			copyList3.add(students.get(i));
		}
		System.out.println(copyList3);

		System.out.println("\n--------------\n");

		// 향상된 for문
		// (= 일반적으로 말하는 foreach문)
		for (String stu : students) { // students 에 있는 모든 값이 stu에 담김 / 그걸 출력함
			System.out.println(stu);
		}

		// 인덱스가 존재하는 ArrayList에서는
		// 향상된 for문의 사용이 큰 메리트가 있지는 않다.

		System.out.println("\n--------------\n");

		// 자바의 forEach문 (우엑)

		students.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}

		});

		// 람다식으로 사용하기
		students.forEach(t -> System.out.println(t));

		// 람다식인데 명령어가 여러줄이면
		// 중괄호 블록 만들어주어야 한다.
		students.forEach(t -> {
			System.out.println(t);
			System.out.println(t);
		});

		System.out.println("\n--------------\n");

		// 값을 주면서 리스트 선언
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(30, 23, 1, 44, 52));
		System.out.println(numbers);

		// 정렬
		// 오름차순
		Collections.sort(numbers);
		System.out.println(numbers);

		// 내림차순
		Collections.sort(numbers, Collections.reverseOrder());
		System.out.println(numbers);

		// 버블정렬
		for (int k = 0; k < numbers.size() - 1; k++) {

			for (int i = 0; i < numbers.size() - 1; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (numbers.get(i) > numbers.get(i + 1)) {

					int t = numbers.get(i);
					numbers.set(i, numbers.get(i + 1));
					numbers.set(i + 1, t);
				}
			}

		}
		System.out.println(numbers);
	}

}
