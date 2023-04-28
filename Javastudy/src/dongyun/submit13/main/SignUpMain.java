package dongyun.submit13.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dongyun.submit13.dao.BoardDAO;
import dongyun.submit13.service.BoardService;
import dongyun.submit13.service.SignUpService;
import dongyun.submit13.vo.BoardVO;
import dongyun.submit13.vo.SignUpVO;

public class SignUpMain {

	public static void main(String[] args) {

		SignUpService signservice = SignUpService.getInstance();

		BoardService boardService = BoardService.getInstance();
//		BoardDAO boardService2 = BoardDAO.getInstance();

		Scanner scan = new Scanner(System.in);

		// 현재 시간 추출하기
		Date dateToday = new Date(); // 현재시간 데이트 타입 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 새로운 포맷을 적용
		String strToday = sdf.format(dateToday);

		while (true) {
			System.out.println("행동을 선택하세요");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
			System.out.print("입력 : ");

			int select = 0;

			try {
				select = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 정확히 입력하세요.");
				continue;
			}

			if (select == 1) {
				// 회원가입 하기
				System.out.println("사용 할 ID : ");
				String id = scan.nextLine();

				System.out.println("사용 할 PW : ");
				String pw = scan.nextLine();

				signservice.regiSignup(id, pw);

			}

			if (select == 2) {
				// 로그인 하기
				System.out.println("아이디 : ");
				String id = scan.nextLine();

				System.out.println("비밀번호 : ");
				String pw = scan.nextLine();

				SignUpVO sign = new SignUpVO();
				sign.setId(id);
				sign.setPassword(pw);

				SignUpVO login = signservice.login(sign);

				if (login.getId() != null) {
					// 로그인 성공
					System.out.println(login.getId() + "님 환영합니다.");

					ArrayList<BoardVO> bodList = boardService.getBodList();

					for (int i = 0; i < bodList.size(); i++) {
						System.out.println("[ " + bodList.get(i).getNo() + ". |" + bodList.get(i).getTitle() + " | "
								+ bodList.get(i).getContent() + " | " + bodList.get(i).getAuthor() + " | "
								+ bodList.get(i).getDate() + "]");
					}

					// 글 작성 시작하기
					while (true) {
						System.out.println("행동을 선택해주세요");
						System.out.println("1. 글 쓰기 | 2. 글 조회 | 3. 로그아웃");
						System.out.print("입력 : ");

						int command = 0;
						int command2 = 0;

						try {
							command = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자를 입력하라..");
							continue;
						}

						if (command == 1) {
							// 글 쓰기

							System.out.print("글 제목을 입력해주세요 : ");
							String title1 = scan.nextLine();
							System.out.print("글 내용을 입력해주세요 : ");
							String content1 = scan.nextLine();

							boardService.saveBoard(title1, content1, login.getId(), strToday);

						} else if (command == 2) {
							// 글 조회하기

							System.out.println("조회 할 글 번호를 입력하세요");
							System.out.print("입력 : ");

							int num = Integer.parseInt(scan.nextLine());

							for (int i = 0; i < bodList.size(); i++) {
								if (num == bodList.get(i).getNo()) {
									System.out.println("\n=======================\n");
									System.out.println("제목 : " + bodList.get(i).getTitle());
									System.out.println("작성자 : " + bodList.get(i).getAuthor());
									System.out.println("작성일 : " + bodList.get(i).getDate());
									System.out.println("내용 : " + bodList.get(i).getContent());
									System.out.println("\n=======================\n");
								}

							}

						} else if (command == 3) {
							// 로그아웃
							break;
						} else {
							System.out.println("재 입력 해주세요.");
						}

					}
//////////////////////////////////////////////////////////////////////////////////////////

				} else {
					// 로그인 실패
					System.out.println("아이디 혹은 비밀번호를 다시 입력하세요");
				}

			}
			if (select == 3) {
				System.out.println("프로그램 종료");
				break;
			}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		}

	}

}