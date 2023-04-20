package ch11_api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ydy.util.YDYUtil;

public class ApiJosn {

	public static void main(String[] args) throws ParseException {
		// 객체지향 프로그래밍 ( oop )
		// 개발 대상, 데이터 등을 객체로 보고
		// 객체로 만들어서 구현
		
		// 학생 이름, 나이, 점수 처럼 객체로 바라보고
		
		// 자바에서는 이를 클래스로 선언
		// public class Student
//			String name;
//			int age;
//			int  score;
		
		// Student stu = new Student("준호", 30, 80);
		
		// 자바 스크립트 - JSON 객체 사용
		// let stu = {name : "준호", age : 30, score : 80};
		// JSON 객체 형식이 서버 통신시 데이터 요청/응답에 많이 사용되는 형태이다.
		
		// 자바단에서 서버 통신으로 데이터가 넘어왔는데
		// JSON 형태인 경우가 있다.
		// "{name : "준호", age : 30, score : 80}" 이런식으로 문자열로 넘어옴
		// 이렇게 오는게 -> JSONString이라고 함
		
		// JSONString 이 넘어올때, 이를 JSONObject로 변환하여
		// 각 key값에 접근할 수 있어야 value 를 꺼내올 수 있다.
		
		// JSONObject를 소환해서 사용하기 위해
		// 외부 라이브러리를 불러 와야 한다.
		// maven repository 사이트에 있음
		
		// .jar 파일을( 라이브러리 파일)
		// 프로젝트 안에서 쓸수 있도록 하기
		// 프로젝트 마우스 우클릭 - build path
		// -configure build path - library 탭
		// - add jars 클릭 = 프로젝트 내 library 폴더를 찾아
		// 해당 .jar 파일을 선택해준다.
		
		// 라이브러리 만들기 어렵지 않다. 대단한게 아님
		
		System.out.println(YDYUtil.weRound(3.2534, 1));
		
		
		// JSON 객체 만들기
		// HashMap<String, Object>과 사용법이 유사
		JSONObject json = new JSONObject();
		
		// 타입이 달라도 들어감 
		json.put("name", "이수");
		json.put("age", 40);
		
		
		// JSONArray 리스트 생성 
		JSONArray songList = new JSONArray();
		songList.add("원러브");
		songList.add("그대가 분다");
		songList.add("마이웨이");
		
		System.out.println(songList);
		
		json.put("노래목록", songList);
		
		System.out.println(json);
		System.out.println(json.toJSONString());
		System.out.println(json.toString());
		
		String jsonStr = json.toJSONString();
		System.out.println(jsonStr);
		
		System.out.println("\n==============================\n");
		
		JSONObject daysix = new JSONObject();
		daysix.put("이름", "데이식스");
		daysix.put("노래", "좀비");
		
		json.put("동료", daysix);
		System.out.println(json);
		
		// 값 꺼내보기
		System.out.println(json.get("name"));
		String name = (String) json.get("name");
		System.out.println(name);
		
		int age = (int) json.get("age");
		System.out.println(age);
		
		// 없는 키값에 대해서는 null을 리턴한다
//		JSONArray temp = (JSONArray) json.get("노");
		JSONArray temp = (JSONArray) json.get("노래목록");
		System.out.println(temp.get(2));
		
		System.out.println("\n==============================\n");
		
		// 서버에서 온 JSONString 데이터를 JSONObject 객체로 바꾼 후 키에 대한 값 꺼내기
		String serverData = "{\"노래목록\":[\"원러브\",\"그대가 분다\",\"마이웨이\"],\"동료\":{\"노래\":\"좀비\",\"이름\":\"데이식스\"},\"name\":\"이수\",\"age\":40}";
		System.out.println(serverData);
		
		// JSONParser 를 이용해서 파싱
		JSONParser parser = new JSONParser();
		
		JSONObject result = (JSONObject) parser.parse(serverData);
		System.out.println(result);
		
		name = (String) result.get("name");
		System.out.println(name);
		
		// 파싱 후 숫자는 long 타입으로 꺼내와야 한다
		long ageL = (long) result.get("age");
		System.out.println(ageL);
		
		// result 로 부터 "좀비"
		
		JSONObject daysix2 = (JSONObject) result.get("동료");
		System.out.println(daysix2);
		System.out.println(daysix2.get("노래"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
