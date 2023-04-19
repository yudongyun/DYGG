package dongyun.submit09;

import java.util.ArrayList;

import ch09_class.school.Student;

public class ProductMain {

	public static void main(String[] args) {
		
		// #1-2번 문제
		product himartCool = new product("냉장고", 2000000);
		product himartAir = new product("에어컨", 800000);
		product himartTv = new product("TV", 1000000);
		product himartCom = new product("컴퓨터", 1300000);
		product himartSun = new product("선풍기", 100000);

//		System.out.println(himartCom);

		// #1-3번 문제 
		ArrayList<product> HI = new ArrayList<>();

		HI.add(himartSun);
		HI.add(himartAir);
		HI.add(himartTv);
		HI.add(himartCom);
		HI.add(himartCool);

//		System.out.println(HI.get(1));

//		System.out.println(HI.get(2));
		
//		System.out.println(HI.size());
		
		
		
		
		System.out.println("\n===============================\n");
		
		
		for (int k = 0; k < HI.size() - 1; k++) {

			for (int i = 0; i < HI.size() - 1; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (HI.get(i).getPrice() < HI.get(i + 1).getPrice()) {
					product t = HI.get(i);
					HI.set(i, HI.get(i + 1));
					HI.set(i + 1, t);
				}
			}
		}
		for (int i = 0; i < HI.size(); i++) {
			System.out.println(HI.get(i));
		}
		
		System.out.println("\n===============================\n");
		
		
		// #2번 문제
		for(int i = 0; i < HI.size(); i++) {
			if(HI.get(i).getName().equals("TV")) {
				System.out.println(HI.indexOf(HI.get(i)));
			}
		}
		
		for(int i = 0; i < HI.size(); i++) {
			if(HI.get(i).getName().equals("TV")) {
				System.out.println(i);
			}
			
		}
		
		
		// #@문제
//		public class CafeMain {
//			public static void main(String[] args) {
//				Cafe starBucks = new Cafe("스타벅스");
//				starBucks.addCoffee(new Coffee("아메리카노", 5000));
//				starBucks.addCoffee(new Coffee("카푸치노", 6000));
//				starBucks.addCoffee(new Coffee("오곡라떼", 7000));
//				
//				Cafe conte = new Cafe("꽁떼");
//				conte.addCoffee(new Coffee("아메리카노", 2500));
//				conte.addCoffee(new Coffee("바닐라라떼", 3000));
//				conte.addCoffee(new Coffee("아이스티", 3500));
//				
//				Scanner sc = new Scanner(System.in);
//				
//				while(true) {
//					System.out.println("행동을 선택해주세요.");
//					System.out.println("1. 스타벅스 방문 | 2. 꽁떼 방문 | 3. 사무실 복귀..");
//					System.out.print(">>> ");
//					int select = Integer.parseInt(sc.nextLine());
//					
//					// 코드 작성 시작	
//				}
//				
//			}
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
