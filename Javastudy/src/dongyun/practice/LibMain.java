package dongyun.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class LibMain {

	public static void main(String[] args) {

		Lib library = Lib.getInstance();

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해라");
			System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4.책 검색 | 5.종료");
			System.out.print(">>  ");

			int select = Integer.parseInt(scan.nextLine());

			if (select == 1) { // 책 입고
				System.out.println("책 번호를 입력해주세요");
				System.out.print(">>  ");

				int no = Integer.parseInt(scan.nextLine());

				library.inBook(no);
			} else if (select == 2) { // 책 대여
				System.out.println("책 이름을 입력해주세요");
				System.out.print(">>  ");

				String name = scan.nextLine();
				
				
				ArrayList<books> searchBookList = library.searchBookList(name);
				
				if(searchBookList.size() == 0) {
					System.out.println("해당 책이 존재하지 않습니다.");
				}else if(searchBookList.size() == 1) {
					library.useBook(searchBookList.get(0).getBooknum());
				}else {
					library.searchBookList(name);
					System.out.println("책 번호를 입력해주세요");
					System.out.print(">>  ");
					
					int no = Integer.parseInt(scan.nextLine());
					
					library.useBook(no);
				}
				
				
				
			} else if (select == 3) { // 책 목록
				System.out.println("책 목록입니다.");
				library.showBookList();

			} else if (select == 4) { // 책 검색
				System.out.println("책 이름을 입력해주세요");
				System.out.print(">>  ");

				String keyword = scan.nextLine();

				library.searchBookList(keyword);
			}else {
				System.out.println("종료합니다");
				break;
			}
		}

	}

}
