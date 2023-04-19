package dongyun.submit12;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {

		
		 ArrayList<Board> boardlist = new ArrayList<>();
		
		 System.out.println(boardlist);
		 
		 
		 
		Scanner scan = new Scanner(System.in);
		 
		while(true) {
			
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
			System.out.print(">>  ");
			
			int select = Integer.parseInt(scan.nextLine());
			
			// 목록
			if(select == 1) {
				
				for(int i = 0; i < boardlist.size(); i++) {
					System.out.println(boardlist.get(i));
				}
				
				
			}
			
			if(select == 2) {
				
				
				
				
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
