package ch14_jdbc_jsp.main;

import java.util.ArrayList;
import java.util.Scanner;

import ch14_jdbc_jsp.service.StudentService;
import ch14_jdbc_jsp.service.WordGameService;
import ch14_jdbc_jsp.vo.StudentVO;
import ch14_jdbc_jsp.vo.WordGameVO;

public class JdbcMain {

	public static void main(String[] args) {

		StudentService stuService = StudentService.getInstance();

		System.out.println("\n" + " _   __                            ______         _____        \n"
				+ "| | / /                            | ___ \\       |  __ \\       \n"
				+ "| |/ /   ___    ___   _ __    __ _ | |_/ /  __ _ | |  \\/  ___  \n"
				+ "|    \\  / _ \\  / _ \\ | '_ \\  / _` ||  __/  / _` || | __  / _ \\ \n"
				+ "| |\\  \\| (_) || (_) || | | || (_| || |    | (_| || |_\\ \\| (_) |\n"
				+ "\\_| \\_/ \\___/  \\___/ |_| |_| \\__, |\\_|     \\__,_| \\____/ \\___/ \n"
				+ "                              __/ |                            \n"
				+ "                             |___/                             \n" + "");

		System.out.println("쿵파고에 오신걸 환영합니다.");
		System.out.println("데이터 불러 오는중 .. ");

		WordGameService wordService = WordGameService.getInstance();

		ArrayList<WordGameVO> wordGameList = wordService.getWordList();

//		wordGameList.get(0).getWords(); // 이렇게 해야 단어가 나옴

		ArrayList<String> wordList = new ArrayList<>(); // 배열은 만들어서 옮겨주자

		for (int i = 0; i < wordGameList.size(); i++) {
			wordList.add(wordGameList.get(i).getWords()); // 리스트에 추가하기
		}

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원목록 | 4. 종료");
			System.out.print(">> ");

			int command = 0;
			try {
				command = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요");
				continue;
			}

			if (command == 1) {
				// 로그인
				System.out.print("아이디 : ");
				String id = scan.nextLine();

				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();

				StudentVO student = new StudentVO();
				student.setStuId(id);
				student.setStuPassword(pw);

				StudentVO login = stuService.login(student);

				if (login.getStuId() != null) {
					// 로그인 성공
					System.out.println(login.getStuName() + "님 환영합니다.");

					// 끝말잇기 시작
					while (true) {
						System.out.println("행동을 선택해주세요");
						System.out.println("1. 끝말잇기 시작 | 2. 랭킹 | 3. 로그아웃");
						System.out.print(">> ");

						int select = 0;
						try {
							select = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자로 입력해주세요");
							continue;
						}

						if (select == 1) {
							// TODO 끝말잇기 시작

							// 제시어 출력
							// wordList에서 랜덤 인덱스의 단어를 하나 출력하면 된다.
							int randIdx = (int) (Math.random() * wordList.size());
							String computerWord = wordList.get(randIdx); // 제시어
							System.out.println("제시어 : " + computerWord);

							while (true) { // 쿵쿵따 반복하기
								System.out.print(">>> ");
								String userWord = scan.nextLine(); // 제시어에 대한 답

								// 조건 체크 !!
								// 1. userWord가 wordList 안에 포함 되어 있는지 체크
								// 2. userWord의 앞글자가 computerWord의 뒷글자와 같은지 체크

								boolean checkOne = wordList.contains(userWord); // true, false
								boolean checkTwo = userWord.substring(0, 1)
										.equals(computerWord.substring(computerWord.length() - 1)); // 컴퓨터가 답한 말의 길이에 -1

								if (checkOne && checkTwo) {
									// 잘 대답함

									// 컴퓨터가 userWord 에 대해 끝말잇기를 진행
									// userWord의 마지막 글자로 시작하는 단어들을
									// wordList 에서 꺼내기 ( 컴퓨터가 대답할수 있는 단어들의 목록 )
									ArrayList<String> comAnswerList = new ArrayList<>();

									for (int i = 0; i < wordList.size(); i++) {
//										userWord.substring(userWord.length()-1) // 유저의 마지막 글자
//										wordList.get(i).substring(0, 1) // wordList의 맨 앞글자
										if (userWord.substring(userWord.length() - 1)
												.equals(wordList.get(i).substring(0, 1))) {
											comAnswerList.add(wordList.get(i)); // 맞다면 컴퓨터가 대답할수 있는 목록에 추가시킨다.
										}
									}

									// 대답할 수 있는 목록의 개수가 0이면 컴퓨터 패배
									if (comAnswerList.size() == 0) {
										// TODO 컴퓨터 패배, 로그인한 사람의 점수 + 1
										System.out.println("내가 승리한 것이지 인간이 승리한게 아냐");
										stuService.plusScore(login.getStuId());
										break;
									} else {
										// 대답할 수 있는 목록에서 랜덤 인덱스를 꺼내서 제시어로 표현
										int randNum = (int) (Math.random() * comAnswerList.size());
										computerWord = comAnswerList.get(randNum);
										System.out.println(computerWord + "  쿵쿵따 !!");

									}

								} else {
									// 틀림 ( 게임 오버 )
									System.out.println("인간이 패배한 것이지 내가 패배한게 아냐");
									break;
								}

							}

						} else if (select == 2) {
							// TODO 랭킹
							ArrayList<StudentVO> stuList = stuService.getStuList();
							for (int i = 0; i < stuList.size(); i++) {
								System.out.println((i + 1) + "등. " + stuList.get(i).getStuName() + " | "
										+ stuList.get(i).getStuScore());
							}

						} else if (select == 3) {
							break;
						} else {
							System.out.println("다시 입력해주세요");
						}

					}

				} else {
					// 로그인 실패
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}

				// TODO 끝말잇기 시작

				// vo 만들고 (select 문 매핑 객체)
				// dao 만들고 (쿼리문 작성)
				// service 만들고 (dao 메소드 실행)

			} else if (command == 2) {
				// 회원가입
				System.out.print("아이디 : ");
				String id = scan.nextLine();

				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();

				System.out.print("닉네임 : ");
				String name = scan.nextLine();

				// 기존방식
//				stuService.registStudent(id, pw, name);

				StudentVO stu = new StudentVO(id, pw, name, 0);
				stuService.registStudent(stu);

			} else if (command == 3) {
				// 회원목록 조회
				ArrayList<StudentVO> stuList = stuService.getStuList();
				for (int i = 0; i < stuList.size(); i++) {
					System.out.println(stuList.get(i));
				}

			} else if (command == 4) {
				// 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}

		}

	}

}
