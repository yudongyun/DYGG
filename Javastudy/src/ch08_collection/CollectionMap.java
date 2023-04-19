package ch08_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionMap {

	public static void main(String[] args) {
		// 맵(HashMap)의 선언
		// key와 value의 한쌍인 데이터를 저장
		
		HashMap<String, String> stuMap = new HashMap<>();
		
		// 다형성 이용
		Map<String, Integer> coinMap = new HashMap<>();
		
		// .put(key, value)
		// 데이터 추가
		stuMap.put("첫째", "예슬");
		stuMap.put("둘째", "종현");
		stuMap.put("셋째", "서영");
		
		// 순서는 보장하지않는다. ( set과 같은 특징 )
		System.out.println(stuMap);
		
		// 중복된 key값을 허용하지 않는다.
		// 중복된 key값을 추가하면,, value 를 덮어쓴다
		// key에 대한 value를 수정하는 경우 put을 이용
		stuMap.put("첫째", "경호");
		System.out.println(stuMap); // 중복이 허용되지 않아 덮어씌움
		
		coinMap.put("비트코인", 36000000);
		coinMap.put("도지코인", 123);
		System.out.println(coinMap);
		
		System.out.println("\n=============================\n");
		
		// .get(key)
		// key에 대한 value를 리턴한다
		System.out.println(stuMap.get("첫째"));
		// 존재하지않는 key값을 입력하면
		System.out.println(stuMap.get("넷째")); // null 값 리턴
		
		
		// .size()
		// Map 내 저장된 데이터의 수 리턴
		System.out.println(stuMap.size());
		
		// .containskey(값)
		// Map 안에 있는 키(key) 중에 괄호 안 값이 있다면 true, 없으면 false
		
		System.out.println(stuMap.containsKey("첫째"));
		
		
		// .containsValue(값)
		// Map 안에 있는 값(value) 중에 괄호 안 값이 있으면 true, 없으면 false
		
		System.out.println(stuMap.containsValue("종현"));
		
		// .remove(key)
		// 괄호 안 key값에 대한 데이터를 삭제한다.
		coinMap.remove("도지코인");
		System.out.println(coinMap);
		
		System.out.println("\n=============================\n");
		
		// Map 순회
		// 1. keySet 이용 / set으로 변환
		Set<String> keySet = stuMap.keySet();
		
		// 향상된 for 문으로 set을 순회 
		
		for(String key : keySet) {
			System.out.println(key); // key 값만 출력
			System.out.println(stuMap.get(key));
		}
		
		System.out.println("\n=============================\n");
		
		// 2. EntrySet 이용
		Set< Entry<String, String> > entrySet = stuMap.entrySet();
		
		// 향상된 for 문 사용 가능하다.
		
		for( Entry<String, String> entry : entrySet ) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		System.out.println("\n=============================\n");
		
		// 3. forEach ( 람다식 )
		stuMap.forEach( (key, value) -> System.out.println(key + ":" + value) );
		
		
		
		
		
		//1부터 100까지 랜덤 정수 추출
		ArrayList<Integer> intList = new ArrayList<>();
		
		
		
		for(int i = 0; i < 11; i++) {
			int temp = (int)(Math.random() * 100) + 1;
			intList.add(temp);
		}
		System.out.println(intList);
		
		ArrayList<Integer> intList2 = new ArrayList<>();
		// 중복을 제거하기
		
		for(int i = 0; i < intList.size(); i++) {
			if(!intList2.contains(intList.get(i))) {
				intList2.add(intList.get(i));
			}
		}
		System.out.println(intList2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
