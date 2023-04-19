package dongyun.submit08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class submit08 {

	public static void main(String[] args) {

//		makeLotto를 ArrayList와 HashSet을 이용해서 만들어보세요
//
//
//		Hint
//		먼저 빈 HashSet을 하나 만들고, while문 내에서 빈 HashSet에 랜덤 로또 번호를 HashSet의 사이즈가 6개가 될 때까지 넣는다.
//		이후 HashSet을 ArrayList로 변환한 다음, 오름차순으로 ArrayList를 정렬하여 리턴한다.
		
		// #1번 문제
		ArrayList<Integer> mylotto = makeLotto();
		System.out.println(mylotto);
		
		
		
		// #2번 문제
		
		HashMap<String, String> infoMap = new HashMap<>();
		
		infoMap.put("a001", "1234a");
		infoMap.put("b001", "1234b");
		infoMap.put("c001", "1234c");
		infoMap.put("d001", "1234d");
		infoMap.put("e001", "1234e");
		
		
		
		

//사용자가 아이디와 비밀번호를 파라미터로 넣었을때, 
//infoMap의 Key(아이디)와 Value(비밀번호)와 비교하여
//
//아이디와 비밀번호가 infoMap 내에 존재하는 데이터와 일치하면 로그인 성공 출력
//아이디가 존재하지 않으면, 존재하지 않는 아이디입니다. 출력 
//아이디는 존재하지만 비밀번호가 일치하지 않으면 비밀번호가 틀렸습니다. 출력
		
		Scanner scan = new Scanner(System.in);
		
		
			System.out.println("아이디를 입력해주세요");
			System.out.print(">>>    ");
			String ID = scan.nextLine();
			// ID 입력값 받기
			
			System.out.println("비밀번호를 입력해주세요");
			System.out.print(">>>    ");
			String PW = scan.nextLine();
			// PW 입력값 받기
			
//			// 입력한 id가 key값 중에 존재하면 true, 없으면 false
//			infoMap.containsKey(id)
//			
//			// 입력한 id가 key값 중에 존재하면 value, 없으면 null
//			// 입력한 id가 key값 중에 존재하면 null이 아님, 없으면 null
//			infoMap.get(id)
			
				if(infoMap.containsKey(ID)) {
					if(!infoMap.get(ID).equals(PW)) {
						System.out.println("비밀번호가 틀렸습니다");
					}else {
						System.out.println("로그인 성공");
					}
					
				}else {
					System.out.println("존재하지 않는 아이디 입니다");
				}
				
			
			
			
			
		
		
		
		
		
		
		
		
		
	} //main 끝 지점
	public static ArrayList<Integer> makeLotto(){
		
		HashSet<Integer> lotto = new HashSet<>();
		
		ArrayList<Integer> intList = new ArrayList<>(); 
		
		outer : while(true) {
			int rand = (int) (Math.random() * 45) + 1;
			lotto.add(rand);
			if(lotto.size() == 6) {
				break;
			}
			
			
			
		}
		
		intList.addAll(lotto);
		
		Collections.sort(intList);
		
		return intList;
		
	}
	
	
	
	
	
	
	
	
	
}
