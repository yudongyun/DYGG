package ch02_variable;

public class VariableMain {

	public static void main(String[] args) {
		// 변수의 선언
		// [변수 타입] [변수명] 의 형태
		int myMoney;
		
		// 값을 담지 않은 경우 사용할 수 없다.
		// 주석처리 단축키 [ctrl+/]
//		System.out.println(myMoney);
		
		// 변수에 값 할당
		// 변수 초기화 (Initialization = init) 라고 한다.
		// 등호(=)를 이용하여 변수에 값을 담을 수 있다.
		// 등호 오른쪽의 값을 왼쪽에 담는다
		myMoney = 10000;
		System.out.println(myMoney);
		
		// 변수의 값을 변경할 수 있다.
		// (그니까 변수라고 부르는거임, 값이 변할 수 있는 녀석)
		myMoney = 1000000;
		System.out.println(myMoney);
		
		// 변수의 선언과 함께 값을 할당
		int numne = 1;
		double pi = 3.14;
		
		System.out.println(numne);
		System.out.println(pi);
		
		// 상수의 선언
		// 값이 항상 같은 녀석
		// 값이 바뀌면 안되는 녀석에 대해 상수로 선언해서 사용
		final double MATH_PI = 3.14;
		
		//상수는 값을 바꿀 수 없다.
//		MATH_PI = 4.23;
		
		// 줄 긋기
		System.out.println("\n=============================\n");
		
		// 변수를 사용하는 이유
		
		// 콘솔창에 숫자 10을 10번 출력
		
		int Ydy = 20;
		System.out.println(Ydy);
		System.out.println(Ydy);
		System.out.println(Ydy);
		System.out.println(Ydy);
		System.out.println(Ydy);
		System.out.println(Ydy);
		System.out.println(Ydy);
		System.out.println(Ydy);
		System.out.println(Ydy);
		System.out.println(Ydy);
		
		// 변수 선언을 통해 출력창 수정이 용이하다.
		// 값에 이름을 부여할 수 있다.
		
		int myAge = 31;
		System.out.println(myAge);
		
		System.out.println("\n------------------string 메소드--------------------\n");
		
		// 문자열 String
		// 문자열은 클래스이므로, 다양한 메소드를 내장하고 있다.
		String fruits = "Apple, Banana, Cherry";
		
		// .length()
		// 해당 문자열의 길이를 리턴
		int len = fruits.length();
		System.out.println(len);
		
		// .charAt(인덱스)
		// 인덱스는 배열, 문자열에서 몇 번째에 해당하는 숫자를 의미
		// 인덱스는 0부터 시작 (첫 번째 = 인덱스 0)에 의미
		// 10번째 글자다 = 인덱스 9임
		// 해당 문자열에서 해당 인덱스에 해당하는 
		// 문자(char)를 리턴한다.
		// 문자열을 셀때 쉼표, 띄어쓰기랑 다 포함 한다.
		char alphaL = fruits.charAt(3);
		System.out.println(fruits.charAt(3));
		
		// .indexOf(문자열)
		// 해당 문자열에서 괄호 안에있는 문자열의 인덱스를 리턴함
		System.out.println(fruits.indexOf("Banana"));
		// 대소문자를 구분한다.
		System.out.println(fruits.indexOf("banana"));
		// 존재하지않는 문자일 경우 -1로 출력된다.
		
		System.out.println(fruits.indexOf("p"));
		// 동시에 존재할 경우 처음에 발견된 녀석만 인덱스 리턴
		
		// .substring(시작 인덱스, 끝 인덱스)
		// 해당 문자열을 시작 인덱스부터 끝 인덱스 전까지 자른다.
		System.out.println(fruits.substring(7,13));
		// 자른 값을 리턴, 실제로 해당 문자열을 잘라버리진 않는다.
		System.out.println(fruits);
		// .substring(시작 인덱스)
		// 해당 문자열을 시작 인덱스부터 끝까지 자른다
		System.out.println(fruits.substring(15));
		
		// .replace(바뀔 문자열, 바꾸고 싶은 문자열
		System.out.println(fruits.replace("Cherry","Chamwui"));
		// 원본은 변하지 않는다.
		System.out.println(fruits);
		
		// 원본을 바꾸고 싶다면 ?
		fruits = fruits.replace("Cherry","Chamwui");
		
		System.out.println(fruits);
		
		// .trim()
		// 해당 문자열의 양끝에 존재하는 모든 공백문자를 제거
		String world = "  The New World!!  ";
		System.out.println(world.replace(" ", ""));  // 모든 공백 제거
	
		System.out.println(world.trim()); // 양쪽 끝 공백 제거
		
		// .toUpperCase()
		// .tolowerCase()
		// 해당 문자열에 존재하는 알파벳들을
		// 전부 대문자/소문자로 바꿔준다.
		System.out.println(fruits.toUpperCase());
		System.out.println(fruits.toLowerCase());
		
		// 언제사용하는가 ?
		// 설치하겠습니까 ? [y/n]
		
		// .concat(문자열)
		// 해당 문자열 뒤에 괄호 안에 있는 문자열을 붙인다.
		System.out.println(fruits.concat(", Durian"));
		
		// 문자열은 더하기 기호를 통해서 추가 가능하다.
		System.out.println(fruits + ", Durian");
		
		fruits = fruits + ", Durian";
		System.out.println(fruits);
		
		fruits = "과일 목록: " + fruits;
		System.out.println(fruits);
		
		System.out.println("\n----------------------------------------------------\n");
		
		// String 은 기본타입이 아닌 참조타입이므로
		// null 값을 가질 수 있다.
		// 참조타입의 변수를 객체(instance)라고 부름
		String empty = "";  // 빈 문자열을 empty 라고 부른다.
		System.out.println(empty);
		
		String strNull = null;
		System.out.println(strNull);
		
		System.out.println(empty.concat("채웠음"));
//		System.out.println(strNull.concat("채우기")); // 메소드 조차 존재하지않는다.
		
		
		System.out.println("\n------------------------char----------------------------\n");
		
		// 문자(char)
		// 작은 따옴표('') 안에 한 문자를 담을 수 있으며
		// 숫자 또한 담을 수 있다.
		// 이때의 숫자는 유니코드에 등록된 각 문자에 대한 넘버링임
		
		// A는 유니코드에서 65번째에 위치함
		char wordA = 'A';
		char numA = 65;
		System.out.println(wordA);
		System.out.println(numA);
		
		// 한글 '가'는 유니코드에서 44032번째 위치
		char hangul = 44032;
		System.out.println(hangul);
		
		hangul++;  // 1을 더해라
		System.out.println(hangul);
		
		
		// byte는 -128부터 127까지만 담을 수 있다. (크기)
		byte byteNum = 127;
		byteNum++;
		System.out.println(byteNum);
		
		
		System.out.println("\n------------------------형변환----------------------------\n");
		
	
		// 형 변환(Casting)
		// 형 변환이 가능한 경우에는 형 변환을 이용해서 상황에 맞게 적절히 사용 가능
		
		int intVal = 15;
		double doubVal = 1.23;
		
		System.out.println(intVal * doubVal);
		
		// int 곱하기 double은 double 타입으로 자동으로 형변환이 된다.
		// type이 int 에서 double로 형이 변환 되었음
		double mulResult = intVal * doubVal;
		
		//int 곱하기 float을 해도 float 타입으로 자동 형변환 된다.
		float floatRst = intVal * 1.23f;
		
		// int 20000이 long 타입으로 자동 형변환 되어 담긴것임 / l을 붙히지 않았어도..
		long longVal = 20000;
		
		// 숫자 더하기 문자열 (String)을 하면
		// 숫자가 문자열로 자동 형변환이 되어
		// 문자열 더하기(이어붙이기)가 된다.
		String name = "동윤";
		String age = name + 27;
		System.out.println(age);
		
		// 강제 형변환
		// 형 변환 하고 싶은곳 앞에 (타입)값 작성
		// 형 변환이 가능한 경우에 대해, 해당 값이 괄호 안 타입으로 변환 된다.
		
		int intCast = (int)3.6;
		System.out.println(intCast);
		// 출력 결과 소수점이 다 없어짐 (반올림 개념 x)
		
		// 주의점
		int mulVal = (int)(10 * 3.333);
		System.out.println(mulVal);
		
		// 주의점2
		double result = (double)10 / 3;  // 3.33333이 나와야하는데 3.0이 나온다.
		System.out.println(result);
		
		// 숫자 문자열과 진짜 숫자들간의 형변환도 가능하다.
		String strNum = "1324";
		System.out.println(strNum + 2);
		
		// 문자열을 정수타입으로 형변환을 해야함
		// Integer.parseInt(숫자 문자열) !! << 중요
		int intNum = Integer.parseInt(strNum);
		System.out.println(intNum + 2); // 연산된 결과가 나옴 1324 + 2 = 1326
		
		// 정수타입을 문자열로 형변환
		// Integer.toString(숫자) << 안중요함
		String strCast = intNum + "";
		System.out.println(strCast + 2);
		
		
		
		
		
		
	}

}
