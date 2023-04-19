package ch09_class.homepage;

import java.util.Scanner;

public class HomepageMain {

	public static void main(String[] args) {
		// 회원가입, 로그인
		// 회원 : 학번, 아이디, 비밀번호, 이름

		MemberDB memDB = MemberDB.getInstance();

		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
			System.out.print(">>> ");
			int command = Integer.parseInt(scan.nextLine());

			if (command == 1) {
				// TODO 회원가입
				System.out.println("아이디를 입력해주세요");
				System.out.print(">>> ");
				String id = scan.nextLine();

				System.out.println("비밀번호를 입력해주세요");
				System.out.print(">>> ");
				String pw = scan.nextLine();

				System.out.println("이름을 입력해주세요");
				System.out.print(">>> ");
				String name = scan.nextLine();

				Member mem = new Member(id, pw, name);
				memDB.registMember(mem);

			} else if (command == 2) {
				// TODO 로그인
				System.out.println("아이디를 입력해주세요");
				System.out.print(">>> ");
				String id = scan.nextLine();

				System.out.println("비밀번호를 입력해주세요");
				System.out.print(">>> ");
				String pw = scan.nextLine();

				Member login = memDB.login(id, pw);

				if (login != null) {
					// 로그인 성공
					System.out.println("로그인 성공!!");
					System.out.println(login.getName() + "님 환영합니다.");
				} else {
					// 로그인 실패
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}

			} else if (command == 3) {
				// 회원목록조회
				memDB.showMemList();

			} else {
				// 종료
				System.out.println("종료");
				break;
			}

		}

	}

}
