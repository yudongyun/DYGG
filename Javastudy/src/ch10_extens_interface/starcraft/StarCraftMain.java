package ch10_extens_interface.starcraft;

import java.util.ArrayList;

public class StarCraftMain {

	public static void main(String[] args) {

		Marine marine = new Marine("마린", 6, 50, 0);
		System.out.println(marine);

		marine.move(100, 200);
		marine.stimpack();
		System.out.println(marine);

		Marine marine2 = new Marine();
		System.out.println(marine2);

		Zealot zealot = new Zealot();
		System.out.println(zealot);

		zealot.move(10, 5);

		Zealot zealot2 = new Zealot();
		Zealot zealot3 = new Zealot();
		Zealot zealot4 = new Zealot();
		Zealot zealot5 = new Zealot();
		Zealot zealot6 = new Zealot();

		// 질럿을 드래그로 선택 후 이동 명령 하듯이
		// 코드로 짜기

		ArrayList<Zealot> protossList = new ArrayList<>();

		protossList.add(zealot);
		protossList.add(zealot2);
		protossList.add(zealot3);
		protossList.add(zealot4);
		protossList.add(zealot5);
		protossList.add(zealot6);

		for (int i = 0; i < protossList.size(); i++) {
			protossList.get(i).move(50, 70);
		}

		HighTemplar highTemplar = new HighTemplar();
		System.out.println(highTemplar);

		highTemplar.tthunderStorm();

		// 하이템플러도 같이 드래그해서 이동시키고 싶으나
		// ArrayList<Zealot>에 담기지 않는다
//		protossList.add(highTemplar)

		// 다형성 ( Polymorphism )
		// 하나의 객체가 여러 타입을 가질 수 있는 것
		// 자식 객체에서 부모 객체로 형변환이 가능하다
		StarUnit highTemplar2 = new HighTemplar();
		// 자식에서 부모로의 형변환은 자동 형변환이 된다.
		StarUnit highTemplar1 = highTemplar;

		Object obj = highTemplar2;
		Object temp = new Zealot();

		ArrayList<StarUnit> starList = new ArrayList<>();
		// starunit 이라는 부모 클래스에 담기면서 자동 형변환이 되어 담긴다.

		// starList는 StarUnit의 자식 객체들을 다 담을수 있다.
		starList.add(zealot);
		starList.add(zealot2);
		starList.add(zealot3);
		starList.add(zealot4);
		starList.add(highTemplar);
		starList.add(highTemplar2);
		starList.add(marine);

		for (int i = 0; i < starList.size(); i++) {
			starList.get(i).move(100, 150);

		}

		marine.attack(zealot6);
		System.out.println(zealot6);

		zealot.attack(marine2);
		System.out.println(marine2);

		System.out.println("\n=========================\n");

		// HighTemplar (자식) 이 starunit (부모)로
		// 형변환이 되어 있기 때문에 부모가 가지고 있지 않은 메소드를 사용못함
//		starList.get(4)tthunderStorm();

		// 자식 -> 부모 상태인 객체를
		// 부모 -> 자식 형변환 한 후 자식의 메소드 사용

		// 부모 -> 자식 형식은 자동 형변환이 안됨
		// 강제로 형변환을 시켜줘야함
		HighTemplar welcome = (HighTemplar) starList.get(4);
		welcome.tthunderStorm();

//		((HighTemplar)starList.get(4)).tthunderStorm(); 이렇게도 표현 가능

		// for 문을 돌려서 이 객체가 원래는 하이템플러 였다면
		// 썬더스톰을 쓰도록 하기

		// 하이템플러 -> 스타유닛 -> 하이템플러 (o)
		// 하이템플러 -> 스타유닛 -> 질럿, 마린 (x)
//		((HighTemplar)starList.get(0)).move(5, 5); 이렇게하면 오류남

		for (int i = 0; i < starList.size(); i++) {
			if (starList.get(i).getName().equals("하이템플러")) {
				((HighTemplar) starList.get(i)).tthunderStorm();
			}

			// 객체 instanceof 클래스
			// 좌측의 객체가 우측의 클래스로 형변환이 가능하다면
			// true, 불가능하면 false 리턴

			if (starList.get(i) instanceof HighTemplar) {
				((HighTemplar) starList.get(i)).tthunderStorm();

			}

		}

		for (int i = 0; i < starList.size(); i++) {
			if (starList.get(i) instanceof Marine) {
				((Marine) starList.get(i)).stimpack();
			}
		}
		
		// 부모 객체
		StarUnit scv = new StarUnit("SCV", 5, 60, 0);
		
		// 일반적으로 부모 객체는 자식 객체로 형변환 할 수 없다.
		System.out.println(scv instanceof Zealot); // 일반적으로 안되서 false 뜸
		// 자식이 가지고 있는 옵션이 더 많기 때문에
		
		// 자식 객체는 부모 객체로 형변환이 가능하다.
		System.out.println(zealot instanceof StarUnit); // 되니까 true 뜸
		
		// 부모 객체로 형변환 되었던 자식 객체는
		// 다시 자식 타입으로 형변환이 가능하다.
		System.out.println(starList.get(0) instanceof Zealot); // true
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
