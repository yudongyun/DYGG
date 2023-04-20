package dongyun.submit12;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {

		// 깃허브 테스트 용 주석
		Board boa = Board.getInstance();
		
		// 현재 시간 입력 하기
		
		Date dateToday = new Date(); // 현재시간 데이트 타입 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 새로운 포맷을 적용
		String strToday = sdf.format(dateToday);
		
		
		
		 ArrayList<Board> boardlist = new ArrayList<>();
		 
		 System.out.println(boardlist);
		 
		Scanner scan = new Scanner(System.in);
		 
		while(true) {
			
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
			System.out.print(">>  ");
			
			int select = Integer.parseInt(scan.nextLine());
			
			// 목록
			if(select == 1) { // 글 목록 보기
				for(int i = 0; i < boardlist.size(); i++) {
					System.out.println(boardlist.get(i));
				}
			}
			if(select == 2) {
				System.out.print("글 제목을 입력해주세요 : ");
				String title1 = scan.nextLine();
				System.out.print("글 내용을 입력해주세요 : ");
				String content1 = scan.nextLine();
				
				boardlist.add(new Board(boardlist.size() + 1, title1, strToday, "내용"));
				
			}
			if(select == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

	
}