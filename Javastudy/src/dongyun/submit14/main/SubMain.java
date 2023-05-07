package dongyun.submit14.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dongyun.submit14.service.BoardReviewService;
import dongyun.submit14.service.FreeBoardService;
import dongyun.submit14.service.MemberService;
import dongyun.submit14.vo.BoardReviewVO;
import dongyun.submit14.vo.FreeBoardVO;
import dongyun.submit14.vo.MemberVO;

public class SubMain {

	public static void main(String[] args) {

		MemberService memservice = MemberService.getInstance();

		FreeBoardService freesevice = FreeBoardService.getInstance();

		BoardReviewService reviewservice = BoardReviewService.getInstance();

		// 현재 시간 추출하기
		Date dateToday = new Date(); // 현재시간 데이트 타입 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 새로운 포맷을 적용
		String strToday = sdf.format(dateToday);

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("넥스트 중고나라에 오신걸 환영합니다.");
			System.out.println("1. Sign up | 2. Login | 3. exit");
			System.out.print(">> ");

			int select = 0;

			try {
				select = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 정확히 입력해주세요");
				continue;
			}

			if (select == 1) {
				// sign up
				System.out.println("사용 할 ID : ");
				String id = scan.nextLine();

				System.out.println("사용 할 PW : ");
				String pw = scan.nextLine();

				System.out.println("사용 할 name : ");
				String name = scan.nextLine();

				memservice.newMember(id, pw, name);

			}

			if (select == 2) {
				// login
				System.out.println("아이디 : ");
				String id = scan.nextLine();

				System.out.println("비밀번호 : ");
				String pw = scan.nextLine();

				MemberVO mem = new MemberVO();
				mem.setId(id);
				mem.setPw(pw);

				MemberVO login = memservice.login(mem);

				if (login.getId() != null) {
					// login success !
//					ArrayList<FreeBoardVO> boardList = freesevice.FreeBoardList();
//					ArrayList<FreeBoardVO> boardList = freesevice.FreeBoardList();

					ArrayList<FreeBoardVO> myBoardList = new ArrayList<FreeBoardVO>();

					System.out.println(login.getName() + "님 환영합니다.");

					while (true) {
						ArrayList<FreeBoardVO> boardList = freesevice.FreeBoardList();

//						for (int i = 0; i < boardList.size(); i++) {
//							System.out.println("▶ " + boardList.get(i).getNo() +  " | "
//									+ boardList.get(i).getTitle() + " | " + "추천수 : " + boardList.get(i).getLike() + " | " + boardList.get(i).getDate());
//						}
						System.out.println("행동을 선택해주세요");
						System.out
								.println("1. 글 작성 | 2. 글 조회 | 3. 게시글 삭제 | 4. 로그아웃 | 5. 게시글 검색 | 6. 게시글 수정 | 7. 정보 조회");
						System.out.print("입력 : ");

						int comm = 0;

						try {
							comm = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자만 입력해주세요");
							continue;
						}
						if (comm == 1) {
							// 판매 글 작성하기

							System.out.println("글 제목을 입력해주세요");
							System.out.print(">> ");
							String title = scan.nextLine();
							System.out.println("글 내용을 입력해주세요");
							System.out.print(">> ");
							String content = scan.nextLine();

							freesevice.freesave(title, content, login.getId(), strToday);

						} else if (comm == 2) {
							// 글 조회하기
							for (int i = 0; i < boardList.size(); i++) {
								System.out.println("▶ " + boardList.get(i).getNo() + " | " + boardList.get(i).getTitle()
										+ " | " + "추천수 : " + boardList.get(i).getLike() + " | "
										+ boardList.get(i).getDate());
							}

							System.out.println("조회 할 글 번호를 입력하세요");
							System.out.print("입력 : ");

							int click = 0;

							try {
								click = Integer.parseInt(scan.nextLine());
							} catch (NumberFormatException e) {
								System.out.println("글 번호를 정확히 입력해주세요");
								continue;
							}

							ArrayList<BoardReviewVO> boardreview = reviewservice.reviewList(click);

							// 돌아가기

							// 글 내용을 출력하기
							for (int i = 0; i < boardList.size(); i++) {
								if (click == boardList.get(i).getNo()) {
									System.out.println("");
									System.out.println("==========================");
									System.out.println("작성자 : " + boardList.get(i).getAuthor());
									System.out.println("추천수 : " + boardList.get(i).getLike());
									System.out.println("작성일 : " + boardList.get(i).getDate());
									System.out.println("제목 : " + boardList.get(i).getTitle());
									System.out.println("--------------------------");
									System.out.println("내용 : " + boardList.get(i).getContent());
									System.out.println("--------------------------");
									System.out.println("");
								}
							}

							// 해당 글의 댓글들을 출력하기
							for (int i = 0; i < boardreview.size(); i++) {

								if (click == boardreview.get(i).getFbNumber()) {
									System.out.println("==========================");
									System.out.println("[ " + boardreview.get(i).getBrAuthor() + " >> "
											+ boardreview.get(i).getBrContent() + " | " + boardreview.get(i).getBrDate()
											+ "]");
									System.out.println("");
								}

							}

							System.out.println("1. 댓글 작성한다 | 2. 추천하기 | 3. 취소");
							System.out.print("입력 : ");

							int click2 = Integer.parseInt(scan.nextLine());

							if (click2 == 1) {
								// 댓글 남기기
//								System.out.println("댓글 제목을 입력해주세요");
//								System.out.print(">> ");
//								String title = scan.nextLine();
								System.out.println("댓글 내용을 입력해주세요");
								System.out.print(">> ");
								String content = scan.nextLine();

								reviewservice.reviewSave(click, content, login.getId(), strToday);
							} else if (click2 == 2) {
								// 해당 글 추천하기
								int result = freesevice.freeLike(click);

								if (result > 0) {
									System.out.println("해당 게시글을 추천했습니다");
								} else {
									System.out.println("추천을 실패했습니다.");
								}

							} else if (click2 == 3) {
								// 취소
								break;
							}

						} else if (comm == 3) {
							// 게시글 삭제하기

							System.out.println("삭제 할 글 번호를 입력하세요");
							System.out.print("입력 : ");

							int click = Integer.parseInt(scan.nextLine());

							// 댓글을 삭제한다.
							int reviewrst = reviewservice.reviewDelete(click);

//							if (reviewrst >= 1) {
//								System.out.println("해당 댓글이 삭제되었습니다.");
//							}

							// 게시글을 삭제한다
							int rst = freesevice.freeDelete(click);

							if (rst >= 1) {
								System.out.println(click + "번째 글과 댓글이 삭제 되었습니다.");
							} else {
								System.out.println("글 번호를 정확히 입력해주세요");
							}

						} else if (comm == 4) {
							// 로그아웃
							break;
						} else if (comm == 5) {
							// 게시글 검색

							System.out.println("검색어를 입력하세요");
							System.out.print("입력 : ");
							String keyword = scan.nextLine();

							boolean found = false; // 검색어를 포함하는 게시글이 있는지 여부를 저장하는 변수

							for (int i = 0; i < boardList.size(); i++) {
								if (boardList.get(i).getTitle().contains(keyword)) {
									// 검색어가 제목에 포함되어 있으면 출력
									System.out.println("[ no. " + boardList.get(i).getNo() + ". | "
											+ boardList.get(i).getTitle() + " | " + boardList.get(i).getDate() + " ]");
									found = true;
								}
							}

							if (!found) {
								System.out.println("검색 결과가 없습니다.");
							}
							break;

						} else if (comm == 6) {
							// 게시글 수정하기
							System.out.println("수정 할 글 번호를 입력하세요");
							System.out.print("입력 : ");

							int click = Integer.parseInt(scan.nextLine());

							boolean isExist = false;

							for (int i = 0; i < boardList.size(); i++) {
								if (click == boardList.get(i).getNo()) {
									isExist = true;
									System.out.println("수정 할 제목을 입력해주세요");
									System.out.print(">> ");
									String title = scan.nextLine();

									System.out.println("수정 할 내용을 입력해주세요");
									System.out.print(">> ");
									String content = scan.nextLine();

									// 게시글 수정
									freesevice.freeUpdate(click, title, content, strToday);
									System.out.println("게시글이 수정되었습니다.");
									break;
								}
							}

							if (!isExist) {
								System.out.println("글 번호를 정확히 입력해주세요");
							}

						} else if (comm == 7) {
							// 정보조회

							System.out.println("조회할 ID 를 입력하세요");
							System.out.print(">>  ");
							String searchId = scan.nextLine();

							memservice.showpro(searchId);

							// 내가 작성한 글 목록 보기

							// 내가 작성한 댓글 목록 보기

						}

						else {
							System.out.println("다시 입력해주세요");
						}

					}

				}

			}

			if (select == 3) {
				// exit
				System.out.println("프로그램 종료");
				break;
			}

		}
	}

}
