package dongyun.submit09;

import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {

	private String name;
	private ArrayList<Coffee> menuList;

	public Cafe() {
	}

	public Cafe(String name) {
		this.name = name;
		menuList = new ArrayList<>();
	}

	// 커피 메뉴를 추가한다.
	public void addCoffee(Coffee cf) {
		menuList.add(cf);
	}

	// 메뉴판을 출력하는 메소드
	public void showMenu() {
		for (int i = 0; i < menuList.size(); i++) {
			System.out.println((i + 1) + ". " + menuList.get((i)));
		}
	}

	// 커피 구매
	public void buycoffee(Scanner sc) {

		System.out.print("메뉴를 선택해주세요.");
		int choice = Integer.parseInt(sc.nextLine());
		// 해당 인덱스
		System.out
				.println(menuList.get(choice - 1).getName() + "를" + menuList.get(choice - 1).getPrice() + "원에 구매했습니다.");
	}

	public Cafe(String name, ArrayList<Coffee> menuList) {
		super();
		this.name = name;
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		return "Cafe [name=" + name + ", menuList=" + menuList + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Coffee> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<Coffee> menuList) {
		this.menuList = menuList;
	}

}
